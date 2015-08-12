package edu.ucsd.nlp.bean;

import java.io.Serializable;

import edu.ucsd.nlp.skos.SKOSProject;

public class SettingsBean extends SKOSBean implements Serializable {

	private static final long serialVersionUID = 2483662826713947293L;
	
	public SettingsBean(SKOSProject project) {
		this.project = project;
	}

	public String getShowConceptTitleAs() {
		return project.getShowConceptTitleAs();
	}
	
	public String getShowConceptTitleLanguageAs() {
		return project.getShowConceptTitleLanguageAs();
	}
}