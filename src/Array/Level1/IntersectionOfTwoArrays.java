package Array.Level1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoArrays {
    private static int[] intersection(int[] ar1, int[] ar2){

        //Approach1: Use two for loops.
        //T.C O(n2) S.C O(n)
//        int counter=0;
//        Set<Integer> set=new HashSet<>();
//        for(int i=0; i<ar1.length; i++){
//            for(int j=0; j<ar2.length; j++){
//                if(ar1[i]==ar2[j]) set.add(ar1[i]);
//            }
//        }
//        int[] intersectionElements=new int[set.size()];
//        for(int ele: set) intersectionElements[counter++]=ele;

        //Approach2: Optimized above approach
        //T.C O(n) S.C O(n)
        Set<Integer> set=new HashSet<>();
        Set<Integer> set2=new HashSet<>();//used to put elements in the resultant array

        for(int ele: ar1) set.add(ele);

        int count=0;
        for(int ele: ar2){
            if(set.contains(ele)){
                count++;
                set2.add(ele);
                set.remove(ele);//removed because we don't want duplicate occurrence of elements
            }
        }
        int[] intersectionElements=new int[count];
        int counter2=0;
        for(int ele: set2) intersectionElements[counter2++]=ele;
        return intersectionElements;
    }
    public static void main(String[] args) {
        int[] ar1={1,2,2,1};
//        int[] ar1={4,9,5};
        int[] ar2={2,2};
//        int[] ar2={9,4,9,8,4};
        int[] intersectionElements=intersection(ar1, ar2);
        System.out.println("Intersection Point is: "+ Arrays.toString(intersectionElements));
    }
}
