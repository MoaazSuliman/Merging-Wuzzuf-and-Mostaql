package com.moaaz.wuzzufmostaql.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailSenderService {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendPasswordToEmail(String email, String password) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("moaazsuliman1@gmail.com");
            message.setTo(email);
            message.setText("Your Password From Moaaz Web Application System is "
                    + password + " \n I Will Fuck You If You Forget Password Again...");
            message.setSubject("Moaaz Wuzzuf Application");
            javaMailSender.send(message);

        } catch (MailException mailException) {
            throw mailException;
        }

    }

    public void sendOtpMessageToEmail(String otp, String email) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("moaazsuliman1@gmail.com");
            message.setTo(email);
            message.setText("Your Otp From Moaaz Web Application System is "
                    + otp + " \n Now You Should Go To Verify Page Or We Will Kill You...");
            message.setSubject("Moaaz Wuzzuf Application");
            javaMailSender.send(message);
        } catch (MailException mailException) {
            throw mailException;
        }

    }
}
