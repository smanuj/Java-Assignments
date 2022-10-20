package com.valtech.account.service;

import com.valtech.account.controllers.*;
import com.valtech.account.entity.Account;

public interface AccountService {

	Account createSavingsAcc(double balance);

	Account createCurrentAcc(double balance);

}