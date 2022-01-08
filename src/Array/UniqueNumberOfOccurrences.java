package Array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UniqueNumberOfOccurrences {
    private static boolean uniqueOccurrences(int[] ar){

        //Approach1: Use a frequency map
        //T.C O(n) S.C O(n)
        Map<Integer, Integer> map=new HashMap<>(ar.length);
        for(int ele: ar){
            map.put(ele, map.getOrDefault(ele, 0)+1);
        }

//        Set<Integer> set=new HashSet<>(map.size());
//        for(Integer ele: map.values()){
//            if(set.contains(ele)) return false;
//            else set.add(ele);
//        }
//        return true;

        //Better
        Set<Integer> set=new HashSet<>(map.values());
        return map.size()==set.size();
    }
    public static void main(String[] args) {
//        int[] ar={1,2,2,1,1,3};
//        int[] ar={1,2};
        int[] ar={-3,0,1,-3,1,1,1,-3,10,0};
        System.out.println(uniqueOccurrences(ar));
    }
}
