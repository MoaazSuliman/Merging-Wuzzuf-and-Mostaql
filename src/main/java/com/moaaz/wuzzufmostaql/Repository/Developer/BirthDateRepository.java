package com.moaaz.wuzzufmostaql.Repository.Developer;

import com.moaaz.wuzzufmostaql.Model.Developer.BirthDate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BirthDateRepository extends JpaRepository<BirthDate , Long> {
}
