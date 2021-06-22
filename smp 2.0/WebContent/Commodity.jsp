<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.util.List"%>
<%@page import="com.yxr.tools.Goods"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="./style.css">
<title>Insert title here</title>

</head>

<title>商品信息界面</title>
	<script>
function myFunction()
{
     confirm_ = confirm('你确定要删除此信息么'); 
      if(confirm_)
       {   
            $.ajax
           ({
                type:"get",
                url:"de_number?id="+de_number,
                success:function(msg)
                         {
                          alert("删除成功"+msg);
                          $("#tr_"+de_number).remove();
                          }
           });          
      }           
}
</script>
    
  </head>
  
  <body>
  <div class="main">
  
  <table>

  			<th>学生姓名</th>
	  		<th>是否返校</th>
	  		<th>原因</th>
	  		
	  		<th>操作</th>
  		</tr>
     <c:forEach var="U" items="${goodslist}"  > 
      <form class="form" action="opServlet" method="get"> 
       <tr>
	       
	       <td><input type="text" value="${U.name}" name="name"></td>
	       <td><input type="text" value="${U.comebackornot}" name="comebackornot"></td>
	       <td><input type="text" value="${U.reason}" name="reason"></td>
	   	   <td><a href="opServlet?de_name=${U.name} " onclick="myFunction()">删除</a></td>
	   </tr>
   </form>
    </c:forEach>  
    
    </table>
     <form  action="opServlet" method="get">
        <label>查询的学生名称</label>
        <input class="form__input" type="text" name="se_name" value="">
        <input class="form__button button submit" type="submit" value="查询">    
    </form>
    <h5>修改学生信息</h5>
    <form  action="opServlet" method="get">
         
        <label>学生姓名</label>
        <input class="form__input" type="text" name="up_name" value="">
        </br>
        <label>是否返校</label>
        <input class="form__input" type="text" name="up_comebackornot" value=""> 
        </br> 
        <label>原因</label>
        <input class="form__input" type="text" name="up_reason" value="">             
        <input class="form__button button submit" type="submit" value="修改">     
    </form>
    </div>

  </body>
</html>

</html>