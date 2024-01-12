package com.moaaz.wuzzufmostaql.Service.Company;

import com.moaaz.wuzzufmostaql.Dto.Company.BenefitDto;
import com.moaaz.wuzzufmostaql.Dto.Company.CompanyUpdateRequest;
import com.moaaz.wuzzufmostaql.Model.Company.Benefit;
import com.moaaz.wuzzufmostaql.Model.Company.Company;
import com.moaaz.wuzzufmostaql.Service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class CompanyInfoService {

    @Autowired
    private CompanyService companyService;


    public Company addBenefit(BenefitDto benefitDto, long companyId) {
        Company company
                = companyService.getByIdOrElseThrowException(companyId);
        Benefit benefit
                = Benefit.builder()
                .logo(FileService.saveLogo(benefitDto.getLogo()))
                .details(benefitDto.getDetails())
                .build();

        company.getBenefits().add(benefit);

        companyService.updateCompany(company);

        return company;
    }

    public Company updateCompany(CompanyUpdateRequest companyUpdateRequest, long companyId) {
        Company oldCompany = companyService.getByIdOrElseThrowException(companyId);
        Company company = Company
                .builder()
                .id(companyId)
                .name(companyUpdateRequest.getName())
                .email(companyUpdateRequest.getEmail())
                .details(companyUpdateRequest.getDetails())
                .basePicture(FileService.saveImage(companyUpdateRequest.getBasePicture()))
                .logo(FileService.saveLogo(companyUpdateRequest.getLogo()))
                .facebook(companyUpdateRequest.getFacebook())
                .instagram(companyUpdateRequest.getInstagram())
                .linkedin(companyUpdateRequest.getLinkedin())
                .build();
        // set old data
        company.setPassword(oldCompany.getPassword());
        company.setAuthentication(oldCompany.getAuthentication());
        company.setPictures(oldCompany.getPictures());
        company.setBenefits(oldCompany.getBenefits());

        return companyService.updateCompany(company);
    }

    public Company addPicture(MultipartFile picture, long companyId) {
        Company company
                = companyService.getByIdOrElseThrowException(companyId);
        String imageUrl=FileService.saveImage(picture);
        company.getPictures().add(imageUrl);

        return companyService.updateCompany(company);

    }
}
