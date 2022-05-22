package org.tukorea.chm_free.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.tukorea.chm_free.domain.PlaylistDetail_freeVO;
import org.tukorea.chm_free.domain.Playlist_freeVO;
import org.tukorea.chm_free.persistence.Playlist_freeDAO;

@Service
public class Playlist_freeServiceImpl implements Playlist_freeService {
	
	@Autowired
	private Playlist_freeDAO playlist_freeDAO;
	

	@Override
	public List<Playlist_freeVO> readPlaylistList() throws Exception {
		return playlist_freeDAO.readList();
	}

	@Override
	public Integer addPlaylist(Playlist_freeVO playlist) throws Exception {
		return playlist_freeDAO.add(playlist);
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED, isolation=Isolation.READ_COMMITTED, timeout=10) // annotation Transaction
	public void addALL(Playlist_freeVO playlist, List<String> Dvo) throws Exception {
		// 1
		Integer playlistNumber = playlist_freeDAO.add(playlist);
		
		// 2
		System.out.println(playlistNumber);
		for (int t = 0; t < Dvo.size(); t++){
			PlaylistDetail_freeVO dao = new PlaylistDetail_freeVO();
			dao.setPlaylistDetailSource(Dvo.get(t));
			dao.setPlaylistNumber(playlistNumber);
			playlist_freeDAO.add(dao);		
		}

	}
	
}