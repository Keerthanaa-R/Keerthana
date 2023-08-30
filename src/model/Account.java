package model;

public class Account {
	private long accountid;
	private String username;
	private String mailid;
	private long mobileno;
	private String accounttype;
	private double balance;
	private String password;

	public Account() {
	}

	public Account(long accountid, String username, String mailid, long mobileno, String accounttype, double balance,
			String password) {
		super();
		this.accountid = accountid;
		this.username = username;
		this.mailid = mailid;
		this.mobileno = mobileno;
		this.accounttype = accounttype;
		this.balance = balance;
		this.password = password;
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

	public String getMailid() {
		return mailid;
	}

	public void setMailid(String mailid) {
		this.mailid = mailid;
	}

	public long getMobileno() {
		return mobileno;
	}

	public void setMobileno(long mobileno) {
		this.mobileno = mobileno;
	}

	public String getAccounttype() {
		return accounttype;
	}

	public void setAccounttype(String accounttype) {
		this.accounttype = accounttype;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return String.format("%-20s%-20s%-20s%-20s%-20s%-20s%-20s\n", accountid, username, mailid, mobileno,
				accounttype, balance, password);
	}

}
