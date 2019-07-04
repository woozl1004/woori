package kr.co.woozl.base.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tobesoft.xplatform.data.PlatformData;

import kr.co.woozl.base.sf.BaseServiceFacade;
import kr.co.woozl.base.to.CodeDetailTO;
import kr.co.woozl.base.to.mpsSeqTO;
import kr.co.woozl.common.mapper.DatasetBeanMapper;


@Controller
public class CodeDetailController  {

	@Autowired
	private BaseServiceFacade baseServiceFacade;

	@Autowired
	private DatasetBeanMapper datasetBeanMapper;
	
	@RequestMapping("base/findCodeDetailList.do")
	public void findCodeDetailList(HttpServletRequest request, HttpServletResponse response) throws Exception{
        
		PlatformData outData = (PlatformData) request.getAttribute("outData");
		
		List<CodeDetailTO> codeDetailList= baseServiceFacade.findCodeDetailList();
        
        datasetBeanMapper.beansToDataset(outData, codeDetailList, CodeDetailTO.class);
        
	}
	
	@RequestMapping("base/batchDetailCode.do")
	public void batchDetailCode(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		PlatformData inData = (PlatformData) request.getAttribute("inData");
		
		List<CodeDetailTO> codeDetailList = datasetBeanMapper.datasetToBeans(inData, CodeDetailTO.class);
		
		baseServiceFacade.batchDetailCode(codeDetailList);
		
		findCodeDetailList(request, response);
		
	}
	
	@RequestMapping("base/takeSerialCode.do")
	public void takeSerialCode(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		PlatformData inData = (PlatformData) request.getAttribute("inData");
		
		PlatformData outData = (PlatformData) request.getAttribute("outData");
		
		Map<String,Object> findSeq=new HashMap<String,Object>();
		
		String Seq = inData.getVariable("findSeq").getString();
		
		findSeq.put("findSeq", Seq);

		String seqNo=baseServiceFacade.takeSerialCode(findSeq);
		
		mpsSeqTO seqTO=new mpsSeqTO();
		
		seqTO.setSeqNo(seqNo);
        
        datasetBeanMapper.beanToDataset(outData, seqTO, mpsSeqTO.class);		
	}
	
	
	
}
