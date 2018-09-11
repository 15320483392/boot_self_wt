package com.example.boot_self_wt;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@MapperScan("com.example.boot_self_wt.domain")
@SpringBootApplication
@ComponentScan({"com.example.boot_self_wt"})
@EnableAutoConfiguration(exclude = {
		/*关闭Security拦截器*/
		org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class
})
public class BootSelfWtApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootSelfWtApplication.class, args);
	}
}
