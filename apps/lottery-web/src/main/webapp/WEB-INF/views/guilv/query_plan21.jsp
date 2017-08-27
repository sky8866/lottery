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
			<c:when test="${!empty sbr16 }">
               
---------------------万位5码一期方案--------------------------------

				<c:forEach items="${sbr16}" var="entry" varStatus="statu">
				 <c:choose>
			<c:when test="${entry.type2==1 }">
				<p class="message">
							 
								   <small class="text-muted pull-left"><i class="glyphicon glyphicon-dashboard"></i> ${entry.qi }期</small> <br> 
							 	万位5码一期方案：【
							 	 
							 	${entry.number1 }
							 	 】 
							 	  ${entry.number6 }   
								<c:if test="${entry.prize==1 }">挂</c:if> <c:if test="${entry.prize==2 }"><span
								style="color: red;">中</span></c:if>
								 
								 <br> 
						</p>	 
			</c:when>
			<c:otherwise>				 
 
				<p class="message">
							 
								   <small class="text-muted pull-left"><i class="glyphicon glyphicon-dashboard"></i> ${entry.qi }期</small> <br> 
								<span
								style="color: red;">	
								万位5码一期方案：【  ${entry.number1 } 
								 】
								  </span> 
								等待开奖
								 
								 <br> 
						</p>		
				</c:otherwise>
		</c:choose>	 
				</c:forEach>
 
			 
-------------------------------------------------------------------------

			</c:when>
			<c:otherwise>
				 
			</c:otherwise>
		</c:choose>
	</div>

 

	<div class="box-body chat" id="chat-box">
		<div style="margin: 10px;"></div>
		<c:choose>
			<c:when test="${!empty sbr17 }">
               
---------------------千位5码一期方案--------------------------------

				<c:forEach items="${sbr17}" var="entry" varStatus="statu">
				 <c:choose>
			<c:when test="${entry.type2==1 }">
				<p class="message">
							 
								   <small class="text-muted pull-left"><i class="glyphicon glyphicon-dashboard"></i> ${entry.qi }期</small> <br> 
							 	千位5码一期方案：【 ${entry.number2 }】   
							 	 ${entry.number6 } 
								<c:if test="${entry.prize==1 }">挂</c:if> <c:if test="${entry.prize==2 }"><span
								style="color: red;">中</span></c:if>
								 
								 <br> 
						</p>	 
			</c:when>
			<c:otherwise>				 
 
				<p class="message">
							 
								   <small class="text-muted pull-left"><i class="glyphicon glyphicon-dashboard"></i> ${entry.qi }期</small> <br> 
								<span
								style="color: red;">	
								千位5码一期方案：【  ${entry.number2 }】
								  </span> 
								等待开奖
								 
								 <br> 
						</p>		
				</c:otherwise>
		</c:choose>	 
				</c:forEach>
 
			 
-------------------------------------------------------------------------

			</c:when>
			<c:otherwise>
				 
			</c:otherwise>
		</c:choose>
	</div>


 	<div class="box-body chat" id="chat-box">
		<div style="margin: 10px;"></div>
		<c:choose>
			<c:when test="${!empty sbr18 }">
               
---------------------百位5码一期方案--------------------------------

				<c:forEach items="${sbr18}" var="entry" varStatus="statu">
				 <c:choose>
			<c:when test="${entry.type2==1 }">
				<p class="message">
							 
								   <small class="text-muted pull-left"><i class="glyphicon glyphicon-dashboard"></i> ${entry.qi }期</small> <br> 
							 	百位5码一期方案：【 ${entry.number3 }】   
							 	 ${entry.number6 } 
								<c:if test="${entry.prize==1 }">挂</c:if> <c:if test="${entry.prize==2 }"><span
								style="color: red;">中</span></c:if>
								 
								 <br> 
						</p>	 
			</c:when>
			<c:otherwise>				 
 
				<p class="message">
							 
								   <small class="text-muted pull-left"><i class="glyphicon glyphicon-dashboard"></i> ${entry.qi }期</small> <br> 
								<span
								style="color: red;">	
								百位5码一期方案：【  ${entry.number3 }】
								  </span> 
								等待开奖
								 
								 <br> 
						</p>		
				</c:otherwise>
		</c:choose>	 
				</c:forEach>
 
			 
-------------------------------------------------------------------------

			</c:when>
			<c:otherwise>
				 
			</c:otherwise>
		</c:choose>
	</div>

	<div class="box-body chat" id="chat-box">
		<div style="margin: 10px;"></div>
		<c:choose>
			<c:when test="${!empty sbr19 }">
               
---------------------十位5码一期方案--------------------------------

				<c:forEach items="${sbr19}" var="entry" varStatus="statu">
				 <c:choose>
			<c:when test="${entry.type2==1 }">
				<p class="message">
							 
								   <small class="text-muted pull-left"><i class="glyphicon glyphicon-dashboard"></i> ${entry.qi }期</small> <br> 
							 	十位5码一期方案：【 ${entry.number4 }】   
							 	 ${entry.number6 } 
								<c:if test="${entry.prize==1 }">挂</c:if> <c:if test="${entry.prize==2 }"><span
								style="color: red;">中</span></c:if>
								 
								 <br> 
						</p>	 
			</c:when>
			<c:otherwise>				 
 
				<p class="message">
							 
								   <small class="text-muted pull-left"><i class="glyphicon glyphicon-dashboard"></i> ${entry.qi }期</small> <br> 
								<span
								style="color: red;">	
								十位5码一期方案：【  ${entry.number4 }】
								  </span> 
								等待开奖
								 
								 <br> 
						</p>		
				</c:otherwise>
		</c:choose>	 
				</c:forEach>
 
			 
-------------------------------------------------------------------------

			</c:when>
			<c:otherwise>
				 
			</c:otherwise>
		</c:choose>
	</div>
	
	
		<div class="box-body chat" id="chat-box">
		<div style="margin: 10px;"></div>
		<c:choose>
			<c:when test="${!empty sbr20 }">
               
---------------------个位5码一期方案--------------------------------

				<c:forEach items="${sbr20}" var="entry" varStatus="statu">
				 <c:choose>
			<c:when test="${entry.type2==1 }">
				<p class="message">
							 
								   <small class="text-muted pull-left"><i class="glyphicon glyphicon-dashboard"></i> ${entry.qi }期</small> <br> 
							 	万位5码一期方案：【 ${entry.number5 }】   
							 	 ${entry.number6 } 
								<c:if test="${entry.prize==1 }">挂</c:if> <c:if test="${entry.prize==2 }"><span
								style="color: red;">中</span></c:if>
								 
								 <br> 
						</p>	 
			</c:when>
			<c:otherwise>				 
 
				<p class="message">
							 
								   <small class="text-muted pull-left"><i class="glyphicon glyphicon-dashboard"></i> ${entry.qi }期</small> <br> 
								<span
								style="color: red;">	
								万位5码一期方案：【  ${entry.number5 }】
								  </span> 
								等待开奖
								 
								 <br> 
						</p>		
				</c:otherwise>
		</c:choose>	 
				</c:forEach>
 
			 
-------------------------------------------------------------------------

			</c:when>
			<c:otherwise>
				 
			</c:otherwise>
		</c:choose>
	</div>
</body>
</html>
