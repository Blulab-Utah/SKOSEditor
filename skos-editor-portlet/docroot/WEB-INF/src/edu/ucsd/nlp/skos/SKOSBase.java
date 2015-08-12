package edu.ucsd.nlp.skos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.skos.SKOSConceptScheme;
import org.semanticweb.skos.SKOSDataFactory;
import org.semanticweb.skosapibinding.SKOSManager;

import com.liferay.portal.kernel.util.ListUtil;

import edu.ucsd.nlp.bean.model.SKOSPropertiesModel;
import edu.ucsd.nlp.util.SKOSConstants;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class SKOSBase {
	
	protected OWLOntologyManager owlManager = null;
	protected SKOSManager skosManager = null;
	protected SKOSDataFactory skosFactory;
	protected SKOSConceptScheme scheme = null;
	protected String schemeURI = null;
	protected Map<String, String> dataTypes = null;

	public SKOSBase() {
		owlManager = OWLManager.createOWLOntologyManager();
	}

	private List<SKOSPropertiesModel> objectProperties = new ArrayList<SKOSPropertiesModel>();
	private List<SKOSPropertiesModel> dataProperties = new ArrayList<SKOSPropertiesModel>();
	
	public void initializeObjectProperties() {
		objectProperties = new ArrayList<SKOSPropertiesModel>();
	}
	
	public void initializeDataProperties() {
		dataProperties = new ArrayList<SKOSPropertiesModel>();
	}
	
	public List<SKOSPropertiesModel> getObjectPropertiesModels() {
		return objectProperties == null ? new ArrayList<SKOSPropertiesModel>() : objectProperties;
	}
	
	public List<SKOSPropertiesModel> getDataPropertiesModels() {
		return dataProperties == null ? new ArrayList<SKOSPropertiesModel>() : dataProperties;
	}
	
	public void addObjectPropertiesModel(SKOSPropertiesModel obj) {
		getObjectPropertiesModels().add(obj);
	}
	
	public void addDataPropertiesModel(SKOSPropertiesModel obj) {
		getDataPropertiesModels().add(obj);
	}

	public List<SKOSPropertiesModel> getObjectModelsByProperty(String property) {
		List<SKOSPropertiesModel> filtered = new ArrayList<SKOSPropertiesModel>();
		for (SKOSPropertiesModel obj : getObjectPropertiesModels()) {
			String prop = obj.getProperty();
			prop = prop == null ? "" : prop;
			boolean isDefault = !prop.equals(SKOSConstants.TYPE_RELATED)
					&& !prop.equals(SKOSConstants.TYPE_BROADER)
					&& !prop.equals(SKOSConstants.TYPE_NARROWER)
					&& !prop.equals(SKOSConstants.TYPE_INSCHEME)
					&& !prop.equals(SKOSConstants.TYPE_TOPCONCEPTOF);
			if ((property.equals(SKOSConstants.TYPE_RELATED) && prop.equals(SKOSConstants.TYPE_RELATED))
					|| (property.equals(SKOSConstants.TYPE_BROADER) && prop.equals(SKOSConstants.TYPE_BROADER))
					|| (property.equals(SKOSConstants.TYPE_NARROWER) && prop.equals(SKOSConstants.TYPE_NARROWER))
					|| (property.equals(SKOSConstants.TYPE_INSCHEME) && prop.equals(SKOSConstants.TYPE_INSCHEME))
					|| (property.equals(SKOSConstants.TYPE_TOPCONCEPTOF) && prop.equals(SKOSConstants.TYPE_TOPCONCEPTOF))
					|| (property.equals(SKOSConstants.TYPE_DEFAULT) && isDefault)) {
				filtered.add(obj);
			}
		}
		return filtered;
	}
	
	public List<SKOSPropertiesModel> getDataModelsByProperty(String property) {
		List<SKOSPropertiesModel> filtered = new ArrayList<SKOSPropertiesModel>();
		for (SKOSPropertiesModel obj : getDataPropertiesModels()) {
			String prop = obj.getProperty();
			prop = prop == null ? "" : prop;
			boolean isDefault = !prop.equals(SKOSConstants.TYPE_PREFLABEL)
					&& !prop.equals(SKOSConstants.TYPE_NOTATION)
					&& !prop.equals(SKOSConstants.TYPE_ALTLABEL)
					&& !prop.equals(SKOSConstants.TYPE_HIDDENLABEL);
			if ((property.equals(SKOSConstants.TYPE_PREFLABEL) && prop.equals(SKOSConstants.TYPE_PREFLABEL))
					|| (property.equals(SKOSConstants.TYPE_NOTATION) && prop.equals(SKOSConstants.TYPE_NOTATION))
					|| (property.equals(SKOSConstants.TYPE_ALTLABEL) && prop.equals(SKOSConstants.TYPE_ALTLABEL))
					|| (property.equals(SKOSConstants.TYPE_HIDDENLABEL) && prop.equals(SKOSConstants.TYPE_HIDDENLABEL))
					|| (property.equals(SKOSConstants.TYPE_NOTATION) && prop.equals(SKOSConstants.TYPE_NOTATION))
					|| (property.equals(SKOSConstants.TYPE_DEFAULT) && isDefault)) {
				filtered.add(obj);
			}
		}
		return filtered;
	}
	
	public SKOSPropertiesModel getObjectPropertiesModelById(int id) {
		for (SKOSPropertiesModel obj : getObjectPropertiesModels()) {
			if (obj.getId() == id) {
				return obj;
			}
		}
		return null;
	}
	
	public SKOSPropertiesModel getDataPropertiesModelById(int id) {
		for (SKOSPropertiesModel obj : getDataPropertiesModels()) {
			if (obj.getId() == id) {
				return obj;
			}
		}
		return null;
	}
	
	public void sortObjectProperties() {
		List sorted = ListUtil.copy(getObjectPropertiesModels());
		Collections.sort(sorted, new Comparator() {
			public int compare(Object a, Object b) {
				return ((SKOSPropertiesModel) a).getObject().compareTo(((SKOSPropertiesModel) b).getObject());
			}
		});
		objectProperties = sorted;
	}
	
	public void sortDataProperties() {
		List sorted = ListUtil.copy(getDataPropertiesModels());
		Collections.sort(sorted, new Comparator() {
			public int compare(Object a, Object b) {
				return ((SKOSPropertiesModel) a).getObject().compareTo(((SKOSPropertiesModel) b).getObject());
			}
		});
		dataProperties = sorted;
	}
}