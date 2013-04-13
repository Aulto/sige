package sige.gui;

import javax.swing.JFrame;


public class LoginSIGE extends JFrame {
	
	public LoginSIGE() {
		super();
		setSize(350, 150);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Login");
		//setLayout(new Fo)
	}
	
	public static void main(String[] args) {
		LoginSIGE ls = new LoginSIGE();
		ls.setVisible(true);
	}
}
