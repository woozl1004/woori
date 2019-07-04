package kr.co.woozl.logistics.production.sf;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.woozl.logistics.business.to.ContractDetailTO;
import kr.co.woozl.logistics.production.applicationService.ProductionApplicationService;
import kr.co.woozl.logistics.production.to.MaterialCheckTempTO;
import kr.co.woozl.logistics.production.to.MpsTO;
import kr.co.woozl.logistics.production.to.MrpGatheringTO;
import kr.co.woozl.logistics.production.to.MrpGatheringTO2;
import kr.co.woozl.logistics.production.to.MrpOpenTempTO;
import kr.co.woozl.logistics.production.to.MrpTO;
import kr.co.woozl.logistics.production.to.PrmTO;
import kr.co.woozl.logistics.production.to.WorkInstructionTO;
import kr.co.woozl.logistics.purchase.to.MaterialPaymentTO;
import kr.co.woozl.logistics.purchase.to.StockTO;
import kr.co.woozl.logistics.purchase.to.WarehousingTO;

@Service
public class ProductionServiceFacadeImpl implements ProductionServiceFacade{

	@Autowired
	private ProductionApplicationService productionApplicationService;


	@Override
	public List<MpsTO> findMpsList(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return productionApplicationService.findMpsList(map);
	}
	
	@Override
	public void registerMps(List<MpsTO> mpsList, List<ContractDetailTO> contractDetailList) {
		// TODO Auto-generated method stub
		productionApplicationService.registerMps(mpsList, contractDetailList);
	}

	@Override
	public List<MrpTO> findMrpList() {
		// TODO Auto-generated method stub
		return productionApplicationService.findMrpList();
	}

	@Override
	public List<MrpGatheringTO> findMrpGatheringList() {
		// TODO Auto-generated method stub
		return productionApplicationService.findMrpGatheringList();
	}

	@Override
	public List<WorkInstructionTO> findWorkInstructionList(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return productionApplicationService.findWorkInstructionList(map);
	}
	
	@Override
	public List<MaterialCheckTempTO> findWorkInstructionOpen(HashMap<String, Object> paramMap) {
		// TODO Auto-generated method stub
		return productionApplicationService.findWorkInstructionOpen(paramMap);
	}
	

	@Override
	public List<MaterialCheckTempTO> findMaterialCheckTemp() {
		// TODO Auto-generated method stub
		return productionApplicationService.findMaterialCheckTemp();
	}
	
	@Override
	public void bathMrpGathering(List<MrpGatheringTO> mrpGatheringList) {
		// TODO Auto-generated method stub
		productionApplicationService.bathMrpGathering(mrpGatheringList);
	}

	@Override
	public void registWorkInstruction(List<WorkInstructionTO> workInstructionList,
			List<MrpGatheringTO> mrpGatheringList, List<MaterialPaymentTO> materialPaymentList,
			List<StockTO> stockList
			) {
		// TODO Auto-generated method stub
		productionApplicationService.registWorkInstruction(workInstructionList,mrpGatheringList,materialPaymentList,stockList);

	}

	@Override
	public List<PrmTO> findPrmList() {
		// TODO Auto-generated method stub
		return productionApplicationService.findPrmList();
	}

	@Override
	public void registPrm(List<WorkInstructionTO> workInstructionList, List<PrmTO> prmList, List<StockTO> stockList , List<WarehousingTO> warehousingList ) {
		// TODO Auto-generated method stub
		productionApplicationService.registPrm(workInstructionList, prmList, stockList, warehousingList);
	}

	@Override
	public List<MrpOpenTempTO> findMrpOpenTempProcessList(String mpsNo) {
		// TODO Auto-generated method stub
		return productionApplicationService.findMrpOpenTempProcessList(mpsNo);
	}
	
	@Override
	public List<MrpOpenTempTO> findMrpOpenTempProcessList(HashMap<String, Object> paramMap) {
		// TODO Auto-generated method stub
		return productionApplicationService.findMrpOpenTempProcessList(paramMap);
	}

	@Override
	public List<MrpGatheringTO2> findMrpGatheringList2(List<MrpTO> mrpList) {
		// TODO Auto-generated method stub
		return productionApplicationService.findMrpGatheringList2(mrpList);
	}


	@Override
	public List<MrpGatheringTO> registMrpGathering(HashMap<String, Object> paramMap) {
		// TODO Auto-generated method stub
		return productionApplicationService.registMrpGathering(paramMap);
	}


}
