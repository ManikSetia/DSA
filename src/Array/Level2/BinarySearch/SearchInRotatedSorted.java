package Array.Level2.BinarySearch;

public class SearchInRotatedSorted {
    private static int search(int[] ar, int target){

        //Approach1: Linear search
        for(int i=0; i<ar.length; i++){
            if(ar[i]==target) return i;
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] ar={4,5,6,7,0,1,2};
        int target=0;
        System.out.println(target+" is at index: "+search(ar, target));
    }
}
