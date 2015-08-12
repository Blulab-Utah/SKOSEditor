<%@ page contentType="text/html; charset=UTF-8" %>

<%@ page import="com.liferay.portal.kernel.util.*" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<portlet:defineObjects />
<liferay-theme:defineObjects />

<div id='skos-settings'>
	<table class="skos-table">
		<tbody class="vertical">
			<tr>
				<td>
					Show titles as
				</td>
				<td>
					<select id='settings-show-as'>
						<option value=''></option>
						<c:forEach items="${bean.showAsOptions}" var="obj">
							<c:choose>
								<c:when test="${obj.value == bean.showConceptTitleAs}">
									<option selected="selected" value="${obj.value}">${obj.label}</option>
								</c:when>
								<c:otherwise>
									<option value="${obj.value}">${obj.label}</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td>
					<div style="position: absolute; right: 115px;">
						<img id="settings-lang-icon" src="/skos-editor-portlet/images/flags/${bean.showConceptTitleLanguageAs}.png">
					</div>
					Use language
				</td>
				<td>
					<select id='settings-show-as-lang' onchange="$('#settings-lang-icon').attr('src', '/skos-editor-portlet/images/flags/' + this.value + '.png');">
						<option value=''></option>
						<c:forEach items="${bean.languages}" var="obj">
							<c:choose>
								<c:when test="${obj == bean.showConceptTitleLanguageAs}">
									<option selected="selected" value="${obj}">${obj}</option>
								</c:when>
								<c:otherwise>
									<option value="${obj}">${obj}</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</select>
				</td>
			</tr>
		</tbody>
	</table>
	<div class='skos-dialog-buttons-block'>
		<a href="#" onclick="skos_MySettings.close(); return false;">Cancel</a>
		<button class="btn btn-primary" onclick="skos_MySettings.save(); return false;">Save</button>
		<div class='skos-dialog-buttons-waiting-block' style='display: none;'></div>
	</div>
</div>