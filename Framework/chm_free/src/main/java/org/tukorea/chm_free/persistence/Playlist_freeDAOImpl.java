package org.tukorea.chm_free.persistence;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.tukorea.chm_free.controller.PlaylistController;
import org.tukorea.chm_free.domain.PlaylistDetail_freeVO;
import org.tukorea.chm_free.domain.Playlist_freeVO;

@Repository
@Component
@Service
public class Playlist_freeDAOImpl implements Playlist_freeDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	private static final String namespace = "org.tukorea.chm_free.mapper.PlaylistMapper";
	
	private static final Logger logger = LoggerFactory.getLogger(Playlist_freeDAOImpl.class);

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

	@Override
	public void modify(Playlist_freeVO playlist_freeVO) throws Exception {
		Integer a = sqlSession.update(namespace + ".modify", playlist_freeVO);
		Integer b = playlist_freeVO.getPlaylistNumber();
	}

	@Override
	public void heart(Playlist_freeVO Playlist_freeVO) throws Exception {
		Integer a = sqlSession.update(namespace + ".heart", Playlist_freeVO);
		
	}
	
}