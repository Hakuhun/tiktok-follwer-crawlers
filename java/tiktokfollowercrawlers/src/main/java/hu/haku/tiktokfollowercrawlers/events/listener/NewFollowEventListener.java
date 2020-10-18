package hu.haku.tiktokfollowercrawlers.events.listener;

import hu.haku.tiktokfollowercrawlers.events.model.TikTokFollowerEvent;
import lombok.extern.java.Log;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
@Log
public class NewFollowEventListener implements ApplicationListener<TikTokFollowerEvent> {
    @Override
    public void onApplicationEvent(TikTokFollowerEvent event) {
        log.info("New follower(s) have started to follow you "+ event.getEventData().getConnectedUser() +", follower count: " + event.getEventData().getActualCount());
    }
}
