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

public class LabelsModule extends SKOSModule {
	
	public void process(SKOSProject project, ResourceRequest request, ResourceResponse response) {
		String action = ParamUtil.getString(request, "action", "");
		if (action.equals("load")) {
			long id = ParamUtil.getLong(request, "id", 0);
			TreeBean bean = project.getTreeBean();
			bean.setNode(id);
			processJSP(request, response, "/jsp/linguistics.jsp", bean);
		} else if (action.equals("save")) {
			JSONObject json = JSONFactoryUtil.createJSONObject();
			try {
				update(project, request, response);
			} catch (Exception e) {
				json.put("error", e.getMessage());
			}
			writeJSON(request, response, json);
		} else if (action.equals("remove")) {
			long labelId = ParamUtil.getLong(request, "label-id", 0);
			remove(project, labelId, true);
		}
	}

	public void update(SKOSProject project, ResourceRequest request, ResourceResponse response) throws Exception {
		TreeNodeModel node = project.getTreeBean().getNode();
		
		long labelId = ParamUtil.getLong(request, "label-id", 0);
		
		boolean isUpdate = labelId > 0;
		
		String info = project.getUserName() + (isUpdate ? " updated" : " added");

		String action = "";
		String concept = node.getUri();
		String category = ParamUtil.getString(request, "label-category", "");
		String value = ParamUtil.getString(request, "label-value", "");
		String type = ParamUtil.getString(request, "label-type", "");
		String type2 = ParamUtil.getString(request, "label-type-2", "");
		String language = ParamUtil.getString(request, "label-language", "");

		if (value.isEmpty()) {
			throw new Exception("Please enter a Value");
		}

		if (category.equals(SKOSConstants.TYPE_PREFLABEL)) {
			action = "add-preferred-label";
			info += " preferred label ";
			project.addDataPropertyPreferredLabel(concept, value, language, type);
		} else if (category.equals(SKOSConstants.TYPE_NOTATION)) {
			action = "add-notation-label";
			info += " notation ";
			project.addDataPropertyNotation(concept, value, language, type);
		} else if (category.equals(SKOSConstants.TYPE_ALTLABEL)) {
			action = "add-altlabel-label";
			info += " alternate label ";
			project.addDataPropertyAlternateLabel(concept, value, language, type);
		} else if (category.equals(SKOSConstants.TYPE_HIDDENLABEL)) {
			action = "add-hidden-label";
			info += " hidden label ";
			project.addDataPropertyHiddenLabel(concept, value, language, type);
		} else {
			action = "add-other-label";
			info += " other label ";
			if (type2.isEmpty()) {
				throw new Exception("Please select a Property Type");
			}
			project.addDataPropertyOtherDataProperty(concept, type2, value, language, type);
		}
		info += "<span class='history-label'>" + value + "</span>" + (isUpdate ? " in " : " to ") 
			+ "Concept <span class='history-concept'>" + node.getTitle() + "</span>";

		if (isUpdate) {
			remove(project, labelId, false);
		} else {
			node.initialize();
		}

		project.processFileChange(action, concept, value, type, type2, language, info, true);
    }
	
	public void remove(SKOSProject project, long labelId, boolean addToHistory) {
		TreeNodeModel node = project.getTreeBean().getNode();
		SKOSPropertiesModel model = node.getLabelById(labelId);
		String objectStr = model.getObjectURI();
		String subjectStr = model.getSubjectURI();
		String type = model.getPropertyURI();
		String lang = model.getLang();
		String info = project.getUserName() + " removed label <span class='history-label'>" + objectStr 
				+ "</span> from concept <span class='history-concept'>" + treeBean.findNodeByUri(subjectStr).getTitle() + "</span>";			
		project.processFileChange("remove-label", subjectStr, objectStr, type, "", lang, info, addToHistory);

		project.removeLabel(labelId);

		node.initialize();
	}
}