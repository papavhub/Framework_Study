package org.tukorea.di.service;

import org.tukorea.di.domain.StudentVO;
import org.tukorea.di.persistence.MemberDAO;

public class MemberServiceImpl implements MemberService {
	
	private MemberDAO memberDAO;
	
	public MemberServiceImpl(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}

	public StudentVO readMember(String userid) throws Exception {
		return memberDAO.read(userid);
	}

	public void addMember(StudentVO student) throws Exception {
		memberDAO.add(student);
	}
	
}