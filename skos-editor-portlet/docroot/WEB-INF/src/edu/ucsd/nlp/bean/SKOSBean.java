package edu.ucsd.nlp.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import org.apache.struts.util.LabelValueBean;
import org.semanticweb.skos.SKOSEntity;

import edu.ucsd.nlp.skos.SKOSProject;
import edu.ucsd.nlp.skos.SKOSVocabulary;

public class SKOSBean implements Serializable {

	private static final long serialVersionUID = 2483662826713947293L;

	protected SKOSProject project = null;
	private String actionType = null;
	private String schemeURI = null;
	private String conceptURI = null;
	private String conceptName = null;
	private String parentConceptURI = null;
	
	private static List<LabelValueBean> OBJECT_PROPERTY_TYPES = new ArrayList<LabelValueBean>();
	private static List<LabelValueBean> DATA_PROPERTY_TYPES = new ArrayList<LabelValueBean>();
	private static List<String> languages = new ArrayList<String>();
	private static List<LabelValueBean> SHOW_AS_OPTIONS = new ArrayList<LabelValueBean>();
	static {
		OBJECT_PROPERTY_TYPES.add(new LabelValueBean(SKOSVocabulary.BROADMATCH.getIRI().toURI().getFragment(), SKOSVocabulary.BROADMATCH.getIRI().toURI().toString()));
		OBJECT_PROPERTY_TYPES.add(new LabelValueBean(SKOSVocabulary.NARROWMATCH.getIRI().toURI().getFragment(), SKOSVocabulary.NARROWMATCH.getIRI().toURI().toString()));
		OBJECT_PROPERTY_TYPES.add(new LabelValueBean(SKOSVocabulary.EXACTMATCH.getIRI().toURI().getFragment(), SKOSVocabulary.EXACTMATCH.getIRI().toURI().toString()));
		OBJECT_PROPERTY_TYPES.add(new LabelValueBean(SKOSVocabulary.BROADERTRANS.getIRI().toURI().getFragment(), SKOSVocabulary.BROADERTRANS.getIRI().toURI().toString()));
		OBJECT_PROPERTY_TYPES.add(new LabelValueBean(SKOSVocabulary.NARROWERTRANS.getIRI().toURI().getFragment(), SKOSVocabulary.NARROWERTRANS.getIRI().toURI().toString()));
		OBJECT_PROPERTY_TYPES.add(new LabelValueBean(SKOSVocabulary.RELATEDMATCH.getIRI().toURI().getFragment(), SKOSVocabulary.RELATEDMATCH.getIRI().toURI().toString()));
		OBJECT_PROPERTY_TYPES.add(new LabelValueBean(SKOSVocabulary.CLOSEMATCH.getIRI().toURI().getFragment(), SKOSVocabulary.CLOSEMATCH.getIRI().toURI().toString()));
		
		DATA_PROPERTY_TYPES.add(new LabelValueBean(SKOSVocabulary.CHANGENOTE.getIRI().toURI().getFragment(), SKOSVocabulary.CHANGENOTE.getIRI().toURI().toString()));
		DATA_PROPERTY_TYPES.add(new LabelValueBean(SKOSVocabulary.COMMENT.getIRI().toURI().getFragment(), SKOSVocabulary.COMMENT.getIRI().toURI().toString()));
		DATA_PROPERTY_TYPES.add(new LabelValueBean(SKOSVocabulary.DEFINITION.getIRI().toURI().getFragment(), SKOSVocabulary.DEFINITION.getIRI().toURI().toString()));
		DATA_PROPERTY_TYPES.add(new LabelValueBean(SKOSVocabulary.DOCUMENT.getIRI().toURI().getFragment(), SKOSVocabulary.DOCUMENT.getIRI().toURI().toString()));
		DATA_PROPERTY_TYPES.add(new LabelValueBean(SKOSVocabulary.EDITORIALNOTE.getIRI().toURI().getFragment(), SKOSVocabulary.EDITORIALNOTE.getIRI().toURI().toString()));
		DATA_PROPERTY_TYPES.add(new LabelValueBean(SKOSVocabulary.EXAMPLE.getIRI().toURI().getFragment(), SKOSVocabulary.EXAMPLE.getIRI().toURI().toString()));
		DATA_PROPERTY_TYPES.add(new LabelValueBean(SKOSVocabulary.HISTORYNOTE.getIRI().toURI().getFragment(), SKOSVocabulary.HISTORYNOTE.getIRI().toURI().toString()));
		DATA_PROPERTY_TYPES.add(new LabelValueBean(SKOSVocabulary.IMAGE.getIRI().toURI().getFragment(), SKOSVocabulary.IMAGE.getIRI().toURI().toString()));
		DATA_PROPERTY_TYPES.add(new LabelValueBean(SKOSVocabulary.NOTATION.getIRI().toURI().getFragment(), SKOSVocabulary.NOTATION.getIRI().toURI().toString()));
		DATA_PROPERTY_TYPES.add(new LabelValueBean(SKOSVocabulary.NOTE.getIRI().toURI().getFragment(), SKOSVocabulary.NOTE.getIRI().toURI().toString()));
		DATA_PROPERTY_TYPES.add(new LabelValueBean(SKOSVocabulary.RESOURCE.getIRI().toURI().getFragment(), SKOSVocabulary.RESOURCE.getIRI().toURI().toString()));
		DATA_PROPERTY_TYPES.add(new LabelValueBean(SKOSVocabulary.SCOPENOTE.getIRI().toURI().getFragment(), SKOSVocabulary.SCOPENOTE.getIRI().toURI().toString()));
	
		languages = new ArrayList<String>();
		languages.add("en");
		languages.add("de");
		languages.add("fr");
		Set<String> set = new HashSet<String>();
		for (Locale obj : Locale.getAvailableLocales()) {
			String l = obj.getLanguage();
			if (l.equals("en") || l.equals("de") || l.equals("fr")) {
				continue;
			}
			set.add(obj.getLanguage());
		}
		languages.addAll(set);

		SHOW_AS_OPTIONS.add(new LabelValueBean("Preferred Labels", "prefLabel"));
		SHOW_AS_OPTIONS.add(new LabelValueBean("Notations", "notation"));
		SHOW_AS_OPTIONS.add(new LabelValueBean("Alternative Labels", "altLabel"));
		SHOW_AS_OPTIONS.add(new LabelValueBean("Hidden Labels", "hiddenLabel"));
	}

