<%@ page contentType="text/html; charset=UTF-8" %>

<%@ page import="com.liferay.portal.kernel.util.*" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<portlet:defineObjects />
<liferay-theme:defineObjects />

<table id="object-properties-table" style="width: 100%;">
	<tbody>
		
		<tr>
			<th colspan="2">
				Related Concept assertions
				<c:if test="${bean.project.access > 0}">
					<a class="addIcon" title="Add Related Concept Assertion" href="#" onclick='skos_editAssertion("Related", "Concept"); return false;'></a>
				</c:if>
			</th>
		</tr>
		<c:forEach var="obj" items="${bean.node.relatedAssertions}">
			<tr skos-object-id='${obj.id}'>
				<td>
					<c:choose>
						<c:when test="${bean.project.access > 0}">
							<a href='#' onclick='skos_editAssertion("Related", "Concept", "${obj.objectURI}", ${obj.id}); return false;'>${obj.title}</a>
						</c:when>
						<c:otherwise>
							${obj.title}
						</c:otherwise>
					</c:choose>
				</td>
				<td style="width: 20%;">
					<c:if test="${bean.project.access == 2}">
						<a title="Remove property" class="deleteIcon" href="#" onclick='skos_DeleteAssertion("${obj.id}"); return false;'></a>
					</c:if>
				</td>
			</tr>
		</c:forEach>
		
		<tr>
			<th colspan="2">
				InScheme assertions
				<c:if test="${bean.project.access > 0}">
					<a class="addIcon" title="Add inScheme Assertion" href="#" onclick='skos_editAssertion("InScheme", "Scheme"); return false;'></a> 
				</c:if>
			</th>
		</tr>
		<c:forEach var="obj" items="${bean.node.inSchemeAssertions}">
			<tr skos-object-id='${obj.id}'>
				<td>
					<c:choose>
						<c:when test="${bean.project.access > 0}">
							<a href='#' onclick='skos_editAssertion("InScheme", "Scheme", "${obj.objectURI}", ${obj.id}); return false;'>${obj.title}</a>
						</c:when>
						<c:otherwise>
							${obj.title}
						</c:otherwise>
					</c:choose>
				</td>
				<td>
					<c:if test="${bean.project.access == 2}">
						<a title="Remove property" class="deleteIcon" href="#" onclick='skos_DeleteAssertion("${obj.id}"); return false;'></a>
					</c:if>
				</td>
			</tr>
		</c:forEach>
		
		<tr>
			<th colspan="2">
				TopConceptOf assertions
				<c:if test="${bean.project.access > 0}">
					<a class="addIcon" title="Add topConceptOf Assertion" href="#" onclick='skos_editAssertion("TopConceptOf", "Scheme"); return false;'></a>
				</c:if>
			</th>
		</tr>
		<c:forEach var="obj" items="${bean.node.topConceptOfAssertions}">
			<tr skos-object-id='${obj.id}'>
				<td>
					<c:choose>
						<c:when test="${bean.project.access > 0}">
							<a href='#' onclick='skos_editAssertion("TopConceptOf", "Scheme", "${obj.objectURI}", ${obj.id}); return false;'>${obj.title}</a>
						</c:when>
						<c:otherwise>
							${obj.title}
						</c:otherwise>
					</c:choose>
				</td>
				<td>
					<c:if test="${bean.project.access == 2}">
						<a title="Remove property" class="deleteIcon" href="#" onclick='skos_DeleteAssertion("${obj.id}"); return false;'></a>
					</c:if>
				</td>
			</tr>
		</c:forEach>
		
		<tr>
			<th colspan="2">
				Broader assertions
				<c:if test="${bean.project.access > 0}">
					<a class="addIcon" title="Add broader Assertion" href="#" onclick='skos_editAssertion("Broader", "Concept"); return false;'></a> 
				</c:if>
			</th>
		</tr>
		<c:forEach var="obj" items="${bean.node.broaderAssertions}">
			<tr skos-object-id='${obj.id}'>
				<td>
					<c:choose>
						<c:when test="${bean.project.access > 0}">
							<a href='#' onclick='skos_editAssertion("Broader", "Concept", "${obj.objectURI}", ${obj.id}); return false;'>${obj.title}</a>
						</c:when>
						<c:otherwise>
							${obj.title}
						</c:otherwise>
					</c:choose>
				</td>
				<td>
					<c:if test="${bean.project.access == 2}">
						<a title="Remove property" class="deleteIcon" href="#" onclick='skos_DeleteAssertion("${obj.id}"); return false;'></a>
					</c:if>
				</td>
			</tr>
		</c:forEach>
		
		<tr>
			<th colspan="2">
				Narrower assertions
				<c:if test="${bean.project.access > 0}">
					<a class="addIcon" title="Add narrower Assertion" href="#" onclick='skos_editAssertion("Narrower", "Concept"); return false;'></a> 
				</c:if>
			</th>
		</tr>
		<c:forEach var="obj" items="${bean.node.narrowerAssertions}">
			<tr skos-object-id='${obj.id}'>
				<td>
					<c:choose>
						<c:when test="${bean.project.access > 0}">
							<a href='#' onclick='skos_editAssertion("Narrower", "Concept", "${obj.objectURI}", ${obj.id}); return false;'>${obj.title}</a>
						</c:when>
						<c:otherwise>
							${obj.title}
						</c:otherwise>
					</c:choose>
				</td>
				<td>
					<c:if test="${bean.project.access == 2}">
						<a title="Remove property" class="deleteIcon" href="#" onclick='skos_DeleteAssertion("${obj.id}"); return false;'></a>
					</c:if>
				</td>
			</tr>
		</c:forEach>
		
		<tr>
			<th colspan="2">
				Other assertions
				<c:if test="${bean.project.access > 0}">
					<a class="addIcon" title="Add other Assertion" href="#" onclick='skos_editAssertion("Other", "Concept"); return false;'></a> 
				</c:if>
			</th>
		</tr>
		<c:forEach var="obj" items="${bean.node.otherAssertions}">
			<tr skos-object-id='${obj.id}'>
				<td>
					<c:if test="${not empty obj.property}">
						<div class="language-info" style="margin-right: 10px; margin-left: 0;">
							<img src='/skos-editor-portlet/images/t.gif' style="width: auto;" />
							${obj.property}
						</div>
					</c:if>
					<c:choose>
						<c:when test="${bean.project.access > 0}">
							<a href='#' onclick='skos_editAssertion("Other", "Concept", "${obj.objectURI}", ${obj.id}); return false;'>${obj.title}</a>
						</c:when>
						<c:otherwise>
							${obj.title}
						</c:otherwise>
					</c:choose>
				</td>
				<td>
					<c:if test="${bean.project.access == 2}">
						<a title="Remove property" class="deleteIcon" href="#" onclick='skos_DeleteAssertion("${obj.id}"); return false;'></a>
					</c:if>
				</td>
			</tr>
		</c:forEach>
	
	</tbody>
</table>