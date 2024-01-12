package com.moaaz.wuzzufmostaql.Repository.Developer;

import com.moaaz.wuzzufmostaql.Model.Developer.GeneralInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeneralInfoRepository extends JpaRepository<GeneralInfo , Long> {
}
