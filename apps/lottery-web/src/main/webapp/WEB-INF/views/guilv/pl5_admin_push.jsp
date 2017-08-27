<%@ page contentType="text/html;charset=UTF-8" %> 
 
 <%@ include file="/WEB-INF/share/taglib.jsp"%>
 
<!DOCTYPE html>
<html lang="zh-CN">
<head>
 
   
        <title>推送码 </title> 
     

 

</head>

<body> 

        <div class="row"  >
       <div class="col-md-12">
          <!-- general form elements -->
          <div class="box box-primary">
            <div class="box-header with-border">
              <h3 class="box-title">排列5推送码</h3>
            </div>
            <div class="box-body" id="quilvQuery">
            
            
            </div>
            
            </div>
            </div>
            </div>
            

 
 
    
   <input type="hidden" id="openid" name="openid" value="${openid }">
   
   
      
 
       
 <script type="text/javascript">
	
	   (function ($) {
		      $(document).ready(function() {
		     
		      ajaxQueryList();
		      });
		    
		    })(jQuery);
	
	
	   
 
	
	
	 
   
  
		
		 function  ajaxQueryList(){
		  var type=$("#type").val();
		   var qu="<div class='row'>"+
            "<div class='col-xs-12 col-md-12'>"+
            "<p class='text-center' style='margin: 50px;'>"+
             "<img   src='${basePath}/static/images/loader.gif'> 正在玩命的给您算规，请稍等...</p></div></div>";
		 
		  $("#quilvQuery").empty();
		  $("#quilvQuery").append(qu); 
                     var openid=$("#openid").val();
            $.ajax({                                                 
  		  type: "post",                                     
  		 url: "${basePath}/admin/ajax/guilv/pl5/push",                                      
  		 dataType: "html", 
  		   data: {openId:openid},
  		 success: function(html){  
            
  			 $("#quilvQuery").empty();
  			 $("#quilvQuery").append(html);
  		 } 
  		 });
            } 
	
	</script>   
    
</body>
</html>
