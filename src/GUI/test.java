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
		JFrame jf = new JFrame("ͼƬ�������");
		JTextField filePath = new JTextField(26);
		ExtensionFileFilter filter = new ExtensionFileFilter();
		//��ʾ�ļ��Ի���
		filter.addExtension("jpg");
		filter.addExtension("jpeg");
		filter.addExtension("gif");
		filter.addExtension("png");
		filter.setDescription("ͼƬ�ļ�(*.jpg,*.jpeg,*.gif,*.png)");
		chooser.addChoosableFileFilter(filter);
		//��ֹ���ļ����͡������б�����ʾ�������ļ���ѡ�
		chooser.setAcceptAllFileFilterUsed(false); 
		//---------��ʼ���������---------
	//	fillListModel();
		filePath.setEditable(false);

		int result = chooser.showDialog(jf , "���ͼƬ�ļ��ϴ�");
		//����û�ѡ����APPROVE����ͬ����ť�����򿪣����漰���Ч��ť
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
	//�Զ��巽������������ļ���չ��
	public void addExtension(String extension)
	{
		if (!extension.startsWith("."))
		{
			extension = "." + extension;
			extensions.add(extension.toLowerCase());
		}
	}
	//�������ø��ļ��������������ı�
	public void setDescription(String aDescription)
	{
		description = aDescription;
	}
	//�̳�FileFilter�����ʵ�ֵĳ��󷽷������ظ��ļ��������������ı�
	public String getDescription()
	{
		return description; 
	}
	//�̳�FileFilter�����ʵ�ֵĳ��󷽷����жϸ��ļ��������Ƿ���ܸ��ļ�
	public boolean accept(File f)
	{
		//������ļ���·�������ܸ��ļ�
		if (f.isDirectory()) return true;
		//���ļ���תΪСд��ȫ��תΪСд��Ƚϣ����ں����ļ�����Сд��
		String name = f.getName().toLowerCase();
		//�������пɽ��ܵ���չ���������չ����ͬ�����ļ��Ϳɽ��ܡ�
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
