<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>read</title>
	<link rel="stylesheet" href="../resources/read.css" type="text/css"></link>
</head>

<body>
	
	
	<div align=center>

		<header>read</header>

		<div id="player"></div>

		<script>
			// youtube API
			var tag = document.createElement('script');
			tag.src = "https://www.youtube.com/iframe_api";
			var firstScriptTag = document.getElementsByTagName('script')[0];
			firstScriptTag.parentNode.insertBefore(tag, firstScriptTag);

			// player variable
			var player;
			var done = false;

			var playList = [];
			var index = 0
			<c:forEach var="playlistDetail" items="${PlaylistDetail_freeVO}" varStatus="status">
			playList.push("${playlistDetail.playlistDetailSource}")
			</c:forEach>

			console.log(playList[index])

			function onYouTubeIframeAPIReady() {
				player = new YT.Player('player', {
					height : '360',
					width : '640',
					videoId : youtube_parser(playList[index]),
					origin : 'http://localhost:8080',
					events : {
						'onReady' : onPlayerReady,
						'onStateChange' : onPlayerStateChange
					}
				});
			}

			// after loading
			function onPlayerReady(event) {
				/* event.target.setVolume(70); // 볼륨 설정 */
				event.target.playVideo(); // auto play
			}

			// player state change
			function onPlayerStateChange(event) {

				// video end
				if (event.data == YT.PlayerState.ENDED) {
					if (index < playList.length - 1) { // 마지막 플리 음악이 아님 
						console.log(index)
						console.log(playList.length)
						player.stopVideo();
						player.destroy();
						player = null;

						// 다음 재생
						index += 1
						onYouTubeIframeAPIReady();

					} else {
						done = true;
					}
				}

			}

			// stop video
			function stopVideo() {
				player.stopVideo();
			}

			// get video_id from url
			function youtube_parser(url) {
				var regExp = /^.*((youtu.be\/)|(v\/)|(\/u\/\w\/)|(embed\/)|(watch\?))\??v?=?([^#&?]*).*/;
				var match = url.match(regExp);
				return (match && match[7].length == 11) ? match[7] : false;
			}


		</script>
		
		<p></p>
		<c:forEach var="playlistDetail" items="${PlaylistDetail_freeVO}">
			<tr>
				<td><c:out value="<h2>${playlistDetail.playlistDetailSource}</h2>" escapeXml="false"/></td>
			</tr>
		</c:forEach>



	</div>
		
</body>


</html>