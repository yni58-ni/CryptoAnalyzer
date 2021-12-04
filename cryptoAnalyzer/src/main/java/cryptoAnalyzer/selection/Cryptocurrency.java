package cryptoAnalyzer.selection;

import javax.swing.JComboBox;

/***
 * 
 * @author Yeonsil Choi
 *
 */
public class Cryptocurrency {
	
	private JComboBox<String> cryptoList;
	
	private String name;
	
	/***
	 * 
	 * @param n
	 */
	public Cryptocurrency(String n) {
		//n = cryptoList.getSelectedItem().toString();
		//n = String.valueOf(cryptoList.getSelectedItem());
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
		//newName = cryptoList.getSelectedItem().toString();
		this.name = newName;
	}
	
	public Boolean isEqual(Cryptocurrency c) {
		if(this.getName().equals(c.getName())) {
			return true;
		}else {
			return false;
		}
	}

}
