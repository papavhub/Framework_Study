package org.tukorea.di.service;

import java.util.List;

import org.tukorea.di.domain.MemberVO;
import org.tukorea.di.domain.MemberVO;

public interface MemberService {
	public MemberVO readMember(String id) throws Exception;
	public void addMember(MemberVO student) throws Exception;
	
	public List<MemberVO> readMemberList() throws Exception;
}