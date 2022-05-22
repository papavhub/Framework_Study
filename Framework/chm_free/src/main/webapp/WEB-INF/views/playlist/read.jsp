<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>read</title>
		<link rel="stylesheet" href="../resources/member.css" type="text/css"></link>
	</head>
	
	<body>
		<div align=center>
		
			<header>read</header>
			
			<table>
				<tr>		
				<th>playlistNumber</th>
				<th>playlistDetailSource</th>			
				</tr>
			
				<c:forEach var="playlistDetail" items="${PlaylistDetail_freeVO}">
					<tr>
						<td><c:out value="${playlistDetail.playlistNumber}"/></td>
						<td><c:out value="${playlistDetail.playlistDetailSource}"/></td>
						
					</tr>
				</c:forEach>
			</table>
			
			
		</div>
	</body>


</html>