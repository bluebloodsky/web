Ext.define('Device',{
	extend : 'Ext.data.Model',
	fields : [
	           {name : 'id' ,type : 'string'},
	           {name : 'chilren',type :'auto'}	        	  
	         ]
});
Ext.define('DeviceNode',{
	extend : 'Ext.data.Model',
	fields : ['id', 'text']
});