package hu.haku.tiktokfollowercrawlers.persistence.repository;

import hu.haku.tiktokfollowercrawlers.persistence.model.TikTokFollowerData;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface TikTokFollowerCountRepository extends CrudRepository<TikTokFollowerData, Long> {

    public Optional<TikTokFollowerData> findTopByConnectedUser(String connectedUser);
}
