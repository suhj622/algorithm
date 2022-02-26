package com.suhj.jike.week1;
/**
 * �ϲ�������������
 * @author Haojie
 *
 */
class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        //�߽����⣺��������������һ��Ϊ������
        if( list1== null && list2== null){
            return null;
        }else if(list1 == null){
            return list2;
        }else if(list2 == null){
            return list1;
        }

        ListNode old1 = list1;
        ListNode old2 = list2;
        ListNode newHead;

        //ȷ��ͷ���
        if(old1.val <= old2.val){
            newHead = old1;
            old1 = old1.next;
        }else{
            newHead = old2;
            old2 = old2.next;
        }
        //��ʼ����ƴ�ӣ�˭Сƴ��˭
        //�������ƶ�����һ���ӿڣ����������ӽڵ���ƶ����µĽӿ�
        ListNode cur = newHead;
        while(old1 != null || old2 != null ){
            //��������1ȥ�ڵ������
            if( (old2 == null ) || ( old1 != null  &&  old2 != null &&  old1.val <= old2.val) ){
                cur.next = old1;
                old1 = old1.next;
                cur = cur.next;
            }else{
                cur.next = old2;
                old2 = old2.next;
                cur = cur.next;
            }
        }
        //���ص�ͷ���
        return newHead;

    }
}
