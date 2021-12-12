package com.project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

public class GUI extends JFrame {

	//fields
	private JPanel loginPanel;
	private final JComboBox<Person> users = new JComboBox<Person>();

	private JPanel userPanel;
	private final int WIDTH = 310;    //window width
	private final int HEIGHT = 200;    //window height

	private JPanel timePanel;

	private Person selectedUser;

	private JPanel goalPanel;


	//constructors
	public GUI() {
		setTitle("Login or Sign up");
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
		JOptionPane.showMessageDialog(null, "Login Successful, Welcome " + selectedUser);
		buildUserPanel();
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

		//create a login button
		JButton loginButton = new JButton("Login");

		//add an action listener to the login button
		LoginButtonListener loginListener = new LoginButtonListener();
		loginButton.addActionListener(loginListener);


		//create the Panel
		loginPanel = new JPanel();

		//add components to the loginPanel
		loginPanel.add(users);
		loginPanel.add(loginButton);

		//sign up section
		JButton signUpButton = new JButton("Sign Up");
	}

	private void buildUserPanel() {
		setTitle("HealthTracker");

		//create a button
		JButton goalButton = new JButton("Set Goals");
		JButton sleepButton = new JButton("Record Sleep");
		JButton exerciseButton = new JButton("Record Exercise");

		//add an action listener to the button
		SleepButtonListener sleepListener = new SleepButtonListener();
		sleepButton.addActionListener(sleepListener);

		ExerciseButtonListener exerciseListener = new ExerciseButtonListener();
		exerciseButton.addActionListener(exerciseListener);

		GoalButtonListener goalListener = new GoalButtonListener();
		goalButton.addActionListener(goalListener);


		//create the Panel
		userPanel = new JPanel();

		setSize(WIDTH, HEIGHT);

		//add all components to the userPanel
		userPanel.add(sleepButton);
		userPanel.add(exerciseButton);
		userPanel.add(goalButton);
	}

	private void buildtimePanel(int category) {
		String type;
		timePanel = new JPanel(new GridBagLayout());
		//GBC for alignment
		GridBagConstraints gb = new GridBagConstraints();

		if (category == 1) {
			setTitle("Sleep Record");
			type = "Sleep";
		} else {
			setTitle("Exercise Record");
			type = "Exercise";
		}

		//Declare + initialize all components
		JButton submitButton = new JButton("Submit");
		submitButton.setVerticalAlignment(JButton.CENTER);
		//reference to a text field object
		JTextField hourStartText = new JTextField(2);
		JTextField minuteStartText = new JTextField(2);
		JTextField hourEndText = new JTextField(2);
		JTextField minuteEndText = new JTextField(2);
		JLabel hourStartLabel = new JLabel(type + " Start Time ");
		JLabel minuteStartLabel = new JLabel(":");
		JLabel hourEndLabel = new JLabel();
		hourEndLabel.setText(type + " End Time ");
		JLabel minuteEndLabel = new JLabel(":");

		//Add + align components
		gb.gridy = 0;
		gb.insets = new Insets(0, 0, 20, 0);
		timePanel.add(new JLabel("Enter your " + type.toLowerCase(Locale.ROOT) + " data below"), gb);

		gb.gridy = 1;
		gb.insets = new Insets(0, 0, 0, 0);
		timePanel.add(hourStartLabel, gb);
		timePanel.add(hourStartText, gb);
		timePanel.add(minuteStartLabel, gb);
		timePanel.add(minuteStartText, gb);

		gb.gridy = 2;
		timePanel.add(hourEndLabel, gb);
		timePanel.add(hourEndText, gb);
		timePanel.add(minuteEndLabel, gb);
		timePanel.add(minuteEndText, gb);

		gb.gridy = 3;
		timePanel.add(submitButton, gb);
	}

	private void buildGoalPanel() {
	}

	private class LoginButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			//declarations
			selectedUser = (Person) users.getSelectedItem();
			login();
		}
	}

	private class GoalButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			buildGoalPanel();
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
