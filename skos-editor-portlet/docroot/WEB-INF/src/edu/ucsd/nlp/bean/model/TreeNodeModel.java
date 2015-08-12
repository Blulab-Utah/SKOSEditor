package edu.ucsd.nlp.bean.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.util.IRIShortFormProvider;
import org.semanticweb.owlapi.util.SimpleIRIShortFormProvider;
import org.semanticweb.skos.SKOSAnnotation;
import org.semanticweb.skos.SKOSEntity;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ListUtil;

import edu.ucsd.nlp.bean.TreeBean;
import edu.ucsd.nlp.skos.StringTriple;
import edu.ucsd.nlp.util.SKOSConstants;

public class TreeNodeModel implements Serializable {
	
	private static final long serialVersionUID = 4615025129563844363L;

	private static final Log log = LogFactoryUtil.getLog(TreeNodeModel.class);
	
	private static final IRIShortFormProvider shortFormProvider = new SimpleIRIShortFormProvider();

	private TreeBean tree = null;
	private boolean titleLanguageAsSet = false;
	private String showConceptTitleAs = "";
	private String showConceptTitleLanguageAs = "";
	
	private SKOSEntity entity = null;
	private TreeNodeModel parent = null;
	private long id = 0;
	private String uri = "";
	private String title = "";
	private String type = "";
	private List<SKOSAnnotation> annotations = new ArrayList<SKOSAnnotation>();
	private List<SKOSPropertiesModel> objectProperties = new ArrayList<SKOSPropertiesModel>();
	private List<SKOSPropertiesModel> dataProperties = new ArrayList<SKOSPropertiesModel>();
	private long assertionId = 0;
	private SKOSPropertiesModel assertion = null;
	private long labelId = 0;
	private SKOSPropertiesModel label = null;
	private List<TreeNodeModel> children = null;

	public TreeNodeModel(TreeBean tree, SKOSEntity entity, String type, TreeNodeModel parent) {
		this.tree = tree;
		this.titleLanguageAsSet = tree.getProject().isTitleLanguageAsSet();
		this.showConceptTitleAs = tree.getProject().getShowConceptTitleAs();
		this.showConceptTitleLanguageAs = tree.getProject().getShowConceptTitleLanguageAs();

		this.entity = entity;
		this.id = tree.increment();
		this.parent = parent;
		this.type = type;
		
		initialize();
	}

	public void initialize() {		
		try {
			uri = entity.getURI().toString();
			title = shortFormProvider.getShortForm(IRI.create(entity.getURI()));
			annotations = tree.getProject().getObjectAnnotations(entity);
			refreshAssertions();
			refreshLabels();
		} catch (Exception e) {
			log.error(e);
		}
	}
	
	public void rename(String name) {
		title = name;
	}
	
	public void addChildNode(SKOSEntity entity, String type) {
		tree.getNodes().add(new TreeNodeModel(tree, entity, type, this));
		tree.sort();
	}
	
	public void refreshAssertions() {
		objectProperties = new ArrayList<SKOSPropertiesModel>();
		int id = 1;
		SKOSPropertiesModel obj = null;
		List<StringTriple> props = tree.getProject().getObjectPropertiesAsTriple(entity, annotations);
		for (StringTriple prop : props) {
			String property = prop.getProperty();
			String propertyURI = prop.getPropertyURI();
			String object = prop.getObject();
			String objectURI = prop.getObjectURI();
			String propType = prop.getType();
			String typeURI = prop.getTypeURI();
			String lang = prop.getLang();
			obj = new SKOSPropertiesModel(this, id++, uri, title, property, propertyURI, object, objectURI, propType, typeURI, lang);
			objectProperties.add(obj);
		}
		ListUtil.sort(objectProperties, new Comparator<SKOSPropertiesModel>() {
			public int compare(SKOSPropertiesModel a, SKOSPropertiesModel b) {
				return a.getObject().compareTo(b.getObject());
			}
		});
	}
	
	public void refreshLabels() {
		dataProperties = new ArrayList<SKOSPropertiesModel>();
		int id = 1;
		SKOSPropertiesModel obj = null;
		List<StringTriple> props = tree.getProject().getDataPropertiesAsTriple(entity, annotations);
		for (StringTriple prop : props) {
			String property = prop.getProperty();
			String propertyURI = prop.getPropertyURI();
			String object = prop.getObject();
			if (object == null || object.isEmpty()) {
				continue;
			}
			String objectURI = prop.getObjectURI();
			String propType = prop.getType();
			String typeURI = prop.getTypeURI();
			String lang = prop.getLang();
			obj = new SKOSPropertiesModel(this, id++, uri, title, property, propertyURI, object, objectURI, propType, typeURI, lang);
			dataProperties.add(obj);
		}
		ListUtil.sort(dataProperties, new Comparator<SKOSPropertiesModel>() {
			public int compare(SKOSPropertiesModel a, SKOSPropertiesModel b) {
				return a.getObject().compareTo(b.getObject());
			}
		});
	}
	
	public TreeBean getTree() {
		return tree;
	}
	
	public SKOSEntity getEntity() {
		return entity;
	}

	public long getId() {
		return id;
	}

	public long getParentId() {
		return parent == null ? 0 : parent.getId();
	}

	public String getUri() {
		return uri;
	}

