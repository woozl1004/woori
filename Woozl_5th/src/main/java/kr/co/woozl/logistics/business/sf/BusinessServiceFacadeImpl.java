package kr.co.woozl.logistics.business.sf;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.woozl.logistics.business.applicationService.BusinessApplicationService;
import kr.co.woozl.logistics.business.to.ContractDetailTO;
import kr.co.woozl.logistics.business.to.ContractTO;
import kr.co.woozl.logistics.business.to.CustomerTO;
import kr.co.woozl.logistics.business.to.DeliveryResultTO;
import kr.co.woozl.logistics.business.to.EstimateDetailTO;
import kr.co.woozl.logistics.business.to.EstimateTO;
import kr.co.woozl.logistics.purchase.to.StockTO;

@Service
public class BusinessServiceFacadeImpl implements BusinessServiceFacade{

	@Autowired
	private BusinessApplicationService businessApplicationService;


	@Override
	public List<EstimateTO> findEstimateList(Map<String,Object> map) {
		// TODO Auto-generated method stub
		return businessApplicationService.findEstimateList(map);
	}


	@Override
	public List<EstimateDetailTO> findEstimateDetailList() {
		// TODO Auto-generated method stub
		return businessApplicationService.findEstimateDetailList();
	}


	@Override
	public List<ContractTO> findContractList(Map<String,Object> map) {
		// TODO Auto-generated method stub
		return businessApplicationService.findContractList(map);
	}


	@Override
	public List<ContractDetailTO> findContractDetailList(Map<String,Object> map) {
		// TODO Auto-generated method stub
		return businessApplicationService.findContractDetailList(map);
	}

	@Override
	public List<ContractDetailTO> findMpsCheckList(String startDate,String endDate) {
		// TODO Auto-generated method stub
		return businessApplicationService.findMpsCheckList(startDate,endDate);
	}

	@Override
	public List<CustomerTO> findCustomerList() {
		// TODO Auto-generated method stub
		return businessApplicationService.findCustomerList();
	}


	@Override
	public void batchEstimate(List<EstimateTO> estimateList,List<EstimateDetailTO> estimateDetailList) {
		// TODO Auto-generated method stub
		businessApplicationService.batchEstimate(estimateList,estimateDetailList);

	}


	@Override
	public List<EstimateTO> findEstimateDialog() {
		// TODO Auto-generated method stub
		return businessApplicationService.findEstimateDialog();
	}


	@Override
	public void batchContract(List<ContractTO> contractList, List<ContractDetailTO> contractDetailList) {
		// TODO Auto-generated method stub
		businessApplicationService.batchContract(contractList,contractDetailList);
	}


	@Override
	public List<DeliveryResultTO> findDeliveryResultList() {
		// TODO Auto-generated method stub
		return businessApplicationService.findDeliveryResultList();
	}


	@Override
	public void registDeliveryResult(List<ContractTO> contractList, List<ContractDetailTO> contractDetailList,
			List<StockTO> stockList, List<DeliveryResultTO> deliveryResultList) {
		// TODO Auto-generated method stub
		businessApplicationService.registDeliveryResult(contractList,contractDetailList,stockList,deliveryResultList);
	}
	

	@Override
	public void batchCustomer(List<CustomerTO> customerList) {
		// TODO Auto-generated method stub
		businessApplicationService.batchCustomer(customerList);
	}

}
