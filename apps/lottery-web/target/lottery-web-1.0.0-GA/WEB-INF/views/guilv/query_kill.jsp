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
							<a href="###"  class="name">
								   <small class="text-muted pull-right"><i class="glyphicon glyphicon-dashboard"></i> ${entry.qi }期</small>  
								${entry.typeVaule } </a> ${entry.queryValue }<br> <span
								style="color: red;">${entry.info }</span>
								  <span
								style="color: red;">最高记录为：${entry.countMin }期,现已经跑了:${entry.sum }期,连续连对20次以上的有：${entry.duiNum }次，有过：${entry.errorCou }次错，最高连错：${entry.errorNum }期</span>
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
