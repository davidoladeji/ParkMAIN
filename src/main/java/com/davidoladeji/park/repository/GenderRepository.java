package com.davidoladeji.park.repository;


/**
 * Created by Daveola on 25-Nov-14.
 * Interface for GenderRepository extends JpaRepository
 * Provides CRUD facilities for Gender Model
 * This contains
 * findAll() method
 * findOne(Long id)
 * delete(Gender)
 * save(Gender)
 *
 * Also allows finding by a particular field
 * More details at: http://docs.spring.io/spring-data/jpa/docs/1.6.5.RELEASE/reference/html/repositories.html
 */


import com.davidoladeji.park.model.Gender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface GenderRepository extends JpaRepository<Gender, Long> {

    Gender findByName(String gendername);
}
