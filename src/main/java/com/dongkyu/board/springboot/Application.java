package com.dongkyu.board.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    public static void main(String args[]){
        SpringApplication.run(Application.class, args);
        // SpringApplication.run으로 인해 내장 WAS를 실행함.
        // 이렇게 되면 항상 서버에 톰캣을 설치할 필요가 없게 되고,
        // 스프링 부트로 만들어진 Jar파일(실행가능한 Java 패키징 파일)로 실행하면 됨.

        // 스프링 부트에서는 내장 WAS를 사용하는 것을 권장하고 있음.
        // 언제 어디서나 같은 환경에서 스프링 부트를 배포할 수 있기 때문.
        // 대표적인 WAS인 톰캣 역시 서블릿으로 이루어진 자바 애플리케이션.

    }
}
