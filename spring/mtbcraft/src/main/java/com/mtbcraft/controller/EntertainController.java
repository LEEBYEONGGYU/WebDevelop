package com.mtbcraft.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EntertainController {
	//경쟁전
	@RequestMapping("/entertainment/competitions")
	public String competitions() {
		return "/entertainment/competitions";
	}
	
	//미션
		@RequestMapping("/entertainment/missions")
		public String missions() {
			return "/entertainment/competitions";
		}
	
	
}
