<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form action="/html" method="post">
    输入一个数：<input type="text" name="num1"/><br/>
    选择运算符：<select name="flag">
    <option value=1>+</option>
    <option value=2>-</option>
    <option value=3>*</option>
    <option value=4>/</option>
  </select><br>
    输另一个数：<input type="text" name="num2"/><br/>
    <input type="submit" value="提交"/><br/>
  </form>
  ${errorMsg }
  <h1>结果是:<%=request.getAttribute("result")%></h1>
  </body>
</html>
