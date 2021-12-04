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
 * @author Yeonsil Choi
 *
 */
public class Selection {
	
	private Cryptocurrency c;
	private String[] cryptoName;
	private Dates[] dates;
	private Frequency freq;
	private String analysisType;
	private Dates d;
	
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
		Calendar selected = Calendar.getInstance();
		selected.set(d.getYear(), d.getMonth(), d.getDay());
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
				dates = new Dates[(int) (days + 1)];
				for (int i = 0; i < days; i++) {
					selected.add(Calendar.DATE, i);
					d = new Dates(selected.getTime().getDate(), selected.getTime().getMonth(), selected.getTime().getYear());
					dates[i] = d;
				}
				//return dates;
			}else if (freq.getFreq() == "Weekly") {
				int index = (int) (days / 7);
				dates = new Dates[index + 1];
				if (index == 0) {
					d = new Dates(selected.getTime().getDate(), selected.getTime().getMonth(), selected.getTime().getYear());
					dates[0] = d;
					//return dates;
 				} else if (index > 0) {
 					//int n = 0;
					for (int i = 0; i < index + 1; i++) {
						selected.add(Calendar.WEEK_OF_MONTH, i);
						d = new Dates(selected.getTime().getDate(), selected.getTime().getMonth(), selected.getTime().getYear());
						dates[i] = d;
						//n += 7;
					}
					//return dates;
 				}
				
			}else if (freq.getFreq() == "Monthly") {
				int index = (int) (days / 30);
				dates = new Dates[index + 1];
				if (index == 0) {
					d = new Dates(selected.getTime().getDate(), selected.getTime().getMonth(), selected.getTime().getYear());
					dates[0] = d;
					//return dates;
				} else if (index > 0) {
 					//int n = 0;
					for (int i = 0; i < index + 1; i++) {
						selected.add(Calendar.MONTH, i);
						d = new Dates(selected.getTime().getDate(), selected.getTime().getMonth(), selected.getTime().getYear());
						dates[i] = d;
						//n += 7;
					}
					//return dates;				
				}
			}else if (freq.getFreq() == "Yearly") {
				int index = (int) (days / 365);
				dates = new Dates[index + 1];
				if (index == 0) {
					d = new Dates(selected.getTime().getDate(), selected.getTime().getMonth(), selected.getTime().getYear());
					dates[0] = d;
					//return dates;
				} else if (index > 0) {
					for (int i = 0; i < index + 1; i++) {
						selected.add(Calendar.YEAR, i);
						d = new Dates(selected.getTime().getDate(), selected.getTime().getMonth(), selected.getTime().getYear());
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
	
}
