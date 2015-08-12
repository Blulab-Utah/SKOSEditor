<%@ page contentType="text/html; charset=UTF-8" %>

<%@ page import="com.liferay.portal.kernel.util.*" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<portlet:defineObjects />
<liferay-theme:defineObjects />

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
