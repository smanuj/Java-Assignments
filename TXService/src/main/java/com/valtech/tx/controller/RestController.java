package com.valtech.tx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.valtech.tx.entity.Tx;
import com.valtech.tx.service.TxService;

@org.springframework.web.bind.annotation.RestController
public class RestController {
	
	@Autowired
	private TxService txService;
	
	@PostMapping("/api/tx/new")
	public Tx createNewTx(@RequestParam("id") int id,@RequestParam("amount") float amount, @RequestParam("debit") boolean debit, @RequestParam("accountId") long accountId){
		return txService.createNewTx(id, amount, debit, accountId);
	}
	
	@PostMapping("/api/tx/debit")
	public Tx newDebitTx(@RequestParam("amount") float amount, @RequestParam("accountId") long accountId){
		return txService.newDebitTx(amount, accountId);
	}
	
	@PostMapping("/api/tx/credit")
	public Tx newCreditTx(@RequestParam("amount") float amount, @RequestParam("accountId") long accountId){
		return txService.newCreditTx(amount, accountId);
	}

}	
