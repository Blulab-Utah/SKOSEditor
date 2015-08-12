package edu.ucsd.nlp.portlet.module;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletResponse;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.ServletResponseUtil;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.util.PortalUtil;

import edu.ucsd.nlp.bean.TreeBean;
import edu.ucsd.nlp.service.ObjectHistoryLocalServiceUtil;
import edu.ucsd.nlp.skos.SKOSProject;

public class SKOSModule {

	private static final Log log = LogFactoryUtil.getLog(SKOSModule.class);
	
	protected TreeBean treeBean = null;
	
	protected void processJSP(ResourceRequest request, ResourceResponse response, String path, Object bean) {
		try {
			treeBean = (TreeBean) request.getPortletSession().getAttribute("treeBean");

			if (bean != null) {
				request.setAttribute("bean", bean);
			}
	    	request.getPortletSession().getPortletContext().getRequestDispatcher(path).include(request, response);
		} catch (Exception e) {
			log.error(e);
		}
    }
	
	protected void writeJSON(ResourceRequest portletRequest, ResourceResponse actionResponse, Object json) {
		try {
			HttpServletResponse response = PortalUtil.getHttpServletResponse(actionResponse);
			response.setContentType(ContentTypes.APPLICATION_JSON);
			ServletResponseUtil.write(response, json.toString());
			response.flushBuffer();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	protected TreeBean getTreeBean() {
		return treeBean;
	}
	
	protected void lock(SKOSProject project, String conceptURI) {
		long skosFileId = project.getSkosFileId();
		long userId = project.getUserId();
		if (skosFileId > 0) {
			ObjectHistoryLocalServiceUtil.createLock(skosFileId, userId, conceptURI);
		}
	}
}