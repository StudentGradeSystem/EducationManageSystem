package edu.fzu.openfund.dao;

import java.util.List;

import javax.persistence.criteria.From;

import org.hibernate.Query;
import org.hibernate.Session;

import edu.fzu.openfund.domain.FinAcc;

public class FinAccDaoHibImpl extends BaseDaoHibImpl<FinAcc> implements
		FinAccDao {

	@Override
	public FinAcc find(String passwd, int accNo) {
		//请补充编写代码
		String hql="from FinAcc where accNo=?0 and accPwd=?1";
		List<FinAcc> user=find(hql,accNo,passwd);
		if(user.size()>0){
			if("A".equalsIgnoreCase(user.get(0).getAccStatus())){
				return user.get(0);
			}
		}
		return null;
	}

}
