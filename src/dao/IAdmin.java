package dao;

import model.Admin;

public interface IAdmin {
	public String AdminLoginValidation(Admin admin);
	
	public String ChangePassword(Admin admin);

}
