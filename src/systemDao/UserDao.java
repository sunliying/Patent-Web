package systemDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import systemVo.UserVo;


public class UserDao{
	public void insert(Connection con, UserVo vo) {
		StringBuffer sb = new StringBuffer(); 
		PreparedStatement ps = null; 
		Connection _conn  = null; 
		try {
			_conn = con;
			sb.append(" insert into user (email,name,gender,password) ");
			sb.append(" values(?,?,?,?) ");
			ps = _conn.prepareStatement(sb.toString());
			int nIndex = 1;
			ps.setString(nIndex++, vo.getEmail());
			ps.setString(nIndex++, vo.getName());
			ps.setString(nIndex++, vo.getGender());
			ps.setString(nIndex++, vo.getPassword());
			ps.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				if(ps!=null){
					ps.close();ps= null;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public UserVo searchUserByEmail(Connection con,String email){
		UserVo user = null;
		PreparedStatement ps = null; 
		Connection _conn  = null; 
		try {
			_conn = con;
			ps = _conn.prepareStatement("Select * from user " +
					" where email = ?");
			ps.setString(1, email);
			ResultSet result = ps.executeQuery();			
			if (result.next()) {
				user = new UserVo();
				user.setName(result.getString("name"));
				user.setEmail(result.getString("email"));
				user.setGender(result.getString("gender"));
				user.setPassword(result.getString("password"));
			}
			_conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return user;		
	}
	
}