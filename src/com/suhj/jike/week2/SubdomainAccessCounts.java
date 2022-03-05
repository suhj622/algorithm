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
 * 811. ���������ʼ���
 */
public class SubdomainAccessCounts {
    public List<String> subdomainVisits(String[] cpdomains) {

        HashMap<String, Integer> domainMap = new HashMap<>();
        //1. �����ַ�������
        String subdomain = null;
        String[] elements = null;
        for(String cpdomain:cpdomains){
            //1.1 ��ÿһ��Ԫ�ذ��ո��и��һ��Ԫ���Ƿ��ʴ������ڶ���Ԫ������ַ����
            elements = cpdomain.split(" ");
            addToHashMap(domainMap, elements[1], Integer.valueOf(elements[0]));
            //1.2 ����վ������dot�Ž����и����һ���ַ�����
            String[] subdomains = elements[1].split("\\.");
            //1.3 �����һ��Ԫ�ر������ڶ���Ԫ�أ�ƴ��������
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

        //2. ����ƴ�ӽ��
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
