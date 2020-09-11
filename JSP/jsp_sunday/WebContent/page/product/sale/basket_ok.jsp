<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ include file="/include/db.jsp" %>
    <% 
    
    request.setCharacterEncoding("utf-8");
    
    String procode = request.getParameter("pcode");
    String pilsu = request.getParameter("pil");
    String oplens = request.getParameter("opt1");
	String opsdcard = request.getParameter("opt2");
	String samgak = request.getParameter("opt3");
	
	try {
		stmt = con.createStatement();
		String jannum = "c1234";
		String uid = "userid";
		int price = 2323232;
		int su = 10;
		int opsu = 20;
		String sql2="";
		int oppri = 20000;
		
		
		sql = "insert into 장바구니 (장바구니번호, 사용자아이디, 상품명, 가격, 수량) values"+
				"('"+jannum+
						"','"+uid+
						"','"+pilsu+
						"','"+price+
						"','"+su+
						"')";
		System.out.println(sql);
		
		
			if(pilsu.equals("")){
				if(oplens.equals("")){
					if(opsdcard.equals("")){
						if(samgak.equals("")){
							
						}else{
							sql2 = "insert into 장바구니내역 (장바구니번호, 옵션상품명, 옵션수량, 옵션가격) values"+
									"('"+jannum+
											"','"+samgak+
											"','"+pilsu+
											"','"+su+
											"','"+oppri+
											"')"; System.out.println(sql2);
						}
					}else{
						sql2 = "insert into 장바구니내역 (장바구니번호, 옵션상품명, 옵션수량, 옵션가격) values"+
								"('"+jannum+
										"','"+opsdcard+
										"','"+pilsu+
										"','"+su+
										"','"+oppri+
										"')"; System.out.println(sql2);
					}
				}else{
					sql2 = "insert into 장바구니내역 (장바구니번호, 옵션상품명, 옵션수량, 옵션가격) values"+
							"('"+jannum+
									"','"+oplens+
									"','"+pilsu+
									"','"+su+
									"','"+oppri+
									"')"; System.out.println(sql2);
				}
			}else{
				sql2 = "insert into 장바구니내역 (장바구니번호, 옵션상품명, 옵션수량, 옵션가격) values"+
						"('"+jannum+
								"','"+samgak+
								"','"+pilsu+
								"','"+su+
								"','"+oppri+
								"')"; System.out.println(sql2);
			}
		
				stmt.executeUpdate(sql);
				stmt.executeUpdate(sql2);
				stmt.close();
				con.close();
	}catch(Exception e){
		e.printStackTrace();
	}
	
	
    %>