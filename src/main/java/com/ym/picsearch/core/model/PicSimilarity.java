package com.ym.picsearch.core.model;

import org.apache.lucene.search.similarities.BM25Similarity;

public class PicSimilarity extends BM25Similarity {
    @Override
    protected float idf(long docFreq, long docCount) {
        return 1F;
    }
}
