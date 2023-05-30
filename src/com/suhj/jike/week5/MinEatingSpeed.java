package com.suhj.jike.week5;
/**
 * 爱吃香蕉的珂珂
 * @author Haojie
 *
 */
public class MinEatingSpeed {
/**
二分思想
*/	
    public int minEatingSpeed(int[] piles, int h) {
        
        int max = piles[0];
        for(int i = 1; i < piles.length; i++){
            max = Math.max(max, piles[i]);
        }
        int min = max/h == 0 ? 1 : max/h;

        while(min <= max){
            int mid = (max + min)/2;
            int count = 0;
            for(int i = 0; i < piles.length; i ++){
                if(piles[i]%mid > 0){
                    count += piles[i]/mid + 1;
                }else{
                    count += piles[i]/mid;
                }
                if(count > h) break;
            }

            if(count <= h){
                max = mid - 1;
            }else{
                min = mid + 1;
            }

        }
        return min;
    }
}
