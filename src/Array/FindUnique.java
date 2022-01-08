//Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.

package Array;

import java.util.HashMap;
import java.util.Map;

public class FindUnique {
    private static boolean checkMultipleOccurrence(int[] ar, int index, int uniqueElement){
        for(int i=0; i<ar.length; i++){
            if(i==index) continue;
            if(ar[i]==uniqueElement) return true;
        }
        return false;
    }
    private static int findUnique(int[] ar){
        int uniqueElement=0;

        // Approach1: Separately check for each and every element if it occurs once or multiple times.
        //T.C O(n2) S.C O(1)
//        for(int i=0; i<ar.length; i++){
//            uniqueElement=ar[i];
//            if(!checkMultipleOccurrence(ar, i, uniqueElement)) break;
//        }

        //Approach2: Use map to find occurrence of all elements and return the element which occurred only once.
        //T.C O(n) S.C O(n)
        // Map<Integer, Integer> map=new HashMap<>(ar.length);
        // for(Integer ele: ar){
        //     map.put(ele, map.getOrDefault(ele, 0)+1);
        // }
        // for(Map.Entry<Integer, Integer> entry: map.entrySet()){
        //     if(entry.getValue() == 1) uniqueElement=entry.getKey();
        // }

        //Approach3: XOR operation. Since xor of two same elements is zero.
        //T.C O(n) S.C O(1)
        for(int ele: ar) uniqueElement ^= ele;
        return uniqueElement;
    }
    public static void main(String[] args) {
        int[] ar={2,2,1};
        int uniqueElement=findUnique(ar);
        System.out.println(uniqueElement);

    }
}
