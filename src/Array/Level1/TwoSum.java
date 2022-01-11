//Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
//You may assume that each input would have exactly one solution, and you may not use the same element twice.
//You can return the answer in any order.

package Array.Level1;

import java.util.Arrays;

public class TwoSum {
    private static int[] twoSum(int[] ar, int target){
        int[] indices=new int[2];

        //Approach1: Use two loops.
        //T.C (n2) S.C O(1)
        for(int i=0; i<ar.length; i++){
            for(int j=i+1; j<ar.length; j++){
                if(ar[i]+ar[j]==target) {
                    indices[0]=i;
                    indices[1]=j;
                }
            }
        }
        return indices;
    }
    public static void main(String[] args) {
//        int[] ar={2,7,11,15};
//        int target=9;
//        int[] ar={3,2,4};
//        int target=6;
        int[] ar={3,3};
        int target=6;
        int[] result=twoSum(ar, target);
        System.out.println(Arrays.toString(result));
    }
}
