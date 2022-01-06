package Array;

import java.util.Arrays;

public class SortArrayByParity {

    public static int[] sortArrayByParity(int[] nums) {

        //Approach1: Use two helper arrays(even and odd): T.C O(n) S.C O(n)
        //Use loop to find the size of helper arrays
//        int evenSize=0, oddSize=0;
//        for(int i=0; i<nums.length; i++){
//            if((nums[i] & 1) == 0) evenSize++;
//            else oddSize++;
//        }
//        int[] evenAr=new int[evenSize];
//        int[] oddAr=new int[oddSize];
//
//        //Use the given array to fill the helper arrays
//        int j=0, k=0;
//        for(int i=0; i<nums.length; i++){
//            if((nums[i] & 1) == 0) evenAr[j++]=nums[i];
//            else oddAr[k++]=nums[i];
//        }
//
//        //Use the helper arrays to fill the given array into desired output and return it.
//        for(int i=0; i<evenAr.length; i++){
//            nums[i]=evenAr[i];
//        }
//
//        for(int i=0; i<oddAr.length; i++){
//            nums[evenSize++]=oddAr[i];
//        }

        //Approach2: Use two pointers to track even and old elements: T.C O(n) S.C O(1)
        int i=0, j=nums.length-1;
        while(j>i){
            if(checkOdd(nums[i]) && checkEven(nums[j])) swap(nums, i++, j--);
            else if(checkOdd(nums[i]) && checkOdd(nums[j])) j--;
            else i++;
        }

        return nums;
    }
    private static boolean checkOdd(int element){
        return (element & 1) == 1 ? true : false;
    }
    private static boolean checkEven(int element){
        return (element & 1) == 0 ? true : false;
    }
    private static void swap(int[] ar, int i, int j){
        int temp=ar[i];
        ar[i]=ar[j];
        ar[j]=temp;
    }

    public static void main(String[] args) {
        int[] ar={1,2,3,4,5,6,8};
        int[] result=sortArrayByParity(ar);
        System.out.println("After sorting by parity: "+ Arrays.toString(result));
    }
}
