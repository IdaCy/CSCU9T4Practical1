package com.stir.cscu9t4practical1;

public class SprintEntry extends Entry {
    private int reps;
    private int rec;

    public SprintEntry(String name, int d, int m, int y, int h, int min, int s, float dist, int repetitions, int recovery) {
        super(name, d, m, y, h, min, s, dist); // Needs changed
        reps = repetitions;
        rec = recovery;
    }

    public int getRepetitions() {
        return reps;
    }

    public int getRecovery() {
        return rec;
    }

    public String sprintToString() {
        return name + ", " + getDay() + ", " + getMonth() + ", " +  getYear() + ", " + getHour() + ", " + getMin()
                + ", " + getSec() + ", " + getDistance() + ", " + getRepetitions() + ", " + getRecovery() + " ...Run";
    }

    public String getEntry () {
        String result = getName() + " sprinted " + getRepetitions() + "x" + getDistance() + "m in "
                + getHour() + ":" + getMin() + ":" + getSec() + " with "
                + getRecovery() + " minutes recovery on "
                + getDay() + "/" + getMonth() + "/" + getYear() + "\n";
        return result;
    }
}
