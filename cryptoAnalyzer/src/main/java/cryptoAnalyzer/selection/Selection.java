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
 * @author Yeonsil Choi; Nicole Ni
 *
 */
public class Selection {
	
	private Cryptocurrency c;
	private String[] cryptoName;
	private Dates[] dates;
	private Frequency freq;
	private String analysisType;
	public Dates d;
	public Calendar select;
	
	
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
			//if there is no previous instance, create one
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
	

	/***
	 * Getting method of getting analysis type
	 * @return 
	 */
	public String getAnalysisType() {
		return analysisType;
		
	}
	
	/**
	 * Getting method of geting dates
	 * @param d
	 */
	public Dates[] getDates() {	
		//Dates d = new Dates(d.getDay(), d.getMonth(), d.getYear());
		
		System.out.println(d);
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
				dates = new Dates[(int) (days + 1)];
				for (int i = 0; i < days; i++) {
					select.add(Calendar.DATE, i);
					d = new Dates(select.getTime().getDate(), select.getTime().getMonth(), select.getTime().getYear());
					dates[i] = d;
				}
				//return dates;
			}else if (freq.getFreq() == "Weekly") {
				int index = (int) (days / 7);
				dates = new Dates[index + 1];
				if (index == 0) {
					d = new Dates(select.getTime().getDate(), select.getTime().getMonth(), select.getTime().getYear());
					dates[0] = d;
					//return dates;
 				} else if (index > 0) {
 					//int n = 0;
					for (int i = 0; i < index + 1; i++) {
						select.add(Calendar.WEEK_OF_MONTH, i);
						d = new Dates(select.getTime().getDate(), select.getTime().getMonth(), select.getTime().getYear());
						dates[i] = d;
						//n += 7;
					}
					//return dates;
 				}
				
			}else if (freq.getFreq() == "Monthly") {
				int index = (int) (days / 30);
				dates = new Dates[index + 1];
				if (index == 0) {
					d = new Dates(select.getTime().getDate(), select.getTime().getMonth(), select.getTime().getYear());
					dates[0] = d;
					//return dates;
				} else if (index > 0) {
 					//int n = 0;
					for (int i = 0; i < index + 1; i++) {
						select.add(Calendar.MONTH, i);
						d = new Dates(select.getTime().getDate(), select.getTime().getMonth(), select.getTime().getYear());
						dates[i] = d;
						//n += 7;
					}
					//return dates;				
				}
			}else if (freq.getFreq() == "Yearly") {
				int index = (int) (days / 365);
				dates = new Dates[index + 1];
				if (index == 0) {
					d = new Dates(select.getTime().getDate(), select.getTime().getMonth(), select.getTime().getYear());
					dates[0] = d;
					//return dates;
				} else if (index > 0) {
					for (int i = 0; i < index + 1; i++) {
						select.add(Calendar.YEAR, i);
						d = new Dates(select.getTime().getDate(), select.getTime().getMonth(), select.getTime().getYear());
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
