package controller;

import java.util.List;

import dao.IUser;
import dao.UserImpl;
import model.Account;
import model.User;

public class UserController {
	User user;
	Account user1;
	IUser impl = new UserImpl();

	public String UserLoginValidation(String name, String password) {
		user = new User();
		user.setUsername(name);
		user.setPassword(password);
		return impl.UserLoginValidation(user);
	}

	public List<Account> viewUserAccount() {
		return impl.viewUserAccount();
	}

	public String UpdateDetail(String mailid, long mobileno, long accountid) {
		user = new User(mailid, mobileno, accountid);
		return impl.UpdateDetail(user1);
	}

	public String deleteAccount(long accountid) {
		user = new User();
		user.setAccountid(accountid);
		return impl.deleteUser(user);
	}

}
