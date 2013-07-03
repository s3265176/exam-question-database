package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuesButt implements ActionListener{

	private int number;
	public QuesButt(int questionNum){
		this.number=questionNum;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		new PageA(number);
		
	}

}
