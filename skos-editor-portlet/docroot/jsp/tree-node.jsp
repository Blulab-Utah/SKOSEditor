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
%>

<div id="skos-tree-node-<%= id %>" class="skos-node">
	<div class="skos-node-header">
		<span id='expand-node-<%= id %>' class='expandNode' onclick='skos_ToggleNode(<%= id %>); return false;' 
			<% if (children.isEmpty()) { %>style='visibility: hidden;'<%}%>></span>
		<span class='<%= node.getType() %>'></span>
		<a href='#' 
			id='selected-node-<%= id %>'
			class='skos-node-title' 
			skos-node-id='<%= id %>' 
			skos-node-parent-id='<%= node.getParentId() %>' 
			skos-node-uri='<%= node.getUri() %>' 
			skos-node-parent-uri='<%= node.getParentUri() %>' 
			skos-node-title='<%= node.getTitle() %>'
			onclick='skos_OnClickNode(this); return false;'> 
				<%= node.getTitle() %>
		</a>
	</div>
	<div id='tree-children-block-<%= id %>' style='display: none;'>
	</div>
</div>