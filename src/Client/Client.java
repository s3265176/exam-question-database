package Client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;

import Interface.ServicesInterface;

public class Client {
	
	ServicesInterface service;
	private String RMIRegistryAddress;
	private String RMIRegistryPort;
	private String servicesName;
	private String RMIUrl;
	
	private String username;
	private static Client singletonInstance;
	
	private String[] classification={"percentage_mark","open","topic","skill_required","style_of_question","difficulty","external_domain_references","explicitness","linguistic_complexity","conceptual_complexity","intellectual_complexity","code_legth"};
	private HashMap<String,ArrayList<String>> classificationData;
	private Client(){
		
		
	}
	
	public void saveUsername(String name){
		this.username=name;
	}
	
	public String getUsername(){
		return username;
	}
	
//	public Client(String address,String name,String port,String url){
//		this.RMIRegistryAddress=address;
//		this.RMIRegistryPort=port;
//		this.servicesName=name;
//		this.RMIUrl=url;
//	}
//	
	public void setRMIRegistryAddress(String s){
		this.RMIRegistryAddress=s;
		
	}
	
	public void setRMIRegistryPort(String s){
		this.RMIRegistryPort=s;
		
	}
	
	public void setServicesName(String s){
		this.servicesName=s;
		
	}
	public void setRMIUrl(String s){
		this.RMIUrl=s;
		
	}
	public boolean connect(){
		
		boolean isConnected = false;
		
		try {
			 service = (ServicesInterface)Naming.lookup(RMIUrl);
			
			if(service.isAvaliable()){
				isConnected= true;
			}
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return isConnected;
	}
	
	public static Client getSinlgetonInstence(){
		if(singletonInstance==null){
			singletonInstance = new Client();
		}
		
		return singletonInstance;
		
	}
	
	public  ServicesInterface getService(){
		return service;
	}
	
	// get Classification from database once and then can be used for all GUI
	public void updateClassificationField(){
		classificationData = new HashMap<String,ArrayList<String>>();
		try {
			//percentage_mark
			//classificationData.put(classification[0], Client.getSinlgetonInstence().getService().getClassificationCriteria_topic());
			//open
			ArrayList<String> array = new ArrayList<String>();
			array.add("Open");
			array.add("Close");
			classificationData.put(classification[1],array);
			classificationData.put(classification[2], Client.getSinlgetonInstence().getService().getClassificationCriteria_topic());
			classificationData.put(classification[3], Client.getSinlgetonInstence().getService().getClassificationCriteria_skillRequired());
			classificationData.put(classification[4], Client.getSinlgetonInstence().getService().getClassificationCriteria_style());
			classificationData.put(classification[5], Client.getSinlgetonInstence().getService().getClassificationCriteria_difficulty());
			classificationData.put(classification[6], Client.getSinlgetonInstence().getService().getClassificationCriteria_exteranlDomainReferences());
			classificationData.put(classification[7], Client.getSinlgetonInstence().getService().getClassificationCriteria_explictness());
			classificationData.put(classification[8], Client.getSinlgetonInstence().getService().getClassificationCriteria_linguisticComlexity());
			classificationData.put(classification[9], Client.getSinlgetonInstence().getService().getClassificationCriteria_conceptualComplexity());
			classificationData.put(classification[10], Client.getSinlgetonInstence().getService().getClassificationCriteria_intellectualComplexity());
			classificationData.put(classification[11], Client.getSinlgetonInstence().getService().getClassificationCriteria_codelength());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public String[] getClassification() {
		return classification;
	}

	public HashMap<String, ArrayList<String>> getClassificationData() {
		return classificationData;
	}

}
