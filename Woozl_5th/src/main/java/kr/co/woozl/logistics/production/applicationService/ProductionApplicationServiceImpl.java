package kr.co.woozl.logistics.production.applicationService;


import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.co.woozl.logistics.business.applicationService.BusinessApplicationService;
import kr.co.woozl.logistics.business.to.ContractDetailTO;
import kr.co.woozl.logistics.production.dao.MpsDAO;
import kr.co.woozl.logistics.production.dao.MrpDAO;
import kr.co.woozl.logistics.production.dao.MrpGatheringDAO;
import kr.co.woozl.logistics.production.dao.PrmDAO;
import kr.co.woozl.logistics.production.dao.WorkInstructionDAO;
import kr.co.woozl.logistics.production.to.MaterialCheckTempTO;
import kr.co.woozl.logistics.production.to.MpsTO;
import kr.co.woozl.logistics.production.to.MrpGatheringTO;
import kr.co.woozl.logistics.production.to.MrpGatheringTO2;
import kr.co.woozl.logistics.production.to.MrpOpenTempTO;
import kr.co.woozl.logistics.production.to.MrpTO;
import kr.co.woozl.logistics.production.to.PrmTO;
import kr.co.woozl.logistics.production.to.WorkInstructionTO;
import kr.co.woozl.logistics.purchase.applicationService.PurchaseApplicationService;
import kr.co.woozl.logistics.purchase.to.MaterialPaymentTO;
import kr.co.woozl.logistics.purchase.to.StockTO;
import kr.co.woozl.logistics.purchase.to.WarehousingTO;

@Component
public class ProductionApplicationServiceImpl implements ProductionApplicationService{

	@Autowired
	private MpsDAO mpsDAO;

	@Autowired
	private MrpDAO mrpDAO;

	@Autowired
	private MrpGatheringDAO mrpGatheringDAO;

	@Autowired
	private WorkInstructionDAO workInstructionDAO;

	@Autowired
	private PrmDAO prmDAO;

	@Autowired
	private PurchaseApplicationService pruchaseApplicationSerivce;

	@Autowired
	private BusinessApplicationService businessApplicationService;

	@Override
	public List<MpsTO> findMpsList(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return mpsDAO.selectMpsList(map);
	}

	@Override
	public void registerMps(List<MpsTO> mpsList, List<ContractDetailTO> contractDetailList) {
		// TODO Auto-generated method stub


		if(mpsList!=null) {	

		for(MpsTO mpsTO : mpsList) {

			switch(mpsTO.getStatus()) {

			case "insert" : mpsDAO.insertMps(mpsTO);	break;
			//case "update" : contractDAO.updateContract(contractTO); break;
			//case "delete" : contractDAO.deleteContract(contractTO); break;

			}

		}

		}


		if(contractDetailList!=null) {

			businessApplicationService.batchContract(null, contractDetailList);

		}




	}


	@Override
	public List<MrpTO> findMrpList() {
		// TODO Auto-generated method stub
		return mrpDAO.selectMrpList();
	}


	@Override
	public List<MrpGatheringTO> findMrpGatheringList() {
		// TODO Auto-generated method stub
		return mrpGatheringDAO.selectMrpGatheringList();
	}

	@Override
	public List<WorkInstructionTO> findWorkInstructionList(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return workInstructionDAO.selectWorkInstructionList(map);
	}
	
	@Override
	public List<MaterialCheckTempTO> findWorkInstructionOpen(HashMap<String, Object> paramMap) {
		// TODO Auto-generated method stub
		return workInstructionDAO.workInstructionOpen(paramMap);
	}
	
	@Override
	public List<MaterialCheckTempTO> findMaterialCheckTemp() {
		// TODO Auto-generated method stub
		return workInstructionDAO.selectMaterialCheckTemp();
	}

