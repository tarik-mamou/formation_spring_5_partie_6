package spring.partie6.rest;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import spring.partie6.persistence.ConfigurationPersistence;
import spring.partie6.service.ConfigurationService;

//@SpringBootApplication(scanBasePackageClasses = {ConfigurationPersistence.class,ConfigurationRest.class})
@SpringBootApplication(scanBasePackageClasses = {ConfigurationService.class,ConfigurationRest.class})
public class RestApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestApplication.class, args);
    }


}
