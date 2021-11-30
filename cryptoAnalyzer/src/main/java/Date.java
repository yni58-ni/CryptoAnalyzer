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
	 * 
	 * @param d
	 * @param m
	 * @param y
	 */
	public Date(int d, int m, int y) {
		this.day = d;
		this.month = m;
		this.year = y;
		
	}
	
	/***
	 * 
	 * @return this.day
	 */
	public int getDay() {
		return this.day;
	}
	
	/***
	 * 
	 * @param newDay
	 */
	public void setDay(int newDay) {
		this.day = newDay;
	}
	
	/***
	 * 
	 * @return this.month
	 */
	public int getMon() {
		return this.month;
	}
	
	/***
	 * 
	 * @param newMon
	 */
	public void setMon(int newMon) {
		this.month = newMon;
	}
	
	/***
	 * 
	 * @return this.year
	 */
	public int getYear() {
		return this.year;
	}
	
	/***
	 * 
	 * @param newYear
	 */
	public void setYear(int newYear) {
		this.year = newYear;
	}
	
	/***
	 * print string
	 */
	public void printString() {
		System.out.println(this.day + " - " + this.month);
	}
	
	/***
	 * print int
	 */
	public void printInt() {
		System.out.println(this.day + " - " + this.month + " - " + this.month);
	}
}
