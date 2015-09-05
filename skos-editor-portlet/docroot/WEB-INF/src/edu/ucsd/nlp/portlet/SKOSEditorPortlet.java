package edu.ucsd.nlp.portlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.ProcessAction;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.ResourceURL;

import org.semanticweb.skos.SKOSCreationException;

import com.liferay.portal.GroupFriendlyURLException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.LiferayPortlet;
import com.liferay.portal.kernel.servlet.HttpHeaders;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.service.CompanyLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;

import edu.ucsd.nlp.bean.FilesBean;
import edu.ucsd.nlp.bean.HistoryBean;
import edu.ucsd.nlp.bean.SettingsBean;
import edu.ucsd.nlp.bean.TreeBean;
import edu.ucsd.nlp.model.SKOSCollaborationEntry;
import edu.ucsd.nlp.model.SKOSFile;
import edu.ucsd.nlp.portlet.action.WizardAction;
import edu.ucsd.nlp.portlet.module.CollaborationModule;
import edu.ucsd.nlp.portlet.module.HistoryModule;
import edu.ucsd.nlp.portlet.module.LabelsModule;
import edu.ucsd.nlp.portlet.module.RelationsModule;
import edu.ucsd.nlp.portlet.module.ShareModule;
import edu.ucsd.nlp.portlet.module.TreeModule;
import edu.ucsd.nlp.service.SKOSCollaborationEntryLocalServiceUtil;
import edu.ucsd.nlp.service.SKOSFileLocalServiceUtil;
import edu.ucsd.nlp.service.SKOSSettingLocalServiceUtil;
import edu.ucsd.nlp.service.SharedFileLocalServiceUtil;
import edu.ucsd.nlp.skos.SKOSOntology;
import edu.ucsd.nlp.skos.SKOSProject;
import edu.ucsd.nlp.util.Util;

public class SKOSEditorPortlet extends LiferayPortlet {

	private static final Log log = LogFactoryUtil.getLog(SKOSEditorPortlet.class);
	
	private static final Pattern EMAIL_PATTERN = Pattern.compile("^[_a-zA-Z0-9-]+(\\.[_a-zA-Z0-9-]+)*@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*\\.(([0-9]{1,3})|([a-zA-Z]{2,3})|(aero|coop|info|museum|name))$");

	protected static String SKOS_HOME = null;
	
	protected String viewJSP = null;
	protected String errorJSP = null;
	
	private WizardAction wizardAction = null;

	private ShareModule shareModule = new ShareModule();
	private RelationsModule relationsModule = new RelationsModule();
	private LabelsModule labelsModule = new LabelsModule();
	private HistoryModule historyModule = new HistoryModule();
	private TreeModule treeModule = new TreeModule();
	private CollaborationModule collaborationModule = new CollaborationModule();

