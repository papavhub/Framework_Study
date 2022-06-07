package org.tukorea.chm_free.test;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.tukorea.chm_free.domain.Playlist_freeVO;
import org.tukorea.chm_free.persistence.Playlist_freeDAO;
import org.tukorea.chm_free.service.Playlist_freeService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class playlistTest {
	
	@Autowired
	Playlist_freeService playlist_freeService;
	
	@Test
	public void testHeart() throws Exception {
		Playlist_freeVO playlist_freeVO = new Playlist_freeVO();
		playlist_freeVO.setPlaylistNumber(1);
		playlist_freeVO.setPlaylistLikes(0);
		
		playlist_freeService.heart(playlist_freeVO);
	}
	
	@Test
	public void testReadHeart() throws Exception {
		Playlist_freeVO playlist_freeVO = playlist_freeService.selectbyId(1);
		System.out.println(playlist_freeVO.getPlaylistLikes());
	}

	
	
}