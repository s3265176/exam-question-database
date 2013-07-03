package Server;


import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

import Interface.ServicesInterface;

@SuppressWarnings("serial")
public class Services extends UnicastRemoteObject implements ServicesInterface {
	
		private Database database;
		private Connection conn;
		Statement st;
		Statement st1;
		Classification c;
	
	public Services(Database database) throws RemoteException {
		
		super();
		this.database = database;
		conn = this.database.connect();
		c = new Classification(conn);
		InitializeDatabase initDB = new InitializeDatabase();
		initDB.init();
		
	}

	
	@Override
	public boolean isAvaliable() throws RemoteException {
		
		return true;
	}


	@Override
	public int login(String username, String password) throws RemoteException, SQLException{
		 int condition=0;
         String sqlcheck = "select Username from user"; 
         	Statement st = (Statement) conn.createStatement();
			ResultSet rs = st.executeQuery(sqlcheck);				
			while(rs.next()){
				if(username.equals((rs.getString(1)))){
					condition = 3;				
			}
			}
				if(condition==3){
                    String sql = "select password from user where username ="+"'"+username+"'"; 
					st = (Statement) conn.createStatement();
				
					ResultSet rs1 = st.executeQuery(sql);
					rs1.first();
					if(password.equals(rs1.getString(1))){
			            condition=2; 
					}else{
						condition=1; 
					}
				}	
				
				st.close();
		return condition;		
	}


	@Override
	public int register(String username, String password, String email,String university) throws RemoteException, SQLException{
		 int condition=0;
         
          String sqlcheck = "select Username from user"; 
			st = (Statement) conn.createStatement();
			ResultSet rs = st.executeQuery(sqlcheck);				
			while(rs.next()){
				if(username.equals(rs.getString(1))){
					condition = 1;					
				}
			}
			
			st.close();
				if(condition==1){
					condition=1;
				}
				else{
					
                  String sql = "INSERT INTO user(Username , Password , Email, University )" + 
		            " VALUES ('"+username+"', "+password+", '"+email+"','"+university+"')"; 
					st1 = (Statement) conn.createStatement();
					st1.executeUpdate(sql);
					st1.close();
					
			        condition=2;
				}
				return condition;
	}


	@Override
	public int retrivePassword(String username, String email)throws RemoteException {
				int condition=0;
				try{
                    String sql = "select email from user where username ="+"'"+username+"'"; 
					st = (Statement) conn.createStatement();
					st.executeQuery(sql);
					ResultSet rs1 = st.executeQuery(sql);
					
					if(rs1.next()){
						if(email.equals(rs1.getString(1))){
							condition=2;
						}else condition=1;
					}else condition = 0;
				st.close();
				}catch(SQLException e){
					e.printStackTrace();
				}
				
				return condition;	
	}


	@Override
	public int resetPassword(String username, String newPassword)throws RemoteException, SQLException {
		int condition=0;
         String sqlcheck = "select Username from user"; 
			st = (Statement) conn.createStatement();
			ResultSet rs = st.executeQuery(sqlcheck);				
			while(rs.next()){
				if(username.equals((rs.getString(1)))){
					condition = 3;			
			}
			}
			
			
			st.close();
				if(condition==3){
					
                    String sql = "update user set password = "+"'"+newPassword+"'"+ "where username = "+"'"+username+"'"; 
					st1 = (Statement) conn.createStatement();
					st1.executeUpdate(sql);

					condition=2;
					
					st1.close();
					
				}
				else{
					condition=1;
				}
		return condition;
	}

