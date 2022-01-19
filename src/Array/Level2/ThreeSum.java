package Array.Level2;

import java.util.*;

public class ThreeSum {
    private static List<List<Integer>> threeSum(int[] ar){
        List<Integer> list=null;
        Set<List<Integer>> set=new HashSet<>();

        //Approach1: 3 loops
        //T.C O(n3logm) S.C O(n)
        // for(int i=0; i<ar.length; i++){
        //     for(int j=i+1; j<ar.length; j++){
        //         for(int k=j+1; k<ar.length; k++){
        //             if(ar[i]+ar[j]+ar[k]==0) {
        //                 list=new ArrayList<>();
        //                 list.add(ar[i]);
        //                 list.add(ar[j]);
        //                 list.add(ar[k]);
        //                 Collections.sort(list);
        //             }
        //             set.add(list);
        //         }
        //     }
        // }
        // if(set.contains(null)) set.remove(null);

        //Approach2: Use map to store the third element and use two loops to find the first two elements
        //T.C (n2logm) S.C O(n)+O(m )
//        Map<Integer, Integer> map=new HashMap<>();
//        for(int ele: ar) map.put(ele, map.getOrDefault(ele, 0)+1);
//
//        for(int i=0; i<ar.length; i++){
//            map.put(ar[i], map.get(ar[i])-1);//because we've utilized it
//            for(int j=i+1; j<ar.length; j++){
//                map.put(ar[j], map.get(ar[j])-1);//because we've utilized the one occurrence
//
//                //check the condition
//                int thirdElement=-(ar[i]+ar[j]);
//                if(map.containsKey(thirdElement) && map.get(thirdElement)!=0) {
//                    list=new ArrayList<>();
//                    list.add(ar[i]);
//                    list.add(ar[j]);
//                    list.add(thirdElement);
//                    Collections.sort(list);
//                    System.out.println("Map: "+map);
//                    System.out.println("List: "+list+" ,first: "+i+" ,second: "+j);
//                }
//                System.out.println();
//
//                //inserting back the occurrence of element we've used.
//                map.put(ar[j], map.getOrDefault(ar[j], 0)+1);
//            }
//
//            //putting back the occurrence of element we've used before.
//            map.put(ar[i], map.getOrDefault(ar[i], 0)+1);
//
//            //storing the result in the set to avoid duplicates.
//            set.add(list);
//        }
//        if(set.contains(null)) set.remove(null);
//        List<List<Integer>> result=new ArrayList<>(set);


        //Approach3: Two Pointer
        //We'll use the logic a+b=-c, which is nothing but a two sum problem
        List<List<Integer>> result=new LinkedList<>();
        Arrays.sort(ar);
        for(int i=0; i<ar.length-2; i++){

            if(i==0 || (i>0 && ar[i]!=ar[i-1])){//to avoid duplicates
                int target=-ar[i];
                int low=i+1, high=ar.length-1;

                while(low<high){
                    int sum=ar[low]+ar[high];
                    if(sum<target) low++;
                    else if(sum>target) high--;
                    else{

                        result.add(Arrays.asList(ar[i], ar[low], ar[high]));
                        while(low<high && ar[low]==ar[low+1]) low++;
                        while(low<high && ar[high]==ar[high-1]) high--;

                        low++;
                        high--;
                    }
                }

            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] ar={-1,0,1,2,-1,-4,-2,-3,3,0,4};
        List<List<Integer>> triplets=threeSum(ar);
        System.out.println("Triplets with zero sum: "+triplets);
    }
}
