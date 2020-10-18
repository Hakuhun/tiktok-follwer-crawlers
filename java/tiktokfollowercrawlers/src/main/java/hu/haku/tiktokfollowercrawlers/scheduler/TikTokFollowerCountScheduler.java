package hu.haku.tiktokfollowercrawlers.scheduler;

import hu.haku.tiktokfollowercrawlers.client.tiktok.TikTokClientWrapper;
import hu.haku.tiktokfollowercrawlers.client.tiktok.model.UserData;
import hu.haku.tiktokfollowercrawlers.configuration.TikTokDataConfig;
import hu.haku.tiktokfollowercrawlers.model.BDTikTokFollowerData;
import hu.haku.tiktokfollowercrawlers.persistence.repository.TikTokFollowerCountRepository;
import hu.haku.tiktokfollowercrawlers.service.TikTokDataService;
import hu.haku.tiktokfollowercrawlers.service.TikTokFollowerEventService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Log4j2
@RequiredArgsConstructor
public class TikTokFollowerCountScheduler {

    private final TikTokClientWrapper client;
    private final TikTokDataConfig config;
    private final TikTokFollowerCountRepository repository;
    private final TikTokDataService dataService;
    private final TikTokFollowerEventService eventService;

    @Scheduled(cron = "${scheulder.tiktokcheck}")
    public void countFollowers() {
        for (String user : config.getUsers()) {
            Optional<UserData> userData = client.getUserDataByUserId(user);
            userData.ifPresent(x -> {
                BDTikTokFollowerData data = dataService.createNewRecord(user, x.getFans());
                eventService.createEvent(x.getFans(), data);
            });
        }
    }

}
