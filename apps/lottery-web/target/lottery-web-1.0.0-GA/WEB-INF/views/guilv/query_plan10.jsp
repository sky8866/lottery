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
			<c:when test="${!empty sbr3 }">
               


				<c:forEach items="${sbr3}" var="entry" varStatus="statu">
				 <c:choose>
			<c:when test="${entry.type2==1 }">
				<p class="message">
							 
								   <small class="text-muted pull-left"><i class="glyphicon glyphicon-dashboard"></i> ${entry.qi }期</small> <br> 
							 	五星杀数：【万:${entry.number1 },千:${entry.number2 },百:${entry.number3 },十:${entry.number4 },个:${entry.number5 }】 
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
								style="color: red;">	五星杀数：【万:${entry.number1 },千:${entry.number2 },百:${entry.number3 },十:${entry.number4 },个:${entry.number5 }】 </span> 
								 
								 
								等待开奖
								 
								 <br> 
						</p>		
				</c:otherwise>
		</c:choose>	 
				</c:forEach>
				 
<%-- <p class="message">
							 
								      
		 <small class="text-muted "> 今天的计划一共有${plan3.sum }次，共对：${plan3.prize1 }期，错：${plan3.sum-plan3.prize1-1 }期，最高连对：${plan3.countMin }期，最高连错:${plan3.errorMin }期。</small>
								 
								 <br> 
						</p> --%>
			 
-------------------------------------------------------------------------

			</c:when>
			<c:otherwise>
				 
			</c:otherwise>
		</c:choose>
	</div>







  <div class="box-body chat" id="chat-box">
		<div style="margin: 10px;"></div>
		<c:choose>
			<c:when test="${!empty sbr2 }">
                  


				<c:forEach items="${sbr2}" var="entry" varStatus="statu">
				 <c:choose>
			<c:when test="${entry.type2==1 }">
				<p class="message">
							 
								   <small class="text-muted pull-left"><i class="glyphicon glyphicon-dashboard"></i> ${entry.qi }期</small> <br> 
							 	五星杀数：【万:${entry.number1 },千:${entry.number2 },百:${entry.number3 },十:${entry.number4 },个:${entry.number5 }】 
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
								style="color: red;">	五星杀数：【万:${entry.number1 },千:${entry.number2 },百:${entry.number3 },十:${entry.number4 },个:${entry.number5 }】 </span> 
								 
								 
								等待开奖
								 
								 <br> 
						</p>		
				</c:otherwise>
		</c:choose>	 
				</c:forEach>
				 
<p class="message">
							 
								      
		 
								 
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
			<c:when test="${!empty sbr }">
                 


				<c:forEach items="${sbr}" var="entry" varStatus="statu">
				 <c:choose>
			<c:when test="${entry.type2==1 }">
				<p class="message">
							 
								   <small class="text-muted pull-left"><i class="glyphicon glyphicon-dashboard"></i> ${entry.qi }期</small> <br> 
							 	五星杀数：【万:${entry.number1 },千:${entry.number2 },百:${entry.number3 },十:${entry.number4 },个:${entry.number5 }】 
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
								style="color: red;">	五星杀数：【万:${entry.number1 },千:${entry.number2 },百:${entry.number3 },十:${entry.number4 },个:${entry.number5 }】 </span> 
								 
								 
								等待开奖
								 
								 <br> 
						</p>		
				</c:otherwise>
		</c:choose>	 
				</c:forEach>
				 
<%-- <p class="message">
							 
								      
		 <small class="text-muted "> 今天的计划一共有${plan.sum }次，共对：${plan.prize1 }期，错：${plan.sum-plan.prize1-1 }期，最高连对：${plan.countMin }期，最高连错:${plan.errorMin }期。</small>
								 
								 <br> 
						</p> --%>
			 


-------------------------------------------------------------------------

			</c:when>
			<c:otherwise>
				 
			</c:otherwise>
		</c:choose>
	</div>



 


</body>
</html>
