

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import = "java.util.*, com.google.gson.Gson, com.google.gson.JsonObject"%>

<style>
.res {
color:red;
}
</style>

<%
	request.setCharacterEncoding("utf-8");
	String userid = request.getParameter("userid");
	ArrayList<String> ids = new ArrayList<>();
	ids.add("a");

	String uid = "admin";
	
	
	String msg = "";
	String name = "";
	String phone = "";

	Gson gson = new Gson();
	JsonObject obj = new JsonObject();
	obj.addProperty("msg",msg);
	
	if(ids.contains(userid)){
		
	
		obj.addProperty("result","ok");
	obj.addProperty("uid",uid);
	obj.addProperty("name","BK");
	obj.addProperty("phone","010-4752-7613");
	obj.addProperty("email", "leebkgyu97@gmail.com");
	}else{
		
	
		obj.addProperty("result","ng");
	}
%>


