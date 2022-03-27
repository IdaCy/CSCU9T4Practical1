package com.stir.cscu9t4practical1;

public class SwimEntry extends Entry {
    private String wh;

    public SwimEntry(String name, int d, int m, int y, int h, int min, int s, float dist, String where) {
        super(name, d, m, y, h, min, s, dist); // Needs changed
        wh = where;
    }

    public String getWhere() {
        return wh;
    }

    public String swimToString() {
        return name + ", " + getDay() + ", " + getMonth() + ", " +  getYear() + ", " + getHour() + ", " + getMin()
                + ", " + getSec() + ", " + getDistance() + ", " + getWhere() + " ...Swim";
    }
    public String getEntry () {
        String result = getName() + " swam " + getDistance() + " km "
                + getWhere() + " in " + getHour() + ":" + getMin() + ":" + getSec() + " on "
                + getDay() + "/" + getMonth() + "/" + getYear() + "\n";
        return result;
    }
}
