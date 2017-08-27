<%@ page language="java" pageEncoding="UTF-8" %> 
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
  <!-- Left side column. contains the logo and sidebar -->
  <aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
      <!-- Sidebar user panel -->
      <div class="user-panel">
        <div class="pull-left image">
          <img src="${basePath}/static/images/user2-160x160.jpg" class="img-circle" alt="User Image">
        </div>
        <div class="pull-left info">
          <p><shiro:principal property="name"/></a></p>
          <a href="#"><i class="fa fa-circle text-success"></i> <shiro:principal property="userType"/></a>
        </div>
      </div>
     
    
      <!-- sidebar menu: : style can be found in sidebar.less -->
      <ul class="sidebar-menu">
        <li class="header">MAIN NAVIGATION</li>
    
        <li class="treeview ${error_active }" >
          <a href="${basePath}/admin/guilv/error">
            <i class="fa fa-files-o"></i>
            <span>断规</span>
           
          </a>
         
        </li>
        <li class="treeview ${limit_active }"  >
          <a href="${basePath}/admin/guilv/limit">
            <i class="fa fa-th"></i> <span>极限规</span>
           
          </a>
        </li>
          
               
        
         <shiro:hasPermission name="user:user">  
        <li class="treeview ${sum_error }" >
          <a href="${basePath}/admin/guilv/sum_error">
            <i class="fa fa-pie-chart"></i>
            <span>本期排除</span>
             
          </a>
          
        </li>
        </shiro:hasPermission>
          <shiro:hasPermission name="user:user">  
        <li class="treeview ${pl5_sum_error }" >
          <a href="${basePath}/admin/guilv/pl5/sum_error">
            <i class="fa fa-pie-chart"></i>
            <span>排列5本期排除</span>
             
          </a>
          
        </li>
        </shiro:hasPermission>
        
        
          <li class="treeview ${push_active }" >
          <a href="#">
            <i class="fa fa-edit"></i> <span>推送码</span>
            <i class="fa fa-angle-left pull-right"></i>
          </a>
          <ul class="treeview-menu">
            <li><a href="${basePath}/admin/qxc/plan"><i class="fa fa-circle-o"></i> 查询</a></li>
            <li><a href="${basePath}/admin/guilv/pl5/push"><i class="fa fa-circle-o"></i> 查询排列5</a></li>
              <shiro:hasPermission name="user:user">   
            <li><a href="${basePath}/admin/guilv/push/save"><i class="fa fa-circle-o"></i> 添加</a></li>
            <li><a href="${basePath}/admin/guilv/pl5/push/save"><i class="fa fa-circle-o"></i> 添加排列5</a></li>
            </shiro:hasPermission>
          </ul>
        </li>
        
        
        <li class="treeview ${limit2_active }" >
          <a href="${basePath}/admin/guilv/limit2">
            <i class="fa fa-laptop"></i>
            <span>历史全对</span>
            
          </a>
          
        </li>
             
          <li class="treeview ${peer_active }"  >
          <a href="#">
            <i class="fa fa-calendar"></i> <span>七星规</span>
            <i class="fa fa-angle-left pull-right"></i>
          </a>
          <ul class="treeview-menu">
          <li><a href="${basePath}/admin/guilv/index"><i class="fa fa-circle-o"></i> 综合规</a></li>
          <li><a href="${basePath}/admin/guilv/singleDouble"><i class="fa fa-circle-o"></i> 单双规</a></li>
           <li><a href="${basePath}/admin/guilv/peer2"><i class="fa fa-circle-o"></i> 坐标规</a></li>
           <li><a href="${basePath}/admin/guilv/peer3"><i class="fa fa-circle-o"></i> 对局规</a></li>
           <li><a href="${basePath}/admin/guilv/peer"><i class="fa fa-circle-o"></i> 对等规</a></li>
           <li><a href="${basePath}/admin/guilv/same"><i class="fa fa-circle-o"></i> 全合规</a></li>
              
          </ul>
        </li>
        
       
        
      
          <shiro:hasPermission name="user:user">    
        <li class="treeview ${user_active }"  >
          <a href="#">
            <i class="fa fa-table"></i> <span>用户管理</span>
            <i class="fa fa-angle-left pull-right"></i>
          </a>
          <ul class="treeview-menu">
            <li><a href="${basePath}/admin/user"><i class="fa fa-circle-o"></i> 查询</a></li>
         
          </ul>
        </li>
       </shiro:hasPermission> 
     
       
      </ul>
    </section>
    <!-- /.sidebar -->
  </aside>

            