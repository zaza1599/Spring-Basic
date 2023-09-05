package com.fastcampus.ch2;

import java.io.FileNotFoundException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExceptionController {
	
	//아래의 객체들처럼 중복됐을때 사용해주면 좋음
	// try - catch 대신에 @ExceptionHandler를 써줌
	@ExceptionHandler(Exception.class)
	public String catcher(Exception ex, Model m) {
		m.addAttribute("ex", ex);
		return "error";
	}
	
	@ExceptionHandler({NullPointerException.class, FileNotFoundException.class})
	public String catcher2(Exception ex, Model m) {
		m.addAttribute("ex", ex);
		return "error";
	}
	
	
	@RequestMapping("/ex")
	public String main() throws Exception {
		throw new Exception("예외가 발생하였습니다.");
		}
	
	@RequestMapping("/ex2")
	public String main2() throws Exception {
		throw new FileNotFoundException("예외가 발생하였습니다.");
		}
	
//	@RequestMapping("/ex2")
//	public String main2() throws Exception {
//		try {
//			throw new Exception("예외가 발생하였습니다.");
//		} catch (Exception e) {
//	
//			return "error";
//		}
//	}
	
}
