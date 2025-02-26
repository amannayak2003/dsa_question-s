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
    
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m-1;
        int j = n-1;
        int c = m+n-1;
        while(i>=0&&j>=0){
            if(nums1[i]>nums2[j]){
                nums1[c--] = nums1[i--]; 
            }
            else{
                nums1[c--] = nums2[j--];
            }
        }
        while(j>=0){
            nums1[c--] = nums2[j--];
        }
    }
    
    public int maxProfit(int[] prices) {
        int max_profit = 0 ;
        int buy_price = prices[0];
        for(int i = 1;i<prices.length;i++){
            if(prices[i]>buy_price){
                max_profit = Math.max(max_profit, prices[i]-buy_price);
            }
            else{
                if(buy_price>prices[i]){
                    buy_price = prices[i];
                }
            }
        }
        return max_profit;
    }

    public int singleNumber(int[] arr) {
        int num = arr[0];
        for(int i = 1 ;i<arr.length;i++){
            // xor 
            num = num^arr[i];
        }
        return num;
    }

    public int maxSubArray(int[] nums) {
        if (nums.length == 0) return 0; // Edge case: Empty array
        
        int max = nums[0];  // Initialize with first element
        int count = nums[0]; // Start with first element
        
        for (int i = 1; i < nums.length; i++) {
            count = Math.max(nums[i], count + nums[i]); // Continue or start new subarray
            max = Math.max(max, count); // Update max if needed
        }
        
        return max;
    }

    public double myPow(double x, int n) {
        long binary = n;
        double ans = 1;
        if (n < 0) {
            binary = -binary;
            x = 1 / x;
        }

        while (binary > 0) {
            if (binary % 2 == 1) {
                ans *= x;
            }
            x = x * x;
            binary /= 2;
        }

        return ans;
    }

    public void sortColors(int[] nums) {
       int low = 0; int mid = 0; int high = nums.length-1;
       while(mid<=high){
           if(nums[mid]==0){
               int temp = nums[low];
               nums[low] = nums[mid];
               nums[mid] = temp;
               low++;
               mid++;
           }
           else if(nums[mid]==1){
            mid++;
           }
           else{
               int temp = nums[mid];
               nums[mid] = nums[high];
               nums[high] = temp;
               high--;
           }
       }
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int r = matrix.length;
        int c = matrix[0].length;
        
        int low = 0, high = r - 1, row = -1;
        
        // Step 1: Binary Search to Find the Correct Row
        while (low <= high) {
            int mid = (low + high) / 2;
            if (matrix[mid][0] <= target && matrix[mid][c - 1] >= target) {
                row = mid;
                break;
            } else if (matrix[mid][c - 1] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        // If row is not found, target is not present
        if (row == -1) return false;

        // Step 2: Binary Search Within the Found Row
        int low2 = 0, high2 = c - 1;
        while (low2 <= high2) {
            int mid2 = (low2 + high2) / 2;
            if (matrix[row][mid2] == target) {
                return true;
            } else if (matrix[row][mid2] < target) {
                low2 = mid2 + 1;
            } else {
                high2 = mid2 - 1;
            }
        }

        return false;
    }
}