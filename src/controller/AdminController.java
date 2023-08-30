package controller;

import dao.AdminImpl;
import dao.IAdmin;
import model.Admin;

public class AdminController {
	IAdmin impl = new AdminImpl();

	public String AdminLoginValidation(String username, String password) {
		Admin admin = new Admin();
		admin.setUsername(username);
		admin.setPassword(password);
		return impl.AdminLoginValidation(admin);

	}

	public String ChangePassword(String username, String password) {
		Admin admin = new Admin();
		admin.setUsername(username);
		admin.setPassword(password);
		return impl.ChangePassword(admin);

	}

}
