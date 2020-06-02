package jact.core;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.ApplicationPidFileWriter;

@SpringBootApplication
@EnableAutoConfiguration
@Slf4j
public class JactSimplePlatform {


    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(JactSimplePlatform.class);
        springApplication.addListeners(new ApplicationPidFileWriter("jact-application.pid"));
        springApplication.run(args);
    }
}
