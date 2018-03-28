package com.project6.web.domain;

import org.springframework.stereotype.Component;
import lombok.Data;

@Component
@Data
public class CommonDTO {
	private String beforePass,afterPass,nowPass,deleNum;
}
