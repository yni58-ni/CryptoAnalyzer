/***
 * 
 * @author Yeonsil Choi
 *
 */
public class Date {

	private int day;
	private int month;
	private int year;
	private String[] months= {"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sept","Oct","Nov","Dec"};
	
	/***
	 * constructor
	 */
	public Date(int d, int m, int y) {
		this.day = d;
		this.month = m;
		this.year = y;
		
	}
	
	public int getDay() {
		return this.day;
	}
	
	public void setDay(int newDay) {
		this.day = newDay;
	}
	
	public int getMon() {
		return this.month;
	}
	
	public void setMon(int newMon) {
		this.month = newMon;
	}
	
	public int getYear() {
		return this.year;
	}
	
	public void setYear(int newYear) {
		this.year = newYear;
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
