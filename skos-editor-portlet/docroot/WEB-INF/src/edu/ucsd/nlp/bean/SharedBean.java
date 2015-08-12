package edu.ucsd.nlp.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import edu.ucsd.nlp.model.SharedFile;
import edu.ucsd.nlp.service.SharedFileLocalServiceUtil;

public class SharedBean implements Serializable {

	private static final long serialVersionUID = 2483662826713947293L;
	
	private static final Log log = LogFactoryUtil.getLog(SharedBean.class);
	
	private List<SharedFile> objects = null;
	private List<SharedFile> objects2 = null;

	public SharedBean(long userId) {
		try {
			objects = new ArrayList<SharedFile>();
			objects.addAll(SharedFileLocalServiceUtil.findBySharedBy(userId));
		} catch (Exception e) {
			log.error(e);
		}
		try {
			objects2 = new ArrayList<SharedFile>();
			objects2.addAll(SharedFileLocalServiceUtil.findBySharedWith(userId));
		} catch (Exception e) {
			log.error(e);
		}
	}

	public List<SharedFile> getObjects() {
		return objects;
	}
	
	public List<SharedFile> getObjects2() {
		return objects2;
	}
}