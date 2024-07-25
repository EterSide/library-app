package com.group.libraryapp.domain.user.loanhistory;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserLoanHisotryRepository extends JpaRepository<UserLoanHistory, Long> {

    // select * from user where book_name = ? and is_return = ?
    boolean existsByBookNameAndIsReturn(String name, boolean isReturn);

    //Optional<UserLoanHistory> findByUserIdAndBookName(long userId, String bookName);
}
