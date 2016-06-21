package as2;

/* Date.java */

import java.io.*;

public class Date {

  /* Put your private data fields here. */
	private int month;
	private int day;
	private int year;
	
	private int dayInAll(){
		int n=0;
		int leapYearCount=0;
		for(int i=1;i<year;i++){
			if(isLeapYear(i)){
				leapYearCount++;
			}
		}
		n=(year-1)*365+leapYearCount+this.dayInYear();
		return n;
	}

  /** Constructs a date with the given month, day and year.   If the date is
   *  not valid, the entire program will halt with an error message.
   *  @param month is a month, numbered in the range 1...12.
   *  @param day is between 1 and the number of days in the given month.
   *  @param year is the year in question, with no digits omitted.
   */
  public Date(int month, int day, int year) {
	  if(!isValidDate(month,day,year)){
		  System.out.println("This is not a valid date!");
		  System.exit(0);
	  }
	  this.month=month;
	  this.day=day;
	  this.year=year;
  }

  /** Constructs a Date object corresponding to the given string.
   *  @param s should be a string of the form "month/day/year" where month must
   *  be one or two digits, day must be one or two digits, and year must be
   *  between 1 and 4 digits.  If s does not match these requirements or is not
   *  a valid date, the program halts with an error message.
   */
  public Date(String s) {
	  String[] strs=new String[3];
	  for(int i=0;i<3;i++){
		  strs[i]=new String();
	  }
	  int index=0;
	  int start=0;
	  int end=0;
	  for(int i=0;i<s.length();i++){
		  if(s.charAt(i)==' ' || s.charAt(i)=='/') continue;
		  if(!Character.isDigit(s.charAt(i))){
			  System.out.println("Must be digit!");
			  System.exit(0);
		  }
		  start=i;
		  while(i<s.length() && s.charAt(i)!='/'){
			  if(!Character.isDigit(s.charAt(i))){
				  System.out.println("Must be digit!");
				  System.exit(0);
			  }
			  else i++;
		  }
		  end=i;
		  strs[index++]=s.substring(start,end);
		  
	  }
	  
	  int lenOfMonth=strs[0].length();
	  int lenOfDay=strs[1].length();
	  int lenOfYear=strs[2].length();
	  if(!(lenOfMonth==1 || lenOfMonth==2) || !(lenOfDay==1 || lenOfDay==2) || !(lenOfYear>=1 && lenOfYear<=4)){
		  System.out.println("The date format is not correct!");
		  System.exit(0);
	  }
	  
	  int tmpMonth=Integer.parseInt(strs[0]);
	  int tmpDay=Integer.parseInt(strs[1]);
	  int tmpYear=Integer.parseInt(strs[2]);
	  
	  if(!isValidDate(tmpMonth,tmpDay,tmpYear)){
		  System.out.println("This is not a valid date");
		  System.exit(0);
	  }
	  this.month=tmpMonth;
	  this.day=tmpDay;
	  this.year=tmpYear;
	  
  }

  /** Checks whether the given year is a leap year.
   *  @return true if and only if the input year is a leap year.
   */
  public static boolean isLeapYear(int year) {
    //return true;                        // replace this line with your solution
	  if(year%4!=0){
		  return false;
	  }
	  else{
		  if(year%400==0) return true;
		  if(year%100==0) return false;
		  return true;
	  }
  }

  /** Returns the number of days in a given month.
   *  @param month is a month, numbered in the range 1...12.
   *  @param year is the year in question, with no digits omitted.
   *  @return the number of days in the given month.
   */
  public static int daysInMonth(int month, int year) {
    //return 0;                           // replace this line with your solution
	  int numOfDays=0;
	  boolean isLeapYear=isLeapYear(year);
	  switch(month){
	  case 2:
		  if(isLeapYear){
			  numOfDays=29;
			  break;
		  }else{
			  numOfDays=28;
			  break;
		  }
	  case 4:
	  case 6:
	  case 9:
	  case 11:
		  numOfDays=30;
		  break;
	  default:
		  numOfDays=31;
		  break;
	  }
	  return numOfDays;
  }

  /** Checks whether the given date is valid.
   *  @return true if and only if month/day/year constitute a valid date.
   *
   *  Years prior to A.D. 1 are NOT valid.
   */
  public static boolean isValidDate(int month, int day, int year) {
    //return true;                        // replace this line with your solution
	  if(year<1) return false;
	  if(month<1 || month>12) return false;
	  int numOfDays=daysInMonth(month,year);
	  if(day<1 || day>numOfDays) return false;
	  return true;
  }

  /** Returns a string representation of this date in the form month/day/year.
   *  The month, day, and year are expressed in full as integers; for example,
   *  12/7/2006 or 3/21/407.
   *  @return a String representation of this date.
   */
  public String toString() {
    //return "stuff";                     // replace this line with your solution
	  return ""+month+"/"+day+"/"+year;
  }

