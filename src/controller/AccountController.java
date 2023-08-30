package controller;

import java.util.List;

import dao.AccountImpl;
import dao.IAccount;
import model.Account;

public class AccountController {
	Account account;
	IAccount impl = new AccountImpl();

	public String addAccount(long accountid, String username, String mailid, long mobileno, String accounttype,
			double balance, String password) {
		account = new Account(accountid, username, mailid, mobileno, accounttype, balance, password);
		return impl.addAccount(account);
	}

	public List<Account> viewAccount() {
		return impl.viewAccount();
	}

	public String updateAccount(long accountid, String username, String mailid, long mobileno, String accounttype,
			double balance, String password) {
		account = new Account(accountid, username, mailid, mobileno, accounttype, balance, password);
		return impl.updateAccount(account);
	}

	public String deleteAccount(long accountid) {
		account = new Account();
		account.setAccountid(accountid);
		return impl.deleteAccount(account);
	}

}
