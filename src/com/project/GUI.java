package com.project;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame {

	//fields
	private JPanel loginPanel;
	private final JComboBox<Person> users = new JComboBox<Person>();
	private JButton loginButton;

	private JPanel userPanel;
	private final int WIDTH = 310;    //window width
	private final int HEIGHT = 200;    //window height
	private JButton GoalButton;

	private JPanel timePanel;
	private JButton ExerciseButton;
	private JTextField minuteStartText;
	private JButton SleepButton;
	private JTextField minuteEndText;
	private JTextField hourStartText;        //reference to a text field object
	private JTextField hourEndText;
	private JLabel hourStartLabel;
	private JLabel minuteStartLabel;
	private JButton SubmitButton;

	private Person selecteduser;

	private JPanel goalPanel;
	private JLabel hourEndLabel;
	private JLabel minuteEndLabel;


	//constructors
	public GUI() {
		setTitle("Login");
		setSize(WIDTH, HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		buildLoginPanel();
		add(loginPanel);
		pack();
		setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GUI start = new GUI();
	}

	private void login() {
		JOptionPane.showMessageDialog(null, "Login Successful, Welcome " + selecteduser);
		builduserPanel();
		add(userPanel);

		loginPanel.setVisible(false);
		userPanel.setVisible(true);
	}

	private void buildLoginPanel() {

		//create the labels

		Person[] userList = DataStorage.loadAllFile();

		for (Person user : userList) {
			users.addItem(user);
		}


		//create text fields


		//create a button
		loginButton = new JButton("Login");

		//add an action listener to the button
		LoginButtonListener loginListener = new LoginButtonListener();
		loginButton.addActionListener(loginListener);



		//create the Panel
		loginPanel = new JPanel();

		//add components to the loginPanel
		loginPanel.add(users);
		loginPanel.add(loginButton);
	}

	private void builduserPanel() {
		setTitle("HealthTracker");

		//create a button
		GoalButton = new JButton("Set Goals");
		SleepButton = new JButton("Record Sleep");
		ExerciseButton = new JButton("Record Exercise");

		//add an action listener to the button
		SleepButtonListener sleepListener = new SleepButtonListener();
		SleepButton.addActionListener(sleepListener);

		ExerciseButtonListener exerciseListener = new ExerciseButtonListener();
		ExerciseButton.addActionListener(exerciseListener);

		GoalButtonListener goalListener = new GoalButtonListener();
		GoalButton.addActionListener(goalListener);


		//create the Panel
		userPanel = new JPanel();

		setSize(WIDTH, HEIGHT);

		//add all components to the userPanel
		userPanel.add(SleepButton);
		userPanel.add(ExerciseButton);
		userPanel.add(GoalButton);
	}

	private void buildtimePanel(int category) {
		String type;
		timePanel = new JPanel();
		if (category == 1) {
			setTitle("Sleep Record");
			type = "Sleep";
		} else {
			setTitle("Exercise Record");
			type = "Exercise";
		}

		SubmitButton = new JButton("Submit");
		hourStartText = new JTextField(2);
		minuteStartText = new JTextField(2);
		hourEndText = new JTextField(2);
		minuteEndText = new JTextField(2);
		hourStartLabel = new JLabel(type + " Start Time");
		minuteStartLabel = new JLabel(":");
		hourEndLabel = new JLabel("        End Time");
		minuteEndLabel = new JLabel(":");

		timePanel.add(hourStartLabel);
		timePanel.add(hourStartText);
		timePanel.add(minuteStartLabel);
		timePanel.add(minuteStartText);
		timePanel.add(hourEndLabel);
		timePanel.add(hourEndText);
		timePanel.add(minuteEndLabel);
		timePanel.add(minuteEndText);
		timePanel.add(SubmitButton);

	}

	private void buildgoalPanel() {
	}

	private class LoginButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			//declarations
			Person selectedUser = (Person) users.getSelectedItem();
			login();
		}
	}

	private class GoalButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			buildgoalPanel();
		}
	}

	private class SleepButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			buildtimePanel(1);
			userPanel.setVisible(false);
			add(timePanel);
			timePanel.setVisible(true);
		}

	}

	private class ExerciseButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			buildtimePanel(2);
			userPanel.setVisible(false);
			add(timePanel);
			timePanel.setVisible(true);
		}
	}


}
