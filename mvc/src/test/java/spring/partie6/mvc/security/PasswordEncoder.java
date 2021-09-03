package spring.partie6.mvc.security;

import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoder {

    public static void main(String[] args) {

            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String password [] = {"pasword1", "pasword2", "pasword3"};
            for(int i = 0; i < password.length; i++)
                System.out.println(passwordEncoder.encode(password[i]));

    }

}
