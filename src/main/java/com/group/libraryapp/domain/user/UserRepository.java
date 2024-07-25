package com.group.libraryapp.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    //User findByName(String name);
    // find라고 작성하면 한 개의 데이터만 By뒤에 붙는게 Where 부분
    Optional<User> findByName(String name);

    // by 앞에 올 수 있는것
    // find findall exist count
    // 뒤에 오는 것 and나 or을 조합할 수 있다
    // GreaterThan 초과 GreaterThanEqual 이상 LessThan 미만 등등 있다

    
}
