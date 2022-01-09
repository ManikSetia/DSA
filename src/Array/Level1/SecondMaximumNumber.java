package Array.Level1;

public class SecondMaximumNumber {

    public static int print2largest(int ar[],int n)
    {
        //Approach1: sorting
        //T.C O(nlogn)
//    if(n<2) return -1;
//    Arrays.sort(ar);
//
//    for(int i=n-2; i>=0; i--){
//        if(ar[i]!=ar[i-1]) return ar[i];
//    }
//    return -1;

        //Approach2: Use two for loops to find first and second maximum respectively.
        //T.C O(n)
//    int firstMax=Integer.MIN_VALUE;
//    int secondMax=Integer.MIN_VALUE;
//
//    //first loop to find first max
//    for(int i=0; i<n; i++){
//        firstMax=Math.max(firstMax, ar[i]);
//    }
//
//    //second loop to find second max
//    for(int i=0; i<n; i++){
//        if(ar[i]!=firstMax) secondMax=Math.max(secondMax, ar[i]);
//    }
//    return secondMax;

        //Approach3: Use single for loop to find second max element
        //Efficient Approach, T.C O(n)
        int firstMax=Integer.MIN_VALUE;
        int secondMax=Integer.MIN_VALUE;

        for(int i=0; i<n; i++){
            if(ar[i]>firstMax){
                secondMax=firstMax;
                firstMax=ar[i];
            }
            else if(ar[i] > secondMax) secondMax=ar[i];
        }
        return secondMax;
    }

    public static void main(String[] args) {
        int[] ar={2,4,5,6,7};
        int secondMax=print2largest(ar, ar.length);
        System.out.println(secondMax);
    }
}
