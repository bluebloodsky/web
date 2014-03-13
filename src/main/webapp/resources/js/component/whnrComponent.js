Ext.namespace('Whnr.Component');
//画多边形
var getPolyPath  = function(points){
			var tmpPath='';
			for(var i = 0;i < points.length;i++){
				if(i == 0){
					tmpPath += 'M';
				}else{
					tmpPath += 'L';
				}
				tmpPath += points[i][0]+' '+points[i][1]+' ';
			}

			return tmpPath+'Z';
		};
//画直线
		var getLinePath = function(point1,point2){
			var lineWidth = 1 ;
			var angle = Math.atan((point2[1] - point1[1])/(point2[0]-point1[0]));

			var point3 = [point2[0] + lineWidth * Math.sin(angle) , point2[1] - lineWidth * Math.cos(angle)];
			var point4 = [point1[0] + lineWidth * Math.sin(angle) , point1[1] - lineWidth * Math.cos(angle)];

			return getPolyPath([point1,point2,point3,point4]);
		};

		// 画箭头
		var getArrowPath = function(point1,point2){
			var point3,point4,point5,point6,point7 ;
			var arrowLength = 10 , arrowWidth = 4 , lineWidth = 1;
			var angle = Math.atan((point2[1] - point1[1])/(point2[0]-point1[0]));

			point3 = [point2[0] + arrowWidth * Math.sin(angle), point2[1] - arrowWidth * Math.cos(angle)];
			point5 = [point2[0] - arrowWidth * Math.sin(angle), point2[1] + arrowWidth * Math.cos(angle)];
			if(point2[0] >= point1[0]){
				point4 = [point2[0] + arrowLength * Math.cos(angle) , point2[1] + arrowLength * Math.sin(angle)];
			}else{
				point4 = [point2[0] - arrowLength * Math.cos(angle) , point2[1] - arrowLength * Math.sin(angle)];
			}    	   
			point6 = [point2[0] - lineWidth * Math.sin(angle), point2[1] + lineWidth * Math.cos(angle)];
			point7 = [point1[0] - lineWidth * Math.sin(angle) , point1[1] + lineWidth * Math.cos(angle)];
			return getPolyPath([point1,point2,point3,point4,point5,point6,point7]);
		};

