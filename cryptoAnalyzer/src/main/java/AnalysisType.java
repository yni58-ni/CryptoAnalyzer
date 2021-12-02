/***
 * 
 * @author Yeonsil Choi
 *
 */
public class AnalysisType {
	
	private String type;
	
	/***
	 * 
	 * @param t
	 */
	public AnalysisType (String t) {
		this.type = t;
	}
	
	/***
	 * 
	 * @return this.type;
	 */
	public String getType() {
		return this.type;
		
	}
	
	/****
	 * 
	 * @param newType
	 */
	public void setType(String newType) {
		this.type = newType;
	}

}
