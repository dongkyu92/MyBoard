package com.dongkyu.board.springboot.web;

import com.dongkyu.board.springboot.web.HelloController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//java.lang.IllegalStateException: Unable to find a @SpringBootConfiguration,
// you need to use @ContextConfiguration or @SpringBootTest(classes=...) with your test
// 원래 패키지와 테스트 패키지의 경로가 동일하지 않을 때 발생하는 오류.


@RunWith(SpringRunner.class)
// 테스트를 진행할때 Junit에 내장된 실행자 외에 다른 실행자를 실행
// 여기서는 SpringRunner라는 스프링 실행자를 사용
// 즉, 스프링 부트 테스트와 JUnit 사이에 연결자 역할을 함.
@WebMvcTest(controllers = HelloController.class)
// 여러 스프링 테스트 어노테이션 중, Web(spring mvc)에 집중할 수 있는 어노테이션.
// 선언할 경우 @Controller, @ControllerAdvice 등을 사용할 수 있음.
// 단, Service, @component, @Repository 등은 사용할 수 없음. 여기서는 컨트롤러만 사용하기 때문에 선언.
public class HelloControllerTest {

    @Autowired
    private MockMvc mvc;
    // 스프링이 관리하는 빈을 주입
    // MockMvc는 웹 API를 테스트할 때 사용.
    // 스프링 MVC 테스트의 시작점. 이 클래스를 통해 HTTP GET, POST 등에 대한 API를 테스트를 할 수 있음.

    @Test
    public void hello가_리턴된다() throws Exception{
        String hello = "hello";

        mvc.perform(get("/hello")) // MockMvc를 통해 /hello 주소로 HTTP GET 요청을 함. 체이닝지원되어 아래에 검증 추가 가능
                .andExpect(status().isOk()) // mvc.perform 결과를 검증. 여기서는 200인지 확인
                .andExpect(content().string(hello)); // 응답 본문의 내용을 검증 hello가 맞는지.
    }
    //1. Preference > Build, Execution, Deployment > Build Tools > Gradle 로 이동
    //2. Run tests using 을 IntelliJ IDEA 로 설정

}
