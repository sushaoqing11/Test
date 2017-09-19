package bean;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;


import bean.user;
import bean.javabean;

public class userdao {
     
	public static List<user> getuserList(Integer pagenumber,Integer pagesize) throws SQLException{
		List<user> Userlist = new ArrayList<user>();
		
			Connection connection = javabean.getconn();
			Statement statement = javabean.getStatement(connection);
			int start = (pagenumber-1)*pagesize;

			ResultSet resultset=javabean.getResultSet(statement, "SELECT * FROM user limit "+ start+","+pagesize);
		try {
			while(resultset.next()) {
				int id =resultset.getInt("id");
				String name =resultset.getString("name");
				int age = resultset.getInt("age");
				user user = new user(id,name,age);
				Userlist.add(user);
			}
			
		} catch (Exception e){
			 e.printStackTrace();
			
		} finally {
			javabean.close(resultset);
	    	javabean.close(statement);
	    	javabean.close(connection);
		}
		
		return Userlist;
	}
	public static user getuser(Integer id) throws SQLException{
		     user User = null;
		
			Connection connection = javabean.getconn();
			PreparedStatement statement= null;
			

			ResultSet resultset=null;
		try {
			String sql = "SELECT * FROM user where id=?";
			statement = connection.prepareStatement(sql);
			statement.setInt(1,id);
			resultset=statement.executeQuery();
			if(resultset.next()) {
				int ID =resultset.getInt("id");
				String name =resultset.getString("name");
				int age = resultset.getInt("age");
				User = new user(ID,name,age);
	
			}
			
		} catch (Exception e){
			 e.printStackTrace();
			
		} finally {
			javabean.close(resultset);
	    	javabean.close(statement);
	    	javabean.close(connection);
		}
		
		return User;
	}

	public static int getCount() {
		int count = 1;
		Connection connection = javabean.getconn();
		Statement statement = javabean.getStatement(connection);
		String sql = "select count(*) from user "; 
		ResultSet rs=javabean.getResultSet(statement, sql);
         try {
        	 if (rs.next()) {
        		 count = rs.getInt(count);
        	 }
        	 
         }	catch (Exception e){
			 e.printStackTrace();
			
		} finally {
			javabean.close(rs);
	    	javabean.close(statement);
	    	javabean.close(connection);
		}
	   return count;
	}
	
}
