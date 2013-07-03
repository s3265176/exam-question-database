package Server;

import java.net.MalformedURLException;
import java.rmi.Naming;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;



public class Server {
	//RMI
	String RMIport = "2005";
	//END** RMI
	
	public void init(){
		
		
		
		//initial services for Client. set in up on local RMIRegistry
		try {
			LocateRegistry.createRegistry(Integer.parseInt(RMIport));
			
			Services services = new Services(new Database());

			Naming.rebind("rmi://localhost:"+RMIport+"/Server",services);
			
			System.out.println("RMI is ready");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
		
		
		
	}
	
	

	
	
	
	

}
