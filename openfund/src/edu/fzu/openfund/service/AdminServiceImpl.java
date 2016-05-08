package edu.fzu.openfund.service;
import edu.fzu.openfund.dao.AdminDao;
import edu.fzu.openfund.dao.AdminDaoJDBCImpl;

public class AdminServiceImpl implements AdminService
{

    public boolean checkUser(String adminName, String adminPwd)
    {
        // TODO Auto-generated method stub
        AdminDao adminDao = new AdminDaoJDBCImpl();
        return adminDao.checkUser(adminName, adminPwd);
    }

}
