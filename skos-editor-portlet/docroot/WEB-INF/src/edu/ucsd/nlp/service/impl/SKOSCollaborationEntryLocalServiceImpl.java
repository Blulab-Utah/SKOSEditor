package edu.ucsd.nlp.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import edu.ucsd.nlp.model.SKOSCollaborationEntry;
import edu.ucsd.nlp.service.base.SKOSCollaborationEntryLocalServiceBaseImpl;

/**
 * @author http://nlp-app.ucsd.edu
 * @see edu.ucsd.nlp.service.base.SKOSCollaborationEntryLocalServiceBaseImpl
 * @see edu.ucsd.nlp.service.SKOSCollaborationEntryLocalServiceUtil
 */
public class SKOSCollaborationEntryLocalServiceImpl extends SKOSCollaborationEntryLocalServiceBaseImpl {

	private static final Log log = LogFactoryUtil.getLog(SKOSCollaborationEntryLocalServiceImpl.class);
	
	public SKOSCollaborationEntry create(long skosFileId, long userId,
			String updateType, String conceptURI, String value, String type,
			String type2, String lang) {
		SKOSCollaborationEntry obj = null;
		try {
			obj = createSKOSCollaborationEntry(getCounterLocalService().increment());
			obj.setSkosFileId(skosFileId);
			obj.setUserId(userId);
			obj.setUpdateType(updateType);
			obj.setConceptURI(conceptURI);
			obj.setValue(value);
			obj.setType(type);
			obj.setType2(type2);
			obj.setLang(lang);
			obj = updateSKOSCollaborationEntry(obj);
		} catch (Exception e) {
			log.error(e);
		}
		return obj;
	}

	public void removeByFileUser(long skosFileId, long userId) {
		try {
			getSKOSCollaborationEntryPersistence().removeByFileUser(skosFileId, userId);
		} catch (Exception e) {
			log.error(e);
		}
	}
	
	public List<SKOSCollaborationEntry> findByFileUser(long skosFileId, long userId) {
		List<SKOSCollaborationEntry> list = new ArrayList<SKOSCollaborationEntry>();
		try {
			list.addAll(getSKOSCollaborationEntryPersistence().findByFileUser(skosFileId, userId));
		} catch (Exception e) {
			log.error(e);
		}
		return list;
	}

}