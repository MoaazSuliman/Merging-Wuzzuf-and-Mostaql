package com.moaaz.wuzzufmostaql.Controller.Developer;

import com.moaaz.wuzzufmostaql.Model.Developer.Developer;
import com.moaaz.wuzzufmostaql.Service.Developer.Imp.DeveloperService;
import jakarta.validation.constraints.Size;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/moaaz/wuzzufmostaql/api/achievement")
public class DeveloperAchievementController {

    @Autowired
    private DeveloperService developerService;

    @PostMapping("/put/{developerId}")
    public String putAchievement(@RequestParam
                                 @Size(max = 1000,
                                         message = "Your Achievement  Must Not Be Greater Than 1000")
                                 String achievement,
                                 @PathVariable long developerId) {
        Developer developer = developerService.getByIdOrElseThrowException(developerId);
        developer.setAchievement(achievement);
        developerService.updateDeveloper(developer);

        return "Developer Achievement Putted Successfully...";
    }
}
