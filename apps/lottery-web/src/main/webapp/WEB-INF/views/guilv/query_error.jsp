<%@ page contentType="text/html;charset=UTF-8"%>

<%@ include file="/WEB-INF/share/taglib.jsp"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>




</head>

<body>


	<div class="box-body chat" id="chat-box">
		<div style="margin: 10px;"></div>
		
		  <div class="row">
        <div class="col-md-12">
          <!-- The time line -->
          <ul class="timeline">
            <!-- timeline time label -->
            <li class="time-label">
                  <span class="bg-red">
                    第${queryqi }期断规，越靠前越排除,重点看99%与95%。
                  </span>
            </li>
            
            
        


			 
					
					        <li>
              <i class="fa  bg-red">99%</i>
              
              <c:forEach items="${peerList }" var="entry" varStatus="statu">
              <div class="timeline-item">
                <span class="time"><i class="glyphicon glyphicon-dashboard"></i> ${entry.qi }期</span>

                <h3 class="timeline-header"> <a href="###" onclick="importDetail('${entry.id }',4)">${entry.typeVaule }<span
								style="color: red;">[排除]</span></a> </h3>

                <div class="timeline-body">
                 ${entry.queryValue }<br> <span
								style="color: red;">历史最高跑${entry.num }期，目前已经跑${entry.sum }期。</span>
                </div>
                
              </div> 
              	</c:forEach>
              	
              	              <c:forEach items="${peer3List }" var="entry" varStatus="statu">
              <div class="timeline-item">
                <span class="time"><i class="glyphicon glyphicon-dashboard"></i> ${entry.qi }期</span>

                <h3 class="timeline-header"> ${entry.typeVaule }<span
								style="color: red;">[排除]</span> </h3>

                <div class="timeline-body">
                 ${entry.queryValue }<br> <span
								style="color: red;">历史最高跑${entry.num }期，目前已经跑${entry.sum }期。</span>
                </div>
                
              </div> 
              	</c:forEach>
              
              	<c:choose>
			<c:when test="${!empty sbr }">
			
<c:forEach items="${sbr}" var="entry" varStatus="statu">
              <div class="timeline-item">
                <span class="time"><i class="glyphicon glyphicon-dashboard"></i> ${entry.qi }期</span>

                <h3 class="timeline-header"><a href="###" onclick="importDetail('${entry.id }',1)">${entry.typeVaule }<span
								style="color: red;">[排除]</span></a> </h3>

                <div class="timeline-body">
                 ${entry.queryValue }<br> <span
								style="color: red;">历史最高跑${entry.num }期，目前已经跑${entry.sum }期。</span>
                </div>
                
              </div> 
              	</c:forEach>


			</c:when>
			<c:otherwise>
			<div class="timeline-item">
                 

                <div class="timeline-body">
                 <c:if test="${isVip==2 }">
                 
                  <div class="alert alert-warning alert-dismissible">
                <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                <h4><i class="icon fa fa-warning"></i> 提示</h4>
               免费用户只能查看一部分记录！
              </div>
                 </c:if>
                 <span style="color: red;">没有要排除的规律！</span>
                </div>
                
              </div> 
			 
			</c:otherwise>
		</c:choose>
            </li> 	
					
					
 				
					        <li>
              <i class="fa  bg-green">95%</i>
                  <c:forEach items="${peerList1 }" var="entry" varStatus="statu">
              <div class="timeline-item">
                <span class="time"><i class="glyphicon glyphicon-dashboard"></i> ${entry.qi }期</span>

                <h3 class="timeline-header"> <a href="###" onclick="importDetail('${entry.id }',4)"> ${entry.typeVaule }<span
								style="color: red;">[排除]</span></a> </h3>

                <div class="timeline-body">
                 ${entry.queryValue }<br> <span
								style="color: red;">历史最高跑${entry.num }期，目前已经跑${entry.sum }期。</span>
                </div>
                
              </div> 
              	</c:forEach>
              	
              	                <c:forEach items="${peer3List1 }" var="entry" varStatus="statu">
              <div class="timeline-item">
                <span class="time"><i class="glyphicon glyphicon-dashboard"></i> ${entry.qi }期</span>

                <h3 class="timeline-header"> ${entry.typeVaule }<span
								style="color: red;">[排除]</span> </h3>

                <div class="timeline-body">
                 ${entry.queryValue }<br> <span
								style="color: red;">历史最高跑${entry.num }期，目前已经跑${entry.sum }期。</span>
                </div>
                
              </div> 
              	</c:forEach>
              	
              	                  <c:forEach items="${singleDoubleList }" var="entry" varStatus="statu">
              <div class="timeline-item">
                <span class="time"><i class="glyphicon glyphicon-dashboard"></i> ${entry.qi }期</span>

                <h3 class="timeline-header"><a href="###" onclick="importDetail('${entry.id }',3)"> ${entry.typeVaule }<span
								style="color: red;">[排除]</span></a> </h3>

                <div class="timeline-body">
                 ${entry.queryValue }<br> <span
								style="color: red;">历史最高跑${entry.num }期，目前已经跑${entry.sum }期。</span>
                </div>
                
              </div> 
              	</c:forEach>
              	
              	<c:choose>
			<c:when test="${!empty sbr1 }">
			
