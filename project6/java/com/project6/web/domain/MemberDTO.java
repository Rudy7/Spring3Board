package com.project6.web.domain;

import org.springframework.stereotype.Component;
import lombok.Data;

@Component
@Data
public class MemberDTO {
	private String userid, password, name, regdate;

}
