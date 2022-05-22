package org.tukorea.chm_free.persistence;

import java.util.List;

import org.tukorea.chm_free.domain.PlaylistDetail_freeVO;

public interface PlaylistDetail_freeDAO {
	public List<PlaylistDetail_freeVO> readList() throws Exception;
	public PlaylistDetail_freeVO read(Integer id) throws Exception;
}