package org.tukorea.di.service;

import org.tukorea.di.domain.StudentVO;
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
	
	public StudentVO readMember(String userid) throws Exception {
		return memberDAO.read(userid);
	}
	
	public void addMember(StudentVO student) throws Exception {
		memberDAO.add(student);
	}

	public List<StudentVO> readMemberList() throws Exception {
		return memberDAO.readList();
	}

	public void deleteMember(String id) throws Exception {
		memberDAO.delete(id);
	}

	public StudentVO updateMember(StudentVO student) throws Exception {
		return memberDAO.update(student);
	}
}