package com.whnr.cac.web.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.springframework.stereotype.Service;

import com.whnr.cac.database.BtMonitorparatype;
import com.whnr.cac.database.BtbMonitordeviceinfo;
import com.whnr.cac.database.BtbMonitordeviceinfoDAO;
import com.whnr.cac.database.BtbSubdevice;
import com.whnr.cac.database.BtbSubdeviceDAO;
import com.whnr.cac.database.BtbSubstation;
import com.whnr.cac.database.BtbSubstationdevice;
import com.whnr.cac.database.DtsDatainfo;
import com.whnr.cac.database.DtsDatainfoDAO;
import com.whnr.cac.database.TDevicetype;
import com.whnr.cac.database.TbCominfo;
import com.whnr.cac.database.TbCominfoDAO;
import com.whnr.cac.web.model.ComponentModel;
import com.whnr.cac.web.model.DoPanel;
import com.whnr.cac.web.model.GridPanel;
import com.whnr.cac.web.model.TreeNodeModel;
@Service
public class DataService {
	public Object loadTree()
	{		
		List<TbCominfo> listCompany =new TbCominfoDAO().findAll();
		List<TreeNodeModel> treeNodes=new ArrayList<TreeNodeModel>();//变电站
		for(TbCominfo company:listCompany)
		{
			TreeNodeModel companyNode =new TreeNodeModel(company.getCompanyName());
			boolean hasParent=false;
			for(TreeNodeModel childNode:treeNodes)
			{
				if(childNode.getText().equals(company.getComInfoName()))
				{
					childNode.addChild(companyNode);
					hasParent=true;
				}
			}
			if(!hasParent)
			{
				TreeNodeModel companyInfoNode =new TreeNodeModel(company.getComInfoName());
				companyInfoNode.addChild(companyNode);
				treeNodes.add(companyInfoNode);
			}
			for(BtbSubstation substation : company.getBtbSubstations())
			{
				TreeNodeModel substationNode =new TreeNodeModel(substation.getStationName());
				for(BtbSubstationdevice device : substation.getBtbSubstationdevices())
				{
					TreeNodeModel deviceNode =new TreeNodeModel(device.getDeviceName());
					TDevicetype deviceType = device.getTDevicetype();
					deviceNode.setHref("../data/dataMain.html?deviceType="
							+ deviceType.getDeviceTypeName()
							+"&deviceId="+device.getSubstationDeviceId());
					boolean parentExist=false;
					if(substationNode.hasChildren())
					{
						for(TreeNodeModel childNode:substationNode.getChildren())//设备类型
						{
							if(childNode.getText().equals(deviceType.getDeviceTypeDesc()))
							{
								childNode.addChild(deviceNode);
								parentExist=true;
								break;
							}
						}
					}
					if(!parentExist)
					{
						TreeNodeModel deviceTypeNode = new TreeNodeModel(deviceType.getDeviceTypeDesc());
						deviceTypeNode.addChild(deviceNode);
						substationNode.addChild(deviceTypeNode);
					}
				}
				boolean parentExist=false;
				String volInfo = substation.getTCurrentquality().getCurrentName()
						+substation.getTVollevel().getVolLevel();//电压电流
				if(companyNode.hasChildren())
				{
					for(TreeNodeModel childNode:companyNode.getChildren())
					{
						if(childNode.getText().equals(volInfo))
						{
							childNode.addChild(substationNode);
							parentExist=true;
							break;
						}
					}
				}
				if(!parentExist)
				{
					TreeNodeModel volNode = new TreeNodeModel(volInfo);
					companyNode.addChild(volNode);
					volNode.addChild(substationNode);
				}
			}
		}
		return treeNodes;
	}
	public Object loadSubDevice(String deviceType,String deviceId)
	{
		List<ComponentModel> buttonSubDevices = new ArrayList<ComponentModel>();
		List<BtbSubdevice> subDevices = new BtbSubdeviceDAO().findByProperty("btbSubstationdevice.substationDeviceId",Long.parseLong(deviceId));
		for(BtbSubdevice subdevice:subDevices)
		{
			ComponentModel buttonSub = new ComponentModel();
			buttonSub.setText(subdevice.getTDevicetype().getDeviceTypeDesc());
			buttonSub.setName(subdevice.getTDevicetype().getDeviceTypeName());
			buttonSub.setId(subdevice.getSubDeviceId().toString());
			buttonSubDevices.add(buttonSub);
		}
		return buttonSubDevices;
	}
	public Object loadSubDeviceData(String subDeviceId,String deviceId)
	{
		List<ComponentModel> panelMonitorData =new ArrayList<ComponentModel>();
		if(subDeviceId == "")//开始进入页面
		{			
		}
		else if(subDeviceId == "0")//诊断页面
		{}
		else
		{
			List<BtbMonitordeviceinfo> monitorDevices = 
					new BtbMonitordeviceinfoDAO().findByProperty("btbSubdevice.subDeviceId",Long.parseLong(subDeviceId));
			for(BtbMonitordeviceinfo monitorDevice : monitorDevices)
			{
				if(monitorDevice.getBtMonitortype().getShowMethod() == 0) //do单个显示
				{					
					panelMonitorData.add(getLnTextPanel(monitorDevice));
				}
				else if(monitorDevice.getBtMonitortype().getShowMethod() ==1)
				{
					panelMonitorData.add(getLnDiagramPanel(monitorDevice));					
				}
			}
		}
		return panelMonitorData;
	}
	private ComponentModel getLnTextPanel(BtbMonitordeviceinfo monitorDevice)
	{
		String queryString ="from DtsDatainfo where monitordeviceinfoId="+monitorDevice.getMonitorDeviceInfoId()
				+" and monitorTime =(select max(monitorTime) from DtsDatainfo where monitordeviceinfoId="+monitorDevice.getMonitorDeviceInfoId()+")";
		Query query =	new DtsDatainfoDAO().getSession().createQuery(queryString);
		List<DtsDatainfo> listData = query.list();
		ComponentModel lnPanel =new ComponentModel();
		lnPanel.setTitle(monitorDevice.getBtMonitortype().getMoniTorTypeDesc());
		lnPanel.setBorder(false);
		lnPanel.setLayout("column");

		List<Object> layoutPanels = new ArrayList<Object>();//doPanel布局所用
		lnPanel.setItems(layoutPanels);
		for(int i =0 ; i < listData.size();i++)  //doData
		{
			if(i%5==0)
			{
				ComponentModel layoutPanel = new ComponentModel();
				layoutPanel.setColumnWidth(0.5f);
				layoutPanel.setBorder(false);
				layoutPanels.add(layoutPanel);
			}
			DtsDatainfo data = listData.get(i);
			DoPanel doPanel =new DoPanel();
			doPanel.setDoDesc(data.getBtMonitorparatype().getMonitorParaName());
			doPanel.setDoState(data.getMonitorDataState());
			doPanel.setDoTime(data.getMonitorTime().toString());
			doPanel.setDoValue(data.getMonitorDataValue() + data.getBtMonitorparatype().getMonitorParaUnit());
			((ComponentModel)layoutPanels.get(i/5)).addItem(doPanel);
		} 
		return lnPanel;
	}

