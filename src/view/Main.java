package view;

import java.io.IOException;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;
import controller.AccountController;
import controller.AdminController;
import controller.UserController;
import model.Account;

public class Main {

	public static void main(String[] args)
			throws ClassNotFoundException, SQLException, IOException, NumberFormatException {
		Scanner scanner = new Scanner(System.in);
		String s[];
		System.out.println("****Fund Transfer Application****");
		System.out.println("MENU: 1.Admin 2.User");
		int option = scanner.nextInt();

		if (option == 1) {
			scanner.nextLine();
			AdminController con = new AdminController();
			System.out.println("Enter Username");
			String username = scanner.nextLine();
			System.out.println("Enter Password");
			String password = scanner.nextLine();
			System.out.println(con.AdminLoginValidation(username, password));

			AccountController controller = new AccountController();
			UserController conn = new UserController();

			try {
				int a;
				do {
					System.out.println(
							"MENU: 1.Add Account 2.View Account 3.Update Account 4.Delete Account 5.Change Password");
					option = scanner.nextInt();
					switch (option) {
					case 1:
						scanner.nextLine();
						System.out.println(
								"Enter Accountid,Username,Mailid,Mobileno,Accounttype,Balance,Password for ADD");
						s = scanner.nextLine().split(",");
						System.out.println(controller.addAccount(Long.parseLong(s[0]), s[1], s[2], Long.parseLong(s[3]),
								s[4], Double.parseDouble(s[5]), s[6]));
						break;
					case 2:
						System.out.format("%-20s%-20s%-20s%-20s%-20s%-20s%-20s\n", "ACCOUNTID", "USERNAME", "MAIL ID",
								"MOBILE NO", "ACCOUNT TYPE", "BALANCE", "PASSWORD");
						for (Account account : controller.viewAccount()) {
							System.out.println(account);
						}
						break;

					case 3:
						scanner.nextLine();
						System.out.println(
								"Enter Accountid,Username,Mailid,Mobileno,Accounttype,Balance,Password for UPDATE");
						s = scanner.nextLine().split(",");
						System.out.println(controller.updateAccount(Long.parseLong(s[0]), s[1], s[2],
								Long.parseLong(s[3]), s[4], Double.parseDouble(s[5]), s[6]));
						break;
					case 4:
						System.out.println("Enter User Accountid for DELETE");
						Long account = scanner.nextLong();
						System.out.println(conn.deleteAccount(account));
	
						System.out.println("Enter Accountid for DELETE");
						account = scanner.nextLong();
						System.out.println(controller.deleteAccount(account));
						break;
						
					case 5:
						scanner.nextLine();
						System.out.println("Enter UserName,Password to Change");
						s = scanner.nextLine().split(",");
						System.out.println(con.ChangePassword(s[0], s[1]));
						break;
					default:
						System.out.println("Please enter valid option");
						System.exit(0);
					}
					System.out.println("\n If you want to continue Admin Operations!! if yes - press 1,else press 0");
					a = scanner.nextInt();
				} while (a == 1);
				System.out.println("Thank you");
			} catch (InputMismatchException e) {
				System.out.println(e.getMessage());
			}
		} else if (option == 2) {
			System.out.println("Welcome to Login Page");
			scanner.nextLine();
			UserController conn = new UserController();
			System.out.println("Enter name");
			String name = scanner.nextLine();
			System.out.println("Enter password");
			String password = scanner.nextLine();
			System.out.println(conn.UserLoginValidation(name, password));
			// @SuppressWarnings("unused")
			AccountController controller = new AccountController();
			try {
				int b;
				do {
				System.out.println("MENU:1.View User 2.UpdateDetails ");
				option = scanner.nextInt();
				switch (option) {
				case 1:
					for (Account account : conn.viewUserAccount()) {
						System.out.println(account);
					}
					break;
				case 2:
					scanner.nextLine();
					System.out.println("Enter Accountid,Mailid,Mobileno,Accounttype,Balance,Password for UPDATE");
					s = scanner.nextLine().split(",");
					System.out.println(controller.updateAccount(Long.parseLong(s[0]), s[1], s[2], Long.parseLong(s[3]),
							s[4], Double.parseDouble(s[5]), s[6]));
				}

				System.out.println("\n If you want to continue Admin Operations!! if yes - press 1,else press 0");
				b = scanner.nextInt();
				}while (b == 1);
				System.out.println("Thank you");
				
			} catch (InputMismatchException e) {
				System.out.println(e.getMessage());
			}
//						else {
//							System.out.println("Please choose valid option");
//						}
		}

		scanner.close();
	}
}
