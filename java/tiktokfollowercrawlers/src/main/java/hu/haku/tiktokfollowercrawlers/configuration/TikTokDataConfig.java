package hu.haku.tiktokfollowercrawlers.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Data
@Configuration
@ConfigurationProperties(value = "tiktok")
public class TikTokDataConfig {
    private String url;
    private String userAgent;
    private List<String> users;
}
