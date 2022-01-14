package Array.Level1.BinarySearch;

public class IntroCode {
    private static int binarySearch(int[] ar, int target){
        if(ar==null) return -1;

        int low=0, high=ar.length-1;

        while(low<=high){
            // int mid=(low+high)/2;
            int mid=low+(high-low)/2;//optimized
            if(ar[mid]<target) low=mid+1;
            else if(ar[mid]>target) high=mid-1;
            else return mid;
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] ar={-1,0,3,5,9,12};
        int target=9;
        System.out.println("Index of "+target+" is: "+binarySearch(ar, target));
    }
}
