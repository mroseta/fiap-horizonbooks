package com.horizonbooks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableFeignClients
@Configuration
@SpringBootApplication
@ImportAutoConfiguration({FeignAutoConfiguration.class})
@EnableJpaRepositories
public class HorizonBooksApplication {

	public static void main(String[] args) {
		SpringApplication.run(HorizonBooksApplication.class, args);
	}

}
