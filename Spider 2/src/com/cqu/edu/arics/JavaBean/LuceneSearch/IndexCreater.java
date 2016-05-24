package com.cqu.edu.arics.JavaBean.LuceneSearch;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Path;
import java.util.List;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.core.SimpleAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.TextField;
import org.apache.lucene.document.Field.Store;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

import com.cqu.edu.arics.JavaBean.Launcher.Launcher;


public class IndexCreater {
	public String getPath() {
		return path;
	}
	private String path="E:\\work\\news\\index";
	
	public void IndexCreate() throws IOException {
		Launcher launcher=new Launcher();
		List<File>fileslist=launcher.GetAllLocalNews();
		File index=new File(path);
		if(!index.exists())
			index.mkdirs();
		File[] files=index.listFiles();
		for(File f:files){
			f.delete();
		}
		Path indexpath=index.toPath();
		 for(File news:fileslist){
			String content="";
			BufferedReader reader;
			reader = new BufferedReader(new FileReader(news));
			String temp="";
			while((temp=reader.readLine())!=null){
				content=content+temp+"\n";
				}
			Directory directory = FSDirectory.open(indexpath);
			Analyzer analyzer = new SimpleAnalyzer();
		    IndexWriterConfig config = new IndexWriterConfig(analyzer);
		    IndexWriter iwriter = new IndexWriter(directory, config);
			 Document doc = new Document();
			 doc.add(new TextField("filename", news.getName(), Store.YES));
	            doc.add(new TextField("content", content, Store.YES));
	            doc.add(new TextField("path", news.getPath(), Store.YES));
	            iwriter.addDocument(doc);
	            iwriter.commit();
	            iwriter.close();
			}
	}

}