	@Override
	public int uploadClassification(String percentage_mark, String topic,
			String skill_required, String style_of_question, String open,
			String difficulty, String external_domain_references,
			String explicitness, String linguistic_complexity,
			String conceptual_complexity, String intellectual_complexity,
			String code_legth) throws RemoteException, SQLException {
		
		 int condition=0;
		    
		 PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement("INSERT INTO classification(Percentage_mark,topic,skill_required,style_of_question,open," +
	           		"difficulty, external_domain_references,explicitness, linguistic_complexity,conceptual_complexity, " +
	           		"intellectual_complexity,code_legth )" + " VALUES (?, ?, ? ,? ,? ,? ,?, ?, ? ,?, ?, ?)");
			pstmt.setString(1, percentage_mark);
			pstmt.setString(2, topic);
			pstmt.setString(3, skill_required);
			pstmt.setString(4, style_of_question);
			pstmt.setString(5, open);
			pstmt.setString(6, difficulty);
			pstmt.setString(7, external_domain_references);
			pstmt.setString(8, explicitness);
			pstmt.setString(9, linguistic_complexity);
			pstmt.setString(10, conceptual_complexity);
			pstmt.setString(11, intellectual_complexity);
			pstmt.setString(12, code_legth);
			
			pstmt.executeUpdate();			
			pstmt.close();
  	
	            String sqlcheck = "select c_id from classification order by c_id asc"; 
				st = (Statement) conn.createStatement();
				ResultSet rs = st.executeQuery(sqlcheck);				
				rs.last();
				condition=rs.getInt(1);
				
				
				st.close();
		return condition;
	}


	@Override
	public int addQuestion(String username, String question, String answer,
			String markingguide) throws RemoteException, SQLException {
		int condition=0;
		int uid = 0;
	
        String sql = "select user_id from user where username ="+"'"+username+"'"; 
		st = (Statement) conn.createStatement();
		st.executeQuery(sql);
		ResultSet rs = st.executeQuery(sql);
		rs.first();
        uid=rs.getInt(1);
		rs.close();
		st.close();
		 
		
		  
		PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement("INSERT INTO question(question,answer,markingguide,user_id)"
		    + " VALUES (?, ? ,?, ?)");
			pstmt.setString(1, question);
			pstmt.setString(2, answer);
			pstmt.setString(3, markingguide);
			pstmt.setInt(4, uid);
			
			pstmt.executeUpdate();			
			pstmt.close();
	            String sqlcheck = "select Question_id from question order by question_id asc"; 
	            Statement st2 = (Statement) conn.createStatement();
				ResultSet rss = st2.executeQuery(sqlcheck);				
				rss.last();
				condition=rss.getInt(1);
				
				rss.close();
				st2.close();
				
				
	return condition;
	}

	@Override
	public int addpic(int questionID, byte[] is,int length)
			throws RemoteException, SQLException {
		int condition=0;
		InputStream   input   = new ByteArrayInputStream(is);     
		PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement("update question set questionpic = ? "+"where question_id=?");
		pstmt.setBinaryStream(1, input, length);
        pstmt.setInt(2,questionID);
		condition=pstmt.executeUpdate();			
		pstmt.close();
		
		return condition;
	}
	
	@Override
	public int addComment(String username, int questionID, String comment)
			throws RemoteException, Exception{
		int condition=0;
		String uid = null;
		
        String sql = "select user_id from user where username ="+"'"+username+"'"; 
		st = (Statement) conn.createStatement();
		st.executeQuery(sql);
		ResultSet rs = st.executeQuery(sql);
		rs.first();
        uid=rs.getString(1);
		rs.close();
		st.close();
		
		PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement("INSERT INTO comments(user_id,question_id,comment)"
		    + " VALUES (?, ? ,?)");
			pstmt.setString(1, uid);
			pstmt.setInt(2, questionID);
			pstmt.setString(3, comment);
			
			pstmt.executeUpdate();			
			pstmt.close();
			
	            String sqlcheck = "select Comment_id from comments order by Comment_id asc"; 
	            Statement st2 = (Statement) conn.createStatement();
				ResultSet rss = st2.executeQuery(sqlcheck);				
				rss.last();
				condition=rss.getInt(1);			
				rss.close();
				st2.close();	
	return condition;
	}


