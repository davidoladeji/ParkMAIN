package com.davidoladeji.park.service.interfaces;

import com.davidoladeji.park.model.Gender;

import javax.ejb.Local;
import javax.ejb.Remote;
import java.util.List;

/**
 * Created by Daveola on 3/11/2015.
 */

@Remote
public interface GenderService {

    public void createGender(Gender gender);

    public Gender findByGendername(String username);

    public List<Gender> findAllGenders();

    public void updateGenderById(Long id);

    public Gender findGenderById(Long id);

    public void deleteGenderById(Long id);

    public int countAllGenders();
}
