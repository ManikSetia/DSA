//Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.

package Array;

import java.util.Arrays;

public class SquaresOfSortedArray {
    private static int[] sortedSquares(int[] ar){

        //Approach1: First do squares of all elements and then sort it.
        //T.C O(nlogn) S.C.O(1)
//        for(int i=0; i<ar.length; i++){
//            ar[i] *= ar[i];
//        }
//        Arrays.sort(ar);
//        return ar;


        //Approach2: Two-pointer
        //T.C O(n) S.C O(n)
        //Idea is to have two pointers. First on smallest/first positive number and second on last negative element. Then start comparing the squares of the two and put in a helper array.
        int[] helperAr=new int[ar.length];

        //Find the correct position of two pointers
        int positivePointer=0, negativePointer;
        while(positivePointer<ar.length && ar[positivePointer]<0) positivePointer++;
        negativePointer=positivePointer-1;

        int counter=0;//to track the elements of helper array

        //now start comparing the squares of elements
        while(negativePointer>=0 && positivePointer<ar.length){
            if(ar[positivePointer] * ar[positivePointer] < ar[negativePointer] * ar[negativePointer]) {
                helperAr[counter++] = ar[positivePointer] * ar[positivePointer];
                positivePointer++;
            }
            else {
                helperAr[counter++] = ar[negativePointer] * ar[negativePointer];
                negativePointer--;
            }
        }

        //to cover the remaining cases
        while(negativePointer>=0) {
            helperAr[counter++]=ar[negativePointer] * ar[negativePointer];
            negativePointer--;
        }
        while(positivePointer<ar.length){
            helperAr[counter++] = ar[positivePointer] * ar[positivePointer];
            positivePointer++;
        }

        return helperAr;
    }
    public static void main(String[] args) {
//        int[] ar={-4,-1,0,3,10};
//        int[] ar={-7,-3,2,3,11};
        int[] ar={-5,-4,-3,-2,-1};
        System.out.println("Squares of each number in sorted fashion: "+ Arrays.toString(sortedSquares(ar)));
    }
}
