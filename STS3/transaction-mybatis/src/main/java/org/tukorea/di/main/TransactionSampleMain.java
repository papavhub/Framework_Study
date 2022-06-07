package org.tukorea.di.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.tukorea.di.domain.StudentVO;
import org.tukorea.di.service.MemberService;

public class TransactionSampleMain {
	private static ApplicationContext ctx = null;
	
	public static void main(String[] args) throws Exception {
		System.out.println("Hello Transaction-Mybatis");
		
		ctx = new ClassPathXmlApplicationContext("classpath:applicationContext-annotation.xml");
		MemberService memberService = ctx.getBean(MemberService.class);
		
		String strId1 = "hansol";
		StudentVO vo1 = new StudentVO();
		vo1.setId(strId1);
		vo1.setPasswd(strId1);
		vo1.setSnum(strId1);
		vo1.setUsername("kanadaramabasa");
		
		String strId2 = "dongjin";
		StudentVO vo2 = new StudentVO();
		vo2.setId(strId2);
		vo2.setPasswd(strId2);
		vo2.setSnum(strId2);
		vo2.setUsername(strId2);
		
		try {
			memberService.updateMemberList(vo1, vo2);
			System.out.println("transaction complete");
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
	}
	
}