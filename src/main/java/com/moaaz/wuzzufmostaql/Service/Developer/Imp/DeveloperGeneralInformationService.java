package com.moaaz.wuzzufmostaql.Service.Developer.Imp;

import com.moaaz.wuzzufmostaql.Dto.Developer.GeneralInfoRequest;
import com.moaaz.wuzzufmostaql.Model.Developer.BirthDate;
import com.moaaz.wuzzufmostaql.Model.Developer.Developer;
import com.moaaz.wuzzufmostaql.Model.Developer.GeneralInfo;
import com.moaaz.wuzzufmostaql.Model.Developer.Location;
import com.moaaz.wuzzufmostaql.Repository.Developer.BirthDateRepository;
import com.moaaz.wuzzufmostaql.Repository.Developer.GeneralInfoRepository;
import com.moaaz.wuzzufmostaql.Repository.Developer.LocationRepository;
import jakarta.servlet.ServletContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
@Slf4j
public class DeveloperGeneralInformationService {

    @Autowired
    private DeveloperService developerService;
    @Autowired
    private GeneralInfoRepository generalInfoRepository;
    @Autowired
    private BirthDateRepository birthDateRepository;
    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private ServletContext servletContext;

    public Developer updateGeneralInformation(GeneralInfoRequest generalInfoRequest, long developerId) {
        Developer developer = developerService.getByIdOrElseThrowException(developerId);
        // convert birthdate
        BirthDate birthDate = BirthDate
                .builder()
                .day(generalInfoRequest.getBirthDateRequest().getDay())
                .month(generalInfoRequest.getBirthDateRequest().getMonth())
                .year(generalInfoRequest.getBirthDateRequest().getYear())
                .build();
        // convert location
        Location location = Location
                .builder()
                .country(generalInfoRequest.getLocationRequest().getCountry())
                .city(generalInfoRequest.getLocationRequest().getCity())
                .area(generalInfoRequest.getLocationRequest().getArea())
                .postalCode(generalInfoRequest.getLocationRequest().getPostalCode())
                .build();
        // convert general info
        GeneralInfo generalInfo = GeneralInfo
                .builder()
                .id(developer.getGeneralInfo().getId())
                .firstName(generalInfoRequest.getFirstName())
                .lastName(generalInfoRequest.getLastName())
                .title(generalInfoRequest.getTitle())
                .gender(generalInfoRequest.getGender())
                .birthDate(birthDate)
                .nationality(generalInfoRequest.getNationality())
                .maritalStatus(generalInfoRequest.getMaritalStatus())
                .phoneNumber1(generalInfoRequest.getPhoneNumber1())
                .phoneNumber2(generalInfoRequest.getPhoneNumber2())
                .location(location)
                .build();
        // set email and password with old email and password
        generalInfo.setPassword(developer.getGeneralInfo().getPassword());
        generalInfo.setEmail(developer.getGeneralInfo().getEmail());

        // delete old things
        if (developer.getGeneralInfo().getBirthDate() != null) {
            log.info("Deleting BirthDate");
            deleteBirthDate(developer.getGeneralInfo().getBirthDate());
        }
        if (developer.getGeneralInfo().getLocation() != null) {
            log.info("Deleting Location");
            deleteLocation(location);
        }

        // set new general info for developer
        developer.setGeneralInfo(generalInfo);

        log.info("Before Saving Developer In Database");
        //update developer in database.
        return developerService.updateDeveloper(developer);
    }

    public void uploadCV(MultipartFile file, long developerId) throws IOException {
        Developer developer = developerService.getByIdOrElseThrowException(developerId);
        try {


            // Create the file path
            String projectPath = "E:\\Spring Projects\\wuzzuf-mostaql\\src\\main\\java\\com\\moaaz\\wuzzufmostaql\\pdfs\\";
            String filePath = projectPath + developer.getGeneralInfo().getEmail() + ".pdf";

            // Save the file
            File dest = new File(filePath);
            file.transferTo(dest);

            // update developer information
            developer.getGeneralInfo().setCvPath(filePath);
            developerService.updateDeveloper(developer);

        } catch (IOException e) {
            log.info("Exception {}", e.getMessage());

        }

    }

    public String deleteCv(long developerId) {
        Developer developer = developerService.getByIdOrElseThrowException(developerId);
        if (developer.getGeneralInfo().getCvPath() != null) {
            // delete Cv
            Path path = Path.of(developer.getGeneralInfo().getCvPath());
            try {
                Files.delete(path);
            } catch (IOException exception) {
                throw new RuntimeException(exception.getMessage());
            }
            // update developer
            developer.getGeneralInfo().setCvPath(null);
            developerService.updateDeveloper(developer);
            return "Deleted Successfully...";
        }
        return "There Are No Cv For This Developer Until Now ==> LoL There Are Developer Without CV :(";
    }

    public void deleteBirthDate(BirthDate birthDate) {
        birthDateRepository.delete(birthDate);
    }

    public void deleteGeneralInfo(GeneralInfo generalInfo) {
        generalInfoRepository.delete(generalInfo);
    }

    public void deleteLocation(Location location) {
        locationRepository.delete(location);
    }


}
