package org.tukorea.di.persistence;

import java.util.HashMap;
import java.util.Map;

import org.tukorea.di.domain.MemberVO;

public class MemberDAOImpl implements MemberDAO {
		private Map<String, MemberVO> storage = new HashMap<String, MemberVO>();
		
		public MemberVO read(String id) throws Exception { return storage.get(id); }
		
		public void add(MemberVO student) throws Exception {
			storage.put(student.getId(), student);
		}
}