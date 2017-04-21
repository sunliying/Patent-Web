package dynamicChartAnal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import org.apache.commons.lang.StringUtils;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

import systemVo.RobotVo;

public class Statistics {

	/**
	 * 根据申请量统计数量以及每个城市的发明量
	 * 
	 * @param robotAll
	 * @return
	 */
	public String statisticsApplicationName(List<RobotVo> robotAll) {
		// 时间 与数量
		Map<String, Integer> appliNumMap = new TreeMap<String, Integer>();
		// 时间 与国家数量
		Table<String, String, Integer> countryTable = HashBasedTable.create();

		for (RobotVo robotVo : robotAll) {
		//			System.out.println("robotVo.getInventorCountry()="+robotVo.getInventorCountry());
			String applicationDate = robotVo.getApplicationDate().substring(0, 4);
			if (appliNumMap.containsKey(applicationDate)) {
				Integer appliNum = appliNumMap.get(applicationDate);
				appliNum++;
				appliNumMap.put(applicationDate, appliNum);
			} else {
				appliNumMap.put(applicationDate, 1);
			}
			if (StringUtils.isNotEmpty(robotVo.getInventorCountry())) {
				String inventorCountry = robotVo.getInventorCountry();
				if(StringUtils.contains(inventorCountry, "~")){
					String[] inventorCountries = StringUtils.split(inventorCountry, "~");
					for(String s:inventorCountries){
						if(StringUtils.endsWith(s, "X")){
							s = s.substring(0, s.length()-1);
						}
						if (countryTable.contains(applicationDate, s)) {
							Integer countryNum = countryTable.get(applicationDate, s);
							countryNum++;
							countryTable.put(applicationDate,s, countryNum);
						} else {
							countryTable.put(applicationDate,s, 1);
						}
					}
				}else{
					if(StringUtils.endsWith(inventorCountry, "X")){
						inventorCountry = inventorCountry.substring(0, inventorCountry.length()-1);
					}
					if (countryTable.contains(applicationDate, inventorCountry)) {
						Integer countryNum = countryTable.get(applicationDate, inventorCountry);
						countryNum++;
						countryTable.put(applicationDate,inventorCountry, countryNum);
					} else {
						countryTable.put(applicationDate,inventorCountry, 1);
					}
				}	
			}
		}
		List<List<Object>> list = new ArrayList<List<Object>>();
		Iterator<Map.Entry<String,Integer>> iterator = appliNumMap.entrySet().iterator();
		Map<String, Map<String, Integer>> countryYearNumMap = countryTable.rowMap();
		while (iterator.hasNext()) {
			Map.Entry<String, Integer> entry = iterator.next();
			String year = entry.getKey();
			Integer num = entry.getValue();
		
			List<Object> _List = new ArrayList<Object>();
			Map<String,Integer> countryNumMap = countryYearNumMap.get(year);
			if(countryNumMap !=null){
				_List.add(countryNumMap.size());
			}else{
				_List.add(0);
			}
			_List.add(num);
			_List.add(Integer.parseInt(year));
			list.add(_List);
		}
		Map<String,List<List<Object>>> seriMap = new HashMap<String, List<List<Object>>>();
		seriMap.put("series", list);
		System.out.println("JSONObject.toJSONString(seriMap)"+JSONObject.toJSONString(seriMap));
		return JSONObject.toJSONString(seriMap);
	}

	/**
	 * 切割处理
	 * 
	 * @param robotAll
	 * @param fearture
	 * @return
	 */
	public List<RobotVo> spitFearture(List<RobotVo> robotAll, String fearture) {
		List<RobotVo> robotList = new ArrayList<RobotVo>();
		for (RobotVo robotVo : robotAll) {
			String newFeature = null;
			if ("assigneeName".equals(fearture)) {
				if (robotVo.getAssigneeName() == null)
					continue;
				newFeature = robotVo.getAssigneeName().trim();
				if (newFeature.contains("~")) {
					String[] newFeatures = newFeature.split("~");
					for (String s : newFeatures) {
						if (StringUtils.isNotBlank(s)) {
							robotVo.setAssigneeName(s);
							robotList.add(robotVo);
						}
					}
				} else {
					robotList.add(robotVo);
				}
			}
			if ("inventorCountry".equals(fearture)) {
				if (robotVo.getInventorCountry() == null && robotVo.getInventorState() == null)
					continue;
				else if (robotVo.getInventorCountry() == null && robotVo.getInventorState() != null)
					robotVo.setInventorCountry("US");
				newFeature = robotVo.getInventorCountry().trim();
				if (newFeature.contains("~")) {
					String[] newFeatures = newFeature.split("~");
					for (String s : newFeatures) {
						if (StringUtils.isNotBlank(s)) {
							if (StringUtils.endsWith(s.trim(), "X")) {
								s = s.substring(0, s.length() - 1);
							}
							robotVo.setInventorCountry(s);
							robotList.add(robotVo);
						}
					}
				} else {
					if (StringUtils.endsWith(newFeature, "X")) {
						robotVo.setInventorCountry(newFeature.substring(0, newFeature.length() - 1));
					}
					robotList.add(robotVo);
				}
			}
			if ("internationalCclassification".equals(fearture)) {
				if (robotVo.getInternationalClassification() == null)
					continue;
				newFeature = robotVo.getInternationalClassification().trim();
				if (newFeature.contains("~")) {
					String[] newFeatures = newFeature.split("~");
					for (String s : newFeatures) {
						if (StringUtils.isNotBlank(s)) {
							robotVo.setInternationalClassification(s);
							robotList.add(robotVo);
						}
					}
				} else {
					robotList.add(robotVo);
				}
			}
		}
		return robotList;
	}

