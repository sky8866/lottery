<%@ page contentType="text/html;charset=UTF-8" %> 
 
 <%@ include file="/WEB-INF/share/taglib.jsp"%>
 
<!DOCTYPE html>
<html lang="zh-CN">
<head>
 
   
        <title>排列五</title> 
     

 

</head>

<body> 
 
            <!-- /.row -->
            <div class="row  "  >
            
            
         <div class="col-lg-12 col-xs-12 col-sm-12  "    >
          <!-- Custom tabs (Charts with tabs)-->
        
          <div class="nav-tabs-custom">
            <!-- Tabs within a box -->
            <ul class="nav nav-tabs " >
            
            
              <li class="active"><a href="#quilvQuery1" data-toggle="tab" onclick="quilvQuery(1);" > 49组</a></li>
             <li><a href="#quilvQuery2" data-toggle="tab" onclick="quilvQuery(2);"  > 36组 </a></li>
              
               <!--  <li><a href="#quilvQuery2" data-toggle="tab" onclick="quilvQuery(2);" > 三定 </a></li>   -->
              
                <li><a href="#quilvQuery4" data-toggle="tab" onclick="quilvQuery(4);" > 1296组 </a></li>  
                  <li><a href="#quilvQuery3" data-toggle="tab" onclick="quilvQuery(3);" > 2401组</a></li>    
                       
              
            </ul>
             
            <div class="tab-content no-padding">
              <!-- Morris chart - Sales -->
              <div class="chart tab-pane " id="quilvQuery0"   >
              </div>
              <div class="chart tab-pane active" id="quilvQuery1" ></div>
               <div class="chart tab-pane" id="quilvQuery2" ></div>
                <div class="chart tab-pane" id="quilvQuery3" ></div>
                <div class="chart tab-pane" id="quilvQuery4" ></div>
                 <div class="chart tab-pane" id="quilvQuery5" ></div>
            </div>
          </div>
          <!-- /.nav-tabs-custom -->

          
             
           

        
        

        </div>     
            
            
 



            </div>
            <!-- /.row -->
            
   	<div class="modal fade" id="impallModal"> 

		          
		          
		          
		          
		          
    
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
        <h4 class="modal-title">数据处理</h4>
      </div>
      <div class="modal-body">
       
            <div class="modal-body">
                
             <form class="form-horizontal" >   
              <input type="hidden" name="type" id="type" value="1">
       
    
   
  
 
 
           </form>                    
            </div>
             
            
      </div>
      <div class="modal-footer">
      <input type="hidden" id="openid" name="openid" value="${openid }">
        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
        <button type="button" class="btn btn-default" data-dismiss="modal" onclick="ajaxQueryList()">确定</button>
      </div>
      
    </div>
  </div>
     
  
	</div>
   
   
      
 
       
 <script type="text/javascript">
	
	   (function ($) {
		      $(document).ready(function() {
		     
		      ajaxQueryList();
		      });
		    
		    })(jQuery);
	
	
	   
	   function quilvQuery(type){
	     $("#type").val(type);
	       $("#quilvQuery"+type).empty();
	      ajaxQueryList();
	   }
	
	      
	
	
	 
   
  
		
		 function  ajaxQueryList(){
		  var type=$("#type").val();
		   var qu="<div class='row'>"+
            "<div class='col-xs-12 col-md-12'>"+
            "<p class='text-center' style='margin: 50px;'>"+
             "<img   src='${basePath}/static/images/loader.gif'> 正在玩命的给您算规，请稍等...</p></div></div>";
		 
		  $("#quilvQuery"+type).empty();
		  $("#quilvQuery"+type).append(qu); 
		   
                  var openid=$("#openid").val();
            $.ajax({                                                 
  		  type: "post",                                     
  		 url: "${basePath}/system/ajax/guilv/pl5/plan",                                      
  		 dataType: "html", 
  		   data: {type:type,openId:openid},
  		 success: function(html){  
            
  			 $("#quilvQuery"+type).empty();
  			 $("#quilvQuery"+type).append(html);
  		 } 
  		 });
            } 
	
	</script>   
    
</body>
</html>
