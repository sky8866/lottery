<%@ page language="java" pageEncoding="UTF-8" %>
 
  <div class="row" style="display:none;" id="touserModal"> 
  
  </div>
   
   


    <!-- Bootstrap Core JavaScript -->
    <script src="${basePath}/static/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
    
<!-- Morris.js charts -->
<script src="${basePath}/static/js/raphael-min.js"></script>
<script src="${basePath}/static/lte/morris/morris.min.js"></script>
    <!-- Custom Theme JavaScript -->
    <script src="${basePath}/static/lte/js/app.min.js"></script>  
     
<script src="${basePath}/static/lte/js/demo.js"></script>
    <script src="${basePath}/static/jquery-validation/1.10.0/jquery.validate.min.js" type="text/javascript"></script>
	<script src="${basePath}/static/jquery-validation/1.10.0/messages_bs_zh.js" type="text/javascript"></script>
		<script src="${basePath}/static/artDialog/jquery.artDialog.min.js"></script>
<script src="${basePath}/static/artDialog/artDialog.min.js"></script>
<script src="${basePath}/static/artDialog/artDialog.plugins.min.js"></script>
	
	
	
     <script type="text/javascript">
    
            function registModal(){
          
            	$.ajax({                                                 
		                                    
		 url: "${basePath }/oa/ajax/reg",                                      
		 dataType: "html",
		 
		 success: function(html){  
			 $("#registModal").empty();
			 $("#registModal").append(html);
		 } 
		 });
            }
            function loginModal(){
            	$.ajax({                                                 
		                                    
		 url: "${basePath }/oa/ajax/login",                                      
		 dataType: "html",
		 
		 success: function(html){  
			 $("#loginModal").empty();
			 $("#loginModal").append(html);
		 } 
		 });
          }
              </script>    
              
              	<c:if test="${!empty  message}"> 
	<script type="text/javascript">
		$(function(){
			 art.dialog({
				 width: '18em',
				 title:'消息',
				 content: '${message }',
			    time: 3000
			});
		});
		
		
	</script> 
	<% request.getSession().removeAttribute("message");%>
</c:if>  
 



<div style="display:none;">
  <div class="container">
      
        <div class="row footer-bottom">
          <ul class="list-inline text-center">
            <li><a href="http://www.miibeian.gov.cn/" target="_blank">粤ICP备15055813号</a></li><li></li>
          </ul>
        </div>
      </div>

<script src="https://s11.cnzz.com/z_stat.php?id=1260013157&web_id=1260013157" language="JavaScript"></script></div>