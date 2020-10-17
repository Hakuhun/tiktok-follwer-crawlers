package hu.haku.tiktokfollowercrawlers.service;

import hu.haku.tiktokfollowercrawlers.events.model.TikTokFollowerEvent;
import hu.haku.tiktokfollowercrawlers.events.model.TikTokUnfollowEvent;
import hu.haku.tiktokfollowercrawlers.model.BDTikTokFollowerData;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TikTokFollowerEventService {

    private final ApplicationEventPublisher applicationEventPublisher;

    public void createEvent(Long actualNumberOfFans, BDTikTokFollowerData data) {
        getEvent(actualNumberOfFans, data).ifPresent(applicationEventPublisher::publishEvent);
    }

    private Optional<TikTokFollowerEvent> getEvent(Long actualNumberOfFans, BDTikTokFollowerData data) {
        if (actualNumberOfFans < data.getPreviousCount()) {
            return Optional.of(new TikTokUnfollowEvent(this, data));
        } else if (actualNumberOfFans > data.getPreviousCount()) {
            return Optional.of(new TikTokFollowerEvent(this, data));
        }
        return Optional.empty();
    }

}
