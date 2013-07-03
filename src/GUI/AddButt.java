package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddButt implements ActionListener{
	
	private int number;
	public AddButt(int addNum){
		this.number=addNum;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("the add button of" +number+"st qeustion is clicked");
		
	}

}