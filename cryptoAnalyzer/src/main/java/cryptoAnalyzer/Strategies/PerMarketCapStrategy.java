package cryptoAnalyzer.Strategies;

import cryptoAnalyzer.demoClasses.Date;
import cryptoAnalyzer.demoClasses.Selection;
import cryptoAnalyzer.utils.DataFetcher;


/**
 * This class represent calculation for percentage change of market capitalization
 * @author gracezhu
 *
 */
public class PerMarketCapStrategy extends Strategy{

	/**
	 * perform calculation for percentage change of market capitalization
	 * @param sel selection
	 * @return result
	 */
	protected Result perform(Selection sel) {

		//initialization
		DataFetcher dFetcher = new DataFetcher();
		
		int numRow = sel.getNames().length;
		int numCol = sel.getDates().length-1;
		String[] cryptoList = sel.getNames();
		Date[] dateList = sel.getDates();
		
		Result res = new Result(numRow,numCol);

		//calculation
		for(int i=0; i<res.getRow(); i++) {

			for(int j=0; j<res.getCol(); j++) {
				if(i==0) {
					if(j!=0) {
						res.setDate(dateList[j], j); //first row is list of dates
					}
				}else {
					if(j==0) {
						res.setCryptoName(cryptoList[i-1], i); //first column if list of crypto
					}else {
						String cName = ((String) res.getResult()[i][0]).toLowerCase(); //name of crypto
						String prevDate = dateList[j-1].printInt(); //previous date
						String curDate = ((Date) res.getResult()[0][j]).printInt(); //current date
						
						double prevValue = dFetcher.getMarketCapForCoin(cName, prevDate);
						double curValue = dFetcher.getMarketCapForCoin(cName, curDate);
						double value = (curValue-prevValue)/prevValue *100;
						
						value = Math.round(value*100);
						res.setValues(value/100, i, j);
					}
				}
			}	
		}
		
		return res;	
	}
}
