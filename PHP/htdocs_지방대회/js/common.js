/* 회원가입 새로2!!! */
function $(id){
	return document.getElementById(id);	
}

/* ChangeBgColor */
function changeBgColor(id){
	if($(id).value === ''){
		$(id).style.backgroundColor = "#fffabc";
		return 1;
	}else{
		$(id).style.backgroundColor = "";
	}
}

/* check id */
function check(id){
	/* 필수 입력 사항에 들어 갈 것을 구분 */
	/* explode == split */
	// $url = explode("/");
	// $len = count($url); 
	var arr = id.split(",");
	var msg = "";
	
	for(i=0; i<arr.length; i++){
		/* 값이 있을때 "";을 띄어주고 없을때 changebgcolor 실행하고 title의 내용을 띄어준다alert창으로 */
		changeBgColor(arr[i]) ? msg += $(arr[i]).title+"을(를) 입력해주세요\n" : "";
	}
	/**/
	if(msg){
		alert(msg);
	}else{
		/* 버튼을 SUBMIT으로 바꿔줌 */
		$("frm1").submit();
	}	

}












































/* function $(id){
	return document.getElementById(id);
}

function changeBgColor(id){
	if($(id).value === ''){
		$(id).style.backgroundColor = "#fffabc";
		return 1;
	}else{
		$(id).style.backgroundColor = "";
	}
}





회원가입 관련
function getEle(id){
	return document.getElementById(id);
	
}

function getVal(id){
	return document.getElementById(id).value;
}


function changeBgColor(id){
	var ele = getEle(id);
	var val = getVal(id);

	if(getEle(id).value === ''){
		ele.style.backgroundcolor = "#fffccc";
		return 1
	}else{
			ele.style.backgroundColor = "#fff";
			return 0;
		}
}

function doSubmit(id){
	var arr = id.split(id);
	var msg = "";

	for(i=0; i<arr.length; i++){
		changeBgColor(arr[i]) ? msg+= "\""+$(arr[i]).title+"\"\n" : "";
	}
}

/* doSubmit 
function doSubmit(){
	var error =0;

	error += changeBgColor("id");
	error += changeBgColor("pw");
	error += changeBgColor("pw_chk");
	error += changeBgColor("name");
	error += changeBgColor("adress");
	error += changeBgColor("p_num2");
	error += changeBgColor("p_num3");
	error += changeBgColor("email");
	error += changeBgColor("email2");
	error += changeBgColor("capt");

	if(error > 1){
		aelrt("필수항목을 입력하여주세요");
		return false;
	}else{
		getEle("frm_chk").submit();
	}
}

		
*/