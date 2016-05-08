package edu.fzu.openfund.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import edu.fzu.openfund.util.DBUtils;

public class AdminDaoJDBCImpl implements AdminDao
{
    public boolean checkUser(String adminName, String adminPwd)
    {
        // TODO Auto-generated method stub
        Connection conn=null;
        PreparedStatement pstmt = null;
        ResultSet rs=null;
        Boolean flag=false;
        try
        {
        	conn=DBUtils.getConnection();
        	String sql="select * from admins where name=? and pwd=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, adminName);
            pstmt.setString(2, adminPwd);
            rs = pstmt.executeQuery();
            if (rs.next())
                flag=true;
        } catch (SQLException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            DBUtils.releaseResource(conn, pstmt, rs);
        }
        return flag;
    }

}
