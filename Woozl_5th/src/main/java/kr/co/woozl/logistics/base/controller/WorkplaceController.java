package kr.co.woozl.logistics.base.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tobesoft.xplatform.data.PlatformData;

import kr.co.woozl.common.mapper.DatasetBeanMapper;
import kr.co.woozl.logistics.base.sf.ManagementServiceFacade;
import kr.co.woozl.logistics.base.to.WorkplaceTO;

@Controller
public class WorkplaceController  {

	@Autowired
	private ManagementServiceFacade managementServiceFacade;

	@Autowired
	private DatasetBeanMapper datasetBeanMapper;
	
	@RequestMapping("logistics/base/findWorkplaceList.do")
	public void findWorkplaceList(HttpServletRequest request, HttpServletResponse response) throws Exception{

		PlatformData outData = (PlatformData) request.getAttribute("outData");
		
		List<WorkplaceTO> workplaceList = managementServiceFacade.findWorkplaceList();

		datasetBeanMapper.beansToDataset(outData, workplaceList, WorkplaceTO.class);

	}
	
	@RequestMapping("logistics/base/batchWorkplaceList.do")
	public void batchWorkplaceList(HttpServletRequest request, HttpServletResponse response) throws Exception{

		PlatformData inData = (PlatformData) request.getAttribute("inData");
		
		List<WorkplaceTO> batchWorkplaceList = datasetBeanMapper.datasetToBeans(inData,WorkplaceTO.class);
		
		managementServiceFacade.batchWorkplaceList(batchWorkplaceList);

	}


}
