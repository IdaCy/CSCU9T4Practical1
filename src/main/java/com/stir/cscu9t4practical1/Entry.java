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

  // Does the following work - it's just for CycleEntry class?!?
  public Entry(String n, int d, int m, int y, int h, int min, int s, float dist, String terrain, String level) {
  }

  // Does the following work - it's just for SprintEntry class?!?
  public Entry(String n, int d, int m, int y, int h, int min, int s, float dist, float up, float down) {
  }

  // Does the following work - it's just for SwimEntry class?!?
  public Entry(String n, int d, int m, int y, int h, int min, int s, float dist, String terrain) {
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

  public CycleEntry(String n, int d, int m, int y, int h, int min, int s, float dist, String terrain, String level) {
    super(n, d, m, y, h, min, s, dist, terrain, level); // Needs changed so it works ?
  }
}

class SprintEntry extends Entry {

  public SprintEntry(String n, int d, int m, int y, int h, int min, int s, float dist, float up, float down) {
    super(n, d, m, y, h, min, s, dist, up, down); // Needs changed
  }
}


class SwimEntry extends Entry {

  public SwimEntry(String n, int d, int m, int y, int h, int min, int s, float dist, String terrain) {
    super(n, d, m, y, h, min, s, dist, terrain); // Needs changed
  }
}