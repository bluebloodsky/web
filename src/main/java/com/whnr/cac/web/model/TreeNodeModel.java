package com.whnr.cac.web.model;

import java.util.List;
import java.util.ArrayList;
public class TreeNodeModel {
	private String id;
	private String text;
	private boolean leaf = true; 
	private String  href;
	private String hrefTarget = "mainFrame";
	private boolean expanded = false;
	private boolean draggable = false;
	private String lnType;
	private String lnInst;
	private List<TreeNodeModel> children;
	

	public TreeNodeModel(String text)
	{
		this.text=text;
	}
	public TreeNodeModel()
	{}
	public String getHrefTarget() {
		return hrefTarget;
	}
	public void setHrefTarget(String hrefTarget) {
		this.hrefTarget = hrefTarget;
	}
	public boolean isExpanded() {
		return expanded;
	}
	public void setExpanded(boolean expanded) {
		this.expanded = expanded;
	}
	public boolean isDraggable() {
		return draggable;
	}
	public void setDraggable(boolean draggable) {
		this.draggable = draggable;
	}
	public String getLnType() {
		return lnType;
	}
	public void setLnType(String lnType) {
		this.lnType = lnType;
	}
	public String getLnInst() {
		return lnInst;
	}
	public void setLnInst(String lnInst) {
		this.lnInst = lnInst;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public boolean isLeaf() {
		return leaf;
	}
	public void setLeaf(boolean leaf) {
		this.leaf = leaf;
	}
	public List<TreeNodeModel> getChildren() {
		return children;
	}
	public void setChildren(List<TreeNodeModel> children) {
		this.children = children;
	}
	public void addChild(TreeNodeModel child)
	{
		if(children == null)
		{
			children = new ArrayList<TreeNodeModel>();
		}
		children.add(child);
		leaf = false;
		expanded = true;
	}
	public String getHref() {
		return href;
	}
	public void setHref(String href) {
		this.href = href;
	}
	public boolean hasChildren(){
		if(null != children &&!children.isEmpty())
		{
			return true;
		}
		else
		{
			return false;
		}
	}



}
