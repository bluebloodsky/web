package com.whnr.cac.web.model;

import java.util.ArrayList;
import java.util.List;

public class ComponentModel {
	private String id;
	private String title;
	private String text;
	private boolean border=false;
	private String name;
	private List<Object> items;
	private String layout;
	private String xtype;
	private String href;
	private String html;
	private float columnWidth;
	
	public float getColumnWidth() {
		return columnWidth;
	}
	public void setColumnWidth(float columnWidth) {
		this.columnWidth = columnWidth;
	}
	public String getHref() {
		return href;
	}
	public void setHref(String href) {
		this.href = href;
	}
	public String getHtml() {
		return html;
	}
	public void setHtml(String html) {
		this.html = html;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public boolean isBorder() {
		return border;
	}
	public void setBorder(boolean border) {
		this.border = border;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getLayout() {
		return layout;
	}
	public void setLayout(String layout) {
		this.layout = layout;
	}
	public List<Object> getItems() {
		return items;
	}
	public void setItems(List<Object> items) {
		this.items = items;
	}
	public void addItem(Object obj){
		if(null == this.items)
		{
			this.items = new ArrayList<Object>();
		}
		this.items.add(obj);
	}
	public String getXtype() {
		return xtype;
	}
	public void setXtype(String xtype) {
		this.xtype = xtype;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
}
