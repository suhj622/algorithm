/**
 * 
 */
package com.suhj.jike.week9;

/**
 * @author Haojie
 * 给你一个字符串 s ，将该字符串中的大写字母转换成相同的小写字母，返回新的字符串。
 */
public class ToLowerCase {
    public String toLowerCase(String s) {
        StringBuilder ans = new StringBuilder();
        for(char c:s.toCharArray()){
            if(c >= 'A' && c <= 'Z'){
                c |=  32;
            }
            ans.append(c);
        }
        return ans.toString();
    }
}
