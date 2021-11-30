import java.util.ArrayList;

/***
 * 
 * @author Yeonsil Choi
 *
 */
public class Selection {
	
	private String[] cryptoName;
	private Date[] dates;
	private Frequency freq;
	private AnalysisType analysisType;
	
	private static Selection instance = null;
	
	/***
	 * singleton
	 * @return
	 */
	public static Selection getInstance() {
		if (instance == null) {
			instance = Selection.getInstance();
		}
		return instance;
	}

	/***
	 * 
	 * @return 
	 */
	public Frequency getFreq() {
		return freq;		
	}
	
	
	public void setFreq(Frequency freq) {
		this.freq = freq;
	}
	

	/***
	 * 
	 * @return 
	 */
	public AnalysisType getAnalysisType() {
		return analysisType;
		
	}
	
	public void setAnalysisType (AnalysisType type) {
		this.analysisType = type;
	}
	
	/***
	 * 
	 * @return 
	 */
	public String[] getCrypto() {
		return cryptoName;
	}
	
	public void setCrypto(Cryptocurrency crypto) {

	}
	
	/***
	 * 
	 * @return 
	 */
	public Date[] getDate() {
		return dates;
	}
	
	/**
	 * 
	 * @param d
	 */
	public void setStartDate(Date d) {
		
	}
	
	
}