	/**
	 * 统计
	 * 
	 * @param robotAll
	 * @param fearture
	 * @return
	 */
	public String Stat(List<RobotVo> robotAll, String fearture) {
		List<RobotVo> robotList = spitFearture(robotAll, fearture);

		Table<String, String, Integer> table = HashBasedTable.create();
		// 用于存放fearture于count
		Map<String, Integer> feartureCountMap = new TreeMap<String, Integer>();

		for (RobotVo robotVo : robotList) {
			String applicationDate = robotVo.getApplicationDate();
			applicationDate = applicationDate.substring(0, 4);
			String newFeature = null;
			if ("assigneeName".equals(fearture)) // {
				// if (robotVo.getAssigneeName() == null)
				// continue;
				newFeature = robotVo.getAssigneeName().trim();
			// }
			if ("inventorCountry".equals(fearture)) // {
				// if (robotVo.getInventorCountry() == null)
				// continue;
				newFeature = robotVo.getInventorCountry().trim();
			// }

			if ("internationalCclassification".equals(fearture)) // {
				// if (robotVo.getInternationalClassification() == null)
				// continue;
				newFeature = robotVo.getInternationalClassification().trim();
			// }

			// 统计每个特征的数量
			if (feartureCountMap.containsKey(newFeature)) {
				Integer count = feartureCountMap.get(newFeature);
				count++;
				feartureCountMap.put(newFeature, count);
			} else {
				feartureCountMap.put(newFeature, 1);
			}

			// 按年统计特征的数量。
			if (table.contains(applicationDate, newFeature)) {
				Integer num = table.get(applicationDate, newFeature);
				num = num + 1;
				table.put(applicationDate, newFeature, num);
			} else {
				table.put(applicationDate, newFeature, 1);
			}
		}

		// 降序排序
		List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(feartureCountMap.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
				return o2.getValue() - o1.getValue();
			}
		});

		// 将键与值转化为字符串数组
		List<String> nameList = new ArrayList<String>();
		List<Integer> countList = new ArrayList<Integer>();
		for (Map.Entry<String, Integer> mapping : list) {
			nameList.add(mapping.getKey());
			countList.add(mapping.getValue());
		}
		Set<String> yearSetBefore = table.rowKeySet();
		
		TreeSet<String> yearSet = new TreeSet<String>(); 
		for (String year : yearSetBefore) {  
			yearSet.add(year);  
		} 
		
		// 处理series

		// 存储series
		Map<String, List<Integer>> seriesMap = new LinkedHashMap<String, List<Integer>>();// series
		Map<String, Map<String, Integer>> map = table.columnMap();

		// 遍历处理
		Iterator<Map.Entry<String, Map<String, Integer>>> iterator = map.entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry<String, Map<String, Integer>> entry = iterator.next();
			String key = entry.getKey();
			Map<String, Integer> entryMap = entry.getValue();
			// 内循环
			List<Integer> innerList = new ArrayList<Integer>();
			for (String year : yearSet) {
				Integer val = entryMap.get(year);
				if (val == null) {
					val = 0;
				}
				innerList.add(val);
			}
			seriesMap.put(key, innerList);
		}
		Map<String, Object> totalMap = new HashMap<String, Object>();
		totalMap.put("year", yearSet);
		totalMap.put("name", nameList);
		totalMap.put("count", countList);
		totalMap.put("series", seriesMap);

		String totalMapJsonString = JSONObject.toJSONString(totalMap);
//		System.out.println(totalMapJsonString);
		return totalMapJsonString;

	}
}
