package go_football.entity;

import java.util.ArrayList;
import java.util.List;
/** 
* player class to manage a player. 
*/

public class Player extends User{
	/** 
	 * Wallet of this Player
	 */
	private double ewallet;
	/** 
	 * invitations of this Player
	 */
	private List<Invitation> invitations;
	
	 /** 
	* Player Constructor.
	* @param String name
	* @param String password 
	* @param String String email
	* @param String phone
	* @param String location
	*/
	public Player(String name, String password, String email, String phone, String location) {
		super(name, password, email, phone, location);
		this.ewallet = 0;
		invitations = new ArrayList<>();
	}

	/** 
	* this method returns the wallet for this PLayer.
	* @return double
	*/
	public double getEwallet() {
		return ewallet;
	}
	/** 
	* this method make withdraw for this Player.
	* @param double amount 
	*/
	public boolean withdraw(double amount) {
		if (amount < 0) throw new IllegalArgumentException();
		if (ewallet - amount < 0) {
			System.out.println("you have no enough money");
			return false;
				
		}
		ewallet -= amount;
		return true;
	}	
	
	/** 
	* this method make deposit for this Player.
	* @param double amount 
	*/
	public void deposit(double amount) {
		if (amount < 0) throw new IllegalArgumentException();
		ewallet += amount;
	}
	/** 
	* this method to show invitation for this PLayer.
	* @return Invitation
	*/
	
	public Invitation showLastInvitation() {
		return invitations.get(invitations.size()-1);
	}
	/** 
	* this method returns the invitation of this PLayer.
	* @return Invitation
	*/
	public List<Invitation> getInvitations() {
		return invitations;
	}
	/** 
	* this method to add invitation for PLayer.
	* @param Invitation invitation
	*/
	public void addInvitation(Invitation invitation) {
		invitations.add(invitation);
	}
}