package Array.Level2.BinarySearch;

public class SearchInRotatedSorted {
    private static int search(int[] ar, int target){

        //Approach1: Linear search
//        for(int i=0; i<ar.length; i++){
//            if(ar[i]==target) return i;
//        }

        //Approach2: Binary search
        // if(ar.length==1 && ar[0]==target) return 0;
        int low=0, high=ar.length-1;

        while(low<=high){
            int mid=low+(high-low)/2;

            if(ar[mid]==target) return mid;

            //Step1: check mid is on left or right half
            if(ar[mid]<ar[low]){
                //we're on right half
                //now check our target value exists in this half or not
                if(target>=ar[mid] && target<=ar[high]){
                    low=mid+1;
                }
                else{
                    high=mid-1;
                }
            }
            else {
                //we're on left half
                //now check our target value exists in this half or not
                if(target>=ar[low] && target<=ar[mid]){
                    high=mid-1;
                }
                else{
                    low=mid+1;
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] ar={4,5,6,7,0,1,2};
        int target=0;
        System.out.println(target+" is at index: "+search(ar, target));
    }
}
