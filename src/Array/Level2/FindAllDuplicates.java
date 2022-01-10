//Given an integer array nums of length n where all the integers of nums are in the range [1, n] and each integer appears once or twice, return an array of all the integers that appears twice.

package Array.Level2;

import java.util.*;

public class FindAllDuplicates {
    private static List<Integer> findDuplicates(int[] ar){
        List<Integer> duplicates=new ArrayList<>();

        //Approach1: Sorting.
        //T.C. O(nlogn) S.C O(1)
//        Arrays.sort(ar);
//        for(int i=0; i<ar.length-1; i++){
//            if(ar[i]==ar[i+1]) duplicates.add(ar[i]);
//        }

        //Approach2: HashMap to count the occurrence of each element.
        //T.C O(n) S.C O(n)
        Map<Integer, Integer> map=new HashMap<>();
        for(int ele: ar){
            map.put(ele, map.getOrDefault(ele, 0)+1);
        }

        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            if(entry.getValue()==2) duplicates.add(entry.getKey());
        }
        return duplicates;
    }
    public static void main(String[] args) {
//        int[] ar={4,3,2,7,8,2,3,1};
        int[] ar={1,1,2};
//        int[] ar={1};
        List<Integer> duplicateElements=findDuplicates(ar);
        System.out.println("List of duplicate elements: "+duplicateElements);
    }
}
