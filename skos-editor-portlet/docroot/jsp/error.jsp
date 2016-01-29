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

<div class="alert alert-help" style="text-align: center; width: 415px; line-height: 30px; border-radius: 5px; margin: 10px auto 20px; box-shadow: 5px 5px 7px rgb(204, 204, 204); padding: 20px;"> 
	<h3><span style="color: rgb(105, 105, 105);">Welcome to</span> SKOS Editor</h3> 
	<h4 style="color: rgb(105, 105, 105); margin-bottom: 20px; line-height: 25px; text-align: center;">SKOS Editor is a plugin for Liferay that allows you to create and edit thesauri or similar artefacts represented in the <span style="border-bottom: 1px solid;">S</span>imple <span style="border-bottom: 1px solid;">K</span>nowledge <span style="border-bottom: 1px solid;">O</span>rganization <span style="border-bottom: 1px solid;">S</span>ystem</h4> 
	<p> 
	  <button onclick="location.href='<%= themeDisplay.getURLSignIn() %>';" type="button" class="btn btn-primary">Log In</button>&nbsp;&nbsp;or&nbsp;&nbsp; 
	  <button onclick="skos_OpenRegister();" type="button" class="btn btn-primary">Create Account</button> 
	</p>
	<hr>
	<h4 style="margin-top: 20px; margin-bottom: 10px;">Need Help?</h4>
	<div>
		<a target="_blank" href="${pageContext.request.contextPath}/help/SKOS.html" title='Online Help'><img src="${pageContext.request.contextPath}/images/ie.png" /></a>
		&nbsp;&nbsp;
		<a target="_blank" href="${pageContext.request.contextPath}/help/SKOS.docx" title='Help in Word format'><img src="${pageContext.request.contextPath}/images/word.png" /></a>
		&nbsp;&nbsp;
		<a target="_blank" href="https://github.com/Blulab-Utah" title='Projects on GitHub'><img src="${pageContext.request.contextPath}/images/github.jpg" style='border: 1px solid #CCCCCC; border-radius: 5px; box-shadow: 3px 3px 2px #bdbdbd;' /></a>
	</div> 
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