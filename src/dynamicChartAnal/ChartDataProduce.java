package dynamicChartAnal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;

import jxl.Cell;
import jxl.Sheet;

import org.json.JSONException;
import org.json.JSONObject;

import systemVo.RobotVo;

public class ChartDataProduce{
	
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
	//数组的长度不能是一个变量；所以在设置不知长度的序列时不要使用数组
	/***
	 * plot according to the Date ; 
	 * applicationDate 或者  issureDate 的总量，确定的时间列用参数传递
	 * @throws JSONException 
	 */
	public String dateData(List<RobotVo> allResult, String dateColume) throws JSONException{
		//TreeMap 默认是升序的
		Map<String,Integer> nameCount = new TreeMap<String,Integer>(); 
		JSONObject countJson = new JSONObject();
		Iterator<RobotVo> iter = allResult.iterator();
		RobotVo robot;
		while(iter.hasNext()){
			robot = (RobotVo)iter.next();
			String _year="";
			//判断是按那种时间计数
			if(dateColume.equalsIgnoreCase("applicationDate")){
				_year = robot.getApplicationDate(); 
			}else if(dateColume.equalsIgnoreCase("issureDate")){
				_year = robot.getIssuedDate();
			}else{
				
			}
			if(_year==null||_year.trim().equals("")){
        		continue;
        	}    
			_year = _year.substring(0,4);
    		if(nameCount.containsKey(_year)){
    			nameCount.put(_year,nameCount.get(_year)+1);
        	}else{
        		nameCount.put(_year,1);
        	}
		}
		LinkedList<String> name = new LinkedList<String>();
        LinkedList<Integer> count = new LinkedList<Integer>();
        for (Map.Entry<String,Integer> entry : nameCount.entrySet()){
        	name.add(entry.getKey());
        	count.add(entry.getValue());
        }
        countJson.put("name", name);
        countJson.put("count", count);
		return countJson.toString() ;
	}
	/***
	 * 对split的列进行统计
	 * @param allResult
	 * @param dateColume
	 * @return
	 * @throws JSONException
	 */
	public String pDSplit(List<RobotVo> allResult, String dateColume)throws JSONException{
		Map<String,Integer> nameCount = new HashMap<String,Integer>(); 
		JSONObject countJson = new JSONObject();
		Iterator<RobotVo> iter = allResult.iterator();
		RobotVo robot;
		while(iter.hasNext()){
			robot = (RobotVo)iter.next();
			String boxData ="";

			if(dateColume.equalsIgnoreCase("inventorCountry")){
				boxData =robot.getInventorCountry();
			}else{
				
			}
			if(boxData==null){
				continue;
			}
			if(boxData.trim().equals("")){
        		continue;
        	}
        	String[] boxSplitCons = boxData.split("~");
        	for(int j = 0;j<boxSplitCons.length;j++){
        		if(boxSplitCons[j].equals("")){
        			continue;
        		}
        		boxSplitCons[j] = boxSplitCons[j].replaceAll("[0-9]", "X");
    			if(boxSplitCons[j].endsWith("X")&&boxSplitCons[j].length()>2){
    				boxSplitCons[j] =boxSplitCons[j].substring(0, boxSplitCons[j].length()-1);
    			}
    			if(nameCount.containsKey(boxSplitCons[j])){
        			nameCount.put(boxSplitCons[j],nameCount.get(boxSplitCons[j])+1);
            	}else{
            		nameCount.put(boxSplitCons[j],1);
            	}
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
		return countJson.toString() ;
	}
	/***
	 * 不用分割的列
	 * @param allResult
	 * @return
	 * @throws JSONException
	 */
	public String pDNoSplit(List<RobotVo> allResult, String dateColume) throws JSONException{
		Map<String,Integer> nameCount = new HashMap<String,Integer>(); 
		JSONObject countJson = new JSONObject();
		Iterator<RobotVo> iter = allResult.iterator();
		RobotVo robot;
		while(iter.hasNext()){
			robot = (RobotVo)iter.next();
			String boxData ="";
			if(dateColume.equalsIgnoreCase("assigneeName")){
				boxData =robot.getAssigneeName();
			}else if(dateColume.equalsIgnoreCase("usClassficationMain")){
				boxData =robot.getUsClassficationMain();
			}
			if(boxData==null){
				continue;
			}
			if(boxData.trim()==null||boxData.trim().equals("")){
        		continue;
        	}   
			
    		if(nameCount.containsKey(boxData)){
    			nameCount.put(boxData,nameCount.get(boxData)+1);
        	}else{
        		nameCount.put(boxData,1);
        	}
		}
		nameCount = this.sortMap(nameCount);
		LinkedList<String> name = new LinkedList<String>();
        LinkedList<Integer> count = new LinkedList<Integer>();
        for (Map.Entry<String,Integer> entry : nameCount.entrySet()){
        	name.add(entry.getKey());
        	count.add(entry.getValue());
        }
        countJson.put("name", name);
        countJson.put("count", count);
		return countJson.toString() ;
	}
	
	/***
	 * 暂时使用 inventorCountry 来度量
	 * @param allResult
	 * @param dateColume
	 * @return
	 * @throws JSONException
	 */
	public String CountryCount(List<RobotVo> allResult, String dateColume)throws JSONException{
		Map<String,Integer> nameCount = new HashMap<String,Integer>(); 
		JSONObject keyValueObject = new JSONObject();
		JSONObject countJson = new JSONObject();
		Iterator<RobotVo> iter = allResult.iterator();
		RobotVo robot;
		while(iter.hasNext()){
			robot = (RobotVo)iter.next();
			String boxData ="";
//			String boxDataPre="";
			//确定国家使用那种度量
			if(dateColume.equalsIgnoreCase("inventorCountry")){
				boxData =robot.getInventorCountry();
//				boxDataPre = robot.getInventorState();
			}else if(dateColume.equalsIgnoreCase(" ")){
				boxData =robot.getInventorCountry();
			}
			
//			if(boxData.trim().equals("")&&boxDataPre.trim().equals("")){
			//只是关注国家
			if(boxData==null){
				continue;
			}
			if(boxData.trim().equals("")){
        		continue;
        	}
        	String[] boxSplitCons = boxData.split("[~]");
        	for(int j = 0;j<boxSplitCons.length;j++){
        		if(boxSplitCons[j].equals("")){
        			continue;
        		}
        		boxSplitCons[j] = boxSplitCons[j].replaceAll("[0-9]", "X");
    			if(boxSplitCons[j].endsWith("X")&&boxSplitCons[j].length()>2){
    				boxSplitCons[j] =boxSplitCons[j].substring(0, boxSplitCons[j].length()-1);
    			}
    			if(nameCount.containsKey(boxSplitCons[j])){
        			nameCount.put(boxSplitCons[j],nameCount.get(boxSplitCons[j])+1);
            	}else{
            		nameCount.put(boxSplitCons[j],1);
            	}
        	}
		}

        nameCount = sortMap(nameCount);
        keyValueObject.put("keyValueMap", nameCount);
        LinkedList<String> name = new LinkedList<String>();
        LinkedList<Integer> count = new LinkedList<Integer>();
        for (Map.Entry<String,Integer> entry : nameCount.entrySet()){
        	name.add(entry.getKey());
        	count.add(entry.getValue());
        }
        countJson.put("name", name);
        countJson.put("count", count);
		return countJson.toString() ;
	}
}