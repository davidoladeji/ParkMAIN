package com.davidoladeji.park.service.implementation;

import com.davidoladeji.park.model.Account;
import com.davidoladeji.park.repository.AccountRepository;
import com.davidoladeji.park.service.interfaces.AccountService;
import org.jboss.spring.callback.SpringLifecycleInterceptor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import java.util.List;

/**
 * Created by Daveola on 3/5/2015.
 */


@Stateless(name = "AccountServiceImpl")
@Interceptors(SpringLifecycleInterceptor.class)
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountRepository accountRepository;


    public List<Account> findAllAccounts() {
        return accountRepository.findAll();
    }


    public void updateAccountById(Long id) {
        Account account = accountRepository.findById(id);
        accountRepository.save(account);
    }

    /**
     * Find a single account by a user Id
     *
     * @param id
     * @return
     */

    public Account findAccountById(Long id) {
        return accountRepository.findOne(id);
    }

    public void deleteAccountById(Long userId) {
        accountRepository.delete(userId);
    }


    public Account findByAccountname(String username) {
        return accountRepository.findByUsername(username);
    }


    /**
     * Find all Accounts with a particular role name e.g. Customer
     *
     * @param name
     * @return
     */
    public List<Account> findByRoleName(String name) {
        List<Account> account = accountRepository.findByUserRole_Name(name);
        return account;
    }

    public Account findByEmail(String email) {
        Account account = accountRepository.findByEmail(email);
        return account;
    }


    public void createAccount(Account account) {
        accountRepository.save(account);
    }

}
