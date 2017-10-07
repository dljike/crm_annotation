package cn.itcast.dao;

import java.util.List;

import cn.itcast.domain.BaseDict;

public interface BaseDictDao {

	List<BaseDict> findDictByTypeCode(BaseDict baseDict);

}
