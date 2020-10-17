package hu.haku.tiktokfollowercrawlers.events.model;

import hu.haku.tiktokfollowercrawlers.model.BDTikTokFollowerData;

public class TikTokUnfollowEvent extends TikTokFollowerEvent {
    public TikTokUnfollowEvent(Object source, BDTikTokFollowerData eventData) {
        super(source, eventData);
    }
}
