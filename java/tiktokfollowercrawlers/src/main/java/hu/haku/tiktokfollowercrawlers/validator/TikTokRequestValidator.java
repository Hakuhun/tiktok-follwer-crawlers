package hu.haku.tiktokfollowercrawlers.validator;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class TikTokRequestValidator {
    public void checkTikTokUserRequest(String id){
        if(StringUtils.isEmpty(id)){
            throw new IllegalArgumentException("{ID} could not be empty");
        }
        if(!id.startsWith("@")){
            throw new IllegalArgumentException("{ID} must starts with @ character");
        }
    }
}
