package com.project6.web.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.project6.web.domain.CommonDTO;
import com.project6.web.domain.MemberDTO;

@Component
public interface MemberService {
	public void addMember(MemberDTO member);
	public void modifyMember(CommonDTO common);
	public void deleteMember(CommonDTO common);
	public MemberDTO findById(MemberDTO member);
	public List<MemberDTO> findByName(MemberDTO member);
	public List<MemberDTO> findAll();
	public boolean exist(MemberDTO member);
}
