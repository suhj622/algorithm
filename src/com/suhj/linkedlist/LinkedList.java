/**
 * 
 */
package com.suhj.linkedlist;

/**
 * @author Haojie
 * 单链表，V 表示传入的类型
 */
public class LinkedList<V> {
	
	//属性：头指针、尾指针、节点个数
	//头指针与尾指针都是指向节点的引用
	private Node head;
	private Node tail;
	private int size;
	
	//内部封装一个节点类
	//拥有属性：值与next指针
	public class Node{
		public V value;
		public Node next;
		public Node(V value) {
			this.value = value;
			//next在链表操作时才能确定
			this.next = null; 
		}
	}
	
	/**
	 * 初始化单链表，此时值与指针均为null
	 */
	public LinkedList() {
		head = null;
		tail = null;
		size = 0;
	}
	
	/**
	 * 
	 * @param node
	 */
	public void add(V v) {
		Node node = new Node(v);
		if(head==null) {
			head = node;
			tail = node;
		}else {
			tail.next = node;
			tail = node;
		}
		this.size ++;
	}
	
	/**
	 * 展示链表的所有元素
	 */
	private void show() {
		Node index = head;
		while(index != null) {
			System.out.println(index.value);
			index = index.next;
		}
		
	}	
	

	/**
	 * 测试
	 * @param args
	 */
	public static void main(String[] args) {
		LinkedList<Integer> linkedList = new LinkedList<Integer>();
		linkedList.add(1);
		linkedList.add(2);
		linkedList.add(3);
		linkedList.add(4);
		linkedList.add(5);
		linkedList.show();
	}


	
	
	
}
