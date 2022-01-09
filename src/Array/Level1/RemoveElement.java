//Given an integer array nums and an integer val, remove all occurrences of val in nums in-place. The relative order of the elements may be changed.

package Array.Level1;

import java.util.Arrays;

public class RemoveElement {

    public static int removeElement(int[] nums, int val) {
        int i=0;
        for (int j=0; j<nums.length; j++){
            if(nums[j]!=val) nums[i++]=nums[j];
        }
        return i;
    }

    public static void main(String[] args) {
        int[] ar={0,1,2,2,3,0,4,2};
        int result=removeElement(ar,2);
        System.out.println("After removing the element: "+ Arrays.toString(ar));
    }
}
