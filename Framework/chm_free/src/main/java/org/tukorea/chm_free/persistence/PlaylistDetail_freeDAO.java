package org.tukorea.chm_free.persistence;

import java.util.List;

public interface PlaylistDetail_freeDAO {
	public List<PlaylistDetail_freeDAO> readList() throws Exception;
	public PlaylistDetail_freeDAO read(Integer id) throws Exception;
}