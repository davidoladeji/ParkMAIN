package com.davidoladeji.park.service.implementation;

import com.davidoladeji.park.model.SpaceType;
import com.davidoladeji.park.repository.SpaceTypeRepository;
import com.davidoladeji.park.service.interfaces.SpaceTypeService;
import org.jboss.spring.callback.SpringLifecycleInterceptor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import java.util.List;

/**
 * Created by Daveola on 3/11/2015.
 */

@Stateless(name = "SpaceTypeServiceImpl")
@Interceptors(SpringLifecycleInterceptor.class)
public class SpaceTypeServiceImpl implements SpaceTypeService {

    @Autowired
    SpaceTypeRepository spaceTypeRepository;


    public void createSpaceType(SpaceType spaceType) {
        spaceTypeRepository.save(spaceType);
    }

    public List<SpaceType> findAllSpaceTypes() {
        List<SpaceType> spaceTypeList = spaceTypeRepository.findAll();
        return spaceTypeList;
    }

    public void updateSpaceTypeById(Long id) {
        SpaceType spaceType = spaceTypeRepository.findOne(id);
        spaceTypeRepository.save(spaceType);
    }

    public SpaceType findSpaceTypeById(Long id) {
        SpaceType spaceType = spaceTypeRepository.findOne(id);
        return spaceType;
    }

    public void deleteSpaceTypeById(Long id) {
        SpaceType spaceType = spaceTypeRepository.findOne(id);
        spaceTypeRepository.delete(spaceType);
    }

    public int countAllSpaceTypes() {
        List<SpaceType> spaceTypeList = spaceTypeRepository.findAll();
        int numSpaceTypes = spaceTypeList.size();
        return numSpaceTypes;

    }
}
