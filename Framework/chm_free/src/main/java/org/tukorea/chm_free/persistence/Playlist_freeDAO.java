package org.tukorea.chm_free.persistence;

import java.util.List;

import org.tukorea.chm_free.domain.Playlist_freeVO;

public interface Playlist_freeDAO {
	public List<Playlist_freeVO> readList() throws Exception;
	public Integer add(Playlist_freeVO Playlist_freeVO) throws Exception;
}