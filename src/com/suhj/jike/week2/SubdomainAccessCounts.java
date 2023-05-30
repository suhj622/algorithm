/**
 * 
 */
package com.suhj.jike.week2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * @author Haojie
 * 811. 子域名访问计数
 */
public class SubdomainAccessCounts {
    public List<String> subdomainVisits(String[] cpdomains) {

        HashMap<String, Integer> domainMap = new HashMap<>();
        //1. 遍历字符串数组
        String subdomain = null;
        String[] elements = null;
        for(String cpdomain:cpdomains){
            //1.1 对每一个元素按空格切割，第一个元素是访问次数，第二个元素是网址域名
            elements = cpdomain.split(" ");
            addToHashMap(domainMap, elements[1], Integer.valueOf(elements[0]));
            //1.2 对网站域名按dot号进行切割，返回一个字符数组
            String[] subdomains = elements[1].split("\\.");
            //1.3 从最后一个元素遍历到第二个元素，拼接子域名
            subdomain = "";
            for(int i = subdomains.length - 1 ; i > 0; i--){
                if(subdomain.length() > 0){
                    subdomain = subdomains[i] + "." + subdomain;
                }else{
                    subdomain = subdomains[i];
                }
                addToHashMap(domainMap, subdomain, Integer.valueOf(elements[0]));
            }
        }

        //2. 返回拼接结果
        return mapToList(domainMap);
    }

    /** add the reuslt keyvalue<key, value> into the map*/
    public void addToHashMap(HashMap<String, Integer> domainMap, String domain, Integer visitCnt){
        if(domainMap.containsKey(domain)){
            domainMap.put(domain, domainMap.get(domain) + visitCnt);
        }else{
            domainMap.put(domain, visitCnt);
        }
    }

    /**trans a map into a list which every element like ["key www.xxx.com"] */
    public List<String> mapToList(HashMap<String, Integer> domainMap){
        Set<String> keySet = domainMap.keySet();
        List<String> list = new ArrayList<String>();
        for(String key:keySet){
            list.add(domainMap.get(key) + " " + key);
        }
        return list;
    }
}
