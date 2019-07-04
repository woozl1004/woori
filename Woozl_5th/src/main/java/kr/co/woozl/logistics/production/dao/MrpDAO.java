package kr.co.woozl.logistics.production.dao;

import java.util.List;
import java.util.Map;

import kr.co.woozl.logistics.production.to.MrpOpenTempTO;
import kr.co.woozl.logistics.production.to.MrpTO;

public interface MrpDAO {

	public List<MrpTO> selectMrpList();

	public void insertMrp(MrpTO mrpTO);

	public void updateMrp(MrpTO mrpTO);

	public List<MrpOpenTempTO> MrpOpenTempProcessList(String mpsNo);
	
	public List<MrpOpenTempTO> MrpOpenTempProcessList(Map<String,Object> parameters);

}
