package edu.ucsd.nlp.skos;

import java.io.File;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.semanticweb.owlapi.model.AddAxiom;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLAnnotationAssertionAxiom;
import org.semanticweb.owlapi.model.OWLAnnotationSubject;
import org.semanticweb.owlapi.model.OWLAnnotationValue;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.model.OWLDataPropertyAssertionAxiom;
import org.semanticweb.owlapi.model.OWLDatatype;
import org.semanticweb.owlapi.model.OWLLiteral;
import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLObjectPropertyAssertionAxiom;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyChange;
import org.semanticweb.owlapi.model.RemoveAxiom;
import org.semanticweb.owlapi.util.IRIShortFormProvider;
import org.semanticweb.owlapi.util.OWLEntityRemover;
import org.semanticweb.owlapi.util.OWLEntityRenamer;
import org.semanticweb.owlapi.util.SimpleIRIShortFormProvider;
import org.semanticweb.owlapi.vocab.OWL2Datatype;
import org.semanticweb.skos.AddAssertion;
import org.semanticweb.skos.RemoveAssertion;
import org.semanticweb.skos.SKOSAnnotation;
import org.semanticweb.skos.SKOSChange;
import org.semanticweb.skos.SKOSChangeException;
import org.semanticweb.skos.SKOSConcept;
import org.semanticweb.skos.SKOSConceptScheme;
import org.semanticweb.skos.SKOSDataFactory;
import org.semanticweb.skos.SKOSDataProperty;
import org.semanticweb.skos.SKOSDataRelationAssertion;
import org.semanticweb.skos.SKOSDataset;
import org.semanticweb.skos.SKOSEntity;
import org.semanticweb.skos.SKOSEntityAssertion;
import org.semanticweb.skos.SKOSLiteral;
import org.semanticweb.skos.SKOSObjectProperty;
import org.semanticweb.skos.SKOSObjectRelationAssertion;
import org.semanticweb.skos.SKOSTypedLiteral;
import org.semanticweb.skos.SKOSUntypedLiteral;
import org.semanticweb.skosapibinding.SKOSFormatExt;
import org.semanticweb.skosapibinding.SKOSManager;
import org.semanticweb.skosapibinding.SKOStoOWLConverter;

import uk.ac.manchester.cs.skos.SKOSObjectRelationAssertionImpl;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.service.UserLocalServiceUtil;

import edu.ucsd.nlp.bean.TreeBean;
import edu.ucsd.nlp.bean.model.SKOSPropertiesModel;
import edu.ucsd.nlp.bean.model.TreeNodeModel;
import edu.ucsd.nlp.model.SharedFile;
import edu.ucsd.nlp.service.ObjectHistoryLocalServiceUtil;
import edu.ucsd.nlp.service.SKOSCollaborationEntryLocalServiceUtil;
import edu.ucsd.nlp.service.SKOSSettingLocalServiceUtil;
import edu.ucsd.nlp.service.SharedFileLocalServiceUtil;
import edu.ucsd.nlp.util.SKOSConstants;

public class SKOSProject extends SKOSBase {

	private static final Log log = LogFactoryUtil.getLog(SKOSProject.class);
	
	private static final IRIShortFormProvider shortFormProvider = new SimpleIRIShortFormProvider();
	
	private TreeBean treeBean = null;

	private String showConceptTitleAs = "";
	private String showConceptTitleLanguageAs = "en";
	private boolean titleAsSet = false;
	private boolean titleLanguageAsSet = false;
	
	private long userId = 0;
	private String userName = "";
	private long skosFileId = 0;
	private int access = 2;

	public SKOSProject(long userId, long skosFileId, File file) throws Exception {
		this.userId = userId;
		this.userName = UserLocalServiceUtil.getUser(userId).getFullName();
		this.skosFileId = skosFileId;
		this.access = 2;
		
		showConceptTitleAs = SKOSSettingLocalServiceUtil.findByUserName(userId, "show-concept-title-as").getValue();
		if (showConceptTitleAs != null && !showConceptTitleAs.isEmpty()) {
			titleAsSet = true;
		}
		showConceptTitleLanguageAs = SKOSSettingLocalServiceUtil.findByUserName(userId, "show-concept-title-language-as").getValue();
		if (showConceptTitleLanguageAs != null && !showConceptTitleLanguageAs.isEmpty()) {
			titleLanguageAsSet = true;
		}

		SKOSCollaborationEntryLocalServiceUtil.removeByFileUser(skosFileId, userId);

//		ObjectHistoryLocalServiceUtil.create(skosFileId, userId, "init", "", "", "", "", "", userName + " opened the file");

		skosManager = new SKOSManager(owlManager);
		SKOSDataset dataset = skosManager.loadDataset(file.toURI());
		skosFactory = skosManager.getSKOSDataFactory();
		scheme = null;
		try {
			scheme = dataset.getSKOSConceptSchemes().iterator().next();
		} catch (Exception e) {
//			log.info("Notice: root element does not have an xml:base. Relative IRIs will be resolved against file://" + file.getParent().replace("\\", "//"));
		}
		if (scheme == null) {
			addSchemeToProject(file.getName(), file.getParent().replace("\\", "//"));
		}
		schemeURI = scheme.getURI().toString();
		
		dataTypes = new HashMap<String, String>();
		dataTypes.put(OWL2Datatype.XSD_STRING.getURI().toString(), OWL2Datatype.XSD_STRING.getShortName());
		dataTypes.put(OWL2Datatype.RDFS_LITERAL.getURI().toString(), OWL2Datatype.RDFS_LITERAL.getShortName());
		dataTypes.put(OWL2Datatype.RDF_XML_LITERAL.getURI().toString(), OWL2Datatype.RDF_XML_LITERAL.getShortName());		
		dataTypes.put(OWL2Datatype.XSD_INTEGER.getURI().toString(), OWL2Datatype.XSD_INTEGER.getShortName());
		dataTypes.put(OWL2Datatype.XSD_DECIMAL.getURI().toString(), OWL2Datatype.XSD_DECIMAL.getShortName());
		dataTypes.put(OWL2Datatype.XSD_DATE_TIME.getURI().toString(), OWL2Datatype.XSD_DATE_TIME.getShortName());
		dataTypes.put(OWL2Datatype.XSD_BOOLEAN.getURI().toString(), OWL2Datatype.XSD_BOOLEAN.getShortName());
		for (SKOSConcept concept : dataset.getSKOSConcepts()) {
			for (SKOSDataRelationAssertion assertion : dataset.getSKOSDataRelationAssertions(concept)) {
				SKOSLiteral literal = assertion.getSKOSObject();
				if (literal.isTyped()) {
					SKOSTypedLiteral typedLiteral = literal.getAsSKOSTypedLiteral();
					dataTypes.put(typedLiteral.getAsSKOSTypedLiteral().getDataType().getURI().toString(), typedLiteral.getAsSKOSTypedLiteral().getDataType().getURI().getFragment());
				}
			}
		}
		
		cleanupPropertiesAddedAsAnnotations();
	}

	public SKOSProject(SKOSOntology ontology) {
		try {
			skosManager = new SKOSManager(owlManager);

            final URI baseURI = ontology.getBaseURI();//"http://www.extended_sso.org/";
            final String name = ontology.getOntologyName();//"extended_sso";

            SKOSDataset dataset = skosManager.createSKOSDataset(baseURI);
            skosFactory = skosManager.getSKOSDataFactory();

            scheme = skosFactory.getSKOSConceptScheme(URI.create(baseURI + "#" + name));
            schemeURI = scheme.getURI().toString();

            skosManager.applyChange(new AddAssertion(dataset, skosFactory.getSKOSEntityAssertion(scheme)));

            List<SKOSChange> changes = new ArrayList<SKOSChange>();
            changes.add(skos_addDataType(dataset, skosFactory, scheme, "audience", ontology.getAudience()));
            changes.add(skos_addDataType(dataset, skosFactory, scheme, "created", ontology.getCreated()));
            changes.add(skos_addDataType(dataset, skosFactory, scheme, "creator", ontology.getCreator()));
            changes.add(skos_addDataType(dataset, skosFactory, scheme, "description", ontology.getDescription()));
            changes.add(skos_addDataType(dataset, skosFactory, scheme, "language", ontology.getLanguage()));
            changes.add(skos_addDataType(dataset, skosFactory, scheme, "subject", ontology.getSubject()));
            changes.add(skos_addDataType(dataset, skosFactory, scheme, "title", ontology.getTitle()));
            changes.add(skos_addDataType(dataset, skosFactory, scheme, "version", ontology.getVersion()));

			skosManager.applyChanges(changes);
			
			dataTypes = new HashMap<String, String>();
			dataTypes.put(OWL2Datatype.XSD_STRING.getURI().toString(), OWL2Datatype.XSD_STRING.getShortName());
			dataTypes.put(OWL2Datatype.RDFS_LITERAL.getURI().toString(), OWL2Datatype.RDFS_LITERAL.getShortName());
			dataTypes.put(OWL2Datatype.RDF_XML_LITERAL.getURI().toString(), OWL2Datatype.RDF_XML_LITERAL.getShortName());		
			dataTypes.put(OWL2Datatype.XSD_INTEGER.getURI().toString(), OWL2Datatype.XSD_INTEGER.getShortName());
			dataTypes.put(OWL2Datatype.XSD_DECIMAL.getURI().toString(), OWL2Datatype.XSD_DECIMAL.getShortName());
			dataTypes.put(OWL2Datatype.XSD_DATE_TIME.getURI().toString(), OWL2Datatype.XSD_DATE_TIME.getShortName());
			dataTypes.put(OWL2Datatype.XSD_BOOLEAN.getURI().toString(), OWL2Datatype.XSD_BOOLEAN.getShortName());

        } catch (Exception e) {
            log.error(e);
        }
	}
	
