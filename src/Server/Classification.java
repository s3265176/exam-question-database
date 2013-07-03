package Server;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class Classification {
	
	   Connection conn;
	   Statement st;
	   
	   
	   public Classification(Connection c){
		   this.conn=c;
		   
	   }
	public ArrayList<String> getClassificationCriteria_skillRequired()
			throws Exception {
		ArrayList<String> array= new ArrayList<String>();
		
        String sql = "select contents from skill"; 
		st = (Statement) conn.createStatement();
		st.executeQuery(sql);
		ResultSet rs = st.executeQuery(sql);
		while(rs.next()){
		array.add(rs.getString(1));	
		}
		return array;
		}
	



	public ArrayList<String> getClassificationCriteria_style()
			throws Exception {
		ArrayList<String> array= new ArrayList<String>();
		
        String sql = "select contents from style"; 
		st = (Statement) conn.createStatement();
		st.executeQuery(sql);
		ResultSet rs = st.executeQuery(sql);
		while(rs.next()){
		array.add(rs.getString(1));	
		}
		return array;
	}


	
	public ArrayList<String> getClassificationCriteria_topic()
			throws Exception {
		ArrayList<String> array= new ArrayList<String>();
		
        String sql = "select contents from topic"; 
		st = (Statement) conn.createStatement();
		st.executeQuery(sql);
		ResultSet rs = st.executeQuery(sql);
		while(rs.next()){
		array.add(rs.getString(1));	
		}
		return array;
	}


	
	public ArrayList<String> getClassificationCriteria_linguisticComlexity()
			throws Exception {
		ArrayList<String> array= new ArrayList<String>();
		
        String sql = "select contents from linguistic_complexity"; 
		st = (Statement) conn.createStatement();
		st.executeQuery(sql);
		ResultSet rs = st.executeQuery(sql);
		while(rs.next()){
		array.add(rs.getString(1));	
		}
		return array;
	}


	
	public ArrayList<String> getClassificationCriteria_intellectualComplexity()
			throws Exception {
		ArrayList<String> array= new ArrayList<String>();
		
        String sql = "select contents from intellectual_complexity"; 
		st = (Statement) conn.createStatement();
		st.executeQuery(sql);
		ResultSet rs = st.executeQuery(sql);
		while(rs.next()){
		array.add(rs.getString(1));	
		}
		return array;
	}



	public ArrayList<String> getClassificationCriteria_exteranlDomainReferences()
			throws Exception {
		ArrayList<String> array= new ArrayList<String>();
		
        String sql = "select contents from exteranl_domain_references"; 
		st = (Statement) conn.createStatement();
		st.executeQuery(sql);
		ResultSet rs = st.executeQuery(sql);
		while(rs.next()){
		array.add(rs.getString(1));	
		}
		return array;
	}


	
	public ArrayList<String> getClassificationCriteria_explictness()
			throws Exception {
		ArrayList<String> array= new ArrayList<String>();
		
        String sql = "select contents from explicitness"; 
		st = (Statement) conn.createStatement();
		st.executeQuery(sql);
		ResultSet rs = st.executeQuery(sql);
		while(rs.next()){
		array.add(rs.getString(1));	
		}
		return array;
	}


	
	public ArrayList<String> getClassificationCriteria_difficulty()
			throws Exception {
		ArrayList<String> array= new ArrayList<String>();
		
        String sql = "select contents from difficulty"; 
		st = (Statement) conn.createStatement();
		st.executeQuery(sql);
		ResultSet rs = st.executeQuery(sql);
		while(rs.next()){
		array.add(rs.getString(1));	
		}
		return array;
	}


	
	public ArrayList<String> getClassificationCriteria_conceptualComplexity()
			throws Exception {
		ArrayList<String> array= new ArrayList<String>();
		
        String sql = "select contents from conceptual_complexity"; 
		st = (Statement) conn.createStatement();
		st.executeQuery(sql);
		ResultSet rs = st.executeQuery(sql);
		while(rs.next()){
		array.add(rs.getString(1));	
		}
		return array;
	}


	
	public ArrayList<String> getClassificationCriteria_codelength() throws SQLException{
		ArrayList<String> array= new ArrayList<String>();
		
        String sql = "select contents from code_length"; 
		st = (Statement) conn.createStatement();
		st.executeQuery(sql);
		ResultSet rs = st.executeQuery(sql);
		while(rs.next()){
		array.add(rs.getString(1));	
		
		}
		return array;
	}

}
