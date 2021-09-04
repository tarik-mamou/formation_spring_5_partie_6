package spring.partie6.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = "spring.partie6")
public class LigneDeCommandeApplication {

    public static void main(String[] args) {
        SpringApplication.run(LigneDeCommandeApplication.class, args);
    }


}