  /** Determines whether this Date is before the Date d.
   *  @return true if and only if this Date is before d. 
   */
  public boolean isBefore(Date d) {
    //return true;                        // replace this line with your solution
	  int anotherYear=d.year;
	  int anotherMonth=d.month;
	  int anotherDay=d.day;
	  if(this.year<anotherYear) return true;
	  else if(this.year>anotherYear) return false;
	  else{
		  if(this.month<anotherMonth) return true;
		  else if(this.month>anotherMonth) return false;
		  else{
			  if(this.day<anotherDay) return true;
			  else if(this.day>anotherDay) return false;
			  else return false;
		  }
	  }
  }

  /** Determines whether this Date is after the Date d.
   *  @return true if and only if this Date is after d. 
   */
  public boolean isAfter(Date d) {
    //return true;                        // replace this line with your solution
	  if(isBefore(d)) return false;
	  if(this.year==d.year && this.month==d.month && this.day==d.day) return false;
	  return true;
  }

  /** Returns the number of this Date in the year.
   *  @return a number n in the range 1...366, inclusive, such that this Date
   *  is the nth day of its year.  (366 is used only for December 31 in a leap
   *  year.)
   */
  public int dayInYear() {
    //return 0;                           // replace this line with your solution
	  int n=0;
	  
	  int[] days=new int[this.month-1];
	  for(int i=0;i<days.length;i++){
		  days[i]=daysInMonth(i+1,this.year);
		  n=n+days[i];
	  }
	  n=n+this.day;
	  return n;
  }

  /** Determines the difference in days between d and this Date.  For example,
   *  if this Date is 12/15/2012 and d is 12/14/2012, the difference is 1.
   *  If this Date occurs before d, the result is negative.
   *  @return the difference in days between d and this date.
   */
  public int difference(Date d) {
    //return 0;                           // replace this line with your solution
	  return this.dayInAll()-d.dayInAll();
	  
  }

  public static void main(String[] argv) {
    System.out.println("\nTesting constructors.");
    Date d1 = new Date(1, 1, 1);
    System.out.println("Date should be 1/1/1: " + d1);
    d1 = new Date("2/4/2");
    System.out.println("Date should be 2/4/2: " + d1);
    d1 = new Date("2/29/2000");
    System.out.println("Date should be 2/29/2000: " + d1);
    d1 = new Date("2/29/1904");
    System.out.println("Date should be 2/29/1904: " + d1);

    d1 = new Date(12, 31, 1975);
    System.out.println("Date should be 12/31/1975: " + d1);
    Date d2 = new Date("1/1/1976");
    System.out.println("Date should be 1/1/1976: " + d2);
    Date d3 = new Date("1/2/1976");
    System.out.println("Date should be 1/2/1976: " + d3);

    Date d4 = new Date("2/27/1977");
    Date d5 = new Date("8/31/2110");

    /* I recommend you write code to test the isLeapYear function! */

    System.out.println("\nTesting before and after.");
    System.out.println(d2 + " after " + d1 + " should be true: " + 
                       d2.isAfter(d1));
    System.out.println(d3 + " after " + d2 + " should be true: " + 
                       d3.isAfter(d2));
    System.out.println(d1 + " after " + d1 + " should be false: " + 
                       d1.isAfter(d1));
    System.out.println(d1 + " after " + d2 + " should be false: " + 
                       d1.isAfter(d2));
    System.out.println(d2 + " after " + d3 + " should be false: " + 
                       d2.isAfter(d3));

    System.out.println(d1 + " before " + d2 + " should be true: " + 
                       d1.isBefore(d2));
    System.out.println(d2 + " before " + d3 + " should be true: " + 
                       d2.isBefore(d3));
    System.out.println(d1 + " before " + d1 + " should be false: " + 
                       d1.isBefore(d1));
    System.out.println(d2 + " before " + d1 + " should be false: " + 
                       d2.isBefore(d1));
    System.out.println(d3 + " before " + d2 + " should be false: " + 
                       d3.isBefore(d2));

    System.out.println("\nTesting difference.");
    System.out.println(d1 + " - " + d1  + " should be 0: " + 
                       d1.difference(d1));
    System.out.println(d2 + " - " + d1  + " should be 1: " + 
                       d2.difference(d1));
    System.out.println(d3 + " - " + d1  + " should be 2: " + 
                       d3.difference(d1));
    System.out.println(d3 + " - " + d4  + " should be -422: " + 
                       d3.difference(d4));
    System.out.println(d5 + " - " + d4  + " should be 48762: " + 
                       d5.difference(d4));
  }
}
