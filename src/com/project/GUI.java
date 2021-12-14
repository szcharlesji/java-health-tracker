package com.project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

public class GUI extends JFrame {

	private final int WIDTH = 700;    //window width
	private final int HEIGHT = 300;    //window height
	private final JComboBox<Person> users = new JComboBox<Person>();
	private Person[] userList;

	private JPanel loginPanel;
	private JPanel signUpPanel;
	private JPanel userPanel;
	private JPanel timePanel;
	private JPanel goalPanel;

	private Person selectedUser;

	JTextField hourStartText = new JTextField(2);
	JTextField minuteStartText = new JTextField(2);
	JTextField hourEndText = new JTextField(2);
	JTextField minuteEndText = new JTextField(2);

	JTextField genderInput = new JTextField(2);
	JTextField nameInput = new JTextField(2);
	JTextField weightInput = new JTextField(2);
	JTextField heightInput = new JTextField(2);
	JTextField ageInput = new JTextField(2);
	JTextField sleepGoalInput = new JTextField(2);
	JTextField exerciseGoalInput = new JTextField(2);

	//constructors
	public GUI() {
		setTitle("Login or Sign up");
		setSize(WIDTH, HEIGHT);
		setLocationRelativeTo(null);
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

		userList = DataStorage.loadAllFile();
		users.removeAllItems();
		for (Person user : userList) {
			users.addItem(user);
		}


		setSize(WIDTH, HEIGHT);

		//create login + signup buttons
		JButton loginButton = new JButton("Login");
		JButton signUpButton = new JButton("Sign Up");

		//add an action listener to the login button
		LoginButtonListener loginListener = new LoginButtonListener();
		loginButton.addActionListener(loginListener);

		SignUpListener signUpListener = new SignUpListener();
		signUpButton.addActionListener(signUpListener);

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

	private void buildSignUpPanel() {
		setTitle("Sign Up");

		JButton doneButton = new JButton("Done");

		//action listener to the button
		SignUpDoneListener signUpDoneListener = new SignUpDoneListener();
		doneButton.addActionListener(signUpDoneListener);

		//create the Panel + GBC
		signUpPanel = new JPanel(new GridBagLayout());
		setSize(WIDTH, HEIGHT);
		GridBagConstraints gb = new GridBagConstraints();

		//add components to the signUpPanel
		gb.gridy = 0;
		JLabel instruction = new JLabel("Enter your information below");
		signUpPanel.add(instruction, gb);

		gb.gridy = 1;
		JLabel genderLabel = new JLabel("Gender: ");
		signUpPanel.add(genderLabel, gb);
		signUpPanel.add(genderInput, gb);

		JLabel nameLabel = new JLabel("Name: ");
		signUpPanel.add(nameLabel, gb);
		signUpPanel.add(nameInput, gb);

		JLabel weightLabel = new JLabel("Weight (lbs): ");
		signUpPanel.add(weightLabel, gb);
		signUpPanel.add(weightInput, gb);

		JLabel heightLabel = new JLabel("Height (cm): ");
		signUpPanel.add(heightLabel, gb);
		signUpPanel.add(heightInput, gb);

		JLabel ageLabel = new JLabel("Age: ");
		signUpPanel.add(ageLabel, gb);
		signUpPanel.add(ageInput, gb);

		gb.gridy = 2;
		JLabel sleepLabel = new JLabel("Sleep Goal: ");
		signUpPanel.add(sleepLabel, gb);
		signUpPanel.add(sleepGoalInput, gb);

		JLabel exerciseLabel = new JLabel("Exercise Goal: ");
		signUpPanel.add(exerciseLabel, gb);
		signUpPanel.add(exerciseGoalInput, gb);

		gb.gridy = 3;
		signUpPanel.add(doneButton, gb);
	}

	private void buildUserPanel() {
		setTitle("Health Tracker");

		//create a button
		JButton goalButton = new JButton("Track Goals/Progress");
		JButton sleepButton = new JButton("Record Sleep");
		JButton exerciseButton = new JButton("Record Exercise");
		JButton returnButton = new JButton("Return to Login/Signup");


		//add an action listener to the button
		SleepButtonListener sleepListener = new SleepButtonListener();
		sleepButton.addActionListener(sleepListener);

		ExerciseButtonListener exerciseListener = new ExerciseButtonListener();
		exerciseButton.addActionListener(exerciseListener);

		GoalButtonListener goalButtonListener = new GoalButtonListener();
		goalButton.addActionListener(goalButtonListener);

		ReturnButtonListener returnListener = new ReturnButtonListener();
		returnButton.addActionListener(returnListener);


		//create the Panel + GBC
		userPanel = new JPanel(new GridBagLayout());
		setSize(WIDTH, HEIGHT);
		GridBagConstraints gbc = new GridBagConstraints();

		//add all components to the userPanel
//		gbc.gridy = 1;
//		gbc.gridx = 1;
//		userPanel.add(spSleep, gbc);
		new DataFrame();

		gbc.gridy = 1;
//		gbc.gridx = 2;
		userPanel.add(sleepButton, gbc);
		userPanel.add(exerciseButton, gbc);

		userPanel.add(goalButton, gbc);

//		gbc.gridy = 4;
		//gbc.insets = new Insets(20, 0, 0, 0);
		userPanel.add(returnButton, gbc);
	}

	private void buildRecordPanel(int category) {
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

		SubmitButtonListener submitListener = new SubmitButtonListener(category);
		submitButton.addActionListener(submitListener);

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
		GridBagConstraints gb = new GridBagConstraints();
		setTitle("Your Goals & Progress");

		//Declare elements
		JLabel sleepGoalText = new JLabel("Your current sleep goal is: "
				+ selectedUser.getSleepGoal() + " hours/day.");
		//Have new dialogue popup with option to enter data
		JButton updateSGoalButton = new JButton("Update");
		SleepUpdateListener sleepUpdateListener = new SleepUpdateListener();
		updateSGoalButton.addActionListener(sleepUpdateListener);


		JLabel exerciseGoalText = new JLabel("Your current exercise goal is: "
				+ selectedUser.getExerciseGoal()+ " hours/day.");
		//Have new dialogue popup with option to enter data
		JButton updateEGoalButton = new JButton("Update");
		ExerciseUpdateListener exerciseUpdateListener = new ExerciseUpdateListener();
		updateEGoalButton.addActionListener(exerciseUpdateListener);

		//Display elements
		gb.gridy = 1;
		goalPanel.add(sleepGoalText, gb);
		goalPanel.add(updateSGoalButton, gb);

		gb.gridy = 2;
		goalPanel.add(exerciseGoalText, gb);
		goalPanel.add(updateEGoalButton, gb);

	}

	public class DataFrame {
		JFrame f;

		DataFrame() {
			f = new JFrame();
			String[] sleepColumns = {"Sleep starts", "Sleep ends", "Sleep Duration", "Goal Completion rate"};
			String[] exerciseColumns = {"Exercise starts", "Exercise ends", "Exercise Duration", "Goal Completion rate"};
			JTable tableSleep = new JTable(selectedUser.toSleepTable(), sleepColumns);
			JTable tableExercise = new JTable(selectedUser.toExerciseData(), exerciseColumns);

			tableSleep.setBounds(30, 40, 200, 300);
			tableExercise.setBounds(30, 40, 200, 300);
			JScrollPane sp1 = new JScrollPane(tableSleep);
			JScrollPane sp2 = new JScrollPane(tableExercise);

			f.add(sp1);
			f.add(sp2);
			f.setSize(300, 400);
			f.setVisible(true);
		}
	}

	//Button listeners
	private class LoginButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			//declarations
			selectedUser = (Person) users.getSelectedItem();
			login();
		}
	}

	private class SignUpListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			buildSignUpPanel();
			add(signUpPanel);
			loginPanel.setVisible(false);
			signUpPanel.setVisible(true);
		}

	}

	private class SignUpDoneListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {


			try {
				String gender = genderInput.getText();
				String name = nameInput.getText();
				double weight = Double.parseDouble(weightInput.getText());
				double height = Double.parseDouble(heightInput.getText());
				int age = Integer.parseInt(ageInput.getText());
				double sleepGoal = Double.parseDouble(sleepGoalInput.getText());
				double exerciseGoal = Double.parseDouble(exerciseGoalInput.getText());
				Person person = new Person(gender, name, weight, height, age, sleepGoal, exerciseGoal);
				DataStorage.saveRecord(person);
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Check your input");
				ex.printStackTrace();
			}

			genderInput.setText("");
			nameInput.setText("");
			weightInput.setText("");
			heightInput.setText("");
			ageInput.setText("");
			sleepGoalInput.setText("");
			exerciseGoalInput.setText("");

			buildLoginPanel();
			signUpPanel.setVisible(false);
			add(loginPanel);
			loginPanel.setVisible(true);
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
			buildRecordPanel(1);
			userPanel.setVisible(false);
			add(timePanel);
			timePanel.setVisible(true);
		}

	}

	private class ExerciseButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			buildRecordPanel(2);
			userPanel.setVisible(false);
			add(timePanel);
			timePanel.setVisible(true);
		}
	}

	private class SubmitButtonListener implements ActionListener {

		int category;

		SubmitButtonListener(int category) { this.category = category; }

		@Override
		public void actionPerformed(ActionEvent e) {

			String startTime = hourStartText.getText() + ":" + minuteStartText.getText();
			String endTime = hourEndText.getText() + ":" + minuteEndText.getText();

			if (startTime.length() == 4) {
				startTime = "0" + startTime;
			}

			if (endTime.length() == 4) {
				endTime = "0" + endTime;
			}

			try {
				if (category == 1) {
					SleepRecord newRecord = new SleepRecord(startTime, endTime);
					selectedUser.addSleepRecord(newRecord);
					JOptionPane.showMessageDialog(null, "New Record: " + newRecord.getDuration());

				} else {
					ExerciseRecord newRecord = new ExerciseRecord(startTime, endTime);
					selectedUser.addExerciseRecord(newRecord);
					JOptionPane.showMessageDialog(null, "New Record: " + newRecord.getDuration());
				}

			} catch (Exception ex) {
				ex.printStackTrace();
				JOptionPane.showMessageDialog(null, "Check Your Input");
			}

			hourStartText.setText("");
			hourEndText.setText("");
			minuteStartText.setText("");
			minuteEndText.setText("");

			buildUserPanel();
			timePanel.setVisible(false);
			add(userPanel);
			userPanel.setVisible(true);

			DataStorage.saveRecord(selectedUser);
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

	private class SleepUpdateListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			double sleepGoal = Double.parseDouble( JOptionPane.showInputDialog("What is your new sleep goal?") );
			selectedUser.setSleepGoal(sleepGoal);
			buildGoalPanel();
			goalPanel.setVisible(false);
			add(goalPanel);
			goalPanel.setVisible(true);
		}
	}

	private class ExerciseUpdateListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			double exerciseGoal = Double.parseDouble( JOptionPane.showInputDialog("What is your new exercise goal?") );
			selectedUser.setExerciseGoal(exerciseGoal);
			buildGoalPanel();
			goalPanel.setVisible(false);
			add(goalPanel);
			goalPanel.setVisible(true);
		}
	}


}
