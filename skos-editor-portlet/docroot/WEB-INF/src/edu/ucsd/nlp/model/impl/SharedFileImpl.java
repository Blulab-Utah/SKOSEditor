package edu.ucsd.nlp.model.impl;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;

import edu.ucsd.nlp.model.SKOSFile;
import edu.ucsd.nlp.service.SKOSFileLocalServiceUtil;

/**
 * @author http://nlp-app.ucsd.edu
 */
public class SharedFileImpl extends SharedFileBaseImpl {
	
	private static final long serialVersionUID = 98678756746345354L;
	
	private static final Log log = LogFactoryUtil.getLog(SharedFileImpl.class);

	public SharedFileImpl() {
	}
	
	public SKOSFile getFile() {
		SKOSFile obj = null;
		try {
			obj = SKOSFileLocalServiceUtil.getSKOSFile(getSkosFileId());
		} catch (Exception e) {
			log.error(e);
		}
		return obj;
	}
	
	public User getSharedWithUser() {
		User obj = null;
		try {
			obj = UserLocalServiceUtil.getUser(getSharedWith());
		} catch (Exception e) {
			log.error(e);
		}
		return obj;
	}
	
	public User getSharedByUser() {
		User obj = null;
		try {
			obj = UserLocalServiceUtil.getUser(getSharedBy());
		} catch (Exception e) {
			log.error(e);
		}
		return obj;
	}
}