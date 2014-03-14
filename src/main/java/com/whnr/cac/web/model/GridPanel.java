package com.whnr.cac.web.model;

import java.util.ArrayList;
import java.util.List;

public class GridPanel {
    private String xtype = "grid";
    private boolean forceFit =true;
    private boolean border =false;
    private List<Column> columns;
    private Store store;
   
	public String getXtype() {
		return xtype;
	}
	public void setXtype(String xtype) {
		this.xtype = xtype;
	}
	public boolean isForceFit() {
		return forceFit;
	}
	public void setForceFit(boolean forceFit) {
		this.forceFit = forceFit;
	}
	public List<Column> getColumns() {
		return columns;
	}
	public void setColumns(List<Column> columns) {
		this.columns = columns;
	}
	public void addColumn(Column column)
	{
		if(null == columns)
		{
			columns = new ArrayList<Column>();
		}
		columns.add(column);
	}
	public Store getStore() {
		return store;
	}
	public void setStore(Store store) {
		this.store = store;
	}
	 public class Column{
	    	private String text;
	    	private String dataIndex;
			public String getText() {
				return text;
			}
			public void setText(String text) {
				this.text = text;
			}
			public String getDataIndex() {
				return dataIndex;
			}
			public void setDataIndex(String dataIndex) {
				this.dataIndex = dataIndex;
			}
	    }
	 public class Store{
	    	private List<String> fields ;

			public List<String> getFields() {
				return fields;
			}

			public void setFields(List<String> fields) {
				this.fields = fields;
			}	
	    }
}
