package com.moaaz.wuzzufmostaql.Controller.Developer;

import com.moaaz.wuzzufmostaql.Dto.Developer.SkillRequest;
import com.moaaz.wuzzufmostaql.Service.Developer.Imp.DeveloperSkillService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/moaaz/wuzzufmostaql/api/developers/skills")
public class DeveloperSkillsController {

    @Autowired
    private DeveloperSkillService developerSkillService;

    @PostMapping("/add/{developerId}")
    @ResponseStatus(HttpStatus.CREATED)
    public String addSkill(@RequestBody @Valid SkillRequest skillRequest, @PathVariable long developerId) {
        developerSkillService.addSkill(skillRequest, developerId);
        return "Skill Added Successfully...";
    }


    @PutMapping("/update/{skillId}/developer/{developerId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String updateSkill(@RequestBody @Valid SkillRequest skillRequest,
                              @PathVariable long developerId,
                              @PathVariable long skillId) {
        developerSkillService.updateSkill(skillRequest, skillId, developerId);
        return "Skill Updated Successfully...";
    }


    @DeleteMapping("/delete/{skillId}/developer/{developerId}")
    public String deleteSkill(@PathVariable long developerId, @PathVariable long skillId) {
        developerSkillService.deleteSkill(skillId, developerId);
        return "Skill Deleted Successfully...";
    }
}
