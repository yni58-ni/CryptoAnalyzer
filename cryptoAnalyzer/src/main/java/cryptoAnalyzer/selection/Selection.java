package cryptoAnalyzer.selection;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.swing.JComboBox;
import javax.swing.JFrame;

import org.jdatepicker.impl.JDatePanelImpl;

import cryptoAnalyzer.selection.Dates;
import cryptoAnalyzer.gui.MainUINew;

/***
 * 
 * @author Yeonsil Choi; Nicole Ni; Grace Zhu
 *
 */
public class Selection {
	
	//private Cryptocurrency[] cryptos;
	private String[] cryptoName;
	private CryptoDate[] dates;
	private Frequency freq;
	private String analysisType;
<<<<<<< HEAD
	public Dates d;
	public Calendar select;
	
=======
	private Date startDate;
	private String[] unavailable= {"Wonderland", "ECOMI", "Marinade staked SOL", "LINK", 
			"NEXO", "Huobi Token", "Decred", "Osmosis", "TrueUSD","Frax"};
	//private Calendar calendar;
>>>>>>> branch 'master' of ssh://git@repo.csd.uwo.ca:7999/compsci2212_f2021/group11.git
	
	private static Selection instance = null;
	
	private Selection() {
		//perform instance initializations
	}
	
	/***
	 * singleton
	 * @return
	 */
	public static Selection getInstance() {
		if (instance == null) {
//<<<<<<< HEAD
//=======
			//if there is no previous instance, create one
//>>>>>>> branch 'master' of https://repo.csd.uwo.ca/scm/compsci2212_f2021/group11.git
			instance = new Selection();
		}
		return instance;
	}

	/***
	 * Getting method of geting frequency
	 * @return 
	 */
	public Frequency getFreq() {
		return freq;	
	}
	
<<<<<<< HEAD
	/***
	 * 
	 * @return cryptoName
	 */
	public String[] getNames() {
		return cryptoName;
	}
=======
	public void setFreq(Frequency f) {
		freq = f;
	}
	
>>>>>>> branch 'master' of ssh://git@repo.csd.uwo.ca:7999/compsci2212_f2021/group11.git

