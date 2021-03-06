package hu.haku.tiktokfollowercrawlers.client.tiktok;

import hu.haku.tiktokfollowercrawlers.client.tiktok.model.TikTokUserResponse;
import hu.haku.tiktokfollowercrawlers.client.tiktok.model.UserData;
import hu.haku.tiktokfollowercrawlers.configuration.TikTokDataConfig;
import hu.haku.tiktokfollowercrawlers.validator.TikTokRequestValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TikTokClientWrapper {
    private final TikTokClient client;
    private final TikTokRequestValidator validator;
    private final TikTokDataConfig config;

    public Optional<UserData> getUserDataByUserId(String userId) {
        validator.checkTikTokUserRequest(userId);
        TikTokUserResponse tikTokResponseBody = client.getUserDataByUserId(
                userId,
                config.getUserAgent(),
                "www.tiktok.com",
                "tt_webid=6884692678157059589; tt_webid_v2=6884692678157059589"
        );
        return null != tikTokResponseBody ? Optional.of(tikTokResponseBody.getBody().getUserData()) : Optional.empty();
    }
}
