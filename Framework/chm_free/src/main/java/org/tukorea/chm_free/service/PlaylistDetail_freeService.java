package org.tukorea.chm_free.service;

import java.util.List;

import org.tukorea.chm_free.domain.PlaylistDetail_freeVO;

public interface PlaylistDetail_freeService {
	public PlaylistDetail_freeVO readPlaylistDetail(Integer id) throws Exception;
	public List<PlaylistDetail_freeVO> readPlaylistDetailList() throws Exception;
}