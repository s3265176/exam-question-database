package Client;

import GUI.Login;



public class ClientDriver {
	
	public static void main(String args []){
		
		
		//security manager.
		//**Still have problem set User defined client.policy. but it works now**
		//>>solution run configuration >> VM argument >>  -Djava.security.manager -Djava.security.policy=src/Client/client.policy
		//System.setProperty("java.security.policy","java.policy");
		//if (System.getSecurityManager() == null) {
        //    System.setSecurityManager(new SecurityManager());}
		
		new Login();
		
}
}