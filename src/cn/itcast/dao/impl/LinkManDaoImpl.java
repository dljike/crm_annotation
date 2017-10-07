package cn.itcast.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import cn.itcast.dao.LinkManDao;
import cn.itcast.domain.LinkMan;
@Repository("linkManDao")
public class LinkManDaoImpl  implements LinkManDao {
	@Autowired
	private HibernateTemplate hibernateTemplate;
	@Override
	public int getAllCount(DetachedCriteria dc) {
		// 离线查询总行数
		 dc.setProjection(Projections.rowCount());
		 List<Long> count = (List<Long>) hibernateTemplate.findByCriteria(dc);
		return count.get(0).intValue();
	}

	@Override
	public List<LinkMan> getCustomerList(DetachedCriteria dc, int start, int pageSize) {
		dc.setProjection(null);
		List<LinkMan> list = (List<LinkMan>) hibernateTemplate.findByCriteria(dc,start,pageSize);
		for (LinkMan linkMan : list) {
			System.out.println(linkMan);
		}
		return list;
	}

	@Override
	public void save(LinkMan linkMan) {
		 hibernateTemplate.save(linkMan);
	}

}
