package com.moaaz.wuzzufmostaql.Service.Client;

import com.moaaz.wuzzufmostaql.Dto.Client.ClientRegisterRequest;
import com.moaaz.wuzzufmostaql.Model.Client.Client;
import com.moaaz.wuzzufmostaql.Service.MailSenderService;
import com.moaaz.wuzzufmostaql.Service.Developer.Imp.OtpService;
import com.moaaz.wuzzufmostaql.Service.EmailChecker;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientAuthenticationService {

    @Autowired
    private MailSenderService mailSenderService;
    @Autowired
    private ClientService clientService;
    @Autowired
    private EmailChecker emailChecker;

    public Client register(ClientRegisterRequest clientRegisterRequest) {
        emailChecker.checkIfEmailIsExistOrNot(clientRegisterRequest.getEmail());
        Client client = Client
                .builder()
                .email(clientRegisterRequest.getEmail())
                .password(clientRegisterRequest.getPassword())
                .name(clientRegisterRequest.getName())
                .phone(clientRegisterRequest.getPhone())
                .build();
        // Add Client Otp TO Client To Verify Email...
        OtpService.setOtpForClient(client);
        // sending an otp to the email.
//        mailSenderService.sendOtpMessageToEmail(client.getAuthentication().getOtp(), client.getEmail());

        return clientService.saveClient(client);

    }

    @SneakyThrows
    public Client login(String email, String password) {
        Client client
            =clientService.getByEmailOrPasswordOrElseThrowException(email, password);
        if(!client.getAuthentication().isVerify())
            throw  new Exception("Go To Fuck Your Self or Verify Your Email and Come Again");
        return client;
    }

    public boolean verifyOtp(String otp, long clientId) {
        Client client
                = clientService.getClientByIdOrElseThrowException(clientId);
        if(client.getAuthentication().getOtp().equals(otp))
        {
            client.getAuthentication().setVerify(true);
            clientService.updateClient(client);
            return true;
        }
        clientService.deleteClientById(clientId);
        return false;
    }

    @SneakyThrows
    public void forgetPassword(String email) {
        Client client
                = clientService.getClientByEmail(email);
        if (client != null)
            mailSenderService.sendPasswordToEmail(email, client.getPassword());
        else
                throw new Exception("This Email Isn't In Our Database Go To The Hell...");
    }
}
