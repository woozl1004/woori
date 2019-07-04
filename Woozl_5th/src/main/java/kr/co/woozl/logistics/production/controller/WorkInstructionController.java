package kr.co.woozl.logistics.production.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tobesoft.xplatform.data.PlatformData;

import kr.co.woozl.common.mapper.DatasetBeanMapper;
import kr.co.woozl.logistics.production.sf.ProductionServiceFacade;
import kr.co.woozl.logistics.production.to.MaterialCheckTempTO;
import kr.co.woozl.logistics.production.to.MrpGatheringTO;
import kr.co.woozl.logistics.production.to.WorkInstructionTO;
import kr.co.woozl.logistics.purchase.to.MaterialPaymentTO;
import kr.co.woozl.logistics.purchase.to.StockTO;

@Controller
public class WorkInstructionController  {

	@Autowired
	private ProductionServiceFacade productionServiceFacade;

	@Autowired
	private DatasetBeanMapper datasetBeanMapper;

	@RequestMapping("logistics/production/findWorkInstructionList.do")
	public void findWorkInstructionList (HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		PlatformData inData = (PlatformData) request.getAttribute("inData");

		PlatformData outData = (PlatformData) request.getAttribute("outData");
		
		HashMap<String, Object> map = new HashMap<>();
		
		String fromDate = inData.getVariable("fromDate").getString();
		
		String toDate = inData.getVariable("toDate").getString();
		
		map.put("fromDate",fromDate);
		map.put("toDate",toDate);
		
		List<WorkInstructionTO> workInstructionList = productionServiceFacade.findWorkInstructionList(map);

		datasetBeanMapper.beansToDataset(outData, workInstructionList, WorkInstructionTO.class);


	}

	@RequestMapping("logistics/production/registWorkInstruction.do")
	public void registWorkInstruction(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		PlatformData inData = (PlatformData) request.getAttribute("inData");

		List<WorkInstructionTO> workInstruction = datasetBeanMapper.datasetToBeans(inData, WorkInstructionTO.class);

		List<MrpGatheringTO> mrpGatheringlList = datasetBeanMapper.datasetToBeans(inData, MrpGatheringTO.class);

		List<MaterialPaymentTO> materialPaymentList = datasetBeanMapper.datasetToBeans(inData, MaterialPaymentTO.class);

		List<StockTO> stockList = datasetBeanMapper.datasetToBeans(inData, StockTO.class);

		productionServiceFacade.registWorkInstruction(workInstruction,mrpGatheringlList,materialPaymentList,stockList);

		findWorkInstructionList(request, response);


	}

	@RequestMapping("logistics/production/findWorkInstructionOpen.do")
	public void findWorkInstructionOpen (HttpServletRequest request, HttpServletResponse response) throws Exception{

		PlatformData inData = (PlatformData) request.getAttribute("inData");
		
		PlatformData outData = (PlatformData) request.getAttribute("outData");
		
		HashMap<String, Object> paramMap = new HashMap<>();
		
		String mrpGatherNum = inData.getVariable("mrpGatherNum").getString();
		
		paramMap.put("mrpGatherNum", mrpGatherNum);
		
		List<MaterialCheckTempTO> workInstructionOpenList = productionServiceFacade.findWorkInstructionOpen(paramMap);
		
		List<MaterialCheckTempTO> checkOpenTemp=(List<MaterialCheckTempTO>)paramMap.get("result");

		datasetBeanMapper.beansToDataset(outData, checkOpenTemp, MaterialCheckTempTO.class);


	}

	@RequestMapping("logistics/production/findMaterialCheckTemp.do")
	public void findMaterialCheckTemp (HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		PlatformData outData = (PlatformData) request.getAttribute("outData");
		
		List<MaterialCheckTempTO> materialCheckList = productionServiceFacade.findMaterialCheckTemp();

		datasetBeanMapper.beansToDataset(outData, materialCheckList, MaterialCheckTempTO.class);


	}


}
