package com.vue.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.vue.utils.ObjectUtil;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author juan
 * @ClassName CompareJson
 * @Description TODO
 * @Date 2019/9/20
 * @Verison 1.0
 */
public class CompareJson {

    public static JSONObject compareJsonObjectEqual(JSONObject oldJsonStr, JSONObject newJsonStr1){
        JSONObject result = new JSONObject();
        Gson gson1 = new GsonBuilder().create();//or new Gson()
        JsonElement e1 = gson1.toJsonTree(oldJsonStr);
        Gson gson2 = new GsonBuilder().create();
        JsonElement e2 = gson2.toJsonTree(newJsonStr1);
        assert e1 != null;
        if (!e1.equals(e2)){
            result.put("result","不相等");
        }
        else{
            result.put("result","结果一致");
        }
        return result;
    }

    public static Map<String, Object> compareJsonObject1(String oldJsonStr, String newJsonStr1) {
        //将字符串转换为json对象
        JSON oldJson = null;
        JSON newJson = null;
        try {
            oldJson = JSON.parseObject(oldJsonStr);
            newJson = JSON.parseObject(newJsonStr1);
        }catch (JSONException e){
            System.out.println("json不正常格式:");
            System.out.println(oldJsonStr+"\n");
            System.out.println(newJsonStr1+"\n");
        }

        //递归遍历json对象所有的key-value，将其封装成path:value格式进行比较
        Map<String, Object> oldMap = new LinkedHashMap<String, Object>();
        Map<String, Object> newMap = new LinkedHashMap<String, Object>();
        convertJsonToMap(oldJson, "", oldMap);
        convertJsonToMap(newJson, "", newMap);
        Map<String, Object> differenceMap = compareMap(oldMap, newMap);
        //将最终的比较结果把不相同的转换为json对象返回
//        JSONObject jsonObject = convertMapToJson(differenceMap);
//        return jsonObject;
        return differenceMap;

    }

    public static JSONObject compareJsonObject(String oldJsonStr, String newJsonStr1) {
        //将字符串转换为json对象
        JSON oldJson = null;
        JSON newJson = null;
        try {
            oldJson = JSON.parseObject(oldJsonStr);
            newJson = JSON.parseObject(newJsonStr1);
        }catch (JSONException e){
            System.out.println("json不正常格式:");
            System.out.println(oldJsonStr+"\n");
            System.out.println(newJsonStr1+"\n");
        }

        //递归遍历json对象所有的key-value，将其封装成path:value格式进行比较
        Map<String, Object> oldMap = new LinkedHashMap<String, Object>();
        Map<String, Object> newMap = new LinkedHashMap<String, Object>();
        convertJsonToMap(oldJson, "", oldMap);
        convertJsonToMap(newJson, "", newMap);
        Map<String, Object> differenceMap = compareMap(oldMap, newMap);
        //将最终的比较结果把不相同的转换为json对象返回
        JSONObject jsonObject = convertMapToJson(differenceMap);
        return jsonObject;

    }


    public static JSONObject compareJsonObject(JSONObject oldJson, JSONObject newJson) {
        //将字符串转换为json对象、
        //递归遍历json对象所有的key-value，将其封装成path:value格式进行比较
        Map<String, Object> oldMap = new LinkedHashMap<String, Object>();
        Map<String, Object> newMap = new LinkedHashMap<String, Object>();
        convertJsonToMap(oldJson, "", oldMap);
        convertJsonToMap(newJson, "", newMap);
        Map<String, Object> differenceMap = compareMap(oldMap, newMap);
        //将最终的比较结果把不相同的转换为json对象返回
        JSONObject jsonObject = convertMapToJson(differenceMap);
        return jsonObject;
    }

    public JSONObject compareJsonOldContainNew(JSONObject oldJson, JSONObject newJson) {
        //将字符串转换为json对象、
        //递归遍历json对象所有的key-value，将其封装成path:value格式进行比较
        Map<String, Object> oldMap = new LinkedHashMap<String, Object>();
        Map<String, Object> newMap = new LinkedHashMap<String, Object>();
        convertJsonToMap(oldJson, "", oldMap);
        convertJsonToMap(newJson, "", newMap);
        Map<String, Object> differenceMap = compareMap(oldMap, newMap);
        //将最终的比较结果把不相同的转换为json对象返回
        JSONObject jsonObject = convertMapToJson(differenceMap);
        return jsonObject;
    }



