package edu.ucsd.nlp.portlet.action;

import javax.portlet.ResourceRequest;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;

import edu.ucsd.nlp.skos.SKOSProject;

public class WizardAction {
	
	private static final Log log = LogFactoryUtil.getLog(WizardAction.class);
	
	private SKOSProject project = null;
	private String baseURI = null;
	private String schemeURI = null;
	private String prefix = null;
	private String suffix = null;
	
	public void saveWizard(SKOSProject project, ResourceRequest request) throws Exception {
		this.project = project;
		this.baseURI = project.getBaseURI() + "/resource#";
		this.schemeURI = project.getBaseEntity().getURI().toString();
		this.prefix = ParamUtil.getString(request, "prefix", "");
		this.suffix = ParamUtil.getString(request, "suffix", "");
		String parentConcept = ParamUtil.getString(request, "parent", "");
    	String hierarchy = ParamUtil.getString(request, "hierarchy", "").replace("    ", "\t");
    	log.info("Running wizard for [" + parentConcept + "]");
    	log.info("Main scheme is [" + schemeURI + "]");
    	String[] lines = hierarchy.split("\n");
		for (int i = 0; i < lines.length; i++) {
			String name = lines[i];
			int weight = getWeight(name);
			if (weight == 0) {
				process(lines, i, parentConcept);
			}
		}
	}

	private void process(String[] lines, int lineIndex, String parentName) {
		String name = lines[lineIndex].replaceAll(" ", "_");
		int weight = getWeight(name);
		name = prefix + name.trim() + suffix;
		if (parentName.equals(schemeURI)) {
			project.addTopConcept(name, false);
		} else {
			project.addConcept(name, parentName, false);
		}
		for (int i = lineIndex + 1; i < lines.length; i++) {
			String childName = lines[i];
			int childWeight = getWeight(childName);
			if (childWeight == weight) {
				break;
			} else if (childWeight == (weight + 1)) {
				process(lines, i, baseURI + name);
			}
		}
	}

	private int getWeight(String s) {
		int tabs = 0;
		for (char c : s.toCharArray()) {
			if (c == '\t') {
				tabs++;
			}
		}
		return tabs;
	}
}