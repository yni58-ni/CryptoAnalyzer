package cryptoAnalyzer.selection;
/***
 * 
 * @author Yeonsil Choi
 *
 */
public class Dates {

	static int day;
	static int month;
	static int year;
	private String[] months= {"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sept","Oct","Nov","Dec"};
	


	
 	/***
	 * 
	 * @return this.day
	 */
	public int getDay() {
		return day;
	}
	
	/***
	 * 
	 * @param newDay
	 */
	public void setDay(int newDay) {
		day = newDay;
	}
	
	/***
	 * 
	 * @return this.month
	 */
	public int getMonth() {
		return month;
	}
	
	/***
	 * 
	 * @param newMon
	 */
	public void setMon(int newMon) {
		month = newMon;
	}
	
	/***
	 * 
	 * @return this.year
	 */
	public int getYear() {
		return year;
	}
	
	/***
	 * 
	 * @param newYear
	 */
	public void setYear(int newYear) {
		year = newYear;
	}
	

	public String printString() {
		if(day<10) {
			return "0"+day+"-"+months[month-1];
		}else {
			return day+"-"+months[month-1];
		}
	}


	public String printInt() {
		//13-09-2021
		if(month<10) {
			if(day<10) {
				return "0"+day+"-0"+month+"-"+year;
			}else {
				return day+"-0"+month+"-"+year;
			}
		}else {
			if(day<10) {
				return "0"+day+"-"+month+"-"+year;
			}else {
				return day+"-"+month+"-"+year;
			}
		}

	}
}
