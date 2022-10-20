package com.valtech.account.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.valtech.account.entity.Account;
import com.valtech.account.repo.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository accRepo;
	
	public Account createAccount(Account acc){
		return accRepo.save(acc);
	}
	
	public Account updateAccount(Account acc){
		return accRepo.save(acc);
	}
	
	public Account getAccount(Long id){
		return accRepo.findById(id).get();
	}
	
	public List<Account> getAllAccounts(){
		return accRepo.findAll();
	}

	@Override
	public Account createSavingsAcc(double balance) {
		// TODO Auto-generated method stub
		String accType="SB";
		Account acc1 = new Account(accType, balance);
//		acc1.setBalance(balance);
//		acc1.setAccountType("SB");
//		acc1.setActive(false);
//		acc1.setDateOfCreation(LocalDate.now());
//		acc1.setLastUpdatedDate(LocalDate.now());
		return acc1;
	}

	@Override
	public Account createCurrentAcc(double balance) {
		// TODO Auto-generated method stub
		String accType="CA";
		Account acc1 = new Account(accType, balance);
//		acc1.setBalance(balance);
//		acc1.setAccountType("CA");
//		acc1.setActive(false);
//		acc1.setDateOfCreation(LocalDate.now());
//		acc1.setLastUpdatedDate(LocalDate.now());
		return acc1;
	}
}
