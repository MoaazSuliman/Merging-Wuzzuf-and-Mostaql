package com.moaaz.wuzzufmostaql.Controller.Company;

import com.moaaz.wuzzufmostaql.Dto.Company.BenefitDto;
import com.moaaz.wuzzufmostaql.Dto.Company.CompanyUpdateRequest;
import com.moaaz.wuzzufmostaql.Model.Company.Company;
import com.moaaz.wuzzufmostaql.Service.Company.CompanyInfoService;
import com.moaaz.wuzzufmostaql.Service.Company.CompanyService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/moaaz/wuzzufmostql/api/companies/info")
public class CompanyInfoController {

    @Autowired
    private CompanyInfoService companyInfoService;
    @Autowired
    private CompanyService companyService;

    @PostMapping("/addBenefits/{companyId}")
    @ResponseStatus(HttpStatus.CREATED)
    public Company addBenefitsToCompany2(@ModelAttribute @Valid BenefitDto benefitDto, @PathVariable long companyId) {

        return companyInfoService.addBenefit(benefitDto, companyId);
    }

    @PostMapping("/update/{companyId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Company updateCompany(@ModelAttribute @Valid CompanyUpdateRequest companyUpdateRequest, @PathVariable long companyId) {
        return companyInfoService.updateCompany(companyUpdateRequest, companyId);
    }

    @PostMapping("/addPicture/{companyId}")
    @ResponseStatus(HttpStatus.CREATED)
    public Company addPicture(@RequestParam MultipartFile picture, @PathVariable long companyId) {
        return companyInfoService.addPicture(picture , companyId );

    }

    @GetMapping("/getAll")
    @ResponseStatus(HttpStatus.OK)
    public List<Company> getAll() {
        return companyService.getAll();
    }
}
