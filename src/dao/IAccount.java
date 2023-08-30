package dao;

import java.util.List;

import model.Account;

public interface IAccount {
	public String addAccount(Account account);

	public List<Account> viewAccount();

	public String deleteAccount(Account account);

	public String updateAccount(Account account);

}
