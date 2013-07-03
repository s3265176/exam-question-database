package Server;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;


public class InitializeDatabase {
	    Statement st;
	    Statement st1;
	    Statement st2;
	    Statement st3;
	    Statement st4;
	    String paramFile="mysql.ini";
	    Connection conn;
	    
	    public InitializeDatabase( ){
				
				conn=new Database().connect();
	    }
	    
	    public void closeConnection(){
	    	try {
				conn.close();
			} catch (SQLException e) {
				System.out.print("error when close database connection");
				e.printStackTrace();
			}
	    }
	    
	    public void init(){
	    	CreateUserTable();
			CreateClassificationTable();
			CreateQuestionTable();
			CreateCommentsTable();
			Createtopic();
			Createstyle();
			Createskill();
			CreateLinguistic();
			Createintellectual();
			Createreferences();
			Createexplicitness();
			Createdifficulty();
			Createconceptual();
			Createcodelength();
			Inserttopic();
			Insertstyle();
			Insertskill();
			Insertintellectual();
			InsertLinguistic();
			Insertreferences();
			Insertexplicitness();
			Insertdifficulty();
			Insertconceptual();
			Insertcodelength();
			
			closeConnection();
			
			System.out.println("database tables set up successfully");
	    }
	  
	   public void CreateUserTable() {
			
			

			try {
				
				String sql="Create table IF NOT EXISTS USER(" +
						"User_id int not null auto_increment," +
						"Username varchar(255) not null," +
						"Password varchar(255) not null," +
						"Firstname varchar(255)," +
						"Lastname varchar(255)," +
						"Email varchar(100) not null," +
						"Address varchar(255)," +
						"Phone_number int," +
						"Year_of_teaching int," +
						"University varchar(255) not null," +
						"School varchar(255)," +
						"Department varchar(255)," +
						"Background text," +
						"Gender varchar(255)," +
						"PRIMARY KEY (User_id))auto_increment = 10000"; 
				st = (Statement) conn.createStatement();
				st.executeUpdate(sql);
				
				System.out.println("table user created");
			}catch (SQLException e) {
				System.out.println("table user " + e.getMessage());  
			}
		}

         
       public void CreateQuestionTable() {
    	  
			try {
				String sql="create table IF NOT EXISTS question(" +
						"Question_id int not null auto_increment," +
						"Question text," +
						"Questionpic LongBlob,"+
						"Answer text," +
						"MarkingGuide text," +
						"User_id int," +
						"Classification_id int," +
						"PRIMARY KEY (Question_id)," +
						"FOREIGN KEY (User_id) REFERENCES User(User_id)," +
						"FOREIGN KEY (Classification_id) REFERENCES classification(c_id))"; 
				st = (Statement) conn.createStatement();
				st.executeUpdate(sql);
				
				System.out.println("table question created");
			}catch (SQLException e) {
				System.out.println("table question" + e.getMessage());  
			}
		}
       public void CreateCommentsTable() {
			try {
				String sql="create table IF NOT EXISTS comments(" +
						"Comment_id int not null auto_increment," +
						"User_id int," +
						"Question_id int ," +
						"Classification_id  int ," +
						"Comment text," +
						"PRIMARY KEY (Comment_id)," +
						"FOREIGN KEY (Question_id) REFERENCES Question(Question_id)," +
						"FOREIGN KEY (Classification_id) REFERENCES Classification(c_id))"; 
				st = (Statement) conn.createStatement();
				st.executeUpdate(sql);
				System.out.println("table comments created");
			}catch (SQLException e) {
				System.out.println("table comments" + e.getMessage());  
			}
		}
       public void CreateClassificationTable(){	

			try {
				String sql="create table IF NOT EXISTS Classification(" +
						"c_id  int not null AUTO_INCREMENT," +
						"Percentage_mark varchar(255)," +
						"Topic varchar(255)," +
						"Skill_required varchar(255)," +
						"Style_of_question varchar(255)," +
						"Open varchar(255)," +
						"Difficulty varchar(255)," +
						"External_domain_references varchar(255)," +
						"Explicitness varchar(255)," +
						"Linguistic_complexity varchar(255)," +
						"Conceptual_complexity varchar(255)," +
						"Intellectual_complexity varchar(255)," +
						"Code_legth varchar(255)," +
						"PRIMARY KEY (c_id))"; 
				st = (Statement) conn.createStatement();
				st.executeUpdate(sql);
				System.out.println("table Classification created");
			}catch (SQLException e) {
				System.out.println("table Classification" + e.getMessage());  
			}
		}
       public void Createtopic() {
    	   
			try {
				String sql="create table IF NOT EXISTS topic(contents varchar(255))" ;
	
				st = (Statement) conn.createStatement();
				st.executeUpdate(sql);
				System.out.println("table topic created");
			}catch (SQLException e) {
				System.out.println("table topic" + e.getMessage());  
			}
		}
       public void Createstyle(){
    	   	

			try {
				String sql="create table IF NOT EXISTS  style(contents varchar(255))" ;
	
				st = (Statement) conn.createStatement();
				st.executeUpdate(sql);
				System.out.println("table  style created ");
			}catch (SQLException e) {
				System.out.println("table  style" + e.getMessage());  
			}
		}
       public void Createskill(){
    	   

			try {
				String sql="create table IF NOT EXISTS skill(contents varchar(255))" ;
	
				st = (Statement) conn.createStatement();
				st.executeUpdate(sql);
				System.out.println("table skill created");
			}catch (SQLException e) {
				System.out.println("table skill" + e.getMessage());  
			}
		}
       public void CreateLinguistic() {
    	  
			try {
				String sql="create table IF NOT EXISTS linguistic_complexity(contents varchar(255))" ;
	
				st = (Statement) conn.createStatement();
				st.executeUpdate(sql);
				System.out.println("table Linguistic Created");
			}catch (SQLException e) {
				System.out.println("table Linguistic" + e.getMessage());  
			}
		}
       public void Createintellectual(){
    	   
			try {
				String sql="create table IF NOT EXISTS intellectual_complexity(contents varchar(255))" ;
	
				st = (Statement) conn.createStatement();
				st.executeUpdate(sql);
				System.out.println("table intellectual created");
			}catch (SQLException e) {
				System.out.println("table intellectual" + e.getMessage());  
			}
		}
       public void Createreferences(){
    	   
			try {
				String sql="create table IF NOT EXISTS exteranl_domain_references(contents varchar(255))" ;
	
				st = (Statement) conn.createStatement();
				st.executeUpdate(sql);
				System.out.println("table exteranl_domain_references created");
			}catch (SQLException e) {
				System.out.println("table exteranl_domain_references" + e.getMessage());  
			}
		}
       public void Createexplicitness() {
    	   	
			try {
				String sql="create table IF NOT EXISTS explicitness(contents varchar(255))" ;
	
				st = (Statement) conn.createStatement();
				st.executeUpdate(sql);
				System.out.println("table explicitness created");
			}catch (SQLException e) {
				System.out.println("table explicitness" + e.getMessage());  
			}
		}
       public void Createdifficulty() {
    	   
			try {
				String sql="create table IF NOT EXISTS difficulty(contents varchar(255))" ;
	
				st = (Statement) conn.createStatement();
				st.executeUpdate(sql);
				System.out.println("table  difficulty created");
			}catch (SQLException e) {
				System.out.println("table  difficulty" + e.getMessage());  
			}
		}
       public void Createconceptual() {
    	   
			try {
				String sql="create table IF NOT EXISTS conceptual_complexity(contents varchar(255))" ;
	
				st = (Statement) conn.createStatement();
				st.executeUpdate(sql);
				System.out.println("table conceptual created ");
			}catch (SQLException e) {
				System.out.println("table conceptual" + e.getMessage());  
			}
		}
       public void Createcodelength(){
    	  	
			try {
				String sql="create table IF NOT EXISTS code_length(contents varchar(255))" ;
	
				st = (Statement) conn.createStatement();
				st.executeUpdate(sql);
				System.out.println("table code_length created");
			}catch (SQLException e) {
				System.out.println("table code_length" + e.getMessage());  
			}
       } 
       public void Inserttopic() {
    	   
			try {
				String sql="DELETE FROM topic where contents = 'loops' or contents = 'testing' or contents = 'I/O' or contents = 'arrays' or contents = 'constants' ";
				String sql1="INSERT INTO topic(contents) VALUES ('loops'),('testing'),('I/O'),('arrays'),('constants')" ;
				//String sql1="REPLACE INTO topic(contents) VALUES ('testing')" ;
				//String sql2="REPLACE INTO topic(contents) VALUES ('I/O')" ;
				//String sql3="REPLACE INTO topic(contents) VALUES ('arrays')" ;
				//String sql4="REPLACE INTO topic(contents) VALUES ('constants')" ;
				
				st = (Statement) conn.createStatement();
				st1 = (Statement) conn.createStatement();
			//	st2 = (Statement) conn.createStatement();
			//	st3 = (Statement) conn.createStatement();
			//	st4 = (Statement) conn.createStatement();
				st.executeUpdate(sql);
				st.close();
				st1.executeUpdate(sql1);
				st1.close();
			//	st2.executeUpdate(sql2);
			//	st2.close();
			//	st3.executeUpdate(sql3);
			//	st3.close();
			//	st4.executeUpdate(sql4);
			//	st4.close();
			
			}catch (SQLException e) {
				System.out.println(e.getMessage());  
			}
		}
       public void Insertstyle() {
    	  
			try {
				String sql="DELETE FROM style where contents = 'explain_code' or contents = 'write_code' or contents = 'debug_code' or contents = 'trace_code' or contents = 'test_progrem' ";
				String sql1="INSERT INTO style(contents) VALUES ('explain_code'),('write_code'),('debug_code'),('trace_code'),('test_progrem')" ;
//				String sql1="INSERT INTO style(contents) VALUES ('write_code')" ;
//				String sql2="REPLACE INTO style(contents) VALUES ('debug_code')" ;
//				String sql3="REPLACE INTO style(contents) VALUES ('trace_code')" ;
//				String sql4="REPLACE INTO style(contents) VALUES ('test_progrem')" ;
				
				st = (Statement) conn.createStatement();
				st1 = (Statement) conn.createStatement();
			//	st2 = (Statement) conn.createStatement();
			//	st3 = (Statement) conn.createStatement();
			//	st4 = (Statement) conn.createStatement();
				st.executeUpdate(sql);
				st.close();
				st1.executeUpdate(sql1);
				st1.close();
			//	st2.executeUpdate(sql2);
			//	st2.close();
			//	st3.executeUpdate(sql3);
			//	st3.close();
			//	st4.executeUpdate(sql4);
			//	st4.close();
				
			}catch (SQLException e) {
				System.out.println(  e.getMessage());  
			}
		}
       public void Insertskill() {
    	  	
			try {
				String sql="DELETE FROM skill where contents = 'multiple_choice' or contents = 'short_answer' or contents = 'program_code' or contents = 'parsons_problem' or contents = 'graphical_representation' ";
				String sql1="INSERT INTO skill(contents) VALUES ('multiple_choice'),('short_answer'),('program_code'),('parsons_problem'),('graphical_representation')" ;
				//String sql1="REPLACE INTO skill(contents) VALUES ('short_answer')" ;
				//String sql2="REPLACE INTO skill(contents) VALUES ('program_code')" ;
				//String sql3="REPLACE INTO skill(contents) VALUES ('parsons_problem')" ;
				//String sql4="REPLACE INTO skill(contents) VALUES ('graphical_representation')" ;
				
				
				st = (Statement) conn.createStatement();
				st1 = (Statement) conn.createStatement();
				//st2 = (Statement) conn.createStatement();
				//st3 = (Statement) conn.createStatement();
			//	st4 = (Statement) conn.createStatement();
				st.executeUpdate(sql);
				st.close();
				st1.executeUpdate(sql1);
				st1.close();
			//	st2.executeUpdate(sql2);
			//	st2.close();
			//	st3.executeUpdate(sql3);
			//	st3.close();
			//	st4.executeUpdate(sql4);
			//	st4.close();
				
			}catch (SQLException e) {
				System.out.println(  e.getMessage());  
			}
		}
       public void InsertLinguistic(){
    	  	
			try {
				String sql="DELETE FROM linguistic_complexity where contents = 'low' or contents = 'medium' or contents = 'high'";
				String sql1="INSERT INTO linguistic_complexity(contents) VALUES ('low'),('medium'),('high')" ;
				//String sql1="REPLACE INTO linguistic_complexity(contents) VALUES ('medium')" ;
			//	String sql2="REPLACE INTO linguistic_complexity(contents) VALUES ('high')" ;
	
				st = (Statement) conn.createStatement();
				st1 = (Statement) conn.createStatement();
			//	st2 = (Statement) conn.createStatement();

				st.executeUpdate(sql);
				st.close();
				st1.executeUpdate(sql1);
				st1.close();
			//	st2.executeUpdate(sql2);
			//	st2.close();
				
			}catch (SQLException e) {
				System.out.println(  e.getMessage());  
			}
		}
       public void Insertintellectual(){
    	  
			try {
				String sql="DELETE FROM intellectual_complexity where contents = 'Knowledge' or contents = 'Comprehension' or contents = 'Application' or contents = 'Analysis' or contents = 'Synthesis'";
				String sql1="INSERT INTO intellectual_complexity(contents) VALUES ('Knowledge'),('Comprehension'),('Application'),('Analysis'),('Synthesis')" ;
				//String sql1="REPLACE INTO intellectual_complexity(contents) VALUES ('Comprehension')" ;
				//String sql2="REPLACE INTO intellectual_complexity(contents) VALUES ('Application')" ;
				//String sql3="REPLACE INTO intellectual_complexity(contents) VALUES ('Analysis')" ;
				//String sql4="REPLACE INTO intellectual_complexity(contents) VALUES ('Synthesis')" ;
				
				st = (Statement) conn.createStatement();
				st1 = (Statement) conn.createStatement();
				//st2 = (Statement) conn.createStatement();
				//st3 = (Statement) conn.createStatement();
				//st4 = (Statement) conn.createStatement();
				st.executeUpdate(sql);
				st.close();
				st1.executeUpdate(sql1);
				st1.close();
			//	st2.executeUpdate(sql2);
			//	st2.close();
			//	st3.executeUpdate(sql3);
			//	st3.close();
			//	st4.executeUpdate(sql4);
			//	st4.close();
				System.out.println();
			}catch (SQLException e) {
				System.out.println(e.getMessage());  
			}
		}
       public void Insertreferences() {
    	   	
			try {
				String sql="DELETE FROM exteranl_domain_references where contents = 'low' or contents = 'medium' or contents = 'high'";
				String sql1="INSERT INTO exteranl_domain_references(contents) VALUES ('low'),('medium'),('high')" ;
				//String sql1="REPLACE INTO exteranl_domain_references(contents) VALUES ('medium')" ;
			//	String sql2="REPLACE INTO exteranl_domain_references(contents) VALUES ('high')" ;
				
				st = (Statement) conn.createStatement();
				st1 = (Statement) conn.createStatement();
			//	st2 = (Statement) conn.createStatement();

				st.executeUpdate(sql);
				st.close();
				st1.executeUpdate(sql1);
				st1.close();
			//	st2.executeUpdate(sql2);
			//	st2.close();
			
			
				
			}catch (SQLException e) {
				System.out.println(  e.getMessage());  
			}
		}
       public void Insertexplicitness() {
    	  
			try {
				String sql="DELETE FROM explicitness where contents = 'low' or contents = 'medium' or contents = 'high'";
				String sql1="INSERT INTO explicitness(contents) VALUES ('low'),('medium'),('high')" ;
				//String sql1="REPLACE INTO explicitness(contents) VALUES ('medium')" ;
				//String sql2="REPLACE INTO explicitness(contents) VALUES ('high')" ;
				
				st = (Statement) conn.createStatement();
				st1 = (Statement) conn.createStatement();
				//st2 = (Statement) conn.createStatement();

				st.executeUpdate(sql);
				st.close();
				st1.executeUpdate(sql1);
				st1.close();
				//st2.executeUpdate(sql2);
				//st2.close();
				
				
			}catch (SQLException e) {
				System.out.println( e.getMessage());  
			}
		}
       public void Insertdifficulty() {
    	  
			try {
				String sql="DELETE FROM difficulty where contents = 'low' or contents = 'medium' or contents = 'high'";
				String sql1="INSERT INTO difficulty(contents) VALUES ('low'),('medium'),('high')" ;
			//	String sql1="REPLACE INTO difficulty(contents) VALUES ('medium')" ;
			//	String sql2="REPLACE INTO difficulty(contents) VALUES ('high')" ;
				
				st = (Statement) conn.createStatement();
				st1 = (Statement) conn.createStatement();
			//	st2 = (Statement) conn.createStatement();

				st.executeUpdate(sql);
				st.close();
				st1.executeUpdate(sql1);
				st1.close();
			//	st2.executeUpdate(sql2);
			//	st2.close();
				
			}catch (SQLException e) {
				System.out.println( e.getMessage());  
			}
		}
       public void Insertconceptual() {
    	  				try {
				String sql="DELETE FROM conceptual_complexity where contents = 'low' or contents = 'medium' or contents = 'high'";
				String sql1="INSERT INTO conceptual_complexity(contents) VALUES ('low'),('medium'),('high')" ;
				//String sql1="REPLACE INTO conceptual_complexity(contents) VALUES ('medium')" ;
				//String sql2="REPLACE INTO conceptual_complexity(contents) VALUES ('high')" ;
				
				st = (Statement) conn.createStatement();
				st1 = (Statement) conn.createStatement();
			//	st2 = (Statement) conn.createStatement();

				st.executeUpdate(sql);
				st.close();
				st1.executeUpdate(sql1);
				st1.close();
			//	st2.executeUpdate(sql2);
			//	st2.close();
				
			}catch (SQLException e) {
				System.out.println( e.getMessage());  
			}
		}
       public void Insertcodelength() {
    	 	
    	   try {
				String sql="DELETE FROM code_length where contents = 'low' or contents = 'medium' or contents = 'high' or contents = 'N/A'";
				String sql1="INSERT INTO code_length(contents) VALUES ('low'),('medium'),('high'),('N/A')" ;
			//	String sql1="REPLACE INTO code_length(contents) VALUES ('medium')" ;
			//	String sql2="REPLACE INTO code_length(contents) VALUES ('high')" ;
			//	String sql3="REPLACE INTO code_length(contents) VALUES ('N/A')" ;
				
				st = (Statement) conn.createStatement();
				st1 = (Statement) conn.createStatement();
			//	st2 = (Statement) conn.createStatement();
			//	st3 = (Statement) conn.createStatement();
				
				st.executeUpdate(sql);
				st.close();
				st1.executeUpdate(sql1);
				st1.close();
			//	st2.executeUpdate(sql2);
			//	st2.close();
			//	st3.executeUpdate(sql2);
			//	st3.close();
				
			}catch (SQLException e) {
				System.out.println(e.getMessage());  
			}
       } 
       
       }
