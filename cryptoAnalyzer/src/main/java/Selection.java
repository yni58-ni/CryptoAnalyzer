

/***
 * 
 * @author Yeonsil Choi
 *
 */
public class Selection {
	
	private Cryptocurrency cryptoName;
	private Date dates;
	private Frequency freq;
	private AnalysisType analysisType;
	private static Selection instance = null;
	
	/***
	 * singleton
	 * @return
	 */
	public static Selection getInstance() {
		if (instance == null) {
			instance = new Selection();
		}
		return instance;
	}
	
	private Selection() {
	}

	public Frequency getFreq() {
		return freq;		
	}

	public void getCrypto() {
		
	}

	public AnalysisType getAnalysisType() {
		return analysisType;
		
	}

	public void getDates() {
		if (this.freq.getFreq() == "Daily") {
			
		}
		
	}
	


	

}