	@Override
	public int addClassificationTOQuestion(int questionID, int classificationID)
			throws RemoteException, SQLException {
		int condition=0;
		
		PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement("update question set classification_id = ? "+"where question_id = ?");
		pstmt.setInt(1, classificationID);
		pstmt.setInt(2, questionID);
		
		condition=pstmt.executeUpdate();			
		pstmt.close();
		
		return condition;
	}


	@Override
	public int addClassificationTOComment(int CommmentID, int classificationID)
			throws RemoteException, SQLException {
		int condition=0;
		
		PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement("update comments set classification_id = ? "+"where comment_id=?");
		pstmt.setInt(1, classificationID);
		pstmt.setInt(2, CommmentID);
		
		condition=pstmt.executeUpdate();			
		pstmt.close();
		return condition;
	}


	@Override
	public int editUserProfile(String username, String firstname,
			String lastname, String address, int phone_number,
			int Year_of_teaching, String school, String department,
			String background, String gender) throws RemoteException, Exception {
		int condition=0;
		
		PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement("update user set firstname = ? , lastname = ? , address = ? ," +
				"phone_number = ?, Year_of_teaching = ?, school = ?, department = ?, background = ?, gender = ? "+"where username = ?");
		pstmt.setString(1, firstname);
		pstmt.setString(2, lastname);
		pstmt.setString(3, address);
		pstmt.setInt(4, phone_number);
		pstmt.setInt(5, Year_of_teaching);
		pstmt.setString(6, school);
		pstmt.setString(7, department);
		pstmt.setString(8, background);
		pstmt.setString(9, gender);
		pstmt.setString(10, username);
		
		condition=pstmt.executeUpdate();			
		pstmt.close();
		
		return condition;
	}


	@Override
	public int editClassification(int classificationID, String percentage_mark,
			String topic, String skill_required, String style_of_question,
			String open, String difficulty, String external_domain_references,
			String explicitness, String linguistic_complexity,
			String conceptual_complexity, String intellectual_complexity,
			String code_legth) throws RemoteException, SQLException {
		int condition=0;
		
		PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement("update Classification set percentage_mark = ? , topic = ? , skill_required = ? ," +
				"style_of_question = ?, open = ?, difficulty = ?, external_domain_references = ?, explicitness = ?, linguistic_complexity = ? ,"+
				"conceptual_complexity = ?, intellectual_complexity = ?, code_legth = ? where c_ID = ?");
		pstmt.setString(1, percentage_mark);
		pstmt.setString(2, topic);
		pstmt.setString(3, skill_required);
		pstmt.setString(4, style_of_question);
		pstmt.setString(5, open);
		pstmt.setString(6, difficulty);
		pstmt.setString(7, external_domain_references);
		pstmt.setString(8, explicitness);
		pstmt.setString(9, linguistic_complexity);
		pstmt.setString(10, conceptual_complexity);
		pstmt.setString(11, intellectual_complexity);
		pstmt.setString(12, code_legth);
		pstmt.setInt(13, classificationID);
		
		condition=pstmt.executeUpdate();			
		pstmt.close();
		return condition;
	}


	@Override
	public int editQuestion(int questionID, String question, String answer,
			String markingguide) throws RemoteException, Exception {
		int condition=0;
		
		PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement("update question set question = ? , answer = ? , markingguide = ? " +"where Question_id = ?");
		pstmt.setString(1, question);
		pstmt.setString(2, answer);
		pstmt.setString(3, markingguide);
		pstmt.setInt(4, questionID);
		condition=pstmt.executeUpdate();			
		pstmt.close();
		return condition;
	}

	@Override
	public int editQuestionpic(int questionID, byte[] is,int length) throws RemoteException, Exception {
		
		int condition=0;
		InputStream   input   = new ByteArrayInputStream(is);     
		
		PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement("update question set questionpic = ? "+"where question_id=?");
		pstmt.setBinaryStream(1, input, length);
        pstmt.setInt(2,questionID);
		
		condition=pstmt.executeUpdate();			
		pstmt.close();
		
		return condition;
	}
	
