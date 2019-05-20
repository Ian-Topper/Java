package PA06;
 
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

class MyDate {
  private int year;
  private int month;
  private int day;
  private Date date3;
  //////todays date
  MyDate() {    
    GregorianCalendar date = new GregorianCalendar();
    year = date.get(Calendar.YEAR);
    month = date.get(Calendar.MONTH);
    day = date.get(Calendar.DAY_OF_MONTH);
    @SuppressWarnings("deprecation")
	Date date1 = new Date((year-1900), (month), day);
    System.out.println("Todays Date"+date1);
  }
  /////not needed
  MyDate(long elapsedTime) {   
    GregorianCalendar date = new GregorianCalendar();
    date.setTimeInMillis(elapsedTime);
    year = date.get(Calendar.YEAR);
    month = date.get(Calendar.MONTH);
    day = date.get(Calendar.DAY_OF_MONTH);
    @SuppressWarnings("deprecation")
  	Date date2 = new Date((year-1900), (month), day);
      System.out.println("Todays Date"+date2);
  }
    /////date entered
  MyDate(int year, int month, int day) {
	  this.year = year;
    this.month = month;
    this.day = day;
    ///Change date format still works with deprecation
   @SuppressWarnings("deprecation")
Date date3 = new Date((year-1900),(month-1),day);
   this.date3 = date3;
  }
  
  public int getYear() {
    return year;
  }

  public int getMonth() {
    return month;
  }
  
  public int getDay() {
    return day;
  }
  
  public void setYear(int year) {
    this.year = year;
  }
  
  public void setMonth(int month) {
    this.month = month;
  }
  
  public void setDay(int day) {
    this.day = day;
  }

@Override
public String toString() {
	return "["+ date3+"]";
}  
  
  
}