package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Client.Client;
public class RegiButt implements ActionListener{
	Register register;
	
	public RegiButt(Register register){
		this.register=register;
		
	}

	public void actionPerformed(ActionEvent e) {
		String user =register.user.getText();
		String pass = register.pass.getText();
		String repass = register.repass.getText();
		String email = register.email.getText();
		String school = register.school.getText();
		if(pass.equals(repass)){
		
			try {
				int callback = Client.getSinlgetonInstence().getService().register(user, pass, email,school);
				if(callback==1){
					JFrame parent = new JFrame();
					JOptionPane.showMessageDialog(parent, "This username already exists");
				}else if(callback==2){
					JFrame parent = new JFrame();
					JOptionPane.showMessageDialog(parent, "Register successfully");
				}
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		
		}else{
			JFrame parent = new JFrame();
			JOptionPane.showMessageDialog(parent, "Repassword must be the same as password");
			
		}
	}
	

}

