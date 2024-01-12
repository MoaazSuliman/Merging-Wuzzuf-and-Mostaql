package com.moaaz.wuzzufmostaql.Controller.Client;

import com.moaaz.wuzzufmostaql.Dto.Client.ClientRegisterRequest;
import com.moaaz.wuzzufmostaql.Model.Client.Client;
import com.moaaz.wuzzufmostaql.Service.Client.ClientAuthenticationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/moaaz/wuzzufmostaql/api/clients/auth")
public class ClientAuthenticationController {

    @Autowired
    private ClientAuthenticationService clientAuthenticationService;

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Client login(@RequestParam String email, @RequestParam String password) {
        return clientAuthenticationService.login(email, password);
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public Client register(@RequestBody @Valid ClientRegisterRequest clientRegisterRequest) {
        return clientAuthenticationService.register(clientRegisterRequest);
    }

    @PostMapping("/verifyOtp/{clientId}")
    @ResponseStatus(HttpStatus.OK)
    public boolean verifyOtp(@PathVariable long clientId, @RequestParam String otp) {
        return clientAuthenticationService.verifyOtp(otp, clientId);
    }


    @PostMapping("/forgetPassword")
    public String forgetPassword(@RequestParam String email) {

        clientAuthenticationService.forgetPassword(email);
        return "Your Password Sent Successfully for Your Email, Don't Be Fuel And Forget It Again.. :'(";
    }

}
