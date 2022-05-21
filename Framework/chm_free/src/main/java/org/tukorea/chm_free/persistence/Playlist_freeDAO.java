package org.tukorea.chm_free.persistence;

import java.util.List;

public interface Playlist_freeDAO {
	public List<Playlist_freeDAO> readList() throws Exception;
	public Playlist_freeDAO read(Integer id) throws Exception;
}