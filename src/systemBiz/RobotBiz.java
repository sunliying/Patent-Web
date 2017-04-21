package systemBiz;

import java.sql.Connection;

import commonClas.DBConnection;
import systemDao.RobotDao;
import systemVo.RobotVo;

public class  RobotBiz
{
	public void addRobot(RobotVo vo){
			DBConnection dbc=new DBConnection();
			if(dbc.getConnect()){
				Connection con =dbc.getConn();
				RobotDao dao = new RobotDao();
//					dao.createTable(con, vo);
					dao.insert(con,vo);
					try{
						con.close();
					}catch(Exception ex){
						ex.printStackTrace();
					}		
			}else{
				System.out.println("can not connect to mysql");
			}
		
		}
	
	public static void main(String[] args) {
		RobotBiz biz = new RobotBiz();
		RobotVo vo = new RobotVo();
		
		biz.addRobot(vo);
		System.out.println("OK!");
	}
}
