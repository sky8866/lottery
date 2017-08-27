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
            


				<c:forEach items="${sbr}" var="entry" varStatus="statu">
					<div class="item">
						 

								<img src="${basePath}/static/images/a1.png"
									style="width: 41px;height: 41px;">

							 
						 
						<p class="message">
							<a   class="name">
								   <small class="text-muted pull-right"><i class="glyphicon glyphicon-dashboard"></i> ${entry.qi }期</small>  
							<c:if test="${!empty entry.vaule }">开奖号码：${entry.vaule }</c:if>
							<c:if test="${empty entry.vaule }">待开奖</c:if> 
							 </a> <span style="color: red;"> ${entry.info6 }</span> <br><span style="color: red;"> ${entry.info5 }</span> <br> ${entry.info3 }<br>${entry.info2 }<br> ${entry.info1 }<br>  
								
								${entry.info }<br>
								${entry.info7 }
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

 

 



	 


</body>
</html>
