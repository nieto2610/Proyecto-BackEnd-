package com.turnosclinica.demoturnosclinica.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.beans.Encoder;

@Component
public class DataLoader implements ApplicationRunner {

    private UserRepository userRepository;

    @Autowired
    public DataLoader(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String password = passwordEncoder.encode("password");
        String password1 = passwordEncoder.encode("password1");

        AppUser admin = new AppUser("Marcos", "marcos50", "marcos50@gmail.com", password, AppUsuarioRoles.ADMIN);
        AppUser user = new AppUser("Jose", "jose500", "jose500@gmail.com", password1, AppUsuarioRoles.USER);

        userRepository.save(admin);
        userRepository.save(user);


    }
}
