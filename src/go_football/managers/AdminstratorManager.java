package go_football.managers;

import java.util.List;

import go_football.entity.Adminstrator;
import go_football.entity.Complain;
import go_football.entity.PlayGroundOwner;
import go_football.entity.Player;
import go_football.entity.Playground;
import go_football.entity.User;

public class AdminstratorManager {
	Adminstrator adminstrator;
	List<Playground> playgrounds;
	List<Player> players;
	List<PlayGroundOwner> groundOwners;
	
	public AdminstratorManager(Adminstrator adminstrator, List<Playground> playgrounds, List<Player> players,
			List<PlayGroundOwner> groundOwners) {
		this.adminstrator = adminstrator;
		this.playgrounds = playgrounds;
		this.players = players;
		this.groundOwners = groundOwners;
	}
	
	public Playground getPlayground(int playgroundId) {
		for (Playground playground : playgrounds) {
			if (playground.getId() == playgroundId)
				return playground;
		}
		return null;
	}
	
	public User getUser(int userId) {
		for (Player player : players) {
			if (player.getId() == userId) {
				return player;
			}
		}
		for (PlayGroundOwner owner : groundOwners) {
			if (owner.getId() == userId) {
				return owner;
			}
		}
		return null;
	}
	
	public void removeUser(int userId) {
		User user = getUser(userId);
		if (user == null) throw new RuntimeException("There is no user with this id - " + userId);
		if(user instanceof Player) {
			players.remove(user);
		} else {
			groundOwners.remove(user);
			for (Playground playground : ((PlayGroundOwner) user).getPlaygrounds()) {
				playgrounds.remove(playground);
			}
		}
	}
	
	public void removePlayground(int playgroundId) {
		Playground playground = getPlayground(playgroundId);
		if (playground == null) throw new RuntimeException("There is no playground with this id - " + playgroundId);
		playground.getOwner().getPlaygrounds().remove(playground);
		playgrounds.remove(playgroundId);
	}
	
	public List<Complain> showComplains(int playgroundId) {
		Playground playground = getPlayground(playgroundId);
		if (playground == null) throw new RuntimeException("There is no playground with this id - " + playgroundId);
		return playground.getComplains();
	}
}
