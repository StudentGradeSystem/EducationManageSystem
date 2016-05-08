package edu.fzu.openfund.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.Session;
import org.hibernate.criterion.RowCountProjection;

import edu.fzu.openfund.domain.Fund;
import edu.fzu.openfund.util.HibernateSessionFactory;
import edu.fzu.openfund.util.HibernateUtil;

public class FundDaoHibImpl extends BaseDaoHibImpl<Fund> implements FundDao {
	@Override
	public List findFundsPage(String fundName, Double fromPrice,
			Double toPrice, String fundStatus, String fromDate, String toDate,
			int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		String hql = "from Fund as f where 1=1  ";
		Session session = getSession();

		if (fundName != null && !fundName.equals(""))
			hql += " and f.fundName like  '%" + fundName + "%'";
		if (fromPrice != null)
			hql += " and f.fundPrice >= " + fromPrice;
		if (toPrice != null)
			hql += " and f.fundPrice <= " + toPrice;
		if (fundStatus != null && !fundStatus.equals(""))
			hql += " and f.fundStatus = '" + fundStatus + "'";
		if (fromDate != null && !fromDate.equals(""))
			hql += " and f.fundCreateDate>='" + fromDate + "'";
		if (toDate != null && !toDate.equals(""))
			hql += " and f.fundCreateDate<='" + toDate + "'";

		rowsCount = ((Long)session.createQuery("select count(*) " + hql).uniqueResult()).intValue();
		return findByPage(hql, pageNo, pageSize);
	}
	
	

}
