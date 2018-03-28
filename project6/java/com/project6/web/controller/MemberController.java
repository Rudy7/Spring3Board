package com.project6.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import com.project6.web.domain.CommonDTO;
import com.project6.web.domain.MemberDTO;
import com.project6.web.factory.ContextFactory;
import com.project6.web.service.MemberService;

@SessionAttributes("loginUser")
@Controller
public class MemberController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	@Autowired ContextFactory contextFactory;
	@Autowired MemberDTO member;
	@Autowired MemberService mService;
	@Autowired CommonDTO common;
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login(Model model) {
		logger.info("멤버컨트롤러 로그인@@==================");
		logger.info("contextFactory.path() 는 {}", contextFactory.path());
		return "user/login";
	}

	@RequestMapping(value="/login/check", method=RequestMethod.POST)
	public String loginCheck(Model model,
			@RequestParam("inp-login-userid")String userid,
			@RequestParam("inp-login-password")String password
			) {
			String path = "user/login";
			logger.info("멤버컨트롤러 loginCheck도착============================");
			logger.info("멤버컨트롤러 loginCheck도착 userid는 {}", member.getUserid());
			logger.info("멤버컨트롤러 loginCheck도착 password는 {}", member.getPassword());
			member.setUserid(userid);
			member.setPassword(password);
			boolean t = mService.exist(member);
			if(t) {
				logger.info("t는 {}", t);
				model.addAttribute("loginUser",mService.findById(member));
				path = "user/mypage";
			}
		return path;
	}
	
	
	@RequestMapping(value="/join", method=RequestMethod.GET)
	public String join(Model model) {
		logger.info("멤버컨트롤러 조인==========================");
		logger.info("contextFactory.path() 는 {}", contextFactory.path());
		return "user/join";
	}

	@RequestMapping(value="/login/open", method=RequestMethod.POST)
	public String login(Model model,
			@RequestParam("inp-join-userid")String userid,
			@RequestParam("inp-join-password")String password,
			@RequestParam("inp-join-name")String name
			) {
		logger.info("멤버컨트롤러 마이페이지 도착=======================");
		member.setUserid(userid);
		member.setPassword(password);
		member.setName(name);
		mService.addMember(member);
		logger.info("아이디는 {}", member.getUserid());
		logger.info("비밀번호는 {}", member.getPassword());
		logger.info("이름는 {}", member.getName());
		return "user/login";
	}
	
	@RequestMapping(value="/change", method=RequestMethod.GET)
	public String change(Model model) {
		logger.info("멤버컨트롤러 change 도착 =====================");
		return "user/change";
	}
	
	@RequestMapping(value="/login/change", method=RequestMethod.POST)
	public String passChange(Model model,
			@RequestParam("inp-change-before")String beforePass,
			@RequestParam("inp-change-after")String afterPass
			) {
		logger.info("멤버컨트롤러 passChange 도착 ============");
		common.setAfterPass(afterPass);
		common.setBeforePass(beforePass);
		logger.info("beforePass는 {}", common.getBeforePass());
		logger.info("afterPass는 {}", common.getAfterPass());
		mService.modifyMember(common);
		return "user/login";
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public String delete(Model model) {
		logger.info("멤버컨트롤러 delete도착====================");
		logger.info("아이디는 {}", member.getUserid());
		logger.info("비밀번호는 {}", member.getPassword());
		return "user/delete";
	}
	
	@RequestMapping(value="/delete/member", method=RequestMethod.POST)
	public String deleteMember(Model model,
			@RequestParam("inp-delete-password")String nowPass
			) {
		logger.info("멤버컨트롤러 deleteMember======================");
		common.setNowPass(nowPass);
		logger.info("입력받은 현재비밀번호는 {} ", common.getNowPass());
		mService.deleteMember(common);
		return "user/login";
	}	

}

