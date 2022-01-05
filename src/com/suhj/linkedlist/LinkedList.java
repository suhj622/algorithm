/**
 * 
 */
package com.suhj.linkedlist;

/**
 * @author Haojie
 * ������V ��ʾ���������
 */
public class LinkedList<V> {
	
	//���ԣ�ͷָ�롢βָ�롢�ڵ����
	//ͷָ����βָ�붼��ָ��ڵ������
	private Node head;
	private Node tail;
	private int size;
	
	//�ڲ���װһ���ڵ���
	//ӵ�����ԣ�ֵ��nextָ��
	public class Node{
		public V value;
		public Node next;
		public Node(V value) {
			this.value = value;
			//next���������ʱ����ȷ��
			this.next = null; 
		}
	}
	
	/**
	 * ��ʼ����������ʱֵ��ָ���Ϊnull
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
	 * չʾ���������Ԫ��
	 */
	private void show() {
		Node index = head;
		while(index != null) {
			System.out.println(index.value);
			index = index.next;
		}
		
	}	
	

	/**
	 * ����
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
