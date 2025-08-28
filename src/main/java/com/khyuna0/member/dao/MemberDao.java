package com.khyuna0.member.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDao {
	
	@Autowired // DI 자동 주입 -> 컨테이너에 생성된 bean(객체) 자동 주입
	JdbcTemplate jdbctemplate;
	
	// Insert 문 -> 회원 추가 구현
	public void insertMember(String memberid, String memberpw, String membername, int memberage) {
		
		String sql = "INSERT INTO membertbl VALUES (?,?,?,?) ";
		jdbctemplate.update(sql, memberid, memberpw, membername, memberage);
		
	}
}

