package org.tukorea.chm_free.service;

import java.util.List;

import org.tukorea.chm_free.domain.Playlist_freeVO;

public interface Playlist_freeService {
	public Playlist_freeVO readPlaylist(Integer id) throws Exception;
	public List<Playlist_freeVO> readPlaylistList() throws Exception;
}