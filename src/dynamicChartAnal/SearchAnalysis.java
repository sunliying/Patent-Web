package dynamicChartAnal;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONException;

import systemVo.RobotVo;

public class SearchAnalysis extends HttpServlet {

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
		HttpSession session = request.getSession(); 
		String service = request.getParameter("service");
		List<RobotVo> allResult = (ArrayList<RobotVo>)session.getAttribute("allResult");
		ChartDataProduce produceData = new ChartDataProduce();
		Statistics produceData3D = new Statistics();
		response.setCharacterEncoding("UTF-8"); 
		
		String jsonData = null;
		if(service.equals("date")){
			try {
				jsonData = produceData.dateData(allResult, "applicationDate");
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(service.equals("inventorCountry")){
			try {
				jsonData = produceData.pDSplit(allResult,"inventorCountry");
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(service.equals("usClassficationMain")){
			try {
				jsonData = produceData.pDNoSplit(allResult,"usClassficationMain");
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(service.equals("assigneeName")){
			try {
				jsonData = produceData.pDNoSplit(allResult,"assigneeName");
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(service.equals("lifeCycle")){
			try {
				jsonData = produceData3D.statisticsApplicationName(allResult);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(service.equals("name3D")){
			try {
				jsonData = produceData3D.Stat(allResult,"assigneeName");
				System.out.println(jsonData);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(service.equals("country3D")){
			try {
				jsonData = produceData3D.Stat(allResult,"inventorCountry");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(service.equals("subject3D")){
			try {
				jsonData = produceData3D.Stat(allResult,"internationalCclassification");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		response.getWriter().write(jsonData);      
        response.flushBuffer();
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
