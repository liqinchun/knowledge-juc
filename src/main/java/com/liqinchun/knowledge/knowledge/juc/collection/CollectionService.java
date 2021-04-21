package com.liqinchun.knowledge.knowledge.juc.collection;

import java.util.HashMap;
import java.util.Hashtable;

public class CollectionService {

    public static void main(String[] args) {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        Hashtable<String, Object> Hashtable = new Hashtable<String, Object>();
        hashMap.put("aa", "aa");
        hashMap.put(null, "aa");
        Hashtable.put(null, "");
    }
}
