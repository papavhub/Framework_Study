package org.tukorea.chm_free.service;

import java.util.List;
import org.tukorea.chm_free.domain.Playlist_freeVO;
import org.tukorea.chm_free.persistence.Playlist_freeDAO;

public interface Playlist_freeService {
	public List<Playlist_freeVO> readPlaylistList() throws Exception;
	public Integer addPlaylist(Playlist_freeVO playlist) throws Exception;
}