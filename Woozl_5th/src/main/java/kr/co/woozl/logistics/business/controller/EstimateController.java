package kr.co.woozl.logistics.business.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tobesoft.xplatform.data.PlatformData;

import kr.co.woozl.common.mapper.DatasetBeanMapper;
import kr.co.woozl.logistics.business.sf.BusinessServiceFacade;
import kr.co.woozl.logistics.business.to.EstimateDetailTO;
import kr.co.woozl.logistics.business.to.EstimateTO;

@Controller
public class EstimateController  {

	@Autowired
	private BusinessServiceFacade businessServiceFacade;

	@Autowired
	private DatasetBeanMapper datasetBeanMapper;
	
	@RequestMapping("logistics/business/findEstimateList.do")
	public void findEstimateList(HttpServletRequest request, HttpServletResponse response) throws Exception{	
		
		Map<String,Object> map=new HashMap<String,Object>();
		
		PlatformData outData = (PlatformData) request.getAttribute("outData");
		
		PlatformData inData = (PlatformData) request.getAttribute("inData");
		
		String fromDate = inData.getVariable("fromDate").getString();
		
		String toDate = inData.getVariable("toDate").getString();
		
		map.put("fromDate", fromDate);
		map.put("toDate", toDate);
		
		List<EstimateTO> estimateList = businessServiceFacade.findEstimateList(map);
		
		datasetBeanMapper.beansToDataset(outData, estimateList, EstimateTO.class);
		
	}

	@RequestMapping("logistics/business/findEstimateDialog.do")
	public void findEstimateDialog(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		PlatformData outData = (PlatformData) request.getAttribute("outData");
		
		List<EstimateTO> estimateList = businessServiceFacade.findEstimateDialog();
		
		datasetBeanMapper.beansToDataset(outData, estimateList, EstimateTO.class);
		
	}
	
	
	@RequestMapping("logistics/business/findEstimateDetailList.do")
	public void findEstimateDetailList(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		PlatformData outData = (PlatformData) request.getAttribute("outData");
		
		List<EstimateDetailTO> estimateDetailList = businessServiceFacade.findEstimateDetailList();
		
		datasetBeanMapper.beansToDataset(outData, estimateDetailList, EstimateDetailTO.class);
		
	}
	
	@RequestMapping("logistics/business/batchEstimate.do")
	public void batchEstimate(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		PlatformData inData = (PlatformData) request.getAttribute("inData");
		
		List<EstimateTO> estimateList = datasetBeanMapper.datasetToBeans(inData, EstimateTO.class); 
		
		List<EstimateDetailTO> estimateDetailList = datasetBeanMapper.datasetToBeans(inData, EstimateDetailTO.class);
		
		businessServiceFacade.batchEstimate(estimateList,estimateDetailList);
		
		//findEstimateList(request, response);
		//findEstimateDetailList(request, response);
		
	}
	
	
	
	
	
	
	
}
