package com.moaaz.wuzzufmostaql.Service.Client;

import com.moaaz.wuzzufmostaql.Dto.Client.ClientProjectDto;
import com.moaaz.wuzzufmostaql.Model.Client.Client;
import com.moaaz.wuzzufmostaql.Model.Client.ClientProject;
import com.moaaz.wuzzufmostaql.Model.DeveloperOffer;
import com.moaaz.wuzzufmostaql.Repository.Client.ClientProjectRepository;
import com.moaaz.wuzzufmostaql.Service.DeveloperOfferService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ClientProjectService {

    @Autowired
    private ClientService clientService;


    @Autowired
    private ClientProjectRepository clientProjectRepository;

    // add
    public ClientProject addClientProject(ClientProjectDto clientProjectDto, long clientId) {
        // get client by id or throw exception
        Client client = clientService.getClientByIdOrElseThrowException(clientId);
        // save client project in our database and return it.
        return clientProjectRepository.save(ClientProject
                .builder()
                .title(clientProjectDto.getTitle())
                .description(clientProjectDto.getDescription())
                .minMoney(clientProjectDto.getMinMoney())
                .maxMoney(clientProjectDto.getMaxMoney())
                .minNumberOfDays(clientProjectDto.getMinNumberOfDays())
                .maxNumberOfDays(clientProjectDto.getMaxNumberOfDays())
                .linkForAnotherDescription(clientProjectDto.getLinkForAnotherDescription())
                .localDateTime(LocalDateTime.now())
                .client(client)
                .build());
        // send mail to client.
//        clientMailSender.sendMessage("Your Project Will Be Reviewed in 3 Hours");

    }

    // update
    public ClientProject updateClientProject(ClientProjectDto clientProjectDto, long clientProjectId) {
        ClientProject existingClientProject = getByIdOrElseThrowException(clientProjectId);
        existingClientProject = ClientProject
                .builder()
                .client(existingClientProject.getClient())
                .title(clientProjectDto.getTitle())
                .description(clientProjectDto.getDescription())
                .minMoney(clientProjectDto.getMinMoney())
                .maxMoney(clientProjectDto.getMaxMoney())
                .minNumberOfDays(clientProjectDto.getMinNumberOfDays())
                .maxNumberOfDays(clientProjectDto.getMaxNumberOfDays())
                .linkForAnotherDescription(clientProjectDto.getLinkForAnotherDescription())
//                .developerOffers(existingClientProject.getDeveloperOffers())
                .build();

        // update it in our database.
        return clientProjectRepository.save(existingClientProject);

    }


    // delete
    // we will not delete it if associated for any developer..
    @SneakyThrows
    public void deleteClientProject(long clientProjectId) {
        ClientProject clientProject = getByIdOrElseThrowException(clientProjectId);
        if (clientProject.isAssociated())
            throw new Exception("This Project Can't Be Deleted Because It's Associated For A Developer");

        clientProjectRepository.deleteById(clientProjectId);
    }

    // open project
    public void openClientProject(long clientProjectId) {
        ClientProject clientProject = getByIdOrElseThrowException(clientProjectId);
        clientProject.setAccepted(true);
        clientProjectRepository.save(clientProject);
    }


    // close client project


    // associate client project to developer


    // get client project by id
    public ClientProject getByIdOrElseThrowException(long clientProjectId) {
        return clientProjectRepository.findById(clientProjectId).orElseThrow(
                () -> new NoSuchElementException("There Are No Client Project With Id = " + clientProjectId)
        );
    }

    public List<ClientProject> getAllForClient(long clientId) {
        Client client
                = clientService.getClientByIdOrElseThrowException(clientId);
        return clientProjectRepository.findAllByClient(client);

    }

    public List<DeveloperOffer> getClientProjectOffers(long clientProjectId) {
        return getByIdOrElseThrowException(clientProjectId).getDeveloperOffers();
    }
}
