package com.project6.web.serviceImpl;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project6.web.domain.CommonDTO;
import com.project6.web.domain.MemberDTO;
import com.project6.web.mapper.MemberMapper;
import com.project6.web.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService{
	private static final Logger logger = LoggerFactory.getLogger(MemberServiceImpl.class);	
	@Autowired MemberMapper mapper;
	
	@Override
	public void addMember(MemberDTO member) {
		mapper.insertMember(member);
		logger.info("멤버 서비스임플 addMember=====================");
		logger.info("아이디는 {}", member.getUserid());
		logger.info("비밀번호는 {}", member.getPassword());
		logger.info("이름는 {}", member.getName());
	}

	@Override
	public void modifyMember(CommonDTO common) {
		logger.info("멤버 서비스임플 modifyMember도착======================");
		logger.info("beforePass는 {}", common.getBeforePass());
		logger.info("afterPass는 {}", common.getAfterPass());
		mapper.updateMember(common);
	}

	@Override
	public void deleteMember(CommonDTO common) {
		logger.info("멤버 서비스임플 deleteMember======================");
		logger.info("입력받은 현재비밀번호는 {} ", common.getNowPass());
		mapper.deleteMember(common);
	}

	@Override
	public MemberDTO findById(MemberDTO member) {
		MemberDTO k = mapper.selectOne(member);
		return k;
	}

	@Override
	public List<MemberDTO> findByName(MemberDTO member) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MemberDTO> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean exist(MemberDTO member) {
	    int s = mapper.count(member);
	    boolean m = false;
	    if(s!=0) {
	    	m = true; 
	    }else {
	    	m = false;
	    }
		logger.info("멤버 서비스임플 exist도착=====================");
		logger.info("멤버 서비스임플 exist도착 userid는 {}", member.getUserid());
		logger.info("멤버 서비스임플 exist도착 password는 {}", member.getPassword());
		logger.info("로그인 카운트 m의 값은 {}", m);
		return m;
	}

	
}
