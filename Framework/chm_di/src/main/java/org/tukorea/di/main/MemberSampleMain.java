package org.tukorea.di.main;

import org.tukorea.di.domain.StudentVO;
import org.tukorea.di.service.MemberService;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

public class MemberSampleMain {
	private static ApplicationContext ctx = null;
	
	public static void main(String[] args) throws Exception {
		System.out.println("안녕하세요 DI_SPRINGJDBC");
		
		while(true) {
			System.out.println("1. 전체 학생 정보 출력");
			System.out.println("2. 개인 학생 정보 출력");
			System.out.println("3. 개인 학생 정보 생성");
			System.out.println("4. 개인 학생 정보 수정");
			System.out.println("5. 개인 학생 정보 삭제");
			System.out.println("6. 프로그램 종료");
			System.out.print("Select >> ");
			
			try {
				Scanner scan = new Scanner(System.in); // Scanner 객체
				int sel = scan.nextInt();
				scan.nextLine();
				
				switch(sel) {
				case 1:
					System.out.println("1. 전체 학생 정보 출력");
					break;
				case 2:
					System.out.println("2. 개인 학생 정보 출력");
					break;
				case 3:
					System.out.println("3. 개인 학생 정보 생성");
					break;
				case 4:
					System.out.println("4. 개인 학생 정보 수정");
					break;
				case 5:
					System.out.println("5. 개인 학생 정보 삭제");
					break;
				case 6:
					System.out.println("6. 프로그램 종료");
					System.exit(0);
				}
			}
			catch (InputMismatchException e) {
				System.out.println("확인 후 입력하세요.");
				continue;
			}
		}
		
//		System.out.println("Hello DI-XML");
//		
//		ctx = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
//		MemberService memberService = ctx.getBean(MemberService.class);
//		
//		String strID = "hansol";
//		StudentVO vo = new StudentVO();
//		vo.setId(strID);
//		vo.setPasswd(strID);
//		vo.setUsername(strID);
//		vo.setSnum(strID);
//		
//		try {
//			StudentVO member = memberService.readMember(strID);
//			System.out.println(member);
//			
//			List<StudentVO> list = memberService.readMemberList();
//			for(StudentVO svo : list) {
//				System.out.println(vo);
//			}
//		}catch(DataAccessException e) {
//			System.out.println(e);
//		}finally {
//			JdbcTemplate jdbcTemplate = ctx.getBean(JdbcTemplate.class);
//			int count = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM STUDENT", Integer.class);
//			System.out.println(count);
//		}
		
	}
}