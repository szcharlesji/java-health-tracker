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
	private final int WIDTH = 400;    //window width
	private final int HEIGHT = 225;    //window height

	private JPanel timePanel;

	private Person selectedUser;

	private JPanel goalPanel;

	JTextField hourStartText = new JTextField(2);
	JTextField minuteStartText = new JTextField(2);
	JTextField hourEndText = new JTextField(2);
	JTextField minuteEndText = new JTextField(2);

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

		//create login + signup buttons
		JButton loginButton = new JButton("Login");
		JButton signUpButton = new JButton("Sign Up");

		//add an action listener to the login button
		LoginButtonListener loginListener = new LoginButtonListener();
		loginButton.addActionListener(loginListener);


		//create the Panel + GBC
		loginPanel = new JPanel(new GridBagLayout());
		GridBagConstraints gb = new GridBagConstraints();

		//add components to the loginPanel
		gb.gridy = 1;
		loginPanel.add(users, gb);
		loginPanel.add(loginButton, gb);

		gb.gridy = 3;
		gb.insets = new Insets(8, 0, 0, 0);
		signUpButton.setHorizontalAlignment(SwingConstants.CENTER);
		loginPanel.add(signUpButton, gb);

	}

	private void buildUserPanel() {
		setTitle("HealthTracker");

		//create a button
		JButton goalButton = new JButton("Set Goals");
		JButton sleepButton = new JButton("Record Sleep");
		JButton exerciseButton = new JButton("Record Exercise");
		JButton returnButton = new JButton("Return to Login/Signup");

		//add an action listener to the button
		SleepButtonListener sleepListener = new SleepButtonListener();
		sleepButton.addActionListener(sleepListener);

		ExerciseButtonListener exerciseListener = new ExerciseButtonListener();
		exerciseButton.addActionListener(exerciseListener);

		GoalButtonListener goalListener = new GoalButtonListener();
		goalButton.addActionListener(goalListener);

		ReturnButtonListener returnListener = new ReturnButtonListener();
		returnButton.addActionListener(returnListener);


		//create the Panel + GBC
		userPanel = new JPanel(new GridBagLayout());
		setSize(WIDTH, HEIGHT);
		GridBagConstraints gbc = new GridBagConstraints();

		//add all components to the userPanel
		gbc.gridy = 1;
		userPanel.add(sleepButton, gbc);
		userPanel.add(exerciseButton, gbc);

		//gbc.gridy = 2;
		userPanel.add(goalButton, gbc);

		gbc.gridy = 4;
		//gbc.insets = new Insets(20, 0, 0, 0);
		userPanel.add(returnButton, gbc);
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

		SubmitButtonListener submitListener = new SubmitButtonListener();
		submitButton.addActionListener(submitListener);

		//reference to a text field object

		JLabel hourStartLabel = new JLabel(type + " Start Time ");
		JLabel minuteStartLabel = new JLabel(":");
		JLabel hourEndLabel = new JLabel();
		JLabel minuteEndLabel = new JLabel(":");
		hourEndLabel.setText(type + " End Time ");

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

		gb.gridy = 5;

	}

	private void buildGoalPanel() {
		goalPanel = new JPanel(new GridBagLayout());
		GridBagLayout gb = new GridBagLayout();
		setTitle("Your Health Goals");

	}

	//Button listeners
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
			userPanel.setVisible(false);
			add(goalPanel);
			goalPanel.setVisible(true);
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

	private class SubmitButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			SleepRecord newRecord = new SleepRecord(hourStartText.getText() + ":" + minuteStartText.getText(),
					hourEndText.getText() + ":" + minuteEndText.getText());
			selectedUser.addSleepRecord(newRecord);
			buildUserPanel();
			timePanel.setVisible(false);
			add(userPanel);
			userPanel.setVisible(true);
		}
	}

	private class ReturnButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			buildLoginPanel();
			userPanel.setVisible(false);
			add(loginPanel);
			loginPanel.setVisible(true);
		}
	}


}
