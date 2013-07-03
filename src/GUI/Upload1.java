package GUI;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Client.Client;

public class Upload1 extends JFrame{
	String per;
	String topic;
	String skill;
	String style;
	String open;
	String degree;
	String exter;
	String explic;
	String ling;
	String concp;
	String intell;
	String length;
	public  Upload1(final String username) {
		GridBagLayout gridbag = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		setLayout(gridbag);
		
		//JPanel p1= new JPanel();
		//p1.setLayout(new GridLayout(2, 1));
		JPanel p11 = new JPanel();
		p11.setLayout(new GridLayout(13, 1));
		c.gridx = 0;
		c.gridy = 0;
		c.gridheight = 1;
		c.gridwidth = 1;
		c.weightx = 1.0;
		c.weighty = 1.0;
		c.fill = GridBagConstraints.BOTH;
		gridbag.setConstraints(p11, c);
		add(p11);
		
		JLabel percentageL = new JLabel("Percentage");
		final JTextField percentageC=new JTextField();
		
		//JComboBox percentageC= new JComboBox();
		p11.add(percentageL);
		p11.add(percentageC);
		
		JLabel topicL = new JLabel("Topic");
		JComboBox topicC = new JComboBox();
		topicC.addItem(null);
		try {
			ArrayList<String> array = Client.getSinlgetonInstence().getService().getClassificationCriteria_topic();
	        System.out.println(array.toString());
			for(int i=0;i<array.size();i++)	{
				topicC.addItem(array.get(i));
	        }
		} catch (RemoteException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
//		topicC.addItem("Java");
//		topicC.addItem("Array");
		ActionListener listener1 = new ActionListener(){   
		     public void actionPerformed(ActionEvent e) {   
		          JComboBox com = (JComboBox)e.getSource();   
		          topic = (String)com.getSelectedItem();   
		     }   
		};   
		topicC.addActionListener(listener1);
		p11.add(topicL);
		p11.add(topicC);
		
		JLabel skillL= new JLabel("Skill Required");
		JComboBox skillC = new JComboBox();
		skillC.addItem(null);
		try {
			ArrayList<String> array = Client.getSinlgetonInstence().getService().getClassificationCriteria_skillRequired();
	        System.out.println(array.toString());
			for(int i=0;i<array.size();i++)	{
	        	skillC.addItem(array.get(i));
	        }
		} catch (RemoteException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
//		skillC.addItem("knowledge recall");
//		skillC.addItem("trace code");
//		skillC.addItem("explain code");
//		skillC.addItem("write code");
//		skillC.addItem("modify code");
//		skillC.addItem("debug code");
		ActionListener listener2 = new ActionListener(){   
		     public void actionPerformed(ActionEvent e) {   
		          JComboBox com = (JComboBox)e.getSource();   
		          skill = (String)com.getSelectedItem();   
		     }   
		};   
		skillC.addActionListener(listener2);
		p11.add(skillL);
		p11.add(skillC);

        JLabel styleL= new JLabel("Style of question");
		JComboBox styleC = new JComboBox();
		styleC.addItem(null);
		try {
			ArrayList<String> array = Client.getSinlgetonInstence().getService().getClassificationCriteria_style();
	        System.out.println(array.toString());
			for(int i=0;i<array.size();i++)	{
				styleC.addItem(array.get(i));
	        }
		} catch (RemoteException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
//		styleC.addItem("multiple choice");
//		styleC.addItem("short answer");
//		styleC.addItem("program code");
//		styleC.addItem("Parsons problem");
//		styleC.addItem("graphical representation");
		ActionListener listener3 = new ActionListener(){   
		     public void actionPerformed(ActionEvent e) {   
		          JComboBox com = (JComboBox)e.getSource();   
		          style = (String)com.getSelectedItem();   
		     }   
		};   
		styleC.addActionListener(listener3);
		p11.add(styleL);
		p11.add(styleC);
		
		JLabel openL= new JLabel("Open/closed");
		JComboBox openC = new JComboBox();
		openC.addItem(null);
		openC.addItem("open");
		openC.addItem("closed");
		ActionListener listener4 = new ActionListener(){   
		     public void actionPerformed(ActionEvent e) {   
		          JComboBox com = (JComboBox)e.getSource();   
		          open = (String)com.getSelectedItem();   
		     }   
		};   
		openC.addActionListener(listener4);
		p11.add(openL);
		p11.add(openC);
		
		JLabel degreeL= new JLabel("Degree of difficulty");
		JComboBox degreeC = new JComboBox();
		degreeC.addItem(null);
		try {
			ArrayList<String> array = Client.getSinlgetonInstence().getService().getClassificationCriteria_difficulty();
	        System.out.println(array.toString());
			for(int i=0;i<array.size();i++)	{
				degreeC.addItem(array.get(i));
	        }
		} catch (RemoteException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
//		degreeC.addItem("low");
//		degreeC.addItem("medium");
//		degreeC.addItem("high");
		ActionListener listener5 = new ActionListener(){   
		     public void actionPerformed(ActionEvent e) {   
		          JComboBox com = (JComboBox)e.getSource();   
		          degree= (String)com.getSelectedItem();   
		     }   
		};   
		degreeC.addActionListener(listener5);
		p11.add(degreeL);
		p11.add(degreeC);
		
		
		JLabel externalL= new JLabel("External domain references");
		JComboBox externalC = new JComboBox();
		externalC.addItem(null);
		try {
			ArrayList<String> array = Client.getSinlgetonInstence().getService().getClassificationCriteria_exteranlDomainReferences();
	        System.out.println(array.toString());
			for(int i=0;i<array.size();i++)	{
				externalC.addItem(array.get(i));
	        }
		} catch (RemoteException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
//		externalC.addItem("low");
//		externalC.addItem("medium");
//		externalC.addItem("high");
//		externalC.addItem("specify the external domain");
		ActionListener listener6 = new ActionListener(){   
		     public void actionPerformed(ActionEvent e) {   
		          JComboBox com = (JComboBox)e.getSource();   
		          exter = (String)com.getSelectedItem();   
		     }   
		};   
		externalC.addActionListener(listener6);
		p11.add(externalL);
		p11.add(externalC);
		
		JLabel explicitnessL= new JLabel("Explicitness");
		JComboBox explicitnessC = new JComboBox();
		explicitnessC.addItem(null);
		try {
			ArrayList<String> array = Client.getSinlgetonInstence().getService().getClassificationCriteria_explictness();
	        System.out.println(array.toString());
			for(int i=0;i<array.size();i++)	{
				explicitnessC.addItem(array.get(i));
	        }
		} catch (RemoteException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
//		explicitnessC.addItem("low");
//		explicitnessC.addItem("medium");
//		explicitnessC.addItem("high");
		ActionListener listener7 = new ActionListener(){   
		     public void actionPerformed(ActionEvent e) {   
		          JComboBox com = (JComboBox)e.getSource();   
		          explic = (String)com.getSelectedItem();   
		     }   
		};   
		explicitnessC.addActionListener(listener7);
		p11.add(explicitnessL);
		p11.add(explicitnessC);
		
		JLabel linguisticL= new JLabel("Linguistic complexity");
		JComboBox linguisticC = new JComboBox();
		linguisticC.addItem(null);
		try {
			ArrayList<String> array = Client.getSinlgetonInstence().getService().getClassificationCriteria_linguisticComlexity();
	        System.out.println(array.toString());
			for(int i=0;i<array.size();i++)	{
				linguisticC.addItem(array.get(i));
	        }
		} catch (RemoteException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
//		linguisticC.addItem("low");
//		linguisticC.addItem("medium");
//		linguisticC.addItem("high");
		ActionListener listener8 = new ActionListener(){   
		     public void actionPerformed(ActionEvent e) {   
		          JComboBox com = (JComboBox)e.getSource();   
		          ling = (String)com.getSelectedItem();   
		     }   
		};   
		linguisticC.addActionListener(listener8);
		p11.add(linguisticL);
		p11.add(linguisticC);
		
		JLabel conceptualL= new JLabel("Conceptual complexity");
		JComboBox conceptualC = new JComboBox();
		conceptualC.addItem(null);
		try {
			ArrayList<String> array = Client.getSinlgetonInstence().getService().getClassificationCriteria_conceptualComplexity();
	        System.out.println(array.toString());
			for(int i=0;i<array.size();i++)	{
				conceptualC.addItem(array.get(i));
	        }
		} catch (RemoteException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
//		conceptualC.addItem("low");
//		conceptualC.addItem("medium");
//		conceptualC.addItem("high");
		ActionListener listener9 = new ActionListener(){   
		     public void actionPerformed(ActionEvent e) {   
		          JComboBox com = (JComboBox)e.getSource();   
		          concp = (String)com.getSelectedItem();   
		     }   
		};   
		conceptualC.addActionListener(listener9);
		p11.add(conceptualL);
		p11.add(conceptualC);
		
		JLabel intellectualL= new JLabel("Intellectual complexity");
		JComboBox intellectualC = new JComboBox();
		intellectualC.addItem(null);
		try {
			ArrayList<String> array = Client.getSinlgetonInstence().getService().getClassificationCriteria_intellectualComplexity();
	        System.out.println(array.toString());
			for(int i=0;i<array.size();i++)	{
				intellectualC.addItem(array.get(i));
	        }
		} catch (RemoteException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
//		intellectualC.addItem("knowledge");
//		intellectualC.addItem("comprehension");
//		intellectualC.addItem("application");
//		intellectualC.addItem("analysis");
//		intellectualC.addItem("evaluation");
//		intellectualC.addItem("synthesis");
		ActionListener listener10 = new ActionListener(){   
		     public void actionPerformed(ActionEvent e) {   
		          JComboBox com = (JComboBox)e.getSource();   
		          intell = (String)com.getSelectedItem();   
		     }   
		};   
		intellectualC.addActionListener(listener10);
		p11.add(intellectualL);
		p11.add(intellectualC);
		
		JLabel lengthL= new JLabel("Code length");
		JComboBox lengthC = new JComboBox();
		lengthC.addItem(null);
		try {
			ArrayList<String> array = Client.getSinlgetonInstence().getService().getClassificationCriteria_codelength();
	        System.out.println(array.toString());
			for(int i=0;i<array.size();i++)	{
				lengthC.addItem(array.get(i));
	        }
		} catch (RemoteException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
//		lengthC.addItem("low");
//		lengthC.addItem("medium");
//		lengthC.addItem("high");
//		lengthC.addItem("NA");
		ActionListener listener11 = new ActionListener(){   
		     public void actionPerformed(ActionEvent e) {   
		          JComboBox com = (JComboBox)e.getSource();   
		          length = (String)com.getSelectedItem();   
		     }   
		};   
		lengthC.addActionListener(listener11);
		p11.add(lengthL);
		p11.add(lengthC);
	
		
		JPanel p12= new JPanel();
		c.gridx = 0;
		c.gridy = 1;
		c.gridheight = 1;
		c.gridwidth = 1;
		c.weightx = 1.0;
		c.weighty = 1.0;
		c.fill = GridBagConstraints.BOTH;
		gridbag.setConstraints(p12, c);
		add(p12);

		p12.setLayout(gridbag);
		JButton nextButt= new JButton("next");
		nextButt.addActionListener(new ActionListener()
        {
           public void actionPerformed(ActionEvent e)
           {
        	per = percentageC.getText().toString();
          	//System.out.println(per + topic+ skill + style + open + degree + exter+explic+ling+concp+intell+length);
        	try {
				int classid = Client.getSinlgetonInstence().getService().uploadClassification(per, topic, skill,
						style, open, degree, exter, explic, ling, concp, intell, length);
				Upload2 upl = new Upload2(username,classid);
				setVisible(false);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
           }
            });
		c.gridx = 0;
		c.gridy = 0;
		c.gridheight = 1;
		c.gridwidth = 1;
		c.weightx = 1.0;
		c.weighty = 1.0;
		c.fill = GridBagConstraints.CENTER;
		gridbag.setConstraints(nextButt, c);
		p12.add(nextButt);
	
		pack();
		setVisible(true);
		
		
	}
//	public static void main(String[] args) {
//		Upload1 iUpload1= new Upload1();
//	}

}

