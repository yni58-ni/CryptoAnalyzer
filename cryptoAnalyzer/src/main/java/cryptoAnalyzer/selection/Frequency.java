package cryptoAnalyzer.selection;
/***
 * 
 * @author Yeonsil Choi
 *
 */
public class Frequency {
	
	public String freq;
	
	/***
	 * 
	 * @param f
	 */
	public Frequency(String f) {
		freq = f;
		
	}
	
	/***
	 * 
	 * @return this.freq
	 */
	public String getInterval() {
		return this.freq;
	}
	
	/***
	 * 
	 * @param newFreq
	 */
	public void setFreq(String newFreq) {
		this.freq = newFreq;
	}
}
