package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Account;
import util.Db;
import util.Query;

public class AccountImpl implements IAccount {
	PreparedStatement statement;
	String result;
	int status = 0;

	@Override
	public String addAccount(Account account) {
		try {
			statement = Db.getObject().getConnection().prepareStatement(Query.ADD_ACCOUNT);
			statement.setLong(1, account.getAccountid());
			statement.setString(2, account.getUsername());
			statement.setString(3, account.getMailid());
			statement.setLong(4, account.getMobileno());
			statement.setString(5, account.getAccounttype());
			statement.setDouble(6, account.getBalance());
			statement.setString(7, account.getPassword());
			status = statement.executeUpdate();
			result = "Inserted Successfully";
		} catch (SQLException ex) {
			result = "Duplicate Exists";

		}
		return result;
	}

	@Override
	public List<Account> viewAccount() {
		List<Account> list = new ArrayList<Account>();
		try {
			statement = Db.getObject().getConnection().prepareStatement(Query.VIEW_ALL_ACCOUNT);
			ResultSet set = statement.executeQuery();
			while (set.next()) {
				Account account = new Account(set.getLong(1), set.getString(2), set.getString(3), set.getLong(4),
						set.getString(5), set.getDouble(6), set.getString(7));

				list.add(account);
			}

		} catch (SQLException ex) {
			// System.err.println(ex.getMessage());
			ex.printStackTrace();
		}
		return list;

	}

	@Override
	public String updateAccount(Account account) {
		try {
			statement = Db.getObject().getConnection().prepareStatement(Query.UPDATE_ACCOUNT);
			statement.setLong(7, account.getAccountid());
			statement.setString(1, account.getUsername());
			statement.setString(2, account.getMailid());
			statement.setLong(3, account.getMobileno());
			statement.setString(4, account.getAccounttype());
			statement.setDouble(5, account.getBalance());
			statement.setString(6, account.getPassword());
			int status = statement.executeUpdate();
			if (status > 0) {
				result = "Updated Successfully";
			} else {
				result = "Record Not Found";
			}
		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
		}
		return result;

	}

	@Override
	public String deleteAccount(Account account) {
		try {
			statement = Db.getObject().getConnection().prepareStatement(Query.DELETE_ACCOUNT);
			statement.setLong(1, account.getAccountid());
			int status = statement.executeUpdate();
			if (status > 0) {
				result = "Delete Successfully";
			} else {
				result = "Record Not Found";
			}
		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
		}
		return result;

	}

}
