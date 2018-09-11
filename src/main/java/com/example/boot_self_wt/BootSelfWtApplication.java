package com.example.boot_self_wt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration(exclude = {
		/*关闭Security拦截器*/
		org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class
})
public class BootSelfWtApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootSelfWtApplication.class, args);
	}
}