    public void init() {
    	viewJSP = getInitParameter("view-jsp");
    	errorJSP = getInitParameter("error-jsp");
    	wizardAction = new WizardAction();

    	SKOS_HOME = (new File(getPortletContext().getRealPath("")).getParentFile().getParentFile().getParentFile()).getAbsolutePath() + java.io.File.separator + "skos";
		new File(SKOS_HOME).mkdirs();
    }

	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
//		userId = themeDisplay.getUserId();
		getPortletContext().getRequestDispatcher(themeDisplay.isSignedIn() ? viewJSP : errorJSP).include(renderRequest, renderResponse);
//		getSKOSProject(userId) = null;
//		PROJECTS = new HashMap<Long, SKOSProject>();
		renderRequest.getPortletSession().removeAttribute("treeBean");
		renderRequest.getPortletSession().removeAttribute("skosProject");
	}
	
	private long getUserId(ResourceRequest request) {
		return ((ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY)).getUserId();
	}
	
	private long getUserId(ActionRequest request) {
		return ((ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY)).getUserId();
	}

	private String getHome() {
		return SKOS_HOME;
	}
	
	private void addSKOSProject(ResourceRequest request, SKOSProject project) {
		request.getPortletSession().setAttribute("skosProject", project);
	}
	
	private void addSKOSProject(ActionRequest request, SKOSProject project) {
		request.getPortletSession().setAttribute("skosProject", project);
	}
	
	private SKOSProject getSKOSProject(ResourceRequest request) {
		return (SKOSProject) request.getPortletSession().getAttribute("skosProject");
	}
	
	private SKOSProject getSKOSProject(ActionRequest request) {
		return (SKOSProject) request.getPortletSession().getAttribute("skosProject");
	}

    private void processJSP(ResourceRequest request, ResourceResponse response, String path, Object bean) throws PortletException, IOException {
    	if (bean != null) {
			request.setAttribute("bean", bean);
		}
    	request.getPortletSession().getPortletContext().getRequestDispatcher(path).include(request, response);
    }

    public void serveResource(ResourceRequest request, ResourceResponse response) throws IOException, PortletException {
    	long userId = getUserId(request);
    	SKOSProject project = getSKOSProject(request);

    	ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
    	if (!themeDisplay.isSignedIn()) {
    		JSONObject json = JSONFactoryUtil.createJSONObject();
			try {
				json.put("message", "Session expired. Please re-login.");
			} catch (Exception e) {
				json.put("error", e.getMessage());
			}
			writeJSON(request, response, json);
    		return;
    	}
    	String module = ParamUtil.getString(request, "module", "");
		if (module.equals("share")) {
			shareModule.process(request, response);
		} else if (module.equals("relations")) {
			relationsModule.process(project, request, response);
		} else if (module.equals("labels")) {
			labelsModule.process(project, request, response);
		} else if (module.equals("history")) {
			historyModule.process(project, request, response);
		} else if (module.equals("tree")) {
			treeModule.process(project, request, response);
		} else {
			String action = ParamUtil.getString(request, "action", "");
			if (action.equals("register")) {
				JSONObject json = JSONFactoryUtil.createJSONObject();
				try {
					register(request);
					json.put("message", "Registration successfull!");
				} catch (Exception e) {
					json.put("error", e.getMessage());
				}
				writeJSON(request, response, json);
			} else if (action.equals("load-history")) {
				long skosFileId = project != null ? project.getSkosFileId() : -1;
				List<SKOSCollaborationEntry> collaboration = new ArrayList<SKOSCollaborationEntry>();
				if (skosFileId > 0) {
					collaboration.addAll(SKOSCollaborationEntryLocalServiceUtil.findByFileUser(skosFileId, userId));
					for (SKOSCollaborationEntry obj : collaboration) {
						collaborationModule.processEntry(project, obj);
					}
				}
				HistoryBean bean = new HistoryBean(skosFileId, collaboration, userId);
				processJSP(request, response, "/jsp/history.jsp", bean);
			} else if (action.equals("load-library")) {
				FilesBean bean = new FilesBean(userId);
				processJSP(request, response, "/jsp/library.jsp", bean);
			} else if (action.equals("load-settings")) {
				SettingsBean bean = new SettingsBean(project);
				processJSP(request, response, "/jsp/settings.jsp", bean);
			} else if (action.equals("save-settings")) {
				try {
					String showConceptTitleAs = ParamUtil.getString(request, "showConceptTitleAs", "");
					String showConceptTitleLanguageAs = ParamUtil.getString(request, "showConceptTitleLanguageAs", "");
					project.setShowConceptTitleAs(showConceptTitleAs);
					project.setShowConceptTitleLanguageAs(showConceptTitleLanguageAs);
					SKOSSettingLocalServiceUtil.updateByUserName(userId, "show-concept-title-as", showConceptTitleAs);
					SKOSSettingLocalServiceUtil.updateByUserName(userId, "show-concept-title-language-as", showConceptTitleLanguageAs);
				} catch (Exception e) {
					log.error(e);
				}
			} else if (action.equals("load-tree")) {
				long _DEBUG_START = System.currentTimeMillis();
				TreeBean bean = new TreeBean(project);
				log.info("Tree constructed in " + (System.currentTimeMillis() - _DEBUG_START) / 1000 + " seconds");
				request.setAttribute("treeBean", bean);
				request.getPortletSession().setAttribute("treeBean", bean);
				request.getPortletSession().getPortletContext().getRequestDispatcher("/jsp/tree.jsp").include(request, response);
			} else if (action.equals("load-tree-node")) {
				TreeBean bean = (TreeBean) request.getPortletSession().getAttribute("treeBean");
				request.setAttribute("treeBean", bean);
				request.setAttribute("id", ParamUtil.getLong(request, "id", 0));
				request.getPortletSession().setAttribute("treeBean", bean);
				request.getPortletSession().getPortletContext().getRequestDispatcher("/jsp/tree-node.jsp").include(request, response);
			} else if (action.equals("load-tree-node-children")) {
				TreeBean bean = (TreeBean) request.getPortletSession().getAttribute("treeBean");
				request.setAttribute("treeBean", bean);
				request.setAttribute("id", ParamUtil.getLong(request, "id", 0));
				request.getPortletSession().setAttribute("treeBean", bean);
				request.getPortletSession().getPortletContext().getRequestDispatcher("/jsp/tree-node-children.jsp").include(request, response);
			} else if (action.equals("load-dropdowns")) {
				TreeBean bean = (TreeBean) request.getPortletSession().getAttribute("treeBean");
				request.setAttribute("treeBean", bean);
				request.getPortletSession().setAttribute("treeBean", bean);
				request.getPortletSession().getPortletContext().getRequestDispatcher("/jsp/dropdowns.jsp").include(request, response);
			} else if (action.equals("save-wizard")) {
				JSONObject json = JSONFactoryUtil.createJSONObject();
				try {
					wizardAction.saveWizard(project, request);
				} catch (Exception e) {
					json.put("error", e.getMessage());
				}
				writeJSON(request, response, json);
			} else if (action.equals("auto-save")) {
				try {
					long skosFileId = project.getSkosFileId();
					if (skosFileId > 0) {
						long _DEBUG_START = System.currentTimeMillis();
						SKOSFile obj = SKOSFileLocalServiceUtil.getSKOSFile(skosFileId);
						String contents = getFileAsString(request, obj.getName());
						obj.setContents(contents);
						obj.setModified(Calendar.getInstance().getTime());
						SKOSFileLocalServiceUtil.updateSKOSFile(obj);
						log.info("Auto-saved in " + (System.currentTimeMillis() - _DEBUG_START) / 1000 + " seconds");
					}
				} catch (Exception e) {
					log.error(e);
				}
			} else {
				String resourceID = request.getResourceID();
				if (resourceID != null) {
					if (resourceID.equals("save-as-rdfxml")) {
						saveAsRDFXML(request, response);
					} else if (resourceID.equals("upload-skos-file")) {
						uploadSKOSFile(request, response);
					} else if (resourceID.equals("serve-file")) {
						serveSKOSFile(request, response);
					}
				}
			}
		}
    }
    
    private User register(ResourceRequest request) throws Exception {
		String firstName = ParamUtil.getString(request, "first-name", "");
		if (firstName.isEmpty()) {
			throw new Exception("Please enter your first name");
		}
		String lastName = ParamUtil.getString(request, "last-name", "");
		if (lastName.isEmpty()) {
			throw new Exception("Please enter your last name");
		}
		String email = ParamUtil.getString(request, "email", "");
		if (email.isEmpty()) {
			throw new Exception("Please enter an email address");
		} else if (!EMAIL_PATTERN.matcher(email).matches()) {
			throw new Exception("Incorrect email address");
		}
		String password = ParamUtil.getString(request, "password", "");
		if (password.isEmpty()) {
			throw new Exception("Please enter a password");
		}
		String password2 = ParamUtil.getString(request, "password-2", "");
		if (password2.isEmpty()) {
			throw new Exception("Please enter a password confirmation");
		} else if (!password2.equals(password)) {
			throw new Exception("Password confirmation is wrong");
		}

		long companyId = CompanyLocalServiceUtil.getCompanyByWebId("liferay.com").getCompanyId();
		User user = null;
		try {
			user = UserLocalServiceUtil.getUserByEmailAddress(companyId, email);
		} catch (Exception e) {
		}
		if (user != null) {
			throw new Exception("Email address is already in use");
		}

		long creatorUserId = UserLocalServiceUtil.getDefaultUserId(companyId);
		boolean autoPassword = false;
		boolean autoScreenName = true;
		String screenName = "";
		long facebookId = 0;
		String openId = "";
		Locale locale = Locale.ENGLISH;
		String middleName = "";
		int prefixId = -1;
		int suffixId = -1;
		boolean male = true;
		int birthdayMonth = 1;
		int birthdayDay = 1; 
		int birthdayYear = 1981;
		String jobTitle = "";
		long[] groupIds = new long[0];			
		long[] organizationIds = new long[0]; 
		long[] roleIds = new long[0];
		long[] userGroupIds = new long[0];
		boolean sendEmail = false;
		ServiceContext serviceContext = null;
		try {
			user = UserLocalServiceUtil.addUser(creatorUserId, companyId,
					autoPassword, password, password, autoScreenName, screenName,
					email, facebookId, openId, locale, firstName,
					middleName, lastName, prefixId, suffixId, male, birthdayMonth,
					birthdayDay, birthdayYear, jobTitle, groupIds, organizationIds,
					roleIds, userGroupIds, sendEmail, serviceContext);
		} catch (Exception e) {
			if (e instanceof GroupFriendlyURLException) {
				throw new Exception("Please use a different email address");
			} else {
				throw new Exception(e);
			}
		}
		user.setAgreedToTermsOfUse(true);
		user.setReminderQueryQuestion("question");
		user.setReminderQueryAnswer(password);
		user = UserLocalServiceUtil.updateUser(user);

		return user;
	}

    @ProcessAction(name="createNewKB")
    public void createNewKB (ActionRequest request, ActionResponse response) throws IOException, PortletException {
    	JSONObject json = JSONFactoryUtil.createJSONObject();
    	try {
	    	String baseURI = ParamUtil.getString(request, "baseURI", "").trim();
			if (baseURI.isEmpty()) {
				throw new Exception("base-uri;Please enter knowledge base URI address");
			}
			baseURI = baseURI.endsWith("#") ? baseURI.substring(0, baseURI.length() - 1) : baseURI;

	    	String kbName = ParamUtil.getString(request, "kbName", "").trim().replace(' ', '_');
	    	if (kbName.isEmpty()) {
				throw new Exception("kb-name;Please enter knowledge base Name");
			}

	    	String directory = getHome();
			String filePath = directory + File.separator + kbName + ".xml";
			filePath = filePath.replace("\\", "/"); // platform-independent

	    	SKOSOntology ontology = new SKOSOntology(URI.create(baseURI), kbName, filePath);
	    	ontology.setAudience(request.getParameter("audience").trim());
	    	ontology.setCreated(request.getParameter("created").trim());
	    	ontology.setCreator(request.getParameter("creator").trim());
	    	ontology.setDescription(request.getParameter("description").trim());
	    	ontology.setLanguage(request.getParameter("language").trim());
	    	ontology.setSubject(request.getParameter("subject").trim());
	    	ontology.setTitle(request.getParameter("title").trim());
	    	ontology.setVersion(request.getParameter("version").trim());

	    	addSKOSProject(request, new SKOSProject(ontology));
    	} catch (Exception e) {
    		json.put("error", e.getMessage());
    	}

    	writeJSON(request, response, json);
    }
    
    @ProcessAction(name="uploadFromURL")
	public void uploadFromURL(ActionRequest request, ActionResponse response) throws IOException, PortletException {
    	JSONObject json = JSONFactoryUtil.createJSONObject();
    	try {
    		String url = ParamUtil.getString(request, "url", "").trim();
    		if (url.isEmpty()) {
				throw new Exception("Please enter a valid URL address");
			}

			String directory = getHome();		
			String filename = url.substring(url.lastIndexOf('/') + 1, url.length());		
			String filePath = directory + File.separator + filename;
			Util.WriteFileFromURL(url, filePath);
			
			File file = new File(filePath.replace("\\", "/")); // platform-independent
			try {
				long userId = getUserId(request);
				addSKOSProject(request, new SKOSProject(userId, -1, file));
//				json = getSKOSConceptTree();
			} catch (SKOSCreationException e) {
				throw new Exception(e.getMessage());
			}
		} catch (Exception e) {
			json.put("error", "upload-url;" + e.getMessage());
		}
    	writeJSON(request, response, json);
    }
    
    @ProcessAction(name="uploadSKOSFile")
    public void uploadSKOSFile(ActionRequest request, ActionResponse response) throws IOException, PortletException {
    	JSONObject json = JSONFactoryUtil.createJSONObject();    	
    	try {
	    	String directory = getHome();
	    	UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(request);	
			String fileName = uploadRequest.getFileName("skosFile");//uploaded filename
			File file = uploadRequest.getFile("skosFile"); //uploaded file you can see it in /tomcat/temp	
			String filePath = directory + "/" + fileName;
			File newFile = new File(filePath);
			newFile.delete(); // delete old file, if exists
			if (file.renameTo(new File(filePath))) {
				//_log.info("File is moved successful!");
			} else {
				throw new Exception("File is failed to move");
			}
			
			long userId = getUserId(request);
			addSKOSProject(request, new SKOSProject(userId, -1, newFile));
    	} catch (Exception e) {
			json.put("error", "upload-skos-file;" + e.getMessage());
		}
		writeJSON(request, response, json);
    }
    
	private void saveAsRDFXML(ResourceRequest request, ResourceResponse response) throws IOException{
		JSONObject json = JSONFactoryUtil.createJSONObject();
		try {
			String filename = ParamUtil.getString(request, "userFilename");

	    	String directory = getHome();
	    	String filePath = directory + File.separator + filename;
	    	
	    	getSKOSProject(request).saveAsRDFXML(filePath);
			
			File folder = new File(directory);
			File[] listOfFiles = folder.listFiles();
			String files;
			String url = "";
			for (int i = 0; i < listOfFiles.length; i++) {
				if (listOfFiles[i].isFile()) {
					files = listOfFiles[i].getName();
					if (files.equals(filename)) {
						ResourceURL resUrl = response.createResourceURL();
						resUrl.setResourceID("serve-file");
						resUrl.setParameter("filename", files);
						url = resUrl.toString();
						break;
					}
				}
			}

			json.put("downloadUrl", url);
			json.put("filename", filename);
		} catch (Exception e) {
    		json.put("error", e.getMessage());
    	}
		writeJSON(request, response, json);
	}
	
	private void uploadSKOSFile(ResourceRequest request, ResourceResponse response) throws IOException{
    	JSONObject json = JSONFactoryUtil.createJSONObject();    	
    	
    	String directory = getHome();
    	UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(request);	
    	
		String fileName = uploadRequest.getFileName("skosFile");//uploaded filename
		File file = uploadRequest.getFile("skosFile"); //uploaded file you can see it in /tomcat/temp 

		String filePath = directory + File.separator + fileName;
		if (!file.renameTo(new File(filePath))) {
			json.put("error", "Failed to move uploaded file.");
		}

		try {
			long userId = getUserId(request);
			addSKOSProject(request, new SKOSProject(userId, -1, file));
		} catch (Exception e) {
			json.put("error", e.getMessage());
			log.error(e);
		}

		writeJSON(request, response, json);
    }
    
	private void serveSKOSFile(ResourceRequest request, ResourceResponse response) throws IOException{
		String filename = ParamUtil.getString(request, "filename");
    	String directory = getHome();
    	String filePath = directory + File.separator + filename;
		response.setContentType("application/octet-stream");
		response.addProperty(HttpHeaders.CACHE_CONTROL, "max-age=3600, must-revalidate");
		response.addProperty(HttpHeaders.CONTENT_DISPOSITION, "Content-Disposition:attachment;filename=" + filename);
		OutputStream out = response.getPortletOutputStream();
		File file = new File(filePath);
		InputStream is = new FileInputStream(file);
		byte[] buffer = new byte[4096];
		int len;
		while ((len = is.read(buffer)) != -1) {
			out.write(buffer, 0, len);
		}
		out.flush();
		is.close();
		out.close();	
	}

	@ProcessAction(name="updateLibrary")
    public void updateLibrary(ActionRequest request, ActionResponse response) throws IOException, PortletException {
		long userId = getUserId(request);
		JSONObject json = JSONFactoryUtil.createJSONObject();
		try {
			String action = ParamUtil.getString(request, "action", "");
			if (action.equals("load") || action.equals("reload")) {
				long _DEBUG_START = System.currentTimeMillis();
				File temp = null;
				FileOutputStream out = null;
				try {
					long skosFileId = ParamUtil.getLong(request, "id", -1);
					SKOSFile skosFile = SKOSFileLocalServiceUtil.getSKOSFile(skosFileId);
					temp = File.createTempFile("skos_temp_" + System.currentTimeMillis(), ".tmp");
					out = new FileOutputStream(temp);
					out.write(skosFile.getContents().getBytes());
					out.flush();
					
					// check access
					int access = -1;
					try {
						access = (skosFile.getUserId() == userId) ? 2 : SharedFileLocalServiceUtil.findByFileSharedWith(skosFileId, userId).getAccess();
					} catch (Exception e) {
						log.error(e);
						throw new Exception("Internal server error");
					}
					if (access < 0) {
						throw new Exception("Internal server error");
					}
					
					addSKOSProject(request, new SKOSProject(userId, skosFileId, temp));
					getSKOSProject(request).setAccess(access);

					if (action.equals("reload")) {
						TreeBean bean = new TreeBean(getSKOSProject(request));
						log.info("Reloaded in " + (System.currentTimeMillis() - _DEBUG_START) / 1000 + " seconds");
						request.setAttribute("treeBean", bean);
						request.getPortletSession().setAttribute("treeBean", bean);
					} else {
						json.put("skosFileId", "" + skosFile.getSkosFileId());
						json.put("skosFileVersion", "" + skosFile.getVersion());
						json.put("skosFileName", "" + skosFile.getName());
					}
					json.put("access", "" + access);
				} catch (Exception e) {
					json.put("error", e.getMessage());
				} finally {
					if (out != null) {
						try {
							out.close();
						} catch (Exception e) {
							log.error(e);
						}
					}
					if (temp != null) {
						temp.delete();
					}
				}
			} else if (action.equals("add")) {
				String fileName = ParamUtil.getString(request, "fileName", "");
		        String contents = getFileAsString(request, fileName);
				SKOSFile file = SKOSFileLocalServiceUtil.create(userId, 0, fileName, contents);
				json.put("message", "File created successfully");
				json.put("skosFileId", "" + file.getSkosFileId());
				json.put("skosFileVersion", "" + file.getVersion());
				json.put("skosFileName", "" + file.getName());
			} else if (action.equals("update")) {
				long skosFileId = ParamUtil.getLong(request, "id", -1);
				String fileName = SKOSFileLocalServiceUtil.getSKOSFile(skosFileId).getName();
				String contents = getFileAsString(request, fileName);
				SKOSFile file = SKOSFileLocalServiceUtil.update(skosFileId, userId, contents);
				json.put("message", "Version saved successfully");
				json.put("skosFileId", "" + file.getSkosFileId());
				json.put("skosFileVersion", "" + file.getVersion());
				json.put("skosFileName", "" + file.getName());
			} else if (action.equals("save-before-download")) {
				long skosFileId = ParamUtil.getLong(request, "id", -1);
				String fileName = SKOSFileLocalServiceUtil.getSKOSFile(skosFileId).getName();
				String contents = getFileAsString(request, fileName);
				SKOSFile file = SKOSFileLocalServiceUtil.getSKOSFile(skosFileId);
				file.setContents(contents);
				file = SKOSFileLocalServiceUtil.updateSKOSFile(file);
			} else if (action.equals("delete")) {
				long skosFileId = ParamUtil.getLong(request, "id", -1);
				SKOSFileLocalServiceUtil.deleteSKOSFile(skosFileId);
				json.put("message", "File removed successfully");
			}
		} catch (Exception e) {
    		json.put("error", e.getMessage());
    	}
		writeJSON(request, response, json);
    }

	private String getFileAsString(ResourceRequest request, String fileName) {
		String contents = "";
		File temp = null;
		try {
			temp = new File(getHome() + "/" + fileName + ".rdf");
			temp.createNewFile();
			String filePath = temp.getAbsolutePath();
			getSKOSProject(request).saveAsRDFXML(temp.toURI());
			byte[] encoded = Files.readAllBytes(Paths.get(filePath));
			contents = new String(encoded, StandardCharsets.UTF_8);
		} catch (Exception e) {
    		log.error(e);
    	} finally {
    		temp.delete();
    	}
		return contents;
	}	
	
	private String getFileAsString(ActionRequest request, String fileName) {
		String contents = "";
		File temp = null;
		try {
			temp = new File(getHome() + "/" + fileName + ".rdf");
			temp.createNewFile();
			String filePath = temp.getAbsolutePath();
			getSKOSProject(request).saveAsRDFXML(temp.toURI());
			byte[] encoded = Files.readAllBytes(Paths.get(filePath));
			contents = new String(encoded, StandardCharsets.UTF_8);
		} catch (Exception e) {
    		log.error(e);
    	} finally {
    		temp.delete();
    	}
		return contents;
	}
}