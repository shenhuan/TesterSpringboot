package com.vue.utils;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DifferJson {
    /**
     * 返回当前数据类型
     *
     * @param source
     * @return
     */
    public String getTypeValue(Object source){
        if (source instanceof String) {
            return "String";
        }
        if (source instanceof Integer) {
            return "Integer";
        }
        if (source instanceof Float) {
            return "Float";
        }

        if (source instanceof Long) {
            return "Long";
        }

        if (source instanceof Double) {
            return "Double";
        }

        if (source instanceof Date) {
            return "Date";
        }

        if (source instanceof Boolean) {
            return "Boolean";
        }
        return "null";
    }

    /**
     * 把Object变成JsonSchema
     *
     * @param source
     * @return
     */
    public Object generateJsonSchema(Object source){
        //判断是否为JsonObject
        if(source instanceof JSONObject){
            JSONObject jsonResult = new JSONObject();
            JSONObject sourceJSON = JSONObject.parseObject(source.toString());
            for (String key: sourceJSON.keySet()){
                Object nowValue = sourceJSON.get(key);
                if (nowValue == null || nowValue.toString().equals("null")){
                    jsonResult.put(key,"null");
                }else if(isJsonObject(nowValue)){
                    jsonResult.put(key,generateJsonSchema(nowValue));
                }else if(isJsonArray(nowValue)){
                    JSONArray tempArray = JSONArray.parseArray((String) nowValue);
                    JSONArray newArray = new JSONArray();
                    if(tempArray != null && tempArray.size() > 0){
                        for(int i = 0; i<tempArray.size();i++){
                            newArray.add(generateJsonSchema(tempArray.get(i)));
                        }
                        jsonResult.put(key,newArray);
                    }
                }else if(nowValue instanceof  List){
                    List<Object> newList = new ArrayList<Object>();
                    for(int i = 0;i<((List) nowValue).size();i++){
                        newList.add(((List) nowValue).get(i));
                    }
                    jsonResult.put(key,newList);
                }else {
                    jsonResult.put(key,getTypeValue(nowValue));
                }
            }
        }
        return getTypeValue(source);
    }

    /**
     * 判断是否为JSONArray
     * @param value
     * @return
     */
    private boolean isJsonArray(Object value) {
        try {
            if (value instanceof JSONArray){
                return true;
            }
        }catch (Exception e){
            return false;
        }
        return false;
    }

    /**
     * 判断是否是jsonobject
     * @param value
     * @return
     */
    private boolean isJsonObject(Object value) {
        try{
            if(value instanceof JSONObject){
            return true;
            }
        }catch (Exception e){
            return false;
        }
        return false;
    }
    /**
     * JSON格式比对，值不能为空，且key需要存在
     */
    public JSONObject diffFormatJson(Object current,Object expected,String path){
        String path1 = path;
        String path2 = path;
        JSONObject jsonDiff = new JSONObject();

        if(isJsonObject(expected)){
            JSONObject expectedJSON = JSONObject.parseObject(expected.toString());
            JSONObject currentJSON = JSONObject.parseObject(current.toString());
            for (String key:expectedJSON.keySet()){
                Object expectedValue = expectedJSON.get(key);
                path2 = path1 + "." +key;
                if(!currentJSON.containsKey(key)){
                    JSONObject tempJSON = new JSONObject();
                    tempJSON.put("actualKey","不存在此"+key);
                    tempJSON.put("expectedKey",key);
                    jsonDiff.put(path2,tempJSON);
                }
                if(currentJSON.containsKey(key)){
                    Object currentValue = currentJSON.get(key);
                    if(expectedValue != null
                            &&currentValue == null
                            || expectedValue.toString() != "null"
                            && currentValue.toString() == "null"){
                        JSONObject tempJSON = new JSONObject();
                        tempJSON.put("actualValue","null");
                        tempJSON.put("expectedValue",expectedValue);
                        jsonDiff.put(path2,tempJSON);
                    }
                    if(expectedValue != null && currentValue != null){

                        if(isJsonObject(expectedValue) || isJsonArray(expectedValue)){

                            JSONObject getResultJSON = new JSONObject();
                            getResultJSON = diffFormatJson(currentValue,expectedValue,path2);
                            if(getResultJSON != null){
                                jsonDiff.putAll(getResultJSON);
                            }
                        }else if(!expectedValue.equals(currentValue)){
                            JSONObject tempJSON = new JSONObject();
                            tempJSON.put("actualValue", currentValue);
                            tempJSON.put("expectedValue", expectedValue);
                            jsonDiff.put(path2, tempJSON);
                        }
                    }
                }
            }
        }
        if(isJsonArray(expected)){
            JSONArray expectArray = JSONArray.parseArray((String) expected);
            JSONArray currentArray = JSONArray.parseArray((String) current);

            if(expectArray.size() != currentArray.size()){
                JSONObject tempJSON = new JSONObject();
                tempJSON.put("actualLenth",currentArray.size());
                tempJSON.put("expectLenth",expectArray.size());
                jsonDiff.put("Lenth",tempJSON);
            }
            if(expectArray.size() != 0){
                Object expectIndexValue = expectArray.get(0);
                Object currentIndexValue = currentArray.get(0);
                if (expectIndexValue != null && currentIndexValue != null){
                    if (isJsonObject(expectIndexValue) || isJsonArray(expectIndexValue)){
                        JSONObject getResultJSON = new JSONObject();
                        getResultJSON = diffFormatJson(currentIndexValue, expectIndexValue,path2);
                        if (getResultJSON != null) {
                            jsonDiff.putAll(getResultJSON);
                        }
                    }
                }
            }
        }
        System.out.println("json格式比对  diffFormatJson===》"+jsonDiff);
        return jsonDiff;
    }


}
