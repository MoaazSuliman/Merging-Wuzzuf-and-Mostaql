package com.moaaz.wuzzufmostaql.Service.Client;

import com.moaaz.wuzzufmostaql.Dto.Client.ClientDto;
import com.moaaz.wuzzufmostaql.Model.Client.Client;
import com.moaaz.wuzzufmostaql.Service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ClientInfoService {

    @Autowired
    private ClientService clientService;

    public Client updateClientWithAllFields(ClientDto clientDto, long clientId) {
        Client client = clientService.getClientByIdOrElseThrowException(clientId);

        return clientService.updateClient(Client
                .builder()
                .id(clientId)
                .email(client.getEmail())
                .password(client.getPassword())
                .name(clientDto.getName())
                .phone(clientDto.getPhone())
                .picturePath(uploadImageIfExist( client, clientDto.getPicture()))
                .build());


    }

    private String uploadImageIfExist(Client client, MultipartFile picture) {

        if (picture != null)
            return FileService.saveImage(picture);
        else if (client.getPicturePath() == null)
            return "";
        return client.getPicturePath();
    }
}
