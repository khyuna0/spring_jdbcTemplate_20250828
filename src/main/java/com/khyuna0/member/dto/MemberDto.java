package com.khyuna0.member.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class MemberDto {
	private String memberid;
	private String memberpw;
	private String membername;
	private int memberage;
}