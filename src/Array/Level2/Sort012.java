//Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
//We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.

package Array.Level2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Sort012 {
    private static void sortColors(int[] ar){

        //Approach1: Sorting
        //T.C (nlogn) S.C O(1)
//        Arrays.sort(ar);

        //Approach2: Counting sort
        //T.C O(2n) S.C O(1)
//         int count0=0, count1=0, count2=0;
//
//         for(int ele: ar){
//             if(ele==0) count0++;
//             else if(ele==1) count1++;
//             else count2++;
//         }
//
//         for(int i=0; i<count0; i++) ar[i]=0;
//
//         for(int i=count0; i<count0+count1; i++) ar[i]=1;
//
//         for(int i=count0+count1; i<ar.length; i++) ar[i]=2;

        //Approach3: Three pointer or Dutch National Flag Algorithm
        //T.C O(n) S.C O(1)
        int low=0, mid=0, high=ar.length-1;
        while(mid<=high){
            if(ar[mid]==0) swap(ar, low++, mid++);
            else if(ar[mid]==1) mid++;
            else swap(ar, mid, high--);
        }
        System.out.println(Arrays.toString(ar));
    }
    private static void swap(int[] ar, int i, int j){
        int temp=ar[i];
        ar[i]=ar[j];;
        ar[j]=temp;

    }
    public static void main(String[] args) {
        int[] ar={2,0,2,1,1,0};
        sortColors(ar);
    }
}
