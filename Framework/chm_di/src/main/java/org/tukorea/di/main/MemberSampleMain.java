package org.tukorea.di.main;

import org.tukorea.di.domain.StudentVO;
import org.tukorea.di.service.MemberService;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

public class MemberSampleMain {
	private static ApplicationContext ctx = null;
	
	public static void main(String[] args) throws Exception {
		System.out.println("Hello DI-XML");
		
		ctx = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		MemberService memberService = ctx.getBean(MemberService.class);
		
		String strID = "hansol";
		StudentVO vo = new StudentVO();
		vo.setId(strID);
		vo.setPasswd(strID);
		vo.setUsername(strID);
		vo.setSnum(strID);
		
		try {
			StudentVO member = memberService.readMember(strID);
			System.out.println(member);
			
			List<StudentVO> list = memberService.readMemberList();
			for(StudentVO svo : list) {
				System.out.println(vo);
			}
		}catch(DataAccessException e) {
			System.out.println(e);
		}finally {
			JdbcTemplate jdbcTemplate = ctx.getBean(JdbcTemplate.class);
			int count = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM STUDENT", Integer.class);
			System.out.println(count);
		}
		
	}
}