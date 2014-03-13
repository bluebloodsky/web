package com.whnr.cac.web.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.whnr.cac.database.BtbSubdevice;
import com.whnr.cac.database.BtbSubdeviceDAO;
import com.whnr.cac.database.BtbSubstation;
import com.whnr.cac.database.BtbSubstationdevice;
import com.whnr.cac.database.BtbSubstationdeviceDAO;
import com.whnr.cac.database.TDevicetype;
import com.whnr.cac.database.TbCominfo;
import com.whnr.cac.database.TbCominfoDAO;
import com.whnr.cac.web.model.ComponentModel;
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
		List<ComponentModel> panelSubDevices = new ArrayList<ComponentModel>();
		List<BtbSubdevice> subDevices = new BtbSubdeviceDAO().findByProperty("btbSubstationdevice.substationDeviceId",Long.parseLong(deviceId));
		for(BtbSubdevice subdevice:subDevices)
		{
			ComponentModel buttonSub = new ComponentModel();
			buttonSub.setText(subdevice.getTDevicetype().getDeviceTypeDesc());
			buttonSub.setName(subdevice.getTDevicetype().getDeviceTypeName());
			buttonSub.setId(subdevice.getSubDeviceId().toString());
			panelSubDevices.add(buttonSub);
		}

		return panelSubDevices;
	}
}
