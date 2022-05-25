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
			

			
				<c:forEach var="playlistDetail" items="${PlaylistDetail_freeVO}">
					<tr>
						<td><c:out value="${playlistDetail.playlistNumber}"/></td>
						<td><c:out value="${playlistDetail.playlistDetailSource}"/></td>
						
					</tr>
				</c:forEach>
				
				<div id="player"></div>

			    <script>
			    	var count = 1
			    
			    	<c:forEach var="playlistDetail" items="${PlaylistDetail_freeVO}">
		
					      var tag = document.createElement('script');
					      
					      // get from DB
					      var video_id = youtube_parser("${playlistDetail.playlistDetailSource}")

					
					    // youtube API
					      tag.src = "https://www.youtube.com/iframe_api";
					      var firstScriptTag = document.getElementsByTagName('script')[0];
					      firstScriptTag.parentNode.insertBefore(tag, firstScriptTag);
					
					      // player variable
					      var player;
					      function onYouTubeIframeAPIReady() {
					        player = new YT.Player('player', {
					          height: '360',
					          width: '640',
					          videoId: video_id,
					          events: {
					            'onReady': onPlayerReady,
					            'onStateChange': onPlayerStateChange
					          }
					        });
					      }
					
					      // after loading
					      function onPlayerReady(event) {
					        event.target.playVideo(); // auto play
					      }
					
					  
					      var done = false;
					      
					      // player state change
					      function onPlayerStateChange(event) {
					        if (event.data == YT.PlayerState.PLAYING && !done) {
					          setTimeout(stopVideo, 6000);
					          done = true;
					        }
					      }
					      
					      // stop video
					      function stopVideo() {
					        player.stopVideo();
					      }
					      
					      // get video_id from url
					      function youtube_parser(url){
							    var regExp = /^.*((youtu.be\/)|(v\/)|(\/u\/\w\/)|(embed\/)|(watch\?))\??v?=?([^#&?]*).*/;
							    var match = url.match(regExp);
							    return (match&&match[7].length==11)? match[7] : false;
							}
				      
					</c:forEach>
			      
			    </script>


					
		</div>
	</body>


</html>