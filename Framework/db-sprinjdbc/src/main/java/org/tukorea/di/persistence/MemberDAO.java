package org.tukorea.di.persistence;

import java.util.List;

import org.tukorea.di.domain.MemberVO;

public interface MemberDAO {
	public MemberVO read(String id) throws Exception;
	public void add(MemberVO student) throws Exception;
	
	public List<MemberVO> readList() throws Exception;

}