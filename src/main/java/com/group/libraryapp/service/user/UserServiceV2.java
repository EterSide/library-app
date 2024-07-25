package com.group.libraryapp.service.user;


import com.group.libraryapp.domain.user.User;
import com.group.libraryapp.domain.user.UserRepository;
import com.group.libraryapp.dto.user.request.UserCreateRequest;
import com.group.libraryapp.dto.user.request.UserUpdateRequest;
import com.group.libraryapp.dto.user.response.UserResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceV2 {

    private final UserRepository userRepository;

    public UserServiceV2(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Transactional // org으로 시작하는 걸로
    public void saveUser(UserCreateRequest request) {
        User u = userRepository.save(new User(request.getName(), request.getAge()));
        // 미리 만들어져있는 save에 넣기만하면 insert문은 알아서 완성된다
        //throw new IllegalArgumentException(); 롤백됨
    }
    @Transactional(readOnly = true) // select문만 쓰는 경우에는 readOnly옵션으로 성능향상
    public List<UserResponse> getUsers() {
        return userRepository.findAll().stream()
        .map(UserResponse::new)
                .collect(Collectors.toList());
    }
    @Transactional // 이걸 쓰면 영속성 컨텍스트도 생겨난다
    public void updateUser(UserUpdateRequest request) {
        User user = userRepository.findById(request.getId())
                .orElseThrow(IllegalArgumentException::new);

        user.updateName(request.getName()); // 바뀌면 바로 느끼고 수정
        //userRepository.save(user); // 변경된 점을 바로 업데이트
    }
    @Transactional
    public void deleteUser(String name) {
        // select * from user where name = ?
        User user = userRepository.findByName(name)
                .orElseThrow(IllegalArgumentException::new);
        // findbyid는 있어도 findbyname은 없다 그래서 Repository 인터페이스로 가서 만들어라


        userRepository.delete(user);
    }
}
