<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<div>
		<input type="text" id="start-time" class="input-large" placeholder="请选择开始日期" name="startTime" value="${startTime }">
		<input type="text" id="end-time" class="input-large" placeholder="请选择结束日期" name="endTime" value="${endTime }">
		<button id="search-book" class="btn" >搜索</button>
	<%-- <form class="form-search">
		<input type="text" id="start-time" class="input-large" placeholder="请选择开始日期" name="startTime" value="${startTime }">
		<input type="text" id="end-time" class="input-large" placeholder="请选择结束日期" name="endTime" value="${endTime }">
		<button id="search-book" class="btn" >搜索</button>
	</form> --%>
</div>
<script src="${basePath }laydate/laydate.js"></script>
<script>
	lay('#version').html('-v'+ laydate.v);
	//执行一个laydate实例
	laydate.render({
  		elem: '#start-time' //指定元素
	});
	laydate.render({
  		elem: '#end-time' //指定元素
	});
</script>