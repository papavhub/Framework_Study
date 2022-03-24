package org.tukorea.di.main;

import org.tukorea.di.config.JavaConfig;
import org.tukorea.di.domain.MemberVO;
import org.tukorea.di.service.MemberService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MemberSampleMain {
	private static ApplicationContext ctx = null;
	
	public static void main(String[] args) throws Exception {
		System.out.println("Hello DI-XML");
	
		ctx = new AnnotationConfigApplicationContext(JavaConfig.class);
		

		MemberService memberService = (MemberService)ctx.getBean("service", MemberService.class);
		
		MemberVO vo = new MemberVO();
		vo.setId("kanadara");
		memberService.addMember(vo);
		
		MemberVO member = memberService.readMember("kanadara");
		System.out.println(member);
	}
}