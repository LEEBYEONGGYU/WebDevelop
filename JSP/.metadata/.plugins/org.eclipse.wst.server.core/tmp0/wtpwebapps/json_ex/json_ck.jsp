<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.google.gson.*"%>
    
    <%
    request.setCharacterEncoding("UTF-8"); //인코딩 설정
    String idck = request.getParameter("idck"); //ajax data의 idck를 받아옴
    
    JsonObject JsonObject = new JsonObject(); //Json오브젝트 객체 생성
	JsonObject.addProperty("proid",idck); 
    //JSON오브젝트 객체에 키값 proid와 값 idck를 넣음 그러면 {proid:idck} 형식으의 데이터 생성됨 

    out.println(JsonObject.toString());
	//JsonArray jArray = new JsonArray(); //Json배열객체를 만들어서
	//jArray.add(JsonObject); //해당 객체에 Jsonobject를 넣는다.
	//out.print(jArray.toString()); //out.print로 JArray를 String형태로 출력 이 출력은 다시 ajax로 결과가 반환된다
%>