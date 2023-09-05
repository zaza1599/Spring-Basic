package com.fastcampus.ch2;

import java.io.FileNotFoundException;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

	@ControllerAdvice // 모든 클래스에서 발생하게 되는 예외를 처리
	// @ControllerAdice("com.fastcampus.ch2") 해당 패키지에서만 예외 처리
	public class GlobalCatcher {
		@ExceptionHandler({NullPointerException.class, FileNotFoundException.class})
		public String catcher2(Exception ex, Model m) {
			m.addAttribute("ex", ex);
			return "error";
		}
	
		@ExceptionHandler(Exception.class)
		public String catcher(Exception ex, Model m) {
			m.addAttribute("ex", ex);
	
			return "error";
		}
	}