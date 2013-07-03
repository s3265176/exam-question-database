package GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.swing.*;

import Client.Client;

public class PageA extends JFrame {
	JFrame f;
	TextArea myComments;
	int thisQuestionID;
	JPanel p1,p2,p3;
	
	addClassificationToComment actc;
	String[] classification;
	public PageA(int questionID) {
		this.thisQuestionID=questionID;
		classification =Client.getSinlgetonInstence().getClassification();
		f = new JFrame("PageA");
		
		f.setLayout(new GridLayout(3,1));
		
		ScrollPane mysScroll=new ScrollPane();
		 p1=new JPanel();
		 p2=new JPanel();
		 p3=new JPanel();
		
		
		p1.setLayout(new GridLayout(1,2));
		JPanel p11=new JPanel();
		JPanel p12=new JPanel();
		p1.add(p11);
		p1.add(p12);
		
		p11.setLayout(new GridLayout(3,1));
		TextArea question=new TextArea("Question",1,1,1);
		TextArea answer=new TextArea("Answer",1,1,1);
		TextArea marking=new TextArea("Marking",1,1,1);
		
		ArrayList<String> data = new ArrayList<String>();
		//get question information from database
		try {
			data =Client.getSinlgetonInstence().getService().getQuestion(questionID);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		question.setText(data.get(0));
		answer.setText(data.get(1));
		marking.setText(data.get(2));
		
		
		p11.add(question);
		p11.add(answer);
		p11.add(marking);
		
		p12.setLayout(new GridLayout(3,2));
		ArrayList<String> cla = new ArrayList<String>();
		try {
			cla = Client.getSinlgetonInstence().getService().getClassification(
						Client.getSinlgetonInstence().getService().cid(questionID)
						);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i=0;i<classification.length;i++){
			p12.add(new JLabel(classification[i]+": "+cla.get(i)));
			
		}
		
		displayComments();
		
		
		GridBagLayout gridbag = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		p3.setLayout(gridbag);
		
		c.gridx=0;
		c.gridy=0;
		c.gridheight = 1;
		c.gridwidth = 1;
		c.fill = GridBagConstraints.NONE;
		 myComments=new TextArea("My comments");
		gridbag.setConstraints(myComments, c);
		p3.add(myComments);
		
		c.gridx=1;
		c.gridy=0;
		c.gridheight = 1;
		c.gridwidth = 1;
		JButton myButton=new JButton("attach a classification");
		myButton.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	            	actc=new addClassificationToComment();
	            }
	        });
		gridbag.setConstraints(myButton, c);
		p3.add(myButton);
		
		c.gridx=0;
		c.gridy=1;
		c.gridheight = 1;
		c.gridwidth = 2;
		JButton post=new JButton("Post");
		
		post.addActionListener(new ActionListener()
        {
           public void actionPerformed(ActionEvent e)
           {
        	   
        	   if(actc!=null ){
        		   	if(actc.getCid()!=0){
	        		   	 String text = myComments.getText();
		        		   int commentID;
		             	  try {
		     				 commentID =Client.getSinlgetonInstence().getService().addComment(Client.getSinlgetonInstence().getUsername(), thisQuestionID, text);
		     				Client.getSinlgetonInstence().getService().addClassificationTOComment(commentID,actc.getCid());
		     				updateDisplay();
		     			} catch (RemoteException e1) {
		     				// TODO Auto-generated catch block
		     				e1.printStackTrace();
		     			} catch (Exception e1) {
		     				// TODO Auto-generated catch block
		     				e1.printStackTrace();
		     			}
        		   		
        		   	}
		        		  
        		   
        	   }else{
		        		   String text = myComments.getText();
		             	  try {
		     				Client.getSinlgetonInstence().getService().addComment(Client.getSinlgetonInstence().getUsername(), thisQuestionID, text);
		     				updateDisplay();
		     			} catch (RemoteException e1) {
		     				// TODO Auto-generated catch block
		     				e1.printStackTrace();
		     			} catch (Exception e1) {
		     				// TODO Auto-generated catch block
		     				e1.printStackTrace();
		     			}
		        		   
        	   }
        	   
        	 
        	  
        	  
        	  
        	  
           }

		
            });
		
		
		
		gridbag.setConstraints(post, c);
		p3.add(post);
		
		mysScroll.add(p2);
		f.add(p1);
		f.add(mysScroll);
		f.add(p3);
		f.pack();
		f.setVisible(true);
		
	}
	public void windowClosing(WindowEvent e){
		f.setVisible(false);
	}
	private void updateDisplay() {
		p2.removeAll();
		ArrayList<Integer> commentID = new ArrayList<Integer>();
		ArrayList<String> comments = new ArrayList<String>();
		ArrayList<String> userID = new ArrayList<String>();
		ArrayList<String> classificationID = new ArrayList<String>();
		
		try {
			commentID=Client.getSinlgetonInstence().getService().getAllComments(thisQuestionID);
			for(Integer i :commentID){
				ArrayList<String> comment =Client.getSinlgetonInstence().getService().getComment(i);

				comments.add(comment.get(4));
				userID.add(comment.get(1));
				classificationID.add(comment.get(3));
			}
			
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		int num=comments.size();
		if(num!=0){
			p2.setLayout(new GridLayout(num,2));
			for(int i=0;i<num;i++){
				ArrayList<String> userInfo = null;
				try {
					userInfo =Client.getSinlgetonInstence().getService().getuserinfoById(userID.get(i));
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				
				if(classificationID.get(i)!=null ){
					if(!classificationID.get(i).equals("")){
						final int cid = Integer.parseInt(classificationID.get(i));
						JButton b = new JButton(comments.get(i));
						 b.addActionListener(new java.awt.event.ActionListener() {
					            public void actionPerformed(java.awt.event.ActionEvent evt) {
					                new DisplayClassfication(cid);
					            }
					        });
						 p2.add(b);
					}
					
				}else{
					p2.add(new JLabel(comments.get(i)));		
				}
				
				String nameAndUni = userInfo.get(2)+" "+userInfo.get(3)+" from "+userInfo.get(8);
				p2.add(new Label(nameAndUni));
			}
		}else{
			p2.add(new JLabel("this question has no comments yet"));
		}
		f.validate();
		f.repaint();
		
	}
	private void displayComments(){
		ArrayList<Integer> commentID = new ArrayList<Integer>();
		ArrayList<String> comments = new ArrayList<String>();
		ArrayList<String> userID = new ArrayList<String>();
		ArrayList<String> classificationID = new ArrayList<String>();
		
		try {
			commentID=Client.getSinlgetonInstence().getService().getAllComments(thisQuestionID);
			for(Integer i :commentID){
				ArrayList<String> comment =Client.getSinlgetonInstence().getService().getComment(i);
				
				comments.add(comment.get(4));
				userID.add(comment.get(1));
				classificationID.add(comment.get(3));
			}
			
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		int num=comments.size();
		if(num!=0){
			p2.setLayout(new GridLayout(num,2));
			for(int i=0;i<num;i++){
				ArrayList<String> userInfo = null;
				try {
					userInfo =Client.getSinlgetonInstence().getService().getuserinfoById(userID.get(i));
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				
				String id = classificationID.get(i);
				if(id!=null){
					 if(!id.equals("")){
						 JButton b = new JButton(comments.get(i));
						 final int cid = Integer.parseInt(classificationID.get(i));
						 b.addActionListener(new java.awt.event.ActionListener() {
					            public void actionPerformed(java.awt.event.ActionEvent evt) {
					                new DisplayClassfication(cid);
					            }
					        });
							p2.add(b);	
					 }
					
				}else{
					
					p2.add(new JLabel(comments.get(i)));	
				}
					
				String nameAndUni = userInfo.get(2)+" "+userInfo.get(3)+" from "+userInfo.get(8);
				p2.add(new Label(nameAndUni));
			}
		}else{
			p2.add(new JLabel("this question has no comments yet"));
		}
	}
}
