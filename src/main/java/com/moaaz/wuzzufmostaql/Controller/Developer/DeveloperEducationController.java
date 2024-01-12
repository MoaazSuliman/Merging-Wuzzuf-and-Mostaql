package com.moaaz.wuzzufmostaql.Controller.Developer;

import com.moaaz.wuzzufmostaql.Dto.Developer.EducationRequest;
import com.moaaz.wuzzufmostaql.Service.Developer.Imp.DeveloperEducationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/moaaz/wuzzufmostaql/api/developers/education")
public class DeveloperEducationController {

    @Autowired
    private DeveloperEducationService developerEducationService;

    @PostMapping("/putEducation/{developerId}")
    public String putEducation(@RequestBody @Valid EducationRequest educationRequest, @PathVariable long developerId) {
        developerEducationService.putEducation(educationRequest, developerId);
        return "Education Putted For Developer Successfully...";
    }

    @DeleteMapping("/delete/{developerId}")
    public String deleteEducation(@PathVariable long developerId) {
        developerEducationService.deleteEducation(developerId);
        return "Education Deleted Successfully...";
    }

}
