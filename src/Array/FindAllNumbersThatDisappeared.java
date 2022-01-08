//Given an array nums of n integers where nums[i] is in the range [1, n], return an array of all the integers in the range [1, n] that do not appear in nums.

package Array;

import java.util.ArrayList;
import java.util.List;

public class FindAllNumbersThatDisappeared {
    private static List<Integer> findDisappearedNumbers(int[] ar){
        List<Integer> result=new ArrayList<>();

        //Approach1: Use a helper array to find which numbers are missing.
        //T.C O(n) S.C O(n)
        int[] helperAr=new int[ar.length+1];//ar.length+1 is used because we want elements from 1 to size of array
        for(int i=0; i<ar.length; i++){
            helperAr[ar[i]]++;
        }

        //now helperAr is ready, we just left with iteration in this array to find the missing elements in the given array
        for(int i=1; i<helperAr.length; i++){//index started from 0 as we want elements from 1 to size of array
            if(helperAr[i]==0) result.add(i);
        }

        return result;
    }
    public static void main(String[] args) {
//        int[] ar={4,3,2,7,8,2,3,1};
        int[] ar={1,1};
        List<Integer> findNumbers=findDisappearedNumbers(ar);
        System.out.println("Numbers that disappeared: "+findNumbers);
    }
}
