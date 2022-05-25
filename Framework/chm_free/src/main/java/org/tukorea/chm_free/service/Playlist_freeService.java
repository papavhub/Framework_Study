package org.tukorea.chm_free.service;

import java.util.List;

import org.tukorea.chm_free.domain.PlaylistDetail_freeVO;
import org.tukorea.chm_free.domain.Playlist_freeVO;
import org.tukorea.chm_free.persistence.Playlist_freeDAO;

public interface Playlist_freeService {
	public List<Playlist_freeVO> readPlaylistList() throws Exception;
	
	public Integer addPlaylist(Playlist_freeVO playlist) throws Exception;
	public void addALL(Playlist_freeVO playlist, List<String> Dvo) throws Exception;
	
	public Playlist_freeVO selectbyId(Integer playlistNumber) throws Exception;
	
	public void deleteAll(Integer playlistNumber) throws Exception;
	
	public void modify(Playlist_freeVO playlist) throws Exception;
	public void heart(Playlist_freeVO playlist) throws Exception;
	
	public List<PlaylistDetail_freeVO> readMember(Integer playlistNumber) throws Exception;
}