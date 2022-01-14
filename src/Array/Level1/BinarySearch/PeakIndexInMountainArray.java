//Let's call an array arr a mountain if the following properties hold:
//arr.length >= 3
//There exists some i with 0 < i < arr.length - 1 such that:
//arr[0] < arr[1] < ... arr[i-1] < arr[i]
//arr[i] > arr[i+1] > ... > arr[arr.length - 1]
//Given an integer array arr that is guaranteed to be a mountain, return any i such that arr[0] < arr[1] < ... arr[i - 1] < arr[i] > arr[i + 1] > ... > arr[arr.length - 1].

package Array.Level1.BinarySearch;

public class PeakIndexInMountainArray {
    private static int peakIndexInMountainArray(int[] ar) {

        //Approach1: Linear search
        // for(int i=1; i<ar.length-1; i++){
        //     if(ar[i]>ar[i-1] && ar[i]>ar[i+1]) return i;
        // }
        // return -1;

        //Approach2: Binary Search
        int low=0, high=ar.length-1;

        while(low<high){
            int mid=low+(high-low)/2;

            if(ar[mid]<ar[mid+1]) low=mid+1;
            else high=mid;//because we don't want to lose mid, that's why we didn't do mid-1
        }
        return low;
    }
    public static void main(String[] args) {
        int[] ar={3,5,3,2,0};
        System.out.println("Peak index: "+peakIndexInMountainArray(ar));
    }
}
