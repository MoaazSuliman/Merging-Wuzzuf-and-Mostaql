package com.moaaz.wuzzufmostaql.Service.Developer.Imp;

import com.moaaz.wuzzufmostaql.Model.Authentication;
import com.moaaz.wuzzufmostaql.Model.Client.Client;
import com.moaaz.wuzzufmostaql.Model.Company.Company;
import com.moaaz.wuzzufmostaql.Model.Developer.Developer;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class OtpService {
    public static void setOtpForDeveloper(Developer developer) {
        Random random = new Random();
        int randomNumber = random.nextInt(900000) + 100000;
        Authentication authentication = Authentication.builder()
                .otp(String.valueOf(randomNumber))
                .isVerify(false)
                .build();
        developer.setAuthentication(authentication);

    }

    public static void setOtpForCompany(Company company) {
        Random random = new Random();
        int randomNumber = random.nextInt(900000) + 100000;
        Authentication authentication = Authentication.builder()
                .otp(String.valueOf(randomNumber))
                .isVerify(false)
                .build();
        company.setAuthentication(authentication);

    }


    public static boolean checkVerify(String otp, Developer developer) {
        return (developer.getAuthentication().getOtp().equals(otp) ? true : false);
    }


    public static void setOtpForClient(Client client) {
        Random random = new Random();
        int randomNumber = random.nextInt(900000) + 100000;
        Authentication authentication = Authentication.builder()
                .otp(String.valueOf(randomNumber))
                .isVerify(false)
                .build();
        client.setAuthentication(authentication);
    }
}
