/**
 * 
 */
package com.shanghai.our.model;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;

/**
 * @author code0
 *	分页处理实体类
 */
public class Pager<T> {
	public static final Integer DEFAULT_PAGE_SIZE = Integer.MAX_VALUE;
	/**
	 * 结果集
	 */
	private List<T> records = new ArrayList<T>();
	/**
	 * 记录总数
	 */
	private Long totalRecords = 0L;
	/**
	 * 当前页 
	 */
	private Integer currentPage = 1;
	/**
	 * 当前页的开始行索引[首页索引从0开始]
	 */
	private Integer offset=0;
	/**
	 * 每页记录数,默认20条
	 */
	private Integer pageSize = DEFAULT_PAGE_SIZE;
	/**
	 * 排序字段名称,多个字段中间使用,分隔
	 */
	private String orderProperty = "";
	/**
	 * 排序方式asc或desc,多个字段中间使用,分隔
	 */
	private String order = "";
	/**
	 * 是否计算总数
	 */
	private boolean countTotal = true;
	
	public List<T> getRecords() {
		return records;
	}
	public void setRecords(List<T> records) {
		this.records = records;
	}
	/**获取记录总条数
	 * @return
	 */
	public Long getTotalRecords() {
		return totalRecords;
	}
	public void setTotalRecords(Long totalRecords) {
		this.totalRecords = totalRecords;
	}
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		if(currentPage <= 0){
			this.currentPage = 1;
		}else{
			this.currentPage = currentPage;
		}
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		if(pageSize <= 0){
			this.pageSize = 1;
		}else{
			this.pageSize = pageSize;
		}
	}
	public boolean isCountTotal() {
		return countTotal;
	}
	public void setCountTotal(boolean countTotal) {
		this.countTotal = countTotal;
	}
	/**
	 * 计算记录的总页数
	 */
	public Long getTotalPages(){
		if(getTotalRecords() == 0){
			return 1L;
		}
		Long div = getTotalRecords()/getPageSize();
		Long sub = getTotalRecords()%getPageSize();
		if(sub == 0){
			return div;
		}else{
			return div + 1;
		}
	}
	/**
	 * 是否设置了排序属性
	 * @return
	 */
	public boolean isOrderBySetted(){
		return StringUtils.isNotBlank(this.order) && StringUtils.isNotBlank(this.orderProperty);
	}
	/**
	 * 当前页记录开始行
	 * @return
	 */
	public Integer getFirstResult(){
		return getOffset();
	}
	/**
	 * 当前页记录截止行
	 * @return
	 */
	public Integer getMaxResult(){
		return getPageSize();
	}
	public void setPager(List<T> records,Long total){
		this.records=records;
		this.totalRecords=total;
	}
	public String getOrderProperty() {
		return orderProperty;
	}
	public void setOrderProperty(String orderProperty) {
		this.orderProperty = orderProperty;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		String lowcaseOrderDir = StringUtils.lowerCase(order);
		//检查order字符串的合法值
		String[] orderDirs = StringUtils.split(lowcaseOrderDir, ',');
		for (String orderDirStr : orderDirs) {
			if (!StringUtils.equals(Sort.DESC, orderDirStr) && !StringUtils.equals(Sort.ASC, orderDirStr)) {
				throw new IllegalArgumentException("排序方向" + orderDirStr + "不是合法值");
			}
		}
		this.order = lowcaseOrderDir;
	}
	/**
	 * 获得排序参数.
	 * @return
	 */
	public List<Sort> getSort() {
		String[] orderBys = StringUtils.split(this.orderProperty, ',');
		String[] orderDirs = StringUtils.split(this.order, ',');
		Validate.isTrue(orderBys.length == orderDirs.length, "分页多重排序参数中,排序字段与排序方向的个数不相等");

		List<Sort> orders = new ArrayList<Sort>();
		for (int i = 0; i < orderBys.length; i++) {
			orders.add(new Sort(orderBys[i], orderDirs[i]));
		}
		return orders;
	}
	
	/**
	 * 复制pager的基本信息，totalRecords,currentPage,pageSize,orderProperty,order,countTotal
	 * @param pager
	 * @return
	 */
	public static <X,M> Pager<M> cloneFromPager(Pager<X> pager){
		Pager<M> result = new Pager<M>();
		result.setCountTotal(pager.isCountTotal());
		result.setCurrentPage(pager.getCurrentPage());
		result.setOrder(pager.getOrder());
		result.setOrderProperty(pager.getOrderProperty());
		result.setPageSize(pager.getPageSize());
		result.setTotalRecords(pager.getTotalRecords());
		return result;
	}
	
	/**
	 * 复制pager的基本信息，totalRecords,currentPage,pageSize,orderProperty,order,countTotal,
	 * 重新设置records，totalRecords属性
	 * @param pager
	 * @return
	 */
	public static <X> Pager<X> cloneFromPager(Pager<X> pager,long totalRecords,List<X> records){
		Pager<X> result = cloneFromPager(pager);
		result.setTotalRecords(totalRecords);
		result.setRecords(records);
		return result;
	}
	
	public static class Sort {
		public static final String ASC = "asc";
		public static final String DESC = "desc";

		private final String property;
		private final String dir;

		public Sort(String property, String dir) {
			this.property = property;
			this.dir = dir;
		}

		public String getProperty() {
			return property;
		}

		public String getDir() {
			return dir;
		}
	}

	/**
	 * @return the offset
	 */
	public Integer getOffset() {
		return offset;
	}
	/**
	 * @param offset the offset to set
	 */
	public void setOffset(Integer offset) {
		if(offset<0){
			offset=0;
		}
		this.offset = offset;
		this.setCurrentPage(offset/this.pageSize+1);
	}
}
