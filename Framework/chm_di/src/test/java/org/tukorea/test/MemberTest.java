package org.tukorea.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.tukorea.di.domain.StudentVO;
import org.tukorea.di.service.MemberService;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/applicationContext.xml")


public class MemberTest {
	
	@Autowired
	MemberService memberService;
	
	@Test
	public void testAddMember() throws Exception {
		String strID = "hansol7";
		StudentVO vo = new StudentVO();
		vo.setId(strID);
		vo.setPasswd(strID);
		vo.setUsername(strID);
		vo.setSnum(strID);
		vo.setDepart(strID);
		vo.setMobile(strID);
		vo.setEmail(strID);
		
		memberService.addMember(vo);
		
		StudentVO member = memberService.readMember(strID);
		System.out.println(member);
	}
	
	@Test
	public void testUpdateMember() throws Exception {
		String strID = "hansol6";
		StudentVO vo = new StudentVO();
		vo.setId("hansol6");
		vo.setPasswd("passwd");
		vo.setUsername("username");
		vo.setSnum("snum");
		vo.setDepart("depart");
		vo.setMobile("mobile");
		vo.setEmail("email");
		
		memberService.updateMember(vo);
		
		StudentVO member = memberService.readMember(strID);
		System.out.println(member);
	}

	
	
}