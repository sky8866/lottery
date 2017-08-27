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
			<c:when test="${!empty sbr11 }">
               
---------------------后三杀数--------------------------------

				<c:forEach items="${sbr11}" var="entry" varStatus="statu">
				 <c:choose>
			<c:when test="${entry.type2==1 }">
				<p class="message">
							 
								   <small class="text-muted pull-left"><i class="glyphicon glyphicon-dashboard"></i> ${entry.qi }期</small> <br> 
							 	后三复式杀数：【
							 	<c:if test="${ !empty entry.number1 }">
							 	万:${entry.number1 },
							 	</c:if>
							 	<c:if test="${ !empty entry.number2 }">
							 	千:${entry.number2 },
							 	</c:if>
							 	<c:if test="${ !empty entry.number3 }">
							 	百:${entry.number3 },
							 	</c:if>
							 	
							 	<c:if test="${ !empty entry.number4 }">
							 	十:${entry.number4 },
							 	</c:if>
							 	<c:if test="${ !empty entry.number5 }">
							 	个:${entry.number5 }
							 	</c:if>
							 	
							 	】 
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
								后三复式杀数：【
							 	<c:if test="${ !empty entry.number1 }">
							 	万:${entry.number1 },
							 	</c:if>
							 	<c:if test="${ !empty entry.number2 }">
							 	千:${entry.number2 },
							 	</c:if>
							 	<c:if test="${ !empty entry.number3 }">
							 	百:${entry.number3 },
							 	</c:if>
							 	
							 	<c:if test="${ !empty entry.number4 }">
							 	十:${entry.number4 },
							 	</c:if>
							 	<c:if test="${ !empty entry.number5 }">
							 	个:${entry.number5 }
							 	</c:if>
							 	
							 	】</span> 
								 
								 
								等待开奖
								 
								 <br> 
						</p>		
				</c:otherwise>
		</c:choose>	 
				</c:forEach>
				 
<%-- <p class="message">
							 
								      
		 <small class="text-muted "> 今天的计划一共有${plan11.sum }次，共对：${plan11.prize1 }期，错：${plan11.sum-plan11.prize1-1 }期，最高连对：${plan11.countMin }期，最高连错:${plan11.errorMin }期。</small>
								 
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
			<c:when test="${!empty sbr10 }">
               
---------------------前三杀数--------------------------------

				<c:forEach items="${sbr10}" var="entry" varStatus="statu">
				 <c:choose>
			<c:when test="${entry.type2==1 }">
				<p class="message">
							 
								   <small class="text-muted pull-left"><i class="glyphicon glyphicon-dashboard"></i> ${entry.qi }期</small> <br> 
							 	前三复式杀数：【
							 	<c:if test="${ !empty entry.number1 }">
							 	万:${entry.number1 },
							 	</c:if>
							 	<c:if test="${ !empty entry.number2 }">
							 	千:${entry.number2 },
							 	</c:if>
							 	<c:if test="${ !empty entry.number3 }">
							 	百:${entry.number3 },
							 	</c:if>
							 	
							 	<c:if test="${ !empty entry.number4 }">
							 	十:${entry.number4 },
							 	</c:if>
							 	<c:if test="${ !empty entry.number5 }">
							 	个:${entry.number5 }
							 	</c:if>
							 	
							 	】 
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
								前三复式杀数：【
							 	<c:if test="${ !empty entry.number1 }">
							 	万:${entry.number1 },
							 	</c:if>
							 	<c:if test="${ !empty entry.number2 }">
							 	千:${entry.number2 },
							 	</c:if>
							 	<c:if test="${ !empty entry.number3 }">
							 	百:${entry.number3 },
							 	</c:if>
							 	
							 	<c:if test="${ !empty entry.number4 }">
							 	十:${entry.number4 },
							 	</c:if>
							 	<c:if test="${ !empty entry.number5 }">
							 	个:${entry.number5 }
							 	</c:if>
							 	
							 	】</span> 
								 
								 
								等待开奖
								 
								 <br> 
						</p>		
				</c:otherwise>
		</c:choose>	 
				</c:forEach>
				 
<%-- <p class="message">
							 
								      
		 <small class="text-muted "> 今天的计划一共有${plan10.sum }次，共对：${plan10.prize1 }期，错：${plan10.sum-plan10.prize1-1 }期，最高连对：${plan10.countMin }期，最高连错:${plan10.errorMin }期。</small>
								 
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
