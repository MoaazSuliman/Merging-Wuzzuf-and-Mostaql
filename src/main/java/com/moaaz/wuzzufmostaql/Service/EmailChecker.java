package com.moaaz.wuzzufmostaql.Service;

import com.moaaz.wuzzufmostaql.Model.Client.Client;
import com.moaaz.wuzzufmostaql.Model.Company.Company;
import com.moaaz.wuzzufmostaql.Model.Developer.Developer;
import com.moaaz.wuzzufmostaql.Service.Client.ClientService;
import com.moaaz.wuzzufmostaql.Service.Company.CompanyService;
import com.moaaz.wuzzufmostaql.Service.Developer.Imp.DeveloperService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmailChecker {

    private final DeveloperService developerService;


    private final ClientService clientService;


    private final CompanyService companyService;

    @SneakyThrows
    public  void checkIfEmailIsExistOrNot(String email) {
        log.info("Here In Checker Method");
        Developer developer = developerService.getDeveloperByEmail(email);
        if (developer != null)
            throw new Exception("This Email Already In Our Database , Choose Another One Or Go To The Hell...");
        Client client = clientService.getClientByEmail(email);
        if (client != null)
            throw new Exception("This Email Already In Our Database , Choose Another One Or Go To The Hell...");
        Company company = companyService.getByEmail(email);
        if (company != null)
            throw new Exception("This Email Already In Our Database , Choose Another One Or Go To The Hell...");

    }
}
