package com.moaaz.wuzzufmostaql.Controller.Developer;

import com.moaaz.wuzzufmostaql.Model.Developer.Developer;
import com.moaaz.wuzzufmostaql.Service.Developer.Imp.DeveloperSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/moaaz/wuzzufmostaql/api/developers")
public class DeveloperSearchController {


    @Autowired
    private DeveloperSearchService developerSearchService;


    @GetMapping("/searchByTitle")
    @ResponseStatus(HttpStatus.OK)
    public List<Developer> searchForDeveloperByTitle(@RequestParam String title) {
        return developerSearchService.getAllDevelopersByTitle(title);
    }

    @GetMapping("/searchBySkills")
    @ResponseStatus(HttpStatus.OK)
    public List<Developer> searchForDeveloperBySkills(@RequestParam List<String> skills) {
        return  developerSearchService.getAllDevelopersByMatchingSkills(skills);
    }
}
