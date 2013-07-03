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
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.channels.Pipe;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.filechooser.FileFilter;



public class Upload2 extends JFrame  {
	String name;
	String filePath;
	final static int BUFFER_SIZE = 4096;
        public Upload2(final String username,final int classificationid) {
        this.name=username;
		setLayout(new GridLayout(1, 2));
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
		final TextArea quesArea= new TextArea ("Question",10,20, TextArea.SCROLLBARS_VERTICAL_ONLY);
		final TextArea answerArea= new TextArea ("Answer",10,20, TextArea.SCROLLBARS_VERTICAL_ONLY);
		final TextArea markArea= new TextArea ("Mark",10,20, TextArea.SCROLLBARS_VERTICAL_ONLY);
		p2.add(quesArea);
		p2.add(answerArea);
		p2.add(markArea);

		JButton nextButt= new JButton("Save");
		JButton pciButt= new JButton("Attached a picture");
		
		
 		final JLabel image = new JLabel();
 		image.setBorder(BorderFactory.createLineBorder(Color.red));
 		p3.setLayout(new GridLayout(2,1));
 		p3.add(image);
        JPanel button = new JPanel();
        button.add(pciButt,BorderLayout.NORTH);
        button.add(nextButt,BorderLayout.NORTH);
 		p3.add(button);
 		pciButt.addActionListener(new ActionListener()
 		{
 			public void actionPerformed(ActionEvent event)
 			{
 				JFileChooser chooser = new JFileChooser(".");
 				JFrame jf = new JFrame("Image Upload");
 				
 				//JTextField filePath = new JTextField(26);
 				ExtensionFileFilter filter = new ExtensionFileFilter();
 				//显示文件对话框
 				filter.addExtension("jpg");
 				filter.addExtension("jpeg");
 				filter.addExtension("gif");
 				filter.addExtension("png");
 				filter.setDescription("ImageFile(*.jpg,*.jpeg,*.gif,*.png)");
 				chooser.addChoosableFileFilter(filter);
 				//禁止“文件类型”下拉列表中显示“所有文件”选项。
 				chooser.setAcceptAllFileFilterUsed(false); 
 				//---------初始化程序界面---------
 		     	//	fillListModel();
 				//filePath.setEditable(false);

 				int result = chooser.showDialog(jf , "Browse and Choose");
 				//如果用户选择了APPROVE（赞同）按钮，即打开，保存及其等效按钮
 				if(result == JFileChooser.APPROVE_OPTION)
 				{
 					filePath = chooser.getSelectedFile().getPath().toString();
 					ImageIcon icon = new ImageIcon(filePath);
 					image.setIcon(icon);
 					
// 					try {
//						InputStream is = new FileInputStream(f);
//					} catch (FileNotFoundException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
 				//	filePath.setText(chooser.getSelectedFile().getPath());
 				}
 			}
 		});
 		nextButt.addActionListener(new ActionListener()
        {
           public void actionPerformed(ActionEvent e)
           {
        	 
        	   String question = quesArea.getText();
        	   String answer = answerArea.getText();
        	   String markingguide = markArea.getText();
        	try {
        		
				int questionid = Client.Client.getSinlgetonInstence().getService().addQuestion(username, question, answer, markingguide);
				   if(filePath!=null&&!filePath.trim().equals("")){
					   
				   File f = new File(filePath);
	        	   InputStream is =null;
	        	   is = new FileInputStream(f);
	        	   byte[] data = InputStreamTOByte(is);
				Client.Client.getSinlgetonInstence().getService().addpic(questionid, data, (int)f.length());
				}
				int callback = Client.Client.getSinlgetonInstence().getService().addClassificationTOQuestion(questionid, classificationid);
				if(callback==1){
					JOptionPane.showMessageDialog(null, "Upload question successfully");
					setVisible(false);
					new MainPage(Client.Client.getSinlgetonInstence().getUsername());
					
				}else if(callback==0){
					JOptionPane.showMessageDialog(null, "Upload question Faild");
					setVisible(false);
					new MainPage(Client.Client.getSinlgetonInstence().getUsername());
				}
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        	
           }
            });
		
		pack();
		setVisible(true);
		 myEvent();
			
	}     
    
   private void myEvent()
   {
       addWindowListener(new WindowAdapter()//窗口监听
          {
            public void windowClosing(WindowEvent e)
            {
				 MainPage main = new MainPage(name);
				 main.myquestion();

            	main.userinfo();

            }
        });
	}
   public class ExtensionFileFilter extends FileFilter
	{

		private String description = "";
		private ArrayList<String> extensions = new ArrayList<String>();
		//自定义方法，用于添加文件扩展名
		public void addExtension(String extension)
		{
			if (!extension.startsWith("."))
			{
				extension = "." + extension;
				extensions.add(extension.toLowerCase());
			}
		}
		//用于设置该文件过滤器的描述文本
		public void setDescription(String aDescription)
		{
			description = aDescription;
		}
		//继承FileFilter类必须实现的抽象方法，返回该文件过滤器的描述文本
		public String getDescription()
		{
			return description; 
		}
		//继承FileFilter类必须实现的抽象方法，判断该文件过滤器是否接受该文件
		public boolean accept(File f)
		{
			//如果该文件是路径，接受该文件
			if (f.isDirectory()) return true;
			//将文件名转为小写（全部转为小写后比较，用于忽略文件名大小写）
			String name = f.getName().toLowerCase();
			//遍历所有可接受的扩展名，如果扩展名相同，该文件就可接受。
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



