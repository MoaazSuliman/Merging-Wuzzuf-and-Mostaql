package com.moaaz.wuzzufmostaql.Repository.Client;

import com.moaaz.wuzzufmostaql.Model.Client.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client , Long> {

    public Optional<Client>findByEmailAndPassword(String email , String password);
    public Optional<Client>findByEmail(String email);
}
