package com.ym.picsearch.core.model;

import org.apache.lucene.search.ScoreDoc;

import java.util.Arrays;

public class PicSort {
    public static ScoreDoc[] sortByScoreDoc(ScoreDoc[] docs) {
        ScoreDoc[] scoreDocs = Arrays.copyOf(docs, docs.length);
        return null;
    }
}
