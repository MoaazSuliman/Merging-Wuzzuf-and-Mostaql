package com.moaaz.wuzzufmostaql.Service;

import com.moaaz.wuzzufmostaql.Dto.DeveloperOfferDto;
import com.moaaz.wuzzufmostaql.Model.Client.ClientProject;
import com.moaaz.wuzzufmostaql.Model.Developer.Developer;
import com.moaaz.wuzzufmostaql.Model.DeveloperOffer;
import com.moaaz.wuzzufmostaql.Repository.Developer.DeveloperOfferRepository;
import com.moaaz.wuzzufmostaql.Service.Client.ClientProjectService;
import com.moaaz.wuzzufmostaql.Service.Developer.Imp.DeveloperService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class DeveloperOfferService {

    @Autowired
    private DeveloperOfferRepository developerOfferRepository;

    @Autowired
    private ClientProjectService clientProjectService;

    @Autowired
    private DeveloperService developerService;

    @SneakyThrows
    public DeveloperOffer addDeveloperOffer(DeveloperOfferDto developerOfferDto, long developerId, long clientProjectId) {
        Developer developer = developerService.getByIdOrElseThrowException(developerId);
        ClientProject clientProject = clientProjectService.getByIdOrElseThrowException(clientProjectId);
        if (!clientProject.isAccepted())
            throw new Exception("This Client Project Are Not Accepted Until Now So Go To The Hell...");
        return developerOfferRepository.save(DeveloperOffer
                .builder()
                .price(developerOfferDto.getPrice())
                .description(developerOfferDto.getDescription())
                .numberOfDays(developerOfferDto.getNumberOfDays())
                .clientProject(clientProject)
                .developer(developer)
                .creationTime(LocalDateTime.now())
                .build());

    }

    public List<DeveloperOffer> getAllDeveloperOffers(long developerId) {
        Developer developer = developerService.getByIdOrElseThrowException(developerId);
        return developerOfferRepository.findAllByDeveloper(developer);
    }

    public DeveloperOffer getDeveloperOfferById(long developerOfferId) {
        return developerOfferRepository.findById(developerOfferId).orElseThrow(
                () -> new NoSuchElementException("There Are No Developer Offer With Id = " + developerOfferId)
        );
    }

    public void updateDeveloperOffer(DeveloperOffer developerOffer) {

        developerOfferRepository.save(developerOffer);
    }


    public ClientProject acceptDeveloperOffer(long developerOfferId, long clientProjectId) {
        DeveloperOffer developerOffer = getDeveloperOfferById(developerOfferId);
        ClientProject clientProject = clientProjectService.getByIdOrElseThrowException(clientProjectId);
        developerOffer.setAccepted(true);
        updateDeveloperOffer(developerOffer);
        return clientProject;

    }
}
