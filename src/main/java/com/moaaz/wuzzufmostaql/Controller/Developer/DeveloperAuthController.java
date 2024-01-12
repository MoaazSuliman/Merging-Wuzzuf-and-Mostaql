package com.moaaz.wuzzufmostaql.Controller.Developer;

import com.moaaz.wuzzufmostaql.Dto.Developer.DeveloperRegisterRequest;
import com.moaaz.wuzzufmostaql.Model.Developer.Developer;
import com.moaaz.wuzzufmostaql.Service.Developer.Imp.DeveloperAuthenticationService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/moaaz/wuzzufmostaql/api/developers/auth")
@Slf4j
public class DeveloperAuthController {

    @Autowired
    private DeveloperAuthenticationService developerAuthenticationService;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public String register(@RequestBody @Valid DeveloperRegisterRequest developerRegisterRequest) {
        developerAuthenticationService.register(developerRegisterRequest);
        return "Registered Successfully...:) , Run And Verify Your Email Now Or I'll Kill You..$LOL!$";
    }
    @PostMapping("/login")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Developer login(@RequestParam String email, @RequestParam String password) {
        log.info("Here In Controller Method => Login By Email And Password");
        return developerAuthenticationService.login(email, password);
    }

    @PostMapping("/verifyOtp/{developerId}")
    @ResponseStatus(HttpStatus.OK)
    public boolean verifyOtp(@PathVariable long developerId, @RequestParam String otp) {
        return developerAuthenticationService.verifyOtp(otp, developerId);
    }


    @PostMapping("/forgetPassword")
    public String forgetPassword(@RequestParam String email) {

        developerAuthenticationService.forgetPassword(email);
        return "Your Password Sent Successfully for Your Email, Don't Be Fuel And Forget It Again.. :'(";
    }



}
