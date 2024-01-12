package com.moaaz.wuzzufmostaql.Repository;

import com.moaaz.wuzzufmostaql.Model.Application.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface JobRepository extends JpaRepository<Job , Long> {

    public Optional<List<Job>> findAllByOpen(boolean isOpen);
}
