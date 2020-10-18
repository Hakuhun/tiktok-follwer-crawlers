package hu.haku.tiktokfollowercrawlers.client.tiktok;

import hu.haku.tiktokfollowercrawlers.client.tiktok.configuration.TikTokFeignConfig;
import hu.haku.tiktokfollowercrawlers.client.tiktok.model.Body;
import hu.haku.tiktokfollowercrawlers.client.tiktok.model.TikTokUserResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(
        name = "tiktok-api",
        url = "${tiktok.url}",
        configuration = TikTokFeignConfig.class
)
interface TikTokClient {
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/user/{userId}"
    )
    public TikTokUserResponse getUserDataByUserId(
            @PathVariable("userId") String userId,
            @RequestHeader("user-agent") String userAgent,
            @RequestHeader("Host") String host
    );

}
