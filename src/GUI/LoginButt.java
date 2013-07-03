package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Client.Client;

public class LoginButt implements ActionListener{
	Login login;
	public LoginButt(Login login) {
		this.login=login;
		}
	public LoginButt() {
		super();
		}
	public void actionPerformed(ActionEvent e) {
		String pass = login.passField.getText();
		String user = login.userField.getText();

		try {
			int callback = Client.getSinlgetonInstence().getService().login(user, pass);
			if(callback==0){
				JOptionPane.showMessageDialog(login, "Invalid Username");
			}else if(callback==1){
				JOptionPane.showMessageDialog(login, "Invalid Passowrd");
			}else if(callback==2){
				// save a user name so that all page can access this info;
					Client.getSinlgetonInstence().saveUsername(user);
					Client.getSinlgetonInstence().updateClassificationField();
                    new MainPage(user);
                    login.setVisible(false);
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
		
	}
}
