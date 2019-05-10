package com.crm.entity;

import java.util.List;

import org.springframework.stereotype.Component;
@Component
public class Fenye<T> {
	private Integer page;
	private Integer limit;
	private T t;
	private Integer total;
	private List<T> rows;
	
	public Integer getPage() {
		return (page-1)*limit;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getLimit() {
		return limit;
	}
	public void setLimit(Integer limit) {
		this.limit = limit;
	}
	public T getT() {
		return t;
	}
	public void setT(T t) {
		this.t = t;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public List<T> getRows() {
		return rows;
	}
	public void setRows(List<T> rows) {
		this.rows = rows;
	}
	@Override
	public String toString() {
		return "Fenye [page=" + page + ", limit=" + limit + ", t=" + t + ", total=" + total + ", rows=" + rows + "]";
	}
}
