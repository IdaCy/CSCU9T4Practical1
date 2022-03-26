// This class holds information about a single training session
package com.stir.cscu9t4practical1;

import java.util.Calendar;
public class Entry {
  protected String name;
  protected Calendar dateAndTime;
  protected float distance;
  private String terrain;
  private String tempo;
  
  public Entry (String n, int d, int m, int y, int h, int min, int s, float dist) {
    name = n;
    Calendar inst = Calendar.getInstance();
    inst.set(y,m-1,d,h,min,s);
    dateAndTime = inst;
    distance = dist;
  } //constructor

  // For CycleEntry class?!?
  public Entry(String n, int d, int m, int y, int h, int min, int s, float dist, String terrain, String tempo) {
    /*name = n;
    Calendar inst = Calendar.getInstance();
    inst.set(y,m-1,d,h,min,s);
    dateAndTime = inst;
    distance = dist;
    terrain = this.getTerrain();
    tempo = this.getTempo();*/
  }

  // For SprintEntry class?!?
  public Entry(String n, int d, int m, int y, int h, int min, int s, float dist, float repetitions, float recovery) {
    name = n;
    Calendar inst = Calendar.getInstance();
    inst.set(y,m-1,d,h,min,s);
    dateAndTime = inst;
    distance = dist;
    repetitions = getRepetitions();
    recovery = getRecovery();
  }

  // For SwimEntry class?!?
  public Entry(String n, int d, int m, int y, int h, int min, int s, float dist, String where) {
    name = n;
    Calendar inst = Calendar.getInstance();
    inst.set(y,m-1,d,h,min,s);
    dateAndTime = inst;
    distance = dist;
    where = getWhere();
  }

  public String getName () {
    return name;
  } //getName
  
  public int getDay () {
    return dateAndTime.get(Calendar.DATE);
  } //getDay
  
  public int getMonth () {
    int month =  dateAndTime.get(Calendar.MONTH) + 1;
    return month;
  } //getMonth
  
  public int getYear () {
    return dateAndTime.get(Calendar.YEAR);
  } //getYear

  public int getHour () {
    return dateAndTime.get(Calendar.HOUR);
  } //getHour

  public int getMin () {
    return dateAndTime.get(Calendar.MINUTE);
  } //getMin

  public int getSec () {
    return dateAndTime.get(Calendar.SECOND);
  } //getSec

  public float getDistance () {
    return distance;
  } //getYear

  public String getEntry () {
   String result = getName()+" ran " + getDistance() + " km in "
             +getHour()+":"+getMin()+":"+ getSec() + " on "
             +getDay()+"/"+getMonth()+"/"+getYear()+"\n";
   return result;
  } //getEntry

  public int getRepetitions() {
    return 0; // Change that it makes sense - and, it might not be an integer !
  }

  public int getRecovery() {
    return 0; // Change that it makes sense - and, it might not be an integer !
  }

  public String getWhere() {
    return null; // Change so it makes sense!!
  }

  @Override
  public String toString() {
    return name + ", " + getDay() + ", " + getMonth() + ", " +  getYear() + ", " + getHour()
            + ", " + getMin() + ", " + getSec() + ", " + getDistance() + " that's the basics!";
  }
} // Entry


