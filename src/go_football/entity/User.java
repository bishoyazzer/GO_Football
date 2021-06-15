package go_football.entity;

public class User {
	private static int idCounter = 0;
	/** 
	 * user's id
	 */
	private int id;
	/** 
	 * users's name
	 */
	private String name;
	/** 
	 * user's password
	 */
	private String password;
	/** 
	 *user's email
	 */
	private String email;
	/** 
	 * user's phone
	 */
	private String phone;
	/** 
	 * user's location
	 */
	private String location;
	 /** 
		* user Constructor.
		* @param String name
		* @param String password 
		* @param String String email
		* @param String phone
		* @param String location
		*/
	public User(String name, String password, String email, String phone, String location) {
		this.id = idCounter;
		idCounter += 1;
		this.name = name;
		this.password = password;
		this.email = email;
		this.phone = phone;
		this.location = location;
	}
	/** 
	* this method returns the User id.
	* @return String
	*/

	public int getId() {
		return id;
	}
	/** 
	* this method sets new User id.
	* @param String name
	*/

	public void setId(int id) {
		this.id = id;
	}
	/** 
	* this method returns User name.
	* @return String
	*/

	public String getName() {
		return name;
	}
	/** 
	* this method sets new User name.
	* @param String name
	*/
	public void setName(String name) {
		this.name = name;
	}
	/** 
	* this method returns the User password.
	* @return String
	*/

	public String getPassword() {
		return password;
	}
	/** 
	* this method sets new User password.
	* @param String name
	*/

	public void setPassword(String password) {
		this.password = password;
	}
	/** 
	* this method returns the User email.
	* @return String
	*/

	public String getEmail() {
		return email;
	}
	/** 
	* this method sets new User email.
	* @param String name
	*/
	public void setEmail(String email) {
		this.email = email;
	}
	/** 
	* this method returns the User phone.
	* @return String
	*/

	public String getPhone() {
		return phone;
	}
	/** 
	* this method sets new User phone.
	* @param String phone
	*/
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/** 
	* this method returns the User location.
	* @return String
	*/

	public String getLocation() {
		return location;
	}
	/** 
	* this method sets new user location.
	* @param String location
	*/
	public void setLocation(String location) {
		this.location = location;
	}
	/** 
	* override toString method for User Class
	* @return String
	*/
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password + ", email=" + email + ", phone=" + phone
				+ ", location=" + location + "]";
	}

}
