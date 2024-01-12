package com.moaaz.wuzzufmostaql.Controller.Developer;

import com.moaaz.wuzzufmostaql.Dto.DeveloperOfferDto;
import com.moaaz.wuzzufmostaql.Model.DeveloperOffer;
import com.moaaz.wuzzufmostaql.Service.DeveloperOfferService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/moaaz/wuzzufmostaql/api/developer/offers")
public class DeveloperOfferController {

    @Autowired
    private DeveloperOfferService developerOfferService;

    @PostMapping("/add/developer/{developerId}/clientProject/{clientProjectId}")
    @ResponseStatus(HttpStatus.CREATED)
    public DeveloperOffer addDeveloperOfferForClientProject(@RequestBody @Valid DeveloperOfferDto developerOfferDto,
                                                            @PathVariable long developerId,
                                                            @PathVariable long clientProjectId) {

        return developerOfferService.addDeveloperOffer(developerOfferDto, developerId, clientProjectId);
    }

    @GetMapping("/getAll/{developerId}")
    @ResponseStatus(HttpStatus.OK)
    public List<DeveloperOffer> getAllOffersForDeveloper(@PathVariable long developerId) {
        return developerOfferService.getAllDeveloperOffers(developerId);
    }
}
