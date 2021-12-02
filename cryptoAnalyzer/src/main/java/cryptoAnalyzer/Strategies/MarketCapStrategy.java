package cryptoAnalyzer.Strategies;

import cryptoAnalyzer.demoClasses.Date;
import cryptoAnalyzer.demoClasses.Selection;
import cryptoAnalyzer.utils.DataFetcher;

/**
 * This class represent calculation for market capitalization
 * @author gracezhu
 *
 */

public class MarketCapStrategy extends Strategy{

	/**
	 * perform calculation for market capitalization
	 * @param sel user selection
	 * @return result
	 */
	protected Result perform(Selection sel) {

		//initialization
		DataFetcher dFetcher = new DataFetcher();
		
		int numRow = sel.getNames().length;
		int numCol = sel.getDates().length;
		String[] cryptoList = sel.getNames();
		Date[] dateList = sel.getDates();
		
		Result res = new Result(numRow,numCol);

		//calculation
		for(int i=0; i<res.getRow(); i++) {
			for(int j=0; j<res.getCol(); j++) {
				if(i==0) {
					if(j!=0) {
						res.setDate(dateList[j-1], j); //first row is list of dates
					}
				}else {
					if(j==0) {
						res.setCryptoName(cryptoList[i-1], i); //first column is list of crypto
					}else {
						String cName = ((String) res.getResult()[i][0]).toLowerCase();
						String cDate = ((Date) res.getResult()[0][j]).printInt();
						double value = dFetcher.getMarketCapForCoin(cName, cDate);
						res.setValues(value, i, j); //add value to result
					}
				}
			}	
		}
		return res;		
	}
}
