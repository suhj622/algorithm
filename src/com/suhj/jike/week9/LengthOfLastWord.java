/**
 * 
 */
package com.suhj.jike.week9;

/**
 * @author Haojie
 * ����һ���ַ��� s�������ɵ�����ɣ�����ǰ����һЩ�ո��ַ������������ַ����� ���һ�� ���ʵĳ��ȡ�
 * ���� ��ָ������ĸ��ɡ��������κοո��ַ���������ַ���
 */
public class LengthOfLastWord {
	/**
	s = "   fly me   to   the moon  "
	����˼·��
	1. �Ը��ַ������з���������������ĵ�һ����ĸ��ʼ�������м���ַ���ĸ�˳�
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
