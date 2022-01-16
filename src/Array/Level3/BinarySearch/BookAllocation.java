package Array.Level3.BinarySearch;

public class BookAllocation {
    private static int minOfMaxPages(int[] ar, int students){
        if(students>ar.length) return -1;//allocation is not possible
        int low=ar[0], high=0;

        for(int ele: ar) {
            high += ele;
            low = Math.min(low, ele);
        }

        int result=-1;
        while(low<=high){
            int barrier=low+(high-low)/2;//mid is barrier

            if(isPossible(ar, barrier, students)){
                System.out.println("result: "+result);
                result=barrier;
                high=barrier-1;
            }
            else{
                low=barrier+1;
            }
        }

        return result;
    }
    private static boolean isPossible(int[] ar, int barrier, int students){
        int studentsCount=1, pagesAllocated=0;
        for(int i=0; i<ar.length; i++){
            if(ar[i]>barrier) return false;
            if(pagesAllocated+ar[i]<barrier){
                pagesAllocated += ar[i];
            }
            else{
                studentsCount++;
                pagesAllocated=ar[i];
            }
        }
        if(studentsCount>students) return false;
        return true;
    }
    public static void main(String[] args) {
        int[] ar={12,34,67,90};
        int students=2;
        System.out.println(minOfMaxPages(ar, students));
    }
}
