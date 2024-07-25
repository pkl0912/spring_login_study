package com.example.spring_login_study;

import com.example.spring_login_study.domain.UserRole;
import com.example.spring_login_study.entity.User;
import com.example.spring_login_study.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class MakeInitData {

    private final UserRepository userRepository;

    @PostConstruct
    public void makeAdminAndUser() {
        User admin = User.builder()
                .loginId("admin")
                .password("1234")
                .nickname("관리자")
                .role(UserRole.ADMIN)
                .build();
        userRepository.save(admin);

        User user = User.builder()
                .loginId("user")
                .password("1234")
                .nickname("User1")
                .role(UserRole.USER)
                .build();
        userRepository.save(user);
    }
}