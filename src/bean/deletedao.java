package bean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import bean.javabean;
public class deletedao {
	
	public static int delete(Integer id) {
		int row = 0;
		Connection connection = javabean.getconn();
		PreparedStatement statement = null;
		
		
		
		try {
			String sql="delete from user  where id=?";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, id);

			row =statement.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
		javabean.close(connection);
		javabean.close(statement);
			
		}
		return row ;
	}

}