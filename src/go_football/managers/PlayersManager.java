package go_football.managers;

import java.util.List;
/** 
* PlayerManager class to manage a player actions. 
*/

import go_football.entity.AvaliableHour;
import go_football.entity.Invitation;
import go_football.entity.Player;
import go_football.entity.Playground;

public class PlayersManager {
	/** 
	 * PlayerManager player
	 */
	private Player player;
	/** 
	 * PlayerManager otherPlayers
	 */
	private List<Player> otherPlayers;
	/** 
	 * 
	 */
	private List<Playground> playgrounds;
	
	 /** 
		* PlayerManager Constructor.
		* @param Player player
		* @param Player other players
		* @param Playground playgrounds
		*/
	public PlayersManager(Player player, List<Player> otherPlayers, List<Playground> playgrounds) {
		this.player = player;
		this.otherPlayers = otherPlayers;
		this.playgrounds = playgrounds;
	}
	/** 
	* this method to show Playgrounds for this PLayer.
	* @param String location
	*/
	public void showPlaygrounds(String location) {
		for (Playground  playground : playgrounds) {
			if (playground.getLocation().equals(location))
				System.out.println(playground);
		}
	}
	/** 
	* this method returns playground for this PLayer.
	* @return Playground
	* @param int id
	*/
	private Playground getPlayground(int id) {
		for (Playground playground : playgrounds) {
			if (playground.getId() == id) {
				return playground;
			}
		}
		return null;
	}
	/** 
	* this method returns the avaliableHour for this player.
	* @return AvaliableHour
	* @param Avaliablehour avaliableHour
	* @param String day
	* @param int starHour
	* @param endHour
	*/
	private AvaliableHour getAvaliableHour(List<AvaliableHour> avaliableHours, String day, int startHour, int endHour) {
		for (AvaliableHour tempAvaliableHour : avaliableHours) {
			if (tempAvaliableHour.isAvaliable() && tempAvaliableHour.getDay().equals(day)
					&& tempAvaliableHour.getStartHour() == startHour
					&& tempAvaliableHour.getEndHour() == endHour) {
				return tempAvaliableHour;
			}
		}
		return null;
	}
	/** 
	* this method to book playground .
	* @return Playground
	* @param int playgroundId
	* @param String day
	* @param int startHour
	* @param int endHour 
	*/
	public Playground reservePlayground(int playgroundId, String day, int startHour, int endHour) {
		Playground playground = getPlayground(playgroundId);
		if (playground == null) throw new IllegalArgumentException("There is no playground with this id!");
		int hours = endHour - startHour;
		double price = hours * playground.getPricePerHour();
		if (player.getEwallet() < price)
			return null;
		
		AvaliableHour avaliableHour = getAvaliableHour(playground.getAvaliableHours(), day, startHour, endHour);
		if (avaliableHour  == null) throw new IllegalArgumentException("There is no avaliable date in these time!");
		
		avaliableHour.setPlayer(player);
		avaliableHour.setAvaliable(false);
		player.withdraw(price);
		playground.getOwner().deposide(price);
		return playground;
	}
	/** 
	* this method to cancel the booking.
	* @param int playgroundId
	*/
	public boolean cancel(int playgroundId) {
		Playground playground = getPlayground(playgroundId);
		if (playground == null) throw new IllegalArgumentException("There is no playground with this id!");
		for (AvaliableHour avaliableHour : playground.getAvaliableHours()) {
			if (avaliableHour.getPlayer() == player) {
				avaliableHour.setAvaliable(true);
				int hours = avaliableHour.getEndHour() - avaliableHour.getStartHour();
				double price = hours * playground.getPricePerHour();
				player.deposit(price);
				playground.getOwner().withdraw(price);
				return true;
			}
		}
		return false;
	}
	/** 
	* this method to invite a player.
	* @param int playerID
	* @param int playgroundId
	*/
	public void invitePlayer(int playerId, int playgroundId) {
		Playground playground = getPlayground(playgroundId);
		if (playground == null) throw new IllegalArgumentException("There is no playground with this id!");
		AvaliableHour avaliableHour = null;
		for (AvaliableHour tempAvaliableHour : playground.getAvaliableHours()) {
			if (tempAvaliableHour.getPlayer().equals(player)) {
				avaliableHour = tempAvaliableHour;
			}
		}
		
		Invitation invitation = new Invitation(player, avaliableHour, playground);
		for (Player otherPlayer : otherPlayers) {
			if (otherPlayer.getId() == playerId) {
				otherPlayer.addInvitation(invitation);
			}
		}
	}
	/**
	  * this method to withdraw
	  * @param int amount 
	  */
	
	public boolean withdraw(int amount) {
		return player.withdraw(amount);
	}
	/**
	  * this method to deposit .
	  * @param int amount
	  */
	public void deposit(int amount) {
		player.deposit(amount);
	}
	
	/**
	  * this method for complains
	  * @param int id 
	  * @param String complainMessage 
	  */
	public void complain(int id, String complainMessage) {
		Playground playground = getPlayground(id);
		if (playground == null) throw new RuntimeException("There is no playground wih this id");
		playground.complain(player, complainMessage);
	}
}