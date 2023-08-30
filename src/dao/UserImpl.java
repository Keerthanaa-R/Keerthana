package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Account;
import model.User;
import util.Db;
import util.Query;

public class UserImpl implements IUser {
	PreparedStatement statement;
	String result;
	int i = 0;
	int status = 0;
	ResultSet set;

	@Override
	public String UserLoginValidation(User user) {
		try {
			statement = Db.getObject().getConnection().prepareStatement(Query.USER_LOGIN);
			statement.setString(1, user.getUsername());
			statement.setString(2, user.getPassword());
			set = statement.executeQuery();
			while (set.next()) {
				i++;
			}
			if (i > 0) {
				result = "Welcome to Userpage";
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
	public String UpdateDetail(Account user1) {
		try {
			statement = Db.getObject().getConnection().prepareStatement(Query.UPDATE_USER);
			statement.setString(1, user1.getMailid());
			statement.setLong(2, user1.getMobileno());
			statement.setLong(3, user1.getAccountid());

			statement.executeUpdate();
			if (i > 0) {
				result = "Updated Successfully";
			} else {
				result = "Record Not Found";
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return result;
	}

	@Override
	public List<Account> viewUserAccount() {
		List<Account> list = new ArrayList<Account>();
		try {
			@SuppressWarnings("resource")
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter Username and Password");
			statement = Db.getObject().getConnection().prepareStatement(Query.VIEW_USER_ACCOUNT);
			String username = scanner.nextLine();
			String password = scanner.nextLine();
			statement.setString(1, username);

			statement.setString(2, password);
			set = statement.executeQuery();

			while (set.next()) {
				Account account = new Account(set.getLong(1), set.getString(2), set.getString(3), set.getLong(4),
						set.getString(5), set.getDouble(6), set.getString(7));
				list.add(account);
			}
			System.out.format("%-20s%-20s%-20s%-20s%-20s%-20s%-20s\n", "accountid", "username", "mailid", "mobileno",
					"accounttype", "balance", "password");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return list;
	}
	

	@Override
	public String deleteUser(User user) {
		try {
			statement = Db.getObject().getConnection().prepareStatement(Query.DELETE_USER);
			statement.setLong(1, user.getAccountid());
			int status = statement.executeUpdate();
			if (status > 0) {
				result = "Delete Successfully";
			} else {
				result = "Record Not Found";
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return result;

	}

		
	}
