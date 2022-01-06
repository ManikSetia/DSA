package Array;

import java.util.Arrays;

public class SortArrayByParity {

    public static int[] sortArrayByParity(int[] nums) {

        //Approach1: Use two helper arrays(even and odd): T.C O(n) S.C O(n)
        //Use loop to find the size of helper arrays
        int evenSize=0, oddSize=0;
        for(int i=0; i<nums.length; i++){
            if((nums[i] & 1) == 0) evenSize++;
            else oddSize++;
        }
        int[] evenAr=new int[evenSize];
        int[] oddAr=new int[oddSize];

        //Use the given array to fill the helper arrays
        int j=0, k=0;
        for(int i=0; i<nums.length; i++){
            if((nums[i] & 1) == 0) evenAr[j++]=nums[i];
            else oddAr[k++]=nums[i];
        }

        //Use the helper arrays to fill the given array into desired output and return it.
        for(int i=0; i<evenAr.length; i++){
            nums[i]=evenAr[i];
        }

        for(int i=0; i<oddAr.length; i++){
            nums[evenSize++]=oddAr[i];
        }

        return nums;
    }

    public static void main(String[] args) {
        int[] ar={3,1,2,4};
        int[] result=sortArrayByParity(ar);
        System.out.println("After sorting by parity: "+ Arrays.toString(result));
    }
}
