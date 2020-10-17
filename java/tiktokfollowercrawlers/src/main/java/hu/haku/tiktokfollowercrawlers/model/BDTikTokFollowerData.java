package hu.haku.tiktokfollowercrawlers.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BDTikTokFollowerData {
    private String connectedUser;
    private Long actualCount;
    private Long previousCount;
}
