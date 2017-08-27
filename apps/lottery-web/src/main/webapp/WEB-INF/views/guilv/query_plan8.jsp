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
			<c:when test="${!empty sbr12 }">
               
---------------------五星定位--------------------------------

				<c:forEach items="${sbr12}" var="entry" varStatus="statu">
				 <c:choose>
			<c:when test="${entry.type2==1 }">
				<p class="message">
							 
								   <small class="text-muted pull-left"><i class="glyphicon glyphicon-dashboard"></i> ${entry.qi }期</small> <br> 
							 	五星定位：【 
							 	<c:if test="${ !empty entry.number1 }">
							 	${entry.number1 }
							 	</c:if>】
							 	   
								 ${entry.number6 }
								<c:if test="${entry.errorNum!=0 }">挂</c:if> <c:if test="${entry.errorNum==0 }"><span
								style="color: red;">中</span></c:if>
								 
								 <br> 
						</p>	 
			</c:when>
			<c:otherwise>				 
 
				<p class="message">
							 
								   <small class="text-muted pull-left"><i class="glyphicon glyphicon-dashboard"></i> ${entry.qi }期</small> <br> 
								<span
								style="color: red;">	
								五星定位：【 
							 	<c:if test="${ !empty entry.number1 }">
							 	${entry.number1 }
							 	</c:if>】</span> 
								 
								 
								等待开奖
								 
								 <br> 
						</p>		
				</c:otherwise>
		</c:choose>	 
				</c:forEach>
				 
<p class="message">
							 
								      
		 <small class="text-muted "> 今天的计划一共有${plan12.sum }次，共对：${plan12.prize1 }期，错：${plan12.sum-plan12.prize1-1 }期，最高连对：${plan12.countMin }期，最高连错:${plan12.errorMin }期。</small>
								 
								 <br> 
						</p>
			 
-------------------------------------------------------------------------

			</c:when>
			<c:otherwise>
				 
			</c:otherwise>
		</c:choose>
	</div>



	<div class="box-body chat" id="chat-box">
		<div style="margin: 10px;"></div>
		<c:choose>
			<c:when test="${!empty sbr13 }">
               
---------------------五星定位计划2--------------------------------

				<c:forEach items="${sbr13}" var="entry" varStatus="statu">
				 <c:choose>
			<c:when test="${entry.type2==1 }">
				<p class="message">
							 
								   <small class="text-muted pull-left"><i class="glyphicon glyphicon-dashboard"></i> ${entry.qi }期</small> <br> 
							 	五星定位：【 
							 	<c:if test="${ !empty entry.number1 }">
							 	${entry.number1 }
							 	</c:if>】
							 	   
								 ${entry.number6 }
								<c:if test="${entry.errorNum!=0 }">挂</c:if> <c:if test="${entry.errorNum==0 }"><span
								style="color: red;">中</span></c:if>
								 
								 <br> 
						</p>	 
			</c:when>
			<c:otherwise>				 
 
				<p class="message">
							 
								   <small class="text-muted pull-left"><i class="glyphicon glyphicon-dashboard"></i> ${entry.qi }期</small> <br> 
								<span
								style="color: red;">	
								五星定位：【 
							 	<c:if test="${ !empty entry.number1 }">
							 	${entry.number1 }
							 	</c:if>】</span> 
								 
								 
								等待开奖
								 
								 <br> 
						</p>		
				</c:otherwise>
		</c:choose>	 
				</c:forEach>
				 
<p class="message">
							 
								      
		 <small class="text-muted "> 今天的计划一共有${plan13.sum }次，共对：${plan13.prize1 }期，错：${plan13.sum-plan13.prize1-1 }期，最高连对：${plan13.countMin }期，最高连错:${plan13.errorMin }期。</small>
								 
								 <br> 
						</p>
			 
-------------------------------------------------------------------------

			</c:when>
			<c:otherwise>
				 
			</c:otherwise>
		</c:choose>
	</div>





 


</body>
</html>