    /**
     * 将json数据转换为map存储用于比较
     *
     * @param json
     * @param root
     * @param resultMap
     */
    public static void convertJsonToMap(Object json, String root, Map<String, Object> resultMap) {
        if (json instanceof JSONObject) {
            JSONObject jsonObject = ((JSONObject) json);
            Iterator iterator = jsonObject.keySet().iterator();
            while (iterator.hasNext()) {
                Object key = iterator.next();
                Object value = jsonObject.get(key);
                String newRoot = "".equals(root) ? key + "" : root + "." + key;
                if (value instanceof JSONObject) {
                    convertJsonToMap(value, newRoot, resultMap);
                }
                else {
                    resultMap.put(newRoot, value);
                }
            }
        }
//      else if (json instanceof JSONArray) {
//            int temp = JSON.DEFAULT_PARSER_FEATURE;
//            JSON.DEFAULT_PARSER_FEATURE = Feature.config(JSON.DEFAULT_PARSER_FEATURE, Feature.OrderedField, true);
//            JSONArray jsonArray = JSONArray.parseArray(json.toString());
//            JSON.DEFAULT_PARSER_FEATURE = temp;
////            JSONArray jsonArray = (JSONArray) json;
//            String newRoot = "".equals(root) ? key + "" : root + "." + key;
//            for (int i = 0; i < jsonArray.size(); i++) {
//                Object vaule = jsonArray.get(i);
//                String newRoot = "".equals(root) ? "[" + i + "]" : root + ".[" + i + "]";
//                if (vaule instanceof JSONObject || vaule instanceof JSONArray) {
//                    convertJsonToMap(vaule, newRoot, resultMap);
//                } else {
//                    resultMap.put(newRoot, vaule);
//                }
//            }
//        }
    }

    /**
     * 比较两个map，返回不同数据
     *
     * @param oldMap
     * @param newMap
     * @return
     */
    private static Map<String, Object> compareMap(Map<String, Object> oldMap, Map<String, Object> newMap) {
        //遍历newMap，将newMap的不同数据装进oldMap，同时删除oldMap中与newMap相同的数据
        compareNewToOld(oldMap, newMap);
        //將舊的有新的沒有的數據封裝數據結構存在舊的裡面
        compareOldToNew(oldMap);
        return oldMap;
    }

    /**
     * 將舊的有新的沒有的數據封裝數據結構存在舊的裡面
     * @param oldMap
     * @return
     */
    private static void compareOldToNew(Map<String, Object> oldMap) {
        //统一oldMap中newMap不存在的数据的数据结构，便于解析
        for (Iterator<Map.Entry<String, Object>> it = oldMap.entrySet().iterator(); it.hasNext(); ) {
            Map.Entry<String, Object> item = it.next();
            String key = item.getKey();
            Object value = item.getValue();
            int lastIndex = key.lastIndexOf(".");
            if (!(value instanceof Map)) {
                Map<String, Object> differenceMap = new HashMap<String, Object>();
                differenceMap.put("oldValue", value);
                differenceMap.put("newValue", "新key不存在");
                oldMap.put(key, differenceMap);
            }
        }
    }

    /**
     * 將新的map與舊的比較，並將數據統一存在舊的裡面
     * @param oldMap
     * @param newMap
     */
    private static void compareNewToOld(Map<String, Object> oldMap, Map<String, Object> newMap) {
        Map<String, Object> differenceMap = new HashMap<String, Object>();
        for (Iterator<Map.Entry<String, Object>> it = newMap.entrySet().iterator(); it.hasNext(); ) {
            Map.Entry<String, Object> item = it.next();
            String key = item.getKey();
            if (item.getValue() instanceof JSONArray){
                Map newValue = ObjectUtil.objectToMap(item.getValue());
                int lastIndex = key.lastIndexOf(".");
                String lastPath = key.substring(lastIndex + 1).toLowerCase();
                if (oldMap.containsKey(key)) {
                    if (filterKey(key)){
                        oldMap.remove(key);
                        continue;
                    }
                    Map oldValue = ObjectUtil.objectToMap(oldMap.get(key));
                    if ((null == newValue && null == oldValue) || (null != newValue && newValue.equals(oldValue))) {
                        oldMap.remove(key);
                    } else {
                        differenceMap.put("oldValue", oldValue);
                        differenceMap.put("newValue", newValue);
                        oldMap.put(key, differenceMap);
                    }
                } else {
                    differenceMap.put("oldValue", "key不存在");
                    differenceMap.put("newValue", newValue);
                    oldMap.put(key, differenceMap);
                }
            }
            else {
                Object newValue = item.getValue();
                int lastIndex = key.lastIndexOf(".");
                String lastPath = key.substring(lastIndex + 1).toLowerCase();
                if (oldMap.containsKey(key)) {
                    if (filterKey(key)){
                        oldMap.remove(key);
                        continue;
                    }
                    Object oldValue =oldMap.get(key);
                    if ((null == newValue && null == oldValue) || (null != newValue && newValue.equals(oldValue))) {
                        oldMap.remove(key);
                    } else {
                        differenceMap.put("oldValue", oldValue);
                        differenceMap.put("newValue", newValue);
                        oldMap.put(key, differenceMap);
                    }
                } else {
                    differenceMap.put("oldValue", "key不存在");
                    differenceMap.put("newValue", newValue);
                    oldMap.put(key, differenceMap);
                }
            }
        }
    }

