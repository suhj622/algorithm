/**
 * 
 */
package com.suhj.jike.week9;

/**
 * @author Haojie
 * ����һ���ַ��� s �������ַ����еĴ�д��ĸת������ͬ��Сд��ĸ�������µ��ַ�����
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
