<%@ page contentType="text/html;charset=UTF-8"%>

<%@ include file="/WEB-INF/share/taglib.jsp"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>




</head>

<body>


	<div class="box-body chat" id="chat-box">
		<div style="margin: 10px;"></div>
		
		  <div class="row">
        <div class="col-md-12">
        <c:choose>
			<c:when test="${!empty singleDoubleList}">
  
 
   
 
         <c:forEach items="${singleDoubleList }" var="entry" varStatus="statu"> 
         <div class="item">
						<c:choose>
							<c:when test="${!empty entry.info }">

								<img src="${basePath}/static/images/a2.png"
									style="width: 41px;height: 41px;">

							</c:when>
							<c:otherwise>
								<img src="${basePath}/static/images/a1.png"
									style="width:41px;height: 41px;">
							</c:otherwise>
						</c:choose>
						<p class="message">
							<a href="###" onclick="importDetail('${entry.id }',3)"   class="name">
								   <small class="text-muted pull-right"><i class="glyphicon glyphicon-dashboard"></i> ${entry.qi }期</small>  
								 ${entry.typeVaule }</a> ${entry.queryValue }<br> <span
								style="color: red;">历史最高跑${entry.num }期，目前已经跑${entry.sum }期，经过分析此规律得出的结果是杀数。</span>
						</p>
					</div>
 </c:forEach> 
 
 
  
        
 </c:when>
			<c:otherwise>
				<div class="item">

					<p class="text-center">此方式没有算出规，请换其他方式试试！</p>

				</div>
			</c:otherwise>
		</c:choose>
        </div>
        <!-- /.col -->
      </div>
		
 
		
		
 
		
		
	</div>









	</section>

	<div id="importUserBox">
		<div id="impordetails"></div>
	</div>


	<script>
		function importDetail(id,type) {
		 
			 
         detail(id,type);
			var dialog = art.dialog({
				 
				width : 380,
				lock : true,
				title : "图规",
				 

				content : document.getElementById("importUserBox"),
				beforeunload : function() {
					$("#impordetails").empty();
				}

			});
			dialog.follow(document.getElementById('myNavbar_'+id));
			
		}
	</script>




	<script type="text/javascript">
		function detail(id,type) {
		 
            
			$("#impordetails").empty();

			$.ajax({
				type : "post",
				url : "${basePath}/system/ajax/guilv/cq/detail",
				dataType : "html",
				data : {
					id : id,
					type:type
				},
				success : function(html) {

					$("#impordetails").empty();
					$("#impordetails").append(html);
				}
			});
		}
		
		
		
	</script>


</body>
</html>