package com.cqu.edu.arics.JavaBean.LuceneSearch;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

public class LuceneSearcher {
	private String src="E:\\work\\news\\index";
	  private Directory directory = null;
	  
	public List<String> LuceneSearching(String target)throws IOException, ParseException{
		File targetfile=new File(src);
		Path indexpath=targetfile.toPath();
		directory=FSDirectory.open(indexpath);
		Analyzer analyzer = new StandardAnalyzer();
        DirectoryReader ireader = DirectoryReader.open(directory);
        IndexSearcher isearcher = new IndexSearcher(ireader);
        QueryParser parser = new QueryParser("content", analyzer);
        Query query = parser.parse(target);      
		Long date1=new Date().getTime();
		ScoreDoc[] hits = isearcher.search(query,1000).scoreDocs;//命中
        Long date2=new Date().getTime();
        System.out.println(date2-date1+"ms");
        List<String> result=new ArrayList<String>();
        for (int i = 0; i < hits.length; i++) {
            Document hitDoc = isearcher.doc(hits[i].doc);
            result.add(hitDoc.get("path"));
        }
        ireader.close();
        directory.close();
        return result;
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		IndexCreater indexCreater=new IndexCreater();
		indexCreater.IndexCreate();
		LuceneSearcher searcher=new LuceneSearcher();
		try {
			List<String> result=searcher.LuceneSearching("学生");
			//for(String res:result)
				//System.out.println(res);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
