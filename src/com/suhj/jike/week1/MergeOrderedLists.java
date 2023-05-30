package com.suhj.jike.week1;
/**
 * 合并两个有序链表
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

public class MergeOrderedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        //边界问题：两个链表至少有一个为空链表
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

        //确定头结点
        if(old1.val <= old2.val){
            newHead = old1;
            old1 = old1.next;
        }else{
            newHead = old2;
            old2 = old2.next;
        }
        //开始进行拼接，谁小拼接谁
        //老链表移动到下一个接口，新链表连接节点后，移动至新的接口
        ListNode cur = newHead;
        while(old1 != null || old2 != null ){
            //能在链表1去节点的条件
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
        //返回的头结点
        return newHead;

    }
}
