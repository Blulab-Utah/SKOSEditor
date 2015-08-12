package edu.ucsd.nlp.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.apache.struts.util.LabelValueBean;
import org.semanticweb.skos.SKOSEntity;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ListUtil;

import edu.ucsd.nlp.bean.model.TreeNodeModel;
import edu.ucsd.nlp.skos.SKOSProject;

public class TreeBean extends SKOSBean implements Serializable {

	private static final long serialVersionUID = 2483662826713947293L;
	
	private static final Log log = LogFactoryUtil.getLog(TreeBean.class);
	
	private long id = 1;
	private SKOSProject project = null;
	private List<TreeNodeModel> nodes = new ArrayList<TreeNodeModel>();
	private TreeNodeModel node = null;
	
	public TreeBean(SKOSProject project) {
		this.project = project;
		project.setTreeBean(this);
		initialize();
	}

	public long increment() {
		return id++;
	}

	public void initialize() {
		try {
			SKOSEntity entity = project.getBaseEntity();
			TreeNodeModel schemeNode = new TreeNodeModel(this, entity, "schema", null);
			nodes.add(schemeNode);

			String uri = entity.getURI().toString();
			List<SKOSEntity> topConcepts = project.getTopLevelConcepts(uri);
			for (SKOSEntity topConcept : topConcepts) {
				TreeNodeModel topConceptNode = new TreeNodeModel(this, topConcept, "topConcept", schemeNode);
				nodes.add(topConceptNode);
				uri = topConcept.getURI().toString();
				getChildrenRecursive(topConceptNode);
			}

			ListUtil.sort(nodes, new Comparator<TreeNodeModel>() {
				public int compare(TreeNodeModel e1, TreeNodeModel e2) {
					return e1.getTitle().compareTo(e2.getTitle());
				}
			});
		} catch (Exception e) {
			log.error(e);
		}
	}
	
	public void sort() {
		ListUtil.sort(nodes, new Comparator<TreeNodeModel>() {
			public int compare(TreeNodeModel e1, TreeNodeModel e2) {
				return e1.getTitle().compareTo(e2.getTitle());
			}
		});
	}
	
	private void getChildrenRecursive(TreeNodeModel parentConceptNode) {
		for (SKOSEntity obj : project.getChildren(parentConceptNode.getEntity())) {
			TreeNodeModel conceptNode = new TreeNodeModel(this, obj, "concept", parentConceptNode);
			nodes.add(conceptNode);
			getChildrenRecursive(conceptNode);
    	}
	}
	
	public List<TreeNodeModel> getNodes() {
		return nodes;
	}
	
	public TreeNodeModel getNode(long id) {
		for (TreeNodeModel obj : nodes) {
			if (obj.getId() == id) {
				return obj;
			}
		}
		return null;
	}

	public TreeNodeModel findNodeByUri(String uri) {
		for (TreeNodeModel obj : nodes) {
			if (obj.getUri().equals(uri)) {
				return obj;
			}
		}
		return null;
	}
	
	public void removeNode(String uri) {
		List<TreeNodeModel> filtered = new ArrayList<TreeNodeModel>();
		for (TreeNodeModel obj : nodes) {
			if (obj.getUri().equals(uri)) {
				for (TreeNodeModel child : obj.getChildren()) {
					removeNode(child.getUri());
				}
				continue;
			}
			filtered.add(obj);
		}
		nodes = new ArrayList<TreeNodeModel>(filtered);
	}

	public TreeNodeModel getRootNode() {
		return getNode(1);
	}

	public SKOSProject getProject() {
		return project;
	}

	public TreeNodeModel getNode() {
		return node;
	}

	public void setNode(long id) {
		node = null;
		for (TreeNodeModel obj : nodes) {
			if (obj.getId() == id) {
				node = obj;
				break;
			}
		}
	}

	public List<LabelValueBean> getTreeConcepts() {
		List<LabelValueBean> objects = new ArrayList<LabelValueBean>();
		for (TreeNodeModel obj : nodes) {
			if (obj.getType().equals("schema")) {
				continue;
			}
			objects.add(new LabelValueBean(obj.getTitle(), obj.getUri()));
		}
		ListUtil.sort(objects, new Comparator<LabelValueBean>() {
			public int compare(LabelValueBean e1, LabelValueBean e2) {
				return e1.getLabel().compareTo(e2.getLabel());
			}
		});
		return objects;
	}
}