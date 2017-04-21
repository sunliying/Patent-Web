package systemDao;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

import systemVo.RobotVo;

public class RobotDao {
	private static String indexFile = "F://search_engine//Robot.xls";
	public void insert(Connection con, RobotVo vo) {
		PreparedStatement ps = null; 
		Connection _conn  = null; 
		String[] namesArray = new String[]{"id","title","applicationDate","issuedDate","inventorCity","inventorState","inventorCountry","applicantCity","applicantState","applicantCountry","assigneeName","assigneeCity","assigneeState","assigneeCountry","referencePatentIssuedDate",
				"referencePatentId","referencePatentCountry","usClassficationMain","usClassificationFurther","cooperativePatentClassification","internationalClassification","abst"}; 
		try{
			  _conn = con;
	          InputStream is = new FileInputStream(indexFile);
	          jxl.Workbook rwb = Workbook.getWorkbook(is);
	          Sheet rs = rwb.getSheet(0);
	          int cloms = rs.getColumns();
	          Cell[] firstRow = rs.getRow(0);
	          for(int p = 0;p<firstRow.length;p++){
	        	  String content = firstRow[p].getContents();
	        	  System.out.println(content);
	          }
	          int rows = rs.getRows();
	          for(int i = 1; i < rows; i++){
	        	  try{
	        		  StringBuffer sb = new StringBuffer(); 
		        	  sb.append(" insert into robot (");
			  			for(int k=0;k<namesArray.length;k++){
			  				sb.append(namesArray[k]+",");
			  			}
			  			sb.deleteCharAt(sb.length()-1);
			  			sb.append(") values(");
			  			for(int k=0;k<namesArray.length;k++){
			  				sb.append("?,");
			  			}
			  			sb.deleteCharAt(sb.length()-1);
			  			sb.append(") ");
			  			ps = _conn.prepareStatement(sb.toString());
		              for(int j = 0; j < cloms; j++){
		                  Cell cell = rs.getCell(j, i);//第一位是列号，第二位是行号
		                  String content = cell.getContents();
		                  ps.setString(j+1, content);
		              }
		              ps.executeUpdate();
	        	  }catch(SQLException e){
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
	          rwb.close();
	      }
	      catch(Exception e){
	          e.printStackTrace();
	      }
	}
	public void createTable(Connection con, RobotVo vo){
		try {
			Connection _conn  = null; 
			//使用ArrayList
			_conn = con;
			String sql = "create table robot(id varchar(10) not null primary key,title varchar(200),applicationDate varchar(10),issuedDate varchar(10),inventorCity varchar(100),inventorState varchar(100),inventorCountry varchar(100),applicantCity varchar(100),applicantState varchar(100),applicantCountry varchar(100),assigneeName varchar(100),assigneeCity varchar(100),assigneeState varchar(100),assigneeCountry varchar(100),referencePatentIssuedDate varchar(300),referencePatentId varchar(300),referencePatentCountry varchar(300),usClassficationMain varchar(100),usClassificationFurther varchar(100),cooperativePatentClassification varchar(100),internationalClassification varchar(100),abst varchar(3000))";
			PreparedStatement stmt = _conn.prepareStatement(sql);
			stmt.execute();
		}catch (SQLException e) {
			
		}finally{
			
		}
	}

}
