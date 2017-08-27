<%@ page contentType="text/html;charset=UTF-8" %> 
 
 <%@ include file="/WEB-INF/share/taglib.jsp"%>
 
<!DOCTYPE html>
<html lang="zh-CN">
<head>
 
   
        <title> 重庆本期排除</title> 
     

 

</head>

<body> 
 
            <!-- /.row -->
            <div class="row  "  >
            
            
         <div class="col-lg-12 col-xs-12 col-sm-12 ">
          <!-- Custom tabs (Charts with tabs)-->
          <div class="nav-tabs-custom">
            <!-- Tabs within a box -->
            <ul class="nav nav-tabs " >
            
            
              <li class="active"><a href="#quilvErrorQuery0" data-toggle="tab" onclick="quilvErrorQuery(0);" > 万 </a></li>
              <li><a href="#quilvErrorQuery1" data-toggle="tab" onclick="quilvErrorQuery(1);"  > 千 </a></li>
                <li><a href="#quilvErrorQuery2" data-toggle="tab" onclick="quilvErrorQuery(2);" > 百 </a></li>
                  <li><a href="#quilvErrorQuery3" data-toggle="tab" onclick="quilvErrorQuery(3);" > 十 </a></li>
                     <li><a href="#quilvErrorQuery4" data-toggle="tab" onclick="quilvErrorQuery(4);" > 个 </a></li>  
                   <li class="pull-right"><a href="#" class="text-muted" data-toggle="modal"  data-target="#impallModal"><i class="glyphicon glyphicon-search"></i> 查询</a></li>       
                       
              
            </ul>
            <div class="tab-content no-padding">
              <!-- Morris chart - Sales -->
              <div class="chart tab-pane active" id="quilvErrorQuery0"   >
              </div>
              <div class="chart tab-pane" id="quilvErrorQuery1" ></div>
               <div class="chart tab-pane" id="quilvErrorQuery2" ></div>
                <div class="chart tab-pane" id="quilvErrorQuery3" ></div>
                  <div class="chart tab-pane" id="quilvErrorQuery4" ></div>
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
              <input type="hidden" name="type" id="type" value="0">
        
             
                 <div class="form-group">
    
    <div class="input-group">
      <div class="input-group-addon">期数：</div>
        <select class="form-control" name="qi" id="qi"  style="width: 80px;" >
         <option value="${newqi }">${newqi }</option>
        <c:forEach items="${lotterys}" var="entry" varStatus="statu">
					<div class="item">
     <option value="${entry.qi }">${entry.qi }</option>
    	</c:forEach>
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
		     
		      ajaxQueryList(0);
		      });
		    
		    })(jQuery);
	
	
	   
	   function quilvErrorQuery(type){
	     $("#type").val(type);
	       $("#quilvErrorQuery"+type).empty();
	      ajaxQueryList(type);
	   }
	
	      
	
	
	 
   
  
		
		 function  ajaxQueryList(){
		  var type=$("#type").val();
		   var qu="<div class='row'>"+
            "<div class='col-xs-12 col-md-12'>"+
            "<p class='text-center' style='margin: 50px;'>"+
             "<img   src='${basePath}/static/images/loader.gif'> 正在玩命的给您算规，请稍等...</p></div></div>";
		 
		  $("#quilvErrorQuery"+type).empty();
		  $("#quilvErrorQuery"+type).append(qu);
		  var qi=$("#qi").val();
                     var openid=$("#openid").val();
            $.ajax({                                                 
  		  type: "post",                                     
  		 url: "${basePath}/system/ajax/guilv/cq/error",                                      
  		 dataType: "html", 
  		   data: {type:type,openId:openid,qi:qi},
  		 success: function(html){  
            
  			 $("#quilvErrorQuery"+type).empty();
  			 $("#quilvErrorQuery"+type).append(html);
  		 } 
  		 });
            } 
	
	</script>   
    
</body>
</html>