Ext.define('Whnr.Component.DavidTriangle',{
	extend : 'Ext.draw.Component',
	xtype  : 'davidTriangle',
	autoRender     : true ,
	graphicStartX  : 20 ,
	graphicStartY  : 20 ,
	triangleLength : 220 ,
	descStartX     : 280 ,
	descStartY     : 20 ,
	descFont       : '14px Arial',
	descWidth      : 100 ,
	descHeight     : 15 ,
	descLineSpace  : 25 ,
	descAdjustX    : 10 ,
	descAdjustY    : 8 ,
	radius         : 3 ,
    colors         : ['#7FFF00','#B0E0E6','#FA8072','#808A87','#228B22','#FF8000','#7FFFD4','red'],
	pointLeft      : [],
	pointRight     : [],
	pointTop       : [],
//	resultItem     : null,
	anglePhase     : Math.PI/3 ,
        		//将三比值转化为大卫三角上的点
	convertPercentToPoint : function(percentCH4,percentC2H4){
			var tmpY = this.pointLeft[1] - this.triangleLength * Math.sin(this.anglePhase) * percentCH4 / 100;
			var tmpX = this.pointLeft[0] + percentCH4 / 100 * this.triangleLength * 0.5 + this.triangleLength  * percentC2H4 / 100;
			return [tmpX,tmpY];
	},
	drawResult   :function(data){
		var total = data['CH4'] + data['C2H4'] + data['C2H2'];
		var point = this.convertPercentToPoint(data['CH4'] * 100 / total , data['C2H4'] *100 /total);   
		if(this.resultItem != null){
		    this.items.pop();
		}
		this.resultItem = {
		    type   : 'circle',
			x      : point[0],
			y      : point[1],
			radius : this.radius ,
			fill   : this.colors[7]
		}
		this.items.push(this.resultItem);
	//	this.update(this);
	},
	initComponent:function(){
	//	var me = this ;
		// var this.colors = ['lightgreen','lightblue','pink','lightslategray','lightseagreen','lightsalmon','lightcyan'];
		var descContent   = ['PD-局部放电','D1-低能放电','D2-高能放电','T1-热故障','T2-热故障','T3-热故障','D + T'];

		this.pointTop   = [this.graphicStartX + this.triangleLength * 0.5 , this.graphicStartY];
		this.pointLeft  = [this.graphicStartX , this.graphicStartY + this.triangleLength * Math.sin(this.anglePhase)];
		this.pointRight = [this.graphicStartX + this.triangleLength , this.graphicStartY + this.triangleLength * Math.sin(this.anglePhase)];
		
		var triangleitems = [];
		//大卫三角形内部
		{
			var drawPoints = [],drawPath='';
			//PD
			drawPoints.push(this.pointTop);
			drawPoints.push(this.convertPercentToPoint(98 , 0));
			drawPoints.push(this.convertPercentToPoint(98 , 2));
			drawPath = getPolyPath(drawPoints);
			triangleitems.push({
				type: 'path',
				path: drawPath,    //路径
				fill: this.colors[0]
			});

			//D1
			drawPoints = [],drawPath='';
			drawPoints.push(this.convertPercentToPoint(100 - 13 , 0));
			drawPoints.push(this.convertPercentToPoint(100 - 13 - 23, 23));
			drawPoints.push(this.convertPercentToPoint(0 , 23));
			drawPoints.push(this.pointLeft);
			drawPath = getPolyPath(drawPoints);
			triangleitems.push({
				type: 'path',
				path: drawPath,    //路径
				fill: this.colors[1]
			});

			//D2
			drawPoints = [],drawPath='';
			drawPoints.push(this.convertPercentToPoint(0 , 23));
			drawPoints.push(this.convertPercentToPoint(100 - 13 - 23 , 23));
			drawPoints.push(this.convertPercentToPoint(100 - 38 - 13 , 38));
			drawPoints.push(this.convertPercentToPoint(100 - 38 - 29 , 38));
			drawPoints.push(this.convertPercentToPoint(0 , 100 - 29));
			drawPath = getPolyPath(drawPoints);
			triangleitems.push({
				type: 'path',
				path: drawPath,    //路径
				fill: this.colors[2]
			});

			//T1
			drawPoints = [],drawPath='';
			drawPoints.push(this.convertPercentToPoint(100 - 4 , 0));
			drawPoints.push(this.convertPercentToPoint(98 , 0));
			drawPoints.push(this.convertPercentToPoint(98 , 2));
			drawPoints.push(this.convertPercentToPoint(100 - 10 , 10));
			drawPoints.push(this.convertPercentToPoint(100 - 10 - 4 , 10));
			drawPath = getPolyPath(drawPoints);
			triangleitems.push({
				type: 'path',
				path: drawPath,    //路径
				fill: this.colors[3]
			});

			//T2
			drawPoints = [],drawPath='';
			drawPoints.push(this.convertPercentToPoint(100 - 10 , 10));
			drawPoints.push(this.convertPercentToPoint(100 - 10 - 4 , 10));
			drawPoints.push(this.convertPercentToPoint(100 - 50 - 4 , 50));
			drawPoints.push(this.convertPercentToPoint(100 - 50 , 50));
			drawPath = getPolyPath(drawPoints);
			triangleitems.push({
				type: 'path',
				path: drawPath,    //路径
				fill: this.colors[4]
			});

			//T3
			drawPoints = [],drawPath='';
			drawPoints.push(this.convertPercentToPoint(100 - 50 , 50));
			drawPoints.push(this.convertPercentToPoint(100 - 50 - 15 , 50));
			drawPoints.push(this.convertPercentToPoint(0 , 100 - 15));
			drawPoints.push(this.pointRight);
			drawPath = getPolyPath(drawPoints);
			triangleitems.push({
				type: 'path',
				path: drawPath,    //路径
				fill: this.colors[5]
			});

			//D+T
			drawPoints = [],drawPath='';
			drawPoints.push(this.convertPercentToPoint(100 - 4 , 0));
			drawPoints.push(this.convertPercentToPoint(100 - 13 , 0));
			drawPoints.push(this.convertPercentToPoint(100 - 38 - 13 , 38));
			drawPoints.push(this.convertPercentToPoint(100 - 38 - 29 , 38));
			drawPoints.push(this.convertPercentToPoint(0 , 100 - 29));
			drawPoints.push(this.convertPercentToPoint(0 , 100 - 15));
			drawPoints.push(this.convertPercentToPoint(100 - 50 - 15 , 50));
			drawPoints.push(this.convertPercentToPoint(100 - 50 - 4 , 50));
			drawPath = getPolyPath(drawPoints);
			triangleitems.push({
				type: 'path',
				path: drawPath,    //路径
				fill: this.colors[6]
			});
		}
		//大卫三角形坐标
		{
			var dotLinePercent = 2;
			for(var i = 0 ; i < 6 ; i++){
				var pointCH4 = this.convertPercentToPoint(20 * i , 0);
				var point2CH4 = this.convertPercentToPoint(20 * i , - dotLinePercent);   	 
				var linePath = getLinePath(pointCH4 ,point2CH4); 
				var textLocate = this.convertPercentToPoint(20 * i , -15);
				triangleitems.push({
					type : 'path',
					path : linePath,    //路径
					fill : 'balck'
				},{
					type : 'text',
					x    : textLocate[0] ,
					y    : textLocate[1] ,
					text : i*20 ,
					rotate: { degrees: 300 }
				});

				var pointC2H4 = this.convertPercentToPoint(100- 20 * i , 20 * i);
				var point2C2H4 = this.convertPercentToPoint(100- 20 * i + dotLinePercent, 20 * i);   	 
				linePath = getLinePath(pointC2H4 ,point2C2H4);  
				textLocate = this.convertPercentToPoint(100- 20 * i + 5, 20 * i);
				triangleitems.push({
					type : 'path',
					path : linePath,    //路径
					fill : 'balck'
				},{
					type : 'text',
					x    : textLocate[0] ,
					y    : textLocate[1] ,
					text : i*20 ,
					rotate: { degrees: 60 }
				});

				var pointC2H2 = this.convertPercentToPoint( 0 , 100 - 20 * i);
				var point2C2H2 = this.convertPercentToPoint (-dotLinePercent , 100 - 20 * i + dotLinePercent); 	 
				linePath = getLinePath(pointC2H2 ,point2C2H2); 
				textLocate = this.convertPercentToPoint (-5 , 100 - 20 * i + 5);
				triangleitems.push({
					type : 'path',
					path : linePath,    //路径
					fill : 'balck'
				},{
					type : 'text',
					x    : textLocate[0] ,
					y    : textLocate[1] ,
					text : i*20 ,
				});
			}
		}
		//箭头及描述
		{
			var arrowPath = getArrowPath(this.convertPercentToPoint( 40 , -20),this.convertPercentToPoint( 80 , -20));
			var textLocate = this.convertPercentToPoint( 60 , -35);
			triangleitems.push({
				type : 'path',
				path : arrowPath ,    //路径
				fill : 'balck'
			},{
				type : 'text',
				x    : textLocate[0],
				y    : textLocate[1] ,
				text : '%CH4' ,
				rotate: { degrees: 300 }
			});

			arrowPath = getArrowPath(this.convertPercentToPoint(120 - 40 , 40),this.convertPercentToPoint(120 - 80 , 80));
			textLocate = this.convertPercentToPoint( 60 , 60);
			triangleitems.push({
				type : 'path',
				path : arrowPath ,    //路径
				fill : 'balck'
			},{
				type : 'text',
				x    : textLocate[0],
				y    : textLocate[1] ,
				text : '%C2H4' ,
				rotate: { degrees: 60 }
			});

			arrowPath = getArrowPath(this.convertPercentToPoint(-15 , 115 - 40),this.convertPercentToPoint(-15 , 115 - 80));
			textLocate = this.convertPercentToPoint( -20 , 120 - 70);
			triangleitems.push({
				type : 'path',
				path : arrowPath ,    //路径
				fill : 'balck'
			},{
				type : 'text',
				x    : textLocate[0],
				y    : textLocate[1] ,
				text : '%C2H2' ,
			});
		} 

		triangleitems.push({
			type  : 'text' ,
			x     : this.descStartX + 5,
			y     : this.descStartY  ,
			text  : '符号说明：',
			font  : this.descFont,
		});
		for (var i = 0 ;i < descContent.length;i++){
			triangleitems.push({ type   : 'rect' ,
				fill   : this.colors[i],
				width  : this.descWidth,
				height : this.descHeight,
				x      : this.descStartX,
				y      : this.descStartY + this.descLineSpace*(i+1)},{
					type  : 'text' ,
					x     : this.descStartX + this.descWidth + this.descAdjustX ,
					y     : this.descStartY + this.descLineSpace*(i+1) + this.descAdjustY ,
					text  : descContent[i],
					font  : this.descFont,
				});
		}

		this.items = triangleitems;
	    this.resultItem = null ;	
		this.superclass.initComponent.call(this);
	},

	viewBox : false,	   
});

Ext.define('Whnr.Component.doTextPanel',{
	extend       : 'Ext.form.Panel' ,
	xtype        : 'doTextPanel',
	border       : false ,
	layout       : 'column',
	padding      : '5 0 5 5' ,
	defaultType  : 'label' ,
	doDesc       : '',
	doName       : '',
	doValue      : '',
	doTime       : '',
	doState      : '',
	doUrl        : '',
	initComponent:function(){
		var me = this ;
		me.items = [{
			columnWidth : 0.4 ,
			html        : '<strong>' + me.doDesc + ':</strong>' 
		},{
			columnWidth : 0.2 ,
			html        : me.doValue 
		},{
			columnWidth : 0.2 ,
			html        : '[' + me.doState + ']'
		}];
		if(me.doUrl != ''){
			me.items.push({
				columnWidth : 0.2 ,
				html        : '[<a onclick = "showDetail(\'' + me.doUrl + '\')"> 详情   ]</a>'
			});
		}

		this.superclass.initComponent.call(this);
	}
})