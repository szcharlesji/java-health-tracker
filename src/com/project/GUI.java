package com.project;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame {

	private final JComboBox<Person> users = new JComboBox<Person>();
	private final int WIDTH = 310;    //window width
	private final int HEIGHT = 200;    //window height
	//fields
	private JPanel loginPanel;
	private JButton ExerciseButton;
	private JButton SleepButton;
	private JButton loginButton;
	private JPanel userPanel;
	private JButton GoalButton;
	private JPanel timePanel;
	private JTextField hourStartText;        //reference to a text field object
	private JTextField minuteStartText;
	private JTextField hourEndText;
	private JTextField minuteEndText;
	private JLabel hourStartLabel;
	private JLabel circumLabel;
	private JButton SubmitButton;
	private Person selecteduser;
	private JPanel goalPanel;


	//constructors
	public GUI() {
		setTitle("Login");
		setSize(WIDTH, HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		buildloginPanel();
		add(loginPanel);
		pack();
		setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GUI start = new GUI();
	}

	private void buildloginPanel() {

		//create the labels
		Person[] userList = new Person[2];
		userList[0] = new Person("male", 150, 180, "Cheng", 19);
		userList[1] = new Person("female", 130, 140, "Sarah", 19);

		users.addItem(userList[0]);
		users.addItem(userList[1]);

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

	private void login() {
		JOptionPane.showMessageDialog(null, "Login Successful, Welcome " + selecteduser);
		builduserPanel();
		add(userPanel);

		loginPanel.setVisible(false);
		userPanel.setVisible(true);
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
		timePanel = new JPanel();
		if (category == 1)
			setTitle("Sleep Record");

		else
			setTitle("Exercise Record");


		SubmitButton = new JButton("Submit");
		hourStartText = new JTextField(2);
		minuteStartText = new JTextField(2);
		hourEndText = new JTextField(2);
		minuteEndText = new JTextField(2);

		timePanel.add(hourStartText);
		timePanel.add(minuteStartText);
		timePanel.add(hourEndText);
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
