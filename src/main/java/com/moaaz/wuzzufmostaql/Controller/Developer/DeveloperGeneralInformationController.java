package com.moaaz.wuzzufmostaql.Controller.Developer;

import com.moaaz.wuzzufmostaql.Dto.Developer.GeneralInfoRequest;
import com.moaaz.wuzzufmostaql.Model.Developer.Developer;
import com.moaaz.wuzzufmostaql.Service.Developer.Imp.DeveloperService;
import com.moaaz.wuzzufmostaql.Service.Developer.Imp.DeveloperGeneralInformationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/moaaz/wuzzufmostaql/api/developers/info")
public class DeveloperGeneralInformationController {

    @Autowired
    private DeveloperGeneralInformationService generalInformationService;
    @Autowired
    private DeveloperService developerService;

    // personal information
    @PostMapping("/update/{developerId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Developer updateDeveloperInfo(
            @RequestBody @Valid GeneralInfoRequest generalInfoRequest,
            @PathVariable long developerId) {
        return generalInformationService.updateGeneralInformation(generalInfoRequest, developerId);

    }

    @GetMapping("/getAll")
    @ResponseStatus(HttpStatus.OK)
    public List<Developer>getAll(){
        return  developerService.getAll();
    }


    @PostMapping("/uploadCV/{developerId}")
    public ResponseEntity<?> uploadCv(
            @RequestParam MultipartFile file,
            @PathVariable long developerId) throws IOException {

        try {

            if (!file.isEmpty()) {
              generalInformationService.uploadCV(file, developerId);
            }

            return ResponseEntity.ok("CV uploaded successfully");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload CV");
        }

    }

    @DeleteMapping("/deleteCv/{developerId}")
    public String deleteCv(@PathVariable long developerId){
       return generalInformationService.deleteCv(developerId);
    }
    // Location  ==> set location
}
