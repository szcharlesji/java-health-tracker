package com.project;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame {
	private final int WIDTH = 310;    //window width
	private final int HEIGHT = 200;    //window height
	//fields
	private JLabel usernameLabel;        //reference to a label object
	private JLabel passwordLabel;
	private JTextField usernameText;        //reference to a text field object
	private JTextField passwordText;        //reference to a text field object
	private JButton loginButton;    //reference to a button object
	private JPanel loginPanel;        //reference to aPanel object
	private JButton EatingButton;        //reference to a text field object
	private JButton ExerciseButton;
	private JButton SleepButton;
	private JPanel userPanel;


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

		usernameLabel = new JLabel("Username");
		passwordLabel = new JLabel("Password");


		//create text fields

		usernameText = new JTextField(10);
		passwordText = new JTextField(10);


		//create a button

		loginButton = new JButton("Login");

		//add an action listener to the button

		LoginButtonListener loginListener = new LoginButtonListener();
		loginButton.addActionListener(loginListener);


		//create the Panel

		loginPanel = new JPanel();

		//add all components to the loginPanel

		loginPanel.add(usernameLabel);
		loginPanel.add(usernameText);
		loginPanel.add(passwordLabel);
		loginPanel.add(passwordText);
		loginPanel.add(loginButton);
	}

	private void login(String user) {
		JOptionPane.showMessageDialog(null, "Login Successful, Welcome " + user);
		remove(loginPanel);
		builduserPanel(user);
		add(userPanel);


		setVisible(true);
	}

	private void builduserPanel(String user) {
		setTitle("HealthTracker");

		//create a button

		SleepButton = new JButton("com.project.Record Sleep");
		ExerciseButton = new JButton("com.project.Record Exercise");
		EatingButton = new JButton("com.project.Record Nutrition");
		//add an action listener to the button

		SleepButtonListener sleepListener = new SleepButtonListener();
		SleepButton.addActionListener(sleepListener);

		EatingButtonListener eatingListener = new EatingButtonListener();
		EatingButton.addActionListener(eatingListener);

		ExerciseButtonListener exerciseListener = new ExerciseButtonListener();
		ExerciseButton.addActionListener(exerciseListener);


		//create the Panel

		userPanel = new JPanel();

		//add all components to the loginPanel


		userPanel.add(SleepButton);
		userPanel.add(EatingButton);
		userPanel.add(ExerciseButton);


	}

	private class LoginButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			//declarations
			String username_str;
			String password_str;
			String[][] user_pass = new String[5][2];
			final JLabel successLogin = new JLabel("Login Successful");
			final JButton loginOK = new JButton("OK");
			user_pass[0][0] = "bob";
			user_pass[0][1] = "password";


			username_str = usernameText.getText();
			password_str = passwordText.getText();
			username_str = username_str.toLowerCase();
			boolean loggedIn = false;
			for (int i = 0; i < user_pass.length; i++) {
				if (username_str.equals(user_pass[i][0]) && password_str.equals(user_pass[i][1])) {
					login(user_pass[i][0]);
					loggedIn = true;
				}
			}
			if (loggedIn == false) {
				JOptionPane.showMessageDialog(null, "Wrong username/password");
			}


		}
	}

	private class SleepButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

		}

	}

	private class EatingButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

		}

	}

	private class ExerciseButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

		}

	}


}
