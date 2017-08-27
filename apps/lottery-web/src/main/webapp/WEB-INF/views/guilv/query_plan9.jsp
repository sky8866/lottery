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
                ---------------------25组极限--------------------------------

				<c:forEach items="${limits}" var="entry" varStatus="statu">
			 	<p class="message">
					<c:if test="${entry.minSum-entry.num<=0  }">
							 
					<span
								style="color: red;">${entry.name },最高${entry.minSum }期没有开，目前已经	${entry.num }期没有开。
					</span> </c:if>
								
					<c:if test="${entry.minSum-entry.num>3  }">
							 
					 ${entry.name },最高${entry.minSum }期没有开，目前已经	${entry.num }期没有开。
					  </c:if>		 	 
								 
								 
								
								 
								 <br> 
						</p> 
				</c:forEach>
				 
 
			  -------------------------------------------------------------------------

			</c:when>
			<c:otherwise>
				 
			</c:otherwise>
		</c:choose>
		
		
		
		<c:choose>
			<c:when test="${!empty limits2 }">
                
 ---------------------大小单双极限--------------------------------
				<c:forEach items="${limits2}" var="entry" varStatus="statu">
			 	<p class="message">
					<c:if test="${entry.minSum-entry.num<=0  }">
							 
					<span
								style="color: red;">${entry.name },最高${entry.minSum }期没有开，目前已经	${entry.num }期没有开。
					</span> </c:if>
								
					<c:if test="${entry.minSum-entry.num>3  }">
							 
					 ${entry.name },最高${entry.minSum }期没有开，目前已经	${entry.num }期没有开。
					  </c:if>		 	 
								 
								 
								
								 
								 <br> 
						</p> 
				</c:forEach>
				 
 
			 -------------------------------------------------------------------------  

			</c:when>
			<c:otherwise>
				 
			</c:otherwise>
		</c:choose>
		
		
				
		<c:choose>
			<c:when test="${!empty limits3 }">
                
 ---------------------三粒极限--------------------------------
				<c:forEach items="${limits3}" var="entry" varStatus="statu">
			 	<p class="message">
					<c:if test="${entry.minSum-entry.num<=0  }">
							 
					<span
								style="color: red;">${entry.name },最高${entry.minSum }期没有开，目前已经	${entry.num }期没有开。
					</span> </c:if>
								
					<c:if test="${entry.minSum-entry.num>3  }">
							 
					 ${entry.name },最高${entry.minSum }期没有开，目前已经	${entry.num }期没有开。
					  </c:if>		 	 
								 
								 
								
								 
								 <br> 
						</p> 
				</c:forEach>
				 
 
			 -------------------------------------------------------------------------  

			</c:when>
			<c:otherwise>
				 
			</c:otherwise>
		</c:choose>
		
		
				<c:choose>
			<c:when test="${!empty limits4 }">
                
 ---------------------一粒极限--------------------------------
				<c:forEach items="${limits4}" var="entry" varStatus="statu">
			 	<p class="message">
					<c:if test="${entry.minSum-entry.num<=0  }">
							 
					<span
								style="color: red;">${entry.name },最高${entry.minSum }期没有开，目前已经	${entry.num }期没有开。
					</span> </c:if>
								
					<c:if test="${entry.minSum-entry.num>3  }">
							 
					 ${entry.name },最高${entry.minSum }期没有开，目前已经	${entry.num }期没有开。
					  </c:if>		 	 
								 
								 
								
								 
								 <br> 
						</p> 
				</c:forEach>
				 
 
			 -------------------------------------------------------------------------  

			</c:when>
			<c:otherwise>
				 
			</c:otherwise>
		</c:choose>
		
		
				
				<c:choose>
			<c:when test="${!empty limits5 }">
                
 ---------------------二粒极限--------------------------------
				<c:forEach items="${limits5}" var="entry" varStatus="statu">
			 	<p class="message">
					<c:if test="${entry.minSum-entry.num<=0  }">
							 
					<span
								style="color: red;">${entry.name },最高${entry.minSum }期没有开，目前已经	${entry.num }期没有开。
					</span> </c:if>
								
					<c:if test="${entry.minSum-entry.num>3  }">
							 
					 ${entry.name },最高${entry.minSum }期没有开，目前已经	${entry.num }期没有开。
					  </c:if>		 	 
								 
								 
								
								 
								 <br> 
						</p> 
				</c:forEach>
				 
 
			 -------------------------------------------------------------------------  

			</c:when>
			<c:otherwise>
				 
			</c:otherwise>
		</c:choose>
		
						<c:choose>
			<c:when test="${!empty limits6 }">
                
 ---------------------三定极限--------------------------------
				<c:forEach items="${limits6}" var="entry" varStatus="statu">
			 	<p class="message">
					<c:if test="${entry.minSum-entry.num<=0  }">
							 
					<span
								style="color: red;">${entry.name },最高${entry.minSum }期没有开，目前已经	${entry.num }期没有开。
					</span> </c:if>
								
					<c:if test="${entry.minSum-entry.num>3  }">
							 
					 ${entry.name },最高${entry.minSum }期没有开，目前已经	${entry.num }期没有开。
					  </c:if>		 	 
								 
								 
								
								 
								 <br> 
						</p> 
				</c:forEach>
				 
 
			 -------------------------------------------------------------------------  

			</c:when>
			<c:otherwise>
				 
			</c:otherwise>
		</c:choose>
		
	</div>



 


 


</body>
</html>
