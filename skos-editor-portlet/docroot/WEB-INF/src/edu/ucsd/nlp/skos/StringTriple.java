package edu.ucsd.nlp.skos;

public class StringTriple {
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
	public String getObject() {
		return object;
	}
	public void setObject(String object) {
		this.object = object;
	}
	
	public String getPropertyURI() {
		return propertyURI;
	}
	public void setPropertyURI(String propertyURI) {
		this.propertyURI = propertyURI;
	}
	public String getSubjectURI() {
		return subjectURI;
	}
	public void setSubjectURI(String subjectURI) {
		this.subjectURI = subjectURI;
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
	public String getLang() {
		return lang;
	}
	public void setLang(String lang) {
		this.lang = lang;
	}

	public String getTypeURI() {
		return typeURI;
	}
	public void setTypeURI(String typeURI) {
		this.typeURI = typeURI;
	}


	private String subject = "";
	private String property = "";
	private String object = "";
	private String type = "";
	private String lang = "";
	private String propertyURI = "";
	private String subjectURI = "";
	private String objectURI= "";
	private String typeURI	= "";
}
