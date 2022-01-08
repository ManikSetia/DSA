//Given an array nums of n integers where nums[i] is in the range [1, n], return an array of all the integers in the range [1, n] that do not appear in nums.

package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllNumbersThatDisappeared {
    private static List<Integer> findDisappearedNumbers(int[] ar){
        List<Integer> result=new ArrayList<>();

        //Approach1: Use to for loops to find the missing numbers.
        //Hint: Use the given constraint; [1,n]
        //T.C O(n2) S.C O(1)
//        for(int element=1; element<=ar.length; element++){
//            int j=0;
//            while(j<ar.length && element!=ar[j]) j++;
//            if(j==ar.length) result.add(element);
//        }

        //Approach2: Use a helper array to find which numbers are missing.
        //T.C O(n) S.C O(n)
//        int[] helperAr=new int[ar.length+1];//ar.length+1 is used because we want elements from 1 to size of array
//        for(int i=0; i<ar.length; i++){
//            helperAr[ar[i]]++;
//        }
//
//        //now helperAr is ready, we just left with iteration in this array to find the missing elements in the given array
//        for(int i=1; i<helperAr.length; i++){//index started from 0 as we want elements from 1 to size of array
//            if(helperAr[i]==0) result.add(i);
//        }

        //Approach3: Playing with indices and elements.
        //T.C O(n) S.C O(1)
        int n=ar.length;//for convenience

        //now iterating over each element and modifying the elements
        for(int i=0; i<n; i++){
            int element=--ar[i];//Making the elements in range of [0, n-1] in single loop itself.
            if(element<n) ar[element] += n;
            else {
                element %= n;
                ar[element] += n;
            }
        }

        //collect all those elements which are less than n, which are nothing but missing elements.
        for(int i=0; i<n; i++){
            if(ar[i] < n) result.add(i+1);//i+1 because in the first loop we've decreased the magnitude by 1.
        }

        return result;
    }
    public static void main(String[] args) {
        int[] ar={4,3,2,7,8,2,3,1};
//        int[] ar={1,1};
        List<Integer> findNumbers=findDisappearedNumbers(ar);
        System.out.println("Numbers that disappeared: "+findNumbers);
    }
}
