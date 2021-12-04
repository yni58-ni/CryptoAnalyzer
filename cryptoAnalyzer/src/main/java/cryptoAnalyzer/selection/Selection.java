package cryptoAnalyzer.selection;

import java.util.Calendar;
import java.util.Date;

import javax.swing.JOptionPane;
/***
 * 
 * @author Yeonsil Choi
 *
 */
public class Selection {
	
	//private Cryptocurrency[] cryptos;
	private String[] cryptoName;
	private CryptoDate[] dates;
	private Frequency freq;
	private String analysisType;
	private Date startDate;
	private String[] unavailable= {"Wonderland", "ECOMI", "Marinade staked SOL", "LINK", 
			"NEXO", "Huobi Token", "Decred", "Osmosis", "TrueUSD","Frax"};
	//private Calendar calendar;
	
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

	/***
	 * 
	 * @return 
	 */
	public Frequency getFreq() {
		return freq;	
	}
	
	public void setFreq(Frequency f) {
		freq = f;
	}
	

	/***
	 * 
	 * @return 
	 */
	public String getAnalysisType() {
		return analysisType;
		
	}
	
	public void setAnalysisType(String at) {
		analysisType = at;
	}
	

	/***
	 * 
	 * @return 
	 */
	public String[] getNames() {
		//String n = String.valueOf(cryptoList.getSelectedItem());
		//MainUINew ui = new MainUINew();
		/*
		String[] arr = {"Bitcoin", "Solana"};
		
		return arr;*/
		return cryptoName;
	}
	
	public void addCrypto(Cryptocurrency crypto) {

		if(cryptoIsAvailable(crypto)) {
			String name = crypto.getName();
			if(cryptoName==null) {
				cryptoName = new String[]{crypto.getName()};
			}else {
				String[] newArr = new String[cryptoName.length+1];
				Boolean duplicate = false;
				
				for(int i=0; i<cryptoName.length; i++) {
					if(cryptoName[i].equals(name)) {
						duplicate = true;
					}else {
						newArr[i] = cryptoName[i];
					}
				}
				if(duplicate) {
					//do nothing
				}else {
					newArr[cryptoName.length] = name;
					cryptoName = newArr;
				}
			}
		}else {
			JOptionPane.showMessageDialog(null, "Cryptocurrency is not available");
		}
		
	}
	
	public void removeCrypto(Cryptocurrency crypto) {
		
		String name = crypto.getName();
		if(cryptoName==null) {
			//do nothing
		}else {
			//String[] newArr = new String[cryptoName.length];
			Boolean notInList = true;
			for(int i=0; i<cryptoName.length; i++) {
				if(cryptoName[i].equals(name)) {
					notInList = false;
					cryptoName[i]=null;
					//newArr[curr] = cryptoName[i+1];
				}
			}
			if(notInList) {
				//do nothing
			}else {
				if(cryptoName.length==1) {
					cryptoName = null;
				}else {
					String[] newArr = new String[cryptoName.length-1];
					int newIndex = 0;
					for(int i=0; i<cryptoName.length; i++) {
						if(cryptoName[i]!=null) {
							
							newArr[newIndex]=cryptoName[i];
							newIndex++;
							//newArr[curr] = cryptoName[i+1];
						}
					}
					cryptoName = newArr;
				}
			}
		}
	}
	
	public void setStartDate(Date d) {
		//CryptoDate = new CryptoDate(d.getDay(), d.getMonth(), d.getYear());
		//calendar.setTime(d);
		Date curDate = Calendar.getInstance().getTime();
		
		if(d.after(curDate)) {
			JOptionPane.showMessageDialog(null, "Select date before current date");
		}else {
			startDate = d;
		}
	}
	
	
	public CryptoDate[] getDateList() {
		Date curDate = Calendar.getInstance().getTime();
		calculateDate(startDate, curDate);
		return dates;
	}
	
	private void calculateDate(Date sDate, Date curDate) {
		Calendar start = Calendar.getInstance();
		start.setTime(sDate);
		System.out.println(start);
		while(!(start.getTime()).after(curDate)) {
			CryptoDate cd = new CryptoDate(start.get(Calendar.DATE), start.get(Calendar.MONTH)+1, start.get(Calendar.YEAR));
			addDate(cd);
			
			if(freq.getFreq().equals("Daily")) {
				start.add(Calendar.DATE, 1);
			}else if(freq.getFreq().equals("Weekly")) {
				start.add(Calendar.DATE, 7);
			}else if(freq.getFreq().equals("Monthly")) {
				start.add(Calendar.MONTH, 1);
			}else {
				start.add(Calendar.YEAR, 1);
			}
			
		}
		
	}
	
