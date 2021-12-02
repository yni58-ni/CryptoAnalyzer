/***
 * 
 * @author Yeonsil Choi
 *
 */
public class Cryptocurrency {
	
	private String name;
	
	/***
	 * 
	 * @param n
	 */
	public Cryptocurrency(String n) {
		this.name = n;
	}
	
	/***
	 * 
	 * @return this.name
	 */
	public String getName() {
		return this.name;		
	}
	
	/***
	 * 
	 * @param newName
	 */
	public void setName(String newName) {
		this.name = newName;
	}

}
