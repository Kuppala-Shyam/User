package com.example.User.controller;

import java.util.List;

import org.apache.commons.lang3.EnumUtils;
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

import com.example.User.entity.Account;
import com.example.User.entity.AccountType;
import com.example.User.model.AccountDetails;
import com.example.User.service.AccountService;

@RestController
@RequestMapping("/account/")
public class AccountController {
	@Autowired
	private AccountService accountService;
	
	@PostMapping("/createAccount")
	public ResponseEntity<Account> createAccount(@RequestBody Account account){
		if(account.getAccounType() == null || !EnumUtils.isValidEnum(AccountType.class, account.getAccounType().toString())) {
			return ResponseEntity.badRequest().build();
		}
		Account createdAccount = accountService.createAccount(account);
		return ResponseEntity.ok(createdAccount);
	}
	
	@GetMapping("/viewAccountDetails/{name}")
	public ResponseEntity<Account> viewAccountDetails(@PathVariable("name") String name) {
		Account account = accountService.viewAccountDetails(name);
		if(account != null) {
			return ResponseEntity.ok(account);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping("/viewBalance/{accountNumber}")
	public ResponseEntity<AccountDetails> viewBalance(@PathVariable("accountNumber")  String accountNumber){
		Account account = accountService.viewBalance(accountNumber);
		if(account != null) {
			AccountDetails accountDetails = new AccountDetails(account.getName(), account.getBalance());
			return ResponseEntity.ok(accountDetails);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PutMapping("/updateAccountDetails/{accountNumber}")
	public ResponseEntity<Account> updateAccountDetails(@PathVariable("accountNumber") String accountNumber, @RequestBody Account updateAccount) {
		Account accountUpdate = accountService.updateAccountDetails(accountNumber, updateAccount);
		if(accountUpdate != null) {
			return ResponseEntity.ok(accountUpdate);
		}else {
			return ResponseEntity.notFound().build();
		}
		
	}
	
	@DeleteMapping("/deleteAccount/{accountNumber}")
	public ResponseEntity<?> deleteAccount(@PathVariable("accountNumber") String accountNumber){
		Account accountDeletion = accountService.deleteAccount(accountNumber);
		if(accountDeletion != null) {
			return  ResponseEntity.ok("account with "+accountNumber+" deleted successfully ");
		}
		else {
			return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("account with "+accountNumber+" is not deleted ");
		}
	}

}
