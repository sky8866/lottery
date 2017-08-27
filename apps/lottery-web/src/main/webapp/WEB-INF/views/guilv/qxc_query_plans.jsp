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
				 
				<p class="message" <c:if test="${entry.vlaue==null }"> style="color: red;"</c:if> >
					${entry.qi } 期： <c:if test="${entry.vlaue==null }">  等待开奖</c:if>  <c:if test="${entry.vlaue!=null }">  开奖号码：${entry.vlaue }</c:if><br> 		 
								
								  ${entry.plan }
						<%-- 		<c:if test="${entry.prize==0 }"> &nbsp; &nbsp; 等待开奖</c:if> <c:if test="${entry.prize==1 }"><span
								style="color: red;"> &nbsp; &nbsp; 中</span></c:if>
								 <c:if test="${entry.prize==2 }"> &nbsp; &nbsp; 挂</c:if>  --%>
								 <br> 
						</p>	 

			 
				</c:forEach>
				
								<c:forEach items="${sbr2}" var="entry" varStatus="statu">
				 
				<p class="message" <c:if test="${entry.vlaue==null }"> style="color: red;"</c:if> >
					${entry.qi } 期： <c:if test="${entry.vlaue==null }">  等待开奖</c:if>  <c:if test="${entry.vlaue!=null }">  开奖号码：${entry.vlaue }</c:if><br> 		 
								
								  ${entry.plan }
						<%-- 		<c:if test="${entry.prize==0 }"> &nbsp; &nbsp; 等待开奖</c:if> <c:if test="${entry.prize==1 }"><span
								style="color: red;"> &nbsp; &nbsp; 中</span></c:if>
								 <c:if test="${entry.prize==2 }"> &nbsp; &nbsp; 挂</c:if>  --%>
								 <br> 
						</p>	 

			 
				</c:forEach>
				
										<c:forEach items="${sbr3}" var="entry" varStatus="statu">
				 
				<p class="message" <c:if test="${entry.vlaue==null }"> style="color: red;"</c:if> >
					${entry.qi } 期： <c:if test="${entry.vlaue==null }">  等待开奖</c:if>  <c:if test="${entry.vlaue!=null }">  开奖号码：${entry.vlaue }</c:if><br> 		 
								
								  ${entry.plan }
						<%-- 		<c:if test="${entry.prize==0 }"> &nbsp; &nbsp; 等待开奖</c:if> <c:if test="${entry.prize==1 }"><span
								style="color: red;"> &nbsp; &nbsp; 中</span></c:if>
								 <c:if test="${entry.prize==2 }"> &nbsp; &nbsp; 挂</c:if>  --%>
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
