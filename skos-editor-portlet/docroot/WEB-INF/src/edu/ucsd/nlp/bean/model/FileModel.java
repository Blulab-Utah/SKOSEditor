package edu.ucsd.nlp.bean.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ListUtil;

import edu.ucsd.nlp.model.SKOSFile;
import edu.ucsd.nlp.service.SKOSFileLocalServiceUtil;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class FileModel {

	private static final Log log = LogFactoryUtil.getLog(FileModel.class);

	private List<SKOSFile> versions = new ArrayList<SKOSFile>();
	private SKOSFile model = null;
	private boolean shared = false;

	public FileModel(SKOSFile model, boolean shared) {
		this.model = model;
		this.shared = shared;
		try {
			versions = SKOSFileLocalServiceUtil.findByUserParent(model.getUserId(), model.getSkosFileId());
			List sorted = ListUtil.copy(versions);
			Collections.sort(sorted, new Comparator() {
				public int compare(Object a, Object b) {
					return (new Double(((SKOSFile) b).getVersion())).compareTo(new Double(((SKOSFile) a).getVersion()));
				}
			});
			versions = sorted;
			versions.add(model);
		} catch (Exception e) {
			log.error(e);
		}
	}

	public long getId() {
		return model == null ? -1 : model.getSkosFileId();
	}

	public String getName() {
		return model == null ? "" : model.getName();
	}

	public String getCreated() {
		return model == null ? "" : model.getCreatedFormatted();
	}

	public String getModified() {
		return model == null ? "" : model.getModifiedFormatted();
	}

	public List<SKOSFile> getVersions() {
		return versions;
	}

	public boolean isShared() {
		return shared;
	}
	
	public SKOSFile getModel() {
		return model;
	}
}