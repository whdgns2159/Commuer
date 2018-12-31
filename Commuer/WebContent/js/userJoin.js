	$(function(){
		/* $('#userInfo tr:odd').css('background','rgb(133, 114, 238)'); */
		$('#userInfo').css({
			'font-size':'12pt',
			'font-weight':'bold'
			
		});
		$('.btn-outline-primary').css('color','darkviolet');
		/* $('tr').firstchild().css('text-align','right'); */
	});


	var idCheck=function(){
		var url='idCheck.jsp';
		win = window.open(url, 'idCheck','width=400, height=400, left=100, top=100]');
	}
	
	var nicknameCheck=function(){
		var url='nicknameCheck.jsp';
		win = window.open(url, 'idCheck','width=400, height=400, left=100, top=100]');
	}
	