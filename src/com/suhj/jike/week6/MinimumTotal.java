/**
 * 
 */
package com.suhj.jike.week6;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Haojie
 * 解题思路：
 * 1. 对于 f[m][n],
    如果 n = 0, 则 f[m][n] = f[m - 1][n] + triangle[m][n]
    如果 m > 0，则 f[m][n] = min(f[m-1][n] + triangle[m][n], f[m-1][n-1] + triangle[m][n]);
    如果 n == n，则 f[m][n] = f[m-1][n-1] + triangle[m][n]
 */
public class MinimumTotal {
	
    public int minimumTotal(List<List<Integer>> triangle) {
    	
        List<List<Integer>> list = new ArrayList<>();
        
        for(int m = 0; m < triangle.size(); m ++){
            List<Integer> current = new ArrayList<>();
            for(int n = 0; n < triangle.get(m).size(); n++){
                int num = triangle.get(m).get(n);
                if(m == 0 && n == 0) current.add(num);
                else if(n == 0) current.add(list.get(m - 1).get(n) + num);
                else if(n == triangle.get(m).size() - 1) current.add(list.get(m - 1).get(n - 1) + num);
                else current.add(Math.min(list.get(m-1).get(n) + num, list.get(m-1).get(n-1) + num));
            }
            list.add(current);
        }
        
        int lastRow = list.size() - 1;
        
        int minimumTotal = list.get(lastRow).get(0);
        
        for(int i = 1; i < list.get(lastRow).size(); i++){
            minimumTotal = Math.min(minimumTotal, list.get(lastRow).get(i));
        }
        
        return minimumTotal;
    }
}
