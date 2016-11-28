<%@ page pageEncoding="utf-8"
	contentType="text/html;charset=utf-8"%>
<%@taglib  prefix="c" 
	uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE HTML>
<html>
  <head>
  	<title>上载文件</title>
  </head>
  <body>
    <h2>上载文件到网站</h2>
    <h3>${ message }</h3>
    <c:url var="path" value="/file/upload.form"/>
	<form action="${path}" method="post"
		enctype="multipart/form-data">
		<p>上载图片
		  <input type="file" name="image"></p>
		<p>拍摄地点:<input type="text" 
			name="location"></p>
		<h4><input type="submit" value="上载"></h4>
	</form>    
	
  </body>
</html>


