<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>Document</title>
		<script src="${path.js}/jquery-3.3.1.min.js"></script>	
		<script src="${path.js}/bootstrap.js"></script>
	<style>
		#tab-login-title{
			/* border: 1px solid gray;  */
			margin: 0 auto;
			margin-top: 80px;
		}
		#tab-login {
			border: 1px solid gray; 
			margin: 0 auto;
			margin-top: 80px;
		}
		#tab-login tr{
			/* border: 1px solid gray;  */
		}
		#tab-login tr td{
			/* border: 1px solid gray;  */
		}
		#btn-login{
			height: 56px;
		}
		
	</style>
</head>
<body>
  <form id="form-login">
  
    <table id="tab-login-title">
    	<tr>
    		<td>로그인</td>
    	</tr>
    </table> 
	<table id="tab-login">
		<tr>
			<td>
				<input id="inp-login-userid" name="inp-login-userid" type="text" value="jyw"/>
			</td>
			<td rowspan="2">
				<button id="btn-login">로그인</button>
			</td>
		</tr>
		<tr>
			<td>
				<input id="inp-login-password" name="inp-login-password" type="text" value="5454"/>
			</td>
		</tr>
		<tr>
			<td>
				<a id="a-login-add" href="#">회원가입</a>
			</td>
		</tr>
	</table>
	
  </form>	
</body>
	<script>
		$('#btn-login').on('click',function(){
			alert("로그인 클릭");
			$('#form-login')
			.attr('action', '${path.context}/login/check')
		    .attr('method', 'post')
		    .submit();
		});
		$('#a-login-add').on('click',function(){
			alert("회원가입 클릭");
			location.href="${path.context}/join"
		})
	</script>
</html>