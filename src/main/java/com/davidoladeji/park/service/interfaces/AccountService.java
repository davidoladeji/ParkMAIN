package com.davidoladeji.park.service.interfaces;

import com.davidoladeji.park.model.Account;

import javax.ejb.Remote;
import java.util.List;

/**
 * Created by Daveola on 3/11/2015.
 */

@Remote
public interface AccountService {

    public void createAccount(Account account);

    public Account findByEmail(String email);

    public Account findByAccountname(String username);

    public List<Account> findByRoleName(String name);

    public List<Account> findAllAccounts();

    public void updateAccountById(Long id);

    public Account findAccountById(Long id);

    public void deleteAccountById(Long id);
}
