package edu.ucsd.nlp.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import edu.ucsd.nlp.NoSuchObjectHistoryException;
import edu.ucsd.nlp.model.ObjectHistory;
import edu.ucsd.nlp.service.base.ObjectHistoryLocalServiceBaseImpl;

/**
 * @author http://nlp-app.ucsd.edu
 * @see edu.ucsd.nlp.service.base.ObjectHistoryLocalServiceBaseImpl
 * @see edu.ucsd.nlp.service.ObjectHistoryLocalServiceUtil
 */
public class ObjectHistoryLocalServiceImpl extends ObjectHistoryLocalServiceBaseImpl {
	
	private static final Log log = LogFactoryUtil.getLog(ObjectHistoryLocalServiceImpl.class);
	
	private static final String LOCK = "lock";

	public ObjectHistory create(long skosFileId, long userId, String type,
			String conceptURI, String value, String objectType,
			String objectType2, String lang, String details) {
		ObjectHistory obj = null;
		try {
			obj = createObjectHistory(getCounterLocalService().increment());
			obj.setSkosFileId(skosFileId);
			obj.setUserId(userId);
			obj.setType(type);
			obj.setConceptURI(conceptURI);
			obj.setValue(value);
			obj.setObjectType(objectType);
			obj.setObjectType2(objectType2);
			obj.setLang(lang);
			obj.setDetails(details);
			obj.setRecorded(Calendar.getInstance().getTime());
			obj = updateObjectHistory(obj);
		} catch (Exception e) {
			log.error(e);
		}
		return obj;
	}
	
	public ObjectHistory createLock(long skosFileId, long userId, String conceptURI) {
		ObjectHistory obj = null;
		try {

			try {
				// remove previous lock
				getObjectHistoryPersistence().removeByFileUserType(skosFileId, userId, LOCK);
			} catch (NoSuchObjectHistoryException ex) {
			}

			// is already locked by someone
			if (!getObjectHistoryPersistence().findByFileTypeConceptURI(skosFileId, LOCK, conceptURI).isEmpty()) {
				return null;
			}

			// create new lock
			obj = create(skosFileId, userId, LOCK, conceptURI, "", "", "", "", "");
		} catch (Exception e) {
			log.error(e);
		}
		return obj;
	}

	public void removeByFile(long skosFileId) {
		try {
			getObjectHistoryPersistence().removeByFile(skosFileId);
		} catch (Exception e) {
			log.error(e);
		}
	}
	
	public List<ObjectHistory> findByFile(long skosFileId) {
		List<ObjectHistory> list = new ArrayList<ObjectHistory>();
		try {
			list.addAll(getObjectHistoryPersistence().findByFile(skosFileId));
		} catch (Exception e) {
			log.error(e);
		}
		return list;
	}
	
	public List<ObjectHistory> findByFileUser(long skosFileId, long userId) {
		List<ObjectHistory> list = new ArrayList<ObjectHistory>();
		try {
			list.addAll(getObjectHistoryPersistence().findByFileUser(skosFileId, userId));
		} catch (Exception e) {
			log.error(e);
		}
		return list;
	}
}