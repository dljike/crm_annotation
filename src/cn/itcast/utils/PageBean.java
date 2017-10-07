package cn.itcast.utils;

import java.util.List;

import cn.itcast.domain.Customer;

public class PageBean<T> {

	private List<T> datas;// 当前页面数据集合
	private int total; // 总记录条数
	private int totalPage; // 总页数
	private int pageSize=3;// 显示数量
	private int cuurentPage=1;// 当前页
	private int start; // 开始位置
	public List<T> getDatas() {
		return datas;
	}
	public void setDatas(List<T> datas) {
		this.datas = datas;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getTotalPage() {
		return total % pageSize==0?total/pageSize:total/pageSize+1;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getCuurentPage() {
		return cuurentPage;
	}
	public void setCuurentPage(int cuurentPage) {
		this.cuurentPage = cuurentPage;
	}
	public int getStart() {
		return (cuurentPage-1)*pageSize;
	}
	public void setStart(int start) {
		this.start = start;
	}
	@Override
	public String toString() {
		return "PageBean [datas=" + datas + ", total=" + total + ", totalPage=" + totalPage + ", pageSize=" + pageSize
				+ ", cuurentPage=" + cuurentPage + ", start=" + start + "]";
	}
	
	
	
	
}
