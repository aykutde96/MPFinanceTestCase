package com.hepsiburada.helper;

import java.util.HashMap;
import java.util.Map;

public class CacheHelper {

    private Map<String, Object> instanceMap;

    public Map<String, Object> globalVariable(){
        if (instanceMap == null){
            instanceMap = new HashMap<>();
        }
        return instanceMap;
    }

}