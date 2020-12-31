<%--
  Created by IntelliJ IDEA.
  User: 蜘蛛啊全是腿儿
  Date: 2020-12-17
  Time: 22:59:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<input type="text" id="txtName" value="admin" onblur="blu()">
<table style="border: #0C0C0C solid 2px">
    <tr>
        <td>姓名</td>
        <td>年龄</td>
        <td>性别</td>
    </tr>
    <tbody id="content"></tbody>
</table>
<hr>
<input type="button" id="btn" onclick="bla()" value="获取数据">

</body>

<script src="https://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>

<script>
    function blu() {
        //重要参数 url data success(data)回调函数
        $.ajax({
            //发给服务器
            url: "/ajax",
            type: "post",
            //获取参数值
            data: {"name": $("#txtName").val()},
            //success(data), data-->封装了服务器返回的数据
            success: function (data, status) {
                console.log(data),
                    console.log(status)
            }
        });

    }
</script>

<script>
    function bla() {
        $.ajax({
            url: "${pageContext.request.contextPath}/ajax1",
            dataType:'json',
            success : function (data) {
                console.log(data.length);

                var con="";
                for (i=0;i<data.length;i++){
                    console.log(data[i]['name']+"--"+data[i]['id']+"--"+data[i]['sex']);

                    con += "<tr>" +
                       "<td>" + data[i]['name'] +"</td>" +
                       "<td>" + data[i]['id']   +"</td>" +
                       "<td>" + data[i]['sex']  +"</td>";
                }
                $("#content").html(con)
            }
        })
    }
</script>

</html>
