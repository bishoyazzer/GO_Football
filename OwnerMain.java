package frontend;
import java.util.List;
import java.util.Scanner;

import go_football.entity.AvaliableHour;
import go_football.entity.PlayGroundOwner;
import go_football.entity.Playground;
import go_football.managers.OwnerManager;


public class OwnerMain {
	Scanner scanner;
	private OwnerManager manager;
	
	
	
	public OwnerMain(PlayGroundOwner owner, List<Playground> playgrounds) {
		scanner =new java.util.Scanner(System.in);
		manager = new OwnerManager(owner, playgrounds);
	}

	public void ownerMain() {
		boolean logout = false;
		while(true) {
			if (logout)
				break;
			showMenu();
			int choice = Integer.parseInt(scanner.next());
			switch(choice) {
				case 1:
					addNewPlayground();
					break;
				case 2:
					removePlayground();
					break;
				case 3:
					deposite();
					break;
				case 4:
					withdraw();
					break;
				case 5:
					addAvaliableTime();
					break;
				case 6:
					showComplains();
					break;
				case 7:
					logout=true;
					break;
			}
		}
	}

	private void showMenu() {
		System.out.println("1- Add new playground ");
		System.out.println("2- Remove playground");
		System.out.println("3- Deposit ");
		System.out.println("4- Withdraw ");
		System.out.println("5- Add avaliable time ");
		System.out.println("6- Show complains ");
		System.out.println("7- Logout ");
		
	}
	public void withdraw() {
		System.out.println("Enter how much you wanna withraw: ");
		int amount = Integer.parseInt(scanner.next());
		manager.withdraw(amount);
	}

	public void deposite() {
		System.out.println("Enter how much you wanna deposite:");
		int amount = Integer.parseInt(scanner.next());
		manager.deposite(amount);
	}
	public void removePlayground() {
		System.out.println("Enter the Playground ID: ");
		int id = Integer.parseInt(scanner.next());
		manager.removePlayground(id);
		
	}
	public void addAvaliableTime() {
		AvaliableHour avaliableHour = new AvaliableHour();
		System.out.println("Enter the Playground ID: ");
		int id = Integer.parseInt(scanner.next());
		System.out.println("Enter the day: ");
		String day = scanner.next();
		scanner.nextLine();
		avaliableHour.setDay(day);
		System.out.println("please enter the Start hour: ");
		int starthour = Integer.parseInt(scanner.next());
		avaliableHour.setStartHour(starthour);
		System.out.println("please enter the End hour: ");
		int endhour = Integer.parseInt(scanner.next());
		avaliableHour.setEndHour(endhour);
		manager.addAvaliableTime(id, avaliableHour);
		
	}
	public void addNewPlayground() {
		System.out.println("Enter the playground name: ");
		String name = scanner.next();
		scanner.nextLine();
	
		System.out.println("Enter the location: ");
		String location = scanner.nextLine();
		System.out.println("Enter the size: ");
		double size = Double.parseDouble(scanner.nextLine());
		System.out.println("Enter the price per hour: ");
		double price = Double.parseDouble(scanner.nextLine());
		manager.addNewPlayground(location, size, name, price);		
	}
	
	public void showComplains() {
		manager.showAllComplains();
	}

}