<c:forEach items="${sbr1}" var="entry" varStatus="statu">
              <div class="timeline-item">
                <span class="time"><i class="glyphicon glyphicon-dashboard"></i> ${entry.qi }期</span>

                <h3 class="timeline-header"><a href="###" onclick="importDetail('${entry.id }',1)">${entry.typeVaule }<span
								style="color: red;">[排除]</span></a> </h3>

                <div class="timeline-body">
                 ${entry.queryValue }<br> <span
								style="color: red;">历史最高跑${entry.num }期，目前已经跑${entry.sum }期。</span>
                </div>
                
              </div> 
              	</c:forEach>


			</c:when>
			<c:otherwise>
			<div class="timeline-item">
                 

                <div class="timeline-body">
                
                <c:if test="${isVip==2 }">
                 
                  <div class="alert alert-warning alert-dismissible">
                <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                <h4><i class="icon fa fa-warning"></i> 提示</h4>
               免费用户只能查看一部分记录！
              </div>
                 </c:if>
                <span style="color: red;">没有要排除的规律！</span>
                </div>
                
              </div> 
			 
			</c:otherwise>
		</c:choose>
            </li> 	
					
					
			
		 				
					        <li>
              <i class="fa  bg-yellow">90%</i>
                <c:forEach items="${peerList2 }" var="entry" varStatus="statu">
              <div class="timeline-item">
                <span class="time"><i class="glyphicon glyphicon-dashboard"></i> ${entry.qi }期</span>

                <h3 class="timeline-header"> ${entry.typeVaule }<span
								style="color: red;">[排除]</span> </h3>

                <div class="timeline-body">
                 ${entry.queryValue }<br> <span
								style="color: red;">历史最高跑${entry.num }期，目前已经跑${entry.sum }期。</span>
                </div>
                
              </div> 
              	</c:forEach>
              	                <c:forEach items="${peer3List2 }" var="entry" varStatus="statu">
              <div class="timeline-item">
                <span class="time"><i class="glyphicon glyphicon-dashboard"></i> ${entry.qi }期</span>

                <h3 class="timeline-header"> ${entry.typeVaule }<span
								style="color: red;">[排除]</span> </h3>

                <div class="timeline-body">
                 ${entry.queryValue }<br> <span
								style="color: red;">历史最高跑${entry.num }期，目前已经跑${entry.sum }期。</span>
                </div>
                
              </div> 
              	</c:forEach>
              	
              	          	                <c:forEach items="${singleDoubleList1 }" var="entry" varStatus="statu">
              <div class="timeline-item">
                <span class="time"><i class="glyphicon glyphicon-dashboard"></i> ${entry.qi }期</span>

                <h3 class="timeline-header"><a href="###" onclick="importDetail('${entry.id }',3)"> ${entry.typeVaule }<span
								style="color: red;">[排除]</span></a> </h3>

                <div class="timeline-body">
                 ${entry.queryValue }<br> <span
								style="color: red;">历史最高跑${entry.num }期，目前已经跑${entry.sum }期。</span>
                </div>
                
              </div> 
              	</c:forEach>
              	
              	
              	<c:choose>
			<c:when test="${!empty sbr2 }">
			
<c:forEach items="${sbr2}" var="entry" varStatus="statu">
              <div class="timeline-item">
                <span class="time"><i class="glyphicon glyphicon-dashboard"></i> ${entry.qi }期</span>

                <h3 class="timeline-header"><a href="###" onclick="importDetail('${entry.id }',1)">${entry.typeVaule }</a> </h3>

                <div class="timeline-body">
                 ${entry.queryValue }<br> <span
								style="color: red;">历史最高跑${entry.num }期，目前已经跑${entry.sum }期。</span>
                </div>
                
              </div> 
              	</c:forEach>


			</c:when>
			<c:otherwise>
			<div class="timeline-item">
                 

                <div class="timeline-body">
                <c:if test="${isVip==2 }">
                 
                  <div class="alert alert-warning alert-dismissible">
                <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                <h4><i class="icon fa fa-warning"></i> 提示</h4>
               免费用户只能查看一部分记录！
              </div>
                 </c:if>
                <span style="color: red;">没有要排除的规律！</span>
                </div>
                
              </div> 
			 
			</c:otherwise>
		</c:choose>
            </li> 	
					
            
            
           					        <li>
              <i class="fa  bg-orange">85%</i>
              
              	<c:choose>
			<c:when test="${!empty sbr3 }">
			
