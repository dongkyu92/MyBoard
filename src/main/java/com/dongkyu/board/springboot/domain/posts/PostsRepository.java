package com.dongkyu.board.springboot.domain.posts;


import org.springframework.data.jpa.repository.JpaRepository;

// 보통 ibatis나 Mybatis 등에서 Dao라고 불리는 DB Layer 접근자.
// JPA에선 Repository라고 부르며 인터페이스로 생성
// 단순히 인터페이스 생성 후 JpaRepository를 상속하면 기본적인 CRUD 메소드가 자동 생성.
// JpaRepository<Entity 클래스, PK타입>를 상속
public interface PostsRepository extends JpaRepository<Posts, Long> {

}
