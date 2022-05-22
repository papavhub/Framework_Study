package org.tukorea.chm_free.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tukorea.chm_free.domain.Playlist_freeVO;
import org.tukorea.chm_free.persistence.Playlist_freeDAO;

@Service
public class Playlist_freeServiceImpl implements Playlist_freeService {
	
	@Autowired
	private Playlist_freeDAO playlist_freeDAO;

	@Override
	public Playlist_freeVO readPlaylist(Integer id) throws Exception {
		return null;
	}

	@Override
	public List<Playlist_freeVO> readPlaylistList() throws Exception {
		return playlist_freeDAO.readList();
	}

	
}