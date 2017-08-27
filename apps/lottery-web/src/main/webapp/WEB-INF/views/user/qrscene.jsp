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

	  
        <div class="col-xs-12">
          <div class="box">
            <div class="box-header">
              <h3 class="box-title">用户列表</h3>

              <div class="box-tools">
               
     
 
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
         var qrscene='${qrscene}';     
             
            $.ajax({                                                 
  		  type: "post",                                     
  		 url: "${basePath}/system/ajax/user/list",                                      
  		 dataType: "html", 
  		   data: {page:page,query:query,vip:vip,qrscene:qrscene},
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
	
 
	
	</script>   
    
    
</body>
</html>
