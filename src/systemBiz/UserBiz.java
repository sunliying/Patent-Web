package systemBiz;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import commonClas.DBConnection;
import systemDao.UserDao;
import systemVo.UserVo;


public class  UserBiz
{
	public void addUser(UserVo vo){
			DBConnection dbc=new DBConnection();
			if(dbc.getConnect()){
				Connection con =dbc.getConn();
					UserDao dao = new UserDao();
					dao.insert(con,vo);
					try{
						con.close();
					}catch(Exception ex){
						ex.printStackTrace();
					}		
			}else{
				System.out.println("sucssess!!");
			}
		
		}
	public UserVo searchUserByEmail(String email){
		DBConnection dbc=new DBConnection();
		UserVo user = new UserVo();
		if(dbc.getConnect()){
			Connection con =dbc.getConn();
			UserDao dao = new UserDao();
			user = dao.searchUserByEmail(con,email);
			try{
				con.close();
			}catch(Exception ex){
				ex.printStackTrace();
			}		
		}else{
			System.out.println("sucssess!!");
		}
		return user;
	}
	
}
