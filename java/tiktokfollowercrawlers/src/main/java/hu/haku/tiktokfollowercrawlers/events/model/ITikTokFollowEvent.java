package hu.haku.tiktokfollowercrawlers.events.model;

import hu.haku.tiktokfollowercrawlers.model.BDTikTokFollowerData;

public interface ITikTokFollowEvent {
    public BDTikTokFollowerData getEventData();
}
