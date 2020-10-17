package hu.haku.tiktokfollowercrawlers.client.tiktok.model;

import lombok.Data;

import java.util.List;

@Data
public class Body{
    public PageState pageState;
    public UserData userData;
    public ShareUser shareUser;
    public ShareMeta shareMeta;
    public int statusCode;
    public List<LangList> langList;
    public String predictedLanguage;
    public MetaParams metaParams;
    public List<Object> itemList;
    public DescVideo descVideo;
}
