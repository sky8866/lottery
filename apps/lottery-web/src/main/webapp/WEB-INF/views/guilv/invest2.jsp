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
		
			<div class="item">
           <table class="table  table-bordered">

			<tr class="active">
				 
				<td class="success text-center" >类型</td>  
				<td class="success text-center" >总资金</td>
				
				<td class="success text-center" >二定资金</td>
				
				<td class="success text-center" >四定资金</td>
			</tr>
			<c:forEach items="${invests}" var="entry" varStatus="statu">
            <tr  >
            <td class="info text-center" >${entry.type
						}</td>
                <td class="danger text-center">${entry.sumMoney }</td>
					<td class="info text-center" >${entry.money1
						}</td>
						
						<td class="info text-center" >${entry.money2
						}</td>
            
					 
						</tr>
						
						</c:forEach>
						 <tr  >
            <td class="info text-center" > </td>
                <td class="danger text-center">${sum1 }</td>
					<td class="info text-center" >${sum2
						}</td>
						
						<td class="info text-center" >${sum3
						}</td>
            
					 
						</tr>
						</table>

               </div>
 
	</div>









	</section>

 

 



	 


</body>
</html>
