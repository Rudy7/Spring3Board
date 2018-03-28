package com.project6.web.domain;

import org.springframework.stereotype.Component;
import lombok.Data;

@Data
@Component
public class Command {
	protected MemberDTO member;
	protected BoardDTO board;
	protected PagiDTO pagi;
	protected CommonDTO common;
	
}
