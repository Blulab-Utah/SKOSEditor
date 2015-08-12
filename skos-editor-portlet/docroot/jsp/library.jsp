<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>

<portlet:defineObjects />
<liferay-theme:defineObjects />

<table class="skos-table">
	<thead>
		<th>Name</th>
		<th style="width: 170px;">Created</th>
		<th style="width: 170px;">Last Modified</th>
		<th colspan="3" style="text-align: center;">Version</th>
	</thead>
	<tbody>
		<c:choose>
			<c:when test="${empty bean.objects}">
				<tr>
					<td colspan="6" style="font-size: 14px; text-align: center; height: 50px;">You have no saved files</td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach var="obj" items="${bean.objects}">
					<tr>
						<td style="text-align: left; text-indent: 10px;">
							<c:if test="${obj.shared}">
								<img src='/skos-editor-portlet/images/locked.gif' />
							</c:if>
							${obj.name}
						</td>
						<td>
							${obj.created}
						</td>
						<td>
							${obj.modified}
						</td>
						<td style="border-right: none; width: 70px;">
							<select id="version-${obj.id}" style="width: auto; font-size: 15px; height: 25px; padding: 0px 5px 0px 0px;">
								<c:forEach items="${obj.versions}" var="obj2">
									<option value="${obj2.skosFileId}">${obj2.version}</option>
							    </c:forEach>
							</select>
						</td>
						<td style="border-right: none; width: 40px;">
							<a href='#' onclick="skos_LoadFile($('#version-${obj.id}').val()); return false;">Load</a>
						</td>
						<td style="text-align: center; padding: 0px; width: 40px;">
							<img onclick="skos_RemoveFile('${obj.id}'); return false;" 
								src='/skos-editor-portlet/images/remove.png' style='cursor: pointer;' title='Remove' />
						</td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</tbody>
</table>