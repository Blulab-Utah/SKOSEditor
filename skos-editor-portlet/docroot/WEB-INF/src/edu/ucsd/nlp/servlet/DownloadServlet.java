package edu.ucsd.nlp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;

import edu.ucsd.nlp.model.SKOSFile;
import edu.ucsd.nlp.service.SKOSFileLocalServiceUtil;

public class DownloadServlet extends HttpServlet {

	private static final long serialVersionUID = -8575875632410332820L;
	
	private static final Log log = LogFactoryUtil.getLog(DownloadServlet.class);

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		try {
			long skosFileId = ParamUtil.getLong(request, "id", -1);
			SKOSFile file = SKOSFileLocalServiceUtil.getSKOSFile(skosFileId);
			String filename = file.getName() + ".rdf";

			response.setContentType("application/octet-stream; charset=UTF-8");
			response.setHeader("Content-Disposition", "attachment;filename=\"" + filename + "\"");

			PrintWriter writer = response.getWriter();
			writer.write(file.getContents());
			writer.flush();
		} catch (Exception e) {
			log.error(e);
		}
	}
}
