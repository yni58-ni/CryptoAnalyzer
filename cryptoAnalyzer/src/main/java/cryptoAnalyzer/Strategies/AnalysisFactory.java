package cryptoAnalyzer.Strategies;

/**
 * This is a class for analysis factory
 * @author gracezhu
 *
 */
public class AnalysisFactory {

	/**
	 * create strategy based on analysis type
	 * @param analysis analysis type
	 * @return corresponding strategy
	 */
	public Strategy create(String analysis) {
		if(analysis.equals("price")) {
			return new PriceStrategy();
		
		}else if(analysis.equals("marCap")) {
			return new MarketCapStrategy();
		
		}else if(analysis.equals("volume")) {
			return new VolumeStrategy();
		
		}else if(analysis.equals("CIC")) {
			return new CICStrategy();
		
		}else if(analysis.equals("perPrice")) {
			return new PerPriceStrategy();
		
		}else if(analysis.equals("perMarCap")) {
			return new PerMarketCapStrategy();
		
		}else if(analysis.equals("perVol")) {
			return new PerVolumeStrategy();
		
		}else if(analysis.equals("perCIC")) {
			return new PerCICStrategy();
		}else {
			return null;
		}
	}
	
}
