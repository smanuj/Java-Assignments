package com.valtech.account.controllers;

import static org.springframework.web.bind.annotation.RestController.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.valtech.account.entity.Account;
import com.valtech.account.service.AccountService;

@org.springframework.web.bind.annotation.RestController
public class RestController {

	@Autowired
	private AccountService accountService;

	@PostMapping("/api/accounts/SB")
	public Account createSavingsAcc(@RequestParam("balance") double balance) {
		return accountService.createSavingsAcc(balance);
	}

	@PostMapping("/api/accounts/CA")
	public Account createCurrentAcc(@RequestParam("balance") double balance) {
		return accountService.createCurrentAcc(balance);
	}
}
