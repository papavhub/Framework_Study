package org.tukorea.chm_free.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class playlistAspect {
	
	@Before("execution(* readList())")
	public void beforeRead(JoinPoint jp) {
		System.out.println("[before readList()]");
		Signature sig = jp.getSignature();
		System.out.println(sig.getName());
	}
}