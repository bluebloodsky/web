Ext.onReady(function(){
	var lnType = getParams("lnType");
	var mainPanel= Ext.create('Ext.panel.Panel', {
	    text    : 'Select the first tab',
	    items   :[{
	    	height :20,
	    	html :"<div>3434344</div>"
	    }]
	});
	//Ext.getCmp('main').items.add(mainPanel);
	htmlAjax('../../resources/jsonData/devices.json',null,function(jsonData){
	        console.log(getJsonById(jsonData,'id','Transform'));
	        var tabs = Ext.create('Ext.tab.Panel',{
		               items    : getJsonById(jsonData,'id',lnType)['children']		
	             });
	        htmlAjax('../../resources/jsonData/currentData.json',null,
				function(obj){
			    	for(var i = 0;i < obj.length;i++){
				        var tabId = obj[i]['id'];
						var tabChildren =obj[i]['children'];
						for(var j= 0;j< tabChildren.length;j++){
							var lnId = tabChildren[j]['id'];
							var items = tabChildren[j]['items'];
						    var aPanel = Ext.create('Ext.panel.Panel',{
							   titile      : tabChildren[j]['id'],
							   height   : 100
						    });
							var gridData = '';
							var gridFields = '[';
							var gridColumns ='[';
						   for(var k =0 ;k < items.length ; k++){
							   gridData +=   items[k]['id']+':\''+items[k]['value']+ '\'';
							   gridFields += '\''+ items[k]['id']+'\'';
							   gridColumns += '{header:\''+ items[k]['desc']+'\',dataIndex:\''+items[k]['id']+'\'}';
							   if(k != items.length - 1){
							       gridData +=',';
								   gridFields += ',';
								   gridColumns += ',';
							   }
                               
						       var bPanel = Ext.create('Ext.panel.Panel',{
								//   html : items[k]['desc']+items[k]['value']+items[k]['state']
							   })
							   aPanel.add(bPanel);
						   }
							
                            gridColumns +=']';
							gridFields  +=']';
							gridData     ='{\'items\':[{' + gridData + '}]}';
							console.log(gridColumns);
							console.log(gridFields);
							console.log(gridData);
							var store = Ext.create('Ext.data.Store', {
								fields : Ext.JSON.decode(gridFields),
								data   : Ext.JSON.decode(gridData),
								proxy: {
								        type: 'memory',
								        reader: {
								            type: 'json',
								            root: 'items'
								        }
							    }
							});
							var grid = Ext.create('Ext.grid.Panel', {
								    title: lnId,
								    store: store,
								    columns : Ext.JSON.decode(gridColumns) ,
								    height: 200,
								    width: 400
							});
							aPanel.add(grid);
	                       Ext.getCmp(tabId).add(aPanel);
						}
					}
			      
			        view.add(tabs);
				})
	});
	var view =  Ext.create('Ext.container.Viewport',{
         layout : 'fit' ,
		 renderTo : Ext.getBody()
	});  
})
