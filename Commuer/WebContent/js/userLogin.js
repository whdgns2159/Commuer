
	var loginCheck=function(){
		if(!loginF.id.value){
			alert('아이디를 입력하세요');
			loginF.id.focus();
			return;
		}
		if(!loginF.pwd.value){
			alert('비밀번호를 입력하세요');
			loginF.pwd.focus();
			return;
		}
		loginF.submit();
	}
	