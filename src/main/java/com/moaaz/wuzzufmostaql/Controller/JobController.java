package com.moaaz.wuzzufmostaql.Controller;

import com.moaaz.wuzzufmostaql.Model.Application.Job;
import com.moaaz.wuzzufmostaql.Service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/moaaz/wuzzufmostaql/api/jobs")
@RestController
public class JobController {

    @Autowired
    private JobService jobService;

    @GetMapping("/getAll")
    @ResponseStatus(HttpStatus.OK)
    public List<Job> getAllJobs(){
        return jobService.getAllJobs();
    }
}
