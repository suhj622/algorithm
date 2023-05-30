/**
 * 
 */
package com.suhj.jike.week9;

/**
 * @author Haojie
 * 给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中 最后一个 单词的长度。
 * 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串
 */
public class LengthOfLastWord {
	/**
	s = "   fly me   to   the moon  "
	解题思路：
	1. 对该字符串进行反向遍历，从遇到的第一个字母开始计数，中间出现非字母退出
	 */
    public int lengthOfLastWord(String s) {
        int ans = 0;
        int lastIndex = s.length() - 1;
        for(int i = lastIndex; i >= 0; i--){
            char c = s.charAt(i);
            if((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')){
                ans++;
            }else if(ans > 0) break;
        }
        return ans;
    }
}
