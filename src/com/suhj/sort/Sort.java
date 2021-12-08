/**
 * 
 */
package com.suhj.sort;

/**
 * @author Haojie
 * 
 * ������
 */
public class Sort {
	
	/**
	 * �������������ѡ������
	 * @param arr
	 */
	public static void SelectSort(int[] arr) {
		//0   0--N-1
		//1   1--N-1
		//2   2--N-1
		//......
		//N-2 N-2--N-1
		//N-1 ֻʣһ��Ԫ�أ�����Ҫ�ҳ���С��Ԫ��		
		int end = arr.length - 1;
		for(int i = 0; i < end ; i ++ ) {
			int minPos = i;
			for (int j = i + 1; j <= end; j++) {
				minPos = arr[minPos] > arr[j] ? j : minPos;
			}
			swap(arr, i, minPos);
		}
	}

	/**
	 * ��������������Ԫ�ص�λ��
	 * @param arr  ����
	 * @param i    Ԫ������1
	 * @param minPos Ԫ������2
	 */
	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;		
	}
	
	/**
	 * ���Է���
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = {17, 1, 9, 4, 70, 58, 26, 99, 10};
		int[] copy = copyArr(arr);
		SelectSort(arr);
		print(copy);
		print(arr);
	}
	
	/**
	 * ��������ķ���
	 * @param arr
	 * @return
	 */
	public static int[] copyArr(int[] arr) {
		int[] copy = new int[arr.length];
		int end = arr.length - 1;
		for(int i = 0; i <= end; i++ ) {
			copy[i] = arr[i];
		}
		return copy;
	}

	/**
	 * ��ӡ����
	 * @param arr
	 */
	private static void print(int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
			
			if (i != arr.length - 1) System.out.print(" ");
			else System.out.println();
		}
		
	}
}
