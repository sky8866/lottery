<%@ page contentType="text/html;charset=UTF-8"%>

<%@ include file="/WEB-INF/share/taglib.jsp"%> 
<!DOCTYPE html>
<html lang="zh-CN">
<head>


 

</head>

<body>
<table class="table  table-bordered">
 <c:forEach items="${lsList}" var="entry"
						varStatus="statu"   >
	     
 <tr>
   <td  class="success text-center" width="55" >${entry.qi }</td>
    <td   class="warning text-center"  width="12">${entry.zhi }</td>
  <td class="text-center"  width="45">${entry.number1 }</td>
  <td class="text-center" width="45">${entry.number2 }</td>
  <td class="text-center"  width="45" >${entry.number3 }</td>
  <td class="text-center"  width="45"  >${entry.number4 }</td>
  <td  class="danger text-center" width="45">${entry.number5 }</td>
  <td class="danger text-center" width="45" >${entry.number6 }</td>
  <td class="danger text-center" width="45" >${entry.number7 }</td>
</tr>
  
                   				
						

</c:forEach>
  </table>	
 
</body>
</html>