	@Override
	public int editComment(int commenetID, String comment)
			throws RemoteException, SQLException {
		int condition=0;
		
		PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement("update comments set comment = ? " +"where Comment_id = ?");
		pstmt.setString(1, comment);
		pstmt.setInt(2, commenetID);

		
		condition=pstmt.executeUpdate();			
		pstmt.close();
		
		return condition;
	}


	@Override
	public ArrayList<Integer> search(String context) throws RemoteException, Exception {
		
		ArrayList<Integer> array= new ArrayList<Integer>();
		
		PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement("select question_id from question where question like ? or answer like ? or markingguide like ? ");
		pstmt.setString(1, "%"+context+"%");
		pstmt.setString(2, "%"+context+"%");
		pstmt.setString(3, "%"+context+"%");

		ResultSet rs = pstmt.executeQuery();	
		while(rs.next()){
			array.add(rs.getInt(1));
		}
		rs.close();
		pstmt.close();
		
		return array;

	}


	@Override
	public ArrayList<Integer> advanceSearch(String context,
			String percentage_mark, String topic, String skill_required,
			String style_of_question, String open, String difficulty,
			String external_domain_references, String explicitness,
			String linguistic_complexity, String conceptual_complexity,
			String intellectual_complexity, String codelegth)
			throws RemoteException, SQLException {
		ArrayList<Integer> array= new ArrayList<Integer>();
	    String[] replace = new String[13];
	    replace[0]=context;
	    replace[1]=percentage_mark;
	    replace[2]=topic;
	    replace[3]=skill_required;
	    replace[4]=style_of_question;
	    replace[5]=open;
	    replace[6]=difficulty;
	    replace[7]=external_domain_references;
	    replace[8]=explicitness;
	    replace[9]=linguistic_complexity;
	    replace[10]=conceptual_complexity;
	    replace[11]=intellectual_complexity;
	    replace[12]=codelegth;
       for(int i=0;i<replace.length;i++ ){
    	   if(replace[i]==null){
    		   replace[i]="%%";
    	   }
       }
        
       PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement("select question_id from question,classification " +
		"where question.classification_id=classification.c_id and question like ? and answer like ? and markingguide like ?" 
        +" and percentage_mark like ? and topic like ? and skill_required like ? and" +
        " style_of_question like ? and  open like ? and difficulty like ? and" +
        " external_domain_references like ? and explicitness like ? and linguistic_complexity like ? and " +
        "conceptual_complexity like ? and intellectual_complexity like ? and code_legth like ? ");
		pstmt.setString(1, "%"+replace[0]+"%");
		pstmt.setString(2, "%"+replace[0]+"%");
		pstmt.setString(3, "%"+replace[0]+"%");
		pstmt.setString(4, replace[1]);
		pstmt.setString(5, replace[2]);
		pstmt.setString(6, replace[3]);
		pstmt.setString(7, replace[4]);
		pstmt.setString(8, replace[5]);
		pstmt.setString(9, replace[6]);
		pstmt.setString(10, replace[7]);
		pstmt.setString(11, replace[8]);
		pstmt.setString(12, replace[9]);
		pstmt.setString(13, replace[10]);
		pstmt.setString(14, replace[11]);
		pstmt.setString(15, replace[12]);

		ResultSet rs = pstmt.executeQuery();	
		while(rs.next()){
			array.add(rs.getInt(1));
		}
		rs.close();
		pstmt.close();
		
		return array;
		}

	@Override
	public ArrayList<String> getQuestion(int questionID) throws RemoteException, SQLException {
		ArrayList<String> array= new ArrayList<String>();
		
		PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement("select question,answer,markingguide,Classification_id from question where question_id = ?");
		pstmt.setInt(1, questionID);
		ResultSet rs = pstmt.executeQuery();	
		rs.first();
		array.add(rs.getString(1));
		array.add(rs.getString(2));
		array.add(rs.getString(3));
		array.add(rs.getString(4));
		rs.close();
		pstmt.close();
		return array;

	}


