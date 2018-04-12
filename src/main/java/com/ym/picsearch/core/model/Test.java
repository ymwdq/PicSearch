package com.ym.picsearch.core.model;

import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ym on 18-4-12.
 */
public class Test {
    public static String getCorrectName(String appName) {
        String regEx="[`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(appName);
        ReentrantLock reentrantLock;
        return m.replaceAll("").trim().replaceAll(" ", "");
    }

    public static void main(String[] args) {
        System.out.println(getCorrectName("My Town : Car (wash, $$$%%%@@##@#@fix"));
    }
}
