package hu.haku.tiktokfollowercrawlers.events.listener;

import hu.haku.tiktokfollowercrawlers.events.model.TikTokUnfollowEvent;
import lombok.extern.java.Log;
import org.springframework.context.ApplicationListener;

@Log
public class NewUnfollowEventListener implements ApplicationListener<TikTokUnfollowEvent> {

    @Override
    public void onApplicationEvent(TikTokUnfollowEvent event) {
        log.info("Some follower has unfollowed you, follower count: " + event.getEventData().getActualCount());
    }
}
