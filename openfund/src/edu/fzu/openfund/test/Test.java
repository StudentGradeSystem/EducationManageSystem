package edu.fzu.openfund.test;

import java.util.Set;

import org.hibernate.Hibernate;

import edu.fzu.openfund.dao.FinAccDao;
import edu.fzu.openfund.dao.FinAccDaoHibImpl;
import edu.fzu.openfund.dao.FundDao;
import edu.fzu.openfund.dao.FundDaoHibImpl;
import edu.fzu.openfund.dao.FundHoldingDao;
import edu.fzu.openfund.dao.FundHoldingDaoHibImpl;
import edu.fzu.openfund.domain.FinAcc;
import edu.fzu.openfund.domain.Fund;
import edu.fzu.openfund.domain.FundHolding;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*FundDao fundDao=new FundDaoHibImpl();
		Fund fund=fundDao.findFundByID(1);
		
		Set<FundHolding> holds=fund.getHoldings();
		System.out.println("购买"+fund.getFundName()+"的账户有:");
		for (FundHolding hold: holds) {
			System.out.println(hold.getFinAcc().getAccNo()+"   "+hold.getHoldAmount());
		}
		*/
		FundHoldingDao fundHoldingDao=new FundHoldingDaoHibImpl();
		FundHolding fundHolding=fundHoldingDao.get(FundHolding.class, 1);
		fundHolding.getHoldAmount();
		
		/*Set<FinAcc> finAccs=fund.getFinAccs();
		System.out.println("购买"+fund.getFundName()+"的客户有:");
		for (FinAcc finAcc: finAccs) {
			System.out.println(finAcc.getClient().getClientName());
		}*/
	}

}
