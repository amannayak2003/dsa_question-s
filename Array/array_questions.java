package Array;

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
    
}