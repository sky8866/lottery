<%@ page contentType="text/html;charset=UTF-8"%>

<%@ include file="/WEB-INF/share/taglib.jsp"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>




</head>

<body>

    <table class="table table-hover">
                <tr>
                  <th width="10%">序号</th>
                  <th width="20%">头像</th>
                  <th width="20%">昵称</th>
                  <th width="30%">用户状态</th>
                  <th width="20%">操作</th>
                </tr>
                	<c:choose>
				<c:when test="${!empty pageView.records }">
					<c:forEach items="${pageView.records}" var="entry"
						varStatus="statu">
                <tr>
                  <td>${statu.count }</td>
                  <td><img src="${entry.imagePath }"
									style="width: 41px;height: 41px;"></td>
                  <td id="name_${entry.id }">${entry.name }</td>
                  <td>${entry.usertype } <span class="label label-success" id="endDate_${entry.id }">${entry.endDate }</span> </td>
                  <td>
 
							<i class="fa fa-edit fa-fw"></i> <a data-toggle="modal" data-target="#wordTypeModal"
								href="###" onclick="updateForm('${entry.id}','${entry.name}')">修改</a>
								 <%--  <i class="fa fa-trash-o fa-fw"></i> <a href="###"
								onclick="goDel('${entry.id}')">删除</a>  --%>
								 
</td>
                </tr>
                  	</c:forEach>



				</c:when>
				<c:otherwise>

					<tr>
						<td colspan="5"><div align="center">暂无数据！</div>
						</td>

					</tr>
				</c:otherwise>
			</c:choose>   
              </table>
<%@include file="/WEB-INF/share/fenye.jsp"%>

<div class="modal fade" id="wordTypeModal">

  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
        <h4 class="modal-title">数据处理</h4>
      </div>
      <div class="modal-body">
       
            <div class="modal-body">
                
             <form class="form-horizontal" >   
              
        
        <div class="form-group">
        <div class="input-group">
      <div class="input-group-addon">昵称：</div>
      <input  type="text" id="userName" style="width: 180px;" disabled>
    </div>
    </div>
  
  
 
  
  <div class="form-group">
      
    <div class="input-group">
      <div class="input-group-addon">会员时间：</div>
     <input type="text" placeholder="开始时间"  
																onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',onpicked:function(){endtime.focus();},maxDate:'#F{$dp.$D(\'endtime\')}'})"
															 	name="starttime"  id="starttime1"  class="form-control   "  style="width: 180px;" />
															  <input type="text" placeholder="结束时间"
																name="endtime"  id="endtime1" 
																onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'starttime\')}'})"
																   class="form-control  "  style="width: 180px;"  />
    </div>
  </div>
 
           </form>                    
            </div>
             
            
      </div>
      <div class="modal-footer">
       <input type="hidden" id="userid" name="userid" >
        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
        <button type="button" class="btn btn-default" data-dismiss="modal" onclick="inputVipForm()">确定</button>
      </div>
      
    </div>
  </div>
     
<script type="text/javascript">
	 

		function updateForm(id,username) {
		   
			   $("#userName").val(username);
        $("#userid").val(id);
		}
  
            
            	 function  inputVipForm(){ 
		      var starttime1=$("#starttime1").val();  
          	 
              var endtime1=$("#endtime1").val();
               
                  var id=$("#userid").val();
                 
            $.ajax({                                                 
  		  type: "post",                                     
  		 url: "${basePath}/admin/ajax/user/inputForm",                                      
  		 dataType: "text", 
  		   data: {starttime:starttime1,endtime:endtime1,id:id},
  		 success: function(html){ 
  		 
  		  if(html=="true"){
  		   $("#name_"+id).empty();
         $("#name_"+id).append("高级会员");
            $("#endDate_"+id).empty();
  			  $("#endDate_"+id).append("【"+endtime1+"】到期");
  			  art.dialog({
				 width: '18em',
				 title:'消息',
				 content: '操作成功！',
			    time: 3000
			});
          }else{
            art.dialog({
				 width: '18em',
				 title:'消息',
				 content: '操作失败！',
			    time: 3000
			});
          }
  		  
          
  			 
  		 } 
  		 });
            } 
	</script>
</div>
</body>
</html>
