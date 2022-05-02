package org.tukorea.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.tukorea.di.domain.StudentVO;

public class MemberAspect {
	
	public void beforeMethod(JoinPoint jp) {
		System.out.println("[BeforeMethod] : 메소드 호출 전");
		Signature sig = jp.getSignature();
		System.out.println("메소드 이름 : " + sig.getName());
		Object[] obj = jp.getArgs();
		System.out.println("인수 값 : " + obj[0]);
	}
	
	public void afterMethod() {
		System.out.println("[AfterMethod] : 메소드 호출 후 ");
	}
	
	public void afterReturningMethod(JoinPoint jp, StudentVO member) {
		System.out.println("[afterReturningMethod] : 메소드 호출 후 ");
		Signature sig = jp.getSignature();
		System.out.println("메소드 이름 : " + sig.getName());
		Object[] obj = jp.getArgs();
		System.out.println("인수 값 : " + obj[0]);		
	}
	
	public StudentVO aroundMethod(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("[AroundMethod before] : 메소드 호출 전 ");
		StudentVO member = (StudentVO)pjp.proceed();
		System.out.println("[AroundMethod after] : 메소드 호출 후 ");
		return member;
	}
	
	public void afterThrowingMethod(Throwable ex) {
		System.out.println("AfterThrowingMethod] : 예외 발생 후");
		System.out.println("exception value = " + ex.toString());
	}
}