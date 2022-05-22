package org.tukorea.chm_free.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.tukorea.chm_free.domain.PlaylistDetail_freeVO;
import org.tukorea.chm_free.domain.Playlist_freeVO;

//public class PlaylistDetail_freeDAOImpl implements PlaylistDetail_freeDAO {
//	
//	@Autowired
//	private SqlSession sqlSession;
//	
//	private static final String namespace = "org.tukorea.chm_free.mapper.PlaylistMapper";
//
//	@Override
//	public void add(PlaylistDetail_freeVO PlaylistDetail_freeVO) throws Exception {
//		sqlSession.insert(namespace + ".insertDetail", PlaylistDetail_freeVO);
//	}
//	
//
//
//}