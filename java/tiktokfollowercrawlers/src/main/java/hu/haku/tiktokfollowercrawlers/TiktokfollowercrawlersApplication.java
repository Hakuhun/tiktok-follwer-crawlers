package hu.haku.tiktokfollowercrawlers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableJpaRepositories
@EnableFeignClients
public class TiktokfollowercrawlersApplication {

	public static void main(String[] args) {
		SpringApplication.run(TiktokfollowercrawlersApplication.class, args);
	}

}
