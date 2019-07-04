package kr.co.woozl.logistics.business.dao;

import java.util.List;
import java.util.Map;

import kr.co.woozl.logistics.business.to.ContractTO;


public interface ContractDAO {

	public List<ContractTO> selectContractList(Map<String,Object> map);

	public void insertContract(ContractTO contractTO);

	public void updateContract(ContractTO contractTO);
	
	public void deleteContract(ContractTO contractTO);
		
}
