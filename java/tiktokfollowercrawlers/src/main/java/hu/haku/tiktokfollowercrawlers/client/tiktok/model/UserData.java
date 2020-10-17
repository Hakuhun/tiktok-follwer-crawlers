package hu.haku.tiktokfollowercrawlers.client.tiktok.model;

import lombok.Data;

import java.util.List;

@Data
public class UserData{
    public String secUid;
    public String userId;
    public boolean isSecret;
    public String uniqueId;
    public String nickName;
    public String signature;
    public List<String> covers;
    public List<String> coversMedium;
    public int following;
    public long fans;
    public String heart;
    public int video;
    public boolean verified;
    public int digg;
    public boolean ftc;
    public int relation;
    public boolean openFavorite;
}
