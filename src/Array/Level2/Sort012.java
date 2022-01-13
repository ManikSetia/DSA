//Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
//We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.

package Array.Level2;

import java.util.Arrays;

public class Sort012 {
    private static void sortColors(int[] ar){

        //Approach1: Sorting
        //T.C (nlogn) S.C O(1)
        Arrays.sort(ar);

        System.out.println(Arrays.toString(ar));
    }
    public static void main(String[] args) {
        int[] ar={2,0,2,1,1,0};
        sortColors(ar);
    }
}