    /**
     * 将已经找出不同数据的map根据key的层级结构封装成json返回
     *
     * @param map
     * @return
     */
    private static JSONObject convertMapToJson(Map<String, Object> map) {
        JSONObject resultJSONObject = new JSONObject();
        JSONObject resultJSONObject1 = new JSONObject();
        String tempath = "";
        for (Iterator<Map.Entry<String, Object>> it = map.entrySet().iterator(); it.hasNext(); ) {
            Map.Entry<String, Object> item = it.next();
            String key = item.getKey();
            Object value = item.getValue();
            String[] paths = key.split("\\.");
            int i = 0;
            Object remarkObject = null;//用於深度標識對象
            int indexAll = paths.length - 1;
            while (i <= paths.length - 1) {
                String path = paths[i];
                if (i == 0) {
                    //初始化对象标识
                    if (resultJSONObject.containsKey(path)) {
                        remarkObject = resultJSONObject.get(path);
                    } else {
                        if (indexAll > i) {
                            if (paths[i + 1].matches("\\[[0-9]+\\]")) {
                                remarkObject = new JSONArray();
                            } else {
                                remarkObject = new JSONObject();
                            }
                            resultJSONObject.put(path, remarkObject);
                        } else {
                            resultJSONObject.put(path, value);

                        }
                    }
                    i++;
                    continue;
                }
                if (path.matches("\\[[0-9]+\\]")) {//匹配集合对象
                    int startIndex = path.lastIndexOf("[");
                    int endIndext = path.lastIndexOf("]");
                    int index = Integer.parseInt(path.substring(startIndex + 1, endIndext));
                    if (indexAll > i) {
                        if (paths[i + 1].matches("\\[[0-9]+\\]")) {
                            while (((JSONArray) remarkObject).size() <= index) {
                                if(((JSONArray) remarkObject).size() == index){
                                    ((JSONArray) remarkObject).add(index,new JSONArray());
                                }else{
                                    ((JSONArray) remarkObject).add(null);
                                }
                            }
                        } else {
                            while(((JSONArray) remarkObject).size() <= index){
                                if(((JSONArray) remarkObject).size() == index){
                                    ((JSONArray) remarkObject).add(index,new JSONObject());
                                }else{
                                    ((JSONArray) remarkObject).add(null);
                                }
                            }
                        }
                        remarkObject = ((JSONArray) remarkObject).get(index);
                    } else {
                        while(((JSONArray) remarkObject).size() <= index){
                            if(((JSONArray) remarkObject).size() == index){
                                ((JSONArray) remarkObject).add(index, value);
                            }else{
                                ((JSONArray) remarkObject).add(null);
                            }
                        }
                    }
                } else {
                    if (indexAll > i) {
                        StringBuilder frontkey = new StringBuilder();
                        for(int x=0;x<i+1;x++){
                            frontkey.append(paths[x]).append(".");
                        }
                        if (paths[i + 1].matches("\\[[0-9]+\\]")) {
                            if ((!tempath.contains(frontkey))){
                                ((JSONObject) remarkObject).put(path, new JSONArray());
                            }
                        } else {
                            if ((!tempath.contains(frontkey))){
                                ((JSONObject) remarkObject).put(path, new JSONObject());
                            }
                        }
                        remarkObject = ((JSONObject) remarkObject).get(path);
                    } else {
                        ((JSONObject) remarkObject).put(path, value);
                    }
                }
                i++;

            }
            tempath = key;
        }
        return resultJSONObject;
    }

    /* *
     * 〈过滤字段不校验〉
     * @Param: [key]
     * @Return: java.lang.Boolean
     * @Author: xujuanjuan
     * @Date: 2019/9/21 上午11:17
     */
    private static Boolean filterKey(String key){
        JSONArray list = new JSONArray();
        list.add("code");

        //分享数据
        list.add("data.html.share.qDescTemplate");
        list.add("data.html.share.title");
        list.add("data.html.share.qqTemplate");
        list.add("data.html.share.titleTemplate");
        list.add("data.html.share.summary");
        list.add("data.html.share.timelineTemplate");
        list.add("data.html.share.summaryTemplate");
        list.add("data.html.share.timeline");
        list.add("data.html.share.qqZoneTemplate");
        //响应时间
        list.add("nowTime");
        //精选店铺拍品列表
        list.add("].liveInfo.playUrl");

        //用户管理
        list.add("data.user.sellerLevel");
        list.add("data.user.uid");
        list.add("data.user.tel");
        list.add("user.inviteUid");
//        list.add()

        list.add("].t");

        for(int i=0;i<list.size();i++){
            if (key.contains(list.getString(i))){
                return true;
            }
        }
        return false;
    }

}
