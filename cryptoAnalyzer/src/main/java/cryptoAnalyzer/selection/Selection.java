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

import cryptoAnalyzer.selection.*;
import cryptoAnalyzer.gui.MainUINew;

/***
 * 
 * @author Yeonsil Choi
 *
 */
public class Selection {
	
	private Cryptocurrency c;
	private String[] cryptoName;
	private Dates[] dates;
	private static Frequency freq = new Frequency();
	private String analysisType;
	private JComboBox<String> cryptoList;
	private static Dates d = new Dates();
	
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
	

	/***
	 * 
	 * @return 
	 */
	public String getAnalysisType() {
		return analysisType;
		
	}
	

	/***
	 * 
	 * @return 
	 */
	public String[] getNames() {
		//String n = String.valueOf(cryptoList.getSelectedItem());
		//MainUINew ui = new MainUINew();
		String[] arr = {"Bitcoin", "Solana"};
		
		return arr;
	}
	
	public void addCrypto(Cryptocurrency crypto) {

	}
	
	public void removeCrypto(Cryptocurrency crypto) {
		
	}
	
	
	/**
	 * 
	 * @param d
	 */
	public Dates[] getDates() {
		
		//get selected date
		int selectedD, selectedM, selectedY;
		selectedD = d.getDay();
		selectedM = d.getMonth();
		selectedY = d.getYear();
		
		//save them
		Calendar selected = Calendar.getInstance();
		selected.set(selectedY, selectedM, selectedD);
		
		
		//current 
		Calendar cal = Calendar.getInstance();
		
		//get the number of days between two dates
		long end = cal.getTimeInMillis();
		long start = selected.getTimeInMillis();
		long days = TimeUnit.MILLISECONDS.toDays(Math.abs(end - start));
		//System.out.println(days);
		
		//System.out.println(selected.getTime());
		//System.out.println(cal.getTime());
		
		
		//System.out.println(freq.getFreq());
		String selectedFreq = freq.getFreq();
		
		
		
		/***
		 * dec 5 2021 - select
		 * dec 7 2021 - current
		 * arr0 = 1205 arr1 = 1206 arr2 = 1207
		 */
		
		//if cureent > selected -> 1
		//if currentdate < selected -> -1
		System.out.print(cal.compareTo(selected));
		
		if(cal.compareTo(selected) > 0) {
			if (selectedFreq == "Daily") {
				dates = new Dates[(int) (days+1)];
				for (int i = 0; i < days; i++) {
					selected.add(selected.DATE, i);
					//datearr[i] = Dates(selected.getDay);
				}
				
			} else if (selectedFreq == "Weekly") {
				
			} else if (selectedFreq == "Monthly") {
				
			} else if (selectedFreq == "Yearly") {
				
			}
		} else {
			return null;
		}
		//if (selectedY > mYear) {
		return dates;
			
		//}
		
		
		//d.getDay();
		
		//System.out.println(d.getMonth());
		//System.out.println(d.getDay());
		//System.out.println(d.getYear());
		
		
		//System.out.println(d.getDay());
		//mYear = cal.get(Calendar.YEAR);
		//System.out.println(mYear);
		//mMonth = cal.get(Calendar.MONTH);
		//january = 0
		//System.out.println(mMonth + 1);
		//mDay = cal.get(Calendar.DATE);
		//mDay1 = cal.get(Calendar.DAY_OF_MONTH);
		//System.out.println(mDay);
		//System.out.println(mDay1);
		

		
				
	}
	

	
	
	
	private Boolean checkAvailability(Cryptocurrency c) throws FileNotFoundException {
		BufferedReader inFile = new BufferedReader(new FileReader("notavailablecrypto.txt"));
		boolean flag;
		try {
			StringBuilder sb = new StringBuilder();
			String line = inFile.readLine();
			while(line != null) {
				if (line.equals(c.getName())) {
					
				}
			}
			
			inFile.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
		
		
	}
	
	public static void main(String[] args) {
		//Cryptocurrency c = new Cryptocurrency();
		//checkAvailability(c.getName());
	}
	
	
	
	
}
