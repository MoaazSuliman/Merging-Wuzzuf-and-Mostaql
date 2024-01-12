package com.moaaz.wuzzufmostaql.Service.Company;

import com.moaaz.wuzzufmostaql.Dto.Company.BenefitDto;
import com.moaaz.wuzzufmostaql.Model.Company.Benefit;
import com.moaaz.wuzzufmostaql.Model.Company.Company;
import com.moaaz.wuzzufmostaql.Repository.Company.CompanyRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    public Company saveCompany(Company company) {
        return companyRepository.save(company);
    }

    public void enableVerify(Company company) {
        company.getAuthentication().setVerify(true);
        companyRepository.save(company);
    }

    public Company updateCompany(Company company) {
        getByIdOrElseThrowException(company.getId());
        return companyRepository.save(company);
    }

    public void deleteCompanyById(long companyId) {
        companyRepository.deleteById(companyId);
    }

    public Company getByIdOrElseThrowException(long companyId) {
        return companyRepository.findById(companyId).orElseThrow(
                () -> new NoSuchElementException("There Are Company With Id = " + companyId));

    }
    public List<Company> getAll(){
        return  companyRepository.findAll();
    }
    @SneakyThrows
    public void checkIfEmailIfExistOrElseThrowException(String email) {
        Company company = companyRepository.findByEmail(email).orElse(null);
        if (company != null)
            throw new Exception("This Email Are Using From Another Company In Our Database So Go To The Hell..");
    }

    public Company getByEmail(String email) {
        return companyRepository.findByEmail(email).orElse(null);
    }

    public Company getByEmailAndPassword(String email, String password) {
        return companyRepository.findByEmailAndPassword(email, password).orElseThrow(() -> new NoSuchElementException("Error In Email Or Password"));
    }


}
