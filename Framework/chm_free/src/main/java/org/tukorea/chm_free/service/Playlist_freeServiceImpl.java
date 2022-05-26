package org.tukorea.chm_free.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.tukorea.chm_free.domain.PlaylistDetail_freeVO;
import org.tukorea.chm_free.domain.Playlist_freeVO;
import org.tukorea.chm_free.persistence.Playlist_freeDAO;

@Service
@Component
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

	@Override
	public List<PlaylistDetail_freeVO> readMember(Integer playlistNumber) throws Exception {
		return playlist_freeDAO.readDetail(playlistNumber);
	}

	@Override
	public Playlist_freeVO selectbyId(Integer playlistNumber) throws Exception {
		Playlist_freeVO Playlist_freeVO = playlist_freeDAO.selectbyId(playlistNumber);
		return Playlist_freeVO;
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED, isolation=Isolation.READ_COMMITTED, timeout=10) // annotation Transaction
	public void deleteAll(Integer playlistNumber) throws Exception {
		// 1
		playlist_freeDAO.deleteDetail(playlistNumber);
		
		// 2
		playlist_freeDAO.delete(playlistNumber);
	}
	
	@Override
	public void modify(Playlist_freeVO playlist) throws Exception {
		playlist_freeDAO.modify(playlist);
	}

	@Override
	public void heart(Playlist_freeVO playlist) throws Exception {
		playlist_freeDAO.heart(playlist);
	}
	
}