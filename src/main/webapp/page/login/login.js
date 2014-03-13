Ext.onReady(function(){
    Ext.tip.QuickTipManager.init();
	Ext.state.Manager.setProvider(Ext.create('Ext.state.CookieProvider',{
	    path : '/',
        expires : new Date(new Date().getTime()+(1000*3600*24*14))
	}));
	var errorInfoLabel = Ext.create('Ext.form.Label',{
	    renderTo : 'form_login'
	});
	var saveCookies = function(){
	    var formValue = loginForm.getForm().getValues();
		if (loginForm.queryById('keepLogin').getValue() == true){
		    Ext.state.Manager.set('loginName',formValue.loginName);
		    Ext.state.Manager.set('password',formValue.password);
		}
	};
    var doLogin = function(name, password) {
    	//communicate with your server side code
    	var params={
    			loginName : name,
    			password  : password
    	};
    	myAjax('login.htm',params,function(obj){
			if(obj.success == true){
			     saveCookies();
			     window.location = "../frame/main.html";
			}else{
	             errorInfoLabel.setText(obj.info);		
			}
    	});
    }
    var formSubmit = function(){
    	if(loginForm.getForm().isValid()){
    		var formValue=loginForm.getForm().getValues();
    		doLogin(formValue.loginName,formValue.password);
    	}    		
    };   
    
    var loginForm = Ext.create('Ext.form.Panel',{
    	frame : true,
		width : 300,
//		height: 180,
//		labelWidth : 50,
    	renderTo:'form_login',
    	defaultType:'textfield',
    	items:[{
    		fieldLabel : 'userName',
    		id         : 'loginName',
    		name       : 'loginName',
    		allowBlank : false
    	},{
    		fieldLabel : 'password',
    		id         : 'password',
    		name       : 'password',
    		inputType  : 'password',
    		allowBlank : false
    	},{
		    xtype    : 'checkbox',
		    id       : 'keepLogin',
            boxLabel : 'Keep the Login Record'
		}],
    	buttonAlign : 'center',
    	buttons:[{
			id      : 'btnSubmit',
    		text    : 'login',
//    		type    : 'submit',
    		handler : formSubmit
    	}]
    });
	loginForm.queryById('loginName').focus();
	Ext.create('Ext.util.KeyMap',{
		target : 'btnSubmit',
		key    : Ext.EventObject.ENTER ,
	    fn     : formSubmit,
	});
});
