package com.davidoladeji.park.service.interfaces;

import com.davidoladeji.park.model.SpaceType;

import javax.ejb.Local;
import javax.ejb.Remote;
import java.util.List;

/**
 * Created by Daveola on 3/11/2015.
 */

@Remote
public interface SpaceTypeService {


    public void createSpaceType(SpaceType spaceType);

    public List<SpaceType> findAllSpaceTypes();

    public SpaceType findSpaceTypeById(Long id);

    public void updateSpaceTypeById(Long id);

    public void deleteSpaceTypeById(Long id);

    public int countAllSpaceTypes();
}
