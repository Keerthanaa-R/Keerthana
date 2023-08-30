package util;

public class Query {
	public static final String ADMIN_LOGIN = "select * from admin where username=? and password=?";
	public static final String UPDATE_ADMIN = "update admin set password=? where username=?";
	public static final String VIEW_USER_ACCOUNT = "select * from account where username=? and password=?";
	public static final String USER_LOGIN = "select * from user where username=? and password=?";
	public static final String UPDATE_USER = "update user set mail_id=?,mobile_no=? where account_id=?";
	public static final String ADD_ACCOUNT = "insert into account values(?,?,?,?,?,?,?)";
	public static final String DELETE_USER = "delete from user where account_id=?";
	public static final String DELETE_ACCOUNT = "delete from account where account_id=?";
	public static final String UPDATE_ACCOUNT = "update account set username=?,mail_id=?,mobile_no=?,account_type=?,account_balance=?,password=? where account_id=?";
	public static final String VIEW_ALL_ACCOUNT = "select * from account";
	// public static final String VIEW_ALL_USER = "select * from user where
	// account_id=? and username=?";
}
