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

  // For CycleEntry class?!?
  public Entry(String n, int d, int m, int y, int h, int min, int s, float dist, String terrain, String tempo) {
    name = n;
    Calendar inst = Calendar.getInstance();
    inst.set(y,m-1,d,h,min,s);
    dateAndTime = inst;
    distance = dist;
    terrain = this.getTerrain();
    tempo = this.getTempo();
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

  @Override
  public String toString() {
    return name + ", " + getDay() + ", " + getMonth() + ", " +  getYear() + ", " + getHour()
            + ", " + getMin() + ", " + getSec() + ", " + getDistance() + " that's the basics!";
  }

  public String cycleToString() {
    return name + ", " + getDay() + ", " + getMonth() + ", " +  getYear() + ", " + getHour() + ", " + getMin()
            + ", " + getSec() + ", " + getDistance() + ", " + getTerrain() + ", " + getTempo() + " ...Bike";
  }
} // Entry

class CycleEntry extends Entry {

  public CycleEntry(String name, int d, int m, int y, int h, int min, int s, float dist, String terrain, String tempo) {
    super(name, d, m, y, h, min, s, dist, terrain, tempo); // Needs changed so it works ?
  }
}

class SprintEntry extends Entry {

  public SprintEntry(String name, int d, int m, int y, int h, int min, int s, float dist, float reps, float rec) {
    super(name, d, m, y, h, min, s, dist, reps, rec); // Needs changed
  }
}


class SwimEntry extends Entry {

  public SwimEntry(String name, int d, int m, int y, int h, int min, int s, float dist, String where) {
    super(name, d, m, y, h, min, s, dist, where); // Needs changed
  }
}