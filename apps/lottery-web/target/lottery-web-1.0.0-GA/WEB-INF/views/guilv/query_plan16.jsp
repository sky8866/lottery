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
				 
				<p class="message">
							 
								
								  ${entry.plan }
								<c:if test="${entry.prize==0 }">开奖中</c:if> <c:if test="${entry.prize==1 }"><span
								style="color: red;">中</span></c:if>
								 <c:if test="${entry.prize==2 }">挂</c:if> 
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
