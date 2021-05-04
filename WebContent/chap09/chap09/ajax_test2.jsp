<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSON형식으로 데이터 주고 받기</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
    $(function() {
	$("#sendButton").click(
		function() {
		    var params = { "userId":$("#userId").val(), "userPwd":$("#userPwd").val() };
		    $.ajax({
				type : "get",
				url : "ajax_ok2.jsp",
				data : $.param(params), //userId=aaaa&userPwd=12334
				dataType : "json", //받는 type은 json방식
				success : function(args) { // 결과값이 json방식으로 args로 들어온 상태
				    console.log(args);
				    var str = "userId=" + args.userId + ",userPwd=" + args.userPwd + "<br/>";
				    $("#resultDIV").html(str);
				},
				error:function(request, status, error){
					alert(
						  "code   : "+request.status+"\n"
						+ "message: "+request.responseText+"\n"
						+ "error  : "+error
					);
				}
		    });
		});
    });
</script>
</head>
<body>
	아이디:<input type="text" id="userId" />
	<br />
	패스워드:	<input type="text" id="userPwd" />
	<br />
	<button id="sendButton">전송</button>
	<br />
	<br />
	<div id="resultDIV"></div>
</body>
</html>