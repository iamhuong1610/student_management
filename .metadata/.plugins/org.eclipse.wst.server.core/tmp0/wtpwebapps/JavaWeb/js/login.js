//Xử lý đăng nhập
//const login => (fn){}

function login(fn){
	let name = fn.txtName.value;
	let pass = fn.txtPass.value;
	
	if((name != null) && (pass != null)){
			fn.method = "post";
			fn.action = "/JavaWeb/user/login";
			fn.submit();
	}else{
		//Không làm gì
		return false;
	}
	
}