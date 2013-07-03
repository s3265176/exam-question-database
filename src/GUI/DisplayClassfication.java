package GUI;

import java.awt.GridLayout;
import java.awt.event.WindowEvent;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DisplayClassfication extends JFrame {
	
	int cid;
	String[] classification;
	ArrayList<String> c ;
	
	public DisplayClassfication(int cid){
		classification= Client.Client.getSinlgetonInstence().getClassification();
		this.cid=cid;
		components();
	}
	
	private void components(){
		JPanel p1 = new JPanel();
		p1.setLayout(new GridLayout(classification.length,2));
		c = null;
		classification=Client.Client.getSinlgetonInstence().getClassification();
		
		try {
			c =Client.Client.getSinlgetonInstence().getService().getClassification(cid);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		for(int i = 0;i<classification.length;i++){
			p1.add(new JLabel(classification[i]+":"));
			p1.add((new JLabel(c.get(i))));
		}
		
		setSize(300,600);
		add(p1);
		setVisible(true);
	}
	
	public void windowClosing(WindowEvent e){
		setVisible(false);
	}
}
