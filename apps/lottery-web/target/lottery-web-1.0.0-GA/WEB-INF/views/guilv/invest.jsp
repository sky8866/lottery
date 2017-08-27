<%@ page contentType="text/html;charset=UTF-8"%>

<%@ include file="/WEB-INF/share/taglib.jsp"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>

 <title>统计 </title> 


</head>

<body>


	<div class="box-body chat" id="chat-box">
		<div style="margin: 10px;"></div>
		       
             
             			<div class="timeline-item">
                 

               <!--  <div class="timeline-body">
                
                
                 
                  <div class="alert alert-warning alert-dismissible">
                <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                <h4><i class="icon fa fa-warning"></i> 提示</h4>
              <p>近期码不稳，等调整算法后，观察一段时间再继续！</p>
              </div>
                  
                
                </div> -->
                
              </div> 
              
			<div class="item">
           <table class="table  table-bordered">

			<tr class="active">
				 
				 <td class="danger text-center" >次数
				</td>
				
				<!-- <td class=" info text-center" >二定（中）
				</td> -->
				
				<td class=" info text-center" >四定（中）
				</td>
				 
				<td class="warning text-center" >启动资金
				</td>
				<td class="success text-center" >总资金</td>
				<td class="success text-center" >提取</td>
			</tr>
            <tr id="myNavbar_${entry.id }" >
                <td class="danger text-center">${invest.sum }</td>
					<%-- <td class="info text-center" >${invest.prize1
						}</td> --%>
						
						<td class="info text-center" >${invest.prize2
						}</td>
            
					<td class="warning text-center">${invest.money }</td>
					<td class="success text-center" >${invest.sumMoney
						}</td>
						<td class="success text-center" >${invest.putInto
						}</td>
						</tr>
						
						</table>

               </div>
               
               <c:choose>
			<c:when test="${!empty invests }">
				<c:forEach items="${invests}" var="entry" varStatus="statu">
					<div class="item">
						 

								<img src="${basePath}/static/images/a1.png"
									style="width: 41px;height: 41px;">
						<p class="message">
							<a   class="name">
								   <small class="text-muted pull-right"><i class="glyphicon glyphicon-dashboard"></i> ${entry.qi }期</small>  
							<c:if test="${!empty entry.vaule }">开奖号码：${entry.vaule }</c:if>
							<c:if test="${empty entry.vaule }">待开奖</c:if> 
							 </a> 
							<c:if test="${entry.p1==1&& entry.visible==0 }"> <span style="color: red;"> ${entry.info5 }</span></c:if>
							 <c:if test="${entry.p1==0&& entry.visible==0 }">  ${entry.info5 }</c:if>
							 	 <c:if test="${ entry.visible==1 }"> 闷声发大财，数据8点25分显示。</c:if>
							  <br> 
							  <c:if test="${entry.p2==1&& entry.visible==0 }"> <span style="color: red;"> ${entry.info1 } </span></c:if>
							 <c:if test="${entry.p2==0&& entry.visible==0 }">  ${entry.info1 }</c:if>
							 <br>
							  <c:if test="${entry.info6!=null&& entry.visible==0 }">  ${entry.info6 } <br></c:if>
							 
							<strong> 36组二定投入： ${entry.money1 }元，大奖投入：  ${entry.money2 }元 <c:if test="${entry.info6!=null }"> , 单吊：100元 </c:if></strong>
						</p>
					</div>
				</c:forEach>
				 

			 


			</c:when>
			<c:otherwise>
				<div class="item">

					<p class="text-center">还没有投资记录！！</p>

				</div>
			</c:otherwise>
		</c:choose>
	</div>









	</section>

 

 



	 


</body>
</html>
