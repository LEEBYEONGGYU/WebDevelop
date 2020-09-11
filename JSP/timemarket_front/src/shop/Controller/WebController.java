package shop.Controller;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.Action.Action;

/**
 * Servlet implementation class WebController
 */
@WebServlet(
      urlPatterns = { 
            "/WebController", 
            "*.do"
      }, 
      initParams = { 
            @WebInitParam(name = "propertyConfig", value = "commandMapping.properties")
      })
public class WebController extends HttpServlet {
   private static final long serialVersionUID = 1L;
   private HashMap<String, Object> commandMap = new HashMap<String, Object>();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WebController() {
        super();
        // TODO Auto-generated constructor stub
    }

   /**
    * @see Servlet#init(ServletConfig)
    */
   public void init(ServletConfig config) throws ServletException {
      String props = config.getInitParameter("propertyConfig");
      String realFolder = "/property"; 

      ServletContext context = config.getServletContext();

      String realPath = context.getRealPath(realFolder) +File.separator+props;
                  

      Properties pr = new Properties();
      FileInputStream f = null;
      try{
         f = new FileInputStream(realPath); 
         pr.load(f);
      }catch (IOException e) {
         e.printStackTrace();
      }finally {
         if (f != null) try { f.close(); } catch(IOException ex) {}
      }
      
      //57~67라인은 프로퍼리티 값을 파일인풋스트리으로 읽어옴
      
      Iterator<?> keyIter = pr.keySet().iterator();
      
      while( keyIter.hasNext() ) {
         String command = (String)keyIter.next();
         String className = pr.getProperty(command);
         try{
            Class<?> commandClass = Class.forName(className);
            Object commandInstance = commandClass.getDeclaredConstructor().newInstance();
            commandMap.put(command, commandInstance);

         }catch (ClassNotFoundException|NoSuchMethodException|InvocationTargetException e) {
            e.printStackTrace();
         }catch (InstantiationException|IllegalAccessException e) {
            e.printStackTrace();
         }
      }   
   }
   
   //command는 .do이고 className은 그에 해당하는 프로퍼리티 클래스이름

   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      requestProcess(request, response);
   }

   /**
    * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      requestProcess(request, response);
   }
   
   private void requestProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
      String view=null; //view는 보여줄 페이지
      Action com=null; //액션클래스 이름
      try {
         String command=request.getRequestURI(); //현재 요청받은 URI주소ㅡㄹ 가져옴
         System.out.println(command);
         if(command.indexOf(request.getContextPath())==0) { //주소의 길이
            command=command.substring(request.getContextPath().length()); //
         }
         com=(Action)commandMap.get(command);
         if(com==null) {view="/index.jsp";} //만약 액션클래스가 null이면 view는 /프로젝트명/index.jsp
         else {view=com.requestProcess(request, response);  System.out.println(view);} //아니면 뷰는 요청받은 액션클래스 command를 받아서 view에 넣음
      }catch(Throwable e) {
         throw new ServletException(e);
      }
      request.setAttribute("cont", view); //요청 뷰 설정
       RequestDispatcher dispatcher = 
           
          request.getRequestDispatcher(view); //Dispacher로 view를 포워드함
      dispatcher.forward(request, response);
     
   }

}