package com.moaaz.wuzzufmostaql.Repository.Company;

import com.moaaz.wuzzufmostaql.Model.Company.Company;
import com.moaaz.wuzzufmostaql.Model.Developer.CareerInterests;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

    public Optional<Company>findByEmailAndPassword(String email , String password);
    public Optional<Company> findByEmail(String email);
}
