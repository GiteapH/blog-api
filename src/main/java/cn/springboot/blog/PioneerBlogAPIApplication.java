package cn.springboot.blog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


@MapperScan("cn.springboot.blog.dao")
@SpringBootApplication
public class PioneerBlogAPIApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(PioneerBlogAPIApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(PioneerBlogAPIApplication.class, args);
    }
}
