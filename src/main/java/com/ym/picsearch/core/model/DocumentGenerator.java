package com.ym.picsearch.core.model;

import org.apache.lucene.document.Document;

/**
 * Created by ym on 18-4-11.
 */
public interface DocumentGenerator {
    Document genDoc(PicInfo picInfo);
}
