package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Admin;
import util.Db;
import util.Query;

public class AdminImpl implements IAdmin {
	PreparedStatement statement;
	String result;
	int i = 0;

	@Override
	public String AdminLoginValidation(Admin admin) {
		try {
			statement = Db.getObject().getConnection().prepareStatement(Query.ADMIN_LOGIN);
			statement.setString(1, admin.getUsername());
			statement.setString(2, admin.getPassword());
			ResultSet set = statement.executeQuery();
			while (set.next()) {
				i++;
			}
			if (i > 0) {
				result = "Welcome to Adminpage";

			} else {
				System.out.println("User or Password is incorrect");
				System.exit(0);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return result;
	}

	@Override
	public String ChangePassword(Admin admin) {
		try {
			statement = Db.getObject().getConnection().prepareStatement(Query.UPDATE_ADMIN);
			statement.setString(1, admin.getPassword());
			statement.setString(2, admin.getUsername());
			i = statement.executeUpdate();
			if (i > 0) {
				result = "Updated Sucessfully";
			} else {
				result = "Record not found";
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return result;
	}

}