	private void addDate(CryptoDate cd) {

		if(dates==null) {
			dates = new CryptoDate[] {cd};
		}else {
			CryptoDate[] newArr = new CryptoDate[dates.length+1];
			
			for(int i=0; i<dates.length; i++) {
				newArr[i] = dates[i];
			}
			newArr[dates.length] = cd;
			dates = newArr;
		}
	}
	
	private Boolean cryptoIsAvailable(Cryptocurrency c) {
		String name = c.getName();
		for(int i=0; i< unavailable.length; i++) {
			if(unavailable[i].equals(name)) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		Cryptocurrency c = new Cryptocurrency("Bitcoin");
		Cryptocurrency c1 = new Cryptocurrency("Dodge");
		Cryptocurrency c2 = new Cryptocurrency("Solana");
		Cryptocurrency c3 = new Cryptocurrency("Ethereum");
		Selection sel = Selection.getInstance();
		//sel.addCrypto(c);
		//sel.addCrypto(c1);
		//sel.addCrypto(c2);
		//sel.addCrypto(c3);
		sel.removeCrypto(c);
		
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE,-3);
		Date dt= cal.getTime();
		sel.setStartDate(dt);
		sel.setFreq(new Frequency("Daily"));;
		sel.getDateList();
		
	}

	
	/**
	 * 
	 * @param d
	 */
/*
	public CryptoDate[] getDates() {	
		//get selected date		
		Calendar selected = Calendar.getInstance();
		selected.getTime();
		System.out.println(selected.getTime());
		
		//selected date

		
		//get current date
		Calendar cur = Calendar.getInstance();
		
		//get the number of days between two dates
		long end = cur.getTimeInMillis();
		long start = selected.getTimeInMillis();
		long days = TimeUnit.MILLISECONDS.toDays(Math.abs(end - start));
		
		//check if selected date is not a future date
		//if current > selected -> 1
		//if current < selected -> -1
		//dates = new Dates[(int) (days + 1)];
		//dates[0] = d;
		
		if (cur.compareTo(selected) > 0) {
			if (freq.getFreq() == "Daily") {
				dates = new CryptoDate[(int) (days + 1)];
				for (int i = 0; i < days; i++) {
					selected.add(Calendar.DATE, i);
					d = new CryptoDate(selected.getTime().getDate(), selected.getTime().getMonth(), selected.getTime().getYear());
					dates[i] = d;
				}
				//return dates;
			}else if (freq.getFreq() == "Weekly") {
				int index = (int) (days / 7);
				dates = new CryptoDate[index + 1];
				if (index == 0) {
					d = new CryptoDate(selected.getTime().getDate(), selected.getTime().getMonth(), selected.getTime().getYear());
					dates[0] = d;
					//return dates;
 				} else if (index > 0) {
 					//int n = 0;
					for (int i = 0; i < index + 1; i++) {
						selected.add(Calendar.WEEK_OF_MONTH, i);
						d = new CryptoDate(selected.getTime().getDate(), selected.getTime().getMonth(), selected.getTime().getYear());
						dates[i] = d;
						//n += 7;
					}
					//return dates;
 				}
				
			}else if (freq.getFreq() == "Monthly") {
				int index = (int) (days / 30);
				dates = new CryptoDate[index + 1];
				if (index == 0) {
					d = new CryptoDate(selected.getTime().getDate(), selected.getTime().getMonth(), selected.getTime().getYear());
					dates[0] = d;
					//return dates;
				} else if (index > 0) {
 					//int n = 0;
					for (int i = 0; i < index + 1; i++) {
						selected.add(Calendar.MONTH, i);
						d = new CryptoDate(selected.getTime().getDate(), selected.getTime().getMonth(), selected.getTime().getYear());
						dates[i] = d;
						//n += 7;
					}
					//return dates;				
				}
			}else if (freq.getFreq() == "Yearly") {
				int index = (int) (days / 365);
				dates = new CryptoDate[index + 1];
				if (index == 0) {
					d = new CryptoDate(selected.getTime().getDate(), selected.getTime().getMonth(), selected.getTime().getYear());
					dates[0] = d;
					//return dates;
				} else if (index > 0) {
					for (int i = 0; i < index + 1; i++) {
						selected.add(Calendar.YEAR, i);
						d = new CryptoDate(selected.getTime().getDate(), selected.getTime().getMonth(), selected.getTime().getYear());
						dates[i] = d;
						//n += 7;
					}
					//return dates;
				}
				
			}
		} else if (cur.compareTo(selected) < 0){
			return null;
		}
		return dates;


	}
	
	*/
	
}
