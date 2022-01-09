//ip = {1,2,3,4,5,6}
//op = {2,1,4,3,6,5}

package Array.Level1;

import java.util.Arrays;

public class SwapAlternate {
    private static void swap(int[] ar, int i, int j){
        int temp=ar[i];
        ar[i]=ar[j];
        ar[j]=temp;
    }
    private static void swapAlternateElements(int[] ar){
//        if((ar.length & 1) == 1){
//            for(int i=0; i<ar.length-1; i=i+2){
//                swap(ar, i, i+1);
//            }
//        }
//        else{
//            for(int i=0; i<ar.length; i=i+2){
//                swap(ar, i, i+1);
//            }
//        }

        //Better
        for(int i=0; i<ar.length; i=i+2){
            if(i+1 < ar.length) swap(ar, i, i+1);
        }
    }
    public static void main(String[] args) {
        int[] ar={1,2,3,4,5,6};
        System.out.println("Before swapping: "+Arrays.toString(ar));
        swapAlternateElements(ar);
        System.out.println("After swapping: "+Arrays.toString(ar));
    }
}
