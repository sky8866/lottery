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
			<c:when test="${!empty limits }">
                

				<c:forEach items="${limits}" var="entry" varStatus="statu">
			 	<p class="message">
					<c:if test="${entry.minSum-entry.num<=0  }">
							 
					<span
								style="color: red;">${entry.name },最高${entry.minSum }期没有开，目前已经	${entry.num }期没有开了。
					</span> </c:if>
								
					<c:if test="${entry.minSum-entry.num>3  }">
							 
					 ${entry.name },最高${entry.minSum }期没有开，目前已经	${entry.num }期没有开了。
					  </c:if>		 	 
								 
								 
								
								 
								 <br> 
						</p> 
				</c:forEach>
				 
 
			  

			</c:when>
			<c:otherwise>
				 
			</c:otherwise>
		</c:choose>
	</div>



 


 


</body>
</html>
