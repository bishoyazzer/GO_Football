package go_football.entity;

import java.util.ArrayList;
import java.util.List;

public class PlayGroundOwner extends User{

	private double ewallet;
	private List<Playground> playgrounds;
	
	public PlayGroundOwner(String name, String password, String email, String phone, String location) {
		super(name, password, email, phone, location);
		ewallet = 0;
		playgrounds = new ArrayList<>();
	}
	
	public boolean withdraw(double amount) {
		if (amount < 0) throw new IllegalArgumentException();
		if (ewallet - amount < 0) return false;
		ewallet -= amount;
		return true;
	}	
	
	
	public void deposide(double amount) {
		if (amount < 0) throw new IllegalArgumentException();
		ewallet += amount;
	}

	public double getEwallet() {
		return ewallet;
	}

	public List<Playground> getPlaygrounds() {
		return playgrounds;
	}
	
	public void addNewPlayground(Playground playground) {
		playgrounds.add(playground);
	}
	
	public Playground getPlayground(int id) {
		for (Playground playground : playgrounds) {
			if (playground.getId() == id) {
				return playground;
			}
		}
		return null;
	}
	
	public Playground removePlayground(int id) {
		Playground playground = getPlayground(id);
		if (playground == null) {
			return null;
		}
		playgrounds.remove(playground);
		return playground;
	}

	public void showPlaygrounds() {
		System.out.println(playgrounds);
	}
	
}
