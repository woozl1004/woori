package kr.co.woozl.base.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tobesoft.xplatform.data.PlatformData;

import kr.co.woozl.base.to.DustStatusTO;
import kr.co.woozl.common.mapper.DatasetBeanMapper;
import kr.co.woozl.common.util.DustStatus;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class DustStatusController {
   @Autowired
   private DatasetBeanMapper datasetBeanMapper;
   
   @Autowired
   private DustStatus dustStatus;

   @RequestMapping("base/findDustStatus.do")
   public void findDustStatus(HttpServletRequest request, HttpServletResponse response) throws Exception {
      System.out.println("findDustStatus");
      request.getAttribute("inData");
      
      PlatformData outData = (PlatformData) request.getAttribute("outData");
      
      List<DustStatusTO> dustList=dustStatus.sendDustStatus();
      
      datasetBeanMapper.beansToDataset(outData, dustList, DustStatusTO.class);
   }

}