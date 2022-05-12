package org.tukorea.di.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.tukorea.di.domain.StudentVO;
import org.tukorea.di.service.MemberService;

public class MemberSampleMain {
	
	private static ApplicationContext ctx = null;
	
	public static void main(String[] args) throws Exception {
		System.out.println("Hello AOP_XML");
		
		// xml & annotation
		 ctx = new GenericXmlApplicationContext("classpath:applicationContext.xml");
		MemberService memberService = ctx.getBean(MemberService.class);
		
		StudentVO vo = new StudentVO();
		vo.setId("kanadara");
		memberService.addMember(vo);
		
		StudentVO member = memberService.readMember("kanadara");
		System.out.println(member);
	}
}