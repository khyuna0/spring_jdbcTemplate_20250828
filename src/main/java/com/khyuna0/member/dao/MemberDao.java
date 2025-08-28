package com.khyuna0.member.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.khyuna0.member.dto.MemberDto;

@Repository
public class MemberDao {
	
	@Autowired // DI 자동 주입 -> 컨테이너에 생성된 bean(객체) 자동 주입
	JdbcTemplate jdbctemplate;
	
	// Insert 문 -> 회원 추가 구현
	public void insertMember(String memberid, String memberpw, String membername, int memberage) {	
		String sql = "INSERT INTO membertbl VALUES (?,?,?,?) ";
		jdbctemplate.update(sql, memberid, memberpw, membername, memberage);	
	}
	
	//  Delete 문 -> 회원 삭제
	public int deleteMember(String memberid) {	
		String sql = "DELETE FROM membertbl WHERE memberid =? ";
		int result = jdbctemplate.update(sql, memberid);
		// update -> 삭제한 레코드 수를 반환 (기본키로 검색했기 때문에 성공 시 1, 실패 시 0 반환)
		return result;
	}
	
	// UPDATE 문 
	public void updateMember(String memberid, String memberpw, String membername, int memberage) {	
		String sql = "UPDATE membertbl SET memberid=?,memberpw=?, membername=?,memberage=? WHERE memberid =? ";
		jdbctemplate.update(sql, memberid, memberpw, membername, memberage);
		// 정보 수정한 레코드 수를 반환 (기본키로 검색했기 때문에 성공 시 1, 실패 시 0 반환)
	}
	
	// SELECT 문 -> 회원 한 명만 조회
	public MemberDto searchMember(String memberid) {
		String sql = "SELECT * FROM membertbl WHERE memberid =? ";
		//MemberDto memberdto = jdbctemplate.queryForObject(sql, new BeanPropertyRowMapper<MemberDto>(MemberDto.class),memberid);
		//return memberdto;
		
		// 바로 return 하기
		// 가져올 레코드가 한 개일 때는 .queryForObject
		return jdbctemplate.queryForObject(sql, new BeanPropertyRowMapper<MemberDto>(MemberDto.class),memberid);
	}
	
	// SELECT 문 -> 회원 전체를 조회
	public List<MemberDto> searchMembers() {
		String sql = "SELECT * FROM membertbl ";
		// 가져올 레코드가 여러개일 때는 .query 사용
		return jdbctemplate.query(sql, new BeanPropertyRowMapper<MemberDto>(MemberDto.class));
	}
}

