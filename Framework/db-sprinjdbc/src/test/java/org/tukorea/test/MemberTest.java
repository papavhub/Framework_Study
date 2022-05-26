package org.tukorea.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.tukorea.di.domain.MemberVO;
import org.tukorea.di.service.MemberService;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/applicationContext.xml")


public class MemberTest {
	
	@Autowired
	MemberService memberService;
	
	@Test
	public void testReadMember() throws Exception {
		MemberVO member = memberService.readMember("hansol");
		System.out.println(member);
	}
	
	@Test
	public void testAddMember() throws Exception {
		String strID = "JUnit";
		MemberVO vo = new MemberVO();
		vo.setId(strID);
		vo.setPasswd(strID);
		vo.setUsername(strID);
		vo.setSnum(strID);
		
		memberService.addMember(vo);
		
		MemberVO member = memberService.readMember("JUnit");
		System.out.println(member);
	}

	
	
}