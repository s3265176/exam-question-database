package GUI;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.lang.reflect.Array;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Client.Client;

public class UserEdit extends JFrame{
	ArrayList<String> array;
	public UserEdit(final ArrayList<String> array){
		this.array=array;
		setLayout(new GridLayout(1, 2));
		JPanel p1= new JPanel();
		p1.setLayout((new GridLayout(14, 1)));
	//	JLabel useNameL = new JLabel("User Name");
	//	JLabel passWordL = new JLabel("Password");
		JLabel firstNameL = new JLabel("First Name");
		JLabel secondNameL = new JLabel("Last Name");
	//	JLabel emailL = new JLabel("Email");
		JLabel addressL = new JLabel("Address");
		JLabel phoneL = new JLabel("Phone");
		JLabel yearL = new JLabel("Year Of Teaching");
	//	JLabel univeL = new JLabel("University");
		JLabel schoolL = new JLabel("School");
		JLabel departL = new JLabel("Department");
		JLabel backL = new JLabel("Background");
		JLabel genderL = new JLabel("Gender");
	//	p1.add(useNameL);
	//	p1.add(passWordL);
		p1.add(firstNameL);
		p1.add(secondNameL);
	//	p1.add(emailL);
		p1.add(addressL);
		p1.add(phoneL);
		p1.add(yearL);
	//	p1.add(univeL);
		p1.add(schoolL);
		p1.add(departL);
		p1.add(backL);
		p1.add(genderL);
		
		JPanel p2= new JPanel();
		p2.setLayout(new GridLayout(14, 1));
	//	JTextField useNameF= new JTextField(10);
	//	JTextField passWordF= new JTextField(10);
		final JTextField firstNameF= new JTextField(""+array.get(2));
		final JTextField secondNameF= new JTextField(""+array.get(3));
	//	JTextField emailF= new JTextField(10);
		final JTextField addressF= new JTextField(""+array.get(5));
		final JTextField phoneF= new JTextField(""+array.get(6));
		final JTextField yearF= new JTextField(""+array.get(7));
	//	JTextField univeF= new JTextField(10);
		final JTextField schoolF= new JTextField(""+array.get(9));
		final JTextField departF= new JTextField(""+array.get(10));
		final JTextField backF= new JTextField(""+array.get(11));
		final JTextField genderF= new JTextField(""+array.get(12));
		
		JButton edit =new JButton("edit");
		edit.addActionListener(new ActionListener()
        {
           public void actionPerformed(ActionEvent e)
           {
        	   int ys;
        	   int ph;
        	   String un= array.get(1);
               String fn= firstNameF.getText();
               String ln= secondNameF.getText();
               String add= addressF.getText();
               if(phoneF.getText().equals("null")){
                 ph=0;
               }else{
            	   ph = Integer.parseInt(phoneF.getText());
            	  // ph=0;
               }
               if(yearF.getText().equals("null")){
                   ys=0;
                 }else{
                	 ys= Integer.parseInt(yearF.getText());
                	 //ys=0;
                 }
               
               String sc= schoolF.getText();
               String dp= departF.getText();
               String bk= backF.getText();
               String gen= genderF.getText();
               
               try {
				int callback = Client.getSinlgetonInstence().getService().editUserProfile(un, fn, ln, add, ph, ys, sc, dp, bk, gen);
				if(callback==1){
					JFrame parent = new JFrame();
					JOptionPane.showMessageDialog(parent, "Save changes successfully");
				}
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        	   
           }
            });
		
	//	p2.add(useNameF);
	//	p2.add(passWordF);
		p2.add(firstNameF);
		p2.add(secondNameF);
	//	p2.add(emailF);
		p2.add(addressF);
		p2.add(phoneF);
		p2.add(yearF);
	//	p2.add(univeF);
		p2.add(schoolF);
		p2.add(departF);
		p2.add(backF);
		p2.add(genderF);
		p2.add(edit);
		add(p1);
		add(p2);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		pack();
		setVisible(true);
		 myEvent();
	
		      
		    }
		 private void myEvent()
		   {
		       addWindowListener(new WindowAdapter()
		          {
		            public void windowClosing(WindowEvent e)
		            {
		            	String name= array.get(1);
		            	MainPage mp =new MainPage(name);
		            	mp.userinfo();
		                 //System.out.println("¥∞ÃÂ÷¥––πÿ±’£°");
		           //   System.exit(0);
		            }
		        });

		
		
	}
	


}
