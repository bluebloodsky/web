Ext.namespace('Whnr.Component');
Ext.define('Whnr.Component.DavidTriangle',{
	extend : 'Ext.Component',
	init   : (function(){
		//分别定义大卫三角行初始 x/y/边长/描述说明的初始x/y/字体 /描述图形的宽/高/行距/描述文字x调整、y调整
		var GRAPHIC_STARTX  = 20;
		var GRAPHIC_STARTY  = 20;
		var TRIANGLE_LENGTH = 220;
		var DESC_STARTX     = 280;
		var DESC_STARTY     = 20;
		var DESC_FONT       = '14px Arial';
		var DESC_WIDTH      = 100;
		var DESC_HEIGHT     = 15;
		var DESC_LINE_SPACE = 25;
		var DESC_ADJUSTX    = 10 ;
		var DESC_ADJUSTY    = 8 ;

		var ANGLE_PHASE     = Math.PI/3;
		var colors = ['#7FFF00','#B0E0E6','#FA8072','#808A87','#228B22','#FF8000','#7FFFD4'];
		// var colors = ['lightgreen','lightblue','pink','lightslategray','lightseagreen','lightsalmon','lightcyan'];
		var descContent   = ['PD-局部放电','D1-低能放电','D2-高能放电','T1-热故障','T2-热故障','T3-热故障','D + T'];

		var pointTop   = [GRAPHIC_STARTX + TRIANGLE_LENGTH * 0.5 , GRAPHIC_STARTY];
		var pointLeft  = [GRAPHIC_STARTX , GRAPHIC_STARTY + TRIANGLE_LENGTH * Math.sin(ANGLE_PHASE)];
		var pointRight = [GRAPHIC_STARTX + TRIANGLE_LENGTH , GRAPHIC_STARTY + TRIANGLE_LENGTH * Math.sin(ANGLE_PHASE)];

		//将三比值转化为大卫三角上的点
		var convertPercentToPoint = function(percentCH4,percentC2H4){
			var tmpY = pointLeft[1] - TRIANGLE_LENGTH * Math.sin(ANGLE_PHASE) * percentCH4 / 100;
			var tmpX = pointLeft[0] + percentCH4 / 100 * TRIANGLE_LENGTH * 0.5 + TRIANGLE_LENGTH  * percentC2H4 / 100;
			return [tmpX,tmpY];
		};
		//画多边形
		var getPolyPath = function(points){
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

		var triangleitems = [];
		//大卫三角形内部
		{
			var drawPoints = [],drawPath='';
			//PD
			drawPoints.push(pointTop);
			drawPoints.push(convertPercentToPoint(98 , 0));
			drawPoints.push(convertPercentToPoint(98 , 2));
			drawPath = getPolyPath(drawPoints);
			triangleitems.push({
				type: 'path',
				path: drawPath,    //路径
				fill: colors[0]
			});

			//D1
			drawPoints = [],drawPath='';
			drawPoints.push(convertPercentToPoint(100 - 13 , 0));
			drawPoints.push(convertPercentToPoint(100 - 13 - 23, 23));
			drawPoints.push(convertPercentToPoint(0 , 23));
			drawPoints.push(pointLeft);
			drawPath = getPolyPath(drawPoints);
			triangleitems.push({
				type: 'path',
				path: drawPath,    //路径
				fill: colors[1]
			});

			//D2
			drawPoints = [],drawPath='';
			drawPoints.push(convertPercentToPoint(0 , 23));
			drawPoints.push(convertPercentToPoint(100 - 13 - 23 , 23));
			drawPoints.push(convertPercentToPoint(100 - 38 - 13 , 38));
			drawPoints.push(convertPercentToPoint(100 - 38 - 29 , 38));
			drawPoints.push(convertPercentToPoint(0 , 100 - 29));
			drawPath = getPolyPath(drawPoints);
			triangleitems.push({
				type: 'path',
				path: drawPath,    //路径
				fill: colors[2]
			});

			//T1
			drawPoints = [],drawPath='';
			drawPoints.push(convertPercentToPoint(100 - 4 , 0));
			drawPoints.push(convertPercentToPoint(98 , 0));
			drawPoints.push(convertPercentToPoint(98 , 2));
			drawPoints.push(convertPercentToPoint(100 - 10 , 10));
			drawPoints.push(convertPercentToPoint(100 - 10 - 4 , 10));
			drawPath = getPolyPath(drawPoints);
			triangleitems.push({
				type: 'path',
				path: drawPath,    //路径
				fill: colors[3]
			});

			//T2
			drawPoints = [],drawPath='';
			drawPoints.push(convertPercentToPoint(100 - 10 , 10));
			drawPoints.push(convertPercentToPoint(100 - 10 - 4 , 10));
			drawPoints.push(convertPercentToPoint(100 - 50 - 4 , 50));
			drawPoints.push(convertPercentToPoint(100 - 50 , 50));
			drawPath = getPolyPath(drawPoints);
			triangleitems.push({
				type: 'path',
				path: drawPath,    //路径
				fill: colors[4]
			});

			//T3
			drawPoints = [],drawPath='';
			drawPoints.push(convertPercentToPoint(100 - 50 , 50));
			drawPoints.push(convertPercentToPoint(100 - 50 - 15 , 50));
			drawPoints.push(convertPercentToPoint(0 , 100 - 15));
			drawPoints.push(pointRight);
			drawPath = getPolyPath(drawPoints);
			triangleitems.push({
				type: 'path',
				path: drawPath,    //路径
				fill: colors[5]
			});

			//D+T
			drawPoints = [],drawPath='';
			drawPoints.push(convertPercentToPoint(100 - 4 , 0));
			drawPoints.push(convertPercentToPoint(100 - 13 , 0));
			drawPoints.push(convertPercentToPoint(100 - 38 - 13 , 38));
			drawPoints.push(convertPercentToPoint(100 - 38 - 29 , 38));
			drawPoints.push(convertPercentToPoint(0 , 100 - 29));
			drawPoints.push(convertPercentToPoint(0 , 100 - 15));
			drawPoints.push(convertPercentToPoint(100 - 50 - 15 , 50));
			drawPoints.push(convertPercentToPoint(100 - 50 - 4 , 50));
			drawPath = getPolyPath(drawPoints);
			triangleitems.push({
				type: 'path',
				path: drawPath,    //路径
				fill: colors[6]
			});
		}
		//大卫三角形坐标
		{
			var dotLinePercent = 2;
			for(var i = 0 ; i < 6 ; i++){
				var pointCH4 = convertPercentToPoint(20 * i , 0);
				var point2CH4 = convertPercentToPoint(20 * i , - dotLinePercent);   	 
				var linePath = getLinePath(pointCH4 ,point2CH4); 
				var textLocate = convertPercentToPoint(20 * i , -15);
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

				var pointC2H4 = convertPercentToPoint(100- 20 * i , 20 * i);
				var point2C2H4 = convertPercentToPoint(100- 20 * i + dotLinePercent, 20 * i);   	 
				linePath = getLinePath(pointC2H4 ,point2C2H4);  
				textLocate = convertPercentToPoint(100- 20 * i + 5, 20 * i);
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

				var pointC2H2 = convertPercentToPoint( 0 , 100 - 20 * i);
				var point2C2H2 = convertPercentToPoint (-dotLinePercent , 100 - 20 * i + dotLinePercent); 	 
				linePath = getLinePath(pointC2H2 ,point2C2H2); 
				textLocate = convertPercentToPoint (-5 , 100 - 20 * i + 5);
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
			var arrowPath = getArrowPath(convertPercentToPoint( 40 , -20),convertPercentToPoint( 80 , -20));
			var textLocate = convertPercentToPoint( 60 , -35);
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

			arrowPath = getArrowPath(convertPercentToPoint(120 - 40 , 40),convertPercentToPoint(120 - 80 , 80));
			textLocate = convertPercentToPoint( 60 , 60);
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

			arrowPath = getArrowPath(convertPercentToPoint(-15 , 115 - 40),convertPercentToPoint(-15 , 115 - 80));
			textLocate = convertPercentToPoint( -20 , 120 - 70);
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
			x     : DESC_STARTX + 5,
			y     : DESC_STARTY  ,
			text  : '符号说明：',
			font  : DESC_FONT,
		});
		for (var i = 0 ;i < descContent.length;i++){
			triangleitems.push({ type   : 'rect' ,
				fill   : colors[i],
				width  : DESC_WIDTH,
				height : DESC_HEIGHT,
				x      : DESC_STARTX,
				y      : DESC_STARTY + DESC_LINE_SPACE*(i+1)},{
					type  : 'text' ,
					x     : DESC_STARTX + DESC_WIDTH + DESC_ADJUSTX ,
					y     : DESC_STARTY + DESC_LINE_SPACE*(i+1) + DESC_ADJUSTY ,
					text  : descContent[i],
					font  : DESC_FONT,
				});
		}

		var drawTriangle = Ext.create('Ext.draw.Component',{
			viewBox : false,	   
			items   : triangleitems
		});	

	})
});

Ext.onReady(function(){
	var panel = Ext.create('Whnr.Component.DavidTriangle',{});
	Ext.create('Ext.container.Viewport',{
		layout : 'border' ,
		region : 'center' ,
		items :[panel]
	});	
})