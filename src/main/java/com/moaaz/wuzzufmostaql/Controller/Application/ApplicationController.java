package com.moaaz.wuzzufmostaql.Controller.Application;


import com.moaaz.wuzzufmostaql.Dto.ApplicationDto;
import com.moaaz.wuzzufmostaql.Dto.DeveloperApplicationResponse;
import com.moaaz.wuzzufmostaql.Model.Developer.Developer;
import com.moaaz.wuzzufmostaql.Service.DeveloperApplicationService;
import jakarta.validation.Valid;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/moaaz/wuzzufmostaql/api/applications")
@RestController
public class ApplicationController {

    @Autowired
    private DeveloperApplicationService developerApplicationService;

    @PostMapping("/submit")
    @ResponseStatus(HttpStatus.CREATED)
    public Developer submitApplication(@RequestBody @Valid ApplicationDto applicationDto) {
        return developerApplicationService.registerApplication(applicationDto);
    }

    @GetMapping("/getAllForDeveloper/{developerId}")
    @ResponseStatus(HttpStatus.OK)
    public List<DeveloperApplicationResponse> getAllDeveloperApplications(@PathVariable long developerId) {
        return developerApplicationService.getAllDeveloperApplications(developerId);
    }
}
