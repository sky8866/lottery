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
                  <li class="pull-right"><a href="#" class="text-muted" data-toggle="modal"  data-target="#impallModal"><i class="glyphicon glyphicon-search"></i> 查规</a></li>    
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
        <h4 class="modal-title">数据处理</h4>
      </div>
      <div class="modal-body">
       
            <div class="modal-body">
                
             <form class="form-horizontal" >   
              <input type="hidden" name="type" id="type" value="0">
	   <div class="form-group">
  <div class="input-group">
     <div class="input-group-addon">数据：</div> 
 <select class="form-control" name="number" id="number"  style="width: 80px;" >
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
             
                 <div class="form-group">
    
    <div class="input-group">
      <div class="input-group-addon">范围：</div>
        <select class="form-control" name="buchang" id="buchang"  style="width: 80px;" >
  <option value="5">5</option>
  <option value="10">10</option> 
   
</select>
       
       
        
       
    </div>
  </div>
  
  <div class="form-group">
    
    <div class="input-group">
      <div class="input-group-addon">连接数：</div>
       <select class="form-control" name="addition" id="addition"  style="width: 80px;" >
   <option value="5" >5</option>
   <option value="4">4</option> 
   <option value="3" selected >3</option> 
    <option value="2">2</option> 
   <option value="1">1</option> 
   
     
     
</select>
       
 
 
    </div>
  </div>
   <div class="form-group">
  <div class="input-group">
      <div class="input-group-addon">固定加：</div>   
 <select class="form-control" name="fixation" id="fixation" style="width: 80px;"  >
  <option value="0"  selected>不加</option>
  <option value="10">无限</option>
 
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
       <select class="form-control" name="even" id="even"  style="width: 80px;" >
   <option value="3" >3</option>
   <option value="4">4</option> 
   <option value="5"  >5</option> 
    <option value="6">6</option> 
   <option value="7">7</option> 
    <option value="8">8</option> 
     <option value="9">9</option> 
      <option value="10">10</option> 
       <option value="11">11</option> 
            <option value="12">12</option> 
                   <option value="13">13</option> 
                          <option value="14">14</option> 
                              <option value="15">15</option>
                              <option value="29">29</option> 
                              <option value="30">30</option> 
                              <option value="31">31</option>
                              <option value="32">32</option>
                               <option value="33">33</option>
                               <option value="34">34</option> 
     
</select>
     
       <select class="form-control" name="matchType" id="matchType" style="width:150px;"  >
 <option value="1">大于等于</option>
  <option value="0">等于</option>
  <option value="2">小于</option>
  <option value="3">大于</option> 
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
               
                  var even=$("#even").val();
                  var fixation=$("#fixation").val();
                  var matchType=$("#matchType").val();
                  var number=$("#number").val();
                  var openid=$("#openid").val();
            $.ajax({                                                 
  		  type: "post",                                     
  		 url: "${basePath}/system/ajax/guilv/query",                                      
  		 dataType: "html", 
  		   data: {buchang:buchang,addition:addition,type:type,even:even,fixation:fixation,matchType:matchType,number:number,openId:openid},
  		 success: function(html){  
            
  			 $("#quilvQuery"+type).empty();
  			 $("#quilvQuery"+type).append(html);
  		 } 
  		 });
            } 
	
	</script>   
    
</body>
</html>
