package go_football.entity;
/** 
* AvaliableHour class to manage the avaliableHour for owner. 
*/

public class AvaliableHour {
	/** 
	 * AvaliableHour's day
	 */
	private String day;
	/** 
	 * AvaliableHour's startHour
	 */
	private int startHour;
	/** 
	 * AvaliableHour's endHour
	 */
	private int endHour;
	/** 
	 * checking
	 */
	private boolean isAvaliable;
	/** 
	 * Attribute for player.
	 */
	private Player player;
	 /** 
	* user Constructor.
	*/
	public AvaliableHour() {
		isAvaliable = true;
	}
	/** 
	* this method returns a day .
	* @return String day
	*/
	public String getDay() {
		return day;
	}
	/** 
	* this method sets new AvaliableHour day.
	* @param String day
	*/
	public void setDay(String day) {
		this.day = day;
	}
	/** 
	* this method returns User name.
	* @return int startHour 
	*/
	public int getStartHour() {
		return startHour;
	}
	/** 
	* this method sets new AvaliableHour startHour.
	* @param int startHour
	*/
	public void setStartHour(int startHour) {
		if (startHour < 0 || startHour > 23) throw new IllegalArgumentException();
		this.startHour = startHour;
	}
	/** 
	* this method returns AvaliableHour endHour.
	* @return int endHour
	*/
	
	public int getEndHour() {
		return endHour;
	}
	/** 
	* this method sets new AvaliableHour endHour.
	* @param int endHour
	*/
	
	public void setEndHour(int endHour) {
		if (endHour < 0 || endHour > 23) throw new IllegalArgumentException();
		this.endHour = endHour;
	}
	/** 
	* this method is used to check the availability.
	* @return boolean isAvaliable 
	*/

	public boolean isAvaliable() {
		return isAvaliable;
	}
	/** 
	* this method sets new .
	* @param boolean isAvaliable
	*/

	public void setAvaliable(boolean isAvaliable) {
		this.isAvaliable = isAvaliable;
	}
	/** 
	* this method returns player.
	* @return player
	*/

	public Player getPlayer() {
		return player;
	}
	/** 
	* this method sets new player.
	* @param Player player
	*/

	public void setPlayer(Player player) {
		this.player = player;
	}
	/** 
	* override toString method for User Class
	* @return String
	*/
	@Override
	public String toString() {
		return "AvaliableHour [day=" + day + ", startHour=" + startHour + ", endHour=" + endHour + ", isAvaliable="
				+ isAvaliable + "]";
	}	
}
