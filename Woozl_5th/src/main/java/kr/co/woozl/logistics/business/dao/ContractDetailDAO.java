package kr.co.woozl.logistics.business.dao;

import java.util.List;
import java.util.Map;

import kr.co.woozl.logistics.business.to.ContractDetailTO;


public interface ContractDetailDAO {

	public List<ContractDetailTO> selectContractDetailList(Map<String,Object> map);
	
	public List<ContractDetailTO> selectMpsCheckList(String startDate,String endDate);
	
	public void insertContractDetail(ContractDetailTO contractDetailTO);
	
	public void updateContractDetail(ContractDetailTO contractDetailTO);
	
	public void deleteContractDetail(ContractDetailTO contractDetailTO);
	
}
