package org.tukorea.di.main;

import org.tukorea.di.domain.MemberVO;
import org.tukorea.di.service.MemberService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MemberSampleMain {
	private static ApplicationContext ctx = null;
	
	public static void main(String[] args) throws Exception {
		System.out.println("Hello DI-XML");
		
		ctx = new GenericXmlApplicationContext("classpath:applicationContext.xml");
		MemberService memberService = (MemberService)ctx.getBean("memberService");
		
		MemberVO vo = new MemberVO();
		vo.setId("kanadara");
		memberService.addMember(vo);
		
		MemberVO member = memberService.readMember("kanadara");
		System.out.println(member);
	}
}