	private ComponentModel getLnDiagramPanel(BtbMonitordeviceinfo monitorDevice)
	{
	  Set<BtMonitorparatype> doTypes =	monitorDevice.getBtMonitortype().getBtMonitorparatypes();
	  String queryString ="from DtsDatainfo where monitordeviceinfoId="+monitorDevice.getMonitorDeviceInfoId()
				+" order by monitorTime desc";
		Query query =	new DtsDatainfoDAO().getSession().createQuery(queryString).setMaxResults(doTypes.size() * 2);
		List<DtsDatainfo> listData = query.list();
		ComponentModel lnPanel =new ComponentModel();
		lnPanel.setTitle(monitorDevice.getBtMonitortype().getMoniTorTypeDesc());
		lnPanel.setBorder(false);
		GridPanel gridPanel = new GridPanel();
		{
			GridPanel.Column column = gridPanel.new Column();
			column.setDataIndex("MonitorTime");
			column.setText("监测时间");
			gridPanel.addColumn(column);
		}
		for(BtMonitorparatype doType:doTypes)
		{
			GridPanel.Column column = gridPanel.new Column();
			column.setDataIndex(doType.getMonitorParaName());
			column.setText(doType.getMonitorParaName());
			gridPanel.addColumn(column);
		}		
		lnPanel.addItem(gridPanel);
	   return lnPanel;

	}
}
