package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.ArrayList;

public class Search2Butt implements ActionListener{
	
	Search search;
	String usern;
	public Search2Butt(Search search){
		this.search=search;
		this.usern=Client.Client.getSinlgetonInstence().getUsername();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String field= search.field1.getText();
		String per = search.per;
		String topic=search.topic;
		String skill=search.skill;
		String style=search.style;
		String open=search.open;
		String degree=search.degree;
		String exter=search.exter;
		String explic=search.explic;
		String ling=search.ling;
		String concp=search.concp;
		String intell=search.intell;
		String length=search.length;
		ArrayList<Integer> array= new ArrayList<Integer>();
		try {
			array = Client.Client.getSinlgetonInstence().getService().advanceSearch(field, per, topic, skill, style, open, 
					degree, exter, explic, ling, concp, intell, length);
			
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		search.updateDisplay(array);
	}

}
