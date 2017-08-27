<%@ page contentType="text/html;charset=UTF-8" %> 
 
 <%@ include file="/WEB-INF/share/taglib.jsp"%>
 
<!DOCTYPE html>
<html lang="zh-CN">
<head>
 
   
        <title> </title> 
     

 

</head>

<body> 
 
            <!-- /.row -->
            <div class="row"  >
       <div class="col-md-12">
          <!-- general form elements -->
          <div class="box box-primary">
            <div class="box-header with-border">
              <h3 class="box-title">推送码</h3>
            </div>
            <!-- /.box-header -->
            <!-- form start -->
            <form role="form" action="${basePath}/admin/guilv/push/save" method="post">
              <div class="box-body">
                <div class="form-group">
                  <label for="qi">期数：</label>
                  <input type="text" class="form-control" id="qi" name="qi"  placeholder="请输入期数">
                </div>
                 <div class="form-group">
                  <label for="exampleInputPassword1">2401组四定：</label>
                  
                     <br>          
                  头： <input type="text" class="form-control" name="infos1"  >
                   
                    百：<input type="text" class="form-control" name="infos2"   >
                     十：<input type="text" class="form-control" name="infos3"   >
                      尾：<input type="text" class="form-control" name="infos4"  >
                </div>
                <div class="form-group">
                  <label for="exampleInputPassword1">1296组四定：</label> 
                    <br>        
                   头：<input type="text" class="form-control" name="infos5"  >
                   
                    百：<input type="text" class="form-control" name="infos6"   >
                     十：<input type="text" class="form-control" name="infos7"   >
                      尾：<input type="text" class="form-control" name="infos8"  >
                </div>
               <div class="form-group">
                  <label for="exampleInputPassword1">256组四定：</label> 
                      <br>        
                    头：<input type="text" class="form-control" name="infos9"  >
                   
                    百：<input type="text" class="form-control" name="infos10"   >
                     十：<input type="text" class="form-control" name="infos11"   >
                      尾：<input type="text" class="form-control" name="infos12"  >
                </div>
                  <div class="form-group">
                  <label for="exampleInputPassword1">三定：</label>
                   
                     <br>        
                    头：<input type="text" class="form-control" name="infos13"  >
                   
                    百：<input type="text" class="form-control" name="infos14"   >
                     十：<input type="text" class="form-control" name="infos15"   >
                      尾：<input type="text" class="form-control" name="infos16"  >
                </div>
                 <div class="form-group">
                  <label for="exampleInputPassword1">二定：</label> 
                     <br>         
                    头：<input type="text" class="form-control" name="infos17"  >
                   
                    百：<input type="text" class="form-control" name="infos18"   >
                     十：<input type="text" class="form-control" name="infos19"   >
                      尾：<input type="text" class="form-control" name="infos20"  >
                </div>
                <div class="form-group">
                  <label for="exampleInputPassword1">36组二定：</label>
                   
                     <br>         
                    头：<input type="text" class="form-control" name="infos21"  >
                   
                    百：<input type="text" class="form-control" name="infos22"   >
                     十：<input type="text" class="form-control" name="infos23"   >
                      尾：<input type="text" class="form-control" name="infos24"  >
                </div>
                
                 <div class="form-group">
                  <label for="exampleInputPassword1">49组二定：</label> 
                        <br>         
                    头：<input type="text" class="form-control" name="infos25"  >
                   
                    百：<input type="text" class="form-control" name="infos26"   >
                     十：<input type="text" class="form-control" name="infos27"   >
                      尾：<input type="text" class="form-control" name="infos28"  >
                </div>
                
              </div>
              <!-- /.box-body -->

              <div class="box-footer">
                <button type="submit" class="btn btn-primary">提交</button>
              </div>
            </form>
          </div>

 </div>  
   
  </div>  
</body>
</html>
