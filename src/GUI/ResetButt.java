package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Client.Client;

public class ResetButt implements ActionListener{
	ResetPass resetPass;
	String username;
	public ResetButt(ResetPass resetPass,String name) {
		this.resetPass = resetPass;
		this.username=name;
	}
   
	public void actionPerformed(ActionEvent e) {
		String newpass = resetPass.newPassF.getText();		
		String repass = resetPass.rePassF.getText();
	//	String username = resetPass.user;
		int callback;
		if(newpass.equals(repass)){
		try {
			callback = Client.getSinlgetonInstence().getService().resetPassword(username, newpass);
			if(callback==1){
				JFrame parent = new JFrame();
				JOptionPane.showMessageDialog(parent, "Fail to change password");
			}else if(callback==2){
				JFrame parent = new JFrame();
				JOptionPane.showMessageDialog(parent, "Change password successfully");
			}

		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		}else{
			JFrame parent = new JFrame();
			JOptionPane.showMessageDialog(parent, "Repasword must be the same as password");
		}
	}

}