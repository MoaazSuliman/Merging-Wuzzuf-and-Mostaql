package com.moaaz.wuzzufmostaql.Controller.Developer;

import com.moaaz.wuzzufmostaql.Dto.Developer.ExperienceRequest;
import com.moaaz.wuzzufmostaql.Service.Developer.Imp.DeveloperExperienceService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/moaaz/wuzzufmostaql/api/developers/experiences")
public class DeveloperExperienceController {

    @Autowired
    private DeveloperExperienceService developerExperienceService;


    @PostMapping("/add/{developerId}")
    @ResponseStatus(HttpStatus.CREATED)
    public String addExperience(@RequestBody @Valid ExperienceRequest experienceRequest,
                                @PathVariable long developerId) {
        developerExperienceService.addExperience(experienceRequest, developerId);
        return "Add Experience For Developer Successfully...";

    }

    @PutMapping("update/{experienceId}/developer/{developerId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String deleteExperience(@PathVariable long developerId,
                                   @PathVariable long experienceId,
                                   @RequestBody @Valid ExperienceRequest experienceRequest) {


        developerExperienceService.updateExperience(experienceRequest, experienceId, developerId);
        return "Updated Experience Successfully...";
    }

    @DeleteMapping("delete/{experienceId}/developer/{developerId}")
    @ResponseStatus(HttpStatus.OK)
    public String deleteExperience(@PathVariable long developerId, @PathVariable long experienceId) {

        developerExperienceService.deleteExperience(experienceId, developerId);
        return "Deleted Experience Successfully...";
    }
}