	public String getShowConceptTitleAs() {
		return showConceptTitleAs;
	}

	public void setShowConceptTitleAs(String showConceptTitleAs) {
		this.showConceptTitleAs = showConceptTitleAs;
		this.titleAsSet = showConceptTitleAs != null && !showConceptTitleAs.isEmpty();
	}

	public String getShowConceptTitleLanguageAs() {
		return showConceptTitleLanguageAs;
	}

	public void setShowConceptTitleLanguageAs(String showConceptTitleLanguageAs) {
		this.showConceptTitleLanguageAs = showConceptTitleLanguageAs;
		this.titleLanguageAsSet = showConceptTitleLanguageAs != null && !showConceptTitleLanguageAs.isEmpty();
	}
	
	public SKOSDataFactory getFactory() {
		return skosFactory;
	}

	private AddAssertion skos_addDataType(SKOSDataset dataset, SKOSDataFactory factory, SKOSConceptScheme scheme, String type, String value) {
		URI uri = URI.create(dataset.getURI() + "#" + type);
        SKOSDataProperty d = factory.getSKOSDataProperty(uri);
        SKOSDataRelationAssertion s = factory.getSKOSDataRelationAssertion(scheme, d, value);
		return new AddAssertion(dataset, s);
	}
	
	/**
	 *	Tree nodes
	 */

	public void addSchemeToProject(String schemeName, String schemeURL) {
//		String baseURI = "file://" + schemeURL + "#";
//		List<SKOSChange> addList = new ArrayList<SKOSChange>();
//		int count = 0;
//		for (SKOSDataset dataset : skosManager.getSKOSDataSets()) {
//			for (SKOSConcept concept : dataset.getSKOSConcepts()) {
//				count++;
//				if (count == 1) {
//					scheme = skosFactory.getSKOSConceptScheme(URI.create(baseURI + "" + schemeName));
//					SKOSEntityAssertion schemaAss = skosFactory.getSKOSEntityAssertion(scheme);
//					addList.add(new AddAssertion(dataset, schemaAss));
//				}
//				if (concept.getURI().getAuthority() == null) {
//					baseURI = "http://" + concept.getURI() + "/resource#";
//				}
//				SKOSObjectRelationAssertion inScheme = skosFactory.getSKOSObjectRelationAssertion(concept, skosFactory.getSKOSInSchemeProperty(), scheme);
//				addList.add(new AddAssertion(dataset, inScheme));
//			}
//		}
//		try {
//			skosManager.applyChanges(addList);
//		} catch (SKOSChangeException e) {
//			log.error(e);
//		}
		List<SKOSChange> addList = new ArrayList<SKOSChange>();
		for (SKOSDataset dataset : skosManager.getSKOSDataSets()) {
			for (SKOSConcept concept : dataset.getSKOSConcepts()) {
				if (scheme == null) {
					List<SKOSAnnotation> annotations = getObjectAnnotations(concept);
					List<StringTriple> props = getObjectPropertiesAsTriple(concept, annotations);
					for (StringTriple obj : props) {
						if (obj.getProperty().equals(SKOSConstants.TYPE_INSCHEME)) {
							scheme = skosFactory.getSKOSConceptScheme(URI.create(obj.getObjectURI()));
							SKOSEntityAssertion schemaAss = skosFactory.getSKOSEntityAssertion(scheme);						
							addList.add(new AddAssertion(dataset, schemaAss));
							log.info("Notice: root element does not have an xml:base. Relative IRIs will be resolved against: " + obj.getObjectURI());
							break;
						}
					}
				}
				SKOSObjectRelationAssertion inScheme = skosFactory.getSKOSObjectRelationAssertion(concept, skosFactory.getSKOSInSchemeProperty(), scheme);
				addList.add(new AddAssertion(dataset, inScheme));
			}
		}
		try {
			skosManager.applyChanges(addList);
		} catch (SKOSChangeException e) {
			log.error(e);
		}
	}
	
