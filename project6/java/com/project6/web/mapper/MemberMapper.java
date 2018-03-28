package com.project6.web.mapper;

import java.util.List;
import org.springframework.stereotype.Component;

import com.project6.web.domain.CommonDTO;
import com.project6.web.domain.MemberDTO;

@Component
public interface MemberMapper {
	public void insertMember(MemberDTO member);
	public void updateMember(CommonDTO common);
	public void deleteMember(CommonDTO common);
	public MemberDTO selectOne(MemberDTO member);
	public List<MemberDTO> selectList(MemberDTO member);
	public List<MemberDTO> selectAll();
	public int count(MemberDTO member);
}
