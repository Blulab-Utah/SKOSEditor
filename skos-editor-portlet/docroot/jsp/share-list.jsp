<%@ include file="import.jsp"%>

<h4>
	Your shared files
	<div id="access-updated-message" class="quick-message">Access updated!</div>
</h4>
<table class="skos-table">
	<thead>
		<th>Name</th>
		<th style='width: 160px;'>Last Updated</th>
		<th style='width: 160px;'>Updated By</th>
		<th style='width: 160px;'>Shared With</th>
		<th style='width: 130px;'>Access</th>
	</thead>
	<tbody>
		<c:choose>
			<c:when test="${empty bean.objects}">
				<tr>
					<td colspan="5" style="text-align: center;">You have no shared files</td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach var="obj" items="${bean.objects}">
					<tr>
						<td style="text-align: left; text-indent: 10px;">
							<a href='#' onclick="skos_LoadFile(${obj.skosFileId}); return false;" title="Click to load this file">
								${obj.file.name}, version ${obj.file.version}
							</a>
						</td>
						<td>
							<fmt:formatDate pattern="MM/dd/yyyy HH:mm a" value="${obj.file.modified}" />
						</td>
						<td>
							${obj.file.modifiedByUser}
						</td>
						<td>
							${obj.sharedWithUser.fullName}
						</td>
						<td>
							<select onchange="skos_ChangeFileAccess(${obj.id}, this.value);" style="width: auto; font-size: 15px; height: 25px; padding: 0px 5px 0px 0px;">
								<option value="-1">Stop Sharing</option>
								<option value="0" <c:if test="${obj.access == 0}"> selected="selected"</c:if>>Read Only</option>
								<option value="1" <c:if test="${obj.access == 1}"> selected="selected"</c:if>>Read/Write</option>
								<option value="2" <c:if test="${obj.access == 2}"> selected="selected"</c:if>>Full</option>
							</select>
						</td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</tbody>
</table>

<h4 style='margin-top: 20px;'>Shared with you</h4>
<table class="skos-table">
	<thead>
		<th>Name</th>
		<th style='width: 160px;'>Last Updated</th>
		<th style='width: 160px;'>Updated By</th>
		<th style='width: 160px;'>Shared By</th>
		<th style='width: 130px;'>Access</th>
	</thead>
	<tbody>
		<c:choose>
			<c:when test="${empty bean.objects2}">
				<tr>
					<td colspan="5" style="text-align: center;">No files shared with you</td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach var="obj" items="${bean.objects2}">
					<tr>
						<td style="text-align: left; text-indent: 10px;">
							<a href='#' onclick="skos_LoadFile(${obj.skosFileId}); return false;">
								${obj.file.name}, version ${obj.file.version}
							</a>
						</td>
						<td>
							<fmt:formatDate pattern="MM/dd/yyyy HH:mm a" value="${obj.file.modified}" />
						</td>
						<td>
							${obj.file.modifiedByUser}
						</td>
						<td>
							${obj.sharedByUser.fullName}
						</td>
						<td>
							<c:choose>
								<c:when test="${obj.access == 2}">
									Full
							  	</c:when>
							  	<c:when test="${obj.access == 1}">
									Read / Write
							  	</c:when>
							  	<c:otherwise>
									Read-Only
							  	</c:otherwise>
							</c:choose>
						</td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</tbody>
</table>