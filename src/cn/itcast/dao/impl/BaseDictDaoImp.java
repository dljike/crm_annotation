package cn.itcast.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import cn.itcast.dao.BaseDictDao;
import cn.itcast.domain.BaseDict;
@Repository("baseDictDao")
public class BaseDictDaoImp implements BaseDictDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Override
	public List<BaseDict> findDictByTypeCode(BaseDict baseDict) {
		List<BaseDict> list = (List<BaseDict>) hibernateTemplate.find("from BaseDict where dict_type_code=?",baseDict.getDict_type_code());
		return list;
	}

}
