package org.tukorea.di.service;

import org.tukorea.di.domain.MemberVO;
import org.tukorea.di.persistence.MemberDAO;

import org.springframework.beans.factory.annotation.Autowired;

public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberDAO memberDAO;
	
	
//	Constructor based Injection
//	public MemberServiceImpl(MemberDAO memberDAO) {
//		this.memberDAO = memberDAO;
//	}
	
	
//	Setter based Injection
	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}
	
	public MemberVO readMember(String userid) throws Exception {
		return memberDAO.read(userid);
	}
	
	public void addMember(MemberVO student) throws Exception {
		memberDAO.add(student);
	}
}