package com.moaaz.wuzzufmostaql.Service.Developer.Imp;

import com.moaaz.wuzzufmostaql.Model.Developer.Developer;
import com.moaaz.wuzzufmostaql.Model.Developer.Skill;
import com.moaaz.wuzzufmostaql.Repository.Developer.DeveloperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DeveloperSearchService {


    @Autowired
    private DeveloperRepository developerRepository;


    public List<Developer> getAllDevelopersByTitle(String title) {
        return developerRepository.findAllByGeneralInfoTitleContaining(title);
    }

    public List<Developer> getAllDevelopersByMatchingSkills(List<String> targetSkillNames) {
        List<Developer> developers = developerRepository.findAll();
        return developers.stream()
                .filter(developer ->
                        developer.getSkills().stream()
                                .map(Skill::getName)
                                .anyMatch(targetSkillNames::contains)
                )
                .collect(Collectors.toList());


    }
}
