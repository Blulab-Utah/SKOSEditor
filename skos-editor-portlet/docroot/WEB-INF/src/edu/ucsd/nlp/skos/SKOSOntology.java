package edu.ucsd.nlp.skos;

import java.net.URI;

public class SKOSOntology {
	
	public SKOSOntology(URI baseURI, String ontologyName, String filePath){
		this.baseURI = baseURI;
		this.ontologyName = ontologyName;
		this.filePath = filePath;
	}
	

	public String getFilePath() {
		return filePath;
	}


	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getAudience() {
		return audience;
	}
	public void setAudience(String audience) {
		this.audience = audience;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public String getCreated() {
		return created;
	}
	public void setCreated(String created) {
		this.created = created;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}	
	
	public URI getBaseURI() {
		return baseURI;
	}


	public void setBaseURI(URI baseURI) {
		this.baseURI = baseURI;
	}


	public String getOntologyName() {
		return ontologyName;
	}


	public void setOntologyName(String ontologyName) {
		this.ontologyName = ontologyName;
	}


	private URI baseURI = null;
	private String ontologyName = "";
	private String title = "";
	private String description = "";
	private String subject = "";
	private String audience = "";
	private String language = "";
	private String creator = "";
	private String created = "";
	private String version = "";
	private String filePath = "";
}
