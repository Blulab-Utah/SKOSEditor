package edu.ucsd.nlp.portlet.module;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;

import edu.ucsd.nlp.bean.SharedBean;
import edu.ucsd.nlp.service.SharedFileLocalServiceUtil;

public class ShareModule extends SKOSModule {

	private static final Log log = LogFactoryUtil.getLog(ShareModule.class);

	public void process(ResourceRequest request, ResourceResponse response) {
		String action = ParamUtil.getString(request, "action", "");
		if (action.equals("load")) {
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			SharedBean bean = new SharedBean(themeDisplay.getUserId());
			processJSP(request, response, "/jsp/share-list.jsp", bean);
		} else if (action.equals("share")) {
			JSONObject json = JSONFactoryUtil.createJSONObject();
			try {
				ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
				String email = ParamUtil.getString(request, "email", "");
				long sharedWith = -1;
				try {
					sharedWith = UserLocalServiceUtil.getUserByEmailAddress(themeDisplay.getCompanyId(), email).getUserId();
				} catch (Exception e) {
					throw new Exception("Email address is not registered");
				}
				if (email.equals(themeDisplay.getUser().getEmailAddress())) {
					throw new Exception("Email address belongs to file owner");
				}
				long skosFileId = ParamUtil.getLong(request, "skosFileId", 0);
				long sharedBy = themeDisplay.getUserId();
				int access = ParamUtil.getInteger(request, "access", 0);
				SharedFileLocalServiceUtil.create(skosFileId, sharedBy, sharedWith, access);

				// send email notification
				// TODO: 

				json.put("message", "File successfully shared with " + email);
			} catch (Exception e) {
				json.put("error", e.getMessage());
			}
			writeJSON(request, response, json);
		} else if (action.equals("change-access")) {
			try {
				long skosFileId = ParamUtil.getLong(request, "skosFileId", 0);
				int access = ParamUtil.getInteger(request, "access", -2);
				if (access == -1) {
					SharedFileLocalServiceUtil.deleteSharedFile(skosFileId);
				} else {
					SharedFileLocalServiceUtil.updateAccess(skosFileId, access);
				}
			} catch (Exception e) {
				log.error(e);
			}
		}
	}
}