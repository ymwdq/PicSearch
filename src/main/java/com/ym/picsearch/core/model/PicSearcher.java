//package com.ym.picsearch.core.model;
//
//import org.apache.lucene.document.Document;
//import org.apache.lucene.index.DirectoryReader;
//import org.apache.lucene.index.Term;
//import org.apache.lucene.search.*;
//import org.apache.lucene.store.Directory;
//import org.apache.lucene.store.FSDirectory;
//import org.json.JSONObject;
//
//import java.io.*;
//import java.util.ArrayList;
//import java.util.Comparator;
//import java.util.HashSet;
//import java.util.List;
//
//public class PicSearcher {
//    public static void main(String[] args) throws IOException {
//        String indexDir = "D:\\indexDir";
//        PicSearcher picSearcher = new PicSearcher();
//        picSearcher.search(indexDir);
//    }
//
//    public void search(String indexDir) throws IOException{
//        Directory dir = FSDirectory.open(new File(indexDir).toPath());
//        IndexSearcher is = new IndexSearcher(DirectoryReader.open(dir));
//
//        List<String> infos = readPicInfo("d://query.json");
//        for (String str : infos) {
//            long start = System.currentTimeMillis();
//            System.out.println(" === query === " + new JSONObject(str).getString("id"));
//            TopDocs hits = is.search(genQuery(str), 50);
//            is.setSimilarity(new PicSimilarity());
//            long end = System.currentTimeMillis();
//            for(ScoreDoc scoreDoc : hits.scoreDocs) {
//                Document doc = is.doc(scoreDoc.doc);
//                System.out.println(doc.get("id"));
////                System.out.println(scoreDoc.score);
////                Explanation explanation = is.explain(genQuery(str), scoreDoc.doc);
////                System.out.println("=== explanation ===");
////                System.out.println(explanation.toString());
////                return;
//            }
//            System.out.println("cost: " + (end - start));
//            System.out.println("over");
//        }
//
//    }
//
//    public BooleanQuery genQuery(String jsonPicInfo) throws FileNotFoundException, IOException {
//        PicInfoJson picInfoJson = new PicInfoJson(jsonPicInfo);
////        System.out.println(picInfoJson.getEdgeCoordinates());
//        BooleanQuery.Builder builder = new BooleanQuery.Builder();
//        BooleanQuery.setMaxClauseCount(10000);
//        for (EdgeCoordinate edgeCoordinate : picInfoJson.getEdgeCoordinates()) {
//            builder.add(new TermQuery(new Term("coordinate", edgeCoordinate.toString())), BooleanClause.Occur.SHOULD);
//        }
//
//        return builder.build();
//    }
//
//    public List<String> readPicInfo(String picinfoPath) throws IOException{
//        File file = new File(picinfoPath);
//        BufferedReader bf = new BufferedReader(new FileReader(file));
//        List<String> picinfoJsonList = new ArrayList<>();
//        String jsonStr;
//        while((jsonStr = bf.readLine()) != null) {
//            picinfoJsonList.add(jsonStr);
//        }
//        return picinfoJsonList;
//    }
//
//    public void searchByPicInfo() {
//
//    }
//
//    private ScoreDoc[] sortScoreDocs(ScoreDoc[] docs, String queryPicInfo) {
//        PicInfoJson picInfoJson = new PicInfoJson(queryPicInfo);
//        return null;
//    }
//
//    private static class PicComparator implements Comparator<PicInfo> {
//        private PicInfo picinfo;
//        public PicComparator(PicInfo picInfo) {
//            this.picinfo = picInfo;
//        }
//
//        @Override
//        public int compare(PicInfo o1, PicInfo o2) {
//            HashSet<EdgeCoordinate> coordinates1 = new HashSet<>(o1.getEdgeCoordinates());
//            HashSet<EdgeCoordinate> coordiantes2 = new HashSet<>(o2.getEdgeCoordinates());
//            HashSet<EdgeCoordinate> queryCoordinates = new HashSet<>(picinfo.getEdgeCoordinates());
//            coordinates1.retainAll(queryCoordinates);
//            coordiantes2.retainAll(queryCoordinates);
//            float score1 = (float)coordinates1.size()/ picinfo.getEdgeCoordinates().size();
//            return 0;
//
//        }
//    }
//}
