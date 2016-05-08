package edu.fzu.openfund.util;

import java.sql.Connection;
import java.sql.SQLException;

public class TransactionManager {
	private Connection conn;

	protected TransactionManager(Connection conn) {
		this.conn = conn;
	}

	/** 开启事务 */
	public void beginTransaction() throws SQLException {
		conn.setAutoCommit(false); // 关闭自动提交

	}

	/** 提交事务并关闭连接 */
	public void commitAndClose() throws SQLException {
		try {
			conn.commit(); // 提交事务
		} catch (SQLException e) {
			throw new SQLException("提交事务时出现异常", e);
		} finally {
			DBUtils.close(conn);
		}
	}

	/** 回滚并关闭连接 */
	public void rollbackAndClose() {
		try {
			conn.rollback();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				DBUtils.close(conn);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
