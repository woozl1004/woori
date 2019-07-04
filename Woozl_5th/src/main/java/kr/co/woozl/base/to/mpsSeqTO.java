package kr.co.woozl.base.to;

import kr.co.woozl.common.annotation.Dataset;
import kr.co.woozl.common.to.BaseTO;

@Dataset(name="gds_seqNo")
public class mpsSeqTO extends BaseTO{
	
	String seqNo;

	public String getSeqNo() {
		return seqNo;
	}

	public void setSeqNo(String seqNo) {
		this.seqNo = seqNo;
	}
	
}

