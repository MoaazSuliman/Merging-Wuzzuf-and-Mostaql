package com.moaaz.wuzzufmostaql.Service.Developer.Imp;

import com.moaaz.wuzzufmostaql.Dto.Developer.DeveloperRegisterRequest;
import com.moaaz.wuzzufmostaql.Model.Developer.Developer;

import com.moaaz.wuzzufmostaql.Service.EmailChecker;
import com.moaaz.wuzzufmostaql.Service.MailSenderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;


@Service
@Slf4j
public class DeveloperAuthenticationService {


    @Autowired
    private MailSenderService mailSenderService;


    @Autowired
    private DeveloperService developerService;
    @Autowired
    private EmailChecker emailChecker;
    public void register(DeveloperRegisterRequest developerRegisterRequest) {


//        checkIfEmailIsExistingOrThrowException(developerRegisterRequest.getEmail());
        emailChecker.checkIfEmailIsExistOrNot(developerRegisterRequest.getEmail());
        // Convert Developer Request To Developer Before Saving him In The Database..
        Developer developer = new Developer();
        developer.Builder(developerRegisterRequest);


        // Add Developer Otp TO Developer To Verify Email...
        OtpService.setOtpForDeveloper(developer);
        // SAVE DEVELOPER TO OUR DATABASE.
        Developer savedDeveloper = developerService.saveDeveloper(developer);
        log.info("Returned Developer From Our Database==> {}", savedDeveloper.toString());

        // Send Otp To Developer Email.
//        mailSenderService.sendOtpMessageToEmail(developer.getAuthentication().getOtp(), developer.getGeneralInfo().getEmail());
    }

    public boolean verifyOtp(String otp, long developerId) {
        Developer developer = developerService.getByIdOrElseThrowException(developerId);
        if (developer.getAuthentication().getOtp().equals(otp)) {
            developer.getAuthentication().setVerify(true);
            developerService.saveDeveloper(developer);
            return true;
        }
        developerService.deleteDeveloperById(developer.getId());
        return false;
    }


    public void forgetPassword(String email) {
        Developer developer = developerService.getByEmailOrElseThrowException(email);

        mailSenderService.sendPasswordToEmail(email, developer.getGeneralInfo().getPassword());
    }

    public Developer login(String email, String password) {

        log.info("Here In Login Method In the Service Layer.");

        Developer developer
                = developerService.getByEmailAndPasswordOrElseThrowException(email, password);

        log.info("Developer From Our Database {}", developer.toString());
        if (!developer.getAuthentication().isVerify()) {
            developerService.deleteDeveloperById(developer.getId());
            log.info("Developer Not Verify his Email");
            throw new NoSuchElementException("Fuck You, I Said Go To Verify Your Email And You Doesn't Accept My Advice. So You Are Out Of My Web Application....Lol!");
        }
        log.info("Developer IS Exist And Email Or Password Are Matched..");
        return developer;
    }


    private void checkIfEmailIsExistingOrThrowException(String email) {
        Developer developer = developerService.getDeveloperByEmail(email);
        if (developer != null)
            throw new IllegalArgumentException("This Email Already In Our Database");
    }


}
