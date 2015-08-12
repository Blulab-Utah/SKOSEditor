package edu.ucsd.nlp.portlet.module;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.semanticweb.skos.SKOSEntity;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.ParamUtil;

import edu.ucsd.nlp.skos.SKOSProject;

public class TreeModule extends SKOSModule {

	public void process(SKOSProject project, ResourceRequest request, ResourceResponse response) {
		String action = ParamUtil.getString(request, "action", "");
		if (action.equals("save")) {
			JSONObject json = JSONFactoryUtil.createJSONObject();
			try {
				update(project, request, response);
			} catch (Exception e) {
				json.put("error", e.getMessage());
			}
			writeJSON(request, response, json);
		}
	}

	public void update(SKOSProject project, ResourceRequest request, ResourceResponse response) throws Exception {
		String action = ParamUtil.getString(request, "action-type", "");

		String schemeURI = ParamUtil.getString(request, "scheme-uri", "");
		String conceptName = ParamUtil.getString(request, "concept-name", "");
		String schemeName = ParamUtil.getString(request, "scheme-name", "");
		String parentConceptURI = ParamUtil.getString(request, "parent-concept-uri", "");
		String conceptURI = ParamUtil.getString(request, "concept-uri", "");
		String newParentConceptURI = ParamUtil.getString(request, "new-parent-concept-uri", "");

		if (action.equals("add-top-concept")) {
			if (conceptName.isEmpty()) {
				throw new Exception("Please enter a concept name");
			}
			conceptName = conceptName.replaceAll(" ", "_");
			project.addTopConcept(conceptName, false);
		} else if (action.equals("rename-scheme")) {
			if (schemeName.isEmpty()) {
				throw new Exception("Please enter a new name");
			}
			schemeName = schemeName.replaceAll(" ", "_");
			project.renameScheme(schemeName, false);
		} else if (action.equals("add-concept")) {
			if (conceptName.isEmpty()) {
				throw new Exception("Please enter a new name");
			}
			conceptName = conceptName.replaceAll(" ", "_");
			project.addConcept(conceptName, parentConceptURI, false);
		} else if (action.equals("rename-concept")) {
			if (conceptName.isEmpty()) {
				throw new Exception("Please enter a new name");
			}
			conceptName = conceptName.replaceAll(" ", "_");
			project.renameConcept(conceptURI, conceptName, false);
		} else if (action.equals("move-concept-to-top")) {
			project.moveToTopConcept(conceptURI, parentConceptURI, schemeURI, false);
		} else if (action.equals("move-concept")) {
			if (newParentConceptURI.isEmpty()) {
				throw new Exception("Please select a new parent concept");
			}
			if (isTopConcept(project, conceptURI)) {
				project.moveFromTopConcept(conceptURI, newParentConceptURI, schemeURI, false);
			} else {
				project.moveConcept(conceptURI, parentConceptURI, newParentConceptURI, false);
			}
		} else if (action.equals("remove-concept")) {
			project.removeConcept(conceptURI, false);
		}
    }

	private boolean isTopConcept(SKOSProject project, String conceptURI) {
		for (SKOSEntity obj : project.getTopLevelConcepts(project.getTopConceptURI())) {
			if (obj.getURI().toString().equals(conceptURI)) {
				return true;
			}
		}
		return false;
	}
}