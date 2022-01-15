//Suppose an array of length n sorted in ascending order is rotated between 1 and n times. For example, the array nums = [0,1,2,4,5,6,7] might become:
//[4,5,6,7,0,1,2] if it was rotated 4 times.
//[0,1,2,4,5,6,7] if it was rotated 7 times.
//Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].
//Given the sorted rotated array nums of unique elements, return the minimum element of this array.

package Array.Level2.BinarySearch;

public class MinInRotatedSorted {
    private static int findMin(int[] ar){

        if(ar.length==1) return ar[0];
        //Approach1: Linear search
//        int min=Integer.MAX_VALUE;
//        for(int ele: ar) {
//            if(min>ele) min=ele;
//        }
//        return min;

        //Approach2: Binary search
        int low=0, high=ar.length-1;

        //check whether array is rotated or not
        if(ar[low]<ar[high]) return ar[low];

        while(low<high){
            int mid=low+(high-low)/2;

            if(ar[mid]>=ar[0]) low=mid+1;
            else high=mid;
        }
        return low;
    }
    public static void main(String[] args) {
        int[] ar={3,4,5,1,2};
        System.out.println("Minimum element: "+findMin(ar));
    }
}
