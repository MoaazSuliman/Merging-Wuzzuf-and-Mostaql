package com.moaaz.wuzzufmostaql.Service.Company;

import com.moaaz.wuzzufmostaql.Dto.Company.CompanyRegisterRequest;
import com.moaaz.wuzzufmostaql.Model.Company.Company;
import com.moaaz.wuzzufmostaql.Service.MailSenderService;
import com.moaaz.wuzzufmostaql.Service.Developer.Imp.OtpService;
import com.moaaz.wuzzufmostaql.Service.EmailChecker;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyAuthService {

    @Autowired
    private CompanyService companyService;

    @Autowired
    private MailSenderService mailSenderService;

    @Autowired
    private EmailChecker emailChecker;
    public Company register(CompanyRegisterRequest companyRegisterRequest) {

//        companyService.checkIfEmailIfExistOrElseThrowException(companyRegisterRequest.getEmail());
        emailChecker.checkIfEmailIsExistOrNot(companyRegisterRequest.getEmail());
        Company company = Company.builder()
                .email(companyRegisterRequest.getEmail())
                .password(companyRegisterRequest.getPassword())
                .name(companyRegisterRequest.getName())
                .details(companyRegisterRequest.getDetails())
                .build();

        // Add  Otp TO Company To Verify Email...
        OtpService.setOtpForCompany(company);
//        mailSenderService.sendOtpMessageToEmail(company.getAuthentication().getOtp(), company.getEmail());
        return companyService.saveCompany(company);

    }

    @SneakyThrows
    public Company login(String email, String password) {
        Company company = companyService.getByEmailAndPassword(email, password);
        if (company.getAuthentication().isVerify()) return company;
        throw new Exception("This Company Doesn't Verify His Email");
    }

    public void forgetPassword(String email) {
        Company company = companyService.getByEmail(email);
        mailSenderService.sendPasswordToEmail(email, company.getPassword());

    }

    public boolean verifyOtp(String otp, long companyId) {
        Company company = companyService.getByIdOrElseThrowException(companyId);
        if (company.getAuthentication().getOtp().equals(otp)) {
            companyService.enableVerify(company);
            return  true;
        }
        companyService.deleteCompanyById(companyId);
        return  false;
    }


}
