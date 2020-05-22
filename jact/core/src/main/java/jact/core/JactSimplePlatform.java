package jact.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.ApplicationPidFileWriter;

@SpringBootApplication
public class JactSimplePlatform {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(JactSimplePlatform.class);
        springApplication.addListeners(new ApplicationPidFileWriter("jact-application.pid"));
        springApplication.run(args);
    }
}
