<%@ page contentType="text/html; charset=UTF-8" %>

<%@ page import="java.util.*" %>
<%@ page import="com.liferay.portal.kernel.util.*" %>
<%@ page import="edu.ucsd.nlp.bean.*" %>
<%@ page import="edu.ucsd.nlp.bean.model.*" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<portlet:defineObjects />
<liferay-theme:defineObjects />

<%
	TreeBean treeBean = (TreeBean) request.getAttribute("treeBean");
	long id = (Long) request.getAttribute("id");
	TreeNodeModel node = treeBean.getNode(id);
	List<TreeNodeModel> children = node.getChildren();

	for (TreeNodeModel child : children) {
%>
	<c:set var="treeBean" value="<%= treeBean %>" scope="request" />
	<c:set var="id" value="<%= child.getId() %>" scope="request" />
	<jsp:include page="/jsp/tree-node.jsp" />
<%
	}
%>