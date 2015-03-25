package com.davidoladeji.park.repository;

import com.davidoladeji.park.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * Created by Daveola on 3/3/2015.
 * Interface for UserRepository extends JpaRepository
 * Provides CRUD facilities for User Model
 * This contains
 * findAll() method
 * findOne(Long id)
 * delete(User)
 * save(User)
 * <p/>
 * Also allows finding by a particular field
 * More details at: http://docs.spring.io/spring-data/jpa/docs/1.6.5.RELEASE/reference/html/repositories.html
 */


@Transactional
public interface AccountRepository extends JpaRepository<Account, Long> {

    Account findByUsername(String username);

    Account findById(Long id);

    List<Account> findByUserRole_Name(String name);

    Account findByEmail(String email);
}

