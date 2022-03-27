// GUI and main program for the Training Record
package com.stir.cscu9t4practical1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TrainingRecordGUI extends JFrame implements ActionListener {

    private JTextField name = new JTextField(30);
    private JTextField day = new JTextField(2);
    private JTextField month = new JTextField(2);
    private JTextField year = new JTextField(4);
    private JTextField hours = new JTextField(2);
    private JTextField mins = new JTextField(2);
    private JTextField secs = new JTextField(2);
    private JTextField dist = new JTextField(4);
    private JLabel labn = new JLabel(" Name:");
    private JLabel labd = new JLabel(" Day:");
    private JLabel labm = new JLabel(" Month:");
    private JLabel laby = new JLabel(" Year:");
    private JLabel labh = new JLabel(" Hours:");
    private JLabel labmm = new JLabel(" Mins:");
    private JLabel labs = new JLabel(" Secs:");
    private JLabel labdist = new JLabel(" Distance (km):");
    private JButton addR = new JButton("Add");
    private JButton lookUpByDate = new JButton("Look Up");
    private JButton findAllByDate = new JButton("Find all by date");
    private JButton removeAll = new JButton("RemoveAll");
    private JButton remove = new JButton("Remove");

    JRadioButton r1 = new JRadioButton("Cycle");
    JRadioButton r2 = new JRadioButton("Sprint");
    JRadioButton r3 = new JRadioButton("Swim");
    ButtonGroup bg = new ButtonGroup();

    private TrainingRecord myAthletes = new TrainingRecord();

    private JTextArea outputArea = new JTextArea(5, 50);

    public static void main(String[] args) {
        TrainingRecordGUI applic = new TrainingRecordGUI();
    } // main

    // set up the GUI 
    public TrainingRecordGUI() {
        super("Training Record");
        setLayout(new FlowLayout());

        r1.setBounds(75,50,100,30);
        r1.setActionCommand("Cycle");
        r2.setBounds(75,100,100,30);
        r2.setActionCommand("Sprint");
        r3.setBounds(75,100,100,30);
        r3.setActionCommand("Swim");
        bg.add(r1); bg.add(r2); bg.add(r3);
        add(r1);
        //r1.addActionListener(this);
        add(r2);
        //r2.addActionListener(this);
        add(r3);
        //r3.addActionListener(this);

        add(labn);
        add(name);
        name.setEditable(true);
        add(labd);
        add(day);
        day.setEditable(true);
        add(labm);
        add(month);
        month.setEditable(true);
        add(laby);
        add(year);
        year.setEditable(true);
        add(labh);
        add(hours);
        hours.setEditable(true);
        add(labmm);
        add(mins);
        mins.setEditable(true);
        add(labs);
        add(secs);
        secs.setEditable(true);
        add(labdist);
        add(dist);
        dist.setEditable(true);
        add(addR);
        addR.addActionListener(this);
        add(lookUpByDate);
        lookUpByDate.addActionListener(this);
        add(findAllByDate);
        findAllByDate.addActionListener(this);
        add(removeAll);
        removeAll.addActionListener(this);
        add(remove);
        remove.addActionListener(this);
        add(outputArea);
        outputArea.setEditable(false);
        setSize(720, 200);
        setVisible(true);
        blankDisplay();

        // To save typing in new entries while testing, uncomment
        // the following lines (or add your own test cases)
        
    } // constructor

    // listen for and respond to GUI events 
    public void actionPerformed(ActionEvent event) {
        String message = "";
        if (event.getSource() == addR) {
            message = addEntry("generic");
        }
        if (event.getSource() == lookUpByDate) {
            message = lookupEntry();
        }
        if (event.getSource() == findAllByDate) {
            message = lookupAllEntries();
        }
        if (event.getSource() == removeAll) {
            message = removeAllEntries();
        }
        if (event.getSource() == remove) {
            message = removeEntry();
        }
        outputArea.setText(message);
        blankDisplay();
    } // actionPerformed

    public String addEntry(String what) {
        String message = bg.getSelection().getActionCommand() + " record added\n";
        System.out.println("Adding "+what+" entry to the records");
        String category = bg.getSelection().getActionCommand();
        String n = name.getText();
        int m = Integer.parseInt(month.getText());
        int d = Integer.parseInt(day.getText());
        int y = Integer.parseInt(year.getText());
        float km = java.lang.Float.parseFloat(dist.getText());
        int h = Integer.parseInt(hours.getText());
        int mm = Integer.parseInt(mins.getText());
        int s = Integer.parseInt(secs.getText());
        String terr = "";
        String tem = "";
        int repetitions = 0;
        int recovery = 0;
        String where = "";

        Entry e;
        if(category.equals("Cycle")) {
            e = new CycleEntry(n, d, m, y, h, mm, s, km, terr, tem);
        }
        else if(category.equals("Sprint")) {
            e = new SprintEntry(n, d, m, y, h, mm, s, km, repetitions, recovery);
        }
        else if(category.equals("Swim")) {
            e = new SwimEntry(n, d, m, y, h, mm, s, km, where);
        }
        else {
            e = new Entry(n, d, m, y, h, mm, s, km);
        }
        myAthletes.addEntry(e);
        return message;
    }

    public String lookupEntry() {
        int m = Integer.parseInt(month.getText());
        int d = Integer.parseInt(day.getText());
        int y = Integer.parseInt(year.getText());
        outputArea.setText("looking up record ...");
        String message = myAthletes.lookupAllEntries(d, m, y); // Original method: lookupEntry
        return message;
    }

    public String lookupAllEntries() {
        int m = Integer.parseInt(month.getText());
        int d = Integer.parseInt(day.getText());
        int y = Integer.parseInt(year.getText());
        outputArea.setText("Not implemented yet");
        String message = myAthletes.lookupAllEntries(d, m, y);
        return message;
    }

    public void blankDisplay() {
        name.setText("");
        day.setText("");
        month.setText("");
        year.setText("");
        hours.setText("");
        mins.setText("");
        secs.setText("");
        dist.setText("");

    }// blankDisplay
    // Fills the input fields on the display for testing purposes only
    public void fillDisplay(Entry ent) {
        name.setText(ent.getName());
        day.setText(String.valueOf(ent.getDay()));
        month.setText(String.valueOf(ent.getMonth()));
        year.setText(String.valueOf(ent.getYear()));
        hours.setText(String.valueOf(ent.getHour()));
        mins.setText(String.valueOf(ent.getMin()));
        secs.setText(String.valueOf(ent.getSec()));
        dist.setText(String.valueOf(ent.getDistance()));
    }

    public String removeAllEntries() {
        myAthletes.clearAllEntries();
        return "All entries deleted!";
    }
    public String removeEntry() {;
        int m = Integer.parseInt(month.getText());
        int d = Integer.parseInt(day.getText());
        int y = Integer.parseInt(year.getText());
        System.out.println(m + " " + d + " are those currently");
        outputArea.setText("...soon deleted...");
        return "Entry deleted!";
    }

} // TrainingRecordGUI

