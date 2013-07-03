package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Client.Client;

public class SetButt implements ActionListener{
	Setting setting;
	public SetButt(Setting setting) {
		this.setting = setting;
	}
	public SetButt(){
		super();
	}
	public void actionPerformed(ActionEvent e) {
		String address = setting.addField.getText();
		String port = setting.portField.getText();
		String name=setting.SerField.getText();
//		if (System.getSecurityManager() == null) {
//            System.setSecurityManager(new SecurityManager());}
		String url="rmi://"+address+":"+port+"/"+ name;

        Client.getSinlgetonInstence().setRMIRegistryAddress(address); 
        Client.getSinlgetonInstence().setRMIRegistryPort(port);
        Client.getSinlgetonInstence().setRMIUrl(url);
        Client.getSinlgetonInstence().setServicesName(name);
        
		if(Client.getSinlgetonInstence().connect()){
			JFrame parent = new JFrame();
			 
			JOptionPane.showMessageDialog(parent, "Connect Ok");
				
			} else{
				// TODO Auto-generated catch block 
				JFrame parent = new JFrame();
				 
				JOptionPane.showMessageDialog(parent, "Connect Faild");
				//re.printStackTrace();
			}	
		}
	
	}



