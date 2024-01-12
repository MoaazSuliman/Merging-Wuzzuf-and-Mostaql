package com.moaaz.wuzzufmostaql.Service.Developer.Imp;

import com.moaaz.wuzzufmostaql.Dto.Developer.SkillRequest;
import com.moaaz.wuzzufmostaql.Model.Developer.Developer;
import com.moaaz.wuzzufmostaql.Model.Developer.Skill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class DeveloperSkillService {

    @Autowired
    private DeveloperService developerService;


    public void addSkill(SkillRequest skillRequest, long developerId) {
        // get developer
        Developer developer = developerService.getByIdOrElseThrowException(developerId);
        // convert dto
        Skill skill = Skill.builder()
                .name(skillRequest.getName())
                .details(skillRequest.getDetails())
                .stars(skillRequest.getStars())
                .build();

        // add skill to developer
        developer.getSkills().add(skill);
        // update developer in the database
        developerService.updateDeveloper(developer);
    }

    public void updateSkill(SkillRequest skillRequest, long skillId, long developerId) {

        Developer developer = developerService.getByIdOrElseThrowException(developerId);

        Skill skill = developer.getSkills().stream().filter(e -> e.getId() == skillId).findFirst()
                .orElseThrow(
                        () -> new NoSuchElementException("There Are No Skill For This Developer With Id = " + skillId)
                );

        skill.setName(skillRequest.getName());
        skill.setDetails(skillRequest.getDetails());
        skill.setStars(skillRequest.getStars());

        // update developer
        developerService.updateDeveloper(developer);


    }

    public void deleteSkill(long skillId, long developerId) {
        Developer developer = developerService.getByIdOrElseThrowException(developerId);

        Skill skill = developer.getSkills().stream().filter(e -> e.getId() == skillId).findFirst()
                .orElseThrow(
                        () -> new NoSuchElementException("There Are No Skill For This Developer With Id = " + skillId)
                );
        developer.getSkills().remove(skill);

        developerService.updateDeveloper(developer);

    }
}
