<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>update</title>
		<link rel="stylesheet" href="../resources/create.css" type="text/css"></link>
	</head>
	
	<body>
	<script type="text/javascript" src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
	
		<div align=center class="stars">
		</div>
		
		<div align=center>
		
			<header>update</header>

			<form name=form1 action="http://localhost:8080/chm_free/playlist/startModify/" method="post">
				<table>
					<tr><th style="color:white; font-size:20pt;">playlistNumber</th><td><input type="number" name="playlistNumber" autofocus value="${Playlist_freeVO.playlistNumber}"></td></tr>
					<tr><th style="color:white; font-size:20pt;">playlistName</th><td><input type="text" name="playlistName" autofocus value="${Playlist_freeVO.playlistName}"></td></tr>
					<tr><th style="color:white; font-size:20pt;">playlistDescribe</th><td><input type="text" name="playlistDescribe" autofocus value="${Playlist_freeVO.playlistDescribe}"></td></tr>
					<%-- <tr><th>playlistLikes</th><td><input type="number" name="playlistLikes" autofocus value="${Playlist_freeVO.playlistName}"></td></tr> --%>
					<tr><th style="color:white; font-size:20pt;">playlistPassword</th><td><input type="number" name="playlistPassword" autofocus value=""></td></tr>
					<tr><th style="color:white; font-size:20pt;">playlistPhoto</th><td><input type="text" name="playlistPhoto" autofocus value="${Playlist_freeVO.playlistPhoto}"></td></tr>
				</table>
				
				
				<dl>
					<input type="submit" name="submit" value="보내기" class="test">
					<input type="reset" name="reset" value="다시 작성" class="test">
				</dl>

			</form>
			
			
		</div>
	</body>
	
	<script>
	
	
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