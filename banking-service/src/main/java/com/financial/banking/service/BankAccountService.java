package com.financial.banking.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.financial.banking.model.BankAccount;
import com.financial.banking.repository.BankAccountRepository;

@Service
public class BankAccountService {
	
	 @Autowired
	    private BankAccountRepository repository;

	    public List<BankAccount> getAllAccounts() {
	        return repository.findAll();
	    }

	    public Optional<BankAccount> getAccountById(Long id) {
	        return repository.findById(id);
	    }

	    public BankAccount createAccount(BankAccount account) {
	        return repository.save(account);
	    }

	    public BankAccount updateAccount(Long id, BankAccount account) {
	        if (repository.existsById(id)) {
	            account.setId(id);
	            return repository.save(account);
	        }
	        return null;
	    }

	    public void deleteAccount(Long id) {
	        repository.deleteById(id);
	    }
	
	

}
