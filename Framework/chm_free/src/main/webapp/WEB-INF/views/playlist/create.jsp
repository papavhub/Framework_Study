<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>Create Playlist</title>
		<link rel="stylesheet" href="../resources/member.css" type="text/css"></link>
	</head>
	
	<body>
		<div align=center>
		
			<header>Playlist Info</header>
			<form name=form1 action="http://localhost:8080/myweb/member/register/" method="post">
				<table>
					<tr><th>playlistName</th><td><input type="text" name="playlistName" autofocus placeholder="공백 없이 입력하세요"></td></tr>
					<tr><th>playlistDescribe</th><td><input type="text" name="playlistDescribe" autofocus placeholder="공백 없이 입력하세요"></td></tr>
					<tr><th>playlistPassword</th><td><input type="text" name="playlistPassword" autofocus placeholder="공백 없이 입력하세요"></td></tr>
					<tr><th>playlistPhoto</th><td><input type="text" name="playlistPhoto" autofocus placeholder="공백 없이 입력하세요"></td></tr>
				</table>
				
<!-- 				<table>
					<tr><th>playlistDetailSource</th><td><input type="text" name="playlistDetailSource" autofocus placeholder="공백 없이 입력하세요"></td></tr>				
				</table> -->
				
				<table>
					<tr>
						<td>playlistDetailSource</td>
					</tr>
					
					<tbody id="tblShow"></tbody>
				</table>
				
				<input type="button" id="addBtn" name="addBtn" value="행추가" onclick="rowAdd()">
				<input type="button" id="removeBtn" name="addBtn" value="행삭제" onclick="rowRemove()">
				
				<dl>
					<dd><input type="submit" name="submit" value="보내기"></dd>
					<dd><input type="reset" name="reset" value="다시 작성"></dd>
				</dl>

			</form>
		</div>
	</body>
	
	
	
	
	<script>
		function rowAdd(){
			var objRow = document.all["tblShow"].insertRow();
			
			var objCell_playlistDetailSource = objRow.insertCell();
			objCell_playlistDetailSource.innerHTML = "<input type='text' name='playlistDetailSource' autofocus placeholder='공백 없이 입력하세요'/>"
		}
		
		function rowRemove(){
			var objRow = document.all["tblShow"].deleteRow(-1);
			
		}
	</script>
	



</html>