package org.tukorea.chm_free.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.tukorea.chm_free.domain.PlaylistDetail_freeVO;
import org.tukorea.chm_free.domain.Playlist_freeVO;
//import org.tukorea.chm_free.service.PlaylistDetail_freeService;
import org.tukorea.chm_free.service.Playlist_freeService;

//@Controller
//@RequestMapping(value="/playlistDetail")
//public class PlaylistDetailController {
//	
//	
////	private static final Logger logger = LoggerFactory.getLogger(PlaylistController.class);
////	
////	@Autowired(required=true)
////	private PlaylistDetail_freeService playlistDetail_freeService;
////	
////	// create Playlist
////	@RequestMapping(value= {"/playlistCreate"}, method=RequestMethod.POST)
////	public String createPlaylist(@ModelAttribute("playlist") Playlist_freeVO vo, @ModelAttribute("playlistDetail") PlaylistDetail_freeVO detailvo) throws Exception {
////		
//////		playlist_freeService.addPlaylist(vo);
////		return "redirect:http://localhost:8080/chm_free/playlist/list";
////	}
//
//}