	@Override
	public void bathMrpGathering(List<MrpGatheringTO> mrpGatheringList) {
		// TODO Auto-generated method stub

		for(MrpGatheringTO mrpGatheringTO : mrpGatheringList) {

			System.out.println(mrpGatheringTO.getStatus());

			switch(mrpGatheringTO.getStatus()) {
			case "insert" : mrpGatheringDAO.insertMrpGathering(mrpGatheringTO); break;
			case "update" : mrpGatheringDAO.updateMrpGathering(mrpGatheringTO); break;
			case "delete" : mrpGatheringDAO.deleteMrpGathering(mrpGatheringTO); break;

			}

		}

	}
	

	@Override
	public void registWorkInstruction(List<WorkInstructionTO> workInstructionList,
			List<MrpGatheringTO> mrpGatheringList, List<MaterialPaymentTO> materialPaymentList, List<StockTO> stockList) {
		// TODO Auto-generated method stub



		for(WorkInstructionTO workInstructionTO : workInstructionList) {



			switch(workInstructionTO.getStatus()) {
			case "insert" : workInstructionDAO.insertWorkInstruction(workInstructionTO); break;
			case "update" : workInstructionDAO.updateWorkInstruction(workInstructionTO); break;
			case "delete" : workInstructionDAO.deleteWorkInstruction(workInstructionTO); break;

			}

		}


		if(mrpGatheringList!=null) {
		bathMrpGathering(mrpGatheringList);
		}

		if(materialPaymentList!=null) {
		pruchaseApplicationSerivce.registMaterialPayment(materialPaymentList);
		}

		if(stockList!=null) {
		pruchaseApplicationSerivce.bathStock(stockList);
		}

	}

	@Override
	public List<PrmTO> findPrmList() {
		// TODO Auto-generated method stub
		return prmDAO.selectPrmList();
	}



	@Override
	public void registPrm(List<WorkInstructionTO> workInstructionList, List<PrmTO> prmList, List<StockTO> stockList , List<WarehousingTO> warehousingList) {
		// TODO Auto-generated method stub


		for(PrmTO prmTO : prmList) {

			switch(prmTO.getStatus()) {
			case "insert" : prmDAO.insertPrm(prmTO); break;
			//case "update" : prmDAO.updatePrm(prmTO); break;
			//case "delete" : prmDAO.deletePrm(prmTO); break;

			}

		}

		registWorkInstruction(workInstructionList,null,null,null);

		pruchaseApplicationSerivce.bathStock(stockList);

		pruchaseApplicationSerivce.registWarehousing(null,null,null,warehousingList);
	}

	@Override
	public List<MrpOpenTempTO> findMrpOpenTempProcessList(String mpsNo) {
		// TODO Auto-generated method stub

		         MpsTO  mpsTO = new MpsTO();
		         mpsTO.setMpsNo(mpsNo);
		         mpsTO.setStatus("update");
		         mpsTO.setMrpApplyStatus("Y");
		         mpsDAO.updeteMps(mpsTO);


				 MrpTO  mrpTO = null;
		         List<MrpOpenTempTO> mrpOpenList = mrpDAO.MrpOpenTempProcessList(mpsNo);

		         int number = 1;

		         for(MrpOpenTempTO mrpOpenTO:mrpOpenList) {
		         mrpTO = new MrpTO();
		         String mpsNumber = mrpOpenTO.getMpsNo();
		         String mrpNo = "RP"+mpsNumber.substring(2)+Integer.toString(number);
		        
		         		         
		         mrpTO.setMrpNo(mrpNo);
		         mrpTO.setMpsNo(mpsNumber);
		         mrpTO.setItemClassification(mrpOpenTO.getItemClassification());
		         mrpTO.setItemCode(mrpOpenTO.getItemCode());
		         mrpTO.setItemName(mrpOpenTO.getItemName());
		         mrpTO.setUnitOfMrp(mrpOpenTO.getUnitOfMrp());
		         mrpTO.setRequiredAmount(mrpOpenTO.getRequiredAmount());
		         mrpTO.setOrderDate(mrpOpenTO.getOrderDate());
		         mrpTO.setRequiredDate(mrpOpenTO.getRequiredDate());
		         mrpTO.setMrpGatheringStatus("N");
		         mrpDAO.insertMrp(mrpTO);
		         number++;
		         }

		      return mrpOpenList;

	}
	
