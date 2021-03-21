package com.dongkyu.board.springboot.web.dto;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HelloResponseDtoTest {

    @Test
    public void 롬복_기능_테스트(){
        //given
        String name = "test";
        int amout = 1000;

        //when
        HelloResponseDto dto = new HelloResponseDto(name, amout);

        //then
        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amout);
        // assertj라는 테스트 검증 라이브러리의 검증 메소드임.
        // 검증하고 싶은 대상을 메소드 인자로 받음.
        // 메소드 체이닝이 지원되어 isEqualTo와 같이 메소드를 이어서 사용할 수 있음.

        //Junit에서 제공하는 assertThat이 아닌 assertj의 assertThat을 사용하는 이유.
        // 추가적인 라이브러리가 필요하지 않음.
        // 자동완성이 좀 더 확실하게 지원됨.
    }
}
