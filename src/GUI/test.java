package GUI;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.nio.channels.Pipe;
import java.util.ArrayList;

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



public class test extends JFrame {
public test() {
	
setLayout(new GridLayout(1, 2));
JPanel p1 = new JPanel();
JPanel p2 = new JPanel();
add(p1);
add(p2);
p1.setLayout(new GridLayout(3,1));
TextArea quesArea= new TextArea ("Question",10,20, TextArea.SCROLLBARS_VERTICAL_ONLY);
TextArea answerArea= new TextArea ("Answer",10,20, TextArea.SCROLLBARS_VERTICAL_ONLY);
TextArea markArea= new TextArea ("Mark",10,20, TextArea.SCROLLBARS_VERTICAL_ONLY);
p1.add(quesArea);
p1.add(answerArea);
p1.add(markArea);



JLabel questionL = new JLabel("Question");
JLabel answerL= new JLabel("Answer");
JLabel markL = new JLabel("Marking");
JCheckBox questionC= new JCheckBox();
JCheckBox answerC= new JCheckBox();
JCheckBox markC= new JCheckBox();
JButton nextButt= new JButton("next");
JButton pciButt= new JButton("Attached a picture");
pciButt.addActionListener(new ActionListener()
{
	public void actionPerformed(ActionEvent event)
	{
		JFileChooser chooser = new JFileChooser(".");
		JFrame jf = new JFrame("图片管理程序");
		JTextField filePath = new JTextField(26);
		ExtensionFileFilter filter = new ExtensionFileFilter();
		//显示文件对话框
		filter.addExtension("jpg");
		filter.addExtension("jpeg");
		filter.addExtension("gif");
		filter.addExtension("png");
		filter.setDescription("图片文件(*.jpg,*.jpeg,*.gif,*.png)");
		chooser.addChoosableFileFilter(filter);
		//禁止“文件类型”下拉列表中显示“所有文件”选项。
		chooser.setAcceptAllFileFilterUsed(false); 
		//---------初始化程序界面---------
	//	fillListModel();
		filePath.setEditable(false);

		int result = chooser.showDialog(jf , "浏览图片文件上传");
		//如果用户选择了APPROVE（赞同）按钮，即打开，保存及其等效按钮
		if(result == JFileChooser.APPROVE_OPTION)
		{
			filePath.setText(chooser.getSelectedFile().getPath());
		}
	}
});

p2.setLayout(new GridLayout(5,2));
p2.add(questionL);
p2.add(questionC);
p2.add(answerL);
p2.add(answerC);
p2.add(markL);
p2.add(markC);
p2.add(pciButt);
p2.add(nextButt);



pack();
setVisible(true);
}
public static void main(String[] args) {
test nUploa2 = new test();
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
}
