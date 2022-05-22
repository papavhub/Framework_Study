package org.tukorea.chm_free.persistence;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.tukorea.chm_free.domain.PlaylistDetail_freeVO;
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
	public Integer add(Playlist_freeVO Playlist_freeVO) throws Exception {
		int vo = sqlSession.insert(namespace + ".insert", Playlist_freeVO);
		return Playlist_freeVO.getPlaylistNumber();
	}

	@Override
	public void add(PlaylistDetail_freeVO PlaylistDetail_freeVO) throws Exception {
		sqlSession.insert(namespace + ".insertDetail", PlaylistDetail_freeVO);
	}

	@Override
	public List<PlaylistDetail_freeVO> readDetail(Integer playlistNumber) throws Exception {
		List<PlaylistDetail_freeVO> playlistDetail_freeVOList = new ArrayList<PlaylistDetail_freeVO>();
		playlistDetail_freeVOList = sqlSession.selectList(namespace + ".selectByIdDetail", playlistNumber);
		return playlistDetail_freeVOList;
	}

	@Override
	public Playlist_freeVO selectbyId(Integer playlistNumber) throws Exception {
		Playlist_freeVO Playlist_freeVO = sqlSession.selectOne(namespace + ".selectByIdPassword", playlistNumber);
		return Playlist_freeVO;
	}

	@Override
	public void delete(Integer playlistNumber) throws Exception {
		sqlSession.delete(namespace + ".delete", playlistNumber);
	}

	@Override
	public void deleteDetail(Integer playlistNumber) throws Exception {
		sqlSession.delete(namespace + ".deleteDetail", playlistNumber);
	}
	
}