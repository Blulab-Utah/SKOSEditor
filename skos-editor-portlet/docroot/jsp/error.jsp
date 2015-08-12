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
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/jquery.blockUI.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/jquery.autogrow-textarea.js"></script>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/skosDialog.js?a=<%= temp %>"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/script.js?a=<%= temp %>"></script>

<script type="text/javascript">
	var ajaxURL = '<%= ajaxURL.toString() %>';
</script>

<div class="alert alert-help" style='text-align: center; padding-top: 20px; padding-bottom: 10px; line-height: 30px;'> 
	<p>Welcome to SKOS Editor Portlet</p>
	<p>Please log in to the system to get access to this portlet</p>
	<p>
		<button class="btn btn-primary" type="button" onclick='location.href="<%= themeDisplay.getURLSignIn() %>";'>Log In</button>&nbsp;&nbsp;or&nbsp;&nbsp;
		<button class="btn btn-primary" type="button" onclick='skos_OpenRegister();'>Create Account</button>
	</p>
</div>


<div id="register-popup" class='skos-edit-popup'>
	<div class='error-box'></div>
	<table class="skos-table">
		<tbody class="vertical">
			<tr>
				<td>
					First Name
				</td>
				<td>
					<input type="text" id='register-first-name' />
				</td>
			</tr>
			<tr>
				<td>
					Last Name
				</td>
				<td>
					<input type="text" id='register-last-name' />
				</td>
			</tr>
			<tr>
				<td>
					Email Address
				</td>
				<td>
					<input type="text" id='register-email' />
				</td>
			</tr>
			<tr>
				<td>
					Password
				</td>
				<td>
					<input type="password" id='register-password' />
				</td>
			</tr>
			<tr>
				<td>
					Confirm Password
				</td>
				<td>
					<input type="password" id='register-password-2' />
				</td>
			</tr>
		</tbody>
	</table>
	<div class='skos-dialog-buttons-block'>
		<a href="#" onclick="skos_CloseRegister(); return false;">Cancel</a>
		<button class='btn btn-primary' onclick="skos_SubmitRegister(); return false;">Register</button>
		<div class='skos-dialog-buttons-waiting-block' style='display: none;'></div>
	</div>
</div>

<div id="register-complete-popup" class='skos-edit-popup'>
	<p style="text-align: center; font-size: 16px; font-weight: normal; line-height: 30px;">Thank you!<br>You have successfully registered and will receive a confirmation email in short.</p>
	<div style="text-align: center;" class="skos-dialog-buttons-block">  
		<button style="float: none;" onclick="location.href = '<%= themeDisplay.getURLSignIn() %>';" class="btn btn-primary">Log In</button>  
	</div>
</div>