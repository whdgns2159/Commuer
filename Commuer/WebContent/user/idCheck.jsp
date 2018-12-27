<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="user.model.*"%>
    <%
    String myctx=request.getContextPath();
    String method=request.getMethod();
    //out.println("요청방식: "+method+"<br>");
    %>
    <!--부트 스트랩  -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="text/javascript"
	src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
<script type="text/javascript"
	src="http://netdna.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<link
	href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<link href="<%=myctx%>/css/style.css" rel="stylesheet" type="text/css">
<!-- ------------------------------------------------------------------------------------------------------ -->
<%
	if(method.equalsIgnoreCase("get")){
	//get방식 요청일 경우는 아이디 임력폼을 보여주고.	
	
%>
	<form name="idf" action="idCheck.jsp" method="POST"
	class="form-inline">
		<div class="col-md-4">
			<label for="userid" class="col-md-2 text-right">아이디 : </label>
			<input type="text" name="userid" placeholder="아이디를 입력하세요" class="form-control">
		</div>
		<div class="col-md-2">
			<button type="button" class="btn btn-info" onclick="send()">확인</button>
		</div>
	</form>
<%
	}else{
		
		//post방식일 경우는 아이디 중복여부 결과를 보여줌
		//out.println("아이디 사용 여부 결과를 보여줄 예정");
		String userid=request.getParameter("userid");
		if(userid==null||userid.trim().isEmpty()){
			%>
			<script>
				/* alert('아이디를 입력해야 해요'); */
				history.back();
			</script>
			<%
			return;
		}//if--------------------

		UserDAO userDao=new UserDAO();
		boolean isDup=userDao.isDuplicatedId(userid);
		
		//1. 아이디를 사용할 수 있는 경우
		if(!isDup){
		%>
		<div class="text-center">
			<h3>[<span class="text-danger"><%=userid %></span>]을 사용할 수 있습니다.</h3>
			<button onclick="setUid('<%=userid%>')" class="btn btn-primary">닫기</button>
		</div>
		<%
		}else{
		//2. 아이디를 사용할 수 없는 경우
		%>
		<div class="text-center">
			<h3>[<span class="text-danger"><%=userid %></span>]는 이미 사용중입니다.</h3>
			<form name="idf" action="idCheck.jsp" method="POST"
				class="form-inline">
				<div class="col-md-4">
					<label for="userid" class="col-md-2 text-right">아이디 : </label>
					<input type="text" name="userid" placeholder="아이디를 입력하세요" class="form-control">
				</div>
				<div class="col-md-2">
					<button type="button" class="btn btn-info" onclick="send()">확인</button>
				</div>
			</form>
		</div>
		<%
		}//else--------
	}//else-----------------
%>
		<script type="text/javascript">
		
			function setUid(uid){
				//uid값을 팝업창을 띄워준 부모창의 userid텍스트박스에 넣어주기
				//계층구조: window=> document=>form
				//부모창=>window=> opener
				opener.document.mf.userid.value=uid;
				
				//팝업창 닫기
				self.close();
			}
		//아무것도 입력하지 않았을때에는 서버를 거치지않고 바로 포커스를 준다.
			function send(){
				if(!idf.userid.value){
					alert('아이디를 입력하세요');
					idf.userid.focus();
					return;
				}
				idf.submit();
			}
		</script>











