package GUI;

import java.awt.GridLayout;
import java.awt.event.WindowEvent;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class addClassificationToComment extends JFrame {
	int cid = 0;
	String[] classification;
	Object[] fields ;
	public addClassificationToComment(){
		classification=Client.Client.getSinlgetonInstence().getClassification();
		fields = new Object[classification.length];
		components();
	}
	
	private void components(){
		JPanel p1 = new JPanel();
		p1.setLayout(new GridLayout(classification.length+2,2));

		JLabel p_Mark=new JLabel("Percentage Mark");
		final JTextField mark = new JTextField(20);
		p1.add(p_Mark);
		p1.add(mark);
		fields[0]=mark;
		
		
		for(int i = 1;i<classification.length;i++){
			p1.add(new JLabel(classification[i]+":"));
			JComboBox j = new JComboBox();
			ArrayList<String> array = Client.Client.getSinlgetonInstence().getClassificationData().get(classification[i]);
			j.addItem(null);
			for(int n=0;n<array.size();n++)	{
				j.addItem(array.get(n));
	        }
			
			fields[i]= j;
			p1.add(j);
			
		}
		
		JButton ok = new JButton("ok");
		  ok.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	            	try {
						cid = Client.Client.getSinlgetonInstence().getService().uploadClassification(
								((JTextField)fields[0]).getText(), (String)((JComboBox)fields[1]).getSelectedItem(),(String)((JComboBox)fields[2]).getSelectedItem(), (String)((JComboBox)fields[3]).getSelectedItem(), (String)((JComboBox)fields[4]).getSelectedItem(),  
								(String)((JComboBox)fields[5]).getSelectedItem(),(String) ((JComboBox)fields[6]).getSelectedItem(), (String)((JComboBox)fields[7]).getSelectedItem(), (String)((JComboBox)fields[8]).getSelectedItem(),(String) ((JComboBox)fields[9]).getSelectedItem(),(String) ((JComboBox)fields[10]).getSelectedItem(),(String) ((JComboBox)fields[11]).getSelectedItem());
					} catch (RemoteException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	            	JOptionPane.showMessageDialog(null, "Classification is added successfully ");
	            	setVisible(false);
	            }
	        });
		
		JButton cancel = new JButton("Cancel");
		 cancel.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	            	setVisible(false);
	            }
	        });
		
		p1.add(ok);
		p1.add(cancel);
		
		add(p1);
		pack();
		
		setVisible(true);
	}

	
	public int getCid(){
		
		return cid;
	}
	
	public void windowClosing(WindowEvent e){
		setVisible(false);
	}
}
