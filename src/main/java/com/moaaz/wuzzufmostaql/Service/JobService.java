package com.moaaz.wuzzufmostaql.Service;

import com.moaaz.wuzzufmostaql.Model.Application.Job;
import com.moaaz.wuzzufmostaql.Repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class JobService {

    @Autowired
    private JobRepository jobRepository;

    public Job addJob(Job job) {

        return jobRepository.save(job);
    }

    public Job updateJob(Job job) {
        getUserByIdOrElseThrowException(job.getId());
        return jobRepository.save(job);
    }

    public List<Job> getAllJobs() {
        return jobRepository.findAllByOpen(true).orElseThrow(
                ()-> new NoSuchElementException("There Are No Job Until Now!")
        );
    }

    public Job getById(long jobId) {
        return getUserByIdOrElseThrowException(jobId);
    }

    private Job getUserByIdOrElseThrowException(long jobId) {
        return jobRepository.findById(jobId).orElseThrow(
                () -> new NoSuchElementException("There Are No Job With Id = " + jobId)
        );
    }

    public List<Job> getAllJobsByTitle(String jobTitle) {
        List<Job> allJobs = jobRepository.findAll();
        return allJobs.stream()
                .filter(job -> job.getTitle().toLowerCase().contains(jobTitle.toLowerCase()))
                .toList();
    }




}
