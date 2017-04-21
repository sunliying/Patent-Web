package dataVisualization;

import java.io.FileInputStream;
import java.io.InputStream;

import jxl.Sheet;
import jxl.Workbook;

public class ReadFromExcel{
	
	
	private static final int COUNT_CITY_ARRAY = 4;
	private static final int COUNT_COUNTRY_ARRAY = 4;
	private static final int COUNT_STATE_ARRAY = 4;
	private static final int COUNT_NAME_ARRAY = 2;
	private static final int INTERNATION_CLASSFICATION_ARRAY = 3;
	static String[] searchDateCol ={"issued date","application date"};
	static String[] searchCityCol ={"inventor city","applicant city","assignee city"};
	static String[] searchStateCol={"inventor state","applicant state","assignee state"};
	static String[] searchCountryCol = {"inventor country","applicant country","assignee country"};
	static String[] searchAssignNameCol = {"assignee name"};
	static String[] searchInClassCol = {"cooperative patent classification","international classification"};
	static String[] CitedLiterature = {"reference patent issued date"};
	static String searchUSClassCol= "us classfication main";
	
//	静态方法调用不用实例化
//	ProduceData regionData = new ProduceData();
	
	public static void main(String[] args){
		String indexFile = "F://search_engine//Robot.xls";
		String ServePath = "F://java-project//.metadata//.me_tcat//webapps//test//jsondata//";
		String storePath = "H://echart//jsondata//";
		PlotMethod plotMethod = new PlotMethod(storePath);
		
		
		try{
	        InputStream is = new FileInputStream(indexFile);
	        jxl.Workbook rwb = Workbook.getWorkbook(is);
	        Sheet rs = rwb.getSheet(0);       
//	        plotMethod.calculateAccordDate(rs,searchDateCol);
//	        plotMethod.calculateAccordCity(rs, searchCityCol, COUNT_CITY_ARRAY );
	        plotMethod.calculateAccordCity(rs, searchCountryCol, COUNT_COUNTRY_ARRAY );
//	        plotMethod.calculateAccordCity(rs, searchStateCol, COUNT_STATE_ARRAY );
//	        plotMethod.calculateAccordCity(rs, searchAssignNameCol, COUNT_NAME_ARRAY );
//	        plotMethod.calculateAccordCity(rs, searchInClassCol, INTERNATION_CLASSFICATION_ARRAY );
//	        plotMethod.calculateAccordDateRegion(rs,searchDateCol,"inventor country",ProduceData.getCountry());
//	        plotMethod.calculateAccordDateRegion(rs,searchDateCol,"assignee name", ProduceData.getName());
	        
//	        plotMethod.classficIntersept(rs, searchUSClassCol );
	        plotMethod.calculateAccordDateRegion(rs,searchDateCol,"assignee country",ProduceData.getCountry());
	        plotMethod.calculateAccordDateRegion(rs,searchDateCol,"us classfication main",ProduceData.getClassfy());
	        rwb.close();
	        System.out.println("successful!!");
	    }
		
	    catch(Exception e){
	        e.printStackTrace();
	    }
		
	}
}