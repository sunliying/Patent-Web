package search;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import systemBiz.UserBiz;
import systemVo.RobotVo;
import systemVo.UserVo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;


public class ParentsSearcherServlet extends HttpServlet {
	
	private static String result ;

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		 this.doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String service = request.getParameter("service");
		HttpSession session = request.getSession(); 
		if(service.equals("login")){
			String loginEmail = request.getParameter("emails");
		    String loginPw = request.getParameter("password");
		    
		    if(session.getAttribute("user")!=null){
		    	request.getRequestDispatcher("/index.jsp").forward(request, response);
		    	return;
		    }
	    	UserBiz biz = new UserBiz();
			UserVo vo = new UserVo();

			vo = biz.searchUserByEmail(loginEmail);
			ServletContext context = getServletContext();
			if(vo==null){
				request.setAttribute("message", "该账户尚未注册，请先注册！");
				RequestDispatcher dispatcher = context.getRequestDispatcher("/login.jsp");
				dispatcher.forward(request, response);
			}else if(!vo.getPassword().equals(loginPw)){
				request.setAttribute("message", "密码输入错误，请重新输入！");
				RequestDispatcher dispatcher = context.getRequestDispatcher("/login.jsp");
				dispatcher.forward(request, response);
			}else{
				session.setAttribute("user", vo); 
				request.getRequestDispatcher("/index.jsp").forward(request, response);
			}
		}
		if(service.equals("register")){
			String name = request.getParameter("name");
	   		String email = request.getParameter("email");
	   		String password = request.getParameter("password");
	   		String gender = request.getParameter("gender");
	   		
	   		if(session.getAttribute("user")!=null){
		    	request.getRequestDispatcher("/index.jsp").forward(request, response);
		    	return;
		    }
	   		try{
		   		UserBiz biz = new UserBiz();
				UserVo vo = new UserVo();
				vo = biz.searchUserByEmail(email);
				ServletContext context = getServletContext();
				UserVo user = new UserVo();
				if(vo==null){
					user.setName(name);
					user.setGender(gender);
					user.setEmail(email);
					user.setPassword(password);
					biz.addUser(user);
			  		session.setAttribute("user", user); 
					RequestDispatcher dispatcher = context.getRequestDispatcher("/index.jsp");
					dispatcher.forward(request, response);
				}else if(vo!=null){
					request.setAttribute("message", "用户已注册，请直接登录！");
					RequestDispatcher dispatcher = context.getRequestDispatcher("/login.jsp");
					dispatcher.forward(request, response);
				}
				
	   		}catch(Exception e){
	   			request.setAttribute("error", e);
	   		    response.sendRedirect("/error.jsp");
	   		}
		}
		if(service.equals("search")){
			String keywords = request.getParameter("keywords");
			
			List<RobotVo> robotAll = new ArrayList<RobotVo>();
			List<RobotVo> pageRobot = new ArrayList<RobotVo>();

			if(keywords==null){
				request.setAttribute("Result", null);
			}else if(request.getParameter("pageIndex")==null){
				PatentsSearcher PS= new PatentsSearcher(keywords);
				robotAll = PS.searcher();	
				session.setAttribute("totalNumOfPat", PS.getTotalNumOfPat());
				session.setAttribute("inTheFiled",PS.getInTheFiled());
				session.setAttribute("keywords",keywords);
				session.setAttribute("pageResult",robotAll.subList(0, 20));
				session.setAttribute("allResult",robotAll);
			}else{
				// 一页显示的条数
				int pageSize = 20;
				// 待显示页码
				int pageIndex;
				
				String strPage;
				strPage  = request.getParameter("pageIndex");
				if(strPage == null){
					pageIndex = 1;
				}else{
					pageIndex = Integer.parseInt(strPage.trim());
					if(pageIndex<1){
						pageIndex = 1;
					}
				}
				int totalIndex = Integer.parseInt(session.getAttribute("totalNumOfPat").toString());
				int start = (pageIndex-1)*pageSize;
				int end = pageIndex*pageSize<totalIndex?pageIndex*pageSize:totalIndex;
				robotAll = (List<RobotVo>)session.getAttribute("allResult");
				pageRobot = robotAll.subList(start, end);
				session.setAttribute("pageResult",pageRobot);
				request.setAttribute("pageIndex", pageIndex);
			}
			ServletContext context = getServletContext();
			RequestDispatcher dispatcher = context.getRequestDispatcher("/searchResult.jsp");
			dispatcher.forward(request, response);
		}
		
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}


}
