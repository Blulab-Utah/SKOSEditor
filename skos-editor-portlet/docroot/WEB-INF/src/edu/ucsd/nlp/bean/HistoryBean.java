package edu.ucsd.nlp.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ListUtil;

import edu.ucsd.nlp.model.ObjectHistory;
import edu.ucsd.nlp.model.SKOSCollaborationEntry;
import edu.ucsd.nlp.service.ObjectHistoryLocalServiceUtil;

public class HistoryBean implements Serializable {

	private static final long serialVersionUID = 2483662826713947293L;
	
	private static final Log log = LogFactoryUtil.getLog(HistoryBean.class);
	
	private List<ObjectHistory> objects = null;
	private List<SKOSCollaborationEntry> collaboration = new ArrayList<SKOSCollaborationEntry>();
	private List<ObjectHistory> locks = null;

	public HistoryBean(long skosFileId, List<SKOSCollaborationEntry> collaboration, long userId) {
		try {
			this.collaboration = collaboration == null ? new ArrayList<SKOSCollaborationEntry>() : collaboration;

			objects = new ArrayList<ObjectHistory>();
			if (skosFileId > 0) {
				List<ObjectHistory> history = ObjectHistoryLocalServiceUtil.findByFile(skosFileId);
				for (ObjectHistory obj : history) {
					if (!obj.getType().equals("lock")) {
						objects.add(obj);
					}
				}
				ListUtil.sort(objects, new Comparator<ObjectHistory>() {
					public int compare(ObjectHistory obj1, ObjectHistory obj2) {
						int p = 0;
						try {
							p = obj2.getRecorded().compareTo(obj1.getRecorded());
						} catch (Exception e) {
						}
						return p;
					}
				});
				objects = ListUtil.subList(objects, 0, 100);
				
				locks = new ArrayList<ObjectHistory>();
				for (ObjectHistory obj : history) {
					if (obj.getType().equals("lock") && obj.getUserId() != userId) {
						locks.add(obj);
					}
				}
			}
		} catch (Exception e) {
			log.error(e);
		}
	}
	
	public List<ObjectHistory> getObjects() {
		return objects;
	}
	
	public List<SKOSCollaborationEntry> getCollaboration() {
		return collaboration;
	}
	
	public List<ObjectHistory> getLocks() {
		return locks;
	}
}