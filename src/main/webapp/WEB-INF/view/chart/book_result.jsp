<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<style>
	span {
		color:#0088CC;
	}
</style>

<script src="${basePath }js/echarts.js"></script>

<div id="main" style="width: 600px;height:400px;"></div>

<script type="text/javascript">
    // 基于准备好的dom，初始化echarts实例
    
    //myChart.showLoading();

    // 指定图表的配置项和数据
    var option = {
        title: {
            text: '热门书籍'
        },
        tooltip: {},
        legend: {
            data:['借阅次数']
        },
        xAxis: {
        	name: '书名',
            data: []
        },
        yAxis: {
        	name: '借阅次数',
        	minInterval: 1
        },
        series: [{
            name: '借阅次数',
            type: 'bar',
            data: [],
            barWidth: 40
        }]
    };
	
	$.ajax({
		url: baseUrl + 'chart/getBookListInit.do',
		type: 'GET',
		dataType: 'json',
		success: function(data){
			var x_arr = new Array();
			var y_arr = new Array();
			for (var i = 0; i < data.length; i++) {
				x_arr[i] = data[i].bookName;
				y_arr[i] = data[i].borrowTimes;
			}
			option.xAxis.data = x_arr;
			option.series[0].data = y_arr;
			var myChart = echarts.init(document.getElementById('main'));
			myChart.setOption(option);
		}
	});
	
	
	$("#search-book").click(function(){
		var startTime = $("#start-time").val();
		var endTime = $("#end-time").val();
		$.ajax({
			url: baseUrl + 'chart/getBookList.do',
			type: 'POST',
			dataType: 'json',
			data: {startTime:startTime, endTime:endTime},
			success: function(data){
				var x_arr = new Array();
				var y_arr = new Array();
				for (var i = 0; i < data.length; i++) {
					x_arr[i] = data[i].bookName;
					y_arr[i] = data[i].borrowTimes;
				}
				option.xAxis.data = x_arr;
				option.series[0].data = y_arr;
				var myChart = echarts.init(document.getElementById('main'));
				myChart.setOption(option);
			}
		});
	});
	
</script>
