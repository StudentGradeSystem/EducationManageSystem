package edu.fzu.openfund.dao;

import java.util.List;

import edu.fzu.openfund.domain.FundHolding;

public class FundHoldingDaoHibImpl extends BaseDaoHibImpl<FundHolding>
		implements FundHoldingDao {
	@Override
	public FundHolding findFundHolding(int accNo, int fundNo) {
		//请补充编写代码
		String hql="from FundHolding as f where f.fund.fundNo=?0 and f.finAcc.accNo=?1";
		List<FundHolding> fundHoldings=find(hql,fundNo,accNo);
		//System.out.println(fundHoldings.get(0).getHoldAmount());		
		return fundHoldings.get(0);
	}
	public long getSize(int accNo)
	{
		long count=0;
		if(accNo==0){
			count=findCount(FundHolding.class);
		//System.out.println("count1111");
		}
		else
		{
			List<FundHolding> fh=null;
			String hql="from FundHolding  as f where f.finAcc.accNo= ?0";
			fh=find(hql,accNo);
            count=fh.size();
           // System.out.println("count222");
		}	
		//System.out.println(count);
		return count;
	}
	@Override
	public List<FundHolding> findHoldingsByAccPage(int accNo, int pageNo, int pageSize){
		//请补充编写代码
		String hql="from FundHolding  as f where f.finAcc.accNo= "+accNo;
		List<FundHolding> fh=findByPage(hql,pageNo,pageSize);
		return fh;
	}

	@Override
	public List<FundHolding> findHoldingsByPage(int pageNo, int pageSize) {
		//请补充编写代码
		String hql="from FundHolding";
		List<FundHolding>  fh=findByPage(hql,pageNo,pageSize);
		return fh;
	}
}
