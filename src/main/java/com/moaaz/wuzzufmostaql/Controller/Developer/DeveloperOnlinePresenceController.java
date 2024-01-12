package com.moaaz.wuzzufmostaql.Controller.Developer;

import com.moaaz.wuzzufmostaql.Dto.Developer.OnlinePresenceRequest;
import com.moaaz.wuzzufmostaql.Service.Developer.Imp.DeveloperOnlinePresenceService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/moaaz/wuzzufmostaql/api/onlinePresence")
public class DeveloperOnlinePresenceController {

    @Autowired
    private DeveloperOnlinePresenceService developerOnlinePresenceService;

    @PostMapping("/put/{developerId}")
    public String putOnlinePresence(@RequestBody @Valid OnlinePresenceRequest onlinePresenceRequest
            , @PathVariable long developerId) {
        developerOnlinePresenceService.putDeveloperOnlinePresence(onlinePresenceRequest, developerId);
        return "Updated Online Presence Successfully...";
    }

}
