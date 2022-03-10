package com.suhj.jike.week3;

import java.util.ArrayList;
import java.util.List;
/**
 * 
 * @author Haojie
 * 合并K个升序链表
 */
public class MergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {

        lists = removeNullNode(lists);

        int length = lists.length;
        if(length == 0) return null;
        if(length == 1) return lists[0];

        ListNode minNode = lists[0] ;
        int minIndex = 0;
        for(int i = 1 ; i < length; i++){
            if(minNode.val > lists[i].val){
                minNode =  lists[i];
                minIndex = i;                
            }
        }

        lists[minIndex] = lists[minIndex].next; 
        minNode.next = mergeKLists(lists);
        return minNode;
    
    }

    public ListNode[] removeNullNode(ListNode[] lists){
        List<ListNode> newLists = new ArrayList<>();
        for(ListNode node:lists){
            if(node != null) newLists.add(node);
        }
        return newLists.toArray(new ListNode[newLists.size()]);
    }
}
/**
 * Definition for singly-linked list.
 */
   class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

