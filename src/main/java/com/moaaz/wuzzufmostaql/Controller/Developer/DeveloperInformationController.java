package com.moaaz.wuzzufmostaql.Controller.Developer;

import com.moaaz.wuzzufmostaql.Service.Developer.Imp.DeveloperSkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/moaaz/wuzzufmostaql/api/developers/informations")
public class DeveloperInformationController {


    @Autowired
    private DeveloperSkillService sKillServiceDeveloper;



//    @PostMapping("/addSkill/{developerId}")
//    @ResponseStatus(HttpStatus.CREATED)
//    public String addSkill(@RequestBody SkillRequest skillRequest, @PathVariable long developerId) {
//        sKillService.addSkill(skillRequest, developerId);
//        return "Skill Added To Developer Successfully.";
//    }



}
