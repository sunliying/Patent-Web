package dynamicChartAnal;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import com.google.gson.Gson;

import sun.print.resources.serviceui;



public class TestGuava {

	@Test
	public void  testTable(){
		Table<Integer,Integer , String[]> table = HashBasedTable.create();
        for (int row = 0; row < 10; row++) {
            for (int column = 0; column < 5; column++) {
            	String[] s = {""+row,""+column,"你好"};
                table.put(row,column,s);
            }
        }
        Gson gson = new Gson();
        String  gsonJson = gson.toJson(table);
        System.out.println("gsonJson="+gsonJson);
		
	}
	
	public static void main(String[] args) {
		TestGuava testTb = new TestGuava();
		testTb.testTable();
		String s= "ADADX";
		StringUtils.endsWith(s,"X");
		System.out.println(s.substring(0, s.length()-1));
	}
}
