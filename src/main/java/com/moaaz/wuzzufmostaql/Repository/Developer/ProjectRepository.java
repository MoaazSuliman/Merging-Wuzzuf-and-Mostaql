package com.moaaz.wuzzufmostaql.Repository.Developer;

import com.moaaz.wuzzufmostaql.Model.Developer.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
}
