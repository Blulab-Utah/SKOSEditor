package edu.ucsd.nlp.portlet.module;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.ParamUtil;

import edu.ucsd.nlp.bean.TreeBean;
import edu.ucsd.nlp.bean.model.SKOSPropertiesModel;
import edu.ucsd.nlp.bean.model.TreeNodeModel;
import edu.ucsd.nlp.skos.SKOSProject;
import edu.ucsd.nlp.util.SKOSConstants;

public class RelationsModule extends SKOSModule {

	public void process(SKOSProject project, ResourceRequest request, ResourceResponse response) {
		String action = ParamUtil.getString(request, "action", "");
		if (action.equals("load")) {
			long id = ParamUtil.getLong(request, "id", 0);
			TreeBean bean = project.getTreeBean();
			bean.setNode(id);
			processJSP(request, response, "/jsp/relations.jsp", bean);
			
			lock(project, bean.getNode(id).getUri());
		} else if (action.equals("save")) {
			JSONObject json = JSONFactoryUtil.createJSONObject();
			try {
				update(project, request, response);
			} catch (Exception e) {
				json.put("error", e.getMessage());
			}
			writeJSON(request, response, json);
		} else if (action.equals("remove")) {
			int assertionId = ParamUtil.getInteger(request, "assertion-id", -1);
			remove(project, assertionId, true);
		}
	}

	public void update(SKOSProject project, ResourceRequest request, ResourceResponse response) throws Exception {
		TreeNodeModel node = project.getTreeBean().getNode();
		
		long assertionId = ParamUtil.getLong(request, "assertion-id", 0);

		boolean isUpdate = assertionId > 0;
		
		String info = project.getUserName() + (isUpdate ? " updated" : " added");

		String action = "";
		String concept = node.getUri();
    	String value = ParamUtil.getString(request, "concept-uri", "");
    	String assertionType = ParamUtil.getString(request, "assertion-type", "").toLowerCase();
 
    	if (assertionType.equals(SKOSConstants.TYPE_RELATED.toLowerCase())) {
    		if (value.isEmpty()) {
				throw new Exception("Please select a Concept");
			}
    		action = "add-related-assertion";
			info += " related assertion ";
			project.addObjectPropertyRelated(concept, value);
    	} else if (assertionType.equals(SKOSConstants.TYPE_BROADER.toLowerCase())) {
    		if (value.isEmpty()) {
				throw new Exception("Please select a Concept");
			}
    		action = "add-broader-assertion";
			info += " broader assertion ";
			project.addObjectPropertyBroader(concept, value);
    	} else if (assertionType.equals(SKOSConstants.TYPE_NARROWER.toLowerCase())) {
    		if (value.isEmpty()) {
				throw new Exception("Please select a Concept");
			}
    		action = "add-narrower-assertion";
			info += " narrower assertion ";
			project.addObjectPropertyNarrower(concept, value);
    	} else if (assertionType.equals(SKOSConstants.TYPE_INSCHEME.toLowerCase())) {
    		value = ParamUtil.getString(request, "scheme-uri", "");
    		if (value.isEmpty()) {
				throw new Exception("Please select a Scheme");
			}
    		action = "add-inscheme-assertion";
			info += " in-scheme assertion ";
			project.addObjectPropertyInscheme(concept, value);
    	} else if (assertionType.equals(SKOSConstants.TYPE_TOPCONCEPTOF.toLowerCase())) {
    		value = ParamUtil.getString(request, "scheme-uri", "");
    		if (value.isEmpty()) {
				throw new Exception("Please select a Scheme");
			}
    		if (value.equals(concept)) {
				throw new Exception("Recursion detected: please select a different scheme");
			}
    		action = "add-topconceptof-assertion";
			info += " top-concept-of assertion ";
			project.addObjectPropertyTopConceptOf(concept, value);
    	} else {
    		if (value.isEmpty()) {
				throw new Exception("Please select a Concept");
			}
    		String assertionType2 = ParamUtil.getString(request, "assertion-type-2", "");
    		if (assertionType2.isEmpty()) {
				throw new Exception("Please select a Type");
			}
    		action = "add-other-assertion";
			info += " other assertion ";
			project.addObjectPropertyOther(concept, assertionType2, value);
    	}
    	
    	info += "<span class='history-assertion'>" + treeBean.findNodeByUri(value).getTitle() + "</span>" + (isUpdate ? " in " : " to ") 
    			+ "Concept <span class='history-concept'>" + node.getTitle() + "</span>";

    	if (isUpdate) {
			remove(project, assertionId, false);
		} else {
			node.initialize();
		}
    	
    	project.processFileChange(action, concept, value, "", "", "", info, true);
    }
	
	public void remove(SKOSProject project, long assertionId, boolean addToHistory) {
		TreeNodeModel node = project.getTreeBean().getNode();
		SKOSPropertiesModel model = node.getAssertionById(assertionId);
		String objectStr = model.getObjectURI();
		String subjectStr = model.getSubjectURI();
		String type = model.getPropertyURI();
		String info = project.getUserName() + " removed assertion <span class='history-assertion'>" + treeBean.findNodeByUri(objectStr).getTitle() 
				+ "</span> from concept <span class='history-concept'>" + treeBean.findNodeByUri(subjectStr).getTitle() + "</span>";			
		project.processFileChange("remove-assertion", subjectStr, objectStr, type, "", "", info, addToHistory);

		project.removeAssertion(assertionId);

		node.initialize();
	}
}