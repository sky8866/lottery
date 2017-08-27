<%@ page language="java" pageEncoding="UTF-8" %>
 
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>

  <header class="main-header">
    <!-- Logo -->
    <a href="###" class="logo">
      <!-- mini logo for sidebar mini 50x50 pixels -->
      <span class="logo-mini"><b>烨</b>轩</span>
      <!-- logo for regular state and mobile devices -->
      <span class="logo-lg"><b>烨轩</b>七星</span>
    </a>
    <!-- Header Navbar: style can be found in header.less -->
    <nav class="navbar navbar-static-top">
      <!-- Sidebar toggle button-->
      <a href="###" class="sidebar-toggle" data-toggle="offcanvas" role="button">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </a>

      <div class="navbar-custom-menu">
        <ul class="nav navbar-nav">
                   <li class="dropdown messages-menu">
            <a href="###" class="dropdown-toggle" data-toggle="dropdown">
              <i class="fa  fa-hand-o-right"></i> 关注我们
               
            </a>
            <ul class="dropdown-menu">
              <li class="header">扫描二维码公众号关注</li>
              <li>
                <!-- inner menu: contains the actual data -->
                <ul class="menu">
                  <li><!-- start message -->
                    <a href="###">
                      
                       
                      <p> <img width="160" height="160" src="${basePath}/static/images/qrcode_for_gh_7754d7ee2e90_344.jpg" class="user-image" alt="User Image"></p>
                    </a>
                  </li>
                  <!-- end message -->
               
                  
                 
                </ul>
              </li>
              <li class="footer" ><a href="#">关注会更精彩，QQ群：482956673</a></li>
            </ul>
          </li>
          
          <!-- User Account: style can be found in dropdown.less -->
          <li class="dropdown user user-menu">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
              <img src="${basePath}/static/images/user2-160x160.jpg" class="user-image" alt="User Image">
              <span class="hidden-xs"><shiro:principal property="name"/></a></span>
            </a>
            
          </li>
          <!-- Control Sidebar Toggle Button -->
        
          
          <li class="dropdown">
           <a href="javascript:exitsystem()"><i class="fa fa-sign-out fa-fw"></i> 退出</a>
          </li>
        </ul>
      </div>
    </nav>
  </header>   
         <script>

		
		
function exitsystem(){
	if (confirm('您确定要退出系统吗？'))
	  window.parent.location="${basePath}/web/logout"; 
}
	</script>   