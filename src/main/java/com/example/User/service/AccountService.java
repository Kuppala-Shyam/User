package com.example.User.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.User.Repository.AccountRepository;
import com.example.User.entity.Account;

@Service
public class AccountService {
	@Autowired
	private AccountRepository accountRepository;

	public Account createAccount(Account account) {
		
		return accountRepository.save(account);
	}

	public Account viewAccountDetails(String name) {
		return accountRepository.findAccountByName(name);
	}

	public Account viewBalance(String accountNumber) {

		return accountRepository.findByAccountNumber(accountNumber);
	}

	public Account updateAccountDetails(String accountNumber, Account updateAccount) {
		Account findAccount = accountRepository.findByAccountNumber(accountNumber);
		if(findAccount != null) {
			findAccount.setAccounType(updateAccount.getAccounType());
			findAccount.setBalance(updateAccount.getBalance());
			findAccount.setEmail(updateAccount.getEmail());
			findAccount.setName(updateAccount.getName());
			findAccount.setPhoneNumber(updateAccount.getPhoneNumber());
			return accountRepository.save(findAccount);
		}
		return null;
	}

	public Account deleteAccount(String accountNumber) {
		
		Account findAccount = accountRepository.findByAccountNumber(accountNumber);
		if(findAccount != null) {
			 accountRepository.delete(findAccount);
			 return findAccount;
		}
		else {
			return findAccount;
		}
	
	}

	public Account updateAccount(Account account) {
		Account findAccount = accountRepository.findByAccountNumber(account.getAccountNumber());
		if(findAccount != null) {
			findAccount.setBalance(account.getBalance());

			return accountRepository.save(findAccount);
		}
		return null;
		
	}

	

	

}
