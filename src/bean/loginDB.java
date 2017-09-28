package bean;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class loginDB {
     
	public static Connection getconn() {
		Connection conn =null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/login?user=root&password=123456");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	
	return conn;
	}

public static Statement getStatement(Connection conn) {
	Statement statement = null;
	try {
		if(conn != null) {
			statement = conn.createStatement();
		}
	}catch(SQLException e) {
			e.printStackTrace();
		}
		return statement;
	
}

public static ResultSet getResultSet(Statement statement,String sql) {
	ResultSet resultset = null;
	try {
		if (statement != null) {
			resultset = statement.executeQuery(sql);
		}
	}catch(SQLException e) {
		e.printStackTrace();
	}return resultset;
}
	public static void close (Connection conn) {
		try {
			if (conn != null) {
				conn.close();
				conn = null;
			}
		}catch(SQLException e) {
               e.printStackTrace();
		}
	}
	public static void close(Statement statement) {
		try {
			if (statement !=null) {
				statement.close();
				statement = null;
			}
		}catch(SQLException e) {
		e.printStackTrace();
		}
	}
	public static void close(ResultSet resultset) {
		try {
			if (resultset != null) {
				resultset.close();
				resultset = null;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
}
