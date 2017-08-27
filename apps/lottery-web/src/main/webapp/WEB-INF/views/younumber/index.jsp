<%@ page contentType="text/html;charset=UTF-8" %> 
 
 <%@ include file="/WEB-INF/share/taglib.jsp"%>
 
<!DOCTYPE html>
<html lang="zh-CN">
<head>
 
   
        <title1> </title1> 
     

 

</head>

<body> 
 

     
   
         
            <div class="row">
                <div class="col-lg-12">
                    <h2 class="page-header">相等规查询条件</h2>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row " >
            <div class="col-lg-12">
            
            <div class="panel panel-default">
  <div class="panel-body">
      <form class="form-inline">
  <div class="form-group">
    
    <div class="input-group">
      <div class="input-group-addon">搜索范围：</div>
       
      <input type="text" class="form-control" name="buchang" id="buchang" value="10" style="width: 60px;">
       
    </div>
  </div>
  
  <div class="form-group">
    
    <div class="input-group">
      <div class="input-group-addon">连接数：</div>
       
      <input type="text" class="form-control" id="addition" style="width: 60px;" value="3" name="addition"  >
       
    
 
 
    </div>
  </div>
   <div class="form-group">
  <div class="input-group">
      <div class="input-group-addon">固定加：</div>   
 <select class="form-control" name="fixation" id="fixation" >
  <option value="10">无限</option>
  <option value="0">不加</option>
  <option value="1">1</option>
  <option value="2">2</option>
  <option value="3">3</option> 
  <option value="4">4</option> 
  <option value="5">5</option> 
  <option value="6">6</option> 
  <option value="7">7</option> 
  <option value="8">8</option> 
  <option value="9">9</option> 
   
</select>
</div>
  </div>
  
  <div class="form-group">
    
    <div class="input-group">
      <div class="input-group-addon">连对：</div>
       
      <input type="text" class="form-control" id="even" style="width: 60px;" value="3" name="even"  >
       
    </div>
  </div>
  <br><div style="margin: 10px;"></div>
    <div class="form-group">
    
 <select class="form-control" name="matchType" id="matchType" >
 <option value="1">大于等于</option>
  <option value="0">等于</option>
  <option value="2">小于</option>
  <option value="3">大于</option> 
</select>
  </div> 
  <div class="form-group">
    
 <select class="form-control" name="type" id="type" >
  <option value="0">千</option>
  <option value="1">百</option>
  <option value="2">十</option>
  <option value="3">个</option> 
</select>
  </div>
	   <div class="form-group">
  <div class="input-group">
     
 <select class="form-control" name="number" id="number" >
  <option value="1">单码</option>
  <option value="0">对数</option>
  <option value="2">范围2</option>
   <option value="3">范围3</option>
  <option value="4">范围4</option>
   <option value="5">范围5</option> 
  <option value="6">范围6</option> 
   
</select>
</div>
  </div>		 

				
			</form>
  </div>
  <div class="panel-footer">
  <p class="text-right">
  <a href="###" class="btn btn-default" onclick="ajaxQueryList()" >数据处理</a>
  </p></div>
</div>
            
            
            
    
			<div style="margin: 10px;"></div>
              
              <div id="quilvQuery">
              
               <pre style="height: 280px;" >
  暂无数据，请搜索！


</pre> 
              </div>
                
            </div>
        
              



            </div>
            <!-- /.row -->
            
            
            
          
 
       
 <script type="text/javascript">
	 
     var qu="<div class='row'>"+
            "<div class='col-xs-12 col-md-12'>"+
            "<p class='text-center' style='margin: 50px;'>"+
             "<img   src='${basePath}/static/images/loader.gif'> 正在玩命的给您算规，请稍等...</p></div></div>";
  
		
		 function  ajaxQueryList(){
		  $("#quilvQuery").empty();
		  $("#quilvQuery").append(qu);
		 var buchang=$("#buchang").val();  
          	 
              var addition=$("#addition").val();
                var type=$("#type").val();
                  var even=$("#even").val();
                  var fixation=$("#fixation").val();
                  var matchType=$("#matchType").val();
                  var number=$("#number").val();
            $.ajax({                                                 
  		  type: "post",                                     
  		 url: "${basePath}/system/ajax/guilv/query",                                      
  		 dataType: "html", 
  		   data: {buchang:buchang,addition:addition,type:type,even:even,fixation:fixation,matchType:matchType,number:number},
  		 success: function(html){  
            
  			 $("#quilvQuery").empty();
  			 $("#quilvQuery").append(html);
  		 } 
  		 });
            } 
	
	</script>   
    
</body>
</html>
