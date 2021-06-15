package frontend;

import java.util.ArrayList;
import java.util.List;

import go_football.entity.Adminstrator;
import go_football.entity.PlayGroundOwner;
import go_football.entity.Player;
import go_football.entity.Playground;
import go_football.entity.User;

public class Main {
	
	private static List<Player> players = new ArrayList<>();
	private static List<PlayGroundOwner> owners = new ArrayList<>();
	private static List<Playground> playgrounds = new  ArrayList<>();
	private static List<Adminstrator> admins = new  ArrayList<>();
	private static RegistrationMain registrationMain = new RegistrationMain(players, owners, admins);
	
	
	public static void main(String[] args) {
		while (true) {
			User user = registrationMain.registrationMain();
			if (user == null)
				continue;
			if (user instanceof Player) {
				PlayerMain playerMain = new PlayerMain((Player) user, players, playgrounds);
				playerMain.playerMain();
			}
			else if (user instanceof PlayGroundOwner) {
				OwnerMain ownerMain = new OwnerMain((PlayGroundOwner)user, playgrounds);
				ownerMain.ownerMain();
			} else if (user instanceof Adminstrator) {
				AdminstratorMain adminstratorMain = new AdminstratorMain((Adminstrator)user, playgrounds, players, owners);
				adminstratorMain.adminstratorMain();
			}
		}
	}	
	
	

}
