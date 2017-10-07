package cn.itcast.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.dao.BaseDictDao;
import cn.itcast.domain.BaseDict;
import cn.itcast.service.BaseDictService;

@Service("baseDictService")
@Transactional
public class BaseDictServiceImpl implements BaseDictService {
	
	@Autowired
	private BaseDictDao baseDictDao;
	

	public List<BaseDict> findDictByTypeCode(BaseDict baseDict) {
		List<BaseDict> list = baseDictDao.findDictByTypeCode( baseDict);
		return list;
	}

}
