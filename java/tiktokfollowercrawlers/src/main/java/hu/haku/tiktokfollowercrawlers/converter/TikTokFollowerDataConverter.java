package hu.haku.tiktokfollowercrawlers.converter;

import hu.haku.tiktokfollowercrawlers.model.BDTikTokFollowerData;
import hu.haku.tiktokfollowercrawlers.persistence.model.TikTokFollowerData;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TikTokFollowerDataConverter {

    public TikTokFollowerData to(BDTikTokFollowerData bdTikTokFollowerData) {
        if (null == bdTikTokFollowerData) {
            return null;
        }

        TikTokFollowerData data = new TikTokFollowerData();
        data.setUpdateTime(new Date());
        data.setNumberOfFans(bdTikTokFollowerData.getActualCount());
        data.setConnectedUser(bdTikTokFollowerData.getConnectedUser());

        return data;
    }

    public BDTikTokFollowerData from(TikTokFollowerData tikTokFollowerData, Long actualNumberOfFollowers) {
        if (null == tikTokFollowerData) {
            return null;
        }

        return BDTikTokFollowerData.builder()
                .connectedUser(tikTokFollowerData.getConnectedUser())
                .previousCount(tikTokFollowerData.getNumberOfFans())
                .actualCount(actualNumberOfFollowers)
                .build();
    }

}
