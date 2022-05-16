package org.tukorea.di.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tukorea.di.domain.StudentVO;
import org.tukorea.di.persistence.MemberDAO;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberDAO memberDAO;

	@Override
	public StudentVO readMember(String id) throws Exception {
		return memberDAO.read(id);
	}

	@Override
	public List<StudentVO> readMemberList() throws Exception {
		return memberDAO.readList();
	}

	@Override
	public void addMember(StudentVO student) throws Exception {
		memberDAO.add(student);
	}

	@Override
	public void deleteMember(String id) throws Exception {
		memberDAO.delete(id);
	}

	@Override
	public void updateMember(StudentVO student) throws Exception {
		memberDAO.update(student);
	}
	
	@Override
	public void updateMemberList(StudentVO student1, StudentVO student2) throws Exception {
		memberDAO.update(student2);
		memberDAO.update(student1);
	}
	
	
}