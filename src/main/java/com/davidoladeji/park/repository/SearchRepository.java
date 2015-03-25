package com.davidoladeji.park.repository;

import com.davidoladeji.park.model.Search;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Daveola on 3/3/2015.
 * Interface for SearchRepository extends JpaRepository
 * Provides CRUD facilities for Search Model
 * This contains
 * findAll() method
 * findOne(Long id)
 * delete(Search)
 * save(Search)
 * <p/>
 * Also allows finding by a particular field
 * More details at: http://docs.spring.io/spring-data/jpa/docs/1.6.5.RELEASE/reference/html/repositories.html
 */


@Transactional
public interface SearchRepository extends JpaRepository<Search, Long> {

}

