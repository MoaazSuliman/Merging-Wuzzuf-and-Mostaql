package com.moaaz.wuzzufmostaql.Controller.Developer;

import com.moaaz.wuzzufmostaql.Dto.Developer.ProjectRequest;
import com.moaaz.wuzzufmostaql.Model.Developer.Project;
import com.moaaz.wuzzufmostaql.Service.Developer.Imp.DeveloperProjectService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/moaaz/wuzzufmostaql/api/developers/projects")
@Slf4j
public class DeveloperProjectController {

    @Autowired
    private DeveloperProjectService developerProjectService;

    @PostMapping("/add/{developerId}")
    @ResponseStatus(HttpStatus.CREATED)
    public Project addProject(@RequestBody @Valid ProjectRequest projectRequest, @PathVariable long developerId) {

        return developerProjectService.addProject(projectRequest, developerId);
    }

    @PostMapping("/uploadPicture/{projectId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Project uploadPicture(@RequestParam MultipartFile picture  , @PathVariable long projectId){
      return   developerProjectService.uploadPicture(picture , projectId);

    }

    @PostMapping("/uploadVideo/{projectId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Project uploadVideo(@RequestParam MultipartFile video  , @PathVariable long projectId){

        return  developerProjectService.uploadVideo(video , projectId);
    }

}
