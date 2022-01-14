//Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
//If target is not found in the array, return [-1, -1].

package Array.Level2.BinarySearch;

import java.util.Arrays;

public class FirstAndLastPositionOfElement {
    private static int[] searchRange(int[] ar, int target){
        int low=0, high=ar.length-1;

        //find the first occurrence of the element
        int firstOccurrence=-1;//since index can't be negative, that's why initialized with -1.
        while(low<=high){
            int mid=low+(high-low)/2;
            if(ar[mid]<target) low=mid+1;
            else if(ar[mid]>target) high=mid-1;
            else {
                //ar[mid]==target
                firstOccurrence=mid;
                high=mid-1;
            }
        }

        //find the right most occurrence of the element
        int lastOccurrence=-1;
        low=0; high=ar.length-1;

        while(low<=high){
            int mid=low+(high-low)/2;

            if(ar[mid]<target) low=mid+1;
            else if(ar[mid]>target) high=mid-1;
            else{
                //go to right to find the right most occurrence
                lastOccurrence=mid;
                low=mid+1;
            }
        }

        return new int[] {firstOccurrence, lastOccurrence};
    }
    public static void main(String[] args) {
//        int[] ar={5,7,7,8,8,10};
        int[] ar={1,8,8};
        int target=8;
        int[] result=searchRange(ar, target);
        System.out.println("First and last position of "+target+" are respectively: "+ Arrays.toString(result));
    }
}
