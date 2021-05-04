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
		    var params = "userId=" + $("#userId").val() + "&userPwd=" + $("#userPwd").val();
		    alert(params);
		    
		    $.ajax({
				type : "get",
				url  : "ajax_ok.jsp",
				data : params,
				dataType : "json", //받는 type은 json방식
				success : function(args) { // 결과값이 json방식으로 args로 들어온 상태 [{"userId":"test", "userPwd":"1234"}]
				    console.log(args);
				    var str = "userId=" + args.userId + ",userPwd=" + args.userPwd + "<br/>";
				    $("#resultDIV").html(str);
				},
				error : function(e) {
				    alert(e.responseText);
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