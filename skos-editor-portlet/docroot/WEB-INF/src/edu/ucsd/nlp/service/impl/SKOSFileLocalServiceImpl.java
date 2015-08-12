package edu.ucsd.nlp.service.impl;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import edu.ucsd.nlp.model.SKOSFile;
import edu.ucsd.nlp.model.SharedFile;
import edu.ucsd.nlp.service.SharedFileLocalServiceUtil;
import edu.ucsd.nlp.service.base.SKOSFileLocalServiceBaseImpl;

/**
 * @author http://nlp-app.ucsd.edu
 * 
 * @see edu.ucsd.nlp.service.base.SKOSFileLocalServiceBaseImpl
 * @see edu.ucsd.nlp.service.SKOSFileLocalServiceUtil
 */
public class SKOSFileLocalServiceImpl extends SKOSFileLocalServiceBaseImpl {

	private static final Log log = LogFactoryUtil.getLog(SKOSFileLocalServiceImpl.class);

	public SKOSFile create(long userId, long parentId, String name, String contents) throws Exception {
		long id = counterLocalService.increment();
		SKOSFile obj = createSKOSFile(id);
		obj.setUserId(userId);
		obj.setCreated(Calendar.getInstance().getTime());
		obj.setModified(obj.getCreated());
		obj.setParentId(parentId);
		obj.setName(name);
		obj.setContents(contents);
		obj.setVersion(1.0);
		obj = updateSKOSFile(obj);
		return obj;
	}

	public SKOSFile update(long skosFileId, long modifiedBy, String contents) throws Exception {
		SKOSFile obj = null;
		try {
			obj = skosFilePersistence.fetchByPrimaryKey(skosFileId);
			
			long userId = obj.getUserId();
			long parentId = obj.getParentId() == 0 ? obj.getSkosFileId() : obj.getParentId();
			String name = obj.getName();
			double version = new BigDecimal(obj.getVersion() + 0.1).setScale(2, BigDecimal.ROUND_HALF_DOWN).doubleValue();
			
			obj = create(userId, parentId, name, contents);
			obj.setVersion(version);
			obj.setLastModifiedBy(modifiedBy);
			obj = updateSKOSFile(obj);

			// update related shared files
			long newId = obj.getSkosFileId();
			for (SharedFile obj2 : SharedFileLocalServiceUtil.findByFile(skosFileId)) {
				obj2.setSkosFileId(newId);
				SharedFileLocalServiceUtil.updateSharedFile(obj2);
			}
		} catch (Exception e) {
			log.error(e);
		}
		return obj;
	}

	public List<SKOSFile> findByUser(long userId) throws Exception {
		return skosFilePersistence.findByUser(userId);
	}
	
	public List<SKOSFile> findByUserParent(long userId, long parentId) throws Exception {
		return skosFilePersistence.findByUserParent(userId, parentId);
	}
}