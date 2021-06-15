package go_football.managers;



import java.util.List;

import go_football.entity.AvaliableHour;
import go_football.entity.PlayGroundOwner;
import go_football.entity.Playground;

public class OwnerManager {
	PlayGroundOwner owner;
	List<Playground> playgrounds;
	public OwnerManager(PlayGroundOwner owner, List<Playground> playgrounds) {
		this.owner = owner;
		this.playgrounds = playgrounds;
	}
	
	public void addNewPlayground(String location, double size, String name, double pricePerHour) {
		Playground playground = new Playground(location, size, name, pricePerHour, owner);
		playgrounds.add(playground);
		owner.addNewPlayground(playground);
	}
	
	public void removePlayground(int playgroundId) {
		Playground playground =  owner.removePlayground(playgroundId);
		if (playground != null)
			playgrounds.remove(playground);
	}
	
	public void addAvaliableTime(int playgroundId, AvaliableHour avaliableHour) {
		Playground  playground = owner.getPlayground(playgroundId);
		playground.addNewAvaliableHour(avaliableHour);
	}
	
	public boolean withdraw(int amount) {
		return owner.withdraw(amount);
	}
	
	public void deposite(int amount) {
		owner.deposide(amount);
	}
	
	public void showPlaygrounds() {
		owner.showPlaygrounds();
	}
	
	public void showAllComplains() {
		List<Playground> playgrounds = owner.getPlaygrounds();
		for (Playground playground : playgrounds) {
			
			System.out.println("Playground id - " + playground.getId());
			System.out.println(">>>> Complains: ");
			System.out.println(playground.getComplains());
		}
	}
	
}
