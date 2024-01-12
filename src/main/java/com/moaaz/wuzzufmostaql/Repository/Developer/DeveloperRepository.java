package com.moaaz.wuzzufmostaql.Repository.Developer;

import com.moaaz.wuzzufmostaql.Model.Developer.Developer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;
import java.util.Optional;

@Repository
public interface DeveloperRepository extends JpaRepository<Developer, Long> {

    public Optional<Developer>findByGeneralInfoEmail(String email);

//    @Query("SELECT d FROM Developer d WHERE d.generaInfo.email = :email AND d.generaInfo.password = :password")
    public Optional<Developer> findByGeneralInfoEmailAndGeneralInfoPassword(@RequestParam("email") String email,@RequestParam("password") String password);

    public List<Developer> findAllByGeneralInfoTitleContaining(String title);

//    public List<Developer> findAllBySkill_Name(List<String> skills);
//    @Query("SELECT d FROM Developer d JOIN d.skills s WHERE s.name = :skillName")
//    List<Developer> findBySkillName(@Param("skillName") String skillName);
}
