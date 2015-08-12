package edu.ucsd.nlp.model.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.service.UserLocalServiceUtil;

/**
 * @author http://nlp-app.ucsd.edu
 */
public class SKOSFileImpl extends SKOSFileBaseImpl {

	private static final long serialVersionUID = -8088390503538460401L;
	
	private static final Log log = LogFactoryUtil.getLog(SKOSFileImpl.class);

	private static final DateFormat DF = new SimpleDateFormat("MM/dd/yyyy HH:mm a");
	
	public SKOSFileImpl() {
	}
	
	public String getCreatedFormatted() {
		String s = "";
		try {
			s = DF.format(getCreated());
		} catch (Exception e) {
			log.error(e);
		}
		return s;
	}
	
	public String getModifiedFormatted() {
		String s = "";
		try {
			s = DF.format(getModified());
		} catch (Exception e) {
			log.error(e);
		}
		return s;
	}
	
	public String getModifiedByUser() {
		String s = "";
		try {
			s = UserLocalServiceUtil.getUser(getLastModifiedBy()).getFullName();
		} catch (Exception e) {
			s = "N/A";
		}
		return s;
	}
}