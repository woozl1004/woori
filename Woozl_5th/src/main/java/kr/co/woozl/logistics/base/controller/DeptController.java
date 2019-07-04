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
import kr.co.woozl.logistics.base.to.DeptTO;



@Controller
public class DeptController  {

	@Autowired
	private ManagementServiceFacade managementServiceFacade;

	@Autowired
	private DatasetBeanMapper datasetBeanMapper;

	@RequestMapping("logistics/base/findDeptList.do")
	public void findDeptList(HttpServletRequest request, HttpServletResponse response) throws Exception{

		PlatformData outData = (PlatformData) request.getAttribute("outData");
		
		List<DeptTO> deptList = managementServiceFacade.findDeptList();

		datasetBeanMapper.beansToDataset(outData, deptList, DeptTO.class);

	}
	
	@RequestMapping("logistics/base/batchDepartmentList.do")
	public void batchDepartmentList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		PlatformData inData = (PlatformData) request.getAttribute("inData");
		
		List<DeptTO> batchDeptList = datasetBeanMapper.datasetToBeans(inData, DeptTO.class);
		
		managementServiceFacade.batchDepartmentList(batchDeptList);
	}

}
