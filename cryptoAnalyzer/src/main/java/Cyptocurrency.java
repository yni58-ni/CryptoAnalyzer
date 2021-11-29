/***
 * 
 * @author Yeonsil Choi
 *
 */
public class Cyptocurrency {
	
	private String name;
	
	/***
	 * constructor
	 * 
	 */
	public Cyptocurrency(String n) {
		this.name = n;
	}
	
	public String getName() {
		return this.name;		
	}
	
	public void setType(String newName) {
		this.name = newName;
	}

}