	public SKOSProject getProject() {
		return project;
	}

	public String getActionType() {
		return actionType;
	}

	public void setActionType(String actionType) {
		this.actionType = actionType;
	}

	public String getSchemeURI() {
		return schemeURI;
	}

	public void setSchemeURI(String schemeURI) {
		this.schemeURI = schemeURI;
	}

	public String getConceptURI() {
		return conceptURI;
	}

	public void setConceptURI(String conceptURI) {
		this.conceptURI = conceptURI;
	}

	public String getConceptName() {
		return conceptName;
	}

	public void setConceptName(String conceptName) {
		this.conceptName = conceptName;
	}

	public String getParentConceptURI() {
		return parentConceptURI == null || parentConceptURI.equals("undefined") ? "None" : parentConceptURI;
	}

	public void setParentConceptURI(String parentConceptURI) {
		this.parentConceptURI = parentConceptURI;
	}

	public void setProject(SKOSProject project) {
		this.project = project;
	}

	public Set<String> getTypes() {
		Set<String> objects = new HashSet<String>();		
		Map<String, String> types = getProject().getDataTypes();
		Iterator<String> it = types.keySet().iterator();
		while (it.hasNext()) {
			String key = it.next();
			String value = types.get(key);
			objects.add(value);
		}
		return objects;
	}

	public List<LabelValueBean> getAllConcepts() {
		List<LabelValueBean> objects = new ArrayList<LabelValueBean>();
		List<SKOSEntity> allConcepts = getProject().getAllConcepts();
	    Collections.sort(allConcepts, new Comparator<SKOSEntity>() {
	          public int compare(SKOSEntity a, SKOSEntity b) {
	              return a.getURI().compareTo(b.getURI());
	    }});
		for (SKOSEntity concept : allConcepts) {
			objects.add(new LabelValueBean(getProject().getBrowserText(concept.getURI().toString()), concept.getURI().toString()));
		}
		return objects;
	}
	
	public List<LabelValueBean> getAllSchemes() {
		List<LabelValueBean> objects = new ArrayList<LabelValueBean>();
//		for (SKOSEntity concept : getProject().getConceptSchemes()) {
//			objects.add(new LabelValueBean(getProject().getBrowserText(concept), concept.getURI().toString()));
//		}
		objects.add(new LabelValueBean(getProject().getBrowserText(getProject().getBaseEntity().getURI().toString()), getProject().getTopConceptURI()));
		return objects;
	}
	
	public List<LabelValueBean> getAllObjectPropertyTypes() {
		return OBJECT_PROPERTY_TYPES;
	}
	
	public List<LabelValueBean> getAllDataPropertyTypes() {
		return DATA_PROPERTY_TYPES;
	}
	
	public List<String> getLanguages() {
		return languages;
	}
	
	public List<LabelValueBean> getShowAsOptions() {
		return SHOW_AS_OPTIONS;
	}
}