package edu.fzu.openfund.dao;
import java.util.Date;
import java.util.List;
import edu.fzu.openfund.domain.Fund;
import edu.fzu.openfund.util.PageBean;

public interface FundDao extends BaseHibDao<Fund>{
	//条件分页查询
	List findFundsPage(String fundName, Double fromPrice, Double toPrice,
            String fundStatus, String fromDate, String toDate, int pageNo, int pageSize);
}

