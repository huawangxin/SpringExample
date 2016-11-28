<%@ page pageEncoding="utf-8"
	contentType="text/html;charset=utf-8"%>
<%@taglib  prefix="c" 
	uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE HTML>
<html>
  <head>
  <title>Spring 参数传递</title>
  <style type="text/css">
    h1, h2, h3, h4, h6, p{ padding: 0;  margin: 0; }
    div{ border: 1px solid #ddd; 
    padding: 5px;  width: 280px;
    margin: 10;
    float: left;}
    div h2{	color: white;	background: black;	text-align: center;	padding: 6px;  }
    div p{	background: #eee;padding: 6px;  }
    div h3{	background: #ddd;text-align: center;padding: 6px;   }
  	div h4 { color: red; background: black; 
  		text-align: center;}
  	div h6{ font-size: 14px; padding: 6px;
  		background: yellow; color: red; text-align: center;
  	}
  </style>
  </head>
  <body>
    <h1>Spring 参数传递 当前用户:${loginUser.name}</h1>
    <!-- 将 Web应用程序的路径保持到属性base -->
    <c:url var="base" value="/"></c:url>
    <div>
      <form action="${base}login/login-action1.form" 
      	method="post">
		<h2>登录 1</h2>
		<h4>${message1}</h4>		      
      	<p>账号:<input type="text" name="name"></p>
     	<p>密码:<input type="password" 
     		name="pwd"></p>
     	<h3><input type="submit" value="Login"></h3>
      </form>
    </div>
    
    <div>
      <form action="${base}login/login-action2.form" 
      	method="post">
		<h2>登录 2</h2>
		<h4>${message2}</h4>		      
      	<p>账号:<input type="text" name="name"></p>
     	<p>密码:<input type="password" 
     		name="pwd"></p>
     	<h3><input type="submit" value="Login"></h3>
      </form>
    </div>

    <div>
      <form action="${base}login/login-action3.form" 
      	method="post">
		<h2>登录 3</h2>
		<h4>${message3}</h4>		      
      	<p>账号:<input type="text" name="name"></p>
     	<p>密码:<input type="password" 
     		name="pwd"></p>
     	<h3><input type="submit" value="Login"></h3>
      </form>
    </div>
    
	<div>
      <c:url var="action4" 
      	value="/login/login-action4.form"></c:url>
      <form action="${action4}"	method="post">
		<h2>登录 4</h2>
		<h4>${message4}</h4>		      
      	<p>账号:<input type="text" name="name"></p>
     	<p>密码:<input type="password" 
     		name="pwd"></p>
     	<h3><input type="submit" value="Login"></h3>
      </form>
    </div>

	<div>
      <c:url var="action5" 
      	value="/login/login-action5.form"></c:url>
      <form action="${action5}"	method="post">
		<h2>登录 5</h2>
		<h4>${message5}</h4>		      
      	<p>账号:<input type="text" name="name"></p>
     	<p>密码:<input type="password" 
     		name="pwd"></p>
     	<h3><input type="submit" value="Login"></h3>
      </form>
    </div>

	<div>
      <c:url var="action6" 
      	value="/login/login-action6.form"></c:url>
      <form action="${action6}"	method="post">
		<h2>登录 6</h2>
		<h4>${message6}</h4>		      
		<h6>${alert}</h6>		      
      	<p>账号:<input type="text" name="name"
      		value="${name}"></p>
     	<p>密码:<input type="password" 
     		name="pwd"></p>
     	<h3><input type="submit" value="Login"></h3>
      </form>
    </div>
    
	<div>
      <c:url var="action7" 
      	value="/login/login-action7.form"></c:url>
      <form action="${action7}"	method="post">
		<h2>登录 7</h2>
		<h4>${message7}</h4>		      
      	<p>账号:<input type="text" name="name"
      		value="${name}"></p>
     	<p>密码:<input type="password" 
     		name="pwd"></p>
     	<h3><input type="submit" value="Login"></h3>
      </form>
    </div>
    
    <div>
      <c:url var="action8" 
      	value="/login/login-action8.form"></c:url>
      <form action="${action8}"	method="post">
		<h2>登录 8</h2>
		<h4>${message8}</h4>		      
      	<p>账号:<input type="text" name="name"
      		value="${name}"></p>
     	<p>密码:<input type="password" 
     		name="pwd"></p>
     	<h3><input type="submit" value="Login"></h3>
      </form>
    </div>
    
     <div>
      <c:url var="action9" 
      	value="/login2/login-action1.form"></c:url>
      <form action="${action9}"	method="post">
		<h2>登录 9</h2>
		<h4>${message}</h4>		      
      	<p>账号:<input type="text" name="name"
      		value=""></p>
     	<p>密码:<input type="password" 
     		name="pwd"></p>
     	<h3><input type="submit" value="Login"></h3>
      </form>
    </div>
    

  </body>
</html>



