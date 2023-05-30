/**
 * 
 */
package com.suhj.jike.week5;

/**
 * �� D �����?����������
 * @author Haojie
 *
 */
public class ShipWithinDays {
/**
����?����?����������???�������?�?�?�?�?������days�������������?��������������
*/
    public int shipWithinDays(int[] weights, int days) {
        int min = weights[0];
        int max = weights[0];
        for(int i = 1; i < weights.length; i++){
            min = Math.max(min, weights[i]);
            max = max + weights[i];
        }
        while(min <= max){
            int mid = (max + min)/2;
            int count = 1;
            int transport = weights[0];
            for(int i = 1; i < weights.length; i++){
                if(transport + weights[i] <= mid){
                    transport = transport + weights[i];
                }else{
                    transport = weights[i];
                    count ++;
                }
                //�������������?�
                if( count > days){
                    break;
                }
            }
            if(count <= days){
                max = mid - 1;
            }else{
                min = mid + 1;
            }
        }

        return min;
    }	
	
}
