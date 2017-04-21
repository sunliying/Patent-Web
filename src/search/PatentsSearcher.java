	package search;
//package lxpInn.network;

import java.io.File;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.PropertyResourceBundle;

import org.apache.commons.lang3.StringUtils;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexableField;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.BooleanClause.Occur;
import org.apache.lucene.search.BooleanQuery;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.SimpleFSDirectory;

import systemVo.RobotVo;



public class PatentsSearcher {
	private RobotVo robot;
	private String index ; 
	private String topicQuery;
	private int totalNumOfPat;
	private String[] parserField = {"DETD","TITLE","ABST","CONTENT","NAME"};
	private String inTheField = StringUtils.join(parserField,",");
	
	public int getTotalNumOfPat(){
		return this.totalNumOfPat;
	}
	public String getInTheFiled(){
		return this.inTheField;
	}
	public PatentsSearcher(String topicQuery) {
		this.topicQuery = topicQuery;
//		Put the data in the server's webapp directory
		URL url = Thread.currentThread().getContextClassLoader()
				 .getResource("");
		File file1 =new File(url.getPath());
		File parentFile =new File(file1.getParent());
		File webFile = new File(parentFile.getParent());
		this.index = webFile.getParent()+Constant.indexFile;
		System.out.print(this.index);
	}

	public List<RobotVo> searcher(){
		
		List<RobotVo> robotAll = new ArrayList<RobotVo>();
		try {
			//获取索引目录
			Directory idxDirectory = new SimpleFSDirectory(new File(index));
			//读取索引目录
			IndexReader reader = DirectoryReader.open(idxDirectory);
			BooleanQuery query = new BooleanQuery();		
			QueryParser parser;
			StandardAnalyzer stdAnalyzer = new StandardAnalyzer();
			for(String s : parserField){	
				parser = new QueryParser(s, stdAnalyzer);			
				query.add(parser.parse(topicQuery), Occur.SHOULD);
			}
			
			IndexSearcher idxSearcher = new IndexSearcher(reader);
			TopDocs topDocs = idxSearcher.search(query, 1000000);
			ScoreDoc[] scoreDoc  = topDocs.scoreDocs;
			totalNumOfPat = topDocs.totalHits;
			
			for(int i = 0;i<totalNumOfPat;i++){
				Document doc = reader.document(scoreDoc[i].doc);
				selectField(doc, robotAll); 
			}
			reader.close();
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return robotAll;
	}
	public void selectField(Document document, List<RobotVo> robotAll){
		PropertyResourceBundle   config = 
				(PropertyResourceBundle)PropertyResourceBundle
				.getBundle("search.patentFiled",
						new Locale("cn","CN"));
		
		robot = new RobotVo();
		robot.setId(document.get(config.getString("Id")));
		robot.setTitle(document.get(config.getString("Title")));
		robot.setApplicationDate(document.get(config.getString("ApplicantDate")));
		robot.setIssuedDate(document.get(config.getString("IssuedDate")));
		robot.setInventorName(document.get(config.getString("InventorName")));
		robot.setInventorCity(document.get(config.getString("InventorCity")));
		robot.setInventorState(document.get(config.getString("InventorState")));
		robot.setInventorCountry(document.get(config.getString("InventorCountry")));
		robot.setAssigneeName(document.get(config.getString("AssigneeName")));
		robot.setAssigneeCity(document.get(config.getString("AssigneeCity")));
		robot.setAssigneeState(document.get(config.getString("AssigneeState")));
		robot.setReferencePatentIssuedDate(document.get(config.getString("ReferencePatentIssuedDate")));
		robot.setReferencePatentId(document.get(config.getString("ReferencePatentId")));
		robot.setReferencePatentName(document.get(config.getString("ReferencePatentName")));
		robot.setUsClassficationMain(document.get(config.getString("UsClassficationMain")));
		robot.setUsClassificationFurther(document.get(config.getString("UsClassificationFurther")));
		robot.setCooperativePatentClassification(document.get(config.getString("CooperativePatentClassification")));
		robot.setInternationalClassification(document.get(config.getString("InternationalClassification")));
		robotAll.add(robot);
	}
	
	public static void main(String[] args){
		PatentsSearcher PS= new PatentsSearcher("SCIENCE");
		PS.searcher();
	}

}
