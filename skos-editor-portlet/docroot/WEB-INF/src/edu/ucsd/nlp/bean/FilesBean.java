package edu.ucsd.nlp.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import edu.ucsd.nlp.bean.model.FileModel;
import edu.ucsd.nlp.model.SKOSFile;
import edu.ucsd.nlp.service.SKOSFileLocalServiceUtil;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class FilesBean implements Serializable {

	private static final long serialVersionUID = 2483662826713947293L;
	
	private static final Log log = LogFactoryUtil.getLog(FilesBean.class);
	
	private long userId = -1;
	private List<FileModel> objects = null;
	
	public FilesBean(long userId) {
		this.userId = userId;
	}

	public List<FileModel> getObjects() {
		if (objects == null) {
			try {
				objects = new ArrayList<FileModel>();
				for (SKOSFile f : SKOSFileLocalServiceUtil.findByUserParent(userId, 0)) {
					objects.add(new FileModel(f, false));
				}
				Collections.sort(objects, new Comparator() {
					public int compare(Object a, Object b) {
						return ((FileModel) a).getModel().getModified().compareTo(((FileModel) a).getModel().getModified());
					}
				});
			} catch (Exception e) {
				log.error(e);
			}
		}
		return objects;
	}
}