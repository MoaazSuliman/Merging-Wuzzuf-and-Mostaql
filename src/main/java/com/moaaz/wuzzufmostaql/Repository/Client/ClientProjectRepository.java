package com.moaaz.wuzzufmostaql.Repository.Client;

import com.moaaz.wuzzufmostaql.Model.Client.Client;
import com.moaaz.wuzzufmostaql.Model.Client.ClientProject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientProjectRepository extends JpaRepository<ClientProject, Long> {
    public List<ClientProject> findAllByClient(Client client);
}