<c:forEach items="${sbr3}" var="entry" varStatus="statu">
              <div class="timeline-item">
                <span class="time"><i class="glyphicon glyphicon-dashboard"></i> ${entry.qi }期</span>

                <h3 class="timeline-header"><a href="###" onclick="importDetail('${entry.id }',1)">${entry.typeVaule }</a> </h3>

                <div class="timeline-body">
                 ${entry.queryValue }<br> <span
								style="color: red;">历史最高跑${entry.num }期，目前已经跑${entry.sum }期。</span>
                </div>
                
              </div> 
              	</c:forEach>


			</c:when>
			<c:otherwise>
			<div class="timeline-item">
                 

                <div class="timeline-body">
                <c:if test="${isVip==2 }">
                 
                  <div class="alert alert-warning alert-dismissible">
                <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                <h4><i class="icon fa fa-warning"></i> 提示</h4>
               免费用户只能查看一部分记录！
              </div>
                 </c:if>
                <span style="color: red;">没有要排除的规律！</span>
                </div>
                
              </div> 
			 
			</c:otherwise>
		</c:choose>
            </li> 	 
            
            					        <li>
              <i class="fa  bg-blue">80%</i>
              
              	<c:choose>
			<c:when test="${!empty sbr4 }">
			
<c:forEach items="${sbr4}" var="entry" varStatus="statu">
              <div class="timeline-item">
                <span class="time"><i class="glyphicon glyphicon-dashboard"></i> ${entry.qi }期</span>

                <h3 class="timeline-header"><a href="###" onclick="importDetail('${entry.id }',1)">${entry.typeVaule }</a> </h3>

                <div class="timeline-body">
                 ${entry.queryValue }<br> <span
								style="color: red;">历史最高跑${entry.num }期，目前已经跑${entry.sum }期。</span>
                </div>
                
              </div> 
              	</c:forEach>


			</c:when>
			<c:otherwise>
			<div class="timeline-item">
                 

                <div class="timeline-body">
                <span style="color: red;">没有要排除的规律！</span>
                </div>
                
              </div> 
			 
			</c:otherwise>
		</c:choose>
            </li> 
      
         
                    					        <li>
              <i class="fa  bg-black">60%</i>
              
              	<c:choose>
			<c:when test="${!empty sbr5 }">
			
<c:forEach items="${sbr5}" var="entry" varStatus="statu">
              <div class="timeline-item">
                <span class="time"><i class="glyphicon glyphicon-dashboard"></i> ${entry.qi }期</span>

                <h3 class="timeline-header"><a href="###" onclick="importDetail('${entry.id }',1)">${entry.typeVaule }</a> </h3>

                <div class="timeline-body">
                 ${entry.queryValue }<br> <span
								style="color: red;">历史最高跑${entry.num }期，目前已经跑${entry.sum }期。</span>
                </div>
                
              </div> 
              	</c:forEach>


			</c:when>
			<c:otherwise>
			<div class="timeline-item">
                 

                <div class="timeline-body">
                <span style="color: red;">没有要排除的规律！</span>
                </div>
                
              </div> 
			 
			</c:otherwise>
		</c:choose>
            </li> 
         
         
            
            <li>
              <i class="fa fa-clock-o bg-gray"></i>
            </li>
          </ul>
        </div>
        <!-- /.col -->
      </div>
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	</div>









	</section>

	<div id="importUserBox">
		<div id="impordetails"></div>
	</div>


	<script>
		function importDetail(id,type) {
			 
detail(id,type);
			var dialog = art.dialog({
				 
				width : 380,
				lock : true,
				title : "图规",
				 

				content : document.getElementById("importUserBox"),
				beforeunload : function() {
					$("#impordetails").empty();
				}

			});
			dialog.follow(document.getElementById('myNavbar_'+id));
			
		}
	</script>




	<script type="text/javascript">
		function detail(id,type) {

			$("#impordetails").empty();

			$.ajax({
				type : "post",
				url : "${basePath}/system/ajax/guilv/detail",
				dataType : "html",
				data : {
					id : id,
					type:type,
					typeq:type
				},
				success : function(html) {

					$("#impordetails").empty();
					$("#impordetails").append(html);
				}
			});
		}
	</script>


</body>
</html>
