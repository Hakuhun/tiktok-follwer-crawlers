package hu.haku.tiktokfollowercrawlers.persistence.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "followercountdata")
@Data
public class TikTokFollowerData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date updateTime;
    private Long numberOfFans;
    private String connectedUser;
}
