package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Client.Client;

public class ModifyClassification extends JFrame{
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
	public  ModifyClassification(int qid,final int cid) {
		ArrayList<String> arrayclass = new ArrayList<String>();
		GridBagLayout gridbag = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		setLayout(gridbag);

		JPanel p11 = new JPanel();
		p11.setLayout(new GridLayout(13, 3));
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
		JLabel percentageT= new JLabel();
		percentageT.setBorder(BorderFactory.createLineBorder(Color.blue));
		final JTextField percentageC= new JTextField();
		p11.add(percentageL);
		p11.add(percentageT);
		p11.add(percentageC);
		
		JLabel topicL = new JLabel("Topic");
		JLabel topicT= new JLabel();
		topicT.setBorder(BorderFactory.createLineBorder(Color.blue));
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
		p11.add(topicT);
		p11.add(topicC);
		
		JLabel skillL= new JLabel("Skill Required");
		JComboBox skillC = new JComboBox();
		JLabel skillT= new JLabel();
		skillT.setBorder(BorderFactory.createLineBorder(Color.blue));
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
		p11.add(skillT);
		p11.add(skillC);

        JLabel styleL= new JLabel("Style of question");
		JComboBox styleC = new JComboBox();
		JLabel styleT= new JLabel();
		styleT.setBorder(BorderFactory.createLineBorder(Color.blue));
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
		p11.add(styleT);
		p11.add(styleC);
		
		JLabel openL= new JLabel("Open/closed");
		JComboBox openC = new JComboBox();
		JLabel openT= new JLabel();
		openT.setBorder(BorderFactory.createLineBorder(Color.blue));
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
		p11.add(openT);
		p11.add(openC);
		
		JLabel degreeL= new JLabel("Degree of difficulty");
		JComboBox degreeC = new JComboBox();
		JLabel degreeT= new JLabel();
		degreeT.setBorder(BorderFactory.createLineBorder(Color.blue));
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
		p11.add(degreeT);
		p11.add(degreeC);
		
		JLabel externalL= new JLabel("External domain references");
		JComboBox externalC = new JComboBox();
		JLabel externalT = new JLabel();
		externalT.setBorder(BorderFactory.createLineBorder(Color.blue));
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
		p11.add(externalT);
		p11.add(externalC);
		
		JLabel explicitnessL= new JLabel("Explicitness");
		JComboBox explicitnessC = new JComboBox();
		JLabel explicitnessT= new JLabel();
		explicitnessT.setBorder(BorderFactory.createLineBorder(Color.blue));
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
		p11.add(explicitnessT);
		p11.add(explicitnessC);
		
		JLabel linguisticL= new JLabel("Linguistic complexity");
		JComboBox linguisticC = new JComboBox();
		JLabel linguisticT = new JLabel();
		linguisticT.setBorder(BorderFactory.createLineBorder(Color.blue));
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
		p11.add(linguisticT);
		p11.add(linguisticC);
		
		JLabel conceptualL= new JLabel("Conceptual complexity");
		JComboBox conceptualC = new JComboBox();
		JLabel conceptualT= new JLabel();
		conceptualT.setBorder(BorderFactory.createLineBorder(Color.blue));
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
		p11.add(conceptualT);
		p11.add(conceptualC);
		
		JLabel intellectualL= new JLabel("Intellectual complexity");
		JComboBox intellectualC = new JComboBox();
		JLabel intellectualT= new JLabel();
		intellectualT.setBorder(BorderFactory.createLineBorder(Color.blue));
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
		p11.add(intellectualT);
		p11.add(intellectualC);
		
		JLabel lengthL= new JLabel("Code length");
		JComboBox lengthC = new JComboBox();
		JLabel lengthT= new JLabel();
		lengthT.setBorder(BorderFactory.createLineBorder(Color.blue));
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
		p11.add(lengthT);
		p11.add(lengthC);
		System.out.println(cid);
		try {
			arrayclass = Client.getSinlgetonInstence().getService().getClassification(cid);
			percentageT.setText(arrayclass.get(0));
			topicT.setText(arrayclass.get(1));
			skillT.setText(arrayclass.get(2));
			styleT.setText(arrayclass.get(3));
			openT.setText(arrayclass.get(4));
			degreeT.setText(arrayclass.get(5));
			externalT.setText(arrayclass.get(6));
			explicitnessT.setText(arrayclass.get(7));
			linguisticT.setText(arrayclass.get(8));
			conceptualT.setText(arrayclass.get(9));
			intellectualT.setText(arrayclass.get(10));
			lengthT.setText(arrayclass.get(11));
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	
		
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
		JButton nextButt= new JButton("Save Changes");
		nextButt.addActionListener(new ActionListener()
        {
           public void actionPerformed(ActionEvent e)
           {
        	   per = percentageC.getText().toString();
				try {
					int callback = Client.getSinlgetonInstence().getService().editClassification(cid,
							per, topic, skill,style, open, degree, exter, explic, ling, concp, intell, length);
					if(callback==1){
						

						JOptionPane.showMessageDialog(null, "Upload question successfully");
						  setVisible(false);
					}else if(callback==0){
						

						JOptionPane.showMessageDialog(null, "Upload question Faild");
						  setVisible(false);
					}
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
          // ModifyClassification mc = new ModifyClassification(qid,cid);
           
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


}
