package com.fastcampus.ch2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

// 1. 원격 호출 가능한 프로그램으로 등록
@Controller
public class Hello {
	int iv = 10; // 인스턴스 변수
	static int cv = 20; // static 변수
	
	
	
	// 2. URL과 메서드를 연결
	@RequestMapping("/hello")
	@ResponseBody
	public void main() { // 인스턴스 메서드 - iv, cv를 둘 다 사용 가능
		System.out.println("Hello - static");
		System.out.println(cv); // OK
		System.out.println(iv); // OK
		
		System.out.println("Hello");
	}
	
	public static void main2() { // static 메서드 - cv만 사용 가능
		
		System.out.println(cv); // OK
		//System.out.println(iv); // 에러
		
	}
}

