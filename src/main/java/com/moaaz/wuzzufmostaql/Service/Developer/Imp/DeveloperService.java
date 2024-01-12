package com.moaaz.wuzzufmostaql.Service.Developer.Imp;

import com.moaaz.wuzzufmostaql.Model.Developer.Developer;
import com.moaaz.wuzzufmostaql.Repository.Developer.DeveloperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class DeveloperService {

    @Autowired
    private DeveloperRepository developerRepository;

    public Developer saveDeveloper(Developer developer) {
        return  developerRepository.save(developer);
    }


    public Developer updateDeveloper(Developer developer) {
        return developerRepository.save(developer);
    }


    public List<Developer> getAll() {
        return developerRepository.findAll();
    }

    public Developer getByIdOrElseThrowException(long developerId) {
        return developerRepository.findById(developerId).orElseThrow(
                () -> new NoSuchElementException("There Are No Developer With Id = " + developerId)
        );
    }

    public Developer getByEmailOrElseThrowException(String email){
        return  developerRepository.findByGeneralInfoEmail(email).orElseThrow(
                () -> new NoSuchElementException("This Email Is Not In Our Database!.")
        );
    }
    public Developer getDeveloperByEmail(String email){
        return  developerRepository.findByGeneralInfoEmail(email).orElse(null);
    }
    public Developer getByEmailAndPasswordOrElseThrowException(String email , String password){
        return  developerRepository.findByGeneralInfoEmailAndGeneralInfoPassword(email, password).orElseThrow(
                () -> new NoSuchElementException("Error In Email Or Password")
        );
    }
    public void deleteDeveloperById(long developerId){
        developerRepository.deleteById(developerId);
    }
}
