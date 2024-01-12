package com.moaaz.wuzzufmostaql.Repository.Developer;

import com.moaaz.wuzzufmostaql.Model.Developer.Developer;
import com.moaaz.wuzzufmostaql.Model.DeveloperOffer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeveloperOfferRepository extends JpaRepository<DeveloperOffer , Long> {

    public List<DeveloperOffer>findAllByDeveloper(Developer developer);
}
