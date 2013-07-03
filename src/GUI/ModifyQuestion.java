package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.Pipe;
import java.rmi.RemoteException;
import java.sql.Blob;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.filechooser.FileFilter;

import GUI.test.ExtensionFileFilter;

 public class ModifyQuestion extends JFrame {
	 String filePath;
	 final static int BUFFER_SIZE = 4096;
	 	public ModifyQuestion (final int qid,final int cid) {
	 		ArrayList<String> arrayquestion= new ArrayList<String>();
	 		setLayout(new GridLayout(1, 3));
	 		JPanel p1 = new JPanel();
	 		JPanel p2 = new JPanel();
	 		JPanel p3 = new JPanel();
	 		add(p1);
	 		add(p2);
	 		add(p3);
	 		
	 		JLabel ques =new JLabel("Question : ");
	 		JLabel answ =new JLabel("Answers : ");
	 		JLabel mark =new JLabel("MarkingGuide : ");
	 		p1.setLayout(new GridLayout(3,1));
	 	    p1.add(ques);
	 	    p1.add(answ);
	 	    p1.add(mark);
	 		
	 		p2.setLayout(new GridLayout(3,1));
	 		 final TextArea quesArea= new TextArea ("",10,20, TextArea.SCROLLBARS_VERTICAL_ONLY);
	 		 final TextArea answerArea= new TextArea ("",10,20, TextArea.SCROLLBARS_VERTICAL_ONLY);
	 		 final TextArea markArea= new TextArea ("",10,20, TextArea.SCROLLBARS_VERTICAL_ONLY);
	 		p2.add(quesArea);
	 		p2.add(answerArea);
	 		p2.add(markArea);
	 		
			final JLabel image = new JLabel();
	 		image.setBorder(BorderFactory.createLineBorder(Color.red));
	 	    try {
				arrayquestion = Client.Client.getSinlgetonInstence().getService().getQuestion(qid);
				byte[] blobimage = Client.Client.getSinlgetonInstence().getService().getQuestionpic(qid);
				String question = arrayquestion.get(0);
				String answer = arrayquestion.get(1);
				String marking = arrayquestion.get(2);
				 quesArea.setText(question);
				 answerArea.setText(answer);
				 markArea.setText(marking);
				 if(blobimage != null){
					 ImageIcon icon = new ImageIcon(blobimage);
					 image.setIcon(icon);
				 }else{
					 image.setText("No picture");
				 }
				
				//	image.setSize(100, 100);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
           

	 		//System.out.println(cid);
	 		JButton pciButt= new JButton("Change Picture");
	 		pciButt.addActionListener(new ActionListener()
	 		{
	 			public void actionPerformed(ActionEvent event)
	 			{
	 				JFileChooser chooser = new JFileChooser(".");
	 				JFrame jf = new JFrame("Image Upload");
	 				
	 				//JTextField filePath = new JTextField(26);
	 				ExtensionFileFilter filter = new ExtensionFileFilter();
	 					 				filter.addExtension("jpg");
	 				filter.addExtension("jpeg");
	 				filter.addExtension("gif");
	 				filter.addExtension("png");
	 				filter.setDescription("ImageFile(*.jpg,*.jpeg,*.gif,*.png)");
	 				chooser.addChoosableFileFilter(filter);
	 			
	 				chooser.setAcceptAllFileFilterUsed(false); 
	 				
	 		     	//	fillListModel();
	 				//filePath.setEditable(false);

	 				int result = chooser.showDialog(jf , "Browse and Choose");
	 				
	 				if(result == JFileChooser.APPROVE_OPTION)
	 				{
	 					filePath = chooser.getSelectedFile().getPath().toString();
	 					ImageIcon icon = new ImageIcon(filePath);
	 					image.setIcon(icon);
	 					
//	 					try {
//							InputStream is = new FileInputStream(f);
//						} catch (FileNotFoundException e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
	 				//	filePath.setText(chooser.getSelectedFile().getPath());
	 				}
	 			}
	 		});
	 		JButton nextButt= new JButton("Save And Next");
			nextButt.addActionListener(new ActionListener()
	        {
	           public void actionPerformed(ActionEvent e)
	           {
	        	  // File f = new File(filePath);
	        	 //  InputStream is =null;
					String str1 = quesArea.getText();
					String str2 = answerArea.getText();
					String str3 = markArea.getText();
					try {
						//is = new FileInputStream(f);
		        		//byte[] data = InputStreamTOByte(is);
						Client.Client.getSinlgetonInstence().getService().editQuestion(qid, str1, str2, str3);
						 if(filePath!=null&&!filePath.trim().equals("")){
							   
							   File f = new File(filePath);
				        	   InputStream is =null;
				        	   is = new FileInputStream(f);
				        	   byte[] data = InputStreamTOByte(is);
							Client.Client.getSinlgetonInstence().getService().addpic(qid, data, (int)f.length());
							}
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
	           ModifyClassification mc = new ModifyClassification(qid,cid);
	           setVisible(false);
	           }
	            });
	 		
	 
	 		p3.setLayout(new GridLayout(2,1));
	 		p3.add(image);
            JPanel button = new JPanel();
            button.add(pciButt,BorderLayout.NORTH);
            button.add(nextButt,BorderLayout.NORTH);
	 		p3.add(button);
	 		
	 		
	 		pack();
	 		setVisible(true);

	 	}     
	 	public class ExtensionFileFilter extends FileFilter
	 	{

	 		private String description = "";
	 		private ArrayList<String> extensions = new ArrayList<String>();
	 		public void addExtension(String extension)
	 		{
	 			if (!extension.startsWith("."))
	 			{
	 				extension = "." + extension;
	 				extensions.add(extension.toLowerCase());
	 			}
	 		}
	 		public void setDescription(String aDescription)
	 		{
	 			description = aDescription;
	 		}
	 		public String getDescription()
	 		{
	 			return description; 
	 		}
	 		public boolean accept(File f)
	 		{
	 			if (f.isDirectory()) return true;
	 			String name = f.getName().toLowerCase();
	 			for (String extension : extensions)
	 			{
	 				if (name.endsWith(extension)) 
	 				{
	 					return true;
	 				}
	 			}
	 			return false;
	 		}
	 	}
	  
	    public static byte[] InputStreamTOByte(InputStream in) throws IOException{  
	         
		      ByteArrayOutputStream outStream = new ByteArrayOutputStream();  
		        byte[] data = new byte[BUFFER_SIZE];  
		        int count = -1;  
		        while((count = in.read(data,0,BUFFER_SIZE)) != -1)  
		             outStream.write(data, 0, count);  
		          
		       data = null;  
		        return outStream.toByteArray();  
		    } 

		}
	 	
	 	


