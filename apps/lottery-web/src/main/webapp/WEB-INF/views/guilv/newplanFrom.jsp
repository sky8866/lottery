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
            <form role="form" action="${basePath}/system/guilv/newplan/save" method="post">
              <div class="box-body">
                <div class="form-group">
                  <label for="qi">期数：</label>
                  <input type="text" class="form-control" id="qi" name="qi" value="${plan.qi }"  placeholder="请输入期数">
                </div>
                 <div class="form-group">
                  <label for="exampleInputPassword1">看好数：</label>
                  
                     <br>          
                  头： <input type="text" class="form-control" value="${plan.number1 }" name="number1"  >
                   
                    百：<input type="text" class="form-control" value="${plan.number2 }" name="number2"   >
                     十：<input type="text" class="form-control" value="${plan.number3 }"  name="number3"   >
                      尾：<input type="text" class="form-control" value="${plan.number4 }" name="number4"  >
            排除头： <input type="text" class="form-control" value="${plan.number5 }" name="number5"  >
                   
                    排除百：<input type="text" class="form-control" value="${plan.number6 }" name="number6"   >
                    排除 十：<input type="text" class="form-control" value="${plan.number7 }"  name="number7"   >
                    排除 尾：<input type="text" class="form-control" value="${plan.number8 }" name="number8"  >           
                      
                       类型：<input type="text" class="form-control" value="${plan.type }" name="type"  >
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
