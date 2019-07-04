package kr.co.woozl.logistics.business.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tobesoft.xplatform.data.PlatformData;

import kr.co.woozl.common.mapper.DatasetBeanMapper;
import kr.co.woozl.logistics.business.sf.BusinessServiceFacade;
import kr.co.woozl.logistics.business.to.ContractDetailTO;
import kr.co.woozl.logistics.business.to.ContractTO;


@Controller
public class ContractController  {

	@Autowired
	private BusinessServiceFacade businessServiceFacade;
	
	@Autowired
	private DatasetBeanMapper datasetBeanMapper;
	
	@Autowired
	 private DataSource dataSource;
	
	@RequestMapping("logistics/business/findContractList.do")
	public void findContractList(HttpServletRequest request, HttpServletResponse response) throws Exception{
	
		Map<String,Object> map=new HashMap<String,Object>();
		
		PlatformData outData = (PlatformData) request.getAttribute("outData");
		
		PlatformData inData = (PlatformData) request.getAttribute("inData");
		
		String fromDate = inData.getVariable("fromDate").getString();
		
		String toDate = inData.getVariable("toDate").getString();
		
		map.put("fromDate", fromDate);
		map.put("toDate", toDate);
		
		List<ContractTO> contractList = businessServiceFacade.findContractList(map);
			
		datasetBeanMapper.beansToDataset(outData, contractList, ContractTO.class);
			
	}
	
	@RequestMapping("logistics/business/findContractDetailList.do")
	public void findContractDetailList(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		Map<String,Object> map=new HashMap<String,Object>();
		
		PlatformData outData = (PlatformData) request.getAttribute("outData");
		
		PlatformData inData = (PlatformData) request.getAttribute("inData");
		
		String fromDate = inData.getVariable("fromDate").getString();
		
		String toDate = inData.getVariable("toDate").getString();
		
		map.put("fromDate", fromDate);
		map.put("toDate", toDate);
		
		List<ContractDetailTO> contractDetailList = businessServiceFacade.findContractDetailList(map);
		
		datasetBeanMapper.beansToDataset(outData, contractDetailList, ContractDetailTO.class);
		
	}
	
	
	@RequestMapping("logistics/business/findMpsCheckList.do")
	public void findMpsCheckList(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		PlatformData inData = (PlatformData) request.getAttribute("inData");
		
		PlatformData outData = (PlatformData) request.getAttribute("outData");
		
		String startDate = inData.getVariable("startDate").getString();
		
		String endDate = inData.getVariable("endDate").getString();
		
		List<ContractDetailTO> MpsCheckList = businessServiceFacade.findMpsCheckList(startDate,endDate);
		
		datasetBeanMapper.beansToDataset(outData, MpsCheckList, ContractDetailTO.class);
		
	}
	
	@RequestMapping("logistics/business/batchContract.do")
	public void batchContract(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		PlatformData inData = (PlatformData) request.getAttribute("inData");
		
		List<ContractTO> contractList = datasetBeanMapper.datasetToBeans(inData, ContractTO.class); 
		
		List<ContractDetailTO> contractDetailList = datasetBeanMapper.datasetToBeans(inData, ContractDetailTO.class);
		
		businessServiceFacade.batchContract(contractList,contractDetailList);
		
		//findContractList(request, response);
		//findContractDetailList(request, response);
		
	}
	
	   @RequestMapping("logistics/business/printContract.do")
	   public ModelAndView printContract(HttpServletRequest request, HttpServletResponse response) throws Exception {
		   System.out.println("gg");
	       String contract_no = request.getParameter("contractNo");
	       
	       String format = request.getParameter("format");

	      ModelMap modelMap = new ModelMap();
	      modelMap.put("format", "pdf");
	      modelMap.put("contract_no", contract_no);
	      modelMap.put("jdbcDataSource", dataSource);
	      
	      ModelAndView modelAndView = new ModelAndView("multiformat-view", modelMap);
	      
	      return modelAndView;
	   }
	 
}
