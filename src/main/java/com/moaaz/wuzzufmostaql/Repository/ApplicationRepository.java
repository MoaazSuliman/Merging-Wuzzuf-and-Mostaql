package com.moaaz.wuzzufmostaql.Repository;

import com.moaaz.wuzzufmostaql.Model.Application.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationRepository extends JpaRepository<Application , Long> {

}
