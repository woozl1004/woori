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
import kr.co.woozl.logistics.base.to.CompanyTO;


@Controller
public class CompanyController  {

	@Autowired
	private ManagementServiceFacade managementServiceFacade;

	@Autowired
	private DatasetBeanMapper datasetBeanMapper;

	@RequestMapping("logistics/base/findCompanyList.do")
	public void findCompanyList(HttpServletRequest request, HttpServletResponse response) throws Exception{

		PlatformData outData = (PlatformData) request.getAttribute("outData");
		
		List<CompanyTO> companyList = managementServiceFacade.findCompanyList();

		datasetBeanMapper.beansToDataset(outData, companyList, CompanyTO.class);

	}

	@RequestMapping("logistics/base/batchCompanyList.do")
	public void batchCompanyList(HttpServletRequest request, HttpServletResponse response) throws Exception{

		PlatformData inData = (PlatformData) request.getAttribute("inData");
		
		List<CompanyTO> batchCompanyList = datasetBeanMapper.datasetToBeans(inData, CompanyTO.class);
				
		managementServiceFacade.batchCompanyList(batchCompanyList);

		

	}

}
