package edu.ucsd.nlp.bean;

import java.io.Serializable;

import edu.ucsd.nlp.bean.model.SKOSPropertiesModel;
import edu.ucsd.nlp.skos.SKOSProject;

public class SKOSPropertiesBean extends SKOSBean implements Serializable {

	private static final long serialVersionUID = 2483662826713947293L;
	
	private int id = 0;
	private SKOSPropertiesModel model = null;
	private String property = null;
	
	public SKOSPropertiesBean(SKOSProject project, int id, String conceptURI, String type, String schemeURI, String property) {
		setProject(project);
		setConceptURI(conceptURI);
		setSchemeURI(schemeURI);
		this.id = id;
		this.property = property;
		if (type.equals("object")) {
			this.model = getProject().getObjectPropertiesModelById(id);
		} else if (type.equals("data")) {
			this.model = getProject().getDataPropertiesModelById(id);
		}
	}
	
	public SKOSPropertiesBean(SKOSProject project, String conceptURI, String parentConceptURI, String conceptName, String schemeURI, String actionType) {
		setProject(project);
		setConceptURI(conceptURI);
		setParentConceptURI(parentConceptURI);
		setConceptName(conceptName);
		setSchemeURI(schemeURI);
		setActionType(actionType);
	}

	public int getId() {
		return id;
	}
	
	public String getProperty() {
		return model == null ? property : model.getProperty();
	}

	public String getValue() {
		return model == null ? "" : model.getObject();
	}
	
	public String getType() {
		return model == null ? "" : model.getType();
	}

	public String getLanguage() {
		return model == null ? "" : model.getLang();
	}
	
	public String getObjectURI() {
		return model == null ? "" : model.getObjectURI();
	}
}