package edu.ucsd.nlp.service.impl;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import edu.ucsd.nlp.model.SharedFile;
import edu.ucsd.nlp.service.base.SharedFileLocalServiceBaseImpl;

/**
 * @author http://nlp-app.ucsd.edu
 * @see edu.ucsd.nlp.service.base.SharedFileLocalServiceBaseImpl
 * @see edu.ucsd.nlp.service.SharedFileLocalServiceUtil
 */
public class SharedFileLocalServiceImpl extends SharedFileLocalServiceBaseImpl {
	
	private static final Log log = LogFactoryUtil.getLog(SharedFileLocalServiceImpl.class);

	public SharedFile create(long skosFileId, long sharedBy, long sharedWith, int access) {
		SharedFile obj = null;
		try {
			long id = counterLocalService.increment();
			obj = createSharedFile(id);
			obj.setSkosFileId(skosFileId);
			obj.setSharedBy(sharedBy);
			obj.setSharedWith(sharedWith);
			obj.setSharedOn(Calendar.getInstance().getTime());
			obj.setStatus(0);
			obj.setAccess(access);
			obj = updateSharedFile(obj);
		} catch (Exception e) {
			log.error(e);
		}
		return obj;
	}

	public SharedFile updateStatus(long id, int status) {
		SharedFile obj = null;
		try {
			obj = sharedFilePersistence.fetchByPrimaryKey(id);
			obj.setStatus(status);
			obj = updateSharedFile(obj);
		} catch (Exception e) {
			log.error(e);
		}
		return obj;
	}
	
	public SharedFile updateAccess(long id, int access) {
		SharedFile obj = null;
		try {
			obj = sharedFilePersistence.fetchByPrimaryKey(id);
			obj.setAccess(access);
			obj = updateSharedFile(obj);
		} catch (Exception e) {
			log.error(e);
		}
		return obj;
	}
	
	public Set<SharedFile> findByFile(long skosFileId) {
		Set<SharedFile> set = new HashSet<SharedFile>();
		try {
			for (SharedFile obj : sharedFilePersistence.findByFile(skosFileId)) {
				set.add(obj);
			}
		} catch (Exception e) {
			log.error(e);
		}
		return set;
	}
	
	public SharedFile findByFileSharedWith(long skosFileId, long userId) {
		SharedFile obj = null;
		try {
			obj = sharedFilePersistence.findByFileSharedWith(skosFileId, userId);
		} catch (Exception e) {
		}
		return obj;
	}

	public Set<SharedFile> findBySharedBy(long userId) {
		Set<SharedFile> set = new HashSet<SharedFile>();
		try {
			for (SharedFile obj : sharedFilePersistence.findBySharedBy(userId)) {
				set.add(obj);
			}
		} catch (Exception e) {
			log.error(e);
		}
		return set;
	}

	public Set<SharedFile> findBySharedWith(long userId) throws Exception {
		Set<SharedFile> set = new HashSet<SharedFile>();
		try {
			for (SharedFile obj : sharedFilePersistence.findBySharedWith(userId)) {
				set.add(obj);
			}
		} catch (Exception e) {
			log.error(e);
		}
		return set;
	}
}