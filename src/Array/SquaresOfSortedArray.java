//Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.

package Array;

import java.util.Arrays;

public class SquaresOfSortedArray {
    private static int[] sortedSquares(int[] ar){

        //Approach1: First do squares of all elements and then sort it.
        //T.C O(nlogn) S.C.O(1)
        for(int i=0; i<ar.length; i++){
            ar[i] *= ar[i];
        }
        Arrays.sort(ar);
        return ar;
    }
    public static void main(String[] args) {
//        int[] ar={-4,-1,0,3,10};
        int[] ar={-7,-3,2,3,11};
        System.out.println("Squares of each number in sorted fashion: "+ Arrays.toString(sortedSquares(ar)));
    }
}
