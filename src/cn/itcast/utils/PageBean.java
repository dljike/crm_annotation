package cn.itcast.utils;

import java.util.List;

import cn.itcast.domain.Customer;

public class PageBean<T> {

	private List<T> datas;// ��ǰҳ�����ݼ���
	private int total; // �ܼ�¼����
	private int totalPage; // ��ҳ��
	private int pageSize=3;// ��ʾ����
	private int cuurentPage=1;// ��ǰҳ
	private int start; // ��ʼλ��
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
