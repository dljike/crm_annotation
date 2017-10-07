package cn.itcast.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.itcast.dao.LinkManDao;
import cn.itcast.domain.LinkMan;
import cn.itcast.service.LinkManService;
@Service("linkManService")
public class LinkManServiceImpl implements LinkManService{
	
	@Autowired
	private LinkManDao linkManDao;
	
	@Override
	public int findCount(DetachedCriteria dc) {
		return  linkManDao.getAllCount(dc);
	}

	@Override
	public List<LinkMan> findPageList(DetachedCriteria dc, int start, int pageSize) {
		 List<LinkMan> list = linkManDao.getCustomerList(dc,start,pageSize);
			return list;
	}

	@Override
	public void save(LinkMan linkMan) {
		 linkManDao.save(linkMan);
		
	}

}
