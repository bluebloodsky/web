/*var htmlAjax = function(url,paramsObj,callback){
	Ext.Ajax.request({
		url    : url,
		params : paramsObj,
		success: function(response, opts){
			var jsonData = Ext.JSON.decode(response.responseText);
			console.log(jsonData);
			if(jsonData.success == true){
				callback(jsonData);		
			}else{
				Ext.MessageBox.alert('failed',jsonData.info);
			}		    
		},
		failure : function(response, opts){
			Ext.MessageBox.alert('error','the server has no response');
		}
	})
};*/
var htmlAjax = function(url,paramsObj,callback){
	Ext.Ajax.request({
		url    : url,
		params : paramsObj,
		success: function(response, opts){
			var jsonData = Ext.JSON.decode(response.responseText);
				callback(jsonData);		
		},
		failure : function(response, opts){
			Ext.MessageBox.alert('error','the server has no response');
		}
	})
};
var myAjax = function(url,paramsObj,callback){
	if(url.indexOf('.htm')!=-1){
		htmlAjax(url,paramsObj,callback);
	}else{
		Ext.MessageBox.alert('error','the url format not support!');
	}
};
var getParams = function(name) {
	new RegExp("(^|&)" + name + "=([^&]*)")
			.exec(window.location.search.substr(1));
	return RegExp.$2
};

var getJsonByKey = function(jsonData,key,value)
{
	console.log(jsonData);
    for(var i=0;i<jsonData.length;i++){
    
    	if(jsonData[i][key] == value){
    		return jsonData[i];
    	}    		
    }
    return '';
}
