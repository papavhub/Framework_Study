<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html class="canvas">

<head>
<meta charset="UTF-8">
<title>PlayList list</title>
<link rel="stylesheet" href="../resources/main.css" type="text/css"></link>
</head>

<body>
	<script type="text/javascript"
		src="http://code.jquery.com/jquery-3.5.1.min.js"></script>


	<div align=center class="stars">
	</div>
	
	<div align=center>

		<header>Playlist List</header>

		<div style="position: fixed; bottom: 0px; right: 0px;">
			<a href="http://localhost:8080/chm_free/playlist/create" height="5" width="10" target="_blank"> 
				<img src="../resources/images/floatingAddBtn.png" class="floatingBtn">
			<a>
		</div>

		<table>

			<c:forEach var="playlist" items="${playlistList}">
				<tr>
					<td><image height="80px" width="100px"
							src="<c:out value="${playlist.playlistPhoto}"/>" /></td>
					<td><c:out value="${playlist.playlistNumber}" /></td>
					<td><c:out value="${playlist.playlistName}" /></td>
					<td><c:out value="${playlist.playlistDescribe}" /></td>
					<td><c:out value="${playlist.playlistLikes}" /></td>


					<td>
						<input type="button" id="deleteBtn" name="deleteBtn" value="삭제" onclick="deleteBtnFunc(${playlist.playlistNumber})">
						<c:url value="/playlist/read?playlistNumber=${playlist.playlistNumber}" var="url"/><a href="${url}">정보 보기</a> 
						<c:url value="/playlist/modify?playlistNumber=${playlist.playlistNumber}" var="url"/><a href="${url}">정보 수정</a> 
						<c:url value="/playlist/heart?playlistNumber=${playlist.playlistNumber}" var="url"/><a href="${url}">heart</a>
					</td>

				</tr>
			</c:forEach>
		</table>


	</div>
</body>



	<script>
		function deleteBtnFunc(number){
			var password = prompt('삭제를 위해서 비밀번호를 입력해주세요.', "password")
				
			$.ajax({
	            type: "POST",
	            url: "http://localhost:8080/chm_free/playlist/checkPassword",
	            datatype: "json",
	            traditional: true,
	            data: {
	            	playlistNumber: number,
	            	password: password
	            }
	        });
		}
		
		
		/* backGround Motion */
		
		$(document).ready(function(){
		  var stars=800;
		  var $stars=$(".stars");
		  var r=800;
		  for(var i=0;i<stars;i++){
		    var $star=$("<div/>").addClass("star");
		    $stars.append($star);
		  }
		  $(".star").each(function(){
		    var cur=$(this);
		    var s=0.2+(Math.random()*1);
		    var curR=r+(Math.random()*300);
		    cur.css({ 
		      transformOrigin:"0 0 "+curR+"px",
		      transform:" translate3d(0,0,-"+curR+"px) rotateY("+(Math.random()*360)+"deg) rotateX("+(Math.random()*-50)+"deg) scale("+s+","+s+")"
		       
		    })
		  })
		})


	</script>


</html>