	public String getTitle() {
		if (tree.getProject().isTitleAsSet()) {
			for (SKOSPropertiesModel obj : dataProperties) {
				if (obj.getProperty().equals(showConceptTitleAs)) {
					if (titleLanguageAsSet) {
						if (obj.getLang().equals(showConceptTitleLanguageAs)) {
							return obj.getObject();
						} else {
							continue;
						}
					} else {
						return obj.getObject();
					}
				}
			}
		}
		return title;
	}

	public String getType() {
		return type;
	}
	
	public String getParentUri() {
		return parent == null ? "" : parent.getUri();
	}
	
	public List<TreeNodeModel> getChildren() {
		children = new ArrayList<TreeNodeModel>();
		for (TreeNodeModel obj : tree.getNodes()) {
			if (obj.getParentId() == id) {
				children.add(obj);
			}
		}
		return children;
	}
	
	private List<SKOSPropertiesModel> getObjectModelsByProperty(String property) {
		List<SKOSPropertiesModel> filtered = new ArrayList<SKOSPropertiesModel>();
		for (SKOSPropertiesModel obj : objectProperties) {
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
	
	private List<SKOSPropertiesModel> getDataModelsByProperty(String property) {
		List<SKOSPropertiesModel> filtered = new ArrayList<SKOSPropertiesModel>();
		for (SKOSPropertiesModel obj : dataProperties) {
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
					|| (property.equals(SKOSConstants.TYPE_DEFAULT) && isDefault)) {
				filtered.add(obj);
			}
		}
		return filtered;
	}
	
	public List<SKOSPropertiesModel> getRelatedAssertions() {
		return getObjectModelsByProperty(SKOSConstants.TYPE_RELATED);
	}
	
	public List<SKOSPropertiesModel> getInSchemeAssertions() {
		return getObjectModelsByProperty(SKOSConstants.TYPE_INSCHEME);
	}
	
	public List<SKOSPropertiesModel> getTopConceptOfAssertions() {
		return getObjectModelsByProperty(SKOSConstants.TYPE_TOPCONCEPTOF);
	}

	public List<SKOSPropertiesModel> getBroaderAssertions() {
		return getObjectModelsByProperty(SKOSConstants.TYPE_BROADER);
	}

	public List<SKOSPropertiesModel> getNarrowerAssertions() {
		return getObjectModelsByProperty(SKOSConstants.TYPE_NARROWER);
	}
	
	public List<SKOSPropertiesModel> getOtherAssertions() {
		return getObjectModelsByProperty(SKOSConstants.TYPE_DEFAULT);
	}
	
	public List<SKOSPropertiesModel> getPrefLabels() {
		return getDataModelsByProperty(SKOSConstants.TYPE_PREFLABEL);
	}

	public List<SKOSPropertiesModel> getNotations() {
		return getDataModelsByProperty(SKOSConstants.TYPE_NOTATION);
	}

	public List<SKOSPropertiesModel> getAltLabels() {
		return getDataModelsByProperty(SKOSConstants.TYPE_ALTLABEL);
	}

	public List<SKOSPropertiesModel> getHiddenLabels() {
		return getDataModelsByProperty(SKOSConstants.TYPE_HIDDENLABEL);
	}

	public List<SKOSPropertiesModel> getOtherLabels() {
		return getDataModelsByProperty(SKOSConstants.TYPE_DEFAULT);
	}

	public long getAssertionId() {
		return assertionId;
	}

	public void setAssertionId(long assertionId) {
		this.assertionId = assertionId;
		
		assertion = null;
		for (SKOSPropertiesModel obj : objectProperties) {
			if (obj.getId() == assertionId) {
				assertion = obj;
				break;
			}
		}
	}

	public SKOSPropertiesModel getAssertion() {
		return assertion;
	}

	public void setAssertion(SKOSPropertiesModel assertion) {
		this.assertion = assertion;
	}

	public long getLabelId() {
		return labelId;
	}

	public void setLabelId(long labelId) {
		this.labelId = labelId;
		
		label = null;
		for (SKOSPropertiesModel obj : dataProperties) {
			if (obj.getId() == labelId) {
				label = obj;
				break;
			}
		}
	}

	public SKOSPropertiesModel getLabel() {
		return label;
	}

	public void setLabel(SKOSPropertiesModel label) {
		this.label = label;
	}

	public SKOSPropertiesModel getAssertionById(long assertionId) {
		for (SKOSPropertiesModel obj : objectProperties) {
			if (obj.getId() == assertionId) {
				return obj;
			}
		}
		return null;
	}
	
	public SKOSPropertiesModel getAssertionByTypeName(String type, String name) {
		try {
			for (SKOSPropertiesModel obj : objectProperties) {
				if (obj.getPropertyURI().equals(type) && obj.getObjectURI().equals(name)) {
					return obj;
				}
			}
		} catch (Exception e) {
		}
		return null;
	}
	
	public SKOSPropertiesModel getLabelById(long labelId) {
		for (SKOSPropertiesModel obj : dataProperties) {
			if (obj.getId() == labelId) {
				return obj;
			}
		}
		return null;
	}

	public SKOSPropertiesModel getLabelByTypeNameLang(String type, String name, String lang) {
		try {
			for (SKOSPropertiesModel obj : dataProperties) {
				if (obj.getPropertyURI().equals(type) && obj.getObject().equals(name) && obj.getLang().equals(lang)) {
					return obj;
				}
			}
		} catch (Exception e) {
		}
		return null;
	}
}