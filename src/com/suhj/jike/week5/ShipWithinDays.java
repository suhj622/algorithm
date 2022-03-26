/**
 * 
 */
package com.suhj.jike.week5;

/**
 * 在 D 天内送达包裹的能力
 * @author Haojie
 *
 */
public class ShipWithinDays {
/**
解题思路：从船的运载量的角度，利用二分的思想，找到一个能在days天内运输完所有包裹的最低运载量
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
                //天数超过立即退出
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
