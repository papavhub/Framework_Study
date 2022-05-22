package org.tukorea.chm_free.persistence;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.tukorea.chm_free.domain.Playlist_freeVO;

@Repository
public class Playlist_freeDAOImpl implements Playlist_freeDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	private static final String namespace = "org.tukorea.chm_free.mapper.PlaylistMapper";

	@Override
	public List<Playlist_freeVO> readList() throws Exception {
		List<Playlist_freeVO> playlistlist = new ArrayList<Playlist_freeVO>();
		playlistlist = sqlSession.selectList(namespace + ".selectAll");
		return playlistlist;
	}

	@Override
	public Playlist_freeVO read(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
}