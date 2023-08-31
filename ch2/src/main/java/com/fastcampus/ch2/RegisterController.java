package com.fastcampus.ch2;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RegisterController {
	
	@RequestMapping(value="/register/add", method= {RequestMethod.GET, RequestMethod.POST})
	public String register() {
		return "registerForm"; //WEB-INF/views/registerForm.jsp
	}
	
	@PostMapping("/register/save")
	public String save(User user, Model m) throws Exception {
		// 1. 유효성 검사
		if(!isValid(user)) {
			String msg= URLEncoder.encode("id를 잘 못 입력하셨습니다.", "utf-8");
			
			m.addAttribute("msg", msg);
			return "forward:/register/add";
// 		==	return "redirect:/register/add?msg" +msg; // URL 재작성(rewriting)
		}
		
		// 2. DB에 신규회원 정보를 저장
		
		return "registerInfo";
	}

	private boolean isValid(User user) {
		
		return false;
	}
}
