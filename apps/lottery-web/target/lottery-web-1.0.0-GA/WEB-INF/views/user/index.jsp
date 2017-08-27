<%@ page contentType="text/html;charset=UTF-8" %> 
 
 <%@ include file="/WEB-INF/share/taglib.jsp"%>
 
<!DOCTYPE html>
<html lang="zh-CN">
<head>
 
   
        <title>个人中心</title> 
     

 

</head>

<body> 
 
            <!-- /.row -->
            <div class="row  "  >
            
            
         <div class="col-lg-12 col-xs-12 col-sm-12  "    >
          <!-- Custom tabs (Charts with tabs)-->
         
             
        

          <!-- Profile Image -->
          <div class="box box-primary">
            <div class="box-body box-profile">
              <img class="profile-user-img img-responsive img-circle" src="${user.imagePath }" >

              <h3 class="profile-username text-center">${user.name }</h3>

              <p class="text-muted text-center"> </p>

              <ul class="list-group list-group-unbordered">
                <li class="list-group-item">
                  <b>${user.usertype }</b> <a class="pull-right">
                  <c:if test="${user.isVip!=1 }">加入会员</c:if>
                   <c:if test="${user.isVip==1 }">${user.endDate }到期</c:if>
                  </a>
                </li>
                
                <li class="list-group-item">
                  <b>我的用户</b> <a href="${basePath}/system/user/qrscene/${user.aes}" class="pull-right">${user_qrscene }</a>
                </li>
              </ul>

              <a href="https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=${ticket }" class="btn btn-primary btn-block"><b>生成我的二维码</b></a>
            </div>
            <!-- /.box-body -->
          </div>
          <!-- /.box -->

       
        
        

        </div>     
            
            
 



            </div>
            <!-- /.row -->
   
    
</body>
</html>
