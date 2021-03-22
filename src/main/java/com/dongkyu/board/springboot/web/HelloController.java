package com.dongkyu.board.springboot.web;

import com.dongkyu.board.springboot.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// 컨트롤러를 JSON을 반환하는 컨트롤러로 만들어줌.
@RestController
public class HelloController {

    @GetMapping("/hello/")
    public String hello(){
        return "hello";
    }
    // HTTP Method인 Get의 요청을 받을 수 있는 API를 만들어줌.
    // RequestMapping(method = RequestMethod.GET)과 같은 역할.

    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name, @RequestParam("amount") int amount){
        return new HelloResponseDto(name, amount);
    }
}

// 이 코드가 제대로 작동하는지 테스트하기 위해 WAS를 실행하지 않고, 테스트 코드로 검증해봄.
// src/test/java에 동일한 패키지 생성.