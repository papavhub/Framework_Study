<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>update</title>
		<link rel="stylesheet" href="../resources/member.css" type="text/css"></link>
	</head>
	
	<body>
		<div align=center>
		
			<header>update</header>

			<form name=form1 action="http://localhost:8080/chm_free/playlist/startModify/" method="post">
				<table>
					<tr><th>playlistNumber</th><td><input type="number" name="playlistNumber" autofocus value="${Playlist_freeVO.playlistNumber}"></td></tr>
					<tr><th>playlistName</th><td><input type="text" name="playlistName" autofocus value="${Playlist_freeVO.playlistName}"></td></tr>
					<tr><th>playlistDescribe</th><td><input type="text" name="playlistDescribe" autofocus value="${Playlist_freeVO.playlistDescribe}"></td></tr>
					<%-- <tr><th>playlistLikes</th><td><input type="number" name="playlistLikes" autofocus value="${Playlist_freeVO.playlistName}"></td></tr> --%>
					<tr><th>playlistLink</th><td><input type="text" name="playlistLink" autofocus value="${Playlist_freeVO.playlistName}"></td></tr>
					<tr><th>playlistPassword</th><td><input type="number" name="playlistPassword" autofocus value=""></td></tr>
					<tr><th>playlistPhoto</th><td><input type="text" name="playlistPhoto" autofocus value="${Playlist_freeVO.playlistPhoto}"></td></tr>
				</table>
				
				
				<dl>
					<dd><input type="submit" name="submit" value="보내기"></dd>
					<dd><input type="reset" name="reset" value="다시 작성"></dd>
				</dl>

			</form>
			
			
		</div>
	</body>


</html>