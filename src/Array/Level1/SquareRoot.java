//Given a non-negative integer x, compute and return the square root of x.
//Since the return type is an integer, the decimal digits are truncated, and only the integer part of the result is returned.

package Array.Level1;

public class SquareRoot {
    private static int mySqrt(int number){

        //Approach1: Using built-in function
        // return (int)Math.sqrt(x);

        //Approach2: Binary search
        long low=0, high=number;

        long nearestSquare=-1;
        while(low<=high){
            long mid=low+(high-low)/2;

            long square=mid*mid;
            if(square<number) {
                low=mid+1;
                nearestSquare=mid;
            }
            else if(square>number) high=mid-1;
            else return (int)mid;
        }
        return (int)nearestSquare;
    }
    public static void main(String[] args) {
        int number=4;
        System.out.println("Square root of "+number+": "+mySqrt(number));
    }
}
