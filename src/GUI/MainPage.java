package GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.swing.*;



import Client.Client;
    
public class MainPage {
	String username;
	ArrayList<String> array= new ArrayList<String>();
	JFrame f;
	GridBagConstraints c;
	GridBagLayout gridbag;
	TextArea userArea;
	
	public MainPage(){}
	public MainPage(final String username){
	this.username=username;
		
		f = new JFrame("Main page");
		 gridbag = new GridBagLayout();
		 c = new GridBagConstraints();
		f.setLayout(gridbag);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
//		try {
//			
//			array = Client.getSinlgetonInstence().getService().getuserinfo(username);
//		} catch (RemoteException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		String userinfo = "User_id : "+array.get(0)+'\n'+"Username : "+array.get(1)+'\n'+ "Firstname : "+array.get(2)+'\n'
//				+"Lastname : "+array.get(3)+'\n'+"Email : "+array.get(4)+'\n'+"Address : "+array.get(5)+'\n'
//				+"Phone_number : "+array.get(6)+'\n'+"Year_of_teaching : "+array.get(7)+'\n'+"University : "+array.get(8)+'\n'
//				+"School : "+array.get(9)+'\n'+"Department : "+array.get(10)+'\n'+"Background : "+array.get(11)+'\n'+"Gender : "+array.get(12)+'\n';
						
		// uesr infor panel
		c.gridx = 0;
		c.gridy = 0;
		c.gridheight = 1;
		c.gridwidth = 1;
		c.weightx = 1.0;
		c.weighty = 7.0;
		c.fill = GridBagConstraints.BOTH;
		JPanel p1 = new JPanel();
		p1.setLayout(new BorderLayout());
		gridbag.setConstraints(p1, c);
		userArea= new TextArea ("Userinfo",20,20, TextArea.SCROLLBARS_VERTICAL_ONLY);
		String text = userinfo().toString();
		userArea.setText(text);
		userArea.setEditable(false);
		gridbag.setConstraints(userArea, c);
		p1.add(userArea);
		p1.setSize(100, 100);
		f.add(p1);

		
		c.gridx = 0;
		c.gridy = 1;
		c.gridheight = 1;
		c.gridwidth = 1;
		c.weightx = 1.0;
		c.weighty = 1.0;
		c.fill = GridBagConstraints.NONE;
		JPanel edit = new JPanel();
		edit.setLayout(new BorderLayout());
		JButton bt =new JButton("edit");
		edit.add(bt,BorderLayout.SOUTH);
		
		bt.addActionListener(new ActionListener()
		          {
		             public void actionPerformed(ActionEvent e)
		             {
		            	 UserEdit edit = new UserEdit(array);
		            	 f.setVisible(false);
		             }
		              });
		         
		     

		gridbag.setConstraints(edit, c);
		f.add(edit);

		//display recent upload
		recentUpload();

		
		c.gridx = 0;
		c.gridy = 2;
		c.gridheight = 1;
		c.gridwidth = 1;
		c.weightx = 1;
		c.weighty = 0.01;
		JPanel pz1 = new JPanel();
		gridbag.setConstraints(pz1, c);
		f.add(pz1);
		
		c.gridx = 1;
		c.gridy = 2;
		c.gridheight = 1;
		c.gridwidth = 1;
		c.weightx = 1;
		c.weighty =0.01;
		JPanel pz2 = new JPanel();
		gridbag.setConstraints(pz2, c);
		f.add(pz2);
		// 添加占位panel
		c.gridx = 2;
		c.gridy = 2;
		c.gridheight = 1;
		c.gridwidth = 1;
		c.weightx = 1.0;
		c.weighty = 0.01;
		JPanel pz3 = new JPanel();
		gridbag.setConstraints(pz3, c);
		f.add(pz3);
		// 添加占位panel
		c.gridx = 3;
		c.gridy = 2;
		c.gridheight = 1;
		c.gridwidth = 1;
		c.weightx = 1.0;
		c.weighty = 0.01;
		JPanel pz4 = new JPanel();
		gridbag.setConstraints(pz4, c);
		f.add(pz4);

		c.gridx = 1;
		c.gridy = 3;
		c.gridheight = 1;
		c.gridwidth = 2;
		c.weightx = 1;
		c.weighty = 2.0;
		c.fill = GridBagConstraints.NONE;
		JPanel qeustionManagement=new JPanel();
		JButton qeustionManagementB=new JButton("qeustionManagement");
		qeustionManagement.setLayout(new BorderLayout());
		qeustionManagement.add( qeustionManagementB,BorderLayout.CENTER);
		
		qeustionManagementB.addActionListener(new ActionListener()
        {
           public void actionPerformed(ActionEvent e)
           {
        	   ExamQuestionManagement qm = new ExamQuestionManagement();
           }
            });
		gridbag.setConstraints(qeustionManagement, c);
		f.add(qeustionManagement);
		
		c.gridx = 0;
		c.gridy = 3;
		c.gridheight = 1;
		c.gridwidth = 2;
		c.weightx = 1;
		c.weighty = 2.0;
		c.fill = GridBagConstraints.NONE;
		JPanel search=new JPanel();
		JButton sea=new JButton("Search");
		search.setLayout(new BorderLayout());
		search.add( sea,BorderLayout.SOUTH);
		
		sea.addActionListener(new ActionListener()
        {
           public void actionPerformed(ActionEvent e)
           {
        	   Search search = new Search();
           }
            });
		gridbag.setConstraints(search, c);
		f.add(search);
		
		
		c.gridx = 2;
		c.gridy = 3;
		c.gridheight = 1;
		c.gridwidth = 2;
		c.weightx = 1;
		c.weighty = 2.0;
		c.fill = GridBagConstraints.NONE;
		JPanel Upload=new JPanel();
		JButton add = new JButton("Upload");
		Upload.setLayout(new BorderLayout());
		Upload.add( add,BorderLayout.SOUTH);
		add.addActionListener(new ActionListener()
        {
           public void actionPerformed(ActionEvent e)
           {
          	Upload1 upload = new Upload1(username);
          	f.setVisible(false);
          
           }
            });
		gridbag.setConstraints(Upload, c);
		f.add(Upload);
		

		f.pack();
		f.setLocationRelativeTo(null);
		f.setSize(700,500);
		
		f.setVisible(true);
	}
	private void recentUpload() {
		
		// 添加recent upload panel
				c.gridx = 1;
				c.gridy = 0;
				c.gridheight = 2;
				c.gridwidth = 3;
				c.weightx = 1.0;
				c.weighty = 8.0;
				c.gridwidth = GridBagConstraints.REMAINDER;
				c.fill = GridBagConstraints.BOTH;
				//int num =20;
				int num= myquestion().toArray().length;
				JPanel p3 = new JPanel();
				p3.setLayout(new GridLayout(num,2));
				for (int i = 0; i < num; i++) {
					
					ArrayList<String> arrayresult= new ArrayList<String>();
					try {
						arrayresult = Client.getSinlgetonInstence().getService().getQuestion(myquestion().get(i));
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					String questionlist="<html>"+"****Question ID**** : "+myquestion().get(i)+"<br>"+"  ****Question**** : "+
					          arrayresult.get(0)+"<br>"+"  ****Answer**** : "+arrayresult.get(1)+"<br>"+
							"  ****Markingguide**** : "+arrayresult.get(2)+"<br>"+"  ****Classification_id**** : "+arrayresult.get(3)+"</html>"; 
					final Integer qid = myquestion().get(i);
					
					//int cid = ((Integer)arrayresult.get(3)).intValue();
					int ccid = 0;
					try {
						ccid = Client.getSinlgetonInstence().getService().cid(qid);
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					final Integer cid = ccid;
					JButton button = new JButton(questionlist); //questionlist
					button.addActionListener(new ActionListener()
			        {
			           public void actionPerformed(ActionEvent e)
			           {
			          	ModifyQuestion mq = new ModifyQuestion(qid,cid);
			          	//f.setVisible(false);
			           }
			            });
					p3.add(button);
					
					
					final int questionID = myquestion().get(i);
					JButton detail = new JButton("View");
					detail.addActionListener(new ActionListener()
			        {
			           public void actionPerformed(ActionEvent e)
			           {
			        	   new PageA(questionID);
			           }
			            });
					
					p3.add(detail);
					
				}

				
				
			
				  JScrollPane jp=new JScrollPane(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			      jp.setViewportView(p3);
			      gridbag.setConstraints(userArea, c);
				gridbag.setConstraints(jp, c);
			    p3.setPreferredSize(new Dimension(600,num*200));
					  //p3.setPreferredSize(new Dimension(jp.getWidth() - 50, jp.getHeight()*2));
			      p3.revalidate();
			      jp.setSize(600, 800);
			      f.add(jp);
			      
			      f.validate();
			      f.repaint();
		
	}
	public ArrayList<Integer> myquestion(){
		ArrayList<Integer> arrayquestion= new ArrayList<Integer>();
		try {
			arrayquestion = Client.getSinlgetonInstence().getService().getMyQuestions(username);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return arrayquestion;		
	}
	
	public String userinfo(){
         try {
			
			array = Client.getSinlgetonInstence().getService().getuserinfo(username);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String userinfo = "User_id : "+array.get(0)+'\n'+"Username : "+array.get(1)+'\n'+ "Firstname : "+array.get(2)+'\n'
				+"Lastname : "+array.get(3)+'\n'+"Email : "+array.get(4)+'\n'+"Address : "+array.get(5)+'\n'
				+"Phone_number : "+array.get(6)+'\n'+"Year_of_teaching : "+array.get(7)+'\n'+"University : "+array.get(8)+'\n'
				+"School : "+array.get(9)+'\n'+"Department : "+array.get(10)+'\n'+"Background : "+array.get(11)+'\n'+"Gender : "+array.get(12)+'\n';
		return userinfo;	
	}
	
	
	
	}



