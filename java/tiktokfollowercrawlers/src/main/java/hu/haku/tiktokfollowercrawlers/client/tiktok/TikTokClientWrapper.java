package hu.haku.tiktokfollowercrawlers.client.tiktok;

import hu.haku.tiktokfollowercrawlers.client.tiktok.model.Body;
import hu.haku.tiktokfollowercrawlers.configuration.TikTokDataConfig;
import hu.haku.tiktokfollowercrawlers.validator.TikTokRequestValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TikTokClientWrapper {
    private final TikTokClient client;
    private final TikTokRequestValidator validator;
    private final TikTokDataConfig config;

    public Optional<Body> getUserDataByUserId(String userId) {
        validator.checkTikTokUserRequest(userId);
        Body tikTokResponseBody = client.getUserDataByUserId(userId, config.getUserAgent());
        return null != tikTokResponseBody ? Optional.of(tikTokResponseBody) : Optional.empty();
    }
}
