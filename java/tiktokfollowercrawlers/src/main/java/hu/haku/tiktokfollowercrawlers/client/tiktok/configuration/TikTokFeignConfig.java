package hu.haku.tiktokfollowercrawlers.client.tiktok.configuration;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TikTokFeignConfig {
    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.HEADERS;
    }
}
