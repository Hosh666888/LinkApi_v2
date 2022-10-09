package pro.goforit;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@MapperScan(basePackages = {"pro.goforit.mapper"})
@EnableWebMvc
public class LinkApisV2Application {

    public static void main(String[] args) {
        SpringApplication.run(LinkApisV2Application.class, args);
    }

}
