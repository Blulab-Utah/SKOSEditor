package edu.ucsd.nlp.portlet.module;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.service.UserLocalServiceUtil;

import edu.ucsd.nlp.bean.model.TreeNodeModel;
import edu.ucsd.nlp.model.SKOSCollaborationEntry;
import edu.ucsd.nlp.service.SKOSCollaborationEntryLocalServiceUtil;
import edu.ucsd.nlp.skos.SKOSProject;

public class CollaborationModule extends SKOSModule {

	private static final Log log = LogFactoryUtil.getLog(CollaborationModule.class);

	public void processEntry(SKOSProject project, SKOSCollaborationEntry obj) {
		try {
			log.info("Performing [" + obj.getUpdateType() + "] for [" + UserLocalServiceUtil.getUser(obj.getUserId()).getEmailAddress() + "]");

			String schemeStr = obj.getSchemeURI();
			String conceptStr = obj.getConceptURI();
			String value = obj.getValue();
			String lang = obj.getLang();
			String type = obj.getType();
			String type2 = obj.getType2();
			
			log.info("schemeStr=" + schemeStr);
			log.info("conceptStr=" + conceptStr);
			log.info("value=" + value);
			log.info("lang=" + lang);
			log.info("type=" + type);
			log.info("type2=" + type2);
			
			TreeNodeModel node = project.getTreeBean().getNode();

			String action = obj.getUpdateType();
			if (action.equals("rename-scheme")) {
				project.renameScheme(value, true);
			} else if (action.equals("add-top-concept")) {
				project.addTopConcept(conceptStr, true);
			} else if (action.equals("add-concept")) {
				project.addConcept(obj.getValue(), obj.getConceptURI(), true);
			} else if (action.equals("rename-concept")) {
				project.renameConcept(conceptStr, value, true);
			} else if (action.equals("move-concept-to-top")) {
				project.moveToTopConcept(conceptStr, value, schemeStr, true);
			} else if (action.equals("move-concept-from-top")) {
				project.moveFromTopConcept(conceptStr, value, schemeStr, true);
			} else if (action.equals("remove-concept")) {
				project.removeConcept(conceptStr, true);

			} else if (action.equals("add-related-assertion")) {
				project.addObjectPropertyRelated(conceptStr, value);
				node.initialize();
			} else if (action.equals("add-inscheme-assertion")) {
				project.addObjectPropertyInscheme(conceptStr, schemeStr);
				node.initialize();
			} else if (action.equals("add-topconceptof-assertion")) {
				project.addObjectPropertyTopConceptOf(conceptStr, schemeStr);
				node.initialize();
			} else if (action.equals("add-broader-assertion")) {
				project.addObjectPropertyBroader(conceptStr, value);
				node.initialize();
			} else if (action.equals("add-narrower-assertion")) {
				project.addObjectPropertyNarrower(conceptStr, value);
				node.initialize();
			} else if (action.equals("add-other-assertion")) {
				project.addObjectPropertyOther(conceptStr, value, type);
				node.initialize();
			} else if (action.equals("remove-assertion")) {
				long assertionId = project.getTreeBean().getNode().getAssertionByTypeName(type, value).getId();
				project.removeAssertion(assertionId);
				node.initialize();
			
			} else if (action.equals("add-preferred-label")) {
				project.addDataPropertyPreferredLabel(conceptStr, value, lang, type);
				node.initialize();
			} else if (action.equals("add-notation-label")) {
				project.addDataPropertyNotation(conceptStr, value, lang, type);
				node.initialize();
			} else if (action.equals("add-altlabel-label")) {
				project.addDataPropertyAlternateLabel(conceptStr, value, lang, type);
				node.initialize();
			} else if (action.equals("add-hidden-label")) {
				project.addDataPropertyHiddenLabel(conceptStr, value, lang, type);
				node.initialize();
			} else if (action.equals("add-other-label")) {
				project.addDataPropertyOtherDataProperty(conceptStr, type, value, lang, type2);
				node.initialize();
			} else if (action.equals("remove-label")) {
				long labelId = project.getTreeBean().getNode().getLabelByTypeNameLang(type, value, lang).getId();
				project.removeLabel(labelId);
				node.initialize();
			}
		} catch (Exception e) {
			log.error(e);
		} finally {
			try {
				SKOSCollaborationEntryLocalServiceUtil.deleteSKOSCollaborationEntry(obj.getId());
			} catch (Exception e) {
			}
		}
	}
}