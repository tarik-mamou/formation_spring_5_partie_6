package spring.partie6.mbeans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//depuis https://nullbeans.com/create-configure-and-test-a-jmx-mbean-in-spring-boot-using-java-config-and-jolokia/
@Configuration
public class MbeansConfiguration {


    @Bean
    public JmxBean bean()
    {
        return new JmxBean();

    }
}
