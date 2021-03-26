package com.dongkyu.board.springboot.domain.posts;

// 이 domain 패키지는 도메인을 담을 패키지임.
// 여기서 도메인이란 게시글, 댓글, 회원, 정산, 결제 등 소프트웨어에 대한 요구사항 혹은 문제 영역이라 생각하면 됨.
// 기존 Mybatis같은 커리 매퍼를 사용했다면 dao 패키지를 사용했겠지만,
// dao 패키지와는 조금 다름.
// 그동안 xml에 쿼리를 담고, 클래스는 오로지 쿼리의 결과만 담던 일들이 모두
// domain 클래스에서 해결됨.

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter // 롬복 클래스 내 모든 필드의 Getter 메소드를 자동 생성.
@NoArgsConstructor // 롬복, 기본 생성자 자동추가, public post(){}와 같은 효과
@Entity // JPA 어노테이션, 테이블과 링크될 클래스임을 나타내줌, 기본값으로 클래스의 카멜케이스 이름을 언더스코어 네이밍(_)으로 테이블 이름 매칭.
// ex)SalesManager.java -> sales_manager table
public class Posts {
    // Posts 클래스는 실제 DB의 테이블과 매칭될 클래스이며 보통 Entity 클래스라고도 함.
    // JPA를 사용하면 DB데이터에 작업할 경우 실제 쿼리를 날리기보다는, 이 Entity클래스의 수정을 통해 작업함.

    @Id // 해당 테이블의 PK필드를 나타냄.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // PK의 생성 규칙을 나타냄.
    // 스프링 부트 2.0에서는 GenerationType.IDENTITY옵션을 추가해야만 auto_increment가 됨.
    private Long id;

    @Column(length = 500, nullable = false)
    // 테이블의 칼럼을 나타내며 굳이 선언하지 않더라도 해당 클래스의 필드는 모두 칼럼이 됨.
    // 사용하는 이유는, 기본값 외에 추가로 변경이 필요한 옵션이 있으면 사용.
    // 문자열의 경우 VARCHAR(255)가 기본값인데, 사이즈를 500으로 늘리고 싶거나(ex:title),
    // 타입을 TEXT로 변경하고 싶거나(ex:content) 등의 경우에 사용됨.
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author; 

    @Builder // 해당 클래스의 빌더 패턴 클래스를 생성
    // 지금과 같이 생성자 상단에 선언시 생성자에 포함된 필드만 빌더에 포함.
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }
}

// 자바빈 규약을 생각하면서 getter/setter를 무작정 생성하는 경우가 있음.
// 이렇게 되면 해당 클래스의 인스턴스 값들이 언제 어디서 변해야 하는지 코드상으로 명확하게 구분할 수가 없어, 차후 기능 변경 시 정말 복잡해짐.
// 그래서 Entity 클래스에서는 절대 Setter 메소드를 만들지 않음.
// 대신, 해당 필드의 값 변경이 필요하면 명확히 그 목적과 의도를 나타낼 수 있는 메소드를 추가해야 함.

// Setter가 없는 상황에서 어떻게 값을 채워 DB에 삽입할까?
// 기본적인 구조는 생성자를 통해 최종값을 채운 후 DB에 삽입 하는 것이며, 값 변경이 필요한 경우 해당 이벤트에 맞는
// public 메소드를 호출하여 변경하는 것을 전제로 함.

// @Builder를 통해 제공되는 빌더 클래스를 사용함.
// 생성자나 빌더나 생성 시점에 값을 채워주는 역할은 똑같음.
// 다만, 생성자의 경우 지금 채워야 할 필드가 무엇인지 명확히 지정할 수가 없음.
