package hu.haku.tiktokfollowercrawlers.events.model;

import hu.haku.tiktokfollowercrawlers.model.BDTikTokFollowerData;
import org.springframework.context.ApplicationEvent;

public class TikTokFollowerEvent extends ApplicationEvent implements ITikTokFollowEvent{

    private BDTikTokFollowerData eventData;

    public TikTokFollowerEvent(Object source, BDTikTokFollowerData eventData) {
        super(source);
        this.eventData = eventData;
    }

    public BDTikTokFollowerData getEventData() {
        return this.eventData;
    }
}
