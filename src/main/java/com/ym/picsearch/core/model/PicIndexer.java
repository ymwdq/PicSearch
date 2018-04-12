//package com.ym.picsearch.core.model;
//
//import org.apache.lucene.analysis.standard.StandardAnalyzer;
//import org.apache.lucene.document.*;
//import org.apache.lucene.index.IndexWriter;
//import org.apache.lucene.index.IndexWriterConfig;
//import org.apache.lucene.store.FSDirectory;
//
//import java.io.*;
//import java.util.ArrayList;
//import java.util.List;
//
//public class PicIndexer {
//    private String indexDir;
//    private IndexWriter indexWriter;
//
//
//    public PicIndexer(String indexDir) throws IOException{
//        this.indexDir = indexDir;
//        indexWriter = new IndexWriter(FSDirectory.open(new File(indexDir).toPath()),
//                new IndexWriterConfig(new StandardAnalyzer()));
//    }
//
//    private Document genDoc(PicInfo picinfo) {
//        Document doc = new Document();
//
//        doc.add(new StringField("id", picinfo.getId(), Field.Store.YES));
//        for (EdgeCoordinate edgeCoordinate : picinfo.getEdgeCoordinates()) {
//            doc.add(new StringField("coordinate",edgeCoordinate.toString(), Field.Store.YES));
//        }
//        return doc;
//    }
//
//    private void indexDoc(Document doc) throws IOException{
//        indexWriter.addDocument(doc);
//    }
//
//
//    public void index(List<PicInfo> picInfos) throws IOException{
//        for (PicInfo picInfo : picInfos) {
//            indexDoc(genDoc(picInfo));
//        }
//        indexWriter.commit();
//    }
//
//    public void close() throws IOException {
//        indexWriter.close();
//    }
//
//    public static void main(String[] args) throws FileNotFoundException, IOException {
//        String indexDir = "d://indexDir";
//        File file = new File("d://documents.json");
//        BufferedReader bf = new BufferedReader(new FileReader(file));
//        PicIndexer picIndexer = new PicIndexer(indexDir);
//        int maxNum = 18000;
//        List<PicInfo> picInfos = new ArrayList<>(maxNum);
//        String st;
//        while((st = bf.readLine()) != null) {
//            System.out.println(st);
//            picInfos.add(new PicInfoJson(st));
//        }
//        picIndexer.index(picInfos);
//        picIndexer.close();
//    }
//
//}
