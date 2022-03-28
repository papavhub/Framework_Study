package org.tukorea.di.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.tukorea.di.domain.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class MemberDAOImpl implements MemberDAO {

		@Autowired
		JdbcTemplate jdbcTemplate;
		
		public MemberVO read(String id) throws Exception {
			MemberVO vo = null;
			try {
				vo = jdbcTemplate.queryForObject("SELECT * FROM STUDENT WHERE ID=?", new BeanPropertyRowMapper<MemberVO>(MemberVO.class), id);
			}
			catch(EmptyResultDataAccessException e) {
				return vo;
			}
			return vo;
		}
		
		public void add(MemberVO vo) throws Exception {
			jdbcTemplate.update("INSERT STUDENT (ID, PASSWD, USERNAME, SNUM, DEPART, MOBILE, EMAIL) VALUES(?, ?, ?, ?, ?, ?, ?)", vo.getId(), vo.getPasswd(), vo.getUsername(), vo.getSnum(), vo.getDepart(), vo.getMobile(), vo.getEmail());
		}
		
		public List<MemberVO> readList() throws Exception {
			List<MemberVO> studentlist = jdbcTemplate.query(
					"SELECT * FROM STUDENT",
					new RowMapper<MemberVO>() {
						public MemberVO mapRow(ResultSet rs, int rowNum) throws SQLException {
							MemberVO vo = new MemberVO();
							vo.setId(rs.getString("ID"));
							vo.setPasswd(rs.getString("PASSWD"));
							vo.setUsername(rs.getString("USERNAME"));
							vo.setSnum(rs.getString("SNUM"));
							vo.setDepart(rs.getString("DEPART"));
							vo.setMobile(rs.getString("MOBILE"));
							vo.setEmail(rs.getString("EMAIL"));
							return vo;
						}
					}
				);
			return studentlist;
		}
}