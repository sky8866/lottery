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
			<c:when test="${!empty sbr2 }">
               
---------------------后二杀数--------------------------------

				<c:forEach items="${sbr2}" var="entry" varStatus="statu">
				 <c:choose>
			<c:when test="${entry.prize!=0 }">
				<p class="message">
							 
								   <small class="text-muted pull-left"><i class="glyphicon glyphicon-dashboard"></i> ${entry.qi }期</small> <br> 
							 	后二复式杀数：【 
							 	
							 	 
							 	十:${entry.number4 },
							  
							 	 
							 	个:${entry.number5 }
							 	 
							 	
							 	】 
								  ${entry.value }
								<c:if test="${entry.prize==2 }">挂</c:if> <c:if test="${entry.prize==1 }"><span
								style="color: red;">中</span></c:if>
								 
								 <br> 
						</p>	 
			</c:when>
			<c:otherwise>				 
 
				<p class="message">
							 
								   <small class="text-muted pull-left"><i class="glyphicon glyphicon-dashboard"></i> ${entry.qi }期</small> <br> 
								<span
								style="color: red;">	
								后二复式杀数：【 
							 	十:${entry.number4 }, 
							 	个:${entry.number5 } 
							 	】</span> 
								 
								 
								等待开奖
								 
								 <br> 
						</p>		
				</c:otherwise>
		</c:choose>	 
				</c:forEach>
<%-- 				 
<p class="message">
							 
								      
		 <small class="text-muted "> 今天的计划一共有${plan8.sum }次，共对：${plan8.prize1 }期，错：${plan8.sum-plan8.prize1-1 }期，最高连对：${plan8.countMin }期，最高连错:${plan8.errorMin }期。</small>
								 
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
			<c:when test="${!empty sbr3 }">
               
---------------------万个位杀数--------------------------------

				<c:forEach items="${sbr3}" var="entry" varStatus="statu">
				 <c:choose>
			<c:when test="${entry.prize!=0 }">
				<p class="message">
							 
								   <small class="text-muted pull-left"><i class="glyphicon glyphicon-dashboard"></i> ${entry.qi }期</small> <br> 
							 	万个位复式杀数：【
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
								  ${entry.value }
								<c:if test="${entry.prize==2 }">挂</c:if> <c:if test="${entry.prize==1 }"><span
								style="color: red;">中</span></c:if>
								 
								 <br> 
						</p>	 
			</c:when>
			<c:otherwise>				 
 
				<p class="message">
							 
								   <small class="text-muted pull-left"><i class="glyphicon glyphicon-dashboard"></i> ${entry.qi }期</small> <br> 
								<span
								style="color: red;">	
								万个位复式杀数：【
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
							 
								      
		 <small class="text-muted "> 今天的计划一共有${plan9.sum }次，共对：${plan9.prize1 }期，错：${plan9.sum-plan9.prize1-1 }期，最高连对：${plan9.countMin }期，最高连错:${plan9.errorMin }期。</small>
								 
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
			<c:when test="${!empty sbr1 }">
               
---------------------前二杀数--------------------------------

				<c:forEach items="${sbr1}" var="entry" varStatus="statu">
				 <c:choose>
			<c:when test="${entry.prize!=0 }">
				<p class="message">
							 
								   <small class="text-muted pull-left"><i class="glyphicon glyphicon-dashboard"></i> ${entry.qi }期</small> <br> 
							 	前二复式杀数：【
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
								 ${entry.value }
								<c:if test="${entry.prize==2 }">挂</c:if> <c:if test="${entry.prize==1 }"><span
								style="color: red;">中</span></c:if>
								 
								 <br> 
						</p>	 
			</c:when>
			<c:otherwise>				 
 
				<p class="message">
							 
								   <small class="text-muted pull-left"><i class="glyphicon glyphicon-dashboard"></i> ${entry.qi }期</small> <br> 
								<span
								style="color: red;">	
								前二复式杀数：【
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
							 
								      
		 <small class="text-muted "> 今天的计划一共有${plan7.sum }次，共对：${plan7.prize1 }期，错：${plan7.sum-plan7.prize1-1 }期，最高连对：${plan7.countMin }期，最高连错:${plan7.errorMin }期。</small>
								 
								 <br> 
						</p> --%>
			 
-------------------------------------------------------------------------

			</c:when>
			<c:otherwise>
				 
			</c:otherwise>
		</c:choose>
	</div>

<%-- 
	<div class="box-body chat" id="chat-box">
		<div style="margin: 10px;"></div>
		<c:choose>
			<c:when test="${!empty sbr3 }">
               
---------------------任意二位杀数--------------------------------

				<c:forEach items="${sbr3}" var="entry" varStatus="statu">
				 <c:choose>
			<c:when test="${entry.type2==1 }">
				<p class="message">
							 
								   <small class="text-muted pull-left"><i class="glyphicon glyphicon-dashboard"></i> ${entry.qi }期</small> <br> 
							 	直选复式杀数：【
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
								  ${entry.value }
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
								直选复式杀数：【
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
				 
<p class="message">
							 
								      
		 <small class="text-muted "> 今天的计划一共有${plan3.sum }次，共对：${plan3.prize1 }期，错：${plan3.sum-plan3.prize1-1 }期，最高连对：${plan3.countMin }期，最高连错:${plan3.errorMin }期。</small>
								 
								 <br> 
						</p>
			 
-------------------------------------------------------------------------

			</c:when>
			<c:otherwise>
				 
			</c:otherwise>
		</c:choose>
	</div>
 --%>



 
<div class="box-body chat" id="chat-box">
		<div style="margin: 10px;"></div>
	
				 
<p class="message">
							 
								      
		 ${plan3.number7 } 
								 
								 <br> 
						</p>
 
	</div>


 


</body>
</html>
