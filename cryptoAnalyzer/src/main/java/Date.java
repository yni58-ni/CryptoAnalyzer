/***
 * 
 * @author Yeonsil Choi
 *
 */
public class Date {

	private int day;
	private int month;
	private int year;
	
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
	
	public void printString() {
		System.out.println(this.day + " - " + this.month);
	}
	
	public void printInt() {
		System.out.println(this.day + " - " + this.month + " - " + this.month);
	}
}
