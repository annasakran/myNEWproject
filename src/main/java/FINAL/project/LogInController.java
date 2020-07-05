package FINAL.project;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class LogInController {

	@FXML
	private TextField username;
	@FXML
	private TextField password;
	@FXML
	private Button loginButton;

	static int TriesNumber = 0;

	private Timer timer;
	 

	@FXML
	void PerformLogin(ActionEvent event) throws IOException, InterruptedException {
		System.out.println("1");
		TriesNumber++;
		LogIn.CheckUserNameAndPassword(username.getText(), password.getText());
		System.out.println("12");
		if (getTriesNumber() > 3) {
			timer = new Timer();
			System.out.println("13");
			TimerTask My_task_1 = new TimerTask() {
				@Override
				public void run() {
					try {
						password.setText("");
						username.setText("");
						password.setDisable(true);
						username.setDisable(true);
						loginButton.setDisable(true);
						App.setCenter("Please try again after 10 seconds!");
						Thread.sleep(10000);
						System.out.println("Time is up");
						password.setDisable(false);
						username.setDisable(false);
						loginButton.setDisable(false);
						TriesNumber = 0;
				
					
						
						
					} catch (Exception e) {
						System.out.println("Timer is failed");
					}
				}
			};
			timer.schedule(My_task_1, 1);
		
		}
		
	}

	static public int getTriesNumber() {
		return TriesNumber;
	}

	static public void setTriesNumber(int triesNumber1) {
		TriesNumber = triesNumber1;
	}
}












/*package FINAL.project;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


public class LogInController {

	@FXML
	private TextField username;
	@FXML
	private TextField password;
    @FXML
    private Button loginButton;
	
	private int TriesNumber=0;
	
	private Timer timer; 
	private TimerTask My_task_1 = new TimerTask() {
		@Override
		public void run() {
			try {
				password.setText("");
				username.setText("");
				password.setDisable(true);
				username.setDisable(true);
				loginButton.setDisable(true);
				App.setCenter("Please try again after 1 minute!");	
				Thread.sleep(5000);
				System.out.println("Time is up");
				password.setDisable(false);
				username.setDisable(false);
				loginButton.setDisable(false);
				TriesNumber=0;
				
			}catch (Exception e) {
				System.out.println("Timer is failed");
			}
		}
	};
	

	@FXML
	void PerformLogin(ActionEvent event) throws IOException, InterruptedException {
		App.setUserName(username.getText());
		TriesNumber++;
		String state=LogIn.CheckUserNameAndPassword(username.getText(), password.getText());
		if(getTriesNumber()>3) {

			timer = new Timer();
			timer.schedule(My_task_1, 1);
			
		}
		else if(state=="Empty") App.setCenter("You must insert user name and password to connect"); 
		else if(state=="Username does not exist! , please try again") App.setCenter("Username does not exist! , please try again");
		else if(state=="Incorrect password! , please try again") App.setCenter("Incorrect password! , please try again");

		else if(state=="User is already connected") App.setCenter("User is already connected");

		else if(state=="ItsStudent")
			{
			App.setRoot("studentHomePage");
			App.setUserName(username.getText());

			}
		else if(state=="ItsTeacher") { App.setRoot("teacherHomePage"); App.setUserName(username.getText());}
		else if(state=="ItsPrinciple") {App.setRoot("principleHomePage"); App.setUserName(username.getText());}
	}

	public int getTriesNumber() {
		return this.TriesNumber;
	}

	public void setTriesNumber(int triesNumber) {
		this.TriesNumber = triesNumber;
	}
}
*/