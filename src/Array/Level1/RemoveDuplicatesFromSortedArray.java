package Array.Level1;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray {

    public static void removeDuplicates(int[] nums) {
//        HashSet<Integer> hashSet=new HashSet<>();
//        for(int ele: nums){
//            hashSet.add(ele);
//        }
//        int i=0;
//        for(int ele: hashSet){
//            nums[i++]=ele;
//        }
        int i=0;
        for(int j=1; j<nums.length; j++){
            if(nums[i]!=nums[j]){
                i++;
                nums[i]=nums[j];
            }
        }
    }

    public static void main(String[] args) {
        int[] ar={-3,-1,0,0,0,3,3};
        System.out.println(Arrays.toString(ar));
        removeDuplicates(ar);
        System.out.println(Arrays.toString(ar));
    }
}
