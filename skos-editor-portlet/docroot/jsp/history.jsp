<%@ include file="import.jsp"%>

<table class='skos-table'>
	<tbody>
		<c:choose>
			<c:when test="${empty bean.objects}">
				<tr>
					<td colspan="2" style="font-size: 14px; text-align: center; height: 30px;">No history available</td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach var="obj" items="${bean.objects}">
					<tr>
						<td style='width: 250px; text-align: center;'>
							<fmt:formatDate pattern="MMMM dd, yyyy HH:mm a" value="${obj.recorded}" />
						</td>
						<td style='text-align: left; text-indent: 10px;'>
							${obj.details}
						</td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</tbody>
</table>
<c:forEach var="obj" items="${bean.collaboration}">
	<input type='hidden' name='collaboration'  
		skos-update-type='${obj.updateType}' 
		skos-schemeURI='${obj.schemeURI}' 
		skos-conceptURI='${obj.conceptURI}' 
		skos-value='${obj.value}' />
</c:forEach>
<c:forEach var="obj" items="${bean.locks}">
	<input type='hidden' name='lock' value='${obj.conceptURI}' />
</c:forEach>