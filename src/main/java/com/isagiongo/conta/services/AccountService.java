package com.isagiongo.conta.services;

import com.isagiongo.conta.entities.Account;
import com.isagiongo.conta.repositories.AccountRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account create(Account account)throws Exception {
        if(Objects.isNull(account.getNumber())) {
            throw new Exception("Account null");
        }
        return accountRepository.save(account);
    }

    public Page<Account> findAll(Pageable pageable) {
        return accountRepository.findAll(pageable);
    }

    public Optional<Account> findById(String id) {
        return accountRepository.findById(id);  
    }
}
