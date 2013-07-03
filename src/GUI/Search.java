package GUI;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.GridLayout;
import java.awt.ScrollPane;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Client.Client;

public class Search extends JFrame{
	JTextField field1;
	JComboBox topicC;
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
	JPanel p31,panel1,panel2,panel3,panel4;
	ScrollPane DisplayScrollPane;
	ExamQuestionManagement exam;
	public Search(){
		component();
	}
	
	public Search(ExamQuestionManagement e){
		this.exam=e;
		component();
		
	}
	public void component() {
		DisplayScrollPane = new ScrollPane();
		setLayout(new GridLayout(5, 1));
		 panel1 = new JPanel();
		 panel2 = new JPanel();
		 panel3 = new JPanel();
		 panel4 = new JPanel();
		add(panel1);
		add(panel2);
		add(panel3);
		add(panel4);
		
		JLabel label1 = new JLabel("Search:");
		field1 = new JTextField(10);
		JButton button1 = new JButton("Search");
		panel1.add(label1);
		panel1.add(field1);
		panel1.add(button1);
		Search1Butt search1Butt = new Search1Butt(this);
		button1.addActionListener(search1Butt);

            
		panel2.setLayout(new GridLayout(4, 4, 1, 3));
		JLabel percentageL = new JLabel("Percentage");
		JTextField percentageC= new JTextField(5);
		panel2.add(percentageL);
		panel2.add(percentageC);
		
		JLabel topicL = new JLabel("Topic");
		topicC = new JComboBox();
		topicC.addItem(null);
		try {
			ArrayList<String> array = Client.getSinlgetonInstence().getService().getClassificationCriteria_topic();
	      //  System.out.println(array.toString());
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
		ActionListener listener1 = new ActionListener(){   
		     public void actionPerformed(ActionEvent e) {   
		          JComboBox com = (JComboBox)e.getSource();   
		          topic = (String)com.getSelectedItem();   
		     }   
		};   
		topicC.addActionListener(listener1);
		panel2.add(topicL);
		panel2.add(topicC);
		
		JLabel skillL= new JLabel("Skill Required");
		JComboBox skillC = new JComboBox();
		skillC.addItem(null);
		try {
			ArrayList<String> array = Client.getSinlgetonInstence().getService().getClassificationCriteria_skillRequired();
	      //  System.out.println(array.toString());
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
		ActionListener listener2 = new ActionListener(){   
		     public void actionPerformed(ActionEvent e) {   
		          JComboBox com = (JComboBox)e.getSource();   
		          skill = (String)com.getSelectedItem();   
		     }   
		};   
		skillC.addActionListener(listener2);
		panel2.add(skillL);
		panel2.add(skillC);
		
		JLabel styleL= new JLabel("Style of question");
		JComboBox styleC = new JComboBox();
		styleC.addItem(null);
		try {
			ArrayList<String> array = Client.getSinlgetonInstence().getService().getClassificationCriteria_style();
	       // System.out.println(array.toString());
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
		ActionListener listener3 = new ActionListener(){   
		     public void actionPerformed(ActionEvent e) {   
		          JComboBox com = (JComboBox)e.getSource();   
		          style = (String)com.getSelectedItem();   
		     }   
		};   
		styleC.addActionListener(listener3);
		panel2.add(styleL);
		panel2.add(styleC);
		
		JLabel openL= new JLabel("Open/closed");
		JComboBox openC = new JComboBox();
		openC.addItem(null);
		openC.addItem("open");
		openC.addItem("closed");
		panel2.add(openL);
		panel2.add(openC);
		
		JLabel degreeL= new JLabel("Degree of difficulty");
		JComboBox degreeC = new JComboBox();
		degreeC.addItem(null);
		try {
			ArrayList<String> array = Client.getSinlgetonInstence().getService().getClassificationCriteria_difficulty();
	       // System.out.println(array.toString());
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
		ActionListener listener5 = new ActionListener(){   
		     public void actionPerformed(ActionEvent e) {   
		          JComboBox com = (JComboBox)e.getSource();   
		          degree= (String)com.getSelectedItem();   
		     }   
		};   
		degreeC.addActionListener(listener5);
		panel2.add(degreeL);
		panel2.add(degreeC);
		
		JLabel externalL= new JLabel("External domain references");
		JComboBox externalC = new JComboBox();
		externalC.addItem(null);
		try {
			ArrayList<String> array = Client.getSinlgetonInstence().getService().getClassificationCriteria_exteranlDomainReferences();
	       // System.out.println(array.toString());
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
		ActionListener listener6 = new ActionListener(){   
		     public void actionPerformed(ActionEvent e) {   
		          JComboBox com = (JComboBox)e.getSource();   
		          exter = (String)com.getSelectedItem();   
		     }   
		};   
		externalC.addActionListener(listener6);
		panel2.add(externalL);
		panel2.add(externalC);
		
		JLabel explicitnessL= new JLabel("Explicitness");
		JComboBox explicitnessC = new JComboBox();
		explicitnessC.addItem(null);
		try {
			ArrayList<String> array = Client.getSinlgetonInstence().getService().getClassificationCriteria_explictness();
	       // System.out.println(array.toString());
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
		ActionListener listener7 = new ActionListener(){   
		     public void actionPerformed(ActionEvent e) {   
		          JComboBox com = (JComboBox)e.getSource();   
		          explic = (String)com.getSelectedItem();   
		     }   
		};   
		explicitnessC.addActionListener(listener7);
		panel2.add(explicitnessL);
		panel2.add(explicitnessC);
		
		JLabel linguisticL= new JLabel("Linguistic complexity");
		JComboBox linguisticC = new JComboBox();
		linguisticC.addItem(null);
		try {
			ArrayList<String> array = Client.getSinlgetonInstence().getService().getClassificationCriteria_linguisticComlexity();
	      //  System.out.println(array.toString());
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
		ActionListener listener8 = new ActionListener(){   
		     public void actionPerformed(ActionEvent e) {   
		          JComboBox com = (JComboBox)e.getSource();   
		          ling = (String)com.getSelectedItem();   
		     }   
		};   
		linguisticC.addActionListener(listener8);
		panel2.add(linguisticL);
		panel2.add(linguisticC);
		
		JLabel conceptualL= new JLabel("Conceptual complexity");
		JComboBox conceptualC = new JComboBox();
		conceptualC.addItem(null);
		try {
			ArrayList<String> array = Client.getSinlgetonInstence().getService().getClassificationCriteria_conceptualComplexity();
	       // System.out.println(array.toString());
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
		ActionListener listener9 = new ActionListener(){   
		     public void actionPerformed(ActionEvent e) {   
		          JComboBox com = (JComboBox)e.getSource();   
		          concp = (String)com.getSelectedItem();   
		     }   
		};   
		conceptualC.addActionListener(listener9);
		panel2.add(conceptualL);
		panel2.add(conceptualC);
		
		JLabel intellectualL= new JLabel("Intellectual complexity");
		JComboBox intellectualC = new JComboBox();
		intellectualC.addItem(null);
		try {
			ArrayList<String> array = Client.getSinlgetonInstence().getService().getClassificationCriteria_intellectualComplexity();
	      //  System.out.println(array.toString());
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
		ActionListener listener10 = new ActionListener(){   
		     public void actionPerformed(ActionEvent e) {   
		          JComboBox com = (JComboBox)e.getSource();   
		          intell = (String)com.getSelectedItem();   
		     }   
		};   
		intellectualC.addActionListener(listener10);
		panel2.add(intellectualL);
		panel2.add(intellectualC);
		
		JLabel lengthL= new JLabel("Code length");
		JComboBox lengthC = new JComboBox();
		lengthC.addItem(null);
		try {
			ArrayList<String> array = Client.getSinlgetonInstence().getService().getClassificationCriteria_codelength();
	     //   System.out.println(array.toString());
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
		ActionListener listener11 = new ActionListener(){   
		     public void actionPerformed(ActionEvent e) {   
		          JComboBox com = (JComboBox)e.getSource();   
		          length = (String)com.getSelectedItem();   
		     }   
		};   
		lengthC.addActionListener(listener11);
		panel2.add(lengthL);
		panel2.add(lengthC);
		
		JButton button2 = new JButton("Search");
		panel3.add(button2);
		Search2Butt search2Butt = new Search2Butt(this);
		button2.addActionListener(search2Butt);
		
	
		panel4.setSize(10, 20);
		panel4.setLayout(new BorderLayout());

		JLabel result = new JLabel("Result");
		panel4.add(result, BorderLayout.NORTH);
		

		pack();
		setVisible(true);
		
	}
	
	public void updateDisplay(ArrayList<Integer> qid){
		
			if(p31!=null){
				DisplayScrollPane.remove(p31);
			}
		
		
		  p31 = new JPanel();
		  GridLayout grid;
		  if(exam ==null){
			   grid = new GridLayout(qid.size()+1,1);
		  }else{
			   grid = new GridLayout(qid.size()+1,2);
		  }
			
			p31.setLayout(grid);
			panel4.add(p31, BorderLayout.CENTER);
			DisplayScrollPane.add(p31);

			add(DisplayScrollPane);
		
		 JButton[] MyQuesButton = new JButton[qid.size()+1];
		 JButton[] MyAddButton = new JButton[qid.size()+1];
		
             if(qid.size()>0){
				for (int i = 0; i < qid.size(); i++) {
				final int questionid = qid.get(i);
				ArrayList<String> qdetail= new ArrayList<String>();
				try {
					qdetail=Client.getSinlgetonInstence().getService().getQuestion(questionid);
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
						
				 if(exam ==null){
					 MyQuesButton[i]= new JButton("QuestionID : "+questionid +" Question : "+ qdetail.get(0) +" Answer : "
								+ qdetail.get(1) +" MarkingGuide : "+ qdetail.get(2));
								p31.add(MyQuesButton[i]);
								
								
								MyQuesButton[i].addActionListener(new java.awt.event.ActionListener() {
							            public void actionPerformed(java.awt.event.ActionEvent evt) {
							                new PageA(questionid);
							            }
							        });
				  }else{
					  MyQuesButton[i]= new JButton("QuestionID : "+questionid +" Question : "+ qdetail.get(0) +" Answer : "
								+ qdetail.get(1) +" MarkingGuide : "+ qdetail.get(2));
								p31.add(MyQuesButton[i]);
								
								
								MyQuesButton[i].addActionListener(new java.awt.event.ActionListener() {
							            public void actionPerformed(java.awt.event.ActionEvent evt) {
							                new PageA(questionid);
							            }
							        });
								
					  MyAddButton[i]= new JButton("+");
						p31.add(MyAddButton[i]);

						MyAddButton[i].addActionListener(new java.awt.event.ActionListener() {
				            public void actionPerformed(java.awt.event.ActionEvent evt) {
				               if(!exam.addOneQuestion(questionid)){
				            	   JOptionPane.showMessageDialog(null, "This question already exists in your paper");
				               }else{
				            	   JOptionPane.showMessageDialog(null, "Successfully added");
				            	   exam.updateDisplay();
				               }
				              
				            }
				        });
				  }
				
				
			}

             }else{
            	 p31.add(new JLabel("no result"));
             }
             this.validate();
             this.repaint();
       
	}

}
