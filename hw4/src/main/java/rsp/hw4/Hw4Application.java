package rsp.hw4;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SuppressWarnings("SpringBootApplicationSetup")
@SpringBootApplication(scanBasePackages = {"rsp.hw4"})
@EnableAutoConfiguration(exclude = {
        org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class
})

public class Hw4Application {
    private static final Logger log = LoggerFactory.getLogger(Hw4Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Hw4Application.class, args);
    }

}