	@Override
	public ArrayList<String> getClassification(int classificationID)
			throws RemoteException, SQLException {
		ArrayList<String> array= new ArrayList<String>();
		
		PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement("select Percentage_mark,Topic,Skill_required," +
						"Style_of_question,Open,Difficulty,External_domain_references," +
						"Explicitness,Linguistic_complexity,Conceptual_complexity,Intellectual_complexity," +
						"Code_legth from classification where c_id = ?");
		pstmt.setInt(1, classificationID);


		ResultSet rs = pstmt.executeQuery();	
		rs.first();
		array.add(rs.getString(1));
		array.add(rs.getString(2));
		array.add(rs.getString(3));
		array.add(rs.getString(4));
		array.add(rs.getString(5));
		array.add(rs.getString(6));
		array.add(rs.getString(7));
		array.add(rs.getString(8));
		array.add(rs.getString(9));
		array.add(rs.getString(10));
		array.add(rs.getString(11));
		array.add(rs.getString(12));
		rs.close();
		pstmt.close();
		
		return array;
	}


	@Override
	public ArrayList<Integer> getMyQuestions(String username)
			throws RemoteException, Exception {
		int uid = 0;
		ArrayList<Integer> array= new ArrayList<Integer>();
		
        String sql = "select user_id from user where username ="+"'"+username+"'"; 
		st = (Statement) conn.createStatement();
		st.executeQuery(sql);
		ResultSet rs = st.executeQuery(sql);
		rs.first();
        uid=rs.getInt(1);
		rs.close();
		st.close();
		
		  
		PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement("select question_id from question where user_id = ?");
			pstmt.setInt(1, uid);
			
			ResultSet rss = pstmt.executeQuery();	
			while(rss.next()){
				array.add(rss.getInt(1));
			}
			rss.close();
			pstmt.close();
			
			
	return array;
	}


