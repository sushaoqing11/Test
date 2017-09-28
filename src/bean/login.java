package bean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bean.userRegister;
import bean.loginDB;
public class login{
	public static boolean findLogin(String username,String password) throws Exception {  
        boolean flag=false;  
        Connection connection = loginDB.getconn();
		PreparedStatement statement = null;
		ResultSet resultset = null;
        try {  
            String sql="select * from user where username=? and password=?";  
            statement=connection.prepareStatement(sql);  
            statement.setString(1,username);  
            statement.setString(2,password);  
            resultset=statement.executeQuery();
            while(resultset.next()){  
                flag=true;        
            }  
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
		loginDB.close(connection);
		loginDB.close(statement);
		loginDB.close(resultset);
		}
		return flag;
	}

}