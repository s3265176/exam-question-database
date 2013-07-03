package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.ArrayList;

public class Search1Butt implements ActionListener {
	Search search ;
	String usern;
	public Search1Butt(Search search) {
		this.search=search;
		this.usern=Client.Client.getSinlgetonInstence().getUsername();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String field= search.field1.getText();
		
		ArrayList<Integer> array= new ArrayList<Integer>();
		try {
			array = Client.Client.getSinlgetonInstence().getService().search(field);
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		search.updateDisplay(array);
		
	//	System.out.println(field);

	}

}
