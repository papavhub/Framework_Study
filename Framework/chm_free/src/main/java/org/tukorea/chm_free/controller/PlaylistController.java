package org.tukorea.chm_free.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.tukorea.chm_free.domain.PlaylistDetail_freeVO;
import org.tukorea.chm_free.domain.Playlist_freeVO;
//import org.tukorea.chm_free.service.PlaylistDetail_freeService;
import org.tukorea.chm_free.service.Playlist_freeService;


@Controller
@RequestMapping(value="/playlist")
public class PlaylistController {
	
	private static final Logger logger = LoggerFactory.getLogger(PlaylistController.class);
	
	@Autowired(required=true)
	private Playlist_freeService playlist_freeService;
	
	// read list
	@RequestMapping(value= {"/list"}, method=RequestMethod.GET)
	public String listPlaylist(Model model) throws Exception {
		List<Playlist_freeVO> playlistList = playlist_freeService.readPlaylistList();
		model.addAttribute("playlistList", playlistList);
		return "playlist/main";
	}
	
	// create Page 로 이동
	@RequestMapping(value= {"/create"}, method=RequestMethod.GET)
	public String toCreate(Model model) throws Exception {
		return "playlist/create";
	}
	
	// create Playlist
	@RequestMapping(value= {"/playlistCreate"}, method=RequestMethod.POST)
	public String createPlaylist(@ModelAttribute("playlist") Playlist_freeVO vo) throws Exception {
		playlist_freeService.addPlaylist(vo);
		return "redirect:http://localhost:8080/chm_free/playlist/list";
	}
}