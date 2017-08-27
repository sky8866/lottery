<%@ page contentType="text/html;charset=UTF-8"%>

<%@ include file="/WEB-INF/share/taglib.jsp"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>




</head>

<body>


	<div class="box-body chat" id="chat-box">
		<div style="margin: 10px;"></div>
		<c:choose>
			<c:when test="${!empty sbr }">
                 <c:if test="${isVip==2 }">
                 
                  <div class="alert alert-warning alert-dismissible">
                <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                <h4><i class="icon fa fa-warning"></i> 提示</h4>
               免费用户只能查看一部分记录！
              </div>
                 </c:if>


				<c:forEach items="${sbr}" var="entry" varStatus="statu">
					<div class="item">
						<c:choose>
							<c:when test="${!empty entry.info }">

								<img src="${basePath}/static/images/a2.png"
									style="width: 41px;height: 41px;">

							</c:when>
							<c:otherwise>
								<img src="${basePath}/static/images/a1.png"
									style="width: 41px;height: 41px;">
							</c:otherwise>
						</c:choose>
						<p class="message">
							<a onclick="importDetail('${entry.id }',11)"  class="name">
								   <small class="text-muted pull-right"><i class="glyphicon glyphicon-dashboard"></i> ${entry.qi }期</small>  
								${entry.typeVaule } </a> ${entry.queryValue }<br> <span
								style="color: red;">${entry.info }</span>
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
				url : "${basePath}/system/ajax/guilv/detail",
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
