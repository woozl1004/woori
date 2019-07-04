package kr.co.woozl.hr.emp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tobesoft.xplatform.data.PlatformData;

import kr.co.woozl.common.mapper.DatasetBeanMapper;
import kr.co.woozl.hr.emp.sf.EmpServiceFacade;
import kr.co.woozl.hr.emp.to.EmployeeTO;


@Controller
public class EmployeeController  {

	@Autowired
	private EmpServiceFacade empServiceFacade;

	@Autowired
	private DatasetBeanMapper datasetBeanMapper;
	
	@RequestMapping("hr/emp/findEmployeeList.do")
	public void findEmployeeList(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		PlatformData outData = (PlatformData) request.getAttribute("outData");
		
		List<EmployeeTO> employeeList = empServiceFacade.findEmployeeList();
		
		datasetBeanMapper.beansToDataset(outData, employeeList, EmployeeTO.class);
		
	}
	
	@RequestMapping("hr/emp/batchEmployee.do")
	public void batchEmployee(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		PlatformData inData = (PlatformData) request.getAttribute("inData");
		
		List<EmployeeTO> employeeList = datasetBeanMapper.datasetToBeans(inData, EmployeeTO.class);
				
		empServiceFacade.batchEmployee(employeeList);

		findEmployeeList(request,response);
		
	}
	
}
