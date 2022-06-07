package org.tukorea.di.persistence;

import org.tukorea.di.domain.MemberVO;

public interface MemberDAO {
	public MemberVO read(String id) throws Exception;
	public void add(MemberVO student) throws Exception;

}