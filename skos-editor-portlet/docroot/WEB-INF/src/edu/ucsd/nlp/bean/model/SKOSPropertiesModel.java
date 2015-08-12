package edu.ucsd.nlp.bean.model;


public class SKOSPropertiesModel {
	
	private TreeNodeModel node = null;
	private int id = 0;
	private String subjectURI = ""; // http://skos.um.es/unescothes/CS000
	private String subject = ""; 
	private String property = ""; // altLabel
	private String propertyURI = ""; // http://www.w3.org/2004/02/skos/core#altLabel
	private String object = ""; // New AltLabel
	private String objectURI = ""; // New AltLabel
	private String type = "";
	private String typeURI = "";
	private String lang = ""; // uk

	public SKOSPropertiesModel(TreeNodeModel node, int id, String subjectURI, String subject,
			String property, String propertyURI, String object,
			String objectURI, String type, String typeURI, String lang) {
		this.node = node;
		this.id = id;
		this.subjectURI = subjectURI;
		this.subject = subject;
		this.property = property;
		this.propertyURI = propertyURI;
		this.object = object;
		this.objectURI = objectURI;
		this.type = type;
		this.typeURI = typeURI;
		this.lang = lang;
	}
	
	public TreeNodeModel getNode() {
		return node;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSubjectURI() {
		return subjectURI;
	}

	public void setSubjectURI(String subjectURI) {
		this.subjectURI = subjectURI;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	public String getPropertyURI() {
		return propertyURI;
	}

	public void setPropertyURI(String propertyURI) {
		this.propertyURI = propertyURI;
	}

	public String getObject() {
		return object == null ? "" : object;
	}
	
	public void setObject(String object) {
		this.object = object;
	}

	public String getObjectURI() {
		return objectURI;
	}

	public void setObjectURI(String objectURI) {
		this.objectURI = objectURI;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTypeURI() {
		return typeURI;
	}

	public void setTypeURI(String typeURI) {
		this.typeURI = typeURI;
	}

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}
	
	public String getTitle() {
		String s = "";
		try {
			s = node.getTree().findNodeByUri(objectURI).getTitle();
		} catch (Exception e) {
		}
		return s;
	}
}