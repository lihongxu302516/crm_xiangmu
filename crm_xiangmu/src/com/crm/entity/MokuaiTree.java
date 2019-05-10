package com.crm.entity;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class MokuaiTree {
	private Integer id;
	private String text;
	private Boolean checked;
	private List<MokuaiTree> children;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Boolean getChecked() {
		return checked;
	}
	public void setChecked(Boolean checked) {
		this.checked = checked;
	}
	public List<MokuaiTree> getChildren() {
		return children;
	}
	public void setChildren(List<MokuaiTree> children) {
		this.children = children;
	}
	@Override
	public String toString() {
		return "MokuaiTree [id=" + id + ", text=" + text + ", checked=" + checked + ", children=" + children + "]";
	}
	
}
