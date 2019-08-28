package com.isagiongo.conta.controllers;

import com.isagiongo.conta.entities.Account;
import com.isagiongo.conta.services.AccountService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/api/account")
public class AccountResource {

    private final AccountService accountService;

    public AccountResource(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping
    public ResponseEntity<Page<Account>> findAll(Pageable pageable) {
        return ResponseEntity.ok(accountService.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Account> findById(@PathVariable String id) throws Exception{
        return accountService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(()-> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Account> create(@RequestBody Account account) throws Exception {
        return ResponseEntity.ok(accountService.create(account));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Account> update(@PathVariable String id, @RequestBody Account account) throws Exception {
        return ResponseEntity.ok(accountService.update(id, account));
    }
}
