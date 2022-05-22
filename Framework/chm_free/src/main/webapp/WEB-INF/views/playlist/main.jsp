<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>Student list</title>
		<link rel="stylesheet" href="../resources/member.css" type="text/css"></link>
	</head>
	
	<body>
		<div align=center>
		
			<header>Playlist List</header>
			
			<br>
				<c:url value="/playlist/create" var="url"/>
				<a href="${url}">playlist 등록</a>
			</br>
			
			<table>
				<tr>		
				<th>playlistNumber</th>
				<th>playlistName</th>
				<th>playlistDescribe</th>
				<th>playlistPhoto</th>				
				</tr>
			
				<c:forEach var="playlist" items="${playlistList}">
					<tr>
						<td><c:out value="${playlist.playlistNumber}"/></td>
						<td><c:out value="${playlist.playlistName}"/></td>
						<td><c:out value="${playlist.playlistDescribe}"/></td>
						<td><c:out value="${playlist.playlistPhoto}"/></td>
						
						<td>
							<c:url value="/playlist/read?playlistNumber=${playlist.playlistNumber}" var="url"/><a href="${url}">정보 보기</a>
							<c:url value="/playlist/modify?playlistNumber=${playlist.playlistNumber}" var="url"/><a href="${url}">정보 수정</a>
							<c:url value="/playlist/delete?playlistNumber=${playlist.playlistNumber}" var="url"/><a href="${url}">정보 삭제</a>
						</td>
						
					</tr>
				</c:forEach>
			</table>
			
			
		</div>
	</body>


</html>