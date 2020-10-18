package hu.haku.tiktokfollowercrawlers.service;

import hu.haku.tiktokfollowercrawlers.converter.TikTokFollowerDataConverter;
import hu.haku.tiktokfollowercrawlers.model.BDTikTokFollowerData;
import hu.haku.tiktokfollowercrawlers.persistence.model.TikTokFollowerData;
import hu.haku.tiktokfollowercrawlers.persistence.repository.TikTokFollowerCountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TikTokDataService {

    private final TikTokFollowerCountRepository repository;
    private final TikTokFollowerDataConverter converter;

    @Transactional
    public BDTikTokFollowerData createNewRecord(String user, long fans) {
        BDTikTokFollowerData data = getPreviousEntry(user);
        if(data.getPreviousCount() != fans || data.getPreviousCount() == 0L){
            data.setActualCount(fans);
            repository.save(converter.to(data));
        }
        return data;
    }


    private BDTikTokFollowerData getPreviousEntry(String user) {
        Optional<TikTokFollowerData> localData = repository.findTopByConnectedUser(user);
        if (localData.isPresent()) {
            return converter.from(localData.get(), null);
        }
        return BDTikTokFollowerData.builder()
                .actualCount(0L)
                .connectedUser(user)
                .previousCount(0L)
                .build();
    }


}
