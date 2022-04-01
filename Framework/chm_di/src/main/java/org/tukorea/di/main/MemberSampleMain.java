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
		
		ctx = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		MemberService memberService = ctx.getBean(MemberService.class);
		Scanner scan = new Scanner(System.in); // Scanner 객체
		
		while(true) {
			System.out.println("------------------");
			System.out.println("1. 전체 학생 정보 출력");
			System.out.println("2. 개인 학생 정보 출력");
			System.out.println("3. 개인 학생 정보 생성");
			System.out.println("4. 개인 학생 정보 수정");
			System.out.println("5. 개인 학생 정보 삭제");
			System.out.println("6. 프로그램 종료");
			System.out.print("Select >> ");
			
			try {
				int sel = scan.nextInt();
				scan.nextLine();
				System.out.println("------------------");
				
				switch(sel) {
				case 1:
					System.out.println("1. 전체 학생 정보 출력");
					System.out.println("------------------");
					
					List<StudentVO> list = memberService.readMemberList();
					for(StudentVO svo : list) {
						System.out.println(svo);
					}			
					break;
					
				case 2:
					System.out.println("2. 개인 학생 정보 출력");
					System.out.println("------------------");
					
					System.out.print("Student_id >> ");
					String strID = scan.next();
					StudentVO member = memberService.readMember(strID);
					System.out.println(member);
					
					break;
					
				case 3:
					System.out.println("3. 개인 학생 정보 생성");
					System.out.println("------------------");
					
					StudentVO vo = new StudentVO();
					System.out.print("Student_id >> ");
					String Student_id = scan.next();
					vo.setId(Student_id);
					
					System.out.print("Student_passwd >> ");
					String Student_passwd = scan.next();
					vo.setPasswd(Student_passwd);
					
					System.out.print("Student_userName >> ");
					String Student_userName = scan.next();
					vo.setUsername(Student_userName);
					
					System.out.print("Student_snum >> ");
					String Student_snum = scan.next();
					vo.setSnum(Student_snum);
					
					System.out.print("Student_depart >> ");
					String Student_depart = scan.next();
					vo.setDepart(Student_depart);
					
					System.out.print("Student_mobile >> ");
					String Student_mobile = scan.next();
					vo.setMobile(Student_mobile);
					
					System.out.print("Student_email >> ");
					String Student_email = scan.next();
					vo.setEmail(Student_email);
					
					memberService.addMember(vo);
					
					break;
					
				case 4:
					System.out.println("4. 개인 학생 정보 수정");
					System.out.println("------------------");
					
					break;
				case 5:
					System.out.println("5. 개인 학생 정보 삭제");
					System.out.println("------------------");
					
					System.out.print("Student_id >> ");
					String deleteID = scan.next();
					memberService.deleteMember(deleteID);
					
					break;
				case 6:
					System.out.println("6. 프로그램 종료");
					System.out.println("------------------");
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