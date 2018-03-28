package com.project6.web.mapperImpl;

import java.util.List;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.project6.web.domain.CommonDTO;
import com.project6.web.domain.MemberDTO;
import com.project6.web.mapper.MemberMapper;

@Repository
public class MemberMapperImpl implements MemberMapper {
	private static final Logger logger = LoggerFactory.getLogger(MemberMapperImpl.class);	
	@Autowired SqlSessionTemplate SqlSession;
	@Autowired MemberDTO member;
	String ns ="com.project6.web.mapperImpl.MemberMapperImpl.";
	
	@Override
	public void insertMember(MemberDTO member) {
		logger.info("멤버 매퍼임플 insertMember==========================");
		logger.info("아이디는 {}", member.getUserid());
		logger.info("비밀번호는 {}", member.getPassword());
		logger.info("이름는 {}", member.getName());
		SqlSession.insert(ns+"insertMember", member);
	
	}

	@Override
	public void updateMember(CommonDTO common) {
		logger.info("멤버 매퍼임플 updateMember도착======================");
		logger.info("beforePass는 {}", common.getBeforePass());
		logger.info("afterPass는 {}", common.getAfterPass());
		SqlSession.update(ns+"updateMember", common);
	}

	@Override
	public void deleteMember(CommonDTO common) {
		logger.info("멤버 매퍼임플 deleteMember======================");
		logger.info("입력받은 현재비밀번호는 {} ", common.getNowPass());
		SqlSession.delete(ns+"deleteMember",common);
	}

	@Override
	public MemberDTO selectOne(MemberDTO member) {
		MemberDTO g = SqlSession.selectOne(ns+"selectOne", member);
		return g;
	}

	@Override
	public List<MemberDTO> selectList(MemberDTO member) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MemberDTO> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int count(MemberDTO member) {
		logger.info("멤버 매퍼임플 count 도착================================");
		logger.info("멤버 매퍼임플 count도착 userid는 {}", member.getUserid());
		logger.info("멤버 매퍼임플 count도착 password는 {}", member.getPassword());
		int s = SqlSession.selectOne(ns+"count", member);
		return s;
	}

}
