package com.moaaz.wuzzufmostaql.Controller.Developer;

import com.moaaz.wuzzufmostaql.Dto.Developer.CareerInterestRequest;
import com.moaaz.wuzzufmostaql.Model.Developer.Developer;
import com.moaaz.wuzzufmostaql.Service.Developer.Imp.DeveloperCareerInterestService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/moaaz/wuzzufmostaql/api/developers/career")
public class DeveloperCareerInterestsController {

    @Autowired
    private DeveloperCareerInterestService developerCareerInterestService;
    @PostMapping("/updateCareer/{developerId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Developer updateDeveloperCareer(@RequestBody @Valid CareerInterestRequest careerInterestRequest, @PathVariable long developerId){
        return developerCareerInterestService.updateDeveloperWithNewCareerInterest(careerInterestRequest, developerId);

    }
}
