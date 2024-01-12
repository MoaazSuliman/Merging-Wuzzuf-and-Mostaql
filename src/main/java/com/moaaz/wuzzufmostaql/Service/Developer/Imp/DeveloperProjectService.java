package com.moaaz.wuzzufmostaql.Service.Developer.Imp;

import com.moaaz.wuzzufmostaql.Dto.Developer.ProjectRequest;
import com.moaaz.wuzzufmostaql.Model.Developer.Developer;
import com.moaaz.wuzzufmostaql.Model.Developer.Project;
import com.moaaz.wuzzufmostaql.Repository.Developer.ProjectRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.NoSuchElementException;

@Service
@Slf4j
public class DeveloperProjectService {

    @Autowired
    private DeveloperService developerService;
    @Autowired
    private ProjectRepository projectRepository;

    public Project addProject(ProjectRequest projectRequest, long developerId) {
        Developer developer = developerService.getByIdOrElseThrowException(developerId);
        Project project = Project
                .builder()
                .address(projectRequest.getAddress())
                .details(projectRequest.getDetails())
                .link(projectRequest.getLink())
                .date(projectRequest.getDate())
                .skills(projectRequest.getSkills())
                .build();

        log.info("update Project In TheDatabase...");
        project.setDeveloper(developer);
        Project savedProject = projectRepository.save(project);


        return savedProject;


    }

    public void updateProject() {

    }

    public void deleteProject() {

    }

    public Project uploadPicture(MultipartFile picture, long projectId) {
        Project project = projectRepository.findById(projectId).orElseThrow(
                () -> new NoSuchElementException("There Are No Project With Id = " + projectId)
        );
        project.setImagePath(convertImageToPath(picture));

        return projectRepository.save(project);
    }

    public Project uploadVideo(MultipartFile video, long projectId) {
        Project project = projectRepository.findById(projectId).orElseThrow(
                () -> new NoSuchElementException("There Are No Project With Id = " + projectId)
        );
        project.setVideoPath(convertVideoToPath(video));

        return projectRepository.save(project);
    }

    public String convertImageToPath(MultipartFile image) {
        String fileName = image.getOriginalFilename();
        String projectPath = "E:\\Spring Projects\\wuzzuf-mostaql\\src\\main\\java\\com\\moaaz\\wuzzufmostaql\\images\\";
        String filePath = projectPath + fileName;
        try {
            File dest = new File(filePath);
            image.transferTo(dest);
            log.info("Original File Name " + filePath);
            return filePath;
        } catch (Exception exception) {
            throw new RuntimeException(exception.getMessage());
        }
    }

    public String convertVideoToPath(MultipartFile image) {
        String fileName = image.getOriginalFilename();
        String projectPath = "E:\\Spring Projects\\wuzzuf-mostaql\\src\\main\\java\\com\\moaaz\\wuzzufmostaql\\videos\\";
        String filePath = projectPath + fileName;
        try {
            File dest = new File(filePath);
            image.transferTo(dest);
            log.info("Original File Name " + filePath);
            return filePath;
        } catch (Exception exception) {
            throw new RuntimeException(exception.getMessage());
        }
    }

}
