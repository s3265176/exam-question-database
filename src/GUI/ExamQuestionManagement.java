package GUI;


import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import java.awt.ScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Scanner;


import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Client.Client;
import javax.swing.filechooser.FileFilter;

public class ExamQuestionManagement extends JFrame {
	
	JTextField enterName;
	File paper;
	JPanel displayPanel = new JPanel();;
	
	ArrayList<Integer> questionList;
	
	ExamQuestionManagement exam;
	public ExamQuestionManagement(){
			exam = this;
			questionList = new ArrayList<Integer>();
		 initComponents();
	}
	
	private void initComponents() {
		setSize(600,600);
		setLayout( new GridLayout(3,1));
		
		
		//topPanel
		JPanel topPanel = new JPanel();
		topPanel.setLayout(new FlowLayout());
		
		JLabel nameLabel = new JLabel();
		nameLabel.setText("Paper Name:");
		nameLabel.setSize(100, 30);
		
		 enterName = new JTextField(30);
		
		JButton createPaper = new JButton("Create");
		
		createPaper.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	            	 paper = new File(enterName.getText()+".txt");
	            	 displayPanel.setVisible(true);
	            }
	        });
		
		
		
		JLabel browseLabel = new JLabel();
		browseLabel.setText("choose a exiting paper:");
		
		JButton browsePaper = new JButton("Browse");
		browsePaper.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	            	JFileChooser chooser = new JFileChooser(".");
	 				JFrame jf = new JFrame("Image Upload");
	 				
	 				//JTextField filePath = new JTextField(26);
	 				chooser.setAcceptAllFileFilterUsed(false); 
	 				
	 		     	//	fillListModel();
	 				//filePath.setEditable(false);

	 				int result = chooser.showDialog(jf , "Browse and Choose");
	 				
	 				if(result == JFileChooser.APPROVE_OPTION)
	 				{
	 					paper = chooser.getSelectedFile();
	 					 try {
	 						 
	 			            Scanner scanner = new Scanner(paper);
	 			 
	 			            while (scanner.hasNextLine()) {
	 			                String line = scanner.nextLine();
	 			                if(line.contains("****ID")){
	 			                	questionList.add(Integer.parseInt(line.substring(6)));
	 			                }
	 			            }
	 			            scanner.close();
	 			        } catch (FileNotFoundException e) {
	 			            e.printStackTrace();
	 			        }
	 			 
	 					
	 				}
	 				updateDisplay();
	 				displayPanel.setVisible(true);
	            }
	        });
		
		
		topPanel.add(nameLabel);
		topPanel.add(enterName);
		topPanel.add(createPaper);
		topPanel.add(browseLabel);
		topPanel.add(browsePaper);
		
		
		add(topPanel);
		
		//displayPanel
		
		
		ScrollPane scrollPanel = new ScrollPane();
		scrollPanel.add(displayPanel);
		
		displayPanel.setVisible(false);
		
		/*
		for(int i = 0; i <10;i++){
			JButton question = new JButton("Qeustion "+ i);
			question.addActionListener(new QuesButt(i));
			
			JButton add = new JButton("-");
			displayPanel.add(question);
			displayPanel.add(add);
			
		}
		**/
		
		displayPanel.add(new JLabel("______________________________________________ "));
		JButton addButton =new JButton("+");
		addButton.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                new Search(exam);
	            }
	        });
		
		displayPanel.add(addButton);
		
		
		
		add(scrollPanel);
		
		//bottomPanel
		JPanel bottomPanel = new JPanel();
		
		JButton export = new JButton("Export");
		export.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	 try {
					paper.createNewFile();
					JOptionPane.showMessageDialog(null, "the file is saved at "+paper.getAbsolutePath());
					PrintWriter pw = new PrintWriter(new
							 BufferedWriter(new FileWriter (paper)));
					
					for(Integer id : questionList){
						try {
							ArrayList<String> result = Client.getSinlgetonInstence().getService().getQuestion(id);
							
							//the format of the text file of a exam paper
							// ****ID as a marker is important
							//when import a file to the system that is a header of each question
							pw.println("****ID"+id);
							pw.println("\nQuestion:\n"+result.get(0));
							pw.println("\nAnswer:\n"+result.get(1));
							pw.println("\nMarking Guide:\n"+result.get(2));
							pw.println("\n\n");
							
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					}
					
					pw.close();
					
					
					
				} catch (IOException e) {
					
					e.printStackTrace();
				}
            	 
            	
            	 try {
            		Runtime runtime = Runtime.getRuntime();
					runtime.exec("notepad.exe "+paper.getAbsolutePath());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });
		
		JButton autoGener = new JButton("auto generate");
		
		autoGener.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                new AutoGener(exam);
	            }
	        });
		
		bottomPanel.add(export);
		bottomPanel.add(autoGener);
		add(bottomPanel);
		
		//set Visible
		setVisible(true);
		
	}
	
	public boolean addOneQuestion(int questionID){
		boolean addAble = true;
		if(questionList.contains(questionID)){
			addAble=false;
		}else{
		questionList.add(questionID);
		}
		return addAble;
	}
	
	public void addQeustions(ArrayList<Integer> ids){
		for(Integer i :ids){
			questionList.add(i);
		}
	}
	
	public void updateDisplay(){
		displayPanel.removeAll();
		displayPanel.setLayout(new GridLayout(questionList.size()+1,2));
		
		for(int i = 0; i <questionList.size();i++){
		
			final int L = i;
			ArrayList<String> qdetail= new ArrayList<String>();
			try {
				qdetail=Client.getSinlgetonInstence().getService().getQuestion(questionList.get(i));
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			JButton question = new JButton("QuestionID : "+questionList.get(i) +" Question : "+ qdetail.get(0) +" Answer : "
					+ qdetail.get(1) +" MarkingGuide : "+ qdetail.get(2));
			question.addActionListener(new QuesButt(questionList.get(i)));
			
			JButton edit = new JButton("-");
			edit.addActionListener(new java.awt.event.ActionListener() {
		            public void actionPerformed(java.awt.event.ActionEvent evt) {
		                questionList.remove(L);
		                updateDisplay();
		            }
		        });
			displayPanel.add(question);
			displayPanel.add(edit);
			
		
			
	}
		
		
		displayPanel.add(new JLabel("______________________________________________ "));
		JButton addButton =new JButton("+");
		addButton.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                new Search(exam);
	            }
	        });
		
		displayPanel.add(addButton);
		
		
		validate();
		repaint();
		

}
	public void windowClosing(WindowEvent e){
		setVisible(false);
	}
}