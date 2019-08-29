package com.isagiongo.conta.services;

import com.isagiongo.conta.entities.Account;
import com.isagiongo.conta.entities.CreateAccountRequest;
import com.isagiongo.conta.repositories.AccountRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    private final LimitService limitService;

    public AccountService(AccountRepository accountRepository, LimitService limitService) {
        this.accountRepository = accountRepository;
        this.limitService = limitService;
    }

    public Account create(CreateAccountRequest request)throws Exception {
        Account account = new Account(request);
        account = accountRepository.save(account);
        limitService.createLimit(account.getId());
        return account;
    }

    public Page<Account> findAll(Pageable pageable) {
        return accountRepository.findAll(pageable);
    }

    public Optional<Account> findById(String id) {
        return accountRepository.findById(id);
    }

    public Account update(String id, Account account) throws Exception {
        Optional<Account> dbAccount = accountRepository.findById(id);
        if(!dbAccount.isPresent()) {
            throw new Exception("Account not found");
        }
        Account accountDb = dbAccount.get();
        accountDb.setNumber(account.getNumber());
        accountDb.setAgency(account.getAgency());
        accountDb.setCpf(account.getCpf());
        return accountRepository.save(accountDb);
    }

    public void delete(String id) {
        Optional<Account> account = accountRepository.findById(id);
        if(account.isPresent()) {
            Account deleteAccount = account.get();
            deleteAccount.setActive(false);
            accountRepository.save(deleteAccount);
        }
    }
}
