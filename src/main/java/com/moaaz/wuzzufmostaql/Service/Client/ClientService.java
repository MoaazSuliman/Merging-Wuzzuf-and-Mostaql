package com.moaaz.wuzzufmostaql.Service.Client;

import com.moaaz.wuzzufmostaql.Model.Client.Client;
import com.moaaz.wuzzufmostaql.Repository.Client.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;


    public Client saveClient(Client client) {
        return clientRepository.save(client);
    }

    public Client updateClient(Client client) {
        getClientByIdOrElseThrowException(client.getId());
        return clientRepository.save(client);
    }

    public Client getClientByIdOrElseThrowException(long clientId) {
        System.out.println("From The Service This Is The Id==================> " + clientId);
        return clientRepository.findById(clientId).orElseThrow(
                () -> new NoSuchElementException("There Are No Client With Id = " + clientId)
        );
    }

    public Client getClientByEmail(String email) {
        return clientRepository.findByEmail(email).orElse(null);
    }

    public Client getByEmailOrPasswordOrElseThrowException(String email, String password) {
        return clientRepository.findByEmailAndPassword(email, password).orElseThrow(
                () -> new NoSuchElementException("Error In Email Or Password")
        );

    }

    public void deleteClientById(long clientId) {
        getClientByIdOrElseThrowException(clientId);
        clientRepository.deleteById(clientId);
    }
}
