package ch12.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BoardDBBean {
	
	private static BoardDBBean instance = new BoardDBBean();
	
    //.jsp?��?���??��?�� DB?��?��빈인 BoardDBBean?��?��?��?�� 메소?��?�� ?��근시 ?��?��
    public static BoardDBBean getInstance() {
        return instance;
    }
    
    private BoardDBBean(){}
    
    //커넥?��??로�??�� Connection객체�? ?��?��?�� : DB?��?��빈의 쿼리문을 ?��?��?��?�� 메소?��?��?�� ?��?��
    private Connection getConnection() throws Exception {
      Context initCtx = new InitialContext();
      Context envCtx = (Context) initCtx.lookup("java:comp/env");
      DataSource ds = (DataSource)envCtx.lookup("jdbc/jsptest");
      return ds.getConnection();
    }
    
    //board?��?��블에 �??�� 추�?(inset�?)<=writePro.jsp?��?�� ?��?��
    @SuppressWarnings("resource")
	public int insertArticle(BoardDataBean article){
        Connection conn = null;
        PreparedStatement pstmt = null;
		ResultSet rs = null;
		int x = 0;
		int number=0;//board?��?��블에 ?��?���? �?번호
        String sql="";
        
        //43~46?��?��?? ?���??�� �?�? ?���?
		int num=article.getNum();//?��목�??�� �?번호
		int ref=article.getRef();//?��목�??�� 그룹?�� ?��?��?��
		int re_step=article.getRe_step();//그룹?��?�� �??��?��?��
		int re_level=article.getRe_level();//�??��목의 ?��?��?���?

        try {
            conn = getConnection();
            //51~57?��?��?? ?��?�� board?��?��블에 ?��코드?�� ?���? ?��?���? �?번호 결정
            pstmt = conn.prepareStatement("select max(num) from board");
			rs = pstmt.executeQuery();
			
			if (rs.next())//기존?�� ?��코드�? 존재
		      number=rs.getInt(1)+1;//?��?���? 번호?�� �??��?�� �?번호+1
		    else//첫번�? �?
		      number=1;
			
		   //60~72?��?��?? ?��목�?�? ?���?간의 ?��?���? 결정
		    if (num!=0){//?���? - ?��목�??�� �?번호 �?�?
		      sql="update board set re_step=re_step+1 where ref= ? and re_step> ?";
              pstmt = conn.prepareStatement(sql);
              pstmt.setInt(1, ref);
			  pstmt.setInt(2, re_step);
			  pstmt.executeUpdate();
			  re_step=re_step+1;
			  re_level=re_level+1;
		    }else{//?��목�? - �?번호 ?��?��
		  	  ref=number;
			  re_step=0;
			  re_level=0;
		    }	 
            // 쿼리�? ?��?�� :board?��?��블에 ?��로운 ?��코드 추�?
            sql = "insert into board(writer,subject,content,passwd,reg_date,ip,ref,re_step,re_level) values(?,?,?,?,?,?,?,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, article.getWriter());
            pstmt.setString(2, article.getSubject());
            pstmt.setString(3, article.getContent());
            pstmt.setString(4, article.getPasswd());
			pstmt.setTimestamp(5, article.getReg_date());
			pstmt.setString(6, article.getIp());
            pstmt.setInt(7, ref);
            pstmt.setInt(8, re_step);
            pstmt.setInt(9, re_level);
            pstmt.executeUpdate();
            x = 1; //?��코드 추�? ?���?
        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
			if (rs != null) try{ rs.close(); }catch(SQLException ex) {}
            if (pstmt != null) try{ pstmt.close(); }catch(SQLException ex) {}
            if (conn != null) try{ conn.close(); }catch(SQLException ex) {}
        }
        return x;
    }
    
    //board?��?��블에 ???��?�� ?��체�??�� ?���? ?��?��?��<=list.jsp?��?�� ?��?��
	public int getArticleCount(){
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int x=0;

        try {
            conn = getConnection();
            
            pstmt = conn.prepareStatement("select count(*) from board");
            rs = pstmt.executeQuery();

            if (rs.next()) 
               x= rs.getInt(1);
        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
            if (rs != null) try{ rs.close(); }catch(SQLException ex) {}
            if (pstmt != null) try{ pstmt.close(); }catch(SQLException ex) {}
            if (conn != null) try{ conn.close(); }catch(SQLException ex) {}
        }
		return x;
    }
	
    //�??�� 목록?�� �??��?�� <=list.jsp
	public List<BoardDataBean> getArticles(int start, int end){
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<BoardDataBean> articleList=null;//�?목록?�� ???��?��?�� 객체
        try {
            conn = getConnection();
            
            pstmt = conn.prepareStatement(
            	"select * from board order by ref desc, re_step asc limit ?,? ");
            pstmt.setInt(1, start-1);
			pstmt.setInt(2, end);
            rs = pstmt.executeQuery();

            if (rs.next()) {//ResultSet?�� ?��코드�? �?�?
                articleList = new ArrayList<BoardDataBean>(end);
                do{
                  BoardDataBean article= new BoardDataBean();
				  article.setNum(rs.getInt("num")); 
				  article.setWriter(rs.getString("writer"));
                  article.setSubject(rs.getString("subject"));
                  article.setContent(rs.getString("content"));
                  article.setPasswd(rs.getString("passwd"));
			      article.setReg_date(rs.getTimestamp("reg_date"));
				  article.setReadcount(rs.getInt("readcount"));
                  article.setRef(rs.getInt("ref"));
                  article.setRe_step(rs.getInt("re_step"));
				  article.setRe_level(rs.getInt("re_level"));
                  article.setContent(rs.getString("content"));
			      article.setIp(rs.getString("ip")); 
				  //List객체?�� ?��?��?��???��빈인 BoardDataBean객체�? ???��
                  articleList.add(article);
			    }while(rs.next());
			}
        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
            if (rs != null) try { rs.close(); } catch(SQLException ex) {}
            if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
            if (conn != null) try { conn.close(); } catch(SQLException ex) {}
        }
		return articleList;//List객체?�� ?��?��?��?���? 리턴
    }
	
    //�? ?��?��?��?��?�� ?��?��?�� �??�� ?��?��(1개의 �?)<=updateForm.jsp?��?�� ?��?��
    public BoardDataBean updateGetArticle(int num){
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        BoardDataBean article=null;
        try {
            conn = getConnection();

            pstmt = conn.prepareStatement(
            	"select * from board where num = ?");
            pstmt.setInt(1, num);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                article = new BoardDataBean();
                article.setNum(rs.getInt("num"));
				article.setWriter(rs.getString("writer"));
                article.setSubject(rs.getString("subject"));
                article.setPasswd(rs.getString("passwd"));
			    article.setReg_date(rs.getTimestamp("reg_date"));
				article.setReadcount(rs.getInt("readcount"));
                article.setRef(rs.getInt("ref"));
                article.setRe_step(rs.getInt("re_step"));
				article.setRe_level(rs.getInt("re_level"));
                article.setContent(rs.getString("content"));
			    article.setIp(rs.getString("ip"));     
			}
        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
            if (rs != null) try{rs.close();}catch(SQLException ex){}
            if (pstmt != null) try{pstmt.close();}catch(SQLException ex){}
            if (conn != null) try{conn.close();}catch(SQLException ex){}
        }
		return article;
    }
    
    //�? ?��?��처리?��?�� ?��?��<=updatePro.jsp?��?�� ?��?��
    @SuppressWarnings("resource")
	public int updateArticle(BoardDataBean article){
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs= null;
		int x=-1;
        try {
            conn = getConnection();
            
			pstmt = conn.prepareStatement(
            	"select passwd from board where num = ?");
            pstmt.setInt(1, article.getNum());
            rs = pstmt.executeQuery();
            
			if(rs.next()){
			  String dbpasswd= rs.getString("passwd"); 
			  if(dbpasswd.equals(article.getPasswd())){
                String sql="update board set subject=?, ";
                sql += "content=? where num=?";
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, article.getSubject());
                pstmt.setString(2, article.getContent());
			    pstmt.setInt(3, article.getNum());
                pstmt.executeUpdate();
				x= 1;
			  }else
				x= 0;
			}
        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
			if (rs != null) try{ rs.close(); }catch(SQLException ex) {}
            if (pstmt != null) try{ pstmt.close(); }catch(SQLException ex) {}
            if (conn != null) try{ conn.close(); }catch(SQLException ex) {}
        }
		return x;
    }
    
    //�??��?��처리?�� ?��?��(delete�?)<=deletePro.jsp?��?�� ?��?��
    @SuppressWarnings("resource")
	public int deleteArticle(int num, String passwd){
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs= null;
        int x=-1;
        try {
			conn = getConnection();

            pstmt = conn.prepareStatement(
            	"select passwd from board where num = ?");
            pstmt.setInt(1, num);
            rs = pstmt.executeQuery();
            
			if(rs.next()){
				String dbpasswd= rs.getString("passwd"); 
				if(dbpasswd.equals(passwd)){
					pstmt = conn.prepareStatement(
            	      "delete from board where num=?");
                    pstmt.setInt(1, num);
                    pstmt.executeUpdate();
					x= 1; //�??��?�� ?���?
				}else
					x= 0; //비�?번호 ??�?
			}
        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
            if (rs != null) try{ rs.close(); }catch(SQLException ex) {}
            if (pstmt != null) try{ pstmt.close(); }catch(SQLException ex) {}
            if (conn != null) try{ conn.close(); }catch(SQLException ex) {}
        }
		return x;
    }
}