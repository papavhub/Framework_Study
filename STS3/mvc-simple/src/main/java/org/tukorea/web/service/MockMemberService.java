package org.tukorea.web.service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import org.tukorea.web.domain.StudentVO;
import org.tukorea.web.exception.DataNotFoundException;

@Service
public class MockMemberService implements MemberService {
	
	private Map<String, StudentVO> storage = new HashMap<String, StudentVO>();
	
	@PostConstruct
	public void init() {
		StudentVO vo = new StudentVO();
		vo.setId("kang");
		vo.setPasswd("kangho");
		vo.setSnum("20181010");
		vo.setDepart("computer");
		vo.setMobile("010-2222-3333");
		vo.setEmail("kang@tukorea.ac.kr");
		
		try {
			storage.put(vo.getId(), vo);
		}catch(Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public StudentVO readMember(String id) throws Exception {
		if(storage.get(id) == null) throw new DataNotFoundException(id);
		return storage.get(id);
	}

	@Override
	public void addMember(StudentVO student) throws Exception {
		storage.put(student.getId(), student);
	}

	@Override
	public List<StudentVO> readMemberList() throws Exception {
		List<StudentVO> list = new LinkedList<StudentVO>();
		for(StudentVO customer : storage.values()) {
			list.add(customer);
		}
		return list;
	}

	@Override
	public void updateMember(StudentVO student) throws Exception {
		if(storage.get(student.getId()) != null) {
			storage.remove(student.getId());
		}
		storage.put(student.getId(), student);
	}

	@Override
	public void deleteMember(String id) throws Exception {
		storage.remove(id);
	}
	
}