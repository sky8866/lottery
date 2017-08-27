<%@ page contentType="text/html;charset=UTF-8"%>

<%@ include file="/WEB-INF/share/taglib.jsp"%>

<!DOCTYPE html>
<html lang="zh-CN">
<head>



<style type="text/css"> .yuanjiao{ 
font-family: Arial; 
border: 1px solid #379082; 
border-radius: 5px;  
 width: 100%;
}
.valueactive{ 
 font-family: Arial;
 border: 1px solid #379082;
 border-radius: 5px;
background-color:red;

width: 20px; 
 height: 20px; 
}

.valueactive2{ 
 font-family: Arial;
 border: 1px solid #379082;
 border-radius: 20px;
background-color:green;   
width: 20px; 
 height: 20px;
}
 

 #tab{
      position:absolute;
          z-index：-1;           
            }  
             #tab2{
      position:absolute;
          z-index：-1;           
            }  
</style> 



	
	 
</head>

<body  onload="on()" >
 
	<div >
		<table class="table  table-bordered"
			style="width: 300px; height: 35px;" id="tab">

			<tr class="active">
				<td class="success text-center" style="width: 40px;  height: 25px;"><div class="b" >期数</div></td>
				<td class="warning text-center" style="width: 15px;  height: 25px;">
					<div class="b" >值</div></td>
				<td class="text-center" style="width: 25px;  height: 25px;"><div class="b" >A</div>
					 
				</td>
				<td class="text-center" style="width: 25px;  height: 25px;"><div class="b" >B</div></td>
				<td class="text-center" style="width: 25px;  height: 25px;"><div class="b" >C</div></td>
				<td class="text-center" style="width: 25px;  height: 25px;"><div class="b" >D</div></td>
				<td class="danger text-center" style="width: 25px;  height: 25px;"><div class="b" >E</div>
				</td>
				<td class="danger text-center" style="width: 25px;  height: 25px;"><div class="b" >F</div>
				</td>
				<td class="danger text-center" style="width: 25px;  height: 25px;"><div class="b" >G</div></td>
			</tr>

			<c:forEach items="${lsList}" var="entry" varStatus="statu">

				<tr >
					<td class="success text-center" style="width: 40px; height: 25px;"><div class="b" >${entry.qi
						}</div></td>
					<td class="warning text-center" style="width: 15px; height: 25px;"><div class="b" >${entry.zhi
						}</div></td>
						
					<td class="text-center" style="width: 25px;  height: 25px;  " >
						<c:if test="${entry.v1==10&&entry.vv1!=10&&entry.p1!=10&&entry.pp1!=10}">
					<div class="aa" style="border-color:red;"></div>
					</c:if> 
					<c:if test="${entry.v1!=10&&entry.vv1==10&&entry.p1!=10&&entry.pp1!=10}">
					<div class="bb" style="border-color:green;"></div>
					
					</c:if>
					<c:if test="${entry.v1==10&&entry.vv1==10&&entry.p1==10&&entry.pp1==10}">
					<div class="cc" style="border-color:blue;"></div>
					
					</c:if> 
					
					<c:if test="${entry.v1!=10&&entry.vv1!=10&&entry.p1==10&&entry.pp1!=10}">
					<div class="aap" style="border-color:orange;"></div>
					</c:if> 
					<c:if test="${entry.v1!=10&&entry.vv1!=10&&entry.p1!=10&&entry.pp1==10}">
					<div class="bbp" style="border-color:black;"></div>
					
					</c:if> 
					<div class="e text-center
					 <c:if test="${entry.v1==10||entry.vv1==10}"> valueactive </c:if> 
					  <c:if test="${entry.p1==10||entry.pp1==10}"> valueactive2 </c:if>
					 <c:if test="${entry.qi==lottery.qi&&guilv.type==0 }">  yuanjiao   </c:if> " 
					 style="width: 15px;  height: 15px;  ">
					 ${entry.number1 }
					 </div> 
                   </td>
					<td class="text-center" style="width: 25px;  height: 25px;  " >
					<c:if test="${entry.v2==10&&entry.vv2!=10&&entry.p2!=10&&entry.pp2!=10}">
					<div class="aa" style="border-color:red;"></div>
					</c:if> 
					<c:if test="${entry.v2!=10&&entry.vv2==10&&entry.p2!=10&&entry.pp2!=10}">
					<div class="bb" style="border-color:green;"></div>
					
					</c:if>
					<c:if test="${entry.v2==10&&entry.vv2==10&&entry.p2==10&&entry.pp2==10}">
					<div class="cc" style="border-color:blue;"></div>
					
					</c:if> 
					
					<c:if test="${entry.v2!=10&&entry.vv2!=10&&entry.p2==10&&entry.pp2!=10}">
					<div class="aap" style="border-color:orange;"></div>
					</c:if> 
					<c:if test="${entry.v2!=10&&entry.vv2!=10&&entry.p2!=10&&entry.pp2==10}">
					<div class="bbp" style="border-color:black;"></div>
					
					</c:if>
					 
					<div class="e text-center
					<c:if test="${entry.v2==10||entry.vv2==10}"> valueactive  </c:if>
					  <c:if test="${entry.p2==10||entry.pp2==10}"> valueactive2 </c:if>
					<c:if test="${entry.qi==lottery.qi&&guilv.type==1 }">  yuanjiao   </c:if> "
					 style="width: 15px;  height: 15px;  ">
					 ${entry.number2 }
					 </div>
					  </td>
					<td class="text-center" style="width: 25px;  height: 25px;  " >
						<c:if test="${entry.v3==10&&entry.vv3!=10&&entry.p3!=10&&entry.pp3!=10}">
					<div class="aa" style="border-color:red;"></div>
					</c:if> 
					<c:if test="${entry.v3!=10&&entry.vv3==10&&entry.p3!=10&&entry.pp3!=10}">
					<div class="bb" style="border-color:green;"></div>
					
					</c:if>
					<c:if test="${entry.v3==10&&entry.vv3==10&&entry.p3==10&&entry.pp3==10}">
					<div class="cc" style="border-color:blue;"></div>
					
					</c:if> 
					
					<c:if test="${entry.v3!=10&&entry.vv3!=10&&entry.p3==10&&entry.pp3!=10}">
					<div class="aap" style="border-color:orange;"></div>
					</c:if> 
					<c:if test="${entry.v3!=10&&entry.vv3!=10&&entry.p3!=10&&entry.pp3==10}">
					<div class="bbp" style="border-color:black;"></div>
					
					</c:if>
					 <div class="e text-center
					 <c:if test="${entry.v3==10||entry.vv3==10}"> valueactive </c:if>
					   <c:if test="${entry.p3==10||entry.pp3==10}"> valueactive2 </c:if>
					 <c:if test="${entry.qi==lottery.qi&&guilv.type==2 }">  yuanjiao   </c:if>"
					  style="width: 15px;  height: 15px;  ">
					  ${entry.number3 }
					  </div>
					 </td>
					<td class="text-center" style="width: 25px;  height: 25px;  " >
					
                    	<c:if test="${entry.v4==10&&entry.vv4!=10&&entry.p4!=10&&entry.pp4!=10}">
					<div class="aa" style="border-color:red;"></div>
					</c:if> 
					<c:if test="${entry.v4!=10&&entry.vv4==10&&entry.p4!=10&&entry.pp4!=10}">
					<div class="bb" style="border-color:green;"></div>
					
					</c:if>
					<c:if test="${entry.v4==10&&entry.vv4==10&&entry.p4==10&&entry.pp4==10}">
					<div class="cc" style="border-color:blue;"></div>
					
					</c:if> 
					
					<c:if test="${entry.v4!=10&&entry.vv4!=10&&entry.p4==10&&entry.pp4!=10}">
					<div class="aap" style="border-color:orange;"></div>
					</c:if> 
					<c:if test="${entry.v4!=10&&entry.vv4!=10&&entry.p4!=10&&entry.pp4==10}">
					<div class="bbp" style="border-color:black;"></div>
					
					</c:if>
                  <div class="e text-center
                  <c:if test="${entry.v4==10||entry.vv4==10}"> valueactive  </c:if>
                    <c:if test="${entry.p4==10||entry.pp4==10}"> valueactive2 </c:if>
                  <c:if test="${entry.qi==lottery.qi&&guilv.type==3 }">  yuanjiao   </c:if>"
                   style="width: 15px;  height: 15px;  ">
                   ${entry.number4 }
                   </div>
					</td>
					<td class="text-center" style="width: 25px;  height: 25px;" >
					
                	<c:if test="${entry.v5==10&&entry.vv5!=10&&entry.p5!=10&&entry.pp5!=10}">
					<div class="aa" style="border-color:red;"></div>
					</c:if> 
					<c:if test="${entry.v5!=10&&entry.vv5==10&&entry.p5!=10&&entry.pp5!=10}">
					<div class="bb" style="border-color:green;"></div>
					
					</c:if>
					<c:if test="${entry.v5==10&&entry.vv5==10&&entry.p5==10&&entry.pp5==10}">
					<div class="cc" style="border-color:blue;"></div>
					
					</c:if> 
					
					<c:if test="${entry.v5!=10&&entry.vv5!=10&&entry.p5==10&&entry.pp5!=10}">
					<div class="aap" style="border-color:orange;"></div>
					</c:if> 
					<c:if test="${entry.v5!=10&&entry.vv5!=10&&entry.p5!=10&&entry.pp5==10}">
					<div class="bbp" style="border-color:black;"></div>
					
					</c:if>
				 <div class="e text-center
				 <c:if test="${entry.v5==10||entry.vv5==10}"> valueactive </c:if> 
				   <c:if test="${entry.p5==10||entry.pp5==10}"> valueactive2 </c:if> " 
				 style="width: 15px;  height: 15px;  ">
				 ${entry.number5 }
				 </div>
                    </td>
					<td class="text-center" style="width: 25px;  height: 25px;" >
						
                    	<c:if test="${entry.v6==10&&entry.vv6!=10&&entry.p6!=10&&entry.pp6!=10}">
					<div class="aa" style="border-color:red;"></div>
					</c:if> 
					<c:if test="${entry.v6!=10&&entry.vv6==10&&entry.p6!=10&&entry.pp6!=10}">
					<div class="bb" style="border-color:green;"></div>
					
					</c:if>
					<c:if test="${entry.v6==10&&entry.vv6==10&&entry.p6==10&&entry.pp6==10}">
					<div class="cc" style="border-color:blue;"></div>
					
					</c:if> 
					
					<c:if test="${entry.v6!=10&&entry.vv6!=10&&entry.p6==10&&entry.pp6!=10}">
					<div class="aap" style="border-color:orange;"></div>
					</c:if> 
					<c:if test="${entry.v6!=10&&entry.vv6!=10&&entry.p6!=10&&entry.pp6==10}">
					<div class="bbp" style="border-color:black;"></div>
					
					</c:if>
                   <div class="e  text-center
                   <c:if test="${entry.v6==10||entry.vv6==10}"> valueactive  </c:if>
                     <c:if test="${entry.p6==10||entry.pp6==10}"> valueactive2 </c:if>" 
                   style="width: 20px;  height: 20px;  ">
                   ${entry.number6 }
                   </div>
                    </td>
					<td class="text-center" style="width: 25px;  height: 25px;  " >
					
                   	<c:if test="${entry.v7==10&&entry.vv7!=10&&entry.p7!=10&&entry.pp7!=10}">
					<div class="aa" style="border-color:red;"></div>
					</c:if> 
					<c:if test="${entry.v7!=10&&entry.vv7==10&&entry.p7!=10&&entry.pp7!=10}">
					<div class="bb" style="border-color:green;"></div>
					
					</c:if>
					<c:if test="${entry.v7==10&&entry.vv7==10&&entry.p7==10&&entry.pp7==10}">
					<div class="cc" style="border-color:blue;"></div>
					
					</c:if> 
					
					<c:if test="${entry.v7!=10&&entry.vv7!=10&&entry.p7==10&&entry.pp7!=10}">
					<div class="aap" style="border-color:orange;"></div>
					</c:if> 
					<c:if test="${entry.v7!=10&&entry.vv7!=10&&entry.p7!=10&&entry.pp7==10}">
					<div class="bbp" style="border-color:black;"></div>
					
					</c:if>
                <div class="e text-center
                <c:if test="${entry.v7==10||entry.vv7==10}"> valueactive  </c:if>
                  <c:if test="${entry.p7==10||entry.pp7==10}"> valueactive2 </c:if>" 
                style="width: 15px;  height: 15px; " >
                ${entry.number7 }
                </div>
                    </td>
				</tr>

 

			</c:forEach>
	 
			<tr style="  border-bottom: 1px red solid;" > 
				<td class="success text-center" width="55"  ><div class="e"></div> ${newQi } </td>
				<td class="warning text-center" width="12"><div class="e"></div></td>
				<td > 
			 
				<c:if test="${guilv.type==0 }"> 
					<div class="aap" style="border-color:orange;"></div>
				 <div style="float:left;   position:absolute; "> <div class="yuanjiao " >${guilv.value }头</div><c:if  test="${ !empty type }"><div style="color:red;   ">[${type }]</div></c:if></div>
					 </c:if>
				</td>
				<td > 
				<c:if test="${guilv.type==1 }">
				<div class="aap" style="border-color:orange;"></div>
				 <div style="float:left;   position:absolute; "> <div class="yuanjiao " >${guilv.value }百</div><c:if  test="${ !empty type }"><div style="color:red;   ">[${type }]</div></c:if></div>
				   </c:if>
				 </td>
				<td  > 
				<c:if  test="${guilv.type==2 }">
				<div class="aap" style="border-color:orange;"></div>
			 <div style="float:left;   position:absolute; "> <div class="yuanjiao " >${guilv.value }十</div><c:if  test="${ !empty type }"><div style="color:red;   ">[${type }]</div></c:if></div>
				</c:if>
				 </td>
				<td > 
				<c:if  test="${guilv.type==3 }">
				<div class="aap" style="border-color:orange;"></div>
				 <div style="float:left;   position:absolute; "> <div class="yuanjiao " >${guilv.value }尾</div><c:if  test="${ !empty type }"><div style="color:red;   ">[${type }]</div></c:if></div>
				 </c:if>
				</td>
				<td class=" text-center" width="45"><div class="e"></div></td>
				<td class=" text-center" width="45"><div class="e"></div></td>
				<td class=" text-center" width="45"><div class="e"></div></td>
				 
			</tr>
         <tr>

			<td colspan="9" width="300"><div class="e"></div>
			规说明：${lsVaule } 
			<span  style="color: red;"><br> ${valueType }</span>
			</td>
		</tr>
		</table>
		 <canvas  id="myCanvas" class="text-center" width="300" height="2200"></canvas>
		  
	</div>
 
 <script type="text/javascript">
     function on2() {
       
        var canvas = document.getElementById('myCanvas');
        var ctx = canvas.getContext('2d');
        var tab = document.getElementById('tab');
        var x;
        var y;
        var lx;
        var ly;
         var xp;
        var yp;
        var lxp;
        var lyp;
        var ol=15;
        var ot=15;
        for (i = 0; i < tab.rows.length; i++) {
            for (j = 0; j < tab.rows[0].cells.length; j++) {
          
                var da = document.getElementById('tab').rows[i].cells[j];
                 
              var tta=$(da).children("div").attr("class");
               // var ta = document.getElementsByClassName(tta);
                if ($(".aa").attr("style") == 'border-color:red;' && tta == "aa") {
                //if (ta.style.borderColor == 'red' && tta == "aa") {
                    //多加了一个名称的限定
                    
                    var xx = da.offsetLeft + ol;
                    var yy = da.offsetTop +ot;

                    if (x != null && y != null) {
                        ctx.beginPath();
                        ctx.moveTo(x, y);
                        ctx.lineTo(xx, yy);
                        ctx.strokeStyle = "red";
                        ctx.stroke();
                    }
                    if (x != xx) {
                        x = xx;
                    }
                    if (y != yy) {
                        y = yy;
                    }
                }
                  if ($(".bb").attr("style") == 'border-color:green;' && tta == "bb") {
              //  if (ta.style.borderColor == "green" && tta=="bb") {
                    var lxx = da.offsetLeft + ol;
                    var lyy = da.offsetTop + ot;

                    if (lx != null && ly != null) {
                        ctx.beginPath();
                        ctx.moveTo(lx, ly);
                        ctx.lineTo(lxx, lyy);
                        ctx.strokeStyle = "green";
                        ctx.stroke();
                    }
                    if (lx != lxx) {
                        lx = lxx;
                    }
                    if (ly != lyy) {
                        ly = lyy;
                    }
                }
                
                   if ($(".aap").attr("style") == 'border-color:orange;' && tta == "aap") {
                   
                //if (ta.style.borderColor == 'red' && tta == "aa") {
                    //多加了一个名称的限定
                    
                    var xxp = da.offsetLeft + ol;
                    var yyp = da.offsetTop +ot;

                    if (xp != null && yp != null) {
                        ctx.beginPath();
                        ctx.moveTo(xp, yp);
                        ctx.lineTo(xxp, yyp);
                        ctx.strokeStyle = "green";
                        ctx.stroke();
                    }
                    if (xp != xxp) {
                        xp = xxp;
                    }
                    if (yp != yyp) {
                        yp = yyp;
                    }
                }
                  if ($(".bbp").attr("style") == 'border-color:black;' && tta == "bbp") {
              //  if (ta.style.borderColor == "green" && tta=="bb") {
                    var lxxp = da.offsetLeft + ol;
                    var lyyp = da.offsetTop + ot;

                    if (lxp != null && lyp != null) {
                        ctx.beginPath();
                        ctx.moveTo(lxp, lyp);
                        ctx.lineTo(lxxp, lyyp);
                        ctx.strokeStyle = "black";
                        ctx.stroke();
                    }
                    if (lxp != lxxp) {
                        lxp = lxxp;
                    }
                    if (lyp != lyyp) {
                        lyp = lyyp;
                    }
                }
                
                if ($(".cc").attr("style") == 'border-color:blue;' && tta == "cc") {
                 //if (ta.style.borderColor == "blue" && tta=="cc") {
                    var lxx = da.offsetLeft + ol;
                    var lyy = da.offsetTop + ot;

                    if (lx != null && ly != null) {
                        ctx.beginPath();
                        ctx.moveTo(lx, ly);
                        ctx.lineTo(lxx, lyy);
                        ctx.strokeStyle = "green";
                        ctx.stroke();
                    }
                    if (lx != lxx) {
                        lx = lxx;
                    }
                    if (ly != lyy) {
                        ly = lyy;
                    }
                    
                    var xx = da.offsetLeft + ol;
                    var yy = da.offsetTop + ot;

                    if (x != null && y != null) {
                        ctx.beginPath();
                        ctx.moveTo(x, y);
                        ctx.lineTo(xx, yy);
                        ctx.strokeStyle = "red";
                        ctx.stroke();
                    }
                    if (x != xx) {
                        x = xx;
                    }
                    if (y != yy) {
                        y = yy;
                    }
                      var xxp = da.offsetLeft + ol;
                    var yyp = da.offsetTop +ot;

                    if (xp != null && yp != null) {
                        ctx.beginPath();
                        ctx.moveTo(xp, yp);
                        ctx.lineTo(xxp, yyp);
                        ctx.strokeStyle = "orange";
                        ctx.stroke();
                    }
                    if (xp != xxp) {
                        xp = xxp;
                    }
                    if (yp != yyp) {
                        yp = yyp;
                    }
                    
                     var lxxp = da.offsetLeft + ol;
                    var lyyp = da.offsetTop + ot;

                    if (lxp != null && lyp != null) {
                        ctx.beginPath();
                        ctx.moveTo(lxp, lyp);
                        ctx.lineTo(lxxp, lyyp);
                        ctx.strokeStyle = "black";
                        ctx.stroke();
                    }
                    if (lxp != lxxp) {
                        lxp = lxxp;
                    }
                    if (lyp != lyyp) {
                        lyp = lyyp;
                    }
                }
            }
 
            
            
        }
    }
 
 		
		   (function ($) {
		      $(document).ready(function() {
		   
		     on2();
		      
		      });
		    
		    })(jQuery);  
</script>
 
</body>
</html>
