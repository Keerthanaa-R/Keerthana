package dao;

import java.util.List;

import model.Account;
import model.User;

public interface IUser {
	public String UserLoginValidation(User user);

	public List<Account> viewUserAccount();
	
	public String deleteUser(User user);

	public String UpdateDetail(Account user1);

}
