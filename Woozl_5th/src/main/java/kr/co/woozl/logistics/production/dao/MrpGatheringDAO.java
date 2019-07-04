package kr.co.woozl.logistics.production.dao;

import java.util.List;
import java.util.Map;

import kr.co.woozl.logistics.production.to.MrpGatheringTO;
import kr.co.woozl.logistics.production.to.MrpGatheringTO2;

public interface MrpGatheringDAO {


	public List<MrpGatheringTO> selectMrpGatheringList();

	public void insertMrpGathering(MrpGatheringTO mrpGatheringTO);

	public void updateMrpGathering(MrpGatheringTO mrpGatheringTO);

	public void deleteMrpGathering(MrpGatheringTO mrpGatheringTO);

	public List<MrpGatheringTO2> selectMrpGatheringList2(String mrpNo);

	public List<MrpGatheringTO> MrpGatheringList(Map<String,Object> parameters);

}
