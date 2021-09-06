package spring.partie6.mvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


@SpringBootApplication(scanBasePackages = "spring.partie6")
public class MvcApplicationPourDeploiement  extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(MvcApplicationPourDeploiement.class, args);
    }


}
