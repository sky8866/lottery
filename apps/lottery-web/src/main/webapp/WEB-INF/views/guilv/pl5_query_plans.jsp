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
							 
								   <small class="text-muted pull-left"><i class="glyphicon glyphicon-dashboard"></i> ${entry.qi }期   ${entry.value } <c:if test="${entry.prize==0 }"><span
								style="color:black;">等待开奖</span></c:if> <c:if test="${entry.prize==2 }">挂</c:if> <c:if test="${entry.prize==1 }"><span
								style="color: red;">中</span></c:if></small> <br> 
							 		<c:if test="${plantype==1 }">49组二定：</c:if><c:if test="${plantype==2 }">36组二定：</c:if>【
							 	<c:if test="${ !empty entry.number1 }">
							 	头:${entry.number1 },
							 	</c:if>
							 	<c:if test="${ !empty entry.number2 }">
							 	百:${entry.number2 },
							 	</c:if>
							 	<c:if test="${ !empty entry.number3 }">
							 	十:${entry.number3 },
							 	</c:if>
							 	
							 	<c:if test="${ !empty entry.number4 }">
							 	尾:${entry.number4 },
							 	</c:if>】 
								
								
								 
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
