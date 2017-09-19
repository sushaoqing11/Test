package bean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import bean.javabean;
public class updatedao {
	
	public static int update(Integer id,String name,String age) {
		int row = 0;
		Connection connection = javabean.getconn();
		PreparedStatement statement = null;
		
		
		
		try {
			String sql="update user set id=?,name=?,age=? where id=?";
			statement = connection.prepareStatement(sql);
			statement.setObject(1, id);
			statement.setObject(2, name);
			statement.setObject(3, age);
			statement.setObject(4, id);
			row = statement.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
		javabean.close(connection);
		javabean.close(statement);
			
		}
		return row ;
	}

}