	@Override
	public List<MrpOpenTempTO> findMrpOpenTempProcessList(HashMap<String, Object> paramMap) {
		// TODO Auto-generated method stub

		 List<MrpOpenTempTO> mrpOpenList = mrpDAO.MrpOpenTempProcessList(paramMap);

/*		 mrpOpenList = (List<MrpOpenTempTO>)paramMap.get("result");*/

		return mrpOpenList;
	}


	@Override
	public List<MrpGatheringTO2> findMrpGatheringList2(List<MrpTO> mrplist) {
		// TODO Auto-generated method stub

		String mrpNo = "";

		MrpTO  mrpTO = new MrpTO();

	      for(MrpTO mrpto : mrplist) {
	         mrpNo += mrpto.getMrpNo()+",";
	      }

	      if(mrpNo.length()!=0) {
	      mrpNo = mrpNo.substring(0, mrpNo.length()-1);
	      }


	      List<MrpGatheringTO2> mrpGatheringList = mrpGatheringDAO.selectMrpGatheringList2(mrpNo);


	      for(MrpGatheringTO2 mrpGatheringTO2 : mrpGatheringList) {

	         if(mrpGatheringTO2.getMrpNo().length() < 14) {

	         mrpTO.setMrpNo(mrpGatheringTO2.getMrpNo());
	         mrpTO.setMrpGatheringStatus("Y");
	         mrpDAO.updateMrp(mrpTO);    // mrp취합여부 업데이트
	         }else {

	            String[] array = mrpGatheringTO2.getMrpNo().split(",");
	            for(int i=0;i<array.length;i++) {
	            	System.out.println("qqqqqqqqqq"+mrpGatheringTO2.getMrpGatheringNo());
	               mrpTO.setMrpNo(array[i]);
	               mrpTO.setMrpGatheringNo(mrpGatheringTO2.getMrpGatheringNo());
	               mrpTO.setMrpGatheringStatus("Y");
	               mrpDAO.updateMrp(mrpTO);
	               }
	         }

	         MrpGatheringTO mrpgatheringTO = new MrpGatheringTO();
	         //mrpgatheringTO.setMrpNo(mrpGatheringTO.getMrpNo());
	         mrpgatheringTO.setMrpGatheringNo(mrpGatheringTO2.getMrpGatheringNo());
	         mrpgatheringTO.setOrderOrProductionStatus(mrpGatheringTO2.getOrderOrProductionStatus());
	         mrpgatheringTO.setItemCode(mrpGatheringTO2.getItemCode());
	         mrpgatheringTO.setItemName(mrpGatheringTO2.getItemName());
	         mrpgatheringTO.setUnitOfMrpGathering(mrpGatheringTO2.getUnitOfMrpGathering());
	         mrpgatheringTO.setNecessaryAmount(mrpGatheringTO2.getNecessaryAmount());
	         mrpgatheringTO.setDueDate(mrpGatheringTO2.getDueDate());
	         mrpgatheringTO.setClaimDate(mrpGatheringTO2.getClaimDate());
	         mrpgatheringTO.setOnGoingProcessStatus("N");
	         mrpGatheringDAO.insertMrpGathering(mrpgatheringTO);      // mrpGathering 인서트
	      }
	      return mrpGatheringList;
	}

	@Override
	public List<MrpGatheringTO> registMrpGathering(HashMap<String, Object> paramMap) {
		// TODO Auto-generated method stub

		 List<MrpGatheringTO> mrpOpenList = mrpGatheringDAO.MrpGatheringList(paramMap);

		return mrpOpenList;
	}

}
