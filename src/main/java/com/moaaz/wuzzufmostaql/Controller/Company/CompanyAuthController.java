package com.moaaz.wuzzufmostaql.Controller.Company;

import com.moaaz.wuzzufmostaql.Dto.Company.CompanyRegisterRequest;
import com.moaaz.wuzzufmostaql.Model.Company.Company;
import com.moaaz.wuzzufmostaql.Service.Company.CompanyAuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/moaaz/wuzzufmostaql/api/companies/auth")
public class CompanyAuthController {

    @Autowired
    private CompanyAuthService companyAuthService;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public Company register(@RequestBody @Valid CompanyRegisterRequest companyRegisterRequest) {
        return companyAuthService.register(companyRegisterRequest);
    }

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Company login(@RequestParam String email, @RequestParam String password) {
        return companyAuthService.login(email, password);
    }

    @PostMapping("/forgetPassword")
    public String forgetPassword(@RequestParam String email) {
        companyAuthService.forgetPassword(email);
        return "Your Password Sent Successfully For Your Email If You Forget It Again " +
                "The Best Place For You Are In The Hell...";
    }

    @PostMapping("/verifyOtp/{companyId}")
    @ResponseStatus(HttpStatus.OK)
    public boolean verifyOtp(@RequestParam String otp, @PathVariable long companyId) {

        return companyAuthService.verifyOtp(otp, companyId);
    }
}
