package Interface;


import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;


import java.sql.SQLException;

public interface ServicesInterface extends Remote  {

	boolean isAvaliable() throws RemoteException;
	// a test method
	// can be used to test if server is on
	
	int login(String username, String password) throws RemoteException, Exception;
	// return type int indicate the error type that may exit
	// for example: if log in succeed then return 0
	//				if any error happens return 1-5 respectively 
	// 
	//* the same rule also applies to other method with return type int*.
	
	int register(String username, String password, String email, String university) throws RemoteException, Exception;
	// all information in register is mandatory, since the data field in database is set to be "not null"
	// if the set of mandatory input needs adjustment, then the database need to be adjusted accordingly 
	
	
	int retrivePassword(String username, String email)throws RemoteException;
	// do not return the actually password if self,  just return a indicator to tell if email address is matched or not, or there is any error 
	
	int resetPassword(String username, String newPassword)throws RemoteException, Exception;
	//overwrite the exit password
	
	
	
	int uploadClassification(String percentage_mark,String topic ,String skill_required ,String style_of_question ,String open ,String difficulty ,String external_domain_references ,String explicitness ,String linguistic_complexity ,String conceptual_complexity ,String intellectual_complexity ,String code_legth )throws RemoteException, Exception;
	// upload classification it self and return a classification id.
	//
	//due to database table structure limitation, the process of upload a question with classification
	//is actually 1. uploadClassification() return a classificationID
	//			  2. uploadQuestion()
	//            3. addClassificationTOQuestion()
	
	//upload question with every thing, or with only question or with question and answer
	int addQuestion(String username,String question, String answer, String markingguide)throws RemoteException, Exception;

	int addComment(String username, int questionID, String comment) throws RemoteException, Exception;
	//up load a comment it self and return a commentID
	//
	int addpic(int questionID,byte[] is,int length) throws RemoteException, Exception ;
	//due to database table structure limitation, the process of upload a comment with classification
	//is actually 1. uploadClassification() return a classificationID
	//			  2. uploadComment()
	//            3. addClassificationTOComment()

	// put a link between classification and question,  & classification and comment 
	int addClassificationTOQuestion(int questionID, int classificationID) throws RemoteException, Exception;
	int addClassificationTOComment(int CommmentID, int classificationID) throws RemoteException, Exception;
	//覆盖修改数据
	//over write the exiting user table with those information.
	// use "null" in the method is user input is not specified
	int editUserProfile(String username, String firstname ,String lastname ,String address ,int phone_number ,int Year_of_teaching ,String school ,String department ,String background ,String gender ) throws RemoteException, Exception;
	int editClassification(int classificationID,String percentage_mark,String topic ,String skill_required ,String style_of_question ,String open ,String difficulty ,String external_domain_references ,String explicitness ,String linguistic_complexity ,String conceptual_complexity ,String intellectual_complexity ,String code_legth )throws RemoteException, Exception;
	
	int editQuestion(int questionID,String question, String answer, String markingguide)throws RemoteException, Exception ;
    int editQuestionpic(int questionID, byte[] is,int length)throws RemoteException, Exception ;
	int editComment(int commenetID, String comment) throws RemoteException, Exception;
	//修改数据
	ArrayList<Integer> search(String context) throws RemoteException, Exception;
	//search without any criteria
	//return a list of QuestionIDs
	
	ArrayList<Integer> advanceSearch(String context,String percentage_mark,String topic ,String skill_required ,String style_of_question ,String open ,String difficulty ,String external_domain_references ,String explicitness ,String linguistic_complexity ,String conceptual_complexity ,String intellectual_complexity ,String codelegth ) throws RemoteException, Exception;
	//searching criteria must in this order, it is the same as the order in real database, if one criteria is not specified by user then use "null" in this method
	// return a arraylist of QuestionIDs
	
	ArrayList<String> getQuestion(int questionID) throws RemoteException, Exception;
	// get question content from a questionID
	// question =arrayList.get(0) 
	// answer =arrayList.get(1) 
	// markingGuide =arrayList.get(2) 
	// classificationID =arrayList.get(3)
	// picture =arrayList.get(4) 
	byte[] getQuestionpic(int questionID) throws RemoteException, Exception;
	ArrayList<String> getClassification(int classificationID) throws RemoteException, Exception;
	// get classification content from a classificationID
		// percentage_mark  =arrayList.get(0) 
		// topic  =arrayList.get(1) 
		// skill_required  =arrayList.get(2) 
		// style_of_question  =arrayList.get(3)
		// open  =arrayList.get(4) 
		// difficulty 
		// external_domain_references 
		// explicitness 
		// linguistic_complexity 
		// conceptual_complexity 
		// intellectual_complexity 
		// code_legth 
	
	ArrayList<Integer>getMyQuestions(String username)throws RemoteException, Exception;
	//get all questionID with one username
	
	ArrayList<Integer> getAllComments(int questionID)throws RemoteException, Exception;
	//get all commentID with one questionID
	
	ArrayList<String> getComment(int commmentID)throws RemoteException, Exception;
	// get comment content with a commentID
	//0 comment ID
	//1 U id
	//2 Q id
	//3 C id
	//4 comment
	
	
	
	Integer cid(int questionid)throws RemoteException, Exception;
	//通过questionid返回一个classificationid
	ArrayList<String>getuserinfo(String username)throws RemoteException, Exception;
	ArrayList<String>getuserinfoById(String userID)throws RemoteException, Exception;
	
	//* the last part refers to "Tables support Classification scheme" in the database *
	//return example for getClassificationCriteria_skillRequired(): 
	//		arraylist.get(0)="knowledge recall "
    //	    arraylist.get(1)="trace code "
    //	    arraylist.get(2)="explain code "	
    //	    arraylist.get(3)="write code "
    //	    arraylist.get(4)="modify code "	
    //	    arraylist.get(5)="debug code "	
	// 		......
	//      (refer to page 1 of ExamQuestionClassificationScheme2012Mar19.pdf)
	ArrayList<String> getClassificationCriteria_skillRequired()throws RemoteException, Exception;
	ArrayList<String> getClassificationCriteria_style()throws RemoteException, Exception;
	ArrayList<String> getClassificationCriteria_topic()throws RemoteException, Exception;
	ArrayList<String> getClassificationCriteria_linguisticComlexity()throws RemoteException, Exception;
	ArrayList<String> getClassificationCriteria_intellectualComplexity()throws RemoteException, Exception;
	ArrayList<String> getClassificationCriteria_exteranlDomainReferences()throws RemoteException, Exception;
	ArrayList<String> getClassificationCriteria_explictness()throws RemoteException, Exception;
	ArrayList<String> getClassificationCriteria_difficulty()throws RemoteException, Exception;
	ArrayList<String> getClassificationCriteria_conceptualComplexity()throws RemoteException, Exception;
	ArrayList<String> getClassificationCriteria_codelength()throws RemoteException, SQLException;
	
	
}
