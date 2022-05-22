package org.tukorea.chm_free.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.tukorea.chm_free.domain.Playlist_freeVO;
import org.tukorea.chm_free.persistence.Playlist_freeDAO;
import org.tukorea.chm_free.service.Playlist_freeService;

@Controller
@RequestMapping(value="/playlist")
public class PlaylistController {
	
	private static final Logger logger = LoggerFactory.getLogger(PlaylistController.class);
	
	@Autowired(required=true)
	private Playlist_freeService playlist_freeService;
	
	
	@RequestMapping(value= {"/list"}, method=RequestMethod.GET)
	public String listPlaylist(Model model) throws Exception {
		List<Playlist_freeVO> playlistList = playlist_freeService.readPlaylistList();
		model.addAttribute("playlistList", playlistList);
		return "playlist/main";
	}
	
	@RequestMapping(value= {"/create"}, method=RequestMethod.GET)
	public String createPlaylist(Model model) throws Exception {
		return "playlist/create";
	}
}