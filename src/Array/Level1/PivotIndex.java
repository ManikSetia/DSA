//Given an array of integers nums, calculate the pivot index of this array.
//The pivot index is the index where the sum of all the numbers strictly to the left of the index is equal to the sum of all the numbers strictly to the index's right.
//If the index is on the left edge of the array, then the left sum is 0 because there are no elements to the left. This also applies to the right edge of the array.
//Return the leftmost pivot index. If no such index exists, return -1.

package Array.Level1;

public class PivotIndex {
    private static int pivotIndex(int[] ar) {

        //Approach1: Pick a particular index and compare the sum on its left and right side
        //T.C O(n2) S.C O(1)
        // for(int i=0; i<ar.length; i++){
        //     if(findSum(ar, 0, i-1)==findSum(ar, i+1, ar.length-1)) return i;
        // }

        //Approach2: Use two arrays to save the sum on the left and right side of an element.
//         T.C O(n) S.C O(n)
//         int[] left=new int[ar.length];
//         int[] right=new int[ar.length];

//         left[0]=0;
//         right[ar.length-1]=0;

//         //filling left array
//         for(int i=1; i<ar.length; i++){
//             left[i]=ar[i-1]+left[i-1];
//         }

//         //filling right array
//         for(int i=ar.length-2; i>=0; i--){
//             right[i]=right[i+1]+ar[i+1];
//         }

//         //last loop to pick the pivot index
//         for(int i=0; i<ar.length; i++){
//             if(left[i]==right[i]) return i;
//         }

        //Approach3: Prefix sum
        //T.C O(n) S.C O(1)
        int sum=0, leftSum=0;
        for(int ele: ar) sum += ele;
        for(int i=0; i<ar.length; i++){
            int rightSum=sum-ar[i]-leftSum;
            if(leftSum==rightSum) return i;
            leftSum += ar[i];
        }
        return -1;
    }
    private static int findSum(int[] ar, int start, int end){
        int sum=0;
        for(int i=start; i<=end; i++) sum += ar[i];
        return sum;
    }
    public static void main(String[] args) {
        int[] ar={1,7,3,6,5,6};
        System.out.println("Pivot index: "+pivotIndex(ar));
    }
}