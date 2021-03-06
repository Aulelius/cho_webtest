package com.chowebtest.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@SpringBootApplication // 스프링부트의 자동 설정, 스프링 Beans 읽기와 생성을 모두 자동으로 설정된다.
public class Application {
  // 프로젝트의 메인 클래스
    public static void main(String[]  args) {
        SpringApplication.run(Application.class, args);
    }
}
