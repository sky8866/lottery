<%@ page contentType="text/html;charset=UTF-8" %> 
 
 <%@ include file="/WEB-INF/share/taglib.jsp"%>
 
<!DOCTYPE html>
<html lang="zh-CN">
<head>
 
   
        <title>个人中心</title> 
     

 <script src="${basePath }/static/My97DatePicker/WdatePicker.js" type="text/javascript"></script>

</head>

<body> 
 
  
 
       	<div class="row " style="margin-bottom: 10px;">

	  
        <div class="col-lg-12 col-xs-12 col-sm-12 ">
          <div class="box">
            <div class="box-header">
              <h3 class="box-title">用户列表</h3>

              <div class="box-tools ">
               
     <a href="#" class="text-muted" data-toggle="modal"  data-target="#impallModal"><i class="glyphicon glyphicon-search"></i> 查询</a>
 
              </div>
            </div>
            
            <!-- /.box-header -->
            <div class="box-body table-responsive no-padding" id="quilvQuery" style="margin: 10px;">
           
            </div>
            <!-- /.box-body -->
          </div>
          <!-- /.box -->
        </div>
      </div>
      
      
      
       	<div class="modal fade" id="impallModal"> 

		          
		          
		          
		          
		          
    
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
        <h4 class="modal-title">查询条件</h4>
      </div>
      <div class="modal-body">
       
            <div class="modal-body">
                
             <form class="form-horizontal" >   
              <input type="hidden" name="type" id="type" value="0">
	   <div class="form-group">
  <div class="input-group">
     <div class="input-group-addon">用户类型：</div> 
 					 
						 <select class="form-control" name="vip" id="vip"  style="width: 80px;" >
  <option value="3">全部</option>
  <option value="1">会员</option> 
    <option value="0">普通用户</option> 
</select>
</div>
  </div>        
             
                 <div class="form-group">
    
    <div class="input-group">
      <div class="input-group-addon">关键字：</div>
       <input type="text" class="form-control" placeholder="昵称,类型,内容,手机号码"
							id="query" name="query">
       
       
        
       
    </div>
  </div>
  
  <div class="form-group">
    
    <div class="input-group">
      <div class="input-group-addon">时间：</div>
        <input type="text" placeholder="开始时间" id="starttime"
																onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',onpicked:function(){endtime.focus();},maxDate:'#F{$dp.$D(\'endtime\')}'})"
															 	name="starttime"  class="form-control   " />
															至 <input type="text" placeholder="结束时间"
																name="endtime"
																onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'starttime\')}'})"
																id="endtime"   class="form-control  " /> 
 
 
    </div>
  </div>
 
 
 
           </form>                    
            </div>
             
            
      </div>
      <div class="modal-footer">
     
        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
        <button type="button" class="btn btn-default" data-dismiss="modal" onclick="ajaxQueryList(1)">确定</button>
      </div>
      
    </div>
  </div>
     
  
	</div>
      
      
   
       <script type="text/javascript">
	
	   (function ($) {
		      $(document).ready(function() {
		     
		      ajaxQueryList(1);
		      });
		    
		    })(jQuery);
	

		
		 function  ajaxQueryList(page){
		   
		   var qu=""+
            "<div class='col-xs-10 col-md-10'>"+
            "<p class='text-center' style='margin: 50px;'>"+
             "<img   src='${basePath}/static/images/loader.gif'> 正在玩命的给加载，请稍等...</p></div>";
		 
		  $("#quilvQuery").empty();
		  $("#quilvQuery").append(qu);
		 var query=$("#query").val();  
          var vip=$("#vip").val();  	 
            
             
            $.ajax({                                                 
  		  type: "post",                                     
  		 url: "${basePath}/admin/ajax/user/list",                                      
  		 dataType: "html", 
  		   data: {page:page,query:query,vip:vip},
  		 success: function(html){  
           
  			 $("#quilvQuery").empty();
  			 $("#quilvQuery").append(html);
  		 } 
  		 });
            } 
	
	
		//到指定的分页页面
	function topage(page){
		 
	
	  ajaxQueryList(page);
	  
	   
 
	}
	
	function goDel(id) {
		if (confirm("删除后将无法看到这条记录，您确定要这样做吗？")) {

			$.post(bpath+"/system/"+modules+"/del/" + id, {
				"_method" : "post"
			}, function(data, status) {
				if ("success" === status) {
					if ("success" == data) {
						 
						content("删除成功！");
						$("#" + id + "_tr").remove();
					} else if ("fail" == data) {
						content("删除失败！");
					}
				}
			});
			return false;
		}

	}
	
	
	</script>   
    
    
</body>
</html>