	public void cleanupPropertiesAddedAsAnnotations() {
		SKOStoOWLConverter converter = new SKOStoOWLConverter();
		for (SKOSDataset dataset : skosManager.getSKOSDataSets()) {
			OWLOntology ont = converter.getAsOWLOntology(dataset);
			Set<OWLAxiom> topAxioms = ont.getReferencingAxioms(ont.getOWLOntologyManager().getOWLDataFactory().getOWLAnnotationProperty(SKOSVocabulary.HASTOPCONCEPT.getIRI()));
			for (OWLAxiom axiom : topAxioms) {
				if (axiom instanceof OWLAnnotationAssertionAxiom) {
					OWLAnnotationAssertionAxiom ax = (OWLAnnotationAssertionAxiom) axiom;
					OWLAnnotationSubject subject = ax.getSubject();
					OWLAnnotationValue value = ax.getValue();
					IRI subjectUri = null;
					IRI objectUri = null;
					if (subject instanceof IRI) {
						subjectUri = (IRI) subject;
					}
					if (value instanceof IRI) {
						objectUri = (IRI) value;
					}
					if (subjectUri != null && objectUri != null) {
						ont.getOWLOntologyManager().applyChange(new RemoveAxiom(ont, axiom));
						SKOSObjectRelationAssertion assertion = skosFactory
								.getSKOSObjectRelationAssertion(skosFactory
										.getSKOSConcept(subjectUri.toURI()),
										skosFactory.getSKOSHasTopConceptProperty(),
										skosFactory.getSKOSConcept(objectUri
												.toURI()));
						SKOSObjectRelationAssertion reverseAssertion = skosFactory
								.getSKOSObjectRelationAssertion(skosFactory
										.getSKOSConcept(objectUri.toURI()),
										skosFactory.getSKOSTopConceptOfProperty(),
										skosFactory.getSKOSConcept(subjectUri
												.toURI()));
						try {
							skosManager.applyChange(new AddAssertion(dataset, assertion));
							skosManager.applyChange(new AddAssertion(dataset, reverseAssertion));
						} catch (SKOSChangeException e) {
							log.error(e);
						}
					}
				}
			}
	
			// broader and narrower
			Set<OWLAxiom> axioms = ont.getReferencingAxioms(ont
					.getOWLOntologyManager().getOWLDataFactory()
					.getOWLAnnotationProperty(SKOSVocabulary.BROADER.getIRI()));
			for (OWLAxiom axiom : axioms) {
				if (axiom instanceof OWLAnnotationAssertionAxiom) {
					OWLAnnotationAssertionAxiom ax = (OWLAnnotationAssertionAxiom) axiom;
	
					OWLAnnotationSubject subject = ax.getSubject();
					OWLAnnotationValue value = ax.getValue();
	
					IRI subjectUri = null;
					IRI objectUri = null;
					if (subject instanceof IRI) {
						subjectUri = (IRI) subject;
					}
					if (value instanceof IRI) {
						objectUri = (IRI) value;
					}
	
					if (subjectUri != null && objectUri != null) {
						ont.getOWLOntologyManager().applyChange(new RemoveAxiom(ont, axiom));
						// broader assertion
						SKOSObjectRelationAssertion broader = skosFactory
								.getSKOSObjectRelationAssertion(skosFactory
										.getSKOSConcept(subjectUri.toURI()),
										skosFactory.getSKOSBroaderProperty(),
										skosFactory.getSKOSConcept(objectUri
												.toURI()));
						SKOSObjectRelationAssertion narrower = skosFactory
								.getSKOSObjectRelationAssertion(skosFactory
										.getSKOSConcept(objectUri.toURI()),
										skosFactory.getSKOSNarrowerProperty(),
										skosFactory.getSKOSConcept(subjectUri
												.toURI()));
	
						try {
							skosManager.applyChange(new AddAssertion(dataset, broader));
							skosManager.applyChange(new AddAssertion(dataset, narrower));
						} catch (SKOSChangeException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
	}

	public SKOSConcept addTopConcept(String conceptStr, boolean isSilent) {
		conceptStr = conceptStr == null ? "" : conceptStr.replace(' ', '_');

		// find scheme
		String baseURI = "";
		SKOSEntity schemeEntity = null;
		if (scheme.getURI().toString().equals(schemeURI)) {
			baseURI = "http://" + scheme.getURI().getAuthority() + "/resource#";
			schemeEntity = scheme;
		}

		// add concept assertion
		SKOSConcept concept = skosFactory.getSKOSConcept(URI.create(baseURI + conceptStr));
		SKOSEntityAssertion conAss = skosFactory.getSKOSEntityAssertion(concept);
		// add inScheme assertion
		SKOSObjectRelationAssertion inScheme = skosFactory.getSKOSObjectRelationAssertion(concept, skosFactory.getSKOSInSchemeProperty(), schemeEntity);
		// add topConcept assertion
		SKOSObjectRelationAssertion topConcept = skosFactory.getSKOSObjectRelationAssertion(schemeEntity, skosFactory.getSKOSHasTopConceptProperty(), concept);
		// add topConcept assertion
		SKOSObjectRelationAssertion topConceptOf = skosFactory.getSKOSObjectRelationAssertion(concept, skosFactory.getSKOSTopConceptOfProperty(), schemeEntity);
		
		for (SKOSDataset dataset : skosManager.getSKOSDataSets()) {
			owlManager.getOWLDataFactory().getOWLNamedIndividual(IRI.create(SKOSVocabulary.getNamespace() + "/"+ conceptStr));

			List<SKOSChange> addList = new ArrayList<SKOSChange>();
			addList.add(new AddAssertion(dataset, conAss));
			addList.add(new AddAssertion(dataset, inScheme));
			addList.add(new AddAssertion(dataset, topConcept));
			addList.add(new AddAssertion(dataset, topConceptOf));
			
			try {
				skosManager.applyChanges(addList);
				
				treeBean.getRootNode().addChildNode(concept, "topConcept");
				
				if (!isSilent) {
					processFileChange("add-top-concept", conceptStr, "", "", "", "", 
							userName + " added top-concept <span class='history-concept'>" + conceptStr + "</span>", true);
				}
			} catch (SKOSChangeException e) {
				log.error(e);
			}
		}

		return concept;
	}
	
	public SKOSEntity getBaseEntity() {
		return scheme;//getConceptSchemes().get(0);
	}
	
	public String getBaseURI() {
		return "http://" + scheme.getURI().getAuthority();
	}
	
	public SKOSConcept addConcept(String conceptName, String parentId, boolean isSilent) {

		SKOSEntity schemeEntity = getBaseEntity();
		String baseURI = getBaseURI() + "/resource#";

		// add concept assertion
		SKOSConcept concept = skosFactory.getSKOSConcept(URI.create(baseURI + conceptName));
		SKOSConcept parent = skosFactory.getSKOSConcept(URI.create(parentId));
		SKOSEntityAssertion conAss = skosFactory.getSKOSEntityAssertion(concept);
		// add inScheme assertion
		SKOSObjectRelationAssertion inScheme = skosFactory.getSKOSObjectRelationAssertion(concept, skosFactory.getSKOSInSchemeProperty(), schemeEntity);
		//add narrower assertion
		SKOSObjectRelationAssertion narrower = skosFactory.getSKOSObjectRelationAssertion(parent, skosFactory.getSKOSNarrowerProperty(), concept);
		SKOSObjectRelationAssertion broader = skosFactory.getSKOSObjectRelationAssertion(concept, skosFactory.getSKOSBroaderProperty(), parent);
		
		for (SKOSDataset dataset : skosManager.getSKOSDataSets()) {
			owlManager.getOWLDataFactory().getOWLNamedIndividual(IRI.create(SKOSVocabulary.getNamespace() + "/"+ conceptName));

			List<SKOSChange> addList = new ArrayList<SKOSChange>();
			addList.add(new AddAssertion(dataset, conAss));
			addList.add(new AddAssertion(dataset, inScheme));
			addList.add(new AddAssertion(dataset, narrower));
			addList.add(new AddAssertion(dataset, broader));

			try {
				skosManager.applyChanges(addList);

				treeBean.findNodeByUri(parentId).addChildNode(concept, "concept");

				if (!isSilent) {
					processFileChange("add-concept", parentId, conceptName, "", "", "", 
							userName + " added concept <span class='history-concept'>" + conceptName + "</span>", true);
				}
			} catch (SKOSChangeException e) {
				log.error(e);
			}
		}
		return concept;
	}

	public void processFileChange(String updateType, String conceptURI, String value, String type, String type2, String lang, String details, boolean addToHistory) {
		// save history
//		log.info(details);
		if (addToHistory) {
			ObjectHistoryLocalServiceUtil.create(skosFileId, userId, updateType, conceptURI, value, type, type2, lang, details);
		}

		// notify collaborators
		try {
			for (SharedFile obj : SharedFileLocalServiceUtil.findByFile(skosFileId)) {
				long sharedBy = obj.getSharedBy();
				if (sharedBy != userId) {
					log.info("Notify " + UserLocalServiceUtil.getUser(sharedBy).getEmailAddress());
					SKOSCollaborationEntryLocalServiceUtil.create(skosFileId, sharedBy, updateType, conceptURI, value, type, type2, lang);	
				}
				long sharedWith = obj.getSharedWith();
				if (sharedWith != userId) {
					log.info("Notify " + UserLocalServiceUtil.getUser(sharedWith).getEmailAddress());
					SKOSCollaborationEntryLocalServiceUtil.create(skosFileId, sharedWith, updateType, conceptURI, value, type, type2, lang);	
				}
			}
		} catch (Exception e) {
			log.error(e);
		}
	}

	public void addNarrowerConcept(String conceptName, String parentConceptURI, boolean isSilent) {
		List<SKOSChange> addList = new ArrayList<SKOSChange>();
		for (SKOSDataset dataset : skosManager.getSKOSDataSets()) {
			for (SKOSConcept concept : dataset.getSKOSConcepts()) {
				if (concept.getURI().toString().equals(parentConceptURI)) {
					owlManager.getOWLDataFactory().getOWLNamedIndividual(IRI.create(SKOSVocabulary.getNamespace() + "/" + conceptName));
	
					// add concept assertion
					SKOSConcept child = skosFactory.getSKOSConcept(URI.create(conceptName));
					SKOSEntityAssertion conAss = skosFactory.getSKOSEntityAssertion(child);
					addList.add(new AddAssertion(dataset, conAss));
	
					// add SKOSNarrowerProperty assertion
					SKOSObjectRelationAssertionImpl ass = (SKOSObjectRelationAssertionImpl) skosFactory
							.getSKOSObjectRelationAssertion(concept,skosFactory.getSKOSNarrowerProperty(),child);
					addList.add(new AddAssertion(dataset, ass));
	
					// find scheme and add inScheme assertion
					for (SKOSConceptScheme scheme : dataset.getSKOSConceptSchemes()) {
						for (SKOSConcept conceptInScheme : dataset.getSKOSConcepts()) {
							if (conceptInScheme.getURI().equals(concept.getURI())) {
								SKOSObjectRelationAssertion inScheme = skosFactory.getSKOSObjectRelationAssertion(
												child,skosFactory.getSKOSInSchemeProperty(),scheme);
								addList.add(new AddAssertion(dataset, inScheme));
							}
						}
					}
				}
			}
		}

		try {
			skosManager.applyChanges(addList);

			if (!isSilent) {
				processFileChange("add-narrower-concept", parentConceptURI, conceptName, "", "", "", 
						userName + " added narrower concept <span class='history-concept'>" + conceptName + "</span>", true);
			}
		} catch (SKOSChangeException e) {
			log.error(e);
		} 
	}

	public void addBroaderConcept(String conceptStr, String parentConceptURI, boolean isSilent) {
		List<OWLOntologyChange> changes = new ArrayList<OWLOntologyChange>();

		SKOSConcept parent = skosFactory.getSKOSConcept(URI.create(parentConceptURI));
		SKOSConcept child = skosFactory.getSKOSConcept(URI.create(conceptStr));
		for (SKOSDataset dataset : skosManager.getSKOSDataSets()) {
			SKOSObjectRelationAssertionImpl ass = (SKOSObjectRelationAssertionImpl) skosFactory.getSKOSObjectRelationAssertion(child,skosFactory.getSKOSBroaderProperty(), parent);
			SKOStoOWLConverter converter = new SKOStoOWLConverter();
			OWLOntology ont = converter.getAsOWLOntology(dataset);
			changes.add(new AddAxiom(ont, ass.getAssertionAxiom()));
		}
		owlManager.applyChanges(changes);
		
		if (!isSilent) {
			processFileChange("add-broader-concept", parentConceptURI, conceptStr, "", "", "", 
					userName + " added broader concept <span class='history-concept'>" + conceptStr + "</span>", true);
		}
	}
	
	public List<SKOSEntity> getTopLevelConcepts(String conceptScheme) {
		List<SKOSEntity> skosEntities = new ArrayList<SKOSEntity>();
		
		for (SKOSDataset dataset : skosManager.getSKOSDataSets()) {
			skosEntities.addAll(dataset.getTopConcepts(scheme));
			for(SKOSConcept concept : dataset.getSKOSConcepts()) {
				if (!skosEntities.contains(concept)) {
					if (!hasObjectProperty(concept, SKOSVocabulary.BROADER.getIRI().toURI())){
						skosEntities.add(concept);
					}
				}
			}
		}

		return skosEntities;
	}

	public boolean hasObjectProperty(SKOSEntity concept, URI propertyURI){
		boolean hasProperty = false;
		for (SKOSObjectRelationAssertion property : getObjectProperties(concept)){
			if (propertyURI.toString().equals(property.getSKOSProperty().getURI().toString())){
				hasProperty = true;
			}
		}		
		return hasProperty;
	}
//	
//	public List<SKOSEntity> getLooseConcepts(String conceptScheme) {
//		List<SKOSEntity> skosEntities = new ArrayList<SKOSEntity>();
//		List<SKOSEntity> topConcepts = getTopLevelConcepts(conceptScheme);		
//		for (SKOSEntity concept : getAllConcepts()) {
//			if (!topConcepts.contains(concept)){
//				if (!hasObjectProperty(concept, SKOSVocabulary.BROADER.getIRI().toURI())){
//					skosEntities.add(concept);
//				}
//			}
//		}
//		return skosEntities;
//	}
	
	public List<SKOSEntity> getAllConcepts() {
		List<SKOSEntity> concepts = new ArrayList<SKOSEntity>();
		for (SKOSDataset dataset : skosManager.getSKOSDataSets()) {
			concepts.addAll(dataset.getSKOSConcepts());
		}
		return concepts;
	}

	public void moveConcept(String concept, String oldParent, String newParent, boolean isSilent) {
		SKOSConcept child = skosFactory.getSKOSConcept(URI.create(concept));
		SKOSConcept fromParent = skosFactory.getSKOSConcept(URI.create(oldParent));
		SKOSConcept toParent = skosFactory.getSKOSConcept(URI.create(newParent));

		List<SKOSChange> changeList = new ArrayList<SKOSChange>();
		for (SKOSDataset dataset : skosManager.getSKOSDataSets()) {
			// add toParent as broader property of child
			SKOSObjectRelationAssertion addAss = skosFactory.getSKOSObjectRelationAssertion(child, skosFactory.getSKOSBroaderProperty(), toParent);
			changeList.add(new AddAssertion(dataset, addAss));
	
			// add inverse of above, meaning: add child as narrower property of toParent
			SKOSObjectRelationAssertion addNarrow = skosFactory.getSKOSObjectRelationAssertion(toParent, skosFactory.getSKOSNarrowerProperty(), child);
			changeList.add(new AddAssertion(dataset, addNarrow));
	
			// remove fromParent as broader property of child
			SKOSObjectRelationAssertion removeAss = skosFactory.getSKOSObjectRelationAssertion(child, skosFactory.getSKOSBroaderProperty(), fromParent);
			changeList.add(new RemoveAssertion(dataset, removeAss));
	
			// remove inverse of above, meaning: remove child as narrower property of fromParent
			SKOSObjectRelationAssertion removeNarrow = skosFactory.getSKOSObjectRelationAssertion(fromParent, skosFactory.getSKOSNarrowerProperty(), child);
			changeList.add(new RemoveAssertion(dataset, removeNarrow));
		}
		try {
			skosManager.applyChanges(changeList);
			
			if (!isSilent) {
				processFileChange("move-concept", concept, newParent, "", "", "", 
						userName + " moved concept <span class='history-concept'>" + treeBean.findNodeByUri(concept).getTitle() 
						+ "</span> to <span class='history-concept'>" + treeBean.findNodeByUri(newParent).getTitle() + "</span>", true);
			}
		} catch (SKOSChangeException e) {
			e.printStackTrace();
		}
	}
	
	public void moveToTopConcept(String concept, String oldParent, String schemeStr, boolean isSilent) {
		SKOSConcept child = skosFactory.getSKOSConcept(URI.create(concept));
		SKOSConcept fromParent = skosFactory.getSKOSConcept(URI.create(oldParent));
		List<SKOSChange> changeList = new ArrayList<SKOSChange>();
		
		for (SKOSDataset dataset : skosManager.getSKOSDataSets()) {
			for (SKOSConceptScheme conceptScheme : dataset.getSKOSConceptSchemes()) {
				if (conceptScheme.getURI().toString().equals(schemeStr)){
					SKOSObjectRelationAssertion ass = skosFactory.getSKOSObjectRelationAssertion(child,skosFactory.getSKOSTopConceptOfProperty(),conceptScheme);
					changeList.add(new AddAssertion(dataset, ass));
					
					SKOSObjectRelationAssertion assReverse = skosFactory.getSKOSObjectRelationAssertion(conceptScheme,skosFactory.getSKOSHasTopConceptProperty(),child);
					changeList.add(new AddAssertion(dataset, assReverse));
				}								
			}			
	
			//remove fromParent as broader property of child
			SKOSObjectRelationAssertion removeAss = skosFactory.getSKOSObjectRelationAssertion(child,skosFactory.getSKOSBroaderProperty(),fromParent);
			changeList.add(new RemoveAssertion(dataset, removeAss));
			
			//remove inverse of above, meaning: remove child as narrower property of fromParent
			SKOSObjectRelationAssertion removeNarrow = skosFactory.getSKOSObjectRelationAssertion(fromParent,skosFactory.getSKOSNarrowerProperty(),child);
			changeList.add(new RemoveAssertion(dataset, removeNarrow));
		}
		
		try {
			skosManager.applyChanges(changeList);
			
			if (!isSilent) {
				processFileChange("move-concept-to-top", concept, concept, "", "", "", 
						userName + " moved concept <span class='history-concept'>" + treeBean.findNodeByUri(concept).getTitle() 
						+ "</span> to <span class='history-concept'>" + treeBean.getRootNode().getTitle() + "</span>", true);
			}
		} catch (SKOSChangeException e) {
			log.error(e);
		}
	}

	public void moveFromTopConcept(String concept, String newParent, String schemeStr, boolean isSilent) {
		SKOSConcept child = skosFactory.getSKOSConcept(URI.create(concept));
		SKOSConcept toParent = skosFactory.getSKOSConcept(URI.create(newParent));
		List<SKOSChange> changeList = new ArrayList<SKOSChange>();
		
		for (SKOSDataset dataset : skosManager.getSKOSDataSets()) {
			for (SKOSConceptScheme conceptScheme : dataset.getSKOSConceptSchemes()) {
				if (conceptScheme.getURI().toString().equals(schemeStr)){
					SKOSObjectRelationAssertion removeAss = skosFactory.getSKOSObjectRelationAssertion(child,skosFactory.getSKOSTopConceptOfProperty(),conceptScheme);
					changeList.add(new RemoveAssertion(dataset, removeAss));					
					SKOSObjectRelationAssertion removeAssReverse = skosFactory.getSKOSObjectRelationAssertion(conceptScheme, skosFactory.getSKOSHasTopConceptProperty(), child);
					changeList.add(new RemoveAssertion(dataset, removeAssReverse));
				}
			}
	
			//add toParent as broader property of child
			SKOSObjectRelationAssertion addAss = skosFactory.getSKOSObjectRelationAssertion(child,skosFactory.getSKOSBroaderProperty(),toParent);
			changeList.add(new AddAssertion(dataset, addAss));
			
			//add inverse of above, meaning: add child as narrower property of toParent
			SKOSObjectRelationAssertion addNarrow = skosFactory.getSKOSObjectRelationAssertion(toParent,skosFactory.getSKOSNarrowerProperty(),child);
			changeList.add(new AddAssertion(dataset, addNarrow));
		}
		
		try {
			skosManager.applyChanges(changeList);
			
			if (!isSilent) {
				processFileChange("move-concept-from-top", concept, newParent, "", "", "", 
						userName + " moved concept <span class='history-concept'>" + treeBean.findNodeByUri(concept).getTitle() 
						+ "</span> to <span class='history-concept'>" + treeBean.findNodeByUri(newParent).getTitle() + "</span>", true);
			}
		} catch (SKOSChangeException e) {
			log.error(e);
		}
	}
	
	public void renameConcept(String conceptStr, String newName, boolean isSilent) {
		try {
			SKOSConcept concept = skosFactory.getSKOSConcept(URI.create(conceptStr));		
			String baseURI = "http://"+ URI.create(conceptStr).getAuthority()+ "/resource#";
			for (SKOSDataset dataset : skosManager.getSKOSDataSets()) {
				SKOStoOWLConverter converter = new SKOStoOWLConverter();
				OWLOntology ontology = converter.getAsOWLOntology(dataset);
				OWLEntityRenamer renamer = new OWLEntityRenamer(owlManager, Collections.singleton(ontology));
				renamer.changeIRI(converter.getAsOWLIndiviudal(concept).getIRI(), IRI.create(baseURI + newName));
				owlManager.applyChanges(renamer.changeIRI(converter.getAsOWLIndiviudal(concept).getIRI(), IRI.create(baseURI + newName)));
			}
			
			String info = userName + " renamed concept <span class='history-concept'>" + treeBean.findNodeByUri(conceptStr).getTitle() 
					+ "</span> to <span class='history-concept'>" + newName + "</span>";
			
			treeBean.findNodeByUri(conceptStr).rename(newName);
	
			if (!isSilent) {
				processFileChange("rename-concept", conceptStr, newName, "", "", "", info, true);
			}
		} catch (Exception e) {
		}
	}

	public void renameScheme(String newName, boolean isSilent) {
		for (SKOSDataset dataset : skosManager.getSKOSDataSets()) {
			SKOStoOWLConverter converter = new SKOStoOWLConverter();
			OWLOntology ontology = converter.getAsOWLOntology(dataset);
			OWLEntityRenamer renamer = new OWLEntityRenamer(owlManager, Collections.singleton(ontology));
			owlManager.applyChanges(renamer.changeIRI(converter.getAsOWLIndiviudal(scheme).getIRI(), IRI.create(newName)));
			scheme = dataset.getSKOSConceptSchemes().iterator().next();
		}

		String info = userName + " renamed scheme <span class='history-scheme'>" + treeBean.getRootNode().getTitle() 
				+ "</span> to <span class='history-scheme'>" + getBrowserText(scheme) + "</span>";
		
		treeBean.getRootNode().rename(newName);

		if (!isSilent) {
			processFileChange("rename-scheme", "", newName, "", "", "", info, true);
		}
	}

	public void removeConcept(String conceptString, boolean isSilent) {
		try {
			// remove all children
			for (TreeNodeModel obj : treeBean.findNodeByUri(conceptString).getChildren()) {
				removeConcept(obj.getUri(), isSilent);
			}
			
			String info = userName + " removed concept <span class='history-concept'>" + treeBean.findNodeByUri(conceptString).getTitle() + "</span>";
			
			treeBean.removeNode(conceptString);
			
			for (SKOSDataset dataset : skosManager.getSKOSDataSets()) {
				SKOSEntity concept = skosFactory.getSKOSConcept(URI.create(conceptString));
				List<SKOSChange> addList = new ArrayList<SKOSChange>();
				SKOStoOWLConverter converter = new SKOStoOWLConverter();
				OWLOntology ont = converter.getAsOWLOntology(dataset);
				OWLEntityRemover remover = new OWLEntityRemover(owlManager, Collections.singleton(ont));
				skosManager.applyChanges(addList);
				converter.getAsOWLIndiviudal(concept).accept(remover);
				owlManager.applyChanges(remover.getChanges());
			}

			if (!isSilent) {
				processFileChange("remove-concept", conceptString, "", "", "", "", info, true);
			}
		} catch (SKOSChangeException e) {
			log.error(e);
		}
	}

	/**
	 *	Labels
	 */
	
	public void addDataPropertyPreferredLabel(String conceptStr, String propValue, String prefLabelLang, String prefLabelType) {
		SKOStoOWLConverter converter = new SKOStoOWLConverter();
		for (SKOSDataset dataset : skosManager.getSKOSDataSets()) {
			OWLOntology ont = converter.getAsOWLOntology(dataset);
			OWLNamedIndividual concept = converter.getAsOWLIndiviudal(skosFactory.getSKOSConcept(URI.create(conceptStr)));
			OWLDataProperty prop = owlManager.getOWLDataFactory().getOWLDataProperty(SKOSVocabulary.PREFLABEL.getIRI());
			OWLLiteral literal;
			if (prefLabelLang != null && !prefLabelLang.isEmpty()) {
				literal = owlManager.getOWLDataFactory().getOWLLiteral(propValue, prefLabelLang);
			} else if (prefLabelType.length() > 0) {
				OWLDatatype dataType = owlManager.getOWLDataFactory().getOWLDatatype(IRI.create(SKOSVocabulary.getNamespace() + prefLabelType));
				literal = owlManager.getOWLDataFactory().getOWLLiteral(propValue, dataType);
			} else {
				literal = owlManager.getOWLDataFactory().getOWLLiteral(propValue, OWL2Datatype.XSD_STRING);
			}
			OWLAxiom ax = owlManager.getOWLDataFactory().getOWLDataPropertyAssertionAxiom(prop, concept, literal);
			owlManager.addAxiom(ont, ax);
			owlManager.applyChange(new AddAxiom(ont, ax));
		}
	}
	
	public void addDataPropertyAlternateLabel(String conceptStr, String propValue, String lang, String type) {
		SKOStoOWLConverter converter = new SKOStoOWLConverter();
		for (SKOSDataset dataset : skosManager.getSKOSDataSets()) {
			OWLOntology ont = converter.getAsOWLOntology(dataset);
			OWLNamedIndividual concept = converter.getAsOWLIndiviudal(skosFactory.getSKOSConcept(URI.create(conceptStr)));
			OWLDataProperty prop = owlManager.getOWLDataFactory().getOWLDataProperty(SKOSVocabulary.ALTLABEL.getIRI());
			OWLLiteral literal;
			if (lang != null && !lang.isEmpty()) {
				literal = owlManager.getOWLDataFactory().getOWLLiteral(propValue, lang);
			} else if (type.length() > 0) {
				OWLDatatype dataType = owlManager.getOWLDataFactory().getOWLDatatype(IRI.create(SKOSVocabulary.getNamespace() + type));
				literal = owlManager.getOWLDataFactory().getOWLLiteral(propValue, dataType);
			} else {
				literal = owlManager.getOWLDataFactory().getOWLLiteral(propValue, OWL2Datatype.XSD_STRING);
			}
			OWLAxiom ax = owlManager.getOWLDataFactory().getOWLDataPropertyAssertionAxiom(prop, concept, literal);
			owlManager.addAxiom(ont, ax);
			owlManager.applyChange(new AddAxiom(ont, ax));
		}
	}

	public void addDataPropertyOtherDataProperty(String conceptStr, String propStr, String propValue, String lang, String type) {
		SKOStoOWLConverter converter = new SKOStoOWLConverter();
		for (SKOSDataset dataset : skosManager.getSKOSDataSets()) {
			OWLOntology ont = converter.getAsOWLOntology(dataset);
			OWLNamedIndividual concept = converter.getAsOWLIndiviudal(skosFactory.getSKOSConcept(URI.create(conceptStr)));
			OWLDataProperty prop = owlManager.getOWLDataFactory().getOWLDataProperty(IRI.create(propStr));
			OWLLiteral literal;
			if (lang != null && !lang.isEmpty()) {
				literal = owlManager.getOWLDataFactory().getOWLLiteral(propValue, lang);
			} else if (type.length() > 0) {
				OWLDatatype dataType = owlManager.getOWLDataFactory().getOWLDatatype(IRI.create(SKOSVocabulary.getNamespace() + type));
				literal = owlManager.getOWLDataFactory().getOWLLiteral(propValue, dataType);
			} else {
				literal = owlManager.getOWLDataFactory().getOWLLiteral(propValue, OWL2Datatype.XSD_STRING);
			}
			OWLAxiom ax = owlManager.getOWLDataFactory().getOWLDataPropertyAssertionAxiom(prop, concept, literal);
			owlManager.addAxiom(ont, ax);
			owlManager.applyChange(new AddAxiom(ont, ax));
		}
	}
	
	public void addDataPropertyNotation(String conceptStr, String propValue, String lang, String type) {
		SKOStoOWLConverter converter = new SKOStoOWLConverter();
		for (SKOSDataset dataset : skosManager.getSKOSDataSets()) {
			OWLOntology ont = converter.getAsOWLOntology(dataset);
			OWLNamedIndividual concept = converter.getAsOWLIndiviudal(skosFactory.getSKOSConcept(URI.create(conceptStr)));
			OWLDataProperty prop = owlManager.getOWLDataFactory().getOWLDataProperty(SKOSVocabulary.NOTATION.getIRI());
			OWLLiteral literal;
			if (lang != null && !lang.isEmpty()) {
				literal = owlManager.getOWLDataFactory().getOWLLiteral(propValue, lang);
			} else if (type.length() > 0) {
				OWLDatatype dataType = owlManager.getOWLDataFactory().getOWLDatatype(IRI.create(SKOSVocabulary.getNamespace() + type));
				literal = owlManager.getOWLDataFactory().getOWLLiteral(propValue, dataType);
			} else {
				literal = owlManager.getOWLDataFactory().getOWLLiteral(propValue, OWL2Datatype.XSD_STRING);
			}
			OWLAxiom ax = owlManager.getOWLDataFactory().getOWLDataPropertyAssertionAxiom(prop, concept, literal);
			owlManager.addAxiom(ont, ax);
			owlManager.applyChange(new AddAxiom(ont, ax));
		}
	}
	
	public void addDataPropertyHiddenLabel(String conceptStr, String propValue, String lang, String type) {
		SKOStoOWLConverter converter = new SKOStoOWLConverter();
		for (SKOSDataset dataset : skosManager.getSKOSDataSets()) {
			OWLOntology ont = converter.getAsOWLOntology(dataset);
			OWLNamedIndividual concept = converter.getAsOWLIndiviudal(skosFactory.getSKOSConcept(URI.create(conceptStr)));
			OWLDataProperty prop = owlManager.getOWLDataFactory().getOWLDataProperty(SKOSVocabulary.HIDDENLABEL.getIRI());
			OWLLiteral literal;
			if (lang != null && !lang.isEmpty()) {
				literal = owlManager.getOWLDataFactory().getOWLLiteral(propValue, lang);
			} else if (type.length() > 0) {
				OWLDatatype dataType = owlManager.getOWLDataFactory().getOWLDatatype(IRI.create(SKOSVocabulary.getNamespace() + type));
				literal = owlManager.getOWLDataFactory().getOWLLiteral(propValue, dataType);
			} else {
				literal = owlManager.getOWLDataFactory().getOWLLiteral(propValue, OWL2Datatype.XSD_STRING);
			}
			OWLAxiom ax = owlManager.getOWLDataFactory().getOWLDataPropertyAssertionAxiom(prop, concept, literal);
			owlManager.addAxiom(ont, ax);
			owlManager.applyChange(new AddAxiom(ont, ax));
		}
	}
	
	public void removeLabel(long labelId) {
		try {
			SKOSPropertiesModel model = treeBean.getNode().getLabelById(labelId);
			String subjectStr = model.getSubjectURI();
			String propertyStr = model.getPropertyURI();
			String objectStr = model.getObjectURI();
			
			String annObjectStr = objectStr;
			String lang = model.getLang();
			if (lang != null && !lang.isEmpty()) {
				annObjectStr = "\"" + annObjectStr + "\"@" + lang;
			}
			
			for (SKOSDataset dataset : skosManager.getSKOSDataSets()) {
				SKOStoOWLConverter converter = new SKOStoOWLConverter();
				OWLOntology ont = converter.getAsOWLOntology(dataset);
				for (OWLAxiom ax : ont.getAxioms()) {
					if (ax instanceof OWLDataPropertyAssertionAxiom) {
						OWLDataPropertyAssertionAxiom  propAx = (OWLDataPropertyAssertionAxiom) ax;
						OWLLiteral object = propAx.getObject();
						String subject = propAx.getSubject().asOWLNamedIndividual().getIRI().toURI().toString();
						String prop = propAx.getProperty().asOWLDataProperty().getIRI().toURI().toString();
						String objectLiteral = object.getLiteral();
						if (prop.equals(propertyStr) && subject.equals(subjectStr) && objectLiteral.equals(objectStr)) {
							owlManager.applyChange(new RemoveAxiom(ont, ax));
						}
					} else if (ax instanceof OWLAnnotationAssertionAxiom) {
						OWLAnnotationAssertionAxiom propAx = (OWLAnnotationAssertionAxiom) ax;
						String prop = propAx.getProperty().asOWLAnnotationProperty().getIRI().toURI().toString().trim();
						String subject = propAx.getSubject().toString().trim();
						String objectLiteral = propAx.getValue().toString().trim();
						if (prop.equals(propertyStr) && subject.equals(subjectStr) && objectLiteral.equals(annObjectStr)) {
							owlManager.applyChange(new RemoveAxiom(ont, ax));
						}
					}
				}
			}
		} catch (Exception e) {
			log.error(e);
		}
	}
	
	/**
	 *	Assertions
	 */
	
	public void addObjectPropertyInscheme(String conceptStr, String schemeStr) {
		SKOSConcept concept = skosFactory.getSKOSConcept(URI.create(conceptStr));
		SKOSConceptScheme scheme = skosFactory.getSKOSConceptScheme(URI.create(schemeStr));
		List<SKOSChange> addList = new ArrayList<SKOSChange>();
		for (SKOSDataset dataset : skosManager.getSKOSDataSets()) {
			SKOSObjectRelationAssertion ass = skosFactory.getSKOSObjectRelationAssertion(concept,skosFactory.getSKOSInSchemeProperty(),scheme);
			addList.add(new AddAssertion(dataset, ass));	
		}
		try {
			skosManager.applyChanges(addList);
		} catch (SKOSChangeException e) {
			log.error(e);
		}
	}
	
	public void addObjectPropertyTopConceptOf(String conceptStr, String schemeStr) {
		SKOSConcept concept = skosFactory.getSKOSConcept(URI.create(conceptStr));
		SKOSConceptScheme scheme = skosFactory.getSKOSConceptScheme(URI.create(schemeStr));
		List<SKOSChange> addList = new ArrayList<SKOSChange>();
		for (SKOSDataset dataset : skosManager.getSKOSDataSets()) {
			SKOSObjectRelationAssertion ass = skosFactory.getSKOSObjectRelationAssertion(concept,skosFactory.getSKOSTopConceptOfProperty(),scheme);
			addList.add(new AddAssertion(dataset, ass));
			SKOSObjectRelationAssertion assReverse = skosFactory.getSKOSObjectRelationAssertion(scheme,skosFactory.getSKOSHasTopConceptProperty(),concept);
			addList.add(new AddAssertion(dataset, assReverse));
		}
		try {
			skosManager.applyChanges(addList);
		} catch (SKOSChangeException e) {
			log.error(e);
		}
	}
	
	public void addObjectPropertyBroadMatch(String conceptStr, String broadMatchStr) {
		SKOSConcept concept = skosFactory.getSKOSConcept(URI.create(conceptStr));
		SKOSConcept relatedConcept = skosFactory.getSKOSConcept(URI.create(broadMatchStr));
		List<SKOSChange> addList = new ArrayList<SKOSChange>();
		for (SKOSDataset dataset : skosManager.getSKOSDataSets()) {
			SKOSObjectRelationAssertion ass = skosFactory.getSKOSObjectRelationAssertion(concept,skosFactory.getSKOSBroadMatchProperty(),relatedConcept);
			addList.add(new AddAssertion(dataset, ass));
			SKOSObjectRelationAssertion ass2 = skosFactory.getSKOSObjectRelationAssertion(relatedConcept,skosFactory.getSKOSNarrowMatchProperty(),concept);
			addList.add(new AddAssertion(dataset, ass2));
		}
		try {
			skosManager.applyChanges(addList);
		} catch (SKOSChangeException e) {
			log.error(e);
		}
	}
	
	public void addObjectPropertyBroader(String conceptStr, String broaderStr) {
		SKOSConcept concept = skosFactory.getSKOSConcept(URI.create(conceptStr));
		SKOSConcept broaderConcept = skosFactory.getSKOSConcept(URI.create(broaderStr));
		List<SKOSChange> addList = new ArrayList<SKOSChange>();
		for (SKOSDataset dataset : skosManager.getSKOSDataSets()) {
			SKOSObjectRelationAssertion ass = skosFactory.getSKOSObjectRelationAssertion(concept,skosFactory.getSKOSBroaderProperty(),broaderConcept);
			addList.add(new AddAssertion(dataset, ass));
			SKOSObjectRelationAssertion ass2 = skosFactory.getSKOSObjectRelationAssertion(broaderConcept,skosFactory.getSKOSNarrowerProperty(),concept);
			addList.add(new AddAssertion(dataset, ass2));
		}
		try {
			skosManager.applyChanges(addList);
		} catch (SKOSChangeException e) {
			log.error(e);
		}
	}
	
	public void addObjectPropertyNarrower(String conceptStr, String narrowerStr) {
		SKOSConcept concept = skosFactory.getSKOSConcept(URI.create(conceptStr));
		SKOSConcept narrowerConcept = skosFactory.getSKOSConcept(URI.create(narrowerStr));
		List<SKOSChange> addList = new ArrayList<SKOSChange>();
		for (SKOSDataset dataset : skosManager.getSKOSDataSets()) {
			SKOSObjectRelationAssertion ass = skosFactory.getSKOSObjectRelationAssertion(concept, skosFactory.getSKOSNarrowerProperty(),narrowerConcept);
			addList.add(new AddAssertion(dataset, ass));
			SKOSObjectRelationAssertion ass2 = skosFactory.getSKOSObjectRelationAssertion(narrowerConcept, skosFactory.getSKOSBroaderProperty(),concept);
			addList.add(new AddAssertion(dataset, ass2));
		}
		try {
			skosManager.applyChanges(addList);
		} catch (SKOSChangeException e) {
			log.error(e);
		}
	}
	
	public void addObjectPropertyNarrowMatch(String conceptStr, String narrowMatchStr) {
		SKOSConcept concept = skosFactory.getSKOSConcept(URI.create(conceptStr));
		SKOSConcept relatedConcept = skosFactory.getSKOSConcept(URI.create(narrowMatchStr));
		List<SKOSChange> addList = new ArrayList<SKOSChange>();
		for (SKOSDataset dataset : skosManager.getSKOSDataSets()) {
			SKOSObjectRelationAssertion ass = skosFactory.getSKOSObjectRelationAssertion(concept,skosFactory.getSKOSNarrowMatchProperty(),relatedConcept);
			addList.add(new AddAssertion(dataset, ass));
	
			//add inverse
			SKOSObjectRelationAssertion ass2 = skosFactory.getSKOSObjectRelationAssertion(relatedConcept,skosFactory.getSKOSBroadMatchProperty(),concept);
			addList.add(new AddAssertion(dataset, ass2));
		}
		try {
			skosManager.applyChanges(addList);
		} catch (SKOSChangeException e) {
			log.error(e);
		} 
	}
	
	public void addObjectPropertyRelatedMatch(String conceptStr, String relatedMatchStr) {
		SKOSConcept concept = skosFactory.getSKOSConcept(URI.create(conceptStr));
		SKOSConcept relatedConcept = skosFactory.getSKOSConcept(URI.create(relatedMatchStr));

		List<SKOSChange> addList = new ArrayList<SKOSChange>();
		for (SKOSDataset dataset : skosManager.getSKOSDataSets()) {
			SKOSObjectRelationAssertion ass = skosFactory.getSKOSObjectRelationAssertion(concept,skosFactory.getSKOSRelatedMatchProperty(),relatedConcept);
			addList.add(new AddAssertion(dataset, ass));
			
			//add inverse
			SKOSObjectRelationAssertion ass2 = skosFactory.getSKOSObjectRelationAssertion(relatedConcept,skosFactory.getSKOSRelatedMatchProperty(),concept);
			addList.add(new AddAssertion(dataset, ass2));
		}
		try {
			skosManager.applyChanges(addList);
		} catch (SKOSChangeException e) {
			log.error(e);
		} 
	}
	
	public void addObjectPropertyExactMatch(String conceptStr, String exactMatchStr) {
		SKOSConcept concept = skosFactory.getSKOSConcept(URI.create(conceptStr));
		SKOSConcept exactConcept = skosFactory.getSKOSConcept(URI.create(exactMatchStr));

		List<SKOSChange> addList = new ArrayList<SKOSChange>();
		for (SKOSDataset dataset : skosManager.getSKOSDataSets()) {
			SKOSObjectRelationAssertion ass = skosFactory.getSKOSObjectRelationAssertion(concept,skosFactory.getSKOSExactMatchProperty(),exactConcept);
			addList.add(new AddAssertion(dataset, ass));
			
			//add inverse
			SKOSObjectRelationAssertion ass2 = skosFactory.getSKOSObjectRelationAssertion(exactConcept,skosFactory.getSKOSExactMatchProperty(),concept);
			addList.add(new AddAssertion(dataset, ass2));
		}
		try {
			skosManager.applyChanges(addList);
		} catch (SKOSChangeException e) {
			log.error(e);
		}
	}

	public void addObjectPropertyOther(String conceptStr, String propertyStr, String concept2Str) {
		SKOSConcept concept = skosFactory.getSKOSConcept(URI.create(conceptStr));
		SKOSConcept concept2 = skosFactory.getSKOSConcept(URI.create(concept2Str));

		List<SKOSChange> addList = new ArrayList<SKOSChange>();
		for (SKOSDataset dataset : skosManager.getSKOSDataSets()) {
			SKOSObjectProperty prop = skosFactory.getSKOSObjectProperty(URI.create(propertyStr));
			SKOSObjectRelationAssertion ass = skosFactory.getSKOSObjectRelationAssertion(concept,prop,concept2);
			addList.add(new AddAssertion(dataset, ass));
		}
		try {
			skosManager.applyChanges(addList);
		} catch (SKOSChangeException e) {
			log.error(e);
		}
	}

	public void addObjectPropertyRelated(String conceptStr, String relatedConceptStr) {
		SKOSConcept concept = skosFactory.getSKOSConcept(URI.create(conceptStr));
		SKOSConcept relatedConcept = skosFactory.getSKOSConcept(URI.create(relatedConceptStr));

		List<SKOSChange> addList = new ArrayList<SKOSChange>();
		for (SKOSDataset dataset : skosManager.getSKOSDataSets()) {
			SKOSObjectRelationAssertion ass = skosFactory.getSKOSObjectRelationAssertion(concept,skosFactory.getSKOSRelatedProperty(),relatedConcept);
			addList.add(new AddAssertion(dataset, ass));
			
			//add inverse
			SKOSObjectRelationAssertion ass2 = skosFactory.getSKOSObjectRelationAssertion(relatedConcept,skosFactory.getSKOSRelatedProperty(),concept);
			addList.add(new AddAssertion(dataset, ass2));
		}
		try {
			skosManager.applyChanges(addList);
		} catch (SKOSChangeException e) {
			log.error(e);
		}
	}
	
	public void removeAssertion(long assertionId) {
		try {
			SKOSPropertiesModel model = treeBean.getNode().getAssertionById(assertionId);
			String subjectStr = model.getSubjectURI();
			String propertyStr = model.getPropertyURI();
			String objectStr = model.getObjectURI();
			
			for (SKOSDataset dataset : skosManager.getSKOSDataSets()) {
				SKOStoOWLConverter converter = new SKOStoOWLConverter();
				OWLOntology ont = converter.getAsOWLOntology(dataset);
				for (OWLAxiom ax : ont.getAxioms()) {
					if (ax instanceof OWLObjectPropertyAssertionAxiom) {
						OWLObjectPropertyAssertionAxiom propAx = (OWLObjectPropertyAssertionAxiom) ax;
						String property = propAx.getProperty().asOWLObjectProperty().getIRI().toURI().toString().trim();
						String subject = propAx.getSubject().asOWLNamedIndividual().getIRI().toURI().toString().trim();
						String object = propAx.getObject().asOWLNamedIndividual().getIRI().toURI().toString().trim();
						if (property.equals(propertyStr) && subject.equals(subjectStr) && object.equals(objectStr)) {
							owlManager.applyChange(new RemoveAxiom(ont, ax));
						}
					} else if (ax instanceof OWLAnnotationAssertionAxiom) {
						OWLAnnotationAssertionAxiom propAx = (OWLAnnotationAssertionAxiom) ax;
						String prop = propAx.getProperty().asOWLAnnotationProperty().getIRI().toURI().toString().trim();
						String subject = propAx.getSubject().toString().trim();
						String objectLiteral = propAx.getValue().toString().trim();
						if (prop.equals(propertyStr) && subject.equals(subjectStr) && objectLiteral.equals(objectStr)) {
							owlManager.applyChange(new RemoveAxiom(ont, ax));
						}
					}
				}
			}
		} catch (Exception e) {
			log.error(e);
		}
	}

	public String getBrowserText(String entityURI) {
		return shortFormProvider.getShortForm(IRI.create(entityURI));
	}
	
	public String getBrowserText(SKOSEntity entity) {
		String s = "";
		try {
			s = getBrowserText(entity.getURI().toString());
		} catch (Exception e) {
		}
		return s;
	}

	public List<SKOSEntity> getChildren(SKOSEntity entity) {
		List<SKOSEntity> skosEntities = new ArrayList<SKOSEntity>();
		List<SKOSAnnotation> annotations = getObjectAnnotations(entity);
		for (StringTriple obj : getObjectPropertiesAsTriple(entity, annotations)) {
			if (obj.getProperty().equals("narrower")) {
				SKOSEntity childEntity = skosFactory.getSKOSConcept(URI.create(obj.getObjectURI()));
				skosEntities.add(childEntity);
			}
		}
//		List<SKOSEntity> skosEntities = new ArrayList<SKOSEntity>();
//		SKOSConcept concept = skosFactory.getSKOSConcept(URI.create(conceptName));
//		for (SKOSDataset dataset : skosManager.getSKOSDataSets()) {
//			SKOSNarrowerProperty skosNarrowerProperty = skosFactory.getSKOSNarrowerProperty();
//			for (SKOSEntity narrowerConcept : concept.getSKOSRelatedEntitiesByProperty(dataset, skosNarrowerProperty)) {
//				skosEntities.add(narrowerConcept);
//			}
//		}
		return skosEntities;
	}
	
	public String getTopConceptURI() {
		return schemeURI;
	}

	public List<SKOSDataRelationAssertion> getDataProperties(SKOSEntity entity) {
		List<SKOSDataRelationAssertion> properties = new ArrayList<SKOSDataRelationAssertion>();
//		for (SKOSDataset dataset : skosManager.getSKOSDataSets()) {
//			if (scheme.getURI().toString().equals(uri)) {
//				for (SKOSDataRelationAssertion assertion : dataset.getSKOSDataRelationAssertions(scheme)) {
//					properties.add(assertion);
//				}
//			} else {
//				SKOSConcept concept = skosFactory.getSKOSConcept(URI.create(uri));
//				for (SKOSDataRelationAssertion assertion : dataset.getSKOSDataRelationAssertions(concept)) {
//					properties.add(assertion);
//				}
//			}
//		}
		for (SKOSDataset dataset : skosManager.getSKOSDataSets()) {
			for (SKOSDataRelationAssertion assertion : dataset.getSKOSDataRelationAssertions(entity)) {
				properties.add(assertion);
			}
		}
		return properties;
	}

	public Map<String, String> getDataTypes() {
		return dataTypes;
	}
	
	public List<StringTriple> getDataPropertiesAsTriple(SKOSEntity entity, List<SKOSAnnotation> annotations) {
		List<StringTriple> triples = new ArrayList<StringTriple>();
		Set<String> usedNames = new HashSet<String>();
		String uri = entity.getURI().toString();
	    for (SKOSDataRelationAssertion prop : getDataProperties(entity)) {
	        StringTriple triple = new StringTriple();
	        triple.setSubject(prop.getSKOSSubject().getURI().getFragment());
	        triple.setSubjectURI(prop.getSKOSSubject().getURI().toString());

	        SKOSLiteral literal = prop.getSKOSObject();
	        String object = literal.getLiteral();
	        triple.setObjectURI(object);

	        String property = "";
	        String lang = "";
	        String type = "";

	        if (literal.isTyped()) {
	          property = prop.getSKOSProperty().getURI().getFragment();
	          triple.setPropertyURI(prop.getSKOSProperty().getURI().toString());

	          SKOSTypedLiteral typedLiteral = literal.getAsSKOSTypedLiteral();
	          type = typedLiteral.getDataType().getURI().getFragment();
	          triple.setTypeURI(typedLiteral.getDataType().getURI().toString());
	          triple.setType(type);

	        } else { 
	        	property = prop.getSKOSProperty().getURI().getFragment();
	        	triple.setPropertyURI(prop.getSKOSProperty().getURI().toString());
	        	// if it has language
	        	SKOSUntypedLiteral untypedLiteral = literal.getAsSKOSUntypedLiteral();
	        	if (untypedLiteral.hasLang()) {
	        		lang = untypedLiteral.getLang();
	        		triple.setLang(lang);
	        	}
	        	if (prop.getSKOSProperty().getURI().getFragment() == null || prop.getSKOSProperty().getURI().getFragment().equals("")) {
	        		SKOStoOWLConverter converter = new SKOStoOWLConverter();
	        		property = converter.getAsOWLDataProperty(prop.getSKOSProperty()).asOWLDataProperty().getIRI().getFragment();
	        		triple.setPropertyURI(converter.getAsOWLDataProperty(prop.getSKOSProperty()).asOWLDataProperty().getIRI().toString());
	        	}

	        }

			triple.setProperty(property);
			triple.setObject(object);
			triple.setLang(lang);

			triples.add(triple);
			
			usedNames.add(object);
		}
	    
	    for (SKOSAnnotation ann : annotations) {
			String type = ann.getURI().getFragment();
			String lang = "";
			if (type == null 
					|| type.equals(SKOSConstants.TYPE_PREFLABEL)
					|| type.equals(SKOSConstants.TYPE_NOTATION)
					|| type.equals(SKOSConstants.TYPE_ALTLABEL) 
					|| type.equals(SKOSConstants.TYPE_HIDDENLABEL)) {
				String value = "";
				if (ann.isAnnotationByConstant()) {
					if (ann.getAnnotationValueAsConstant().isTyped()) {
	                    SKOSTypedLiteral con = ann.getAnnotationValueAsConstant().getAsSKOSTypedLiteral();
	                    value = con.getLiteral();
	                } else {
	                    SKOSUntypedLiteral con = ann.getAnnotationValueAsConstant().getAsSKOSUntypedLiteral();
	                    value = con.getLiteral();
	                    if (con.hasLang()) {
	                    	lang = con.getLang();
	                    }
	                }
				} else {
					value = ann.getAnnotationValue().getURI().getFragment();
				}
				if (usedNames.contains(value)) {
					continue;
				}
				
				StringTriple triple = new StringTriple();
				triple.setSubjectURI(uri);
				triple.setPropertyURI(ann.getURI().toString());
				triple.setObjectURI(value);
				triple.setSubject(uri);
				triple.setProperty(type == null ? "" : type);
				triple.setObject(value);
				triple.setLang(lang);
				triples.add(triple);
			}
		}

		return triples;
	}

	public List<SKOSObjectRelationAssertion> getObjectProperties(SKOSEntity entity) {
		List<SKOSObjectRelationAssertion> properties = new ArrayList<SKOSObjectRelationAssertion>();
//		if (scheme != null && scheme.getURI().toString().equals(uri)) {
//			for (SKOSDataset dataset : skosManager.getSKOSDataSets()) {
//				for (SKOSObjectRelationAssertion objectAssertion : dataset.getSKOSObjectRelationAssertions(scheme)) {
//					properties.add(objectAssertion);
//				}
//			}
//		} else {
//			SKOSConcept concept = skosFactory.getSKOSConcept(URI.create(uri));
//			for (SKOSDataset dataset : skosManager.getSKOSDataSets()) {
//				for (SKOSObjectRelationAssertion objectAssertion : dataset.getSKOSObjectRelationAssertions(concept)) {
//					properties.add(objectAssertion);
//				}
//			}
//		}
		// FIXME: possible recursion, try to catch !!!
		for (SKOSDataset dataset : skosManager.getSKOSDataSets()) {
			for (SKOSObjectRelationAssertion objectAssertion : dataset.getSKOSObjectRelationAssertions(entity)) {
				properties.add(objectAssertion);
			}
		}
		return properties;
	}
	
	public List<SKOSAnnotation> getObjectAnnotations(SKOSEntity entity) {
		List<SKOSAnnotation> list = new ArrayList<SKOSAnnotation>();
//		try {
//			if (scheme.getURI().toString().equals(uri)) {
//				for (SKOSDataset dataset : skosManager.getSKOSDataSets()) {
//					for (SKOSAnnotation ann : scheme.getSKOSAnnotations(dataset)) {
//						list.add(ann);
//					}
//				}
//			} else {
//				SKOSConcept concept = skosFactory.getSKOSConcept(URI.create(uri));
//				for (SKOSDataset dataset : skosManager.getSKOSDataSets()) {
//					for (SKOSAnnotation ann : concept.getSKOSAnnotations(dataset)) {
//						list.add(ann);
//					}
//				}
//			}
//		} catch (Exception e) {
//		}
		for (SKOSDataset dataset : skosManager.getSKOSDataSets()) {
			for (SKOSAnnotation ann : entity.getSKOSAnnotations(dataset)) {
				list.add(ann);
			}
		}
		return list;
	}

	public List<StringTriple> getObjectPropertiesAsTriple(SKOSEntity entity, List<SKOSAnnotation> annotations) {
		List<StringTriple> triples = new ArrayList<StringTriple>();
		Set<String> usedNames = new HashSet<String>();
		String uri = entity.getURI().toString();
		for (SKOSObjectRelationAssertion prop : getObjectProperties(entity)) {
			StringTriple triple = new StringTriple();
			
			String subject = prop.getSKOSSubject().getURI().toString();
			if (subject == null) {
				subject = uri;
			}
			triple.setSubjectURI(subject);

			URI propURI = prop.getSKOSProperty().getURI();
			triple.setPropertyURI(propURI.toString());
			triple.setObjectURI(prop.getSKOSObject().getURI().toString());
			triple.setSubject(prop.getSKOSSubject().getURI().getFragment());
			triple.setProperty(prop.getSKOSProperty().getURI().getFragment());
			
			String object = prop.getSKOSObject().getURI().getFragment();
			if (object == null) {
				try {
					object = getBrowserText(prop.getSKOSObject());
				} catch (Exception e) {
				}
			}
			triple.setObject(object);
			usedNames.add(object);
			
			triples.add(triple);
		}
		for (SKOSAnnotation ann : annotations) {
			String type = ann.getURI().getFragment();
			if (type != null && (type.equals(SKOSConstants.TYPE_RELATED)
					|| type.equals(SKOSConstants.TYPE_BROADER)
					|| type.equals(SKOSConstants.TYPE_NARROWER)
					|| type.equals(SKOSConstants.TYPE_INSCHEME)
					|| type.equals(SKOSConstants.TYPE_TOPCONCEPTOF))) {
				try {
					SKOSEntity annValue = ann.getAnnotationValue();
					String objectURI = annValue.getURI().toString();
					String value = getBrowserText(annValue);
					if (usedNames.contains(value)) {
						continue;
					}
					if (ann.isAnnotationByConstant()) {
						if (ann.getAnnotationValueAsConstant().isTyped()) {
		                    SKOSTypedLiteral con = ann.getAnnotationValueAsConstant().getAsSKOSTypedLiteral();
		                    value = con.getLiteral();
		                } else {
		                    SKOSUntypedLiteral con = ann.getAnnotationValueAsConstant().getAsSKOSUntypedLiteral();
		                    value = con.getLiteral();
		                }
					}
					
					StringTriple triple = new StringTriple();
					triple.setSubjectURI(uri);
					triple.setPropertyURI(ann.getURI().toString());
					triple.setObjectURI(objectURI);
					triple.setSubject(uri);
					triple.setProperty(type);
					triple.setObject(value);
					triples.add(triple);
				} catch (Exception e) {
					log.error(e);
				}
			}
		}
		return triples;
	}

	public void saveAsRDFXML(String filePath) {
		try {
//			filePath = "file://" + filePath; // LINUX
			filePath = filePath.replace("\\", "/");
			URI uri = URI.create(filePath);
			for (SKOSDataset dataset : skosManager.getSKOSDataSets()) {
				skosManager.save(dataset, SKOSFormatExt.RDFXML, uri);
			}
		} catch (Exception e) {
			log.error(e);
		}
	}

	public void saveAsRDFXML(URI uri) {
		try {
			for (SKOSDataset dataset : skosManager.getSKOSDataSets()) {
				skosManager.save(dataset, SKOSFormatExt.RDFXML, uri);
			}
		} catch (Exception e) {
			log.error(e);
		}
	}
	
	public <E extends Enum<E>> boolean isInEnum(String value, Class<E> enumClass) {
		for (E e : enumClass.getEnumConstants()) {
			if (e.name().equals(value)) {
				return true;
			}
		}
		return false;
	}
	
	public TreeBean getTreeBean() {
		return treeBean;
	}

	public void setTreeBean(TreeBean treeBean) {
		this.treeBean = treeBean;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}
	
	public String getUserName() {
		return userName;
	}

	public long getSkosFileId() {
		return skosFileId;
	}

	public void setSkosFileId(long skosFileId) {
		this.skosFileId = skosFileId;
	}

	public boolean isTitleAsSet() {
		return titleAsSet;
	}

	public void setTitleAsSet(boolean titleAsSet) {
		this.titleAsSet = titleAsSet;
	}

	public boolean isTitleLanguageAsSet() {
		return titleLanguageAsSet;
	}

	public void setTitleLanguageAsSet(boolean titleLanguageAsSet) {
		this.titleLanguageAsSet = titleLanguageAsSet;
	}

	public int getAccess() {
		return access;
	}

	public void setAccess(int access) {
		this.access = access;
	}
	
	public boolean hasFullAccess() {
		return access == 2;
	}
	
	public boolean hasEditAccess() {
		return access == 1;
	}
	
	public boolean hasReadAccess() {
		return access == 0;
	}
}