<%@ page contentType="text/html;charset=UTF-8"%>

<%@ include file="/WEB-INF/share/taglib.jsp"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>




</head>

<body>

    <table class="table table-hover">
                <tr>
                  <th width="10%">序号</th>
                  <th width="20%">头像</th>
                  <th width="20%">昵称</th>
                  <th width="30%">用户状态</th>
                
                </tr>
                	<c:choose>
				<c:when test="${!empty pageView.records }">
					<c:forEach items="${pageView.records}" var="entry"
						varStatus="statu">
                <tr>
                  <td>${statu.count }</td>
                  <td><img src="${entry.imagePath }"
									style="width: 41px;height: 41px;"></td>
                  <td id="name_${entry.id }">${entry.name }</td>
                  <td>${entry.usertype } <span class="label label-success" id="endDate_${entry.id }">${entry.endDate }</span> </td>
                   
                </tr>
                  	</c:forEach>



				</c:when>
				<c:otherwise>

					<tr>
						<td colspan="5"><div align="center">暂无数据！</div>
						</td>

					</tr>
				</c:otherwise>
			</c:choose>   
              </table>
<%@include file="/WEB-INF/share/fenye.jsp"%>
 
</div>
</body>
</html>
