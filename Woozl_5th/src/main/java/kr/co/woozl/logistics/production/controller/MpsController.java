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
import kr.co.woozl.logistics.business.to.ContractDetailTO;
import kr.co.woozl.logistics.production.sf.ProductionServiceFacade;
import kr.co.woozl.logistics.production.to.MpsTO;


@Controller
public class MpsController  {

	@Autowired
	private ProductionServiceFacade productionServiceFacade;
	
	@Autowired
	private DatasetBeanMapper datasetBeanMapper;

	@RequestMapping("logistics/production/findMpsList.do")
	public void findMpsList (HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		PlatformData inData = (PlatformData) request.getAttribute("inData");
		
		PlatformData outData = (PlatformData) request.getAttribute("outData");
		
		HashMap<String, Object> map = new HashMap<>();
		
		String select = inData.getVariable("select").getString();
		
		map.put("select",select);
		
		List<MpsTO> mpsList = productionServiceFacade.findMpsList(map);
		
		datasetBeanMapper.beansToDataset(outData, mpsList, MpsTO.class);
		
		
	}
	
	@RequestMapping("logistics/production/registerMps.do")
	public void registerMps(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		PlatformData inData = (PlatformData) request.getAttribute("inData");
		
		List<MpsTO> mpsList = datasetBeanMapper.datasetToBeans(inData, MpsTO.class); 
		
		List<ContractDetailTO> contractDetailList = datasetBeanMapper.datasetToBeans(inData, ContractDetailTO.class);
		
			
		productionServiceFacade.registerMps(mpsList,contractDetailList);
		
		//findMpsList(request, response);
		
		
	}
	
	
	
}
