package model;

public class User {
	private long accountid;
	private String username;
	private String password;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(long accountid, String username, String password) {
		super();
		this.accountid = accountid;
		this.username = username;
		this.password = password;
	}

	public User(String mailid, long mobileno, long accountid2) {
		// TODO Auto-generated constructor stub
	}

	public long getAccountid() {
		return accountid;
	}

	public void setAccountid(long accountid) {
		this.accountid = accountid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [accountid=" + accountid + ", username=" + username + ", password=" + password + "]";
	}

}
