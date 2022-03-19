// This class holds information about a single training session
package com.stir.cscu9t4practical1;

import java.util.Calendar;
public class Entry {
  private String name;
  private Calendar dateAndTime;
  private float distance;
  
  public Entry (String n, int d, int m, int y, int h, int min, int s, float dist) {
    name = n;
    Calendar inst = Calendar.getInstance();
    inst.set(y,m-1,d,h,min,s);
    dateAndTime = inst;
    distance = dist;
  } //constructor

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

  public String getTerrain() {
    return null; // Change so it makes sense!!
  }

  public String getTempo() {
    return null; // Change so it makes sense!!
  }

  public int getRepetitions() {
    return 0; // Change that it makes sense - and, it might not be an integer !
  }

  public int getRecovery() {
    return 0; // Change that it makes sense - and, it might not be an integer !
  }

  public String getWhere() {
    return null; // Change so it makes sense!!
  }
} // Entry

class CycleEntry extends Entry {
  //public CycleEntry(String name, int d, int m, int y, int h, int min, int s, float dist, String asphalt, String moderate) {

  //}

  public CycleEntry(String n, int d, int m, int y, int h, int min, int s, float dist) {
    super(n, d, m, y, h, min, s, dist);
  }
}

class SprintEntry extends Entry {

  public SprintEntry(String n, int d, int m, int y, int h, int min, int s, float dist, float whatsThis, float whatsThisOne) {
    super(n, d, m, y, h, min, s, dist); // Needs changed so the last two things considered!!
  }
}


class SwimEntry extends Entry {

  public SwimEntry(String n, int d, int m, int y, int h, int min, int s, float dist, String terrain) {
    super(n, d, m, y, h, min, s, dist); // Needs changed so the last thing considered!!
  }
}