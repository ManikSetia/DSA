//A school is trying to take an annual photo of all the students. The students are asked to stand in a single file line in non-decreasing order by height. Let this ordering be represented by the integer array expected where expected[i] is the expected height of the ith student in line.

//You are given an integer array heights representing the current order that the students are standing in. Each heights[i] is the height of the ith student in line (0-indexed).

//Return the number of indices where heights[i] != expected[i].

package Array;

import java.util.Arrays;

public class HeightChecker {
    public static int heightChecker(int[] ar) {
        int count = 0;

        //Approach1: Use an exact cloned helper array, we'll sort it and then compare the indices with the original array
        //T.C O(nlogn) S.C O(n)
//        int[] helperAr=new int[ar.length];
//        System.arraycopy(ar, 0, helperAr, 0, ar.length);
//        Arrays.sort(helperAr);
//
//        //comparing starts
//        for(int i=0; i<ar.length; i++){
//            if (ar[i] != helperAr[i]) count++;
//        }

//        return count;

        //Approach2: Make a helper array in which store the occurrence of elements of the initial array.
        int[] frequency=new int[101];
        for(int i=0; i<ar.length; i++){
            frequency[ar[i]]++;
        }

        int givenArrayIndex=0;
        for(int i=0; i<frequency.length; i++){
            if(givenArrayIndex<ar.length){
                while(frequency[i]!=0){
                    int pickedElement=i;
                    frequency[i]--;//we've used that element. Now compare it with the original array.
                    if(pickedElement!=ar[givenArrayIndex]) count++;
                    givenArrayIndex++;//shift to next element in the given array.
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int[] ar={2,1,2,1,1,2,2,1};
//        int[] ar={5,1,2,3,4};
        int numberOfIndices=heightChecker(ar);
        System.out.println("Number of indices: "+numberOfIndices);
    }
}