	@Override
	public byte[] getQuestionpic(int questionID) throws RemoteException {
		
		try{
		PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement("select questionpic from question where question_id = ?");
		pstmt.setInt(1, questionID);

	    
		ResultSet rs = pstmt.executeQuery();	
		rs.first();
		Blob image = rs.getBlob(1);
		byte[] imagebyte = image.getBytes(1L , (int)image.length());
		rs.close();
		pstmt.close();
		
		return imagebyte;
		}catch(Exception e){
		//	e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public ArrayList<Integer> getAllComments(int questionID)
			throws RemoteException, SQLException {
		ArrayList<Integer> array= new ArrayList<Integer>();
	   
		PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement("select comment_id from comments where question_id = ?");
		pstmt.setInt(1, questionID);
		
		ResultSet rs = pstmt.executeQuery();	
		while(rs.next()){
			array.add(rs.getInt(1));
		}
		rs.close();
		pstmt.close();
	
		
     return array;
	}


	@Override
	public ArrayList<String> getComment(int commmentID) throws RemoteException, SQLException {
		ArrayList<String> comment = new ArrayList<String>();
	    
		PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement("select * from comments where comment_id = ?");
		pstmt.setInt(1, commmentID);
		
		ResultSet rs = pstmt.executeQuery();	
		rs.first();
		comment.add( rs.getString(1));
		comment.add( rs.getString(2));
		comment.add( rs.getString(3));
		comment.add( rs.getString(4));
		comment.add( rs.getString(5));
		
		rs.close();
		pstmt.close();
		
     return comment;
	}
	
	@Override
	public Integer cid(int questionid) throws RemoteException, Exception {
		
		PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement("select Classification_id from question where question_id = ?");
		pstmt.setInt(1, questionid);

	    int cid;
		ResultSet rs = pstmt.executeQuery();	
		rs.first();
		cid = rs.getInt(1);

		rs.close();
		pstmt.close();
		
		return cid;
	}

	@Override
	public ArrayList<String> getuserinfo(String username)
			throws RemoteException, SQLException {
		ArrayList<String> array= new ArrayList<String>();
		
		PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement("select User_id ,Username , Firstname, Lastname, Email," +
						"Address, Phone_number, Year_of_teaching, University, School, Department, Background, Gender " + 
				"from user where username = ?");
		pstmt.setString(1, username);


		ResultSet rs = pstmt.executeQuery();	
		rs.first();
		array.add(rs.getString(1));
		array.add(rs.getString(2));
		array.add(rs.getString(3));
		array.add(rs.getString(4));
		array.add(rs.getString(5));
		array.add(rs.getString(6));
		array.add(rs.getString(7));
		array.add(rs.getString(8));
		array.add(rs.getString(9));
		array.add(rs.getString(10));
		array.add(rs.getString(11));
		array.add(rs.getString(12));
		array.add(rs.getString(13));
		rs.close();
		pstmt.close();
		
		return array;
	}
	public ArrayList<String> getuserinfoById(String userID)
			throws RemoteException, SQLException {
		ArrayList<String> array= new ArrayList<String>();
		
		PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement("select User_id ,Username , Firstname, Lastname, Email," +
						"Address, Phone_number, Year_of_teaching, University, School, Department, Background, Gender " + 
				"from user where user_id = ?");
		pstmt.setString(1, userID);


		ResultSet rs = pstmt.executeQuery();	
		rs.first();
		array.add(rs.getString(1));
		array.add(rs.getString(2));
		array.add(rs.getString(3));
		array.add(rs.getString(4));
		array.add(rs.getString(5));
		array.add(rs.getString(6));
		array.add(rs.getString(7));
		array.add(rs.getString(8));
		array.add(rs.getString(9));
		array.add(rs.getString(10));
		array.add(rs.getString(11));
		array.add(rs.getString(12));
		array.add(rs.getString(13));
		rs.close();
		pstmt.close();
		
		return array;
	}

	@Override
	public ArrayList<String> getClassificationCriteria_skillRequired()
			throws RemoteException, Exception {
		
		
		return c.getClassificationCriteria_skillRequired();
	}


	@Override
	public ArrayList<String> getClassificationCriteria_style()
			throws RemoteException, Exception {
		
		
		return c.getClassificationCriteria_style();
	}


	@Override
	public ArrayList<String> getClassificationCriteria_topic()
			throws RemoteException, Exception {
		
		return c.getClassificationCriteria_topic();
	}


	@Override
	public ArrayList<String> getClassificationCriteria_linguisticComlexity()
			throws RemoteException, Exception {
		
		return c.getClassificationCriteria_linguisticComlexity();
	}


	@Override
	public ArrayList<String> getClassificationCriteria_intellectualComplexity()
			throws RemoteException, Exception {
		
		return c.getClassificationCriteria_intellectualComplexity();
	}


	@Override
	public ArrayList<String> getClassificationCriteria_exteranlDomainReferences()
			throws RemoteException, Exception {
		
		return c.getClassificationCriteria_exteranlDomainReferences();
	}


	@Override
	public ArrayList<String> getClassificationCriteria_explictness()
			throws RemoteException, Exception {
		
		return c.getClassificationCriteria_explictness();
	}


	@Override
	public ArrayList<String> getClassificationCriteria_difficulty()
			throws RemoteException, Exception {
		
		return c.getClassificationCriteria_difficulty();
	}


	@Override
	public ArrayList<String> getClassificationCriteria_conceptualComplexity()
			throws RemoteException, Exception {
		
		return c.getClassificationCriteria_conceptualComplexity();
	}


	@Override
	public ArrayList<String> getClassificationCriteria_codelength()
			throws RemoteException, SQLException {
		return c.getClassificationCriteria_codelength();
	}















}