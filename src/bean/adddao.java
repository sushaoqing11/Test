package bean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import bean.javabean;
public class adddao {
	
	public static int adduser(String id,String name,String age) {
		int row = 0;
		Connection connection = javabean.getconn();
		PreparedStatement statement = null;
		
		
		
		try {
			String sql="insert into user(id,name,age) values (?,?,?)";
			statement = connection.prepareStatement(sql);
			statement.setString(1, id);
			statement.setString(2, name);
			statement.setString(3, age);
			statement.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
		javabean.close(connection);
		javabean.close(statement);
			
		}
		return row ;
	}

}
