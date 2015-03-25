package com.davidoladeji.park.service.implementation;

import com.davidoladeji.park.model.Gender;
import com.davidoladeji.park.repository.GenderRepository;
import com.davidoladeji.park.service.interfaces.GenderService;
import org.jboss.spring.callback.SpringLifecycleInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import java.util.List;

/**
 * Created by Daveola on 3/11/2015.
 */

@Stateless(name = "GenderServiceImpl")
@Interceptors(SpringLifecycleInterceptor.class)
public class GenderServiceImpl implements GenderService {

    @Autowired
    GenderRepository genderRepository;

    public void createGender(Gender gender) {
        genderRepository.save(gender);
    }

    public Gender findByGendername(String gendername) {
        return genderRepository.findByName(gendername);
    }

    public List<Gender> findAllGenders() {
        return genderRepository.findAll();
    }

    public void updateGenderById(Long id) {
        genderRepository.save(genderRepository.findOne(id));
    }

    public Gender findGenderById(Long id) {
        return genderRepository.findOne(id);
    }

    public void deleteGenderById(Long id) {
        genderRepository.delete(genderRepository.findOne(id));
    }

    public int countAllGenders() {
        List<Gender> genderList = genderRepository.findAll();
        int numGenders = genderList.size();
        return numGenders;
    }
}
