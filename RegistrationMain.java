package frontend;

import java.util.List;
import java.util.Scanner;

import go_football.entity.Adminstrator;
import go_football.entity.PlayGroundOwner;
import go_football.entity.Player;
import go_football.entity.User;
import go_football.managers.RegistrationManager;

public class RegistrationMain {
	Scanner scanner;
	List<Player> players;
	List<PlayGroundOwner> owners;
	List<Adminstrator> admins;
	RegistrationManager manager;
	
	public RegistrationMain(List<Player> players, List<PlayGroundOwner> owners, List<Adminstrator> admins) {
		scanner = new Scanner(System.in);
		this.players = players;
		this.owners = owners;
		this.admins = admins;
		manager = new RegistrationManager();
	}
	

	public User registrationMain() {
		System.out.println("Welcome!");
		System.out.println("1- login");
		System.out.println("2- register");
		int choice = Integer.parseInt(scanner.next());
		if (choice == 1)
			return login();
		else
			return register();
	}

	private User register() {			
		System.out.println("Enter your name");
		String name = scanner.next().trim();
		scanner.nextLine();
	
		System.out.println("enter your password");
		String password = scanner.nextLine(). trim();
	
		System.out.println("confirm password");
		String passwordConfirmation = scanner.nextLine().trim();

		
		System.out.println("enter your phone number");
		String phone = scanner.nextLine().trim();

	
		System.out.println("enter your location");
		String location = scanner.nextLine().trim();
		System.out.println("Enter Email");
		String email = scanner.next().trim();
		System.out.println("Account type");
		System.out.println("1-Player");
		System.out.println("2-Owner");
		System.out.println("3-Adminstrator");
		int typeChoice = Integer.parseInt(scanner.next().trim());
		String type = null;
		if (typeChoice == 1)
			type = "PLAYER";
		else if (typeChoice == 2)
			type = "OWNER";
		if (password.equals (passwordConfirmation)) {
			User user = manager.register(name, password, email, phone, location, players, owners, admins, type);
			System.out.println("Your id is " + user.getId());
		    return user;
		}
		System.out.println("password doesn't match");
		return null;
	}

	private User login() {
		System.out.println("Enter your email: ");
		String email = scanner.next().trim();
		System.out.println("Enter your password: ");
		String password = scanner.next().trim();
		scanner.nextLine();
		return manager.login(email, password, players, owners);
	}
	
	

}
