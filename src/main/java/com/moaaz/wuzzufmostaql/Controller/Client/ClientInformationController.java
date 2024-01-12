package com.moaaz.wuzzufmostaql.Controller.Client;

import com.moaaz.wuzzufmostaql.Dto.Client.ClientDto;
import com.moaaz.wuzzufmostaql.Model.Client.Client;
import com.moaaz.wuzzufmostaql.Service.Client.ClientInfoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/moaaz/wuzzufmostaql/api/clients/info")
public class ClientInformationController {

    @Autowired
    private ClientInfoService clientInfoService;

    @PostMapping("/update/{clientId}")
    public Client updateClient(@ModelAttribute @Valid ClientDto clientDto, @PathVariable long clientId) {
        System.out.println(clientId + "****************************************************************************");
        return clientInfoService.updateClientWithAllFields(clientDto, clientId);
    }


}
