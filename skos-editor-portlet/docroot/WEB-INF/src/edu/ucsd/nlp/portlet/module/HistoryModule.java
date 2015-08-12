package edu.ucsd.nlp.portlet.module;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.portal.kernel.util.ParamUtil;

import edu.ucsd.nlp.bean.HistoryBean;
import edu.ucsd.nlp.skos.SKOSProject;

public class HistoryModule extends SKOSModule {
	
	public void process(SKOSProject project, ResourceRequest request, ResourceResponse response) {
		String action = ParamUtil.getString(request, "action", "");
		if (action.equals("load")) {
			HistoryBean bean = new HistoryBean(project.getSkosFileId(), null, project.getUserId());
			processJSP(request, response, "/jsp/history.jsp", bean);
		}
	}
}