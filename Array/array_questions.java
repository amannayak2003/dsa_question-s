package Array;

import java.util.HashSet;
import java.util.Set;

public class array_questions {

    public static void main(String[] args) {
        int arr[] = {1,2,2,1,1,1};

        System.out.println(findMajorityElement(arr));
    }
    public static int findMajorityElement(int[] array) {
        int count = 0;
        int candidate = 0;
        
        for (int num : array) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }
        
        return candidate;
    }

    public int[] findMissingAndRepeatedValues(int[][] grid) {
        
        Set<Integer> set = new HashSet<>();
        int[] result = new int[2];
        int sum2 = 0;
        for(int i = 0;i<grid.length;i++){
            for(int j = 0;j<grid[0].length;j++){
                sum2 += grid[i][j];
                if(set.add(grid[i][j])==false){
                    result[0] = grid[i][j];
                }else{
                    set.add(grid[i][j]);
                }
            }
        }
        int sum1 = 0 ;
        for (int i = 1; i <= grid.length*grid[0].length; i++) {
            sum1 += i;
        }

        result[1] = sum1 - (sum2-result[0]);

        return result;

    }
    
    
}