<%@ page contentType="text/html; charset=UTF-8" %>

<%@ page import="com.liferay.portal.kernel.util.*" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<portlet:defineObjects />
<liferay-theme:defineObjects />

<table id="data-properties-table" style="width: 100%;">
	<tbody>
		
		<tr>
			<th colspan="2">
				Preferred Labels 
				<c:if test="${bean.project.access > 0}">
					<a class="addIcon" title="Add Preferred Label" href="#" onclick='skos_editLabel(null, "Preferred Label", "", "", "", "prefLabel"); return false;'></a>
				</c:if>
			</th>
		</tr>
		<c:forEach var="obj" items="${bean.node.prefLabels}">
			<tr skos-object-id='${obj.id}'>
				<td>
					<div style="float: left;">
						<c:if test="${bean.project.access > 0}">
							<a href='#' onclick='skos_editLabel(${obj.id}, "Preferred Label", $.trim($(this).text()), "${obj.type}", "${obj.lang}", "prefLabel"); return false;'>
						</c:if>
						${obj.object}
						<c:if test="${bean.project.access > 0}">
							</a>
						</c:if>
					</div>
					<c:if test="${not empty obj.lang}">
						<div class="language-info">
							<img src='/skos-editor-portlet/images/flags/${obj.lang}.png' />
							${obj.lang}
						</div>
					</c:if>
					<c:if test="${not empty obj.type}">
						<div class="language-info">
							<img src='/skos-editor-portlet/images/t.gif' style="width: auto;" />
							${obj.type}
						</div>
					</c:if>
				</td>
				<td style="width: 20%;">
					<c:if test="${bean.project.access == 2}">
						<a title="Remove property" class="deleteIcon" href="#" onclick='skos_DeleteLabel("${obj.id}"); return false;'></a>
					</c:if>
				</td>
			</tr>
		</c:forEach>
		
		<tr>
			<th colspan="2">
				Notations
				<c:if test="${bean.project.access > 0}">
					<a class="addIcon" title="Add Notation" href="#" onclick='skos_editLabel(null, "Notation", "", "", "", "notation"); return false;'></a>
				</c:if>
			</th>
		</tr>
		<c:forEach var="obj" items="${bean.node.notations}">
			<tr skos-object-id='${obj.id}'>
				<td>
					<div style="float: left;">
						<c:if test="${bean.project.access > 0}">
							<a href='#' onclick='skos_editLabel(${obj.id}, "Notation", $.trim($(this).text()), "${obj.type}", "${obj.lang}", "notation"); return false;'>
						</c:if>
							${obj.object}
						<c:if test="${bean.project.access > 0}">
							</a>
						</c:if>
					</div>
					<c:if test="${not empty obj.lang}">
						<div class="language-info">
							<img src='/skos-editor-portlet/images/flags/${obj.lang}.png' />
							${obj.lang}
						</div>
					</c:if>
					<c:if test="${not empty obj.type}">
						<div class="language-info">
							<img src='/skos-editor-portlet/images/t.gif' style="width: auto;" />
							${obj.type}
						</div>
					</c:if>
				</td>
				<td style="width: 20%;">
					<c:if test="${bean.project.access == 2}">
						<a title="Remove property" class="deleteIcon" href="#" onclick='skos_DeleteLabel("${obj.id}"); return false;'></a>
					</c:if>
				</td>
			</tr>
		</c:forEach>
		
		<tr>
			<th colspan="2">
				Alternative Labels
				<c:if test="${bean.project.access > 0}">
					<a class="addIcon" title="Add Alternative Label" href="#" onclick='skos_editLabel(null, "Alternative Label", "", "", "", "altLabel"); return false;'></a>
				</c:if>	
			</th>
		</tr>
		<c:forEach var="obj" items="${bean.node.altLabels}">
			<tr skos-object-id='${obj.id}'>
				<td>
					<div style="float: left;">
						<c:if test="${bean.project.access > 0}">
							<a href='#' onclick='skos_editLabel(${obj.id}, "Alternative Label", $.trim($(this).text()), "${obj.type}", "${obj.lang}", "altLabel"); return false;'>
						</c:if>
							${obj.object}
						<c:if test="${bean.project.access > 0}">
							</a>
						</c:if>
					</div>
					<c:if test="${not empty obj.lang}">
						<div class="language-info">
							<img src='/skos-editor-portlet/images/flags/${obj.lang}.png' />
							${obj.lang}
						</div>
					</c:if>
					<c:if test="${not empty obj.type}">
						<div class="language-info">
							<img src='/skos-editor-portlet/images/t.gif' style="width: auto;" />
							${obj.type}
						</div>
					</c:if>
				</td>
				<td style="width: 20%;">
					<c:if test="${bean.project.access == 2}">
						<a title="Remove property" class="deleteIcon" href="#" onclick='skos_DeleteLabel("${obj.id}"); return false;'></a>
					</c:if>
				</td>
			</tr>
		</c:forEach>
		
		<tr>
			<th colspan="2">
				Hidden Labels
				<c:if test="${bean.project.access > 0}">
					<a class="addIcon" title="Add Hidden Label" href="#" onclick='skos_editLabel(null, "Hidden Label", "", "", "", "hiddenLabel"); return false;'></a>
				</c:if>
			</th>
		</tr>
		<c:forEach var="obj" items="${bean.node.hiddenLabels}">
			<tr skos-object-id='${obj.id}'>
				<td>
					<div style="float: left;">
						<c:if test="${bean.project.access > 0}">
							<a href='#' onclick='skos_editLabel(${obj.id}, "Hidden Label", $.trim($(this).text()), "${obj.type}", "${obj.lang}", "hiddenLabel"); return false;'>
						</c:if>
							${obj.object}
						<c:if test="${bean.project.access > 0}">
							</a>
						</c:if>
					</div>
					<c:if test="${not empty obj.lang}">
						<div class="language-info">
							<img src='/skos-editor-portlet/images/flags/${obj.lang}.png' />
							${obj.lang}
						</div>
					</c:if>
					<c:if test="${not empty obj.type}">
						<div class="language-info">
							<img src='/skos-editor-portlet/images/t.gif' style="width: auto;" />
							${obj.type}
						</div>
					</c:if>
				</td>
				<td style="width: 20%;">
					<c:if test="${bean.project.access == 2}">
						<a title="Remove property" class="deleteIcon" href="#" onclick='skos_DeleteLabel("${obj.id}"); return false;'></a>
					</c:if>
				</td>
			</tr>
		</c:forEach>
		
		<tr>
			<th colspan="2">
				Other Data Properties
				<c:if test="${bean.project.access > 0}">
					<a class="addIcon" title="Add Other Data Property" href="#" onclick='skos_editLabel(null, "Other Label", "", "", "", "otherLabel"); return false;'></a>
				</c:if>
			</th>
		</tr>
		<c:forEach var="obj" items="${bean.node.otherLabels}">
			<tr skos-object-id='${obj.id}'>
				<td>
					<div style="float: left;">
						<c:if test="${bean.project.access > 0}">
							<a href='#' onclick='skos_editLabel(${obj.id}, "Other Label", $.trim($(this).text()), "${obj.type}", "${obj.lang}", "otherLabel"); return false;'>
						</c:if>
							${obj.object}
						<c:if test="${bean.project.access > 0}">
							</a>
						</c:if>
					</div>
					<c:if test="${not empty obj.lang}">
						<div class="language-info">
							<img src='/skos-editor-portlet/images/flags/${obj.lang}.png' />
							${obj.lang}
						</div>
					</c:if>
					<c:if test="${not empty obj.type}">
						<div class="language-info">
							<img src='/skos-editor-portlet/images/t.gif' style="width: auto;" />
							${obj.type}
						</div>
					</c:if>
				</td>
				<td style="width: 20%;">
					<c:if test="${bean.project.access == 2}">
						<a title="Remove property" class="deleteIcon" href="#" onclick='skos_DeleteLabel("${obj.id}"); return false;'></a>
					</c:if>
				</td>
			</tr>
		</c:forEach>

	</tbody>
</table>