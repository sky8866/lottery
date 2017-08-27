<%@ page contentType="text/html;charset=UTF-8" %> 
 
 <%@ include file="/WEB-INF/share/taglib.jsp"%>
 
<!DOCTYPE html>
<html lang="zh-CN">
<head>
 
   
        <title>排列推送码</title> 
     
<style>
.container{background-image:url("${basePath}/static/images/qrcode_for_gh_7754d7ee2e90_344.jpg") ;background-attachment:fixed;background-repeat:no-repeat;background-size:cover;-moz-background-size:cover;-webkit-background-size:cover;}
</style>
 

</head>

<body> 
 
            <!-- /.row -->
            <div class="row"  >
       <div class="col-md-12">
         <div class="box box-default">
          <div class="box-header with-border">
            <h3 class="box-title">第${push.qi }期</h3>
          </div>
          <div class="box-body">
           <p> ${push.info7 }</p> 
          <p> ${push.info }</p>   
          <p> ${push.info1 }</p>  
            <p> ${push.info2 }</p> 
             <p> ${push.info3 }</p> 
              <p>  <span style="color: red;"> ${push.info5 }</span></p> 
               <p>  <span style="color: red;"> ${push.info6 }</span></p> 
          </div>
          <!-- /.box-body -->
          
           <div class="box-body">
              <div class="callout callout-danger">
                <h4>说明：</h4>

                <p >本推送码是经过电脑算法分析而得出的结果，并不保证数据的准确性，仅作为参考！联系QQ:286549429，微信号：yexuan_zhang  </p>
                <p>欢迎关注微信公众号:<img alt="" src="${basePath}/static/images/qrcode_for_gh_7754d7ee2e90_344.jpg" width="70" height="70"></p> 
                <p>${user.aes }</p>
              </div>
             
               
               
            </div>
        </div>

 </div>  
   
  </div>  
</body>
</html>
