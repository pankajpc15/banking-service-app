package com.financial.banking.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.financial.banking.model.BankAccount;
import com.financial.banking.service.BankAccountService;

@RestController
@RequestMapping("/api/accounts")
public class BankController {
	@Autowired
    private BankAccountService service;

    @GetMapping
    public List<BankAccount> getAllAccounts() {
        return service.getAllAccounts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BankAccount> getAccountById(@PathVariable Long id) {
        Optional<BankAccount> account = service.getAccountById(id);
        return account.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    
   

    @PostMapping
    public ResponseEntity<BankAccount> createAccount(@RequestBody BankAccount account) {
        return new ResponseEntity<>(service.createAccount(account), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BankAccount> updateAccount(@PathVariable Long id, @RequestBody BankAccount account) {
        BankAccount updatedAccount = service.updateAccount(id, account);
        return updatedAccount != null ? ResponseEntity.ok(updatedAccount) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable Long id) {
        service.deleteAccount(id);
        return ResponseEntity.ok("account deleted successfully! ");
    }
}
