package com.moaaz.wuzzufmostaql;

import jakarta.servlet.ServletContext;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
//@EnableAspectJAutoProxy
@Slf4j
public class WuzzufMostaqlApplication {


    public static void main(String[] args) {

        SpringApplication.run(WuzzufMostaqlApplication.class, args);
        log.info("This Application Is Designed And Building With Java Developer Called Moaaz Suliman Saued.");
    }


}
