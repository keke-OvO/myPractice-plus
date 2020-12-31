<%--
  Created by IntelliJ IDEA.
  User: 蜘蛛啊全是腿儿
  Date: 2020-12-31
  Time: 20:19:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>layDate快速使用</title>
    <link rel="stylesheet" href="/layui/css/layui.css" media="all">
</head>
<body>

<div class="layui-inline"> <!-- 注意：这一层元素并不是必须的 -->
    <form class="layui-form">
        <input type="text" class="layui-input" id="test1">
        <button name="tj" id="tj" lay-submit lay-filter="tj">提交</button>
    </form>
</div>

<script src="/layui/layui.js"></script>
<script>
    layui.use(['laydate', 'jquery', 'form'], function () {
        const laydate = layui.laydate;
        const form = layui.form;
        const $ = layui.jquery;

        //执行一个laydate实例
        laydate.render({
            elem: '#test1' //指定元素
        });

        form.on('submit(tj)', function (data) {
            $.ajax({
                url: '/date',
                data: data.field,
                dataType: 'json',
                type: 'get',
                success: function (data) {
                    console.log(data);
                }

            });
        });

    });
</script>
</body>
</html>
