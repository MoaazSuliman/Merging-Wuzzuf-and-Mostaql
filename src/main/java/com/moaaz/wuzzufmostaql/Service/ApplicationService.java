package com.moaaz.wuzzufmostaql.Service;

import com.moaaz.wuzzufmostaql.Dto.ApplicationDto;
import com.moaaz.wuzzufmostaql.Model.Application.Application;
import com.moaaz.wuzzufmostaql.Model.Application.Job;
import com.moaaz.wuzzufmostaql.Model.Developer.Developer;
import com.moaaz.wuzzufmostaql.Repository.ApplicationRepository;
import com.moaaz.wuzzufmostaql.Service.Developer.Imp.DeveloperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApplicationService {

    @Autowired
    private ApplicationRepository applicationRepository;

    public void saveApplication(Application application){
        applicationRepository.save(application);
    }


}
