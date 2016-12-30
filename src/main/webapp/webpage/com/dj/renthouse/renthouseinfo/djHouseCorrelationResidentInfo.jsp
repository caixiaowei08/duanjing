<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>

<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
			  <div class="panel datagrid" style="width:auto;">
			          <div class="panel-header" style="width:auto;">
			                 <div class="panel-title">出租房信息</div>
			                 <div class="panel-tool"></div>
			          </div>
			          <!--查询条件选择框  -->
			          <div class="datagrid-wrap panel-body" title="" style="width: auto; height:auto;">
			                   <div id="djHouseInfoListtb" style="padding:3px; height: auto" class="datagrid-toolbar">
			                          <div name="searchColums">
			                                  <input id="_sqlbuilder" name="sqlbuilder" type="hidden">
			                                  <span style="display:-moz-inline-box;display:inline-block;">
		                                                <span style="vertical-align:middle;display:-moz-inline-box;display:inline-block;width: 80px;
		                                                    text-align:right;text-overflow:ellipsis;-o-text-overflow:ellipsis; 
		                                                    overflow: hidden;white-space:nowrap;" title="房屋所在区">房屋所在区：</span>
				                                        <select name="district" id="district" width="100" style="width: 104px">
				                                            <option value="上海市宝山区"  selected="selected">上海市宝山区</option>
				                                        </select>
                                              </span>
                                              
                                              <span style="display:-moz-inline-box;display:inline-block;">
			                                        <span style="vertical-align:middle;display:-moz-inline-box;display:inline-block;width: 80px;text-align:right;text-overflow:ellipsis;
			                                        -o-text-overflow:ellipsis; overflow: hidden;white-space:nowrap; " title="房屋所在村">房屋所在村：</span>
			                                        <select name="town" width="100" id="town" style="width: 104px">
			                                            <option value="月浦镇段泾村"  selected="selected">月浦镇段泾村</option>
			                                        </select>
			                                  </span>
			                                  
			                                  <span style="display:-moz-inline-box;display:inline-block;">
			                                        <span style="vertical-align:middle;display:-moz-inline-box;display:inline-block;width: 80px;text-align:right;text-overflow:ellipsis;-o-text-overflow:ellipsis; overflow: hidden;white-space:nowrap; "
			                                        title="房屋所属宅">房屋所属宅：</span>
			                                        <select name="village" id="village" width="100" style="width: 104px" onchange="getRidgeNo()">
			                                            <option value="">---请选择---</option>
			                                            <option value="段泾桥宅">段泾桥宅</option>
			                                            <option value="泗塘宅">泗塘宅</option>
			                                            <option value="陆家宅">陆家宅</option>
			                                            <option value="支家楼宅">支家楼宅</option>
			                                            <option value="西北宅">西北宅</option>
			                                        </select>
                                              </span>
                                              
                                              <span style="display:-moz-inline-box;display:inline-block;">
			                                        <span style="vertical-align:middle;display:-moz-inline-box;display:inline-block;width: 80px;text-align:right;text-overflow:ellipsis;-o-text-overflow:ellipsis; overflow: hidden;white-space:nowrap; "
			                                        title="门牌号">门牌号：</span>
			                                        <select name="ridgeNo" id="ridgeNo" width="100" style="width: 104px" onchange="findHouseInfoDetail()">
			                                            <option value="">---请选择---</option>
			                                        </select>
                                              </span>
			                          </div>
			                   </div>
			            </div>

			            <hr style="height: 1px; border: none; border-top: 1px dashed #08A5E0;" />
			            <div class="datagrid-wrap panel-body" title="楼层住户详情"  style="overflow:auto;">
			                  <div  style="margin: 10px 10px 10px 10px"   align="center">
			                        <table style="height: 1px; border:1px dashed #08A5E0; width: 200px;">
			                            <caption><font style="color:red;">房屋安防信息</font></caption>
			                            <tr>
			                               <td><B>院落门禁：</B></td><td><input class="inuptxt"  disabled="disabled"
	                                                        type="text" style=" width: 50px;border-style: solid; border-width: 0"  id="guardNum" value=""></td>
			                            </tr>
			                            <tr>
			                               <td><B>视频监控：</B></td><td><input class="inuptxt"  disabled="disabled"
	                                                        type="text" style=" width: 50px;border-style: solid; border-width: 0"  id="videoNum" value=""></td>
			                            </tr>   
			                             <tr>
			                               <td><B>防盗报警装置：</B></td><td><input class="inuptxt" disabled="disabled"
	                                                        type="text" style=" width: 50px;border-style: solid; border-width: 0"  id="alarmNum" value=""></td>
			                            </tr>   
			                        </table>                                                                           
			                    			                 
			                  </div>
						      <div align="center" style="width: 100%;height: 90%;" >
									 <table  style="border:0;width:80%;position:absolute; margin:1% 10% 5% 10%" >
									         <tr  style="height:100px; ">
									                <td width="100%" align="center" style="background-image:url(plug-in/login/images/house_top.png); -moz-background-size:100% 100%; background-size:100% 100%; background-repeat:no-repeat;background-position: center;">
											                <span style="vertical-align:middle;display:-moz-inline-box;display:inline-block;width: 80px;text-align:right;text-overflow:ellipsis;-o-text-overflow:ellipsis; overflow: hidden;white-space:nowrap; "
					                                        title="">
					                                        <B>地址详情：</B></span>
					                                        <input class="inuptxt" id="address_detail" disabled="disabled"
	                                                        type="text" style=" width: 300px;border-style: solid; border-width: 0" value="上海市宝山区段泾村XXXX宅XX号"> <br/>  
	                                                        <span style="vertical-align:middle;display:-moz-inline-box;display:inline-block;width: 80px;text-align:right;text-overflow:ellipsis;-o-text-overflow:ellipsis; overflow: hidden;white-space:nowrap; "
					                                        title="">
					                                        <B>房主：</B></span><a href="#" id="householder" onclick="checkHouseHolderInfo()">XXX</a>
					                                        
					                                          
					                                        <input id="householderid"  type="hidden" value="">  
			                                        </td >
			                                  </tr>
			                                  
			                                  <tbody id="detail_center">
			                                  </tbody>
									 </table>
							  </div>
			           </div>
			            <hr style="height: 1px; border: none; border-top: 1px dashed #08A5E0;" />
			    </div>
        </div>
   </div>
  
 <script src = "webpage/com/dj/renthouse/renthouseinfo/djHouseInfoList.js"></script>

 
 		
 <script type="text/javascript">
 
      function showInfo(id,peoType){
      	
	      	if(peoType=='n'){
	      		showNInfo(id);
	      	}else if(peoType=='f'){
	      		showFInfo(id);
	      	}else{
	      		showNInfo(id);
	      	}
      	
      } 
    
    /*
              查看人员细节  '查看','djPeopleBaseNLController.do?goUpdate','djPeopleBaseNLList',null,null
    */
    function showNInfo(id){
    	var url = 'djPeopleBaseNLController.do?goUpdate&load=detail&id='+id;
    	createdetailwindow('查看',url,700,500);
    }
              
     function showFInfo(id){
        var url = 'djPeopleBaseFController.do?goUpdate&load=detail&id='+id;
              	createdetailwindow('查看',url,700,500);
     }  
     
     function  checkHouseHolderInfo(){
    	        var id=$("#householderid").val();
    	        if(id==null||id=='undefined'||id==''){
    	        	jQuery.messager.show({ 
    	    			title:'提示:', 
    	    			msg:'该户主无详情！', 
    	    			timeout:2000, 
    	    			showType:'slide'
    	    			}); 
    	        	return;
    	        }
    	 
    	        var url = "djPeopleBaseController.do?goUpdate&load=detail&id="+id;
    	        createdetailwindow('户主详情',url,700,500);
     }
 
    function findHouseInfoDetail(){
    	var formData = new Object();
    	var district=$("#district option:selected").val();
    	var town=$("#town option:selected").val();
    	var village=$("#village option:selected").val();
    	var ridgeNo=$("#ridgeNo option:selected").val();
    	var floorNo=$("#floorNo option:selected").val();
    	
	    if (district == null || district == undefined || district == '') {
    		showMessage('房屋所在区');
    		return;
    	}
    	
		if (town == null || town == undefined || town == '') {
			showMessage('房屋所在村');
    		return;		
		}
		    	
		if (village == null || village == undefined || village == '') {
			showMessage('房屋所属宅');
    		return;
		}
		
		if (ridgeNo== null || ridgeNo == undefined || ridgeNo == '') {
			showMessage('门牌号');
    		return;
		}
    	
    	formData['district']=district;
    	formData['town']=town;
    	formData['village']=village;
    	formData['ridgeNo']=ridgeNo;
    	/* formData['floorNo']=floorNo; */
    /* 	alert(''); */
    	$.ajax({
				async : false,
				cache : false,
				type : 'POST',
				url : 'djHouseInfoController.do?getHouseDetailInfo',// 请求的action路径
				data : formData,
				error : function() {// 请求失败处理函数
					
				},
				success : function(data) {
					var d = $.parseJSON(data);
					 //绘制该楼层的平面图
					drawHouseFloorInfo(d);
				}
			});
    }
    
    

    /*绘制*/
    function drawHouseFloorInfo(data){
    
    	
     var djHouseEntity = data.djHouseEntity;
     //房屋安保信息
     $("#guardNum").val(djHouseEntity.guardNum);
     $("#videoNum").val(djHouseEntity.videoNum);
     $("#alarmNum").val(djHouseEntity.alarmNum);
    	    	
   	 //户主信息
   	 var house_owner = data.djPeopleBaseEntity;
   	 //$("#householder").innerHTML=house_owner.name;
   	 $("#householder").text(house_owner.name);
   	 $("#householderid").val(house_owner.id);
   	 $("#address_detail").val(data.address);
   	 
   	 var floors = data.floors
   	 
   	 $("#detail_center").html("");
   	 
   	for(var i=0; i<floors.length;i++){
   	 		var floor = floors[i];	
   	 		var rooms= floor.rooms;
   	 		var floor_info = floor.djHouseInfoEntity;
   	 		
   	 	var code="<tr><td style=\"align:center width:100%\"><table  style=\"width:100%;cellspacing:1px;\" cellspacing=\"2px\"><tr>";
   	 	    code+="<td style=\"border: 1px solid #08A5E0;height: 140px;width: 10%;\" align=\"center\">";
   	 	    code+="<B>第  "+floor_info.floorNo+" 层</B></td>";
   	 	    
   	 	    
   		 	   for(var j=0; j<rooms.length;j++){
   	              var room =rooms[j];
   	              var peoples=room.djPeopleBaseEntities;
   	              var room_info=room.djHouseInfoEntity;

   		 		  code+= "<td style=\"border: 1px dashed #08A5E0;height: 140px;width: 140px;\"><div style=\"margin-top: 2px\" class=\"datagrid-cell datagrid-cell-c1-opt\">";
   		 		  code+= "<a href=\"#\"><span><B>"+room_info.roomNo+"(室)</B></span></a>";
   		 		 
   		 		  
   		 		  if(room_info.roomNo!='101'){
	   		 	      code+="[<a href=\"#\" onclick=\"delRoom('"+room_info.id+"')\">删除</a>]</div> ";
	   	              code+= "<hr style=\"height: 1px; border: none; border-top: 1px dashed #08A5E0;\" />";
   		 		  }
   	              
   	              if(peoples.length==0){
   	            	code+="<a href=\"#\"><span><B>空闲</B></span></a>";
		 		  }
   	              
   	              for (var m = 0; m<peoples.length; m++) {

   	              	var people = peoples[m];
   	                code+="<a href=\"#\" onclick=\"showInfo('"+ people.id+"','"+people.peoType+"')\">["+people.name+"]</a>"
   	               }
   	              
   	              code+="</td>"  ; 
   	              
   		 	   }
   		 	   
   		 	code+="<td style=\"border: 1px dashed #08A5E0;height: 140px;\">";
   		 	code+="<td style=\"border: 1px solid #08A5E0;height: 140px;width: 10%;\" align=\"center\">";
   	 	    code+="<a href=\"#\" onclick=\"addRoom('"+floor_info.district+"','"+floor_info.town+"','"+floor_info.village+"','"+floor_info.ridgeNo+"','"+floor_info.floorNo+"')\">添加房间</a></td>";
   	 	    
   		 	code+="</tr></table></td></tr>" ; 
   		 	 $("#detail_center").append(code);
       	 }
   	
	   	var addFloor="<tr><td style=\"align:center width:100%\"><table style=\"width:100%;cellspacing:1px;\" cellspacing=\"2px\"><tr>"
	   	+"<td style=\"border: 1px solid #08A5E0;height: 70px;width: 10%;\" align=\"center\">"
		+"<a href=\"#\" onclick=\"addFloor('"+house_owner.districtCurrent+"','"+house_owner.townCurrent+"','"+house_owner.villageCurrent+"','"+house_owner.ridgeNoCurrent+"')\">添加楼层</a></td>";
	   	+"</tr></table></td></tr>";
	   	$("#detail_center").append(addFloor);
    }
    
    function delRoom(id){	
    	createdialog01("确认","你确定删除该房间吗?", "djHouseInfoController.do?doDel&id="+id);
    }
    
    /**
     * 创建询问窗口
     * 
     * @param title
     * @param content
     * @param url
     */
    function createdialog01(title, content, url) {
    	$.dialog.confirm(content, function(){
    		doSubmit01(url);
    	}, function(){
    	}).zindex();
    }
    

    /**
     * 执行操作
     * 
     * @param url
     * @param index
     */
    function doSubmit01(url) {
    	//--author：JueYue ---------date：20140227---------for：把URL转换成POST参数防止URL参数超出范围的问题
    	$.ajax({
    		async : false,
    		cache : false,
    		type : 'POST',
    		data : "",
    		url : url,// 请求的action路径
    		error : function() {// 请求失败处理函数
    		},
    		success : function(data) {
    			var d = $.parseJSON(data);
    			if (d.success) {
    				var msg = d.msg;
    				tip(msg);
    				//重新加载
    				findHouseInfoDetail();
    				
    			}
    		}
    	});
    }
    
    
    function addRoom(district,town,village,ridgeNo,floorNo){
    	
    	var addurl = "djHouseInfoController.do?goAddByfloorNo&district="+encodeURI(encodeURI(district))
    	+"&town="+encodeURI(encodeURI(town))
    	+"&village="+encodeURI(encodeURI(village))
    	+"&ridgeNo="+encodeURI(encodeURI(ridgeNo))
    	+"&floorNo="+encodeURI(encodeURI(floorNo));
    	createwindow02("添加房间", addurl,undefined,undefined); 	
    }
    
   function addFloor(district,town,village,ridgeNo){
    	
    	var addurl = "djHouseInfoController.do?goAddfloor&district="+encodeURI(encodeURI(district))
    	+"&town="+encodeURI(encodeURI(town))
    	+"&village="+encodeURI(encodeURI(village))
    	+"&ridgeNo="+encodeURI(encodeURI(ridgeNo));  	
    	createwindow02("添加楼层", addurl,undefined,undefined);
    }
    
    
    
    function createwindow02(title, addurl,width,height) {
    	width = width?width:700;
    	height = height?height:400;
    	if(width=="100%" || height=="100%"){
    		width = window.top.document.body.offsetWidth;
    		height =window.top.document.body.offsetHeight-100;
    	}
        //--author：JueYue---------date：20140427---------for：弹出bug修改,设置了zindex()函数
    	if(typeof(windowapi) == 'undefined'){
    		$.dialog({
    			content: 'url:'+addurl,
    			lock : true,
    			//zIndex:1990,
    			width:width,
    			height:height,
    			title:title,
    			opacity : 0.3,
    			cache:false,
    		    ok: function(){
    		    	iframe = this.iframe.contentWindow;
    				//saveObj();
    				
    		     	var formData = new Object();
    		    	 formData['district'] = $('#district', iframe.document).val();
    		    	 formData['town'] = $('#town', iframe.document).val();
    		    	 formData['village'] = $('#village', iframe.document).val();
    		    	 formData['ridgeNo']  = $('#ridgeNo', iframe.document).val();
    		    	 formData['roomNo'] = $('#roomNo', iframe.document).val();
    		    	 formData['floorNo']  = $('#floorNo', iframe.document).val();
    		    	 $.ajax({
    		  				async : false,
    		  				cache : false,
    		  				type : 'POST',
    		  				url : 'djHouseInfoController.do?doAdd',// 请求的action路径
    		  				data : formData,
    		  				error : function() {// 请求失败处理函数
    		  					
    		  				},
    		  				success : function(data) {
    		  					var d = $.parseJSON(data);
    		  					callBack01(d,iframe);
    		  				}
    		  			}); 
    		    	 
    				return false;
    		    },
    		    cancelVal: '关闭',
    		    cancel: true /*为true等价于function(){}*/
    		}).zindex();
    	}else{
    		$.dialog({
    			content: 'url:'+addurl,
    			lock : true,
    			width:width,
    			//zIndex:1990,
    			height:height,
    			parent:windowapi,
    			title:title,
    			opacity : 0.3,
    			cache:false,
    		    ok: function(){
    		    	iframe = this.iframe.contentWindow;
    		    	var formData = new Object();
    		    	 formData['district'] = $('#district', iframe.document).val();
    		    	 formData['town'] = $('#town', iframe.document).val();
    		    	 formData['village'] = $('#village', iframe.document).val();
    		    	 formData['ridgeNo']  = $('#ridgeNo', iframe.document).val();
    		    	 formData['roomNo'] = $('#roomNo', iframe.document).val();
    		    	 formData['floorNo']  = $('#floorNo', iframe.document).val();
    		    	 $.ajax({
    		  				async : false,
    		  				cache : false,
    		  				type : 'POST',
    		  				url : 'djHouseInfoController.do?doAdd',// 请求的action路径
    		  				data : formData,
    		  				error : function() {// 请求失败处理函数
    		  					
    		  				},
    		  				success : function(data) {
    		  					var d = $.parseJSON(data,iframe);
    		  					callBack01(d);
    		  				}
    		  			});
    				return false;
    		    },
    		    cancelVal: '关闭',
    		    cancel: true /*为true等价于function(){}*/
    		}).zindex();
    	}
        //--author：JueYue---------date：20140427---------for：弹出bug修改,设置了zindex()函数
    }
    
 function callBack01(data,iframe){
    var win = iframe.frameElement.api.opener;
	if (data.success == true) {
		iframe.frameElement.api.close();
		win.tip(data.msg);
	} else {
		if (data.responseText == ''
				|| data.responseText == undefined) {
			$.messager.alert('错误', data.msg);
			$.Hidemsg();
		} else {
			try {
				var emsg = data.responseText.substring(
						data.responseText.indexOf('错误描述'),
						data.responseText.indexOf('错误信息'));
				$.messager.alert('错误', emsg);
				$.Hidemsg();
			} catch (ex) {
				$.messager.alert('错误', data.responseText
						+ "");
				$.Hidemsg();
			}
		}
		return false;
	}
	findHouseInfoDetail();
}
    
    

    
    
    
    function showMessage(message){
    	jQuery.messager.show({ 
			title:'提示:', 
			msg:'请选择有效的'+message, 
			timeout:2000, 
			showType:'slide'
			}); 
    }
    
     /* *
                  根据 district town village 查询该村的 门牌号
      */
    function getRidgeNo(){
  		   var formData = new Object();
  		   formData['district']=$("#district option:selected").val();
  		   formData['town']=$("#town option:selected").val();
  		   formData['village']=$("#village option:selected").val();

  			$.ajax({
  				async : false,
  				cache : false,
  				type : 'POST',
  				url : 'djHouseInfoController.do?getHouse',// 请求的action路径
  				data : formData,
  				error : function() {// 请求失败处理函数
  					
  				},
  				success : function(data) {
  					var d = $.parseJSON(data);
  					var friends = $("#ridgeNo");
  					friends.empty();
  				
  					var option = $("<option>").text("--请选择--").val(null);
  					friends.append(option);
  					
  					for(var i=0;i<d.length;i++) {
  					    var option = $("<option>").text(d[i]).val(d[i]);
  					    friends.append(option);
  					}
  				}
  			});
     }
     
     
     
     

 </script>
 
 
 