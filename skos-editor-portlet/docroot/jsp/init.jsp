<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>

<portlet:defineObjects />
<liferay-theme:defineObjects />

<%
	long temp = System.currentTimeMillis();
%>

<portlet:resourceURL var="ajaxURL" />

<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/jquery/jquery-ui-1.8.19.custom.css" />
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/jquery/tooltipster.css" />
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/menu.css?a=<%= temp %>" />
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/skos-editor.css?a=<%= temp %>" />

<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/jquery-ui-1.8.19.custom.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/menu.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/jquery.qtip.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/jquery.blockUI.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/jquery.autogrow-textarea.js"></script>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/skosDialog.js?a=<%= temp %>"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/script.js?a=<%= temp %>"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/library.js?a=<%= temp %>"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/wizard.js?a=<%= temp %>"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/settings.js?a=<%= temp %>"></script>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/tree-nodes.js?a=<%= temp %>"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/assertions.js?a=<%= temp %>"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/labels.js?a=<%= temp %>"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/share.js?a=<%= temp %>"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/history.js?a=<%= temp %>"></script>

<script type="text/javascript">
	var ajaxURL = '<%= ajaxURL.toString() %>';
	skos_PreloadImage('${pageContext.request.contextPath}/images/collapse.gif');
	skos_PreloadImage('${pageContext.request.contextPath}/images/mini_circle_concept.png');
	skos_PreloadImage('${pageContext.request.contextPath}/images/mini_circle_loose_concept.png');
	skos_PreloadImage('${pageContext.request.contextPath}/images/mini_circle_schema.png');
	skos_PreloadImage('${pageContext.request.contextPath}/images/mini_circle_topconcept.png');
</script>

<form id="skos-custom-form">
	<input type="hidden" name="<portlet:namespace />schemeURI" id="schemeURI" />
	<input type="hidden" name="<portlet:namespace />conceptURI" id="conceptURI" />
	<input type="hidden" name="<portlet:namespace />id" id="skos-file-id" />
	<input type="hidden" name="<portlet:namespace />version" id="skos-file-version" />
</form>

<form method='post' id='skos-edit-property-form' action='<%= ajaxURL.toString() %>'>
	<div id='skos-edit-property-error-box' class='portlet-msg-error' style="display: none;"></div>
	<div id='skos-edit-property-block'></div>
</form>

<div id="edit-tree-node-popup" class='skos-edit-popup'>
	<input type='hidden' id='tree-node-action-type' />
	<div class='error-box'></div>
	<table id="add-top-concept-block" class="skos-table action-block">
		<tbody class="vertical">
			<tr>
				<td>
					Concept Name
				</td>
				<td>
					<input type='text' id='tree-add-top-concept-name' value='' />
				</td>
			</tr>
			<tr>
				<td>
					Concept Scheme
				</td>
				<td>
					<select id="tree-add-top-concept-scheme"></select>
				</td>
			</tr>
		</tbody>
	</table>
	<table id="rename-scheme-block" class="skos-table action-block">
		<tbody class="vertical">
			<tr>
				<td>
					Scheme Name
				</td>
				<td>
					<input type='text' id='tree-rename-scheme-name' value='' />
				</td>
			</tr>
		</tbody>
	</table>
	<table id="add-concept-block" class="skos-table action-block">
		<tbody class="vertical">
			<tr>
				<td>
					Parent Concept
				</td>
				<td>
					<input type='text' id='tree-add-concept-parent' value='' />
				</td>
			</tr>
			<tr>
				<td>
					Concept Name
				</td>
				<td>
					<input type='text' id='tree-add-concept-name' value='' />
				</td>
			</tr>
		</tbody>
	</table>
	<table id="rename-concept-block" class="skos-table action-block">
		<tbody class="vertical">
			<tr>
				<td>
					Concept Name
				</td>
				<td>
					<input type='text' id='tree-rename-concept-name' value='' />
				</td>
			</tr>
		</tbody>
	</table>
	<table id="move-concept-block" class="skos-table action-block">
		<tbody class="vertical">
			<tr>
				<td>
					Parent Concept
				</td>
				<td>
					<input type='text' id='tree-move-concept-parent' value='' />
				</td>
			</tr>
			<tr>
				<td>
					New Parent Concept
				</td>
				<td>
					<select id="tree-move-concept-uri"></select>
				</td>
			</tr>
		</tbody>
	</table>
	<div class='skos-dialog-buttons-block'>
		<a href="#" onclick="skos_CloseEditTreeNode(); return false;">Cancel</a>
		<button class='btn btn-primary' onclick="skos_SaveTreeNode(); return false;">Save</button>
		<div class='skos-dialog-buttons-waiting-block' style='display: none;'></div>
	</div>
