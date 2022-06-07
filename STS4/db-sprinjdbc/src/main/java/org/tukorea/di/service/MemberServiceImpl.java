package org.tukorea.di.service;

import org.tukorea.di.domain.MemberVO;
import org.tukorea.di.persistence.MemberDAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberDAO memberDAO;

	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}
	
	public MemberVO readMember(String userid) throws Exception {
		return memberDAO.read(userid);
	}
	
	public void addMember(MemberVO student) throws Exception {
		memberDAO.add(student);
	}

	public List<MemberVO> readMemberList() throws Exception {
		return memberDAO.readList();
	}
}