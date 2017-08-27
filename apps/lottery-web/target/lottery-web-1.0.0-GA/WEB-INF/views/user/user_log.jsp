<%@ page contentType="text/html;charset=UTF-8" %> 
 
 <%@ include file="/WEB-INF/share/taglib.jsp"%>
 
<!DOCTYPE html>
<html lang="zh-CN">
<head>
 
   
        <title>个人中心</title> 
     

 <script src="https://img.hcharts.cn/jquery/jquery-1.8.3.min.js" type="text/javascript"></script>
<script src="https://img.hcharts.cn/highcharts/highcharts.js" type="text/javascript"></script>
<script src="https://img.hcharts.cn/highcharts/modules/exporting.js" type="text/javascript"></script>
<script src="https://img.hcharts.cn/highcharts-plugins/highcharts-zh_CN.js" type="text/javascript"></script>
</head>

<body> 
 
 <div id="container2" style="min-width:600px;height:600px"></div>
   
       <script type="text/javascript">
       
       $(function () {
    $('#container2').highcharts({
        chart: {
            type: 'column'
        },
        title: {
            text: '每日访问量'
        },
        subtitle: {
            text: ''
        },
        xAxis: {
            categories: [
                '推送码',
                '历史全对',
                '本期排除',
                '权限',
                '重庆排除',
                '排列排除',
                '重庆计划',
                '排列计划', 
                '分享' 
            ],
            crosshair: true
        },
        yAxis: {
            min: 0,
            title: {
                text: '访问量'
            }
        },
        tooltip: {
            headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
            pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
            '<td style="padding:0"><b>{point.y:.1f} 次</b></td></tr>',
            footerFormat: '</table>',
            shared: true,
            useHTML: true
        },
        plotOptions: {
            column: {
                pointPadding: 0.2,
                borderWidth: 0
            }
        },
        series: [{
            name: '访问量',
            data: ${userlogs}
        } ]
    });
});
       
    
    	</script>  
</body>
</html>
