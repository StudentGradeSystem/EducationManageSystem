package edu.fzu.openfund.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtils {
	private static final String CONN_URL = "jdbc:mysql://localhost:3306/openfunddb?useUnicode=true&characterEncoding=utf8";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "root";
	// 用来把Connection绑定到当前线程上的变量
	private static ThreadLocal<Connection> tl = new ThreadLocal<Connection>();

	public static synchronized Connection getConnection() {
		Connection conn = tl.get(); // 先从当前线程上取出连接实例
		if (null == conn) { // 如果当前线程上没有Connection的实例
			try {
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager
						.getConnection(CONN_URL, USERNAME, PASSWORD);
				tl.set(conn); // 把它绑定到当前线程上
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return conn;
	}

	public static void close(Connection conn) throws SQLException {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new SQLException("关闭连接时出现异常", e);
			} finally {
				tl.remove(); // 卸装线程绑定
			}
		}
	}
	
	 /** 
     * 获取事务管理器 
     * @return 事务管理实例 
     */  
    public static synchronized TransactionManager getTranManager(){  
        return new TransactionManager(getConnection());  
    }  

	public static void releaseResource(Connection conn, PreparedStatement pstmt,
			ResultSet rset) {

		try {

			if (rset != null)
				rset.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			tl.remove(); // 卸装线程绑定
		}

	}
}
