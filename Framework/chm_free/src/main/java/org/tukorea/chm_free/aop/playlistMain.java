package org.tukorea.chm_free.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.tukorea.chm_free.service.Playlist_freeService;

public class playlistMain{
	private static ApplicationContext ctx = null;
	
	public static void main(String[] args) throws Exception {
		System.out.println("Hello AOP");
		ctx = new GenericXmlApplicationContext("classpath:applicationContext.xml");
		Playlist_freeService playlist_freeService = ctx.getBean(Playlist_freeService.class);
		playlist_freeService.readPlaylistList();
	}
}