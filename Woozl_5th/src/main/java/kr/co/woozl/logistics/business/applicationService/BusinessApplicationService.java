package kr.co.woozl.logistics.business.applicationService;

import java.util.List;
import java.util.Map;

import kr.co.woozl.logistics.business.to.ContractDetailTO;
import kr.co.woozl.logistics.business.to.ContractTO;
import kr.co.woozl.logistics.business.to.CustomerTO;
import kr.co.woozl.logistics.business.to.DeliveryResultTO;
import kr.co.woozl.logistics.business.to.EstimateDetailTO;
import kr.co.woozl.logistics.business.to.EstimateTO;
import kr.co.woozl.logistics.purchase.to.StockTO;

public interface BusinessApplicationService {

	public List<EstimateTO> findEstimateList(Map<String,Object> map);

	public List<EstimateTO> findEstimateDialog();

	public void batchEstimate(List<EstimateTO> estimateList,List<EstimateDetailTO> estimateDetailList);
	
	public void updateEstimateStatus(List<EstimateTO> estimateList, List<EstimateDetailTO> estimateDetailList); 

	public List<EstimateDetailTO> findEstimateDetailList();

	public List<ContractTO> findContractList(Map<String,Object> map);

	public List<ContractDetailTO> findContractDetailList(Map<String,Object> map);
	
	public List<ContractDetailTO> findMpsCheckList(String startDate,String endDate);

	public void batchContract(List<ContractTO> contractList,List<ContractDetailTO> contractDetailList);

	public List<CustomerTO> findCustomerList();

	public List<DeliveryResultTO> findDeliveryResultList();
	
	public void batchCustomer(List<CustomerTO> customerList);

	public void registDeliveryResult(List<ContractTO> contractList,List<ContractDetailTO> contractDetailList,List<StockTO> stockList, List<DeliveryResultTO> deliveryResultList);
}
