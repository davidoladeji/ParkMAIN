package com.davidoladeji.park.repository;


import com.davidoladeji.park.model.SpaceType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Daveola on 2/24/2015.
 * Interface for SpaceTypeRepository extends JpaRepository
 * Provides CRUD facilities for SpaceType Model
 * This contains
 * findAll() method
 * findOne(Long id)
 * delete(Spacetype)
 * save(Spacetype)
 * <p/>
 * Also allows finding by a particular field
 * More details at: http://docs.spring.io/spring-data/jpa/docs/1.6.5.RELEASE/reference/html/repositories.html
 */


@Transactional
public interface SpaceTypeRepository extends JpaRepository<SpaceType, Long> {

}
