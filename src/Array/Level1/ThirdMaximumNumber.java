//Given an integer array nums, return the third distinct maximum number in this array. If the third maximum does not exist, return the maximum number.

package Array.Level1;

public class ThirdMaximumNumber {
    //T.C. O(n)
    private static int thirdMax(int[] ar){
        //using Integer class so that we can use null initially.
        Integer firstMax=null;
        Integer secondMax=null;
        Integer thirdMax=null;

        for(Integer ele: ar){

            if(ele.equals(firstMax) || ele.equals(secondMax) || ele.equals(thirdMax)) continue;

            if(firstMax==null || ele>firstMax){
                //if value of firstMax is getting updated, current value of firstMax will become secondMax and current value of secondMax will become thirdMax
                thirdMax=secondMax;
                secondMax=firstMax;
                firstMax=ele;
            }
            else if(secondMax==null || ele>secondMax){
                //same above reason
                thirdMax=secondMax;
                secondMax=ele;
            }
            else if(thirdMax==null || ele>thirdMax) thirdMax=ele;
        }

        //if there is no thirdMax in the array.
        if(thirdMax==null) return firstMax;

        return thirdMax;
    }


    public static void main(String[] args) {
//        int[] ar={2,4,5,6,7};
//        int[] ar={1,2};
//        int[] ar={-2147483648,1,1};//1
        int[] ar={1,2,-2147483648};//-2147483648
        int thirdMaximum=thirdMax(ar);
        System.out.println("Third maximum number: "+thirdMaximum);
    }
}