	/***
	 * Getting method of getting analysis type
	 * @return 
	 */
	public String getAnalysisType() {
		return analysisType;
		
	}
	
//<<<<<<< HEAD
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
try {
		if(checkAvailability(crypto.getName())) {
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
		}}
catch(IOException e) {
	JOptionPane.showMessageDialog(null, "Unavailable list is not found");
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
	/*
	private Boolean cryptoIsAvailable(Cryptocurrency c) {
		String name = c.getName();
		for(int i=0; i< unavailable.length; i++) {
			if(unavailable[i].equals(name)) {
				return false;
			}
		}
		return true;
	}*/
	
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
	

	
//=======
//>>>>>>> branch 'master' of https://repo.csd.uwo.ca/scm/compsci2212_f2021/group11.git
	/**
	 * Getting method of geting dates
	 * @param d
	 */
<<<<<<< HEAD
	public Dates[] getDates() {	
		//Dates d = new Dates(d.getDay(), d.getMonth(), d.getYear());
		
		System.out.println(d);
=======
/*
	public CryptoDate[] getDates() {	
>>>>>>> branch 'master' of ssh://git@repo.csd.uwo.ca:7999/compsci2212_f2021/group11.git
		//get selected date		
		
		//System.out.println(d.getDay());
		//System.out.println(d.getMonth());
		//System.out.println(d.getDay());
		select.getTime();
		select.set(d.getYear(), d.getMonth() + 1, d.getDay() + 1900);
		select.getTime();
		System.out.println(select.getTime());
		
		//selected date

		
		//get current date
		Calendar cur = Calendar.getInstance();
		
		//get the number of days between two dates
		long end = cur.getTimeInMillis();
		long start = select.getTimeInMillis();
		long days = TimeUnit.MILLISECONDS.toDays(Math.abs(end - start));
		
		//check if selected date is not a future date
		//if current > selected -> 1
		//if current < selected -> -1
		//dates = new Dates[(int) (days + 1)];
		//dates[0] = d;
		
		if (cur.compareTo(select) > 0) {
			if (freq.getFreq() == "Daily") {
				dates = new CryptoDate[(int) (days + 1)];
				for (int i = 0; i < days; i++) {
<<<<<<< HEAD
					select.add(Calendar.DATE, i);
					d = new Dates(select.getTime().getDate(), select.getTime().getMonth(), select.getTime().getYear());
=======
					selected.add(Calendar.DATE, i);
					d = new CryptoDate(selected.getTime().getDate(), selected.getTime().getMonth(), selected.getTime().getYear());
>>>>>>> branch 'master' of ssh://git@repo.csd.uwo.ca:7999/compsci2212_f2021/group11.git
					dates[i] = d;
				}
				//return dates;
			}else if (freq.getFreq() == "Weekly") {
				int index = (int) (days / 7);
				dates = new CryptoDate[index + 1];
				if (index == 0) {
<<<<<<< HEAD
					d = new Dates(select.getTime().getDate(), select.getTime().getMonth(), select.getTime().getYear());
=======
					d = new CryptoDate(selected.getTime().getDate(), selected.getTime().getMonth(), selected.getTime().getYear());
>>>>>>> branch 'master' of ssh://git@repo.csd.uwo.ca:7999/compsci2212_f2021/group11.git
					dates[0] = d;
					//return dates;
 				} else if (index > 0) {
 					//int n = 0;
					for (int i = 0; i < index + 1; i++) {
<<<<<<< HEAD
						select.add(Calendar.WEEK_OF_MONTH, i);
						d = new Dates(select.getTime().getDate(), select.getTime().getMonth(), select.getTime().getYear());
=======
						selected.add(Calendar.WEEK_OF_MONTH, i);
						d = new CryptoDate(selected.getTime().getDate(), selected.getTime().getMonth(), selected.getTime().getYear());
>>>>>>> branch 'master' of ssh://git@repo.csd.uwo.ca:7999/compsci2212_f2021/group11.git
						dates[i] = d;
						//n += 7;
					}
					//return dates;
 				}
				
			}else if (freq.getFreq() == "Monthly") {
				int index = (int) (days / 30);
				dates = new CryptoDate[index + 1];
				if (index == 0) {
<<<<<<< HEAD
					d = new Dates(select.getTime().getDate(), select.getTime().getMonth(), select.getTime().getYear());
=======
					d = new CryptoDate(selected.getTime().getDate(), selected.getTime().getMonth(), selected.getTime().getYear());
>>>>>>> branch 'master' of ssh://git@repo.csd.uwo.ca:7999/compsci2212_f2021/group11.git
					dates[0] = d;
					//return dates;
				} else if (index > 0) {
 					//int n = 0;
					for (int i = 0; i < index + 1; i++) {
<<<<<<< HEAD
						select.add(Calendar.MONTH, i);
						d = new Dates(select.getTime().getDate(), select.getTime().getMonth(), select.getTime().getYear());
=======
						selected.add(Calendar.MONTH, i);
						d = new CryptoDate(selected.getTime().getDate(), selected.getTime().getMonth(), selected.getTime().getYear());
>>>>>>> branch 'master' of ssh://git@repo.csd.uwo.ca:7999/compsci2212_f2021/group11.git
						dates[i] = d;
						//n += 7;
					}
					//return dates;				
				}
			}else if (freq.getFreq() == "Yearly") {
				int index = (int) (days / 365);
				dates = new CryptoDate[index + 1];
				if (index == 0) {
<<<<<<< HEAD
					d = new Dates(select.getTime().getDate(), select.getTime().getMonth(), select.getTime().getYear());
=======
					d = new CryptoDate(selected.getTime().getDate(), selected.getTime().getMonth(), selected.getTime().getYear());
>>>>>>> branch 'master' of ssh://git@repo.csd.uwo.ca:7999/compsci2212_f2021/group11.git
					dates[0] = d;
					//return dates;
				} else if (index > 0) {
					for (int i = 0; i < index + 1; i++) {
<<<<<<< HEAD
						select.add(Calendar.YEAR, i);
						d = new Dates(select.getTime().getDate(), select.getTime().getMonth(), select.getTime().getYear());
=======
						selected.add(Calendar.YEAR, i);
						d = new CryptoDate(selected.getTime().getDate(), selected.getTime().getMonth(), selected.getTime().getYear());
>>>>>>> branch 'master' of ssh://git@repo.csd.uwo.ca:7999/compsci2212_f2021/group11.git
						dates[i] = d;
						//n += 7;
					}
					//return dates;
				}
				
			}
		} else if (cur.compareTo(select) < 0){
			return null;
		}
		return dates;
	}
	*/
	
	/**
	 * This is a class that checks if the selected crypto is allowed to be fetched
	 */
	public boolean checkAvailability(String c) throws FileNotFoundException {
		BufferedReader inFile = new BufferedReader(new FileReader("notavailablecrypto.txt"));
		try {
			StringBuilder sb = new StringBuilder();
			String line = inFile.readLine();
			while(line != null) { // while the end of the file hasn't been reached
				if (line.equals(c)) {
					return false; // the selected crypto is not allowed to be fetched
				}
				line = inFile.readLine();
			}
			inFile.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return true;
		
	}
	
	
	
}