</div>

<div id="edit-assertion-popup" class='skos-edit-popup'>
	<input type='hidden' id='assertion-id' />
	<div class='error-box'></div>
	<table class="skos-table">
		<tbody class="vertical">
			<tr>
				<td>
					Type
				</td>
				<td>
					<select id="assertion-type">
						<option value="Related">Related Concept</option>
						<option value="InScheme">In Scheme</option>
						<option value="TopConceptOf">Top Concept Of</option>
						<option value="Broader">Broader</option>
						<option value="Narrower">Narrower</option>
						<option value="Other">Other</option>
					</select>
					<select id='assertion-type-2'></select>
				</td>
			</tr>
			<tr>
				<td>
					<div id='assertion-label'></div>
				</td>
				<td>
					<select id='assertion-concept-uri'></select>
					<select id='assertion-scheme-uri'></select>
				</td>
			</tr>
		</tbody>
	</table>
	<div class='skos-dialog-buttons-block'>
		<a href="#" onclick="skos_CloseEditAssertion(); return false;">Cancel</a>
		<button class='btn btn-primary' onclick="skos_SaveAssertion(); return false;">Save</button>
		<div class='skos-dialog-buttons-waiting-block' style='display: none;'></div>
	</div>
</div>

<div id="edit-label-popup" class='skos-edit-popup'>
	<input type='hidden' id='label-id' />
	<input type='hidden' id='label-category' />
	<div id='edit-label-error-box'></div>
	<table class="skos-table">
		<tbody class="vertical">
			<tr>
				<td style="vertical-align: top;">
					Value
				</td>
				<td>
					<textarea id='label-value'></textarea>
				</td>
			</tr>
			<tr id="label-type-block" style="display: none;">
				<td>
					Label
				</td>
				<td>
					<select id="label-type-2"></select>
				</td>
			</tr>
			<tr>
				<td>
					Select Type
				</td>
				<td>
					<select id='label-type'></select>
				</td>
			</tr>
			<tr>
				<td>
					or Create Type
				</td>
				<td>
					<input type='text' id='label-type-new' value='' />
				</td>
			</tr>
			<tr>
				<td>
					Language
				</td>
				<td>
					<select id="label-language"></select>
				</td>
			</tr>
		</tbody>
	</table>
	<div class='skos-dialog-buttons-block'>
		<a href="#" onclick="skos_CloseEditLabel(); return false;">Cancel</a>
		<button class='btn btn-primary' onclick="skos_SaveLabel(); return false;">Save</button>
		<div class='skos-dialog-buttons-waiting-block' style='display: none;'></div>
	</div>
</div>

<div id="share-now-popup" class='skos-edit-popup'>
	<div class='error-box'></div>
	<table class="skos-table">
		<tbody class="vertical">
			<tr>
				<td>
					File Name
				</td>
				<td>
					<input type="text" id="share-file-title" value="" />
				</td>
			</tr>
			<tr>
				<td>
					Access Type
				</td>
				<td>
					<select id="share-access">
						<option value="0">Read-Only</option>
						<option value="1">Read and Edit</option>
						<option value="2">Read, Write, Delete</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>
					User Email
				</td>
				<td>
					<input type="text" id="share-email" value="" />
				</td>
			</tr>
		</tbody>
	</table>
	<div class='skos-dialog-buttons-block'>
		<a href="#" onclick="skos_CloseShareNow(); return false;">Cancel</a>
		<button class='btn btn-primary' onclick="skos_ShareNow(); return false;">Save</button>
		<div class='skos-dialog-buttons-waiting-block' style='display: none;'></div>
	</div>
</div>

<div id="shared-files-popup" class='skos-edit-popup'>
	<div id="skos-share"></div>
</div>
