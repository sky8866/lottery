<%@ page contentType="text/html;charset=UTF-8" %> 
 
 <%@ include file="/WEB-INF/share/taglib.jsp"%>
 
<!DOCTYPE html>
<html lang="zh-CN">
<head>
 
   
        <title>综合规 </title> 
     

 

</head>

<body> 
 
            <!-- /.row -->
            <div class="row  "  >
            
            
         <div class="col-lg-12 col-xs-12 col-sm-12  "    >
          <!-- Custom tabs (Charts with tabs)-->
        
          <div class="nav-tabs-custom">
            <!-- Tabs within a box -->
            <ul class="nav nav-tabs " > 
              <li class="active"><a href="#quilvQuery0" data-toggle="tab" onclick="quilvQuery(0);" > 头 </a></li>
              <li><a href="#quilvQuery1" data-toggle="tab" onclick="quilvQuery(1);"  > 百 </a></li>
                <li><a href="#quilvQuery2" data-toggle="tab" onclick="quilvQuery(2);" > 十 </a></li>
                  <li><a href="#quilvQuery3" data-toggle="tab" onclick="quilvQuery(3);" > 尾 </a></li>
                  <li class="pull-right"><a href="#" class="text-muted" data-toggle="modal"  data-target="#impallModal"><i class="fa fa-bar-chart"></i> 统计</a></li>    
                   <!-- <li class=" header pull-right">  <button type="button" class="btn btn-default btn-xs dropdown-toggle" data-toggle="modal"  data-target="#impallModal">
                                        <i class="fa fa-circle-o"></i> 查规
                                     </li>     -->  
                       
              
            </ul>
             
            <div class="tab-content no-padding">
              <!-- Morris chart - Sales -->
              <div class="chart tab-pane active" id="quilvQuery0"   >
              </div>
              <div class="chart tab-pane" id="quilvQuery1" ></div>
               <div class="chart tab-pane" id="quilvQuery2" ></div>
                <div class="chart tab-pane" id="quilvQuery3" ></div>
                
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
        <h4 class="modal-title">统计类型</h4>
      </div>
      <div class="modal-body">
       
            <div class="modal-body">
                
             <form class="form-horizontal" >   
             <input type="hidden" name="type" id="type" value="0">
	   <div class="form-group">
  <div class="input-group">
     <div class="input-group-addon">类型：</div> 
 <select class="form-control" name="guilv_type" id="guilv_type"  style="width: 120px;" >
  <option value="1">对等规</option> 
  <option value="0">综合规</option>
  
</select>
</div>
  </div>        
             
                  <div class="form-group">
    
    <div class="input-group">
      <div class="input-group-addon">范围：</div>
        <select class="form-control" name="buchang" id="buchang"  style="width: 100px;" >
          <option value="0" >全部</option>  
  <option value="5">5</option>
  <option value="10">10</option> 
   
</select>
       
       
        
       
    </div>
  </div>
  
  <div class="form-group">
    
    <div class="input-group">
      <div class="input-group-addon">连接数：</div>
       <select class="form-control" name="addition" id="addition"  style="width: 100px;" >
      <option value="0" >全部</option>  
   <option value="5" >5</option>
   <option value="4">4</option> 
   <option value="3">3</option> 
    <option value="2">2</option> 
 <option value="1">1</option> 
   
     
     
</select>
       
 
 
    </div>
  </div>
 
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
		  var buchang=$("#buchang").val();  
          	 
              var addition=$("#addition").val(); 
          	 
              var guilv_type=$("#guilv_type").val();
                
                     var openid=$("#openid").val();
            $.ajax({                                                 
  		  type: "post",                                     
  		 url: "${basePath}/system/ajax/guilv/count",                                      
  		 dataType: "html", 
  		   data: {buchang:buchang,addition:addition,type:type,guilv_type:guilv_type,openId:openid},
  		 success: function(html){  
            
  			 $("#quilvQuery"+type).empty();
  			 $("#quilvQuery"+type).append(html);
  		 } 
  		 });
            } 
	
	</script>   
    
</body>
</html>
