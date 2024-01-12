package com.moaaz.wuzzufmostaql.Controller.Client;

import com.moaaz.wuzzufmostaql.Dto.Client.ClientProjectDto;
import com.moaaz.wuzzufmostaql.Model.Client.ClientProject;
import com.moaaz.wuzzufmostaql.Model.DeveloperOffer;
import com.moaaz.wuzzufmostaql.Repository.Client.ClientProjectRepository;
import com.moaaz.wuzzufmostaql.Service.Client.ClientProjectService;
import com.moaaz.wuzzufmostaql.Service.DeveloperOfferService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/moaaz/wuzzufmostaql/api/clients/projects/")
public class ClientProjectController {

    @Autowired
    private ClientProjectService clientProjectService;
    @Autowired
    private DeveloperOfferService developerOfferService;

    @PostMapping("/add/{clientId}")
    @ResponseStatus(HttpStatus.CREATED)
    public ClientProject addClientProject(@RequestBody @Valid ClientProjectDto clientProjectDto, @PathVariable long clientId) {
        return clientProjectService.addClientProject(clientProjectDto, clientId);
    }

    @PostMapping("/update/{clientProjectId}")
    @ResponseStatus(HttpStatus.CREATED)
    public ClientProject updateClientProject(@RequestBody @Valid ClientProjectDto clientProjectDto, @PathVariable long clientProjectId) {
        return clientProjectService.updateClientProject(clientProjectDto, clientProjectId);
    }

    @PostMapping("/getAllOffers/{clientProjectId}")
    @ResponseStatus(HttpStatus.OK)
    public List<DeveloperOffer> getAllProjectClientOffers(@PathVariable long clientProjectId) {
        return clientProjectService.getClientProjectOffers(clientProjectId);
    }

    @GetMapping("/getAll/{clientId}")
    @ResponseStatus(HttpStatus.OK)
    public List<ClientProject> getAllProjectsForClient(@PathVariable long clientId) {
        return clientProjectService.getAllForClient(clientId);
    }

    @PostMapping("/acceptDeveloperOffer/{developerOfferId}/clientProject/{clientProjectId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ClientProject acceptDeveloperOffer(@PathVariable long developerOfferId ,@PathVariable long clientProjectId){
        return developerOfferService.acceptDeveloperOffer(developerOfferId , clientProjectId);
    }


}
