package bean;
import java.sql.Connection;
import java.sql.PreparedStatement;


import bean.loginDB;
public class register {
	
	public static int userregister(String username,String password) {
		int row = 0;
		Connection connection = loginDB.getconn();
		PreparedStatement statement = null;
		
		
		
		try {
			String sql="insert into user(username,password) values (?,?)";
			statement = connection.prepareStatement(sql);
			statement.setString(1, username);
			statement.setString(2, password);

			statement.executeUpdate();
		
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			loginDB.close(statement);
		loginDB.close(connection);
		
			
		}
		return row ;
	}
	

}


