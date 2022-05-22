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
import org.springframework.web.bind.annotation.RequestParam;
import org.tukorea.chm_free.domain.PlaylistDetail_freeVO;
import org.tukorea.chm_free.domain.Playlist_freeVO;
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
	
	// create Playlist (transaction)
	@RequestMapping(value= {"/playlistCreate"}, method=RequestMethod.POST)
	public String createPlaylist(@RequestParam("playlistName") String playlistName, @RequestParam("playlistDescribe") String playlistDescribe, @RequestParam("playlistPassword") String playlistPassword, @RequestParam("playlistPhoto") String playlistPhoto, @RequestParam("playlistDetail") List<String> playlistDetail) throws Exception {
		Playlist_freeVO vo = new Playlist_freeVO();
		vo.setPlaylistName(playlistName);
		vo.setPlaylistLikes(0);
		vo.setPlaylistDescribe(playlistDescribe);
		vo.setPlaylistPassword(playlistPassword);
		vo.setPlaylistPhoto(playlistPhoto);
		
		playlist_freeService.addALL(vo, playlistDetail);
		return "redirect:http://localhost:8080/chm_free/playlist/list";
	}
	
	// read Detail
	@RequestMapping(value= {"/read"}, method=RequestMethod.GET)
	public String read(@RequestParam("playlistNumber") String playlistNumber, Model model) throws Exception {
		List<PlaylistDetail_freeVO> playlistDetail = playlist_freeService.readMember(Integer.parseInt(playlistNumber));
		model.addAttribute("PlaylistDetail_freeVO", playlistDetail);
		return "playlist/read";
	}
	
	// checkPassword
	@RequestMapping(value= {"/checkPassword"}, method=RequestMethod.POST)
	public String delete(@RequestParam("playlistNumber") Integer playlistNumber, @RequestParam("password") String password) throws Exception {
		Playlist_freeVO Playlist_freeVO = playlist_freeService.selectbyId(playlistNumber);
		String playlistPassword = Playlist_freeVO.getPlaylistPassword();
		logger.info(playlistPassword.toString());
		logger.info(password.toString());
		
		if(playlistPassword.contentEquals(password)) {
			logger.info("yes");
			playlist_freeService.deleteAll(playlistNumber);
		}
		
		return "redirect:http://localhost:8080/chm_free/playlist/list";
	}	
	
	// modify
	@RequestMapping(value= {"/modify"}, method=RequestMethod.GET)
	public String modify(@RequestParam("playlistNumber") Integer playlistNumber, Model model) throws Exception {
		
		
		return "playlist:update";
	}

}