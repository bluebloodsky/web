Ext.onReady(function(){
//	var loginName = Ext.state.Manager.get('loginName', '');
	var treeStore = Ext.create('Ext.data.TreeStore', {
		proxy : {
			type : 'ajax',
			url  : '../data/loadTreeNode.htm'
		},
		reader : {
			type :'json'
		},
		root : {
			text : '武汉南瑞智能组件',
			expanded : true
		}
	});
	var treePanel = Ext.create('Ext.tree.Panel',{
		region      : 'west',
		frame       : false,
		border      : false ,
		split       : true ,
		width       : 250 ,
		useArrows   : true ,
		rootVisible :false ,
		autoScroll  : true ,
		store       : treeStore ,
	});
	var headPanel = Ext.create('Ext.Panel',{
		region : 'north',
//		renderTo : Ext.getBody(),
		height : 100,
		border : false ,
		layout : 'border',
		items: [{
			height : 80,
			region :'north',
			html  : '<a href="main.html"><img src="../../resources/pic/logo.jpg"/></a>'
				//html  : '<p style="text-align:right; HEIGHT: 10px; font-size:12px">Welcome,<label>admin</label></p><p><a href="main.html"><img src="../../resources/pic/logo.jpg"/></a></p>'		    
		},{
			height : 20 ,
			region : 'south',
			html   : '<div id= "userNameDiv" style="text-align:right; font-size:12px"></div>'		    
		}]
	});
	var bottomPanel = Ext.create('Ext.Panel',{
		region : 'south' ,
		border : false ,
		height : 32 ,
		html : '<div style="BORDER-TOP:  #007a77 2px solid;COLOR: #666666; LINE-HEIGHT: 24px; clear:both; text-align:center; margin-top:2px; HEIGHT: 48px; TEXT-ALIGN: center;font-size:12px">Copyright@国网电力科学研究院武汉南瑞有限责任公司 </div>'		
	});
	var mainPanel = Ext.create('Ext.panel.Panel',{
		region : 'center',
		border : false ,
		frame  : false ,
		margins : '0 0 0 0',		
		html : '<iframe name="mainFrame" frameborder="0" width="100%" height="100%" src="../welcomePage/welcomePage.html"></iframe>'
	});
	Ext.create('Ext.container.Viewport',{
		layout : 'border' ,
		region : 'center' ,
//		renderTo : Ext.getBody(),
		maxWidth  : 1350,
		items  : [treePanel,headPanel,mainPanel,bottomPanel]
	});
//	myAjax('/page/login/getUser.htm',null,function(obj){
//		if (!obj || !obj.data || !obj.data[0] || !obj.data[0].userName){
//			window.location.href = "../login/login.html";
//			return;
//		}			
//		// 设置左上角的用户信息
//		Ext.getDom('userNameDiv').innerHTML ='Welcome, <strong>'
//			+ obj.data[0].userName +'</strong>&nbsp&nbsp&nbsp'+Ext.Date.format(new Date(), 'Y年m月d日 h:i:s')+'&nbsp&nbsp&nbsp'
////			+ '<a href="../login/logout.htm">注销</a>'				
////			}
//	});
})
