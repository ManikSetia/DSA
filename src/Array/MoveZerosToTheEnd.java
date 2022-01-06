package Array;

import java.util.Arrays;

public class MoveZerosToTheEnd {

    public static void moveZeroes(int[] nums) {

        //Approach1: Use an extra array to collect all the non-zero elements.
        //T.C O(n), S.C. O(n)
        //using loop to determine the size of new array which we want
//         int size=0;
//         for(int i=0; i<nums.length; i++){
//             if(nums[i]!=0) size++;
//         }
//         int[] ar=new int[size];

//         //using loop to collect all the non-zero elements
//         int j=0;
//         for(int i=0; i<nums.length; i++){
//             if(nums[i]!=0) ar[j++]=nums[i];
//         }

//         //now our helper array is ready, we can safely copy all the non-zero elements in the starting of our given array using our helper array
//         for(int i=0; i<ar.length; i++){
//             nums[i]=ar[i];
//         }

//         //now we just left with inserting 0 to the rest of the array
//         for(int i=ar.length; i<nums.length; i++){
//             nums[i]=0;
//         }

        //Approach2: T.C O(n) S.C O(1)
        int i=0;
        for(int j=1; j<nums.length; j++){
            if(nums[i]==0 && nums[j]!=0){
                swap(nums, i++, j);
            }
            if(nums[i]!=0) i++;
        }
    }
    private static void swap(int[] ar, int i, int j){
        int temp=ar[i];
        ar[i]=ar[j];
        ar[j]=temp;
    }

    public static void main(String[] args) {
        int[] ar={0,1,0,3,12};
        moveZeroes(ar);
        System.out.println("After moving zeros to the end: "+ Arrays.toString(ar));
    }
}
