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
	TreeNodeModel node = treeBean.getRootNode();
	List<TreeNodeModel> children = node.getChildren();
%>

<div class="skos-node" style="margin-left: 15px;">
	<div class="skos-node-header selected-node">
		<span id='expand-node-1' class='expandNode' onclick='skos_ToggleNode(1); return false;' 
			<% if (children.isEmpty()) { %>style='visibility: hidden;'<%}%>></span>
		<span class='schema'></span>
		<a href='#' 
			id='selected-node-1'
			class='skos-node-title' 
			skos-node-id='1' 
			skos-node-uri='${treeBean.rootNode.uri}' 
			skos-node-parent-uri='' 
			skos-node-title='${treeBean.rootNode.title}'
			onclick='skos_OnClickNode(this); return false;'> 
				${treeBean.rootNode.title}
		</a>
	</div>
	<div id='tree-children-block-${treeBean.rootNode.id}' style='display: none;'>
	</div>
</div>

<div id='skos-dropdowns' style="display: none;">

	<select id="tree-schemes">
		<option value="${treeBean.rootNode.uri}">${treeBean.rootNode.title}</option>
	</select>
	
	<select id="tree-concepts">
		<option value=""></option>
		<c:forEach items="${treeBean.treeConcepts}" var="obj">
			<option value="${obj.value}">${obj.label}</option>
		</c:forEach>
	</select>
	
	<select id="tree-assertion-types">
		<option value=""></option>
		<c:forEach items="${treeBean.allObjectPropertyTypes}" var="obj">
			<option value="${obj.value}">${obj.label}</option>
		</c:forEach>
	</select>
	
	<select id="tree-label-types">
		<option value=""></option>
		<c:forEach items="${treeBean.types}" var="obj">
			<option value="${obj}">${obj}</option>
		</c:forEach>
	</select>
	
	<select id="tree-label-types-2">
		<option value=""></option>
		<c:forEach items="${treeBean.allDataPropertyTypes}" var="obj">
			<option value="${obj.value}">${obj.label}</option>
		</c:forEach>
	</select>
	
	<select id="tree-label-languages">
		<option value=""></option>
		<c:forEach items="${treeBean.languages}" var="obj">
			<option value="${obj}">${obj}</option>
		</c:forEach>
	</select>

</div>