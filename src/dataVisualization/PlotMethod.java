package dataVisualization;

//plot operations
import java.io.*;
import jxl.*;
import java.lang.Boolean;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.json.JSONException;
import org.json.JSONObject;
import commonClas.WriteToJson;

public class PlotMethod{
	private static final int START_YEAR = 1972;
	private static final int END_YEAR = 2016;
	private static final int CROSS_YEAR = 45;
	private static final int SATTISTIC_LENGTH = 15020;
	private static String storePath;
	private static int namesCol = 0;
	// 以下四行主要分析的是 受让人的信息
	//并且当进行多维分析时，用到的 country若为空，就分析相应的state，若不为空，则设为美国。
	private static String[] allCountry;
	private static String[] allCity;
	private static String[] allState;
	private static String[] allAssigneeName;
	//没有对被引文献进行分析
	// 只对前三个字符进行分类
	private static String[] USClassification;
	//对international classification 进行统计的时候，根据 ~ 划分并且加起来。
	private static String[] internationalCassification;
	
	//注意以上几点，除了时间，其余都用Map进行统计。

	WriteToJson jsondata = new WriteToJson();
	public PlotMethod(String storePath){
		this.storePath = storePath;
	}
	/**
	 * 获取excel中的某一列数据，返回列数据
	 * @param rs
	 * @param names
	 * @param searchCol
	 * @return
	 */
	public Cell[] getColumn(Sheet rs ,Cell[] names, String searchCol){
		int index = 0;
		for(int i = 0;i<names.length;i++){
        	if(names[i].getContents().toString().equalsIgnoreCase(searchCol) ){
        		index = i;
        		break;
        	}
        }
        Cell[] searchedCol = rs.getColumn(index);
        return searchedCol;
	}
	public int returnColIndex(Cell[] names, String searchCol){
		int index = 0;
		for(int i = 0;i<names.length;i++){
        	if(names[i].getContents().toString().equalsIgnoreCase(searchCol) ){
        		index = i;
        		break;
        	}
        }
        return index;
	}
	/***
	 * java map 根据值来进行排序
	 */
	public static Map sortMap(Map oldMap) {  
        ArrayList<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(oldMap.entrySet());  
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {  
  
            public int compare(Entry<java.lang.String, Integer> arg0,  
                    Entry<java.lang.String, Integer> arg1) {  
                return  arg1.getValue()-arg0.getValue();  
            }
        });  
        Map newMap = new LinkedHashMap();  
        for (int i = 0; i < list.size(); i++) {  
            newMap.put(list.get(i).getKey(), list.get(i).getValue());  
        }  
        return newMap;  
    }  
	/***
	 * plot according to the Date ; All the papers
	 * issure date 和 applicant date 的总量，分别保存
	 * @throws JSONException 
	 */
	public void calculateAccordDate(Sheet rs,String[] searchDateCol) throws JSONException{
    	//数组的长度不能是一个变量；所以设置的时候使用尽量大一点的数，不会溢出；
    	int[] yearCount = new int[CROSS_YEAR]; //已经自动初始化为0
    	int[] years = new int[CROSS_YEAR]; 
    	Cell[] names = null;
    	int[] _allYears = new int[SATTISTIC_LENGTH];
    	JSONObject countAccordDate = new JSONObject();
    	// 获取年份的最大值和最小值
    	names = rs.getRow(namesCol);	 
    	for(int k=0;k<searchDateCol.length;k++){
    		Cell[] Alldate = getColumn( rs , names,searchDateCol[k]);
    		for(int i = 1; i<Alldate.length;i++){
            	String appdate = Alldate[i].getContents();
            	 _allYears[i-1] = Integer.parseInt(appdate.substring(0,4));
            } 
            Arrays.sort(_allYears);
            
          //获取年份
        	for(int i = START_YEAR; i<=END_YEAR;i++){
        		years[i-START_YEAR] = i;
        	}
        	//统计每年的论文数量
        	for(int i = 0;i<_allYears.length;i++){
        		//System.out.println(_allYears[i]+"\n"+(START_YEAR)+"\n"+(_allYears[i]-(START_YEAR)));
        		yearCount[_allYears[i]-(START_YEAR)]++;
        	}
        	countAccordDate.put("years",years );
        	countAccordDate.put("yearCount",yearCount );
        	
            jsondata.appendString(storePath+searchDateCol[k].replaceAll(" ", "_")+".json",countAccordDate.toString(),false);
    	}
	}

	/***
	 * 分类名-数量  截取前三个字符
	 * 主要对us classfication main 进行统计
	 * @throws JSONException 
	 */
	public void classficIntersept(Sheet rs,String searchDateCol) throws JSONException{
		Cell[] names = null;
    	names = rs.getRow(namesCol);	
    	Map<String,Integer> nameCount = new HashMap<String,Integer>(); 
    	JSONObject countJson = new JSONObject();
    	Cell[] perCell = getColumn( rs , names,searchDateCol);
        for(int k = 1; k<perCell.length;k++){
        	//在此截取三个字符
        	String _perClass = perCell[k].getContents();
        	if(_perClass.trim()==null||_perClass.trim().equals("")){
        		continue;
        	}    
        	_perClass = _perClass.substring(0,3);
    		if(nameCount.containsKey(_perClass)){
    			nameCount.put(_perClass,nameCount.get(_perClass)+1);
        	}else{
        		nameCount.put(_perClass,0);
        	}
        } 
        nameCount = sortMap(nameCount);
        LinkedList<String> name = new LinkedList<String>();
        LinkedList<Integer> count = new LinkedList<Integer>();
        for (Map.Entry<String,Integer> entry : nameCount.entrySet()){
        	name.add(entry.getKey());
        	count.add(entry.getValue());
        }
        countJson.put("name", name);
        countJson.put("count", count);
        jsondata.appendString(storePath+searchDateCol.replaceAll(" ", "_")+
    			".json",countJson.toString(),false);
   	}

	/***
	 * 输入第二个参数是需要查询的多列组成的数组，第三个数据是数组的长度
	 * 功能： 主要对每一列的相同元素出现的个数进行频率统计，可以对字符型的每一列进行统计
	 * 结果： 生成所有对应行的数据统计结果，文件名对应于列名称，空格改为下划线
	 * 		单独的关于传入数组的统计生成键值对为{ 字符串： 数组} 类型的对象
	 * 注意： 进行分词，
	 * 		最外层对所给数组进行了相同横坐标的统计，所以要保证所给的数组是在同一个域中；
	 * 		不对生成的数量进行限制
	 * @throws JSONException 
	 */
	public void calculateAccordCity(Sheet rs,String[] searchColArray,final int num ) throws JSONException{
    	Cell[] names = null;
    	JSONObject countJson = new JSONObject();
    	Map<String,int[]> AllCityMap = new HashMap<String,int[]>(); 
    	names = rs.getRow(namesCol);	
    	for(int i = 0;i<searchColArray.length;i++){
    		Map<String,Integer> nameCount = new HashMap<String,Integer>(); 
    		JSONObject percountJson = new JSONObject();
    		JSONObject keyValueObject = new JSONObject();
    		Cell[] perCity = getColumn( rs , names,searchColArray[i]);
	        for(int k = 1; k<perCity.length;k++){
	        	String _perinventorCity = perCity[k].getContents();
	        	
	        	// 为空且不是country的列时直接返回
	        	//字符串比较用equals 不能用等号
	        	if(_perinventorCity.trim().equals("")&&searchColArray[i].indexOf("country")==-1){
	        		continue;
	        	}
	        	if(_perinventorCity.trim().equals("")){
	        		if(searchColArray[i].indexOf("country")!=-1){
	        		//  Cell getCell(int column, int row);
	        			int ColIndex = returnColIndex(names,searchColArray[i]);
	        			if(rs.getCell(ColIndex-1, k).getContents().trim().equals("")){
	        				continue;
	        			}
	        		}
	        	}
	        	String[] cities = _perinventorCity.split("[~,]");
	        	for(int j = 0;j<cities.length;j++){
	        		if(cities[j].equals("")){
	        			continue;
	        		}
	        		if (searchColArray[0].indexOf("country")!=-1){
	        			cities[j] = cities[j].replaceAll("[0-9]", "X");
	        			if(cities[j].endsWith("X")&&cities[j].length()>2){
	        				cities[j] =cities[j].substring(0, cities[j].length()-1);
	        			}
	        		}
	        		if(AllCityMap.containsKey(cities[j])){
	        			if(!nameCount.containsKey(cities[j])){
	        				nameCount.put(cities[j],0);
	        			}
	        			AllCityMap.get(cities[j])[i]++;
	        			AllCityMap.get(cities[j])[num-1]++;
	            	}else{
	            		int[] countArray = new int[num];
		        		nameCount.put(cities[j],0);
		            	AllCityMap.put(cities[j], countArray);
		            	AllCityMap.get(cities[j])[i]++;
	        			AllCityMap.get(cities[j])[num-1]++;
	            	}
	        	}
	        } 
	        for (Map.Entry<String,Integer> entry : nameCount.entrySet()){
	        	entry.setValue((AllCityMap.get(entry.getKey())[i]));
	        }
	        nameCount = sortMap(nameCount);
	        keyValueObject.put("keyValueMap", nameCount);
	        jsondata.appendString(storePath+searchColArray[i].replaceAll(" ", "_")+
	    			"keyValueMap.json",keyValueObject.toString(),false);
	        LinkedList<String> name = new LinkedList<String>();
	        LinkedList<Integer> count = new LinkedList<Integer>();
	        for (Map.Entry<String,Integer> entry : nameCount.entrySet()){
	        	name.add(entry.getKey());
	        	count.add(entry.getValue());
	        }
	        percountJson.put("name", name);
	        percountJson.put("count", count);
	        jsondata.appendString(storePath+searchColArray[i].replaceAll(" ", "_")+
	    			".json",percountJson.toString(),false);
       	}
    	countJson.put("AllCityMap", AllCityMap);
    	jsondata.appendString(storePath+searchColArray[0].
    			substring(searchColArray[0].indexOf(" ")+1, searchColArray[0].length())+
    			".json",countJson.toString(),false);
	}
	/***
	 * @throws JSONException 
	 * 时间-地域-数量
	 * @param rs 表示要excel表
	 * @param searchDateCol 表示需要查询的列组成的数组是 时间列
	 * @param regionCol 表示需要查询的列，主要指地域
	 * @param regions   表示查询的列中需要匹配的地域，并根据地域生成一行申请量随时间变化的关系
	 * 结果：最后生成的数据是不同地域根据时间变化，数量的改变数据
	 * 注意： 匹配的地域是根据传入的数据的；所以本方法只需要判断是否包含，不需要进行分词，
	 * 本方法主要对应时间分布， 搜索的地域可以是 地域 或者受权机构或者是分类 
	 * @throws JSONException
	 */
	public void calculateAccordDateRegion(Sheet rs,String[] searchDateCol,String regionCol,String[] regions) throws JSONException{
    	//数组的长度不能是一个变量；所以设置的时候使用尽量大一点的数，不会溢出；
    	int[] years = new int[CROSS_YEAR]; 
    	Cell[] names = null;
    	
    	//获取年份
    	for(int i = START_YEAR; i<=END_YEAR;i++){
    		years[i-START_YEAR] = i;
    	}
    	
    	names = rs.getRow(namesCol);	 
    	for(int k=0;k<searchDateCol.length;k++){
    		JSONObject countAccordDate = new JSONObject();
    		countAccordDate.put("years",years );
    		Cell[] Alldate = getColumn( rs , names,searchDateCol[k]);
    		Cell[] allRegionCol = getColumn( rs , names,regionCol);
    		for(int j = 0;j<regions.length;j++){
    			String region = regions[j];
    			
    			int[] yearCount = new int[CROSS_YEAR]; //已经自动初始化为0
    			//只对应一个地区
    			LinkedList<Integer> allRegionYear = new LinkedList<Integer>();
    			for(int i = 1; i<Alldate.length;i++){
        			String perRegion = allRegionCol[i].getContents();
        			if(regionCol.equals("us classfication main")){
        				perRegion = perRegion.length()>3? perRegion.substring(0,3):perRegion;
        			}
                	if(perRegion.contains(region)){
                		String appdate = Alldate[i].getContents();
                		int year = Integer.parseInt(appdate.substring(0,4));
                		allRegionYear.add(year);
                	}
                } 
    			
            	//统计每年的论文数量
            	for(int i = 0;i<allRegionYear.size();i++){
            		yearCount[allRegionYear.get(i)-(START_YEAR)]++;
            	}

            	countAccordDate.put(region,yearCount );
    		}
    		jsondata.appendString(storePath+searchDateCol[k].replaceAll(" ", "_")+
    				regionCol.replaceAll(" ", "_")+".json",
            		countAccordDate.toString(),false);
    	}
	}
	

	
	
}