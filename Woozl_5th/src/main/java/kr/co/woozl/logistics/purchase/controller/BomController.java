package kr.co.woozl.logistics.purchase.controller;

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
import kr.co.woozl.logistics.purchase.sf.PurchaseServiceFacade;
import kr.co.woozl.logistics.purchase.to.BomDeployTO;
import kr.co.woozl.logistics.purchase.to.BomTO;

@Controller
public class BomController  {

	@Autowired
	private PurchaseServiceFacade purchaseServiceFacade;

	@Autowired
	private DatasetBeanMapper datasetBeanMapper;

	@RequestMapping("logistics/purchase/findBomList.do")
	public void findBomList(HttpServletRequest request, HttpServletResponse response) throws Exception{

		PlatformData outData = (PlatformData) request.getAttribute("outData");

		List<BomTO> bomList= purchaseServiceFacade.findBomList();

        datasetBeanMapper.beansToDataset(outData, bomList, BomTO.class);

	}

	@RequestMapping("logistics/purchase/findBomDeployList.do")
	public void findBomDeployList(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		Map<String,Object> map=new HashMap<String,Object>();

		PlatformData inData = (PlatformData) request.getAttribute("inData");
		
		PlatformData outData = (PlatformData) request.getAttribute("outData");
		
		 String itemCode = inData.getVariable("itemCode").getString();

		 String deployCondition = inData.getVariable("deployCondition").getString();
		 
		map.put("itemCode", itemCode);
		map.put("deployCondition", deployCondition);
		 
		List<BomDeployTO> bomDeployList = purchaseServiceFacade.findBomDeployList(map);

		datasetBeanMapper.beansToDataset(outData, bomDeployList, BomDeployTO.class);
	}


	@RequestMapping("logistics/purchase/findBomDeployList2.do")
	public void findBomDeployList2(HttpServletRequest request, HttpServletResponse response) throws Exception{

		PlatformData inData = (PlatformData) request.getAttribute("inData");
		
		PlatformData outData = (PlatformData) request.getAttribute("outData");
		
		Map<String,Object> map=new HashMap<String,Object>();
		
		String itemCode = inData.getVariable("itemCode").getString();

		 String deployCondition = inData.getVariable("deployCondition").getString();
		 
		 map.put("itemCode", itemCode);
		 
		 map.put("deployCondition", deployCondition);

		List<BomDeployTO> bomDeployList = purchaseServiceFacade.findBomDeployList2(map);

		datasetBeanMapper.beansToDataset(outData, bomDeployList, BomDeployTO.class);
	}
	

	@RequestMapping("logistics/purchase/batchBom.do")
	public void batchBom(HttpServletRequest request, HttpServletResponse response) throws Exception{

		PlatformData inData = (PlatformData) request.getAttribute("inData");
		
		List<BomTO> bomList = datasetBeanMapper.datasetToBeans(inData, BomTO.class);
		
		purchaseServiceFacade.batchBom(bomList);
		
		findBomList(request, response);
	}


}
