package com.dongkyu.board.springboot.domain.posts;

// 이 domain 패키지는 도메인을 담을 패키지임.
// 여기서 도메인이란 게시글, 댓글, 회원, 정산, 결제 등 소프트웨어에 대한 요구사항 혹은 문제 영역이라 생각하면 됨.
// 기존 Mybatis같은 커리 매퍼를 사용했다면 dao 패키지를 사용했겠지만,
// dao 패키지와는 조금 다름.
// 그동안 xml에 쿼리를 담고, 클래스는 오로지 쿼리의 결과만 담던 일들이 모두
// domain 클래스에서 해결됨.

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Getter // 롬복
@NoArgsConstructor // 롬복
@Entity // JPA 어노테이션, 테이블과 링크될 클래스임을 나타내줌, 기본값으로 클래스의 카멜케이스 이름을 언더스코어 네이밍(_)으로 테이블 이름 매칭.
// ex)SalesManager.java -> sales_manager table
public class Posts {
    // Posts 클래스는 실제 DB의 테이블과 매칭될 클래스이며 보통 Entity 클래스라고도 함.
    // JPA를 사용하면 DB데이터에 작업할 경우 실제 쿼리를 날리기보다는, 이 Entity클래스의 수정을 통해 작업함.
}
