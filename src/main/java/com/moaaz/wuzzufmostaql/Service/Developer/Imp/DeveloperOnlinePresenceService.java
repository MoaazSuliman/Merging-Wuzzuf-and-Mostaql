package com.moaaz.wuzzufmostaql.Service.Developer.Imp;

import com.moaaz.wuzzufmostaql.Dto.Developer.OnlinePresenceRequest;
import com.moaaz.wuzzufmostaql.Model.Developer.Developer;
import com.moaaz.wuzzufmostaql.Model.Developer.OnlinePresence;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DeveloperOnlinePresenceService {

    @Autowired
    private DeveloperService developerService;

    public void putDeveloperOnlinePresence(OnlinePresenceRequest onlinePresenceRequest,
                                           long developerId) {
        Developer developer = developerService.getByIdOrElseThrowException(developerId);
        OnlinePresence onlinePresence = OnlinePresence
                .builder()
                .links(onlinePresenceRequest.getLinks())
                .build();
        if (developer.getOnlinePresence() != null) {
            log.info("Developer Online Presence Not Null");
            onlinePresence.setId(developer.getOnlinePresence().getId());
        }

        developer.setOnlinePresence(onlinePresence);
        developerService.updateDeveloper(developer);
    }
}
