package Array.Level3.BinarySearch;

import java.util.Arrays;

public class MergeTwoSortedArrays {
    public static void merge(long ar1[], long ar2[], int n, int m)
    {

        //Approach1: Using extra space
        // long[] tempArr=new long[m+n];

        // int i=0, j=0, k=0;
        // while(i<n && j<m){
        //     if(ar1[i]<=ar2[j]) tempArr[k++]=ar1[i++];
        //     else tempArr[k++]=ar2[j++];
        // }
        // while(i<n){
        //     tempArr[k++]=ar1[i++];
        // }
        // while(j<m){
        //     tempArr[k++]=ar2[j++];
        // }
        // // System.out.println(Arrays.toString(tempArr));
        // //now tempArr is ready, just copy the elements from this array to the given arrays
        // for(i=0; i<n; i++){
        //     ar1[i]=tempArr[i];
        // }
        //         // System.out.println(Arrays.toString(ar1));

        // int x=n;
        // for(i=0; i<m; i++){
        //     ar2[i]=tempArr[x++];
        // }

        //Approach2: Without extra space
        //T.C O(m*n)
        int i=0;
        while(i<n){
            if(ar1[i]<=ar2[0]) i++;
            else{
                long temp=ar1[i];
                ar1[i]=ar2[0];
                ar2[0]=temp;

                long item=ar2[0];

                int j;
                for(j=1; j<m && ar2[j]<item; j++){
                    ar2[j-1]=ar2[j];
                }
                ar2[j-1]=item;
            }

        }
        System.out.println(Arrays.toString(ar1));
        System.out.println(Arrays.toString(ar2));
    }
    public static void main(String[] args) {
        long[] ar1={1,3,5,7};
        long[] ar2={0,2,6,8,9};
        int n=ar1.length;
        int m=ar2.length;
        merge(ar1, ar2, n, m);
    }
}
