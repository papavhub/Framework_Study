package org.tukorea.chm_free.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.tukorea.chm_free.domain.Playlist_freeVO;

@Aspect
@Component
public class playlistAspect {
	
	@Before("execution(* readList())")
	public void beforeRead(JoinPoint jp) {
		System.out.println("[before readList]");
		System.out.println("플레이리스트 전체를 읽어오고 있습니다. 조금만 기다려주세요...");
		Signature sig = jp.getSignature();
		System.out.println(sig.getName() + " 함수 호출 중");
	}
	
	@After("execution(* readList())")
	public void afterRead(JoinPoint jp) {
		System.out.println("[after readList]");
		System.out.println("플레이리스트를 전부 읽어왔습니다.");
		System.out.println("방문해주셔서 감사합니다 :)");
	}
	
	@AfterReturning(value="execution(* selectbyId(Integer))", returning="playlist")
	public void afterReturningSelectById(JoinPoint jp, Playlist_freeVO playlist) {
		System.out.println("[AfterReturning selectById]");
		System.out.println(playlist.getPlaylistName() + "를 불러왔습니다.");
	}
	
	@After("execution(* heart(org.tukorea.chm_free.domain.Playlist_freeVO))")
	public void afterHeart() {
		System.out.println("[@After heart]");
		System.out.println("하트 추가 완료! 하트는 계속 추가할 수 있습니다");
		System.out.println("플레이스트가 좋았던 만큼 하트를 눌러 주세요!");
	}
	
	@AfterThrowing(value="execution(* add(org.tukorea.chm_free.domain.PlaylistDetail_freeVO))", throwing="ex")
	public void afterThrowingAddDetail(Throwable ex) {
		System.out.println("[@AfterThrowing addDetail]");
		System.out.println(ex.toString());
		System.out.println("같은 링크를 2번 이상 입력하셨나요?");
	}
	
}