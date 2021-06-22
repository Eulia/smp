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
<body>
         <div class="main">
            <div class="container a-container" id="a-container">
            
                <form class="form" id="a-form" method="get" action="opServlet2">
                    <h2 class="form_title title">输入数据</h2>
                    <div class="form__icons">
                        </div>
                    <input class="form__input" type="text" placeholder="name" name="add_name" value="">
                    <input class="form__input" type="text" placeholder="comebackornot" name="add_comebackornot" value="">
                    <input class="form__input" type="text" placeholder="reason" name="add_reason" value="">
                   <input class="form__button button submit" type="submit" value="提交" >     
                </form>
                
            </div>
           
            
        </div>
            
        
</body>
</html>