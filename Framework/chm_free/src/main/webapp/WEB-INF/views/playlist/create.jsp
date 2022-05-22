<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="org.tukorea.chm_free.domain.Playlist_freeVO" %>
<%@ page import="org.tukorea.chm_free.domain.PlaylistDetail_freeVO" %>

<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>Create Playlist</title>
		<link rel="stylesheet" href="../resources/member.css" type="text/css"></link>
	</head>
	
	<body>
	<script type="text/javascript" src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
	
		<div align=center>
		
			<header>Playlist Info</header>

			
				<!-- playlist --> 
				<table>
				
					<tbody id="playlist">
						<tr>
							<th>playlistName</th>
							<td><input type="text" id="playlistName" name="playlistName" autofocus placeholder="공백 없이 입력하세요"></td>
						</tr>
						<tr>
							<th>playlistDescribe</th>
							<td><input type="text" id="playlistDescribe" name="playlistDescribe" autofocus placeholder="공백 없이 입력하세요"></td>
						</tr>
						<tr>
							<th>playlistPassword</th><td>
							<input type="text" id="playlistPassword" name="playlistPassword" autofocus placeholder="공백 없이 입력하세요"></td>
						</tr>
						<tr>
							<th>playlistPhoto</th><td>
							<input type="text" id="playlistPhoto" name="playlistPhoto" autofocus placeholder="공백 없이 입력하세요"></td>
						</tr>
					</tbody>	
				
				<!-- playlistDetail	 -->	
					<tr>
						<th>playlistDetailSource</th>
						<tbody id="playlistDetail"></tbody>
					</tr>
					
				</table>
				
				<dl>
					<input type="button" id="addBtn" name="addBtn" value="행추가" onclick="rowAdd()">
					<input type="button" id="removeBtn" name="addBtn" value="행삭제" onclick="rowRemove()">
				</dl>
				
				<dl>
					<input type="button" id="submitBtn" name="submitBtn" value="보내기" onclick="post()">
				</dl>

		</div>
	</body>
	
	
	
	
	<script>
		function rowAdd(){
			var objRow = document.all["playlistDetail"].insertRow();
			
			var objCell_playlistDetailSource = objRow.insertCell();
			objCell_playlistDetailSource.innerHTML = "<input type='text' name='playlistDetailSource' autofocus placeholder='공백 없이 입력하세요'/>"
		}
		
		function rowRemove(){
			var objRow = document.all["playlistDetail"].deleteRow(-1);
		}
		
		// post
		function post(){
			
			// playlist
			var playlistName = document.getElementById('playlistName')
			console.log(playlistName.value)
			var playlistDescribe = document.getElementById('playlistDescribe')
			console.log(playlistDescribe.value)
			var playlistPassword = document.getElementById('playlistPassword')
			console.log(playlistPassword.value)
			var playlistPhoto = document.getElementById('playlistPhoto')
			console.log(playlistPhoto.value)
			

  			// playlistDetail
			var tableId = document.getElementById('playlistDetail')
			var playlistDetail = tableId.getElementsByTagName('input')
			
			var playlistDetailList = [];
			for (var t = 0; t < playlistDetail.length; t++){
				console.log(playlistDetail[t].value)
				playlistDetailList.push(playlistDetail[t].value)
			} 
			
 	        $.ajax({
	            type: "POST",
	            url: "http://localhost:8080/chm_free/playlist/playlistCreate",
	            datatype: "json",
	            traditional: true,
	            data: {
	            	playlistName: playlistName.value,
	            	playlistDescribe: playlistDescribe.value,
	            	playlistPassword: playlistPassword.value,
	            	playlistPhoto: playlistPhoto.value,
	            	playlistDetail: playlistDetailList
	            }
	        });
 	        
 	        window.alert('추가 완료')
 	        window.location = "http://localhost:8080/chm_free/playlist/list"

		}	
		
	</script>

</html>