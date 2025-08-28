package com.khyuna0.member.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.khyuna0.member.dao.MemberDao;
import com.khyuna0.member.dto.MemberDto;


@Controller
public class MemberController {
	
	@Autowired
	private MemberDao memberDao;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@RequestMapping(value = "/join")
	public String join() {
		return "join";
	}
	
	@RequestMapping(value = "/joinOk")
	public String joinOk(HttpServletRequest request, Model model) {
		
		String mid = request.getParameter("memberid");
		String mpw = request.getParameter("memberpw");
		String mname = request.getParameter("membername");
		int mage = Integer.parseInt(request.getParameter("memberage"));
		
		// 기존 방법
//		MemberDao memberDao = new MemberDao();
//		memberDao.insertMember(mid, mpw, mname, mage);
		
		memberDao.insertMember(mid, mpw, mname, mage);
	
		return "redirect:joinOk";
	}
	
	@RequestMapping(value = "/memberlist")
	public String memberlist(Model model) {
		
		List<MemberDto> mDtos = memberDao.searchMembers();
		model.addAttribute("mDtos", mDtos);
		return "memberlist";
	}
	
	@RequestMapping(value = "/searchOk")
	public String searchOk(HttpServletRequest request, Model model) {
		String mid = request.getParameter("memberid");
		MemberDto memberDto = memberDao.searchMember(mid);
		
		model.addAttribute("mDto", memberDto);
		return "searchMember";
	}
	
	@RequestMapping(value = "/searchMember")
	public String searchMember() {
		return "searchMember";
	}
	
}