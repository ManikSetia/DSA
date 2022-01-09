//Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
//There is only one repeated number in nums, return this repeated number.

package Array.Level2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindTheDuplicateNumber {
    private static int findDuplicate(int[] ar){
        int duplicateNumber=0;

        //Approach1: Sorting and then compare the adjacent elements.
        //T.C O(nlogn) S.C O(1)
//        Arrays.sort(ar);
//        for(int i=0; i<ar.length-1; i++){
//            if(ar[i]==ar[i+1]) duplicateNumber=ar[i];
//        }

        //Approach2: Use Map
        //T.C O(n) S.C O(n)
//        Map<Integer, Integer> map=new HashMap<>(ar.length);
//
//        //create frequency map
//        for(int ele: ar){
//            map.put(ele, map.getOrDefault(ele, 0)+1);
//        }
//
//        //check count, if it is equal to 2 then return the key.
//        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
//            if(entry.getValue()>1) duplicateNumber=entry.getKey();
//        }

        //Approach3: If elements are from [1, n-1]. So we'll XOR the given array with all elements from [1, n] then we'll left with the duplicate element.
        //T.C O(n) S.C O(1)
        //first loop to XOR all the elements of given array
//        for(int ele: ar){
//            duplicateNumber ^= ele;
//        }
//
//        //second loop to XOR the resultant with all the elements from [1, n]
//        for(int element=1; element<ar.length; element++){
//            duplicateNumber ^= element;
//        }

        //Approach4: Negative marking.
        // Since array consists of positive numbers. So, for every element, we'll mark the element present at its index as negative. If we encounter a negative number that means we've encounter that element before and then we'll return that element.
        //T.C O(n) S.C O(1)
        for(int i=0; i<ar.length; i++){
            int index=Math.abs(ar[i]);
            if(ar[index] < 0) duplicateNumber=index;
            ar[index] = -ar[index];
        }

        return duplicateNumber;
    }
    public static void main(String[] args) {
        int[] ar={1,3,4,2,2};
//        int[] ar={3,1,3,4,2};
        int duplicateNumber=findDuplicate(ar);
        System.out.println("Duplicate number is: "+duplicateNumber);
    }
}
