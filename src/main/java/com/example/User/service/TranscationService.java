package com.example.User.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.User.Repository.AccountRepository;
import com.example.User.entity.Account;
import com.example.User.entity.Transcation;

@Service
public class TranscationService  {
	@Autowired
	private AccountRepository accountRepository;
	@Autowired
	private AccountService accountService;

	public Transcation transferMoney(Double amount, String senderAccountNumber, String receiverAccountNumber) {
	    Account senderAccount = accountRepository.findByAccountNumber(senderAccountNumber);
	    Account receiverAccount = accountRepository.findByAccountNumber(receiverAccountNumber);
	    if(senderAccount == null || receiverAccount == null) {
	        return null;
	    }
	    if(senderAccount.getBalance() < amount) {
	        return null;
	    }
	    senderAccount.setBalance(senderAccount.getBalance()-amount);
	    accountService.updateAccount(senderAccount);
	    receiverAccount.setBalance(receiverAccount.getBalance()+amount);
	    accountService.updateAccount(receiverAccount);
	    Transcation transcation = new Transcation();
	    transcation.setAmount(amount);
	    transcation.setSenderAccountNumber(senderAccount);
	    transcation.setReceiverAccountNumber(receiverAccount);
	    transcation.setTimestamp(new Date());
	    return transcation;
	}

